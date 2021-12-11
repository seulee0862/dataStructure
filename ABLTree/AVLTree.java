package ABLTree;

public class AVLTree 
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
	
	private Node insertNode(Node x, Node newNode)
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
		
		changeNodeHeight(x);
		return rotate(x);
	}
	
	public void remove(int key)
	{
		root = removeNode(root,key);
	}
	
	private Node removeNode(Node x, int key)
	{
		if(null == x)
		{
			throw new RuntimeException("키를 찾을 수 없습니다.");
		}
		else if(x.key > key)
		{
			x.left = removeNode(x.left, key);
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
				x.right = removeNode(x.right,key);
			}
			else
			{
				return null;
			}
		}
		
		changeNodeHeight(x);
		return rotate(x);
	}
	
	private Node getLargestNode(Node x)
	{
		if( null == x.right ) return x;
		return getLargestNode(x.right);
	}
	
	private Node getSmallestNode(Node x)
	{
		if(null == x.left) return x;
		return getSmallestNode(x.left);
	}
	
	public int search(int key)
	{
		return searchNode(root,key).key;
	}
	
	private Node searchNode(Node x,int key)
	{
		Node node = x;
		if(null == node)
		{
			throw new RuntimeException("키를 찾을 수 없습니다.");
		}
		else if(node.key > key)
		{
			node = searchNode(node.left,key);
		}
		else if(node.key < key)
		{
			node = searchNode(node.right,key);
		}
		return node;
	}
	
	private Node rotate(Node x)
	{
		int xNodeBalance = getBalance(x);
		
		if(Math.abs(xNodeBalance) >= 2) // 균형이 안맞는다면
		{
			if(xNodeBalance > 1 && 1 == getBalance(x.left)) //LL불균형
			{
				x = LL_rotate(x);
			}
			else if(xNodeBalance > 1 && -1 == getBalance(x.left))//LR불균형
			{
				x.left = RR_rotate(x.left);
				x = LL_rotate(x);
			}
			else if(xNodeBalance < -1 && -1 == getBalance(x.right))//RR불균형
			{
				x = RR_rotate(x);
			}
			else if(xNodeBalance < -1 && 1 == getBalance(x.right))//RL불균형
			{
				x.right = LL_rotate(x.right);
				x = RR_rotate(x);
			}
		}
		return x;
	}
	
	//왼쪽으로 치우쳐진 경우
	private Node LL_rotate(Node P)
	{
		Node L = P.left;
		Node LR = L.right;
		L.right = P;
		P.left = LR;
		
		changeNodeHeight(P);
		changeNodeHeight(L);
		
		return L;
	}
	
	//오른쪽으로 치우쳐진 경우
	private Node RR_rotate(Node P)
	{
		Node R = P.right;
		Node RL = R.left;
		R.left = P;
		P.right = RL;
		
		changeNodeHeight(P);
		changeNodeHeight(R);
		
		return R;
	}
	
	private int getHeight(Node x)
	{
		int leftChildHeight = (null != x.left) ? x.left.height : -1;
		int rightChildHeight = (null != x.right) ? x.right.height : -1;
		return Math.max(leftChildHeight, rightChildHeight) + 1;
	}
	
	private int getBalance(Node x)
	{
		int leftChildHeight = (null != x.left) ? x.left.height : -1;
		int rightChildHeight = (null != x.right) ? x.right.height : -1;
		return leftChildHeight - rightChildHeight;
	}
	
	private void changeNodeHeight(Node x)
	{
		x.height = getHeight(x);
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
				indent += "   ";
			}
			System.out.println(x.key);
			printHelper(x.left,indent,false);
			printHelper(x.right,indent,true);
		}
	}
	
	public void printTree()
	{
		printHelper(this.root,"",true);
	}
	
	public void traversal()
	{
		inorderTraversal(root);
		System.out.println("");
	}
	
	private void inorderTraversal(Node node)
	{
		if(null == node) return;
		inorderTraversal(node.left);
		System.out.printf("%d",node.key);
		inorderTraversal(node.right);
	}
}
