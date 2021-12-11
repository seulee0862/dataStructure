package BinarySearchTree;

public class BinarySearchTree 
{
	private Node root;
	
	public void add(int key)
	{
		Node newNode = new Node();
		newNode.key = key;
		if(null == root)
		{
			root = newNode;
		}
		else
		{
			root = insertNode(root,newNode);
		}
	}
	
	private Node insertNode(Node x,Node newNode)
	{
		if(null == x)
		{
			return newNode;
		}
		else if(x.key > newNode.key)
		{
			x.left = insertNode(x.left,newNode);
		}
		else
		{
			x.right = insertNode(x.right, newNode);
		}
		return x;
	}
	
	public void remove(int key)
	{
		root = removeNode(root,key);
	}
	
	/*
	 * node기준으로 가장 좌측 노드의 키 값이 가장 작고
	 *               우측 노드의 키 값이 가장 크다.
	 * 원하는 node를 삭제한 이후에도 트리의 특징이 그대로 유지되어야 하기 때문에
	 * 삭제될 노드는 자식노드중 가장 작은 값을 찾아서 바꾼후에 해당 노드의 좌or우 
	 * 노드를 null로 처리함으로서 원하는 key값을 삭제하고 트리를 유지시킨다
	 * 여기서 헷갈렸던것이 Node 객체의 주소가 바뀌는 것이 절대아니며 key값의
	 * 변경만 이뤄진후 마지막 Node객체의 주소만 null로 연결을 끊어주는것이다
	 * 이렇게 좌측노드의 연결이 해제된 Node는 부모Node.left로 계속 자신의
	 * Node를 반환하는것이다 ( 처음부터 left가없다면 right일수는 있다)
	 * 
	 * 트리의 특징을 이해하지 않고 queue랑list에 적응된 머리상태로 풀려고하다보니
	 * 엄청해맸음 
	 * (나중에 헷갈리면 참고용 주석)
	 *
	 */
	private Node removeNode(Node x, int key)
	{
		if(null == x)
		{
			throw new RuntimeException("노드를 찾을수 없습니다");
		}
		else if(x.key > key)
		{
			x.left = removeNode(x.left,key);
		}
		else if(x.key < key)
		{
			x.right = removeNode(x.right,key);
		}
		else
		{
			if(null != x.left)
			{
				Node predecessor = getLargestNode(x.left);
				int removeKey = x.key;
				x.key = predecessor.key;
				predecessor.key = removeKey;
				x.left = removeNode(x.left,key);
			}
			else if(null != x.right)
			{
				Node successor = getSmallestNode(x.right);
				int removeKey = x.key;
				x.key = successor.key;
				successor.key = removeKey;
				x.right = removeNode(x.right, key);
			}
			else
			{
				return null;
			}
		}
		return x;
	}
	
	private Node getLargestNode(Node x)
	{
		if(null == x.right)
		{
			return x;
		}
		return getLargestNode(x.right);
	}
	
	private Node getSmallestNode(Node x)
	{
		if(null == x.left)
		{
			return x;
		}
		return getLargestNode(x.left);
	}
	
	public int search(int key)
	{
		return searchNode(root,key).key;
	}
	
	private Node searchNode(Node x, int key)
	{
		Node node = x;
		if(null == node)
		{
			throw new RuntimeException("노드를 찾을수 없습니다");
		}
		else if(node.key > key)
		{
			node = searchNode(x.left,key);
		}
		else if(node.key < key)
		{
			node = searchNode(x.right,key);
		}
		return node;
	}
	
	private void printHelper(Node x, String indent, boolean last)
	{
		if(x != null)
		{
			System.out.println(indent);
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
			printHelper(x.right,indent, true);
		}
	}
	
	public void printTree()
	{
		printHelper(this.root, "", true);
	}
	
	public void traversal()
	{
		inorderTraversal(root);
	}
	
	private void inorderTraversal(Node x)
	{
		if(null == x) return;
		inorderTraversal(x.left);
		System.out.printf("%d ",x.key);
		inorderTraversal(x.right);
	}
}
