package Tree_BFS;

import java.util.LinkedList;
import java.util.Queue;

public class Tree_BFS 
{
	Node root;
	
	public void add(int key)
	{
		Queue<Node> queue = new LinkedList<Node>();
		Node newNode = new Node();
		newNode.key = key;
		if(root == null)
		{
			root = newNode;
		}
		else
		{
			queue.offer(root);
			while(!queue.isEmpty())
			{
				Node parentNode = queue.poll();
				if(parentNode.left != null)
				{
					queue.offer(parentNode.left);
				}
				else
				{
					parentNode.left = newNode;
					return;
				}
				if(parentNode.right != null)
				{
					queue.offer(parentNode.right);
				}
				else
				{
					parentNode.right = newNode;
					break;
				}
			}
		}
	}
	
	private void visit(Node node)
	{
		System.out.printf("%d ",node.key);
	}
	
	public void levelOrder()
	{
		if(null == root)
		{
			return;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty())
		{
			Node parentNode = queue.poll();
			visit(parentNode);
			if(null != parentNode.left)
			{
				queue.offer(parentNode.left);
			}
			if(null != parentNode.right)
			{
				
			}
			System.out.println("");
		}
	}
	
	private void printHelper(Node x, String indent, boolean last)
	{
		if(x != null)
		{
			System.out.print(indent);
			if(last)
			{
				System.out.print("R---");
				indent += "   ";
			}
			else
			{
				System.out.print("L---");
				indent += "|   ";
			}
			System.out.println(x.key);
			printHelper(x.left, indent, false);
			printHelper(x.right, indent, true);
		}
	}
	
	public void printTree()
	{
		printHelper(this.root,"",true);
	}
}
