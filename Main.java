import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import ABLTree.AVLTree;





public class Main
{
	public static void main(String[] args) throws Exception 
	{
		AVLTree avlTree = new AVLTree();
		avlTree.add(5);
		avlTree.add(2);
		avlTree.add(9);
		avlTree.add(3);
		avlTree.add(7);
		avlTree.add(4);
		avlTree.add(8);
		avlTree.printTree();
	}
}
