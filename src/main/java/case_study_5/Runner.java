package case_study_5;

public class Runner {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.add(5);
        tree.add(3);
        tree.add(8);

        boolean contains = tree.contains(8);

        System.out.println(contains);
    }
}

class BinaryTree {
    private Node head;

    public void add(int value) {
        if (head == null) {
            head = new Node(value);
        } else {
            addToTree(head, value);
        }
    }

    private void addToTree(Node node, int value) {
        if (value - node.getKey() < 0) {
            if(node.getLeft() == null) {
                node.setLeft(new Node(value));
            } else addToTree(node.getLeft(), value);
        } else {
            if(node.getRight() == null) {
                node.setRight(new Node(value));
            }
        }
    }

    public boolean contains(int value) {
        Node current = head;

        while (current != null) {
            int result = current.getKey() - value;

            if (result > 0) {
                current = current.getLeft();
            } else if (result < 0) {
                current = current.getRight();
            } else
                break;
        }

        return current != null;
    }
}

class Node {
    private Node right;
    private Node left;
    private int key;

    public Node(int k) {
        key = k;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public int getKey() {
        return key;
    }

    @Override
    public String toString() {
        return String.valueOf(key);
    }
}