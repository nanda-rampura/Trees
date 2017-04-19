package tree;

public class TestBinarySearchTree
{
	public static void main(String args[])
	{
		System.out.println("Create a binary search tree:");
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(7);
		bst.insert(5);
		bst.insert(12);
		bst.insert(3);
		bst.insert(6);
		bst.insert(9);
		bst.insert(15);
		bst.insert(1);
		bst.insert(4);
		bst.insert(8);
		bst.insert(10);
		bst.insert(13);
		bst.insert(17);
		bst.printData();

		System.out.println("Search for 15:");
		System.out.println(bst.search(15) ? "Found" : "Not found");
		System.out.println("Search for 100:");
		System.out.println(bst.search(100) ? "Found" : "Not found");
		System.out.println();

		System.out.println("Finding max and min:");
		System.out.println("Max element = " + bst.findMax());
		System.out.println("Min element = " + bst.findMin());
		System.out.println();

		System.out.println("Delete max and min:");
		System.out.println(bst.delete(17) ? "17 deleted" : "17 not deleted");
		System.out.println(bst.delete(1) ? "1 deleted" : "1 not deleted");
		System.out.println();

		bst.printData();
		System.out.println("Finding max and min:");
		System.out.println("Max element = " + bst.findMax());
		System.out.println("Min element = " + bst.findMin());
		System.out.println();

		System.out.print("Pre-order traversal : ");
		bst.preOrderTraversal();
		System.out.println();
		System.out.print("Post-order traversal: ");
		bst.postOrderTraversal();
		System.out.println();
		System.out.print("In-order traversal  : ");
		bst.inOrderTraversal();
	}
}