package main.Ejercicio_02_invert;
import main.Materia.Models.Node;

public class InvertBinaryTree {

    public Node invertTree(Node root) {

        if(root== null){
            return null;
        }
        Node leftNode= invertTree(root.getLeft());
        Node rightNode=invertTree(root.getRight());

        root.setLeft(rightNode);
        root.setRight(leftNode);

        return root;

        
    }
    

  

    
}
