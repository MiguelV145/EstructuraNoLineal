package main.Materia.Controllers;

import java.util.Stack;
import main.Materia.Models.Node;

public class ArbolBinario {

    public void preOrdenLoop(Node root){
        if(root==null){
            return;
        }
        Stack<Node> stack=  new Stack<>();
        //Agregamos a la pila la raiz para empezar el recorrido
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            
            System.out.print(node.getValue()+" - ");
            //Agrega los hijos de la derecha a la pila
            if (node.getRight() != null){
                stack.push(node.getRight());
            }
            //Agregar los hijos de la izquierda a la pila

            if(node.getLeft()!= null){
                stack.push(node.getLeft());
            }
        }
    }


    public void preOrdenLoopRecursivo(Node node){
        if (node != null){
            System.out.print(node.getValue()+" - ");
            preOrdenLoop(node.getLeft());
            preOrdenLoop(node.getRight());
        }
    }
    public void postOrdenLoop(Node root){
        if (root == null){
            return;
        }

        Stack<Node> stack1= new Stack<>();
        Stack<Node> stack2= new Stack<>();
        stack1.push(root);

        while (!stack1.isEmpty()){
            Node node= stack1.pop();
            stack2.push(node);

            if (node.getLeft()!=null){
                stack1.push(node.getLeft());
            }
            if(node.getRight()!= null){
                stack1.push(node.getRight());
            }
        }

        while (!stack2.isEmpty()){
            Node node= stack2.pop();
            System.out.print(node.getValue()+"  ");
            
        }
    }
    
    public void postOrdenRecursividad(Node node){
        if(node != null){
            postOrdenLoop(node.getLeft());
            postOrdenLoop(node.getRight());
            System.out.print(node.getValue()+" ");
        }
    
    }

    public void inOrdenRecursividad(Node node){
        if(node!= null){
            inOrdenRecursividad(node.getLeft());
            System.out.print(node.getValue()+" ");
            inOrdenRecursividad(node.getRight());
        }
    }



}