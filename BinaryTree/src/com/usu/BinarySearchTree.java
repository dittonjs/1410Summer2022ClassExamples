package com.usu;

public class BinarySearchTree {
    private class Node {
        int value;
        Node left;
        Node right;
    }

    private Node root;

    public void insert(int value) {
        Node newNode = new Node();
        newNode.value = value;
        if (root == null) {
            root = newNode;
            return;
        }

        Node parent = null;
        Node current = root;
        while(current != null) {
            if (current.value <= value) { // go right
                parent = current;
                current = current.right;
            } else { // go left
                parent = current;
                current = current.left;
            }
        }

        if (parent.value <= value) {
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }
    }


    public int numLeafNodes() {
        return numLeafNodes(root);
    }

    private int numLeafNodes(Node node) {
        if (node == null) return 0;
        int count = numLeafNodes(node.left) + numLeafNodes(node.right);
        if (count == 0) return 1;
        return count;
    }

    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(Node node) {
        if (node == null) return -1;
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    public boolean search(int value) {
        Node current = root;
        while(current != null) {
            if (current.value < value) {
                current = current.right;
            } else if(current.value > value) {
                current = current.left;
            } else {
                return true;
            }
        }
        return false;
    }

    public void remove(int value) {
        boolean done = false;
        Node parent = null;
        Node current = root;
        while(!done && current != null) {
            if (current.value < value) {
                parent = current;
                current = current.right;
            } else if(current.value > value) {
                parent = current;
                current = current.left;
            } else {
                done = true;
            }
        }
        if (current == null) return;

        if(current.left == null) {
            if (parent == null) {
                root = current.right;
            } else if (current == parent.right) {
                parent.right = current.right;
            } else {
                parent.left = current.right;
            }
        } else {
            Node parentOfRightMost = current;
            Node rightMost = current.left;
            while(rightMost.right != null) {
                parentOfRightMost = rightMost;
                rightMost = rightMost.right;
            }
            current.value = rightMost.value;
            if (parentOfRightMost.left == rightMost) {
                parentOfRightMost.left = rightMost.left;
            } else {
                parentOfRightMost.right = rightMost.left;
            }
        }
    }

    public void displayInOrder() {
        displayInOrder(root);
    }

    public void displayPostOrder() {
        displayPostOrder(root);
    }

    private void displayPostOrder(Node node) {
        if (node == null) return;
        displayPostOrder(node.left);
        displayPostOrder(node.right);
        System.out.println(node.value);
    }

    public void displayPreOrder() {
        displayPreOrder(root);
    }

    private void displayPreOrder(Node node) {
        if (node == null) return;
        System.out.println(node.value);
        displayPreOrder(node.left);
        displayPreOrder(node.right);
    }

    private void displayInOrder(Node node) {
        if (node == null) return;
        displayInOrder(node.left);
        System.out.println(node.value);
        displayInOrder(node.right);
    }

    public void displayVisualTree() {
        displayVisualTree(root, 2);
    }

    private void displayVisualTree(Node node, int depth) {
        if (node == null) return;
        displayVisualTree(node.right, depth + 4);
        System.out.printf("%" + depth + "d\n", node.value);
        displayVisualTree(node.left, depth + 4);
    }

    public void displayBreadthFirst() {
        if (root == null) return;
        Queue<Node> nodes = new Queue<>();
        nodes.enqueue(root);
        while(!nodes.isEmpty()) {
            Node node = nodes.dequeue();
            System.out.println(node.value);
            if (node.left != null) {
                nodes.enqueue(node.left);
            }
            if (node.right != null) {
                nodes.enqueue(node.right);
            }
        }
    }
}
