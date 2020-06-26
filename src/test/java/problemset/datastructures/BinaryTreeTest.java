package problemset.datastructures;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryTreeTest {

	//private int nums[] = new int[] {17, 31, 3, 5, 2, 19, 23, 29, 13, 1, 37, 11};
	private int nums[] = new int[] {7, 11, 3, 5, 13, 2};

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testTraversePreOrderIterative() {
		BinaryTree binaryTree = new BinaryTree();

		for (int i : nums) {
			binaryTree.add(i);
		}

		binaryTree.traversePreOrderIterative();
	}

	@Test
	public void testTraversePostOrderIterative() {
		BinaryTree binaryTree = new BinaryTree();

		for (int i : nums) {
			binaryTree.add(i);
		}

		binaryTree.traversePostOrderIterative();
	}

	@Test
	public void testTraverseInOrderIterative() {
		BinaryTree binaryTree = new BinaryTree();

		for (int i : nums) {
			binaryTree.add(i);
		}

		binaryTree.traverseInOrderIterative();
	}

	@Test
	public void testTraverseBFS() {
		BinaryTree binaryTree = new BinaryTree();

		for (int i : nums) {
			binaryTree.add(i);
		}

		binaryTree.traverseBFS();
	}

	@Test
	public void testAdd() throws Exception {
		BinaryTree binaryTree = new BinaryTree();

		for (int i : nums) {
			binaryTree.add(i);
		}

		for (int i : nums) {
			assertNotNull(binaryTree.find(i));
		}
	}

	@Test
	public void testFind() throws Exception {
		BinaryTree binaryTree = new BinaryTree();

		for (int i : nums) {
			binaryTree.add(i);
		}

		for (int i : nums) {
			assertNotNull(binaryTree.find(i));
		}
		binaryTree.traverseInOrder();
	}

	@Test
	public void testRemove() throws Exception {
		BinaryTree binaryTree = new BinaryTree();

		System.out.printf("%s\n", nums);
		for (int i : nums) {
			binaryTree.add(i);
		}

		for (int i : nums) {
			binaryTree.remove(i);
		}

		for (int i : nums) {
			assertNull(binaryTree.find(i));
		}

		assertNull(binaryTree.getRoot());
	}
}
