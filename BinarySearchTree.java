package tree;
import java.util.ArrayList;

public class BinarySearchTree
{
	BTNode root;
	
	BinarySearchTree()
	{
		root = null;
	}
	
	public void insert(int data)
	{
		BTNode node = new BTNode();
		node.setData(data);
		node.setLeft(null);
		node.setRight(null);
		if(root == null)
		{
			root = node;
			root.setParent(null);
		}
		else
		{
			BTNode pNode = root;
			while(true)
			{
				if(pNode.getData() > node.getData())
				{
					if(pNode.getLeft() == null)
					{
						pNode.setLeft(node);
						node.setParent(pNode);
						break;
					}
					else
					{
						pNode = pNode.getLeft();
					}
				}
				else
				{
					if(pNode.getRight() == null)
					{
						pNode.setRight(node);
						node.setParent(pNode);
						break;
					}
					else
					{
						pNode = pNode.getRight();
					}
				}
			}
		}
	}
	
	public boolean search(int data)
	{
		BTNode pNode = root;
		while(pNode != null)
		{
			if(pNode.getData() > data)
			{
				pNode = pNode.getLeft();
			}
			else
			{
				if(pNode.getData() == data)
				{
					return true;
				}
				else
				{
					pNode = pNode.getRight();
				}
			}
		}
		return false;		
	}
	
	public int findMax()
	{
		BTNode maxNode = root;
		while(maxNode.getRight() != null)
		{			
			maxNode = maxNode.getRight();
		}
		return maxNode.getData();			
	}
	
	public int findMin()
	{
		return getMinNode(root).getData();		
	}

	public boolean delete(int data)
	{
		BTNode pNode = root;
		BTNode prevNode = null;
		boolean parentLeft = false;
		boolean parentRight = false;
		
		while(pNode != null)
		{
			if(pNode.getData() > data)
			{
				prevNode = pNode;
				parentLeft = true;
				parentRight = false;
				pNode = pNode.getLeft();
			}
			else if(pNode.getData() <= data)
			{
				if(pNode.getData() == data)
				{
					if(pNode.getLeft() == null && pNode.getRight() == null)
					{
						if(parentLeft == true)
						{
							prevNode.setLeft(null);
							return true;
						}
						else if(parentRight == true)
						{
							prevNode.setRight(null);
							return true;
						}
					}
					else if(pNode.getLeft() == null || pNode.getRight() == null)
					{
						if(parentLeft == true)
						{
							if(pNode.getLeft() != null)
							{
								pNode.getLeft().setParent(prevNode);
								prevNode.setLeft(pNode.getLeft());
							}
							else if(pNode.getRight() != null)
							{
								pNode.getRight().setParent(prevNode);
								prevNode.setLeft(pNode.getRight());
							}
							return true;
						}
						else if(parentRight == true)
						{
							if(pNode.getLeft() != null)
							{
								pNode.getLeft().setParent(prevNode);
								prevNode.setRight(pNode.getLeft());
							}
							else if(pNode.getRight() != null)
							{
								pNode.getRight().setParent(prevNode);
								prevNode.setRight(pNode.getRight());
							}
							return true;
						}
					}
					//else if(pNode.getLeft() != null && pNode.getRight() != null)
					else
					{
						BTNode node = getMinNode(pNode.getRight());
						int temp = node.getData();
						delete(node.getData());
						pNode.setData(temp);
					}					
				}
				else
				{
					prevNode = pNode;
					parentLeft = false;
					parentRight = true;
					pNode = pNode.getRight();
				}
			}
		}
		return false;
	}
		
	public void printData()
	{	
		ArrayList<BTNode> tempCurrLevel = new ArrayList<BTNode>();
		ArrayList<BTNode> tempNextLevel = new ArrayList<BTNode>();
		boolean flag;
		System.out.print("Binary Tree Elements (Breadth-First traversal):\n");
		if(root != null)
		{
			System.out.print(root.getData()+"\n");
			tempCurrLevel.add(root);
			do
			{
				flag = false;
				for(BTNode i: tempCurrLevel)
				{
					if(i.getLeft() != null && i.getRight() != null)
					{
						System.out.print(i.getLeft().getData()+" "+i.getRight().getData()+ " ");
						tempNextLevel.add(i.getLeft());
						tempNextLevel.add(i.getRight());
						flag = true;
					}					
					else if(i.getLeft() != null && i.getRight() == null)
					{
						System.out.print(i.getLeft().getData()+" ");
						tempNextLevel.add(i.getLeft());
						flag = true;
					}
					else if(i.getLeft() == null && i.getRight() != null)
					{
						System.out.print(i.getRight().getData()+" ");
						tempNextLevel.add(i.getRight());
						flag = true;
					}
				}
				System.out.println("");
				tempCurrLevel.clear();
				tempCurrLevel.addAll(tempNextLevel);
				tempNextLevel.clear();
			}while(flag);
		}
	}
	
	public void preOrderTraversal()
	{
		preOrderTraversal(root);
	}
	
	public void postOrderTraversal()
	{
		postOrderTraversal(root);
	}
	
	public void inOrderTraversal()
	{
		inOrderTraversal(root);
	}
	
	private BTNode getMinNode(BTNode minNode)
	{
		while(minNode.getLeft() != null)
		{			
			minNode = minNode.getLeft();
		}
		return minNode;		
	}
	
	private void preOrderTraversal(BTNode node)
	{
		if(node == null)
		{
			return;
		}		
		System.out.print(node.getData() + " ");
		preOrderTraversal(node.getLeft());
		preOrderTraversal(node.getRight());
	}
	
	private void postOrderTraversal(BTNode node)
	{
		if(node == null)
		{
			return;
		}	
		postOrderTraversal(node.getLeft());
		postOrderTraversal(node.getRight());
		System.out.print(node.getData() + " ");
	}
	
	private void inOrderTraversal(BTNode node)
	{
		if(node == null)
		{
			return;
		}	
		inOrderTraversal(node.getLeft());
		System.out.print(node.getData() + " ");
		inOrderTraversal(node.getRight());
	}
	
	private class BTNode
	{
		private int data;
		private BTNode parent;
		private BTNode left;
		private BTNode right;
		
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}
		public BTNode getLeft() {
			return left;
		}
		public void setLeft(BTNode left) {
			this.left = left;
		}
		public BTNode getRight() {
			return right;
		}
		public void setRight(BTNode right) {
			this.right = right;
		}	
		public BTNode getParent() {
			return parent;
		}
		public void setParent(BTNode parent) {
			this.parent = parent;
		}
	}
}