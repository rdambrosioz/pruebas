package stack;

import interfaces.Stack;
import linkedlist.LinkedList;
import linkedlist.LinkedListIterator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    private Stack<Integer> myStack;

    @BeforeEach
    void setUp(){
        myStack = new LinkedList<>();
    }

    @Test
    void testIterator() {

        myStack.push(5);
        myStack.push(4);
        myStack.push(9);
        myStack.push(37);

        Iterator<Integer> myStackIterator = myStack.iterator();

        while(myStackIterator.hasNext()){
            Integer value = myStackIterator.next();
            System.out.println(value);
        }


    }

    @Test
    void testForEach(){
        myStack.push(5);
        myStack.push(4);
        myStack.push(9);
        myStack.push(37);

        for (Integer temp : myStack){
            System.out.println(temp);
        }


    }
}