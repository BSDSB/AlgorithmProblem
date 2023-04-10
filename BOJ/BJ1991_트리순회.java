package BOJ;

import java.util.Scanner;

class Node{
    public String data;
    public Node left;
    public Node right;

    public Node(String data) {
        this.data = data;
    }
}
class Tree {
    Node root;

    public void add(String data, String left_data, String right_data) {
        if (root == null) {
            root = new Node(data);

            if (!left_data.equals(".")) {
                root.left = new Node(left_data);
            }
            if (!right_data.equals(".")) {
                root.right = new Node(right_data);
            }
        } else {
            search(root, data, left_data, right_data);
        }
    }

    public void search(Node root, String data, String left_data, String right_data) {
        if (root == null)
            return;
        if (root.data.equals(data)) {
            if (!left_data.equals("."))
                root.left = new Node(left_data);
            if (!right_data.equals("."))
                root.right = new Node(right_data);
        } else {
            search(root.left, data, left_data, right_data);
            search(root.right, data, left_data, right_data);
        }
    }
}

public class BJ1991_트리순회 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        Tree tree = new Tree();
        for (int i = 0; i < num; i++) {
            tree.add(String.valueOf(sc.next().charAt(0)), String.valueOf(sc.next().charAt(0)),
                    String.valueOf(sc.next().charAt(0)));
        }

        preOrder(tree.root);
        System.out.println();
        inOrder(tree.root);
        System.out.println();
        postOrder(tree.root);
    }
    //전위
    public static void preOrder(Node tree){
        System.out.print(tree.data);
        if(tree.left != null)
            preOrder(tree.left);
        if(tree.right != null)
            preOrder(tree.right);
    }
    //중위
    public static void inOrder(Node tree){
        if(tree.left != null)
            inOrder(tree.left);
        System.out.print(tree.data);
        if(tree.right != null)
            inOrder(tree.right);
    }
    //후위
    public static void postOrder(Node tree){
        if(tree.left != null)
            postOrder(tree.left);
        if(tree.right != null)
            postOrder(tree.right);
        System.out.print(tree.data);
    }

}
