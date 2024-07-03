package main;

import main.Materia.Controllers.AVLTree;
import main.Materia.Controllers.ArbolBinario;
import main.Materia.Controllers.Graph;
import main.Materia.Models.Node;
import main.Materia.Models.NodeGraph;

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
    
        runGraph();
    }

    private static void runGraph() {
       Graph grafo = new Graph();

       //agregar node
       //NodeGraph node1 = new NodeGraph(1);
       //NodeGraph node2 = new NodeGraph(2);
       //NodeGraph node3 = new NodeGraph(3);
       //NodeGraph node4 = new NodeGraph(4);
       //NodeGraph node5 = new NodeGraph(5);
        

       NodeGraph node1 = grafo.addNode(1);
       NodeGraph node2 = grafo.addNode(2);
       NodeGraph node3 = grafo.addNode(3);
       NodeGraph node4 = grafo.addNode(4);
       NodeGraph node5 = grafo.addNode(5);
        
       grafo.addEdge(node1, node2);
       grafo.addEdge(node2, node4);
       grafo.addEdge(node4, node5);
       grafo.addEdge(node1, node3);
       
       //Imprime el graph
        grafo.printGraph();
        // Búsqueda en profundidad (DFS)
        System.out.println("Búsqueda en profundidad (DFS) desde el nodo 1:");
        grafo.getDFS(node4);

        // Búsqueda en anchura (BFS)
        System.out.println("Búsqueda en anchura (BFS) desde el nodo 1:");
        grafo.getBFS(node2);

        // Imprimir la matriz de adyacencia
        System.out.println("Matriz de adyacencia:");
        grafo.printAdjacencyMatrix();
    }
}
