/**
 * Created by Jennifer Earley on 2/15/2016.
 */

public class BinaryNode<Integer>{
    public int value;
    public BinaryNode left;
    public BinaryNode right;
    public int updateNum;

    public BinaryNode(int v, BinaryNode l, BinaryNode r){
        value = v;
        left = l;
        right = r;
        updateNum = 0;
    }

    public void setLeft(BinaryNode n){
        left = n;
    }

    public void setRight(BinaryNode m){
        right = m;
    }

    public int getData(){
        return value;
    }

    public BinaryNode getLeft(){
        return left;
    }

    public BinaryNode getRight(){
        return right;
    }

    public void incrementUpdate(){
        updateNum++;
    }

    public void bstAdd(int v){
        if(v < this.value){
            if(this.left == null){
                this.left = new BinaryNode(v, null, null);
            } else {
                this.left.bstAdd(v);
            }
        } else if(v > this.value){
            if(this.right == null){
                this.right = new BinaryNode(v, null, null);
            } else {
                this.right.bstAdd(v);
            }
        } else if(v == this.value){
            this.incrementUpdate();
        }
    }

    public void bstDelete(int v, BinaryNode parent){
        if(this.value == v){
            if(this.left != null && this.right != null){
                this.value = this.right.min();
                this.right.bstDelete(this.value, this);
            } else if(parent.left == this){
                parent.left = (this.left != null) ? this.left : this.right;
            } else if(parent.right == this){
                parent.right = (this.right != null) ? this.left : this.right;
            }
        } else if(this.value > v){
            if(this.left != null){
                this.left.bstDelete(v, this);
            }
        } else if(this.value < v){
            if(this.right != null){
                this.right.bstDelete(v, this);
            }
        }
    }

    public int min(){
        if(this.left == null){
            return this.value;
        }
        else{
            return this.left.min();
        }
    }
}
