/**
 * Created by Jennifer Earley on 2/15/2016.
 */
public class BinarySearchTree<Integer>{
    public static BinaryNode root;
    public int size;
    public int height;

    public BinarySearchTree(){
        size = 0;
        height = 0;
        root = null;
    }

    public void insert(int v){
        if(root == null){
            root = new BinaryNode(v, null, null);
        } else {
            root.bstAdd(v);
        }
        size = calcSize(root);
        height = calcHeight(root);
    }

    public void delete(int v){
        if(root == null){
            throw new NullPointerException();
        } else {
            if(root.value == v){
                if(root.left == null && root.right == null){
                    root = null;
                } else {
                    if(root.right == null && root.left != null){
                        root = root.left;
                    } else if(root.left == null && root.right != null) {
                        root = root.right;
                    } else {
                        BinaryNode tempRoot = new BinaryNode(root.left.getData(), null, null);
                        tempRoot.setLeft(root.getLeft());
                        tempRoot.setRight(root.getRight());
                        root = tempRoot;
                        root.left.bstDelete(root.getData(), root);
                    }
                }
            } else {
                root.bstDelete(v, null);
            }
        }
        size = calcSize(root);
        height = calcHeight(root);
    }

    public int calcHeight(BinaryNode b){
        if(b == null){
            return -1;
        } else {
            return Math.max(calcHeight(b.left), calcHeight(b.right)) + 1;
        }
    }

    public int calcSize(BinaryNode b){
        if(b == null){
            return 0;
        } else {
            return calcSize(b.left) + calcSize(b.right) + 1;
        }
    }

    public int getSize(){
        return size;
    }

    public int getHeight(){
        return height;
    }

    public BinaryNode getRoot(){
        return root;
    }

    public int find(int f, BinaryNode r){
        if(r == null){
            return 0;
        } else if(f == r.getData()){
            return 1;
        } else {
            return find(f, r.right) + find(f, r.left);
        }
    }

}
