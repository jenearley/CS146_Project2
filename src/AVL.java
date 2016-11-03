/**
 * Created by Jennifer Earley on 2/15/2016.
 */
public class AVL extends BinarySearchTree{
    public static BinaryNode root;
    public int size;
    public int height;

    public AVL(){
        root = null;
        size = 0;
        height = 0;
    }

    public void insert(int v){
        if(root == null){
            root = new BinaryNode(v, null, null);
        } else {
            root.bstAdd(v);
        }
        if(root.value != v){
            if(!isBalanced(root)){
                rebalance(root);
            }
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
                        BinaryNode tempRoot = new BinaryNode(root.left.getData(), null, null);
                        tempRoot.setLeft(root.getLeft());
                        tempRoot.setRight(root.getRight());
                        root = tempRoot;
                        root.left.bstDelete(root.getData(), root);
                    } else if(root.left == null && root.right != null) {
                        BinaryNode tempRoot = new BinaryNode(root.right.getData(), null, null);
                        tempRoot.setLeft(root.getLeft());
                        tempRoot.setRight(root.getRight());
                        root = tempRoot;
                        root.right.bstDelete(root.getData(), root);
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
        if(root != null){
            if(!isBalanced(root)){
                rebalance(root);
            }
        }

        height = calcHeight(root);
        size = calcSize(root);
    }

    public void rebalance(BinaryNode b) {
        if(whichSide(b).equals("right")){
            if(calcHeight(b.right.left) > calcHeight(b.right.right)){
                System.out.println("Double left-right rotation: " + b.getData());
                doubleLeftR(b);
            } else if(calcHeight(b.right.left) < calcHeight(b.right.right)){
                System.out.println("Single left rotation: " + b.getData());
                leftRotate(b);
            }
        } else if(whichSide(b).equals("left")){
            if(calcHeight(b.left.left) < calcHeight(b.left.right)){
                System.out.println("Double right-left rotation: " + b.getData());
                doubleRightR(b);
            } else if(calcHeight(b.left.left) > calcHeight(b.left.right)){
                System.out.println("Single right rotation: " + b.getData());
                rightRotate(b);
            }
        }
    }

    public String whichSide(BinaryNode b){
        int check = calcHeight(b.left) - calcHeight(b.right);
        if(check > 1){
            return "left";
        } else {
            return "right";
        }
    }

    public boolean isBalanced(BinaryNode b){
        int check = calcHeight(b.left) - calcHeight(b.right);
        if(check > 1 || check < -1) {
            return false;
        } else {
            return true;
        }
    }
    /* left child rotates up to where c is
    */
    public void rightRotate(BinaryNode c){
        BinaryNode r = c.left;
        c.left = r.right;
        r.right = c;
        root = r;
    }
    /* right child rotates up to where c is
    */
    public void leftRotate(BinaryNode c){
        BinaryNode r = c.right;
        c.right = r.left;
        r.left = c;
        root = r;
    }

    public void doubleLeftR(BinaryNode c){
        rightRotate(c.right);
        leftRotate(c);
    }

    public void doubleRightR(BinaryNode c){
        leftRotate(c.left);
        rightRotate(c);
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
