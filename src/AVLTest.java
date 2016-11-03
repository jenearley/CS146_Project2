import sun.reflect.generics.tree.Tree;

/**
 * Created by Jennifer Earley on 2/20/2016.
 */
public class AVLTest {
    public static void main(String[] args){
        AVL tree = new AVL();
        int min = 10;
        int max = 99;
        int range = (max - min) + 1;
        int[] a = new int[35];

        for(int i = 0; i < 35; i++){
            a[i] = (int) (Math.random() * range) + min;
        }

        for(int i = 0; i < tree.getSize(); i++){
            tree.insert(a[i]);
        }

        for(int i = 1; i < tree.getSize(); i++){
            tree.delete(tree.getRoot().getData());
        }


        System.out.println("Number of nodes: " + tree.getSize());
        System.out.println("Height: " + tree.getHeight());
        String label = "label";
        TreePrinter tp = new TreePrinter(tree);
        tp.print(label);


    }
}
