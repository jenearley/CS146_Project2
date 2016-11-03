import sun.reflect.generics.tree.Tree;

/**
 * Created by Jennifer Earley on 2/20/2016.
 */
public class BSTTest {
    public static void main(String[] args){
        BinarySearchTree tree = new BinarySearchTree();
        int min = 10;
        int max = 99;
        int range = (max - min) + 1;

        for(int i = 1; i <= 1000; i++){
            tree.insert((int) (Math.random() * range) + min);
        }

        System.out.println("Number of nodes: " + tree.getSize());
        System.out.println("Height: " + tree.getHeight());
        String label = "label";
        //TreePrinter tp = new TreePrinter(tree);
        //tp.print(label);

        final long startTime = System.currentTimeMillis();
        long total = 0;
        for (int i = 0; i < 10000000; i++) {
            total += i;
        }
        final long endTime = System.currentTimeMillis();

        System.out.println("Total execution time: " + (endTime - startTime) + " milliseconds");


    }
}
