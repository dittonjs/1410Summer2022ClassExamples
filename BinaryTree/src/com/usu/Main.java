package com.usu;

public class Main {

    public static void main(String[] args) {
	// write your code here
        BinarySearchTree bst = new BinarySearchTree();
        for (int i = 0 ; i < 10; i ++) {
            bst.insert((int)(Math.random() * 10000));
        }
        System.out.println(bst.getHeight());
        System.out.println("==================");
        bst.displayVisualTree();
    }
}
