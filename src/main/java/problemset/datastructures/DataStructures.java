package problemset.datastructures;

public class DataStructures {
	public DataStructures() {
		int nums[] = new int[] {11, 3, 5, 13, 2, 7};
		
		BinaryTree binaryTree = new BinaryTree();

		for (int i : nums) {
			binaryTree.add(i);
		}

		binaryTree.traverseInOrderIterative();
	}
}

















