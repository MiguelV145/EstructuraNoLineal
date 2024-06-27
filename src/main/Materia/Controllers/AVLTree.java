package main.Materia.Controllers;

import main.Materia.Models.Node;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTree {
    private Node root;

    // Obtener la altura de un node
    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.getHeight();
    }

    // Metodo que obtenga el factor de equlibrio de un nodo
    private int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.getLeft()) - height(node.getRight());
    }

    public Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        if (value > node.getValue()) {
            node.setRight(insert(node.getRight(), value));
        } else if (value < node.getValue()) {
            node.setLeft(insert(node.getLeft(), value));
        } else {
            return node;
        }

        // Actualizar la altura del predecesor o ancestro
        node.setHeight(1 + Math.max(height(node.getLeft()), height(node.getRight())));

        // Calcular el balance
        int balance = getBalance(node);

        /// Si el nodo esta desbalanceado se tiene 3 casos

        /// Caso Izquierda - Izquierda
        if (balance > 1 && value < node.getLeft().getValue()) {
            return rightRotate(node);
        }

        /// Caso Derecha - Derecha
        if (balance < -1 && value > node.getRight().getValue()) {
            return leftRotate(node);
        }

        /// Caso Izquierda - Derecha
        if (balance > 1 && value > node.getLeft().getValue()) {
            node.setLeft(leftRotate(node.getLeft()));
            return rightRotate(node);
        }

        /// Caso Derecha - Izquierda
        if (balance < -1 && value < node.getRight().getValue()) {
            node.setRight(rightRotate(node.getRight()));
            return leftRotate(node);
        }

        /// devolver el nodo sin cambioos o rataciones
        return node;
    }

    private Node rightRotate(Node nodeR) {
        System.out.println("Rotaciones a la izquierda: " + nodeR.getValue() + " Balance =  " + getBalance(nodeR));
        Node x = nodeR.getLeft();
        System.out.println("nueva raíz después de girar a la derecha: " +  x.getValue());
        Node temp = x.getRight();

        // realizar la rotacion
        x.setRight(nodeR);
        nodeR.setLeft(temp);

        // actualizando las alturas
        nodeR.setHeight(Math.max(height(nodeR.getLeft()), height(nodeR.getRight())) + 1);
        x.setHeight(Math.max(height(x.getLeft()), height(x.getRight())) + 1);

        /// devolver nueva raiz
        return x;
    }

    private Node leftRotate(Node nodeR) {
        System.out.println("Rotaciones a la derecha: " + nodeR.getValue() + " Balance =  " + getBalance(nodeR));
        Node y = nodeR.getRight();
        System.out.println("nueva raíz después de girar a la izquierda:  " + y.getValue());
        Node temp = y.getLeft();

        // Realizar la rotacion
        y.setLeft(nodeR);
        nodeR.setRight(temp);
        // actualizando las alturas
        nodeR.setHeight(Math.max(height(nodeR.getLeft()), height(nodeR.getRight())) + 1);
        y.setHeight(Math.max(height(y.getLeft()), height(y.getRight())) + 1);

        return y;
    }

    public void insert(int value) {
        System.out.println("Nodo a insertar sera el " + value);
        root = insert(root, value);
        printTree();
        System.out.println("\n-------\n");
    }

    public void printTree() {
        printTreeNode(root, "", true);
    }

    public void printTreeNode(Node root, String prefix, boolean isLeft) {

        if (root != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + root.getValue());
            if (root.getLeft() != null || root.getRight() != null) {
                if (root.getLeft() != null) {
                    printTreeNode(root.getLeft(), prefix + (isLeft ? "│   " : "    "), true);
                } else {
                    System.out.println(prefix + (isLeft ? "│   " : "    ") + "├── null");
                }
                if (root.getRight() != null) {
                    printTreeNode(root.getRight(), prefix + (isLeft ? "│   " : "    "), false);
                } else {
                    System.out.println(prefix + (isLeft ? "│   " : "    ") + "└── null");
                }
            }
        }
    }
}