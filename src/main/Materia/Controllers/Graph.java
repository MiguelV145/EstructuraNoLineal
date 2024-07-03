package main.Materia.Controllers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import main.Materia.Models.NodeGraph;

public class Graph {
    private List<NodeGraph> nodes;

    public Graph() {
        this.nodes = new ArrayList<>();
    }

    // AGREGAMOS NODO
    public NodeGraph addNode(int value) {
        NodeGraph newNode = new NodeGraph(value);
        nodes.add(newNode);
        return newNode;
    }

    // METODO PARA AÑADIR UNA ARISTA
    public void addEdge(NodeGraph src, NodeGraph dest) {
        src.addNeighbor(dest);
        dest.addNeighbor(src); // para grafos no dirigidos
    }

    // Metodo para imprimir grafos
    public void printGraph() {
        for (NodeGraph node : nodes) {
            System.out.print("Vertex " + node.getValue() + " :");
            for (NodeGraph neighbor : node.getNeighbors()) {
                System.out.print("-> " + neighbor.getValue());
            }
            System.out.println();
        }
    }

    public void getDFS(NodeGraph startNode) {
        boolean[] visited = new boolean[nodes.size()];
        getDFSUtil(startNode, visited);
        System.out.println();
    }

    private void getDFSUtil(NodeGraph node, boolean[] visited) {
        int index = nodes.indexOf(node);
        if (index == -1 || visited[index]) {
            return;
        }
        visited[index] = true;
        System.out.print(node.getValue() + " ");
        for (NodeGraph neighbor : node.getNeighbors()) {
            getDFSUtil(neighbor, visited);
        }
    }

    public void getBFS(NodeGraph startNode) {
        boolean[] visited = new boolean[nodes.size()];
        Queue<NodeGraph> queue = new LinkedList<>();
        visited[nodes.indexOf(startNode)] = true;
        queue.add(startNode);

        while (!queue.isEmpty()) {
            NodeGraph node = queue.poll();
            System.out.print(node.getValue() + " ");
            for (NodeGraph neighbor : node.getNeighbors()) {
                int index = nodes.indexOf(neighbor);
                if (!visited[index]) {
                    visited[index] = true;
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    public int[][] getAdjacencyMatrix() {
        int size = nodes.size();
        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            NodeGraph node = nodes.get(i);
            for (NodeGraph neighbor : node.getNeighbors()) {
                int j = nodes.indexOf(neighbor);
                matrix[i][j] = 1;
            }
        }
        return matrix;
    }

    public void printAdjacencyMatrix() {
        int[][] matrix = getAdjacencyMatrix();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
