import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import BinarySearchTree.BinarySearchTree;




public class Main
{
	public static void main(String[] args) throws Exception 
	{
		BinarySearchTree binarySearchTree = new BinarySearchTree();
		binarySearchTree.add(5);
		binarySearchTree.add(2);
		binarySearchTree.add(4);
		binarySearchTree.add(3);
		binarySearchTree.add(1);
		binarySearchTree.printTree();
	}
}
