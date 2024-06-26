package main;

import main.Materia.Controllers.AVLTree;
import main.Materia.Controllers.ArbolBinario;

import main.Materia.Models.Node;

public class App {
    public static void main(String[] args) throws Exception {
        ArbolBinario arbolbinario= new ArbolBinario();
        Node nodeRoot = new Node(1);
        nodeRoot.setLeft(new Node (2));
        nodeRoot.setRight(new Node(3));

        nodeRoot.getLeft().setLeft(new Node (4));
        nodeRoot.getLeft().setRight(new Node (5));
        
        nodeRoot.getRight().setRight(new Node(6));
    
        nodeRoot.getLeft().getLeft().setLeft(new Node(7));
        nodeRoot.getLeft().getRight().setLeft(new Node(8));

        arbolbinario.preOrdenLoop(nodeRoot);
        System.out.println("\n-----recusividad---");
        arbolbinario.preOrdenLoopRecursivo(nodeRoot);
        //postOrden
        System.out.print("\n postOreden");
        System.out.println("");
        arbolbinario.postOrdenLoop(nodeRoot);

        System.out.print("\n postOredenRecursivo");
        System.out.println("");
        arbolbinario.postOrdenRecursividad(nodeRoot);

        //inOrden
        System.out.print("\n inOrden");
        System.out.println("");
        arbolbinario.inOrdenRecursividad(nodeRoot);



        AVLTree tree = new AVLTree();

        int[] values = { 10, 20, 15, 24, 9, 8, 21, 23, 50, 25 };

        for (int value : values) {
            tree.insert(value);
        }

        tree.printTree();
    }
}
