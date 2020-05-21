package tree;

import exceptions.ListOutOfIndex;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    interfaces.BinarySearchTree<Integer,Integer> myTree;

    @BeforeEach
    void setUp(){
        myTree = new tree.BinarySearchTree<>();
    }


    @Test
    void insert() {


        myTree.insert(7,7);
        myTree.insert(2,2);
        myTree.insert(4,4);
        myTree.insert(6,6);
        myTree.insert(11,11);
        myTree.insert(9,9);
        myTree.insert(13,13);
        myTree.insert(3,3);
        myTree.insert(1,1);

        assertTrue(myTree.contains(4));
        assertFalse(myTree.contains(21));



    }

    @Test
    void counting(){
        myTree.insert(7,7);
        myTree.insert(2,2);
        myTree.insert(4,4);
        myTree.insert(6,6);
        myTree.insert(11,11);
        myTree.insert(9,9);
        myTree.insert(13,13);
        myTree.insert(3,3);
        myTree.insert(1,1);


        assertEquals(9, myTree.size() );
        assertEquals(5, myTree.countLeaf());
        assertEquals(4, myTree.countCompleteElement());
    }

    @Test
    void recorridas(){
        myTree.insert(7,7);
        myTree.insert(2,2);
        myTree.insert(4,4);
        myTree.insert(6,6);
        myTree.insert(11,11);
        myTree.insert(9,9);
        myTree.insert(13,13);
        myTree.insert(3,3);
        myTree.insert(1,1);



        myTree.inOrder().visualize(" ");
        myTree.preOrder().visualize(" ");
        myTree.postOrder().visualize(" ");
        myTree.nivelRecursivo().visualize(" ");
        myTree.nivel().visualize(" ");



        try {
            assertEquals(1,myTree.inOrder().get(0) );
            assertEquals(2,myTree.preOrder().get(1) );
            assertEquals(6,myTree.postOrder().get(2) );
            assertEquals(11,myTree.nivel().get(2) );
        } catch (ListOutOfIndex error) {
            fail();
            error.printStackTrace();
        }
    }

    @Test
    void delete() {
        myTree.insert(7, 7);
        myTree.insert(2, 2);
        myTree.insert(4, 4);
        myTree.insert(6, 6);
        myTree.insert(11, 11);
        myTree.insert(9, 9);
        myTree.insert(13, 13);
        myTree.insert(3, 3);
        myTree.insert(1, 1);

        myTree.nivel().visualize(" ");

        System.out.println(myTree);

        myTree.delete(2);
        System.out.println(myTree);
        try {
            assertEquals(1, myTree.preOrder().get(1));
        } catch (ListOutOfIndex error) {
            fail();
            error.printStackTrace();
        }

        myTree.delete(7);
        System.out.println(myTree);

        myTree.delete(6);
        System.out.println(myTree);

        System.out.print(myTree.nivel().visualize(" "));
    }
}