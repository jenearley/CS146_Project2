import java.util.ArrayList;

/**
 * Created by jen0e on 3/1/2016.
 */
public class Compare {
    public static void main(String[] args){
        BinarySearchTree bst = new BinarySearchTree();
        AVL avl = new AVL();
        int[] thing = new int[1000];
        int min = 10;
        int max = 99;
        int range = (max - min) + 1;

        for(int i = 1; i < 1000; i++){
            thing[i] = (int) (Math.random() * range) + min;
        }

        final long startTime1 = System.currentTimeMillis();
        for(int i = 1; i < 1000; i++){
            bst.insert(thing[i]);
        }
        final long endTime1 = System.currentTimeMillis();

        final long startTime3 = System.currentTimeMillis();
        for(int i = 1; i < 1000; i++){
            bst.find(thing[i], bst.getRoot());
        }
        final long endTime3 = System.currentTimeMillis();

        final long startTime5 = System.currentTimeMillis();
        for(int i = 11; i < 23; i++){
            bst.insert(thing[i]);
        }
        for(int i = 1; i < 190; i++){
            bst.find(thing[i], bst.getRoot());
        }
        for(int i = 11; i < 343; i++){
            bst.insert(thing[i]);
        }
        for(int i = 1; i < 331; i++){
            bst.find(thing[i], bst.getRoot());
        }
        for(int i = 11; i < 223; i++){
            bst.insert(thing[i]);
        }
        for(int i = 1; i < 101; i++){
            bst.find(thing[i], bst.getRoot());
        }
        for(int i = 11; i < 57; i++){
            bst.insert(thing[i]);
        }
        for(int i = 1; i < 10; i++){
            bst.find(thing[i], bst.getRoot());
        }
        final long endTime5 = System.currentTimeMillis();

        System.out.println("BST");
        System.out.println("Number of nodes: " + bst.getSize());
        System.out.println("Height: " + bst.getHeight());
        System.out.println("Total execution time n: " + (endTime1 - startTime1) + " milliseconds" );
        System.out.println("Total execution time k: " + (endTime3 - startTime3) + " milliseconds" );
        System.out.println("Total execution time m: " + (endTime5 - startTime5) + " milliseconds" );

        System.out.println("");

        final long startTime2 = System.currentTimeMillis();
        for(int i = 1; i < 1000; i++){
            avl.insert(thing[i]);
        }
        final long endTime2 = System.currentTimeMillis();

        final long startTime4 = System.currentTimeMillis();
        for(int i = 1; i < 1000; i++){
            avl.find(thing[i], avl.getRoot());
        }
        final long endTime4 = System.currentTimeMillis();

        final long startTime6 = System.currentTimeMillis();
        for(int i = 11; i < 23; i++){
            avl.insert(thing[i]);
        }
        for(int i = 1; i < 190; i++){
            avl.find(thing[i], bst.getRoot());
        }
        for(int i = 11; i < 343; i++){
            avl.insert(thing[i]);
        }
        for(int i = 1; i < 331; i++){
            avl.find(thing[i], bst.getRoot());
        }
        for(int i = 11; i < 223; i++){
            avl.insert(thing[i]);
        }
        for(int i = 1; i < 101; i++){
            avl.find(thing[i], bst.getRoot());
        }
        for(int i = 11; i < 57; i++){
            avl.insert(thing[i]);
        }
        for(int i = 1; i < 10; i++){
            avl.find(thing[i], bst.getRoot());
        }
        final long endTime6 = System.currentTimeMillis();
        System.out.println("AVL");
        System.out.println("Number of nodes: " + avl.getSize());
        System.out.println("Height: " + avl.getHeight());
        System.out.println("Total execution time n: " + (endTime2 - startTime2) + " milliseconds" );
        System.out.println("Total execution time k: " + (endTime4 - startTime4) + " milliseconds" );
        System.out.println("Total execution time m: " + (endTime6 - startTime6) + " milliseconds" );


    }
}

