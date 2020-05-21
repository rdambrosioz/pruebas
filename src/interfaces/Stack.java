package interfaces;

import exceptions.EmptyStack;

import java.util.Iterator;

public interface Stack <Type> extends Iterable<Type> {

    Type pop () throws EmptyStack;

    Type top () throws EmptyStack;

    void push (Type element);

    boolean isEmpty();

    void makeEmpty();



}
