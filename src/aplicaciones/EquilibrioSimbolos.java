package aplicaciones;

import exceptions.EmptyStack;
import interfaces.Stack;
import linkedlist.LinkedList;

public class EquilibrioSimbolos {

    public static void EquilibrioSimbolos (String str) throws EmptyStack {


        Stack stack = new LinkedList();

        boolean error = false;


        int largo = str.length();


        for (int i = 0; i < largo; i++) {

            char caracter = str.charAt(i);

            if (caracter == '{' || caracter == '[' || caracter == '(') {
                stack.push(caracter);
            } else if (caracter == '}' || caracter == ']' || caracter == ')' ){
                if (stack.isEmpty()){
                    error = true;
                    break;
                }
                if (caracter == '}') {
                    if ((char) stack.top() == '{') {
                        stack.pop();
                    } else {
                        error = true;
                        break;
                    }
                } else if (caracter == ']') {
                    if ((char) stack.top() == '[') {
                        stack.pop();
                    } else {
                        error = true;
                        break;
                    }
                } else if (caracter == ')') {
                    if ((char) stack.top() == '(') {
                        stack.pop();
                    } else {
                        error = true;
                        break;
                    }
                }
            }


        }

        if (!stack.isEmpty()){
            error = true;
        }

        if (!error){
            System.out.println("El string esta balanceado");
        } else {
            System.out.println("El string no esta balanceado");
        }
    }
}
