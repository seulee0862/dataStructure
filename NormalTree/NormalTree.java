package NormalTree;

import java.util.LinkedList;
import java.util.Queue;

public class NormalTree {

    private Node root;

    public void add(int key) {
        Node newNode = new Node();
        newNode.key = key;
        if (null == root) {
            root = newNode;
        } else {
            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                Node x = queue.poll();
                if (null != x.left) {
                    queue.offer(x.left);
                } else {
                    x.left = newNode;
                    break;
                }
                if (null != x.right) {
                    queue.offer(x.right);
                } else {
                    x.right = newNode;
                    break;
                }
            }
        }
    }

    public void levelOrder() {
        // TODO : 순회
        if (null == root) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node parentNode = queue.poll();

            System.out.printf("%d ", parentNode.key);

            if (null != parentNode.left) {
                queue.offer(parentNode.left);
            }
            if (null != parentNode.right) {
                queue.offer(parentNode.right);
            }
        }
        System.out.println("");
    }
    
    //백트래킹 알고리즘 응용
    private void printHelper(Node x, String indent, boolean last) {
        if (x != null) {
            System.out.print(indent);
            if (last) {
                System.out.print("R----");
                indent += "   ";
            } else {
                System.out.print("L----");
                indent += "|  ";
            }

            System.out.println(x.key);
            printHelper(x.left, indent, false);
            printHelper(x.right, indent, true);
        }
    }

    public void printTree() {
        printHelper(this.root, "", true);
    }

}
