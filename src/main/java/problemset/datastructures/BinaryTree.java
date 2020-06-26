package problemset.datastructures;

import java.util.Queue;
import java.util.Stack;
import java.util.ArrayDeque;

public class BinaryTree {
	private BinaryTreeNode root;

	public BinaryTreeNode find(int n) {

		BinaryTreeNode current = root;
		while (current != null) {
			if (current.value == n) {
				return current;
			} else if (current.value > n) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		return null;
	}

	public void add(int n) {

		if (root == null) {
			root = new BinaryTreeNode(n);
			return;
		}

		BinaryTreeNode current = root;
		while (current.value != n) {
			if (current.value > n) {
				if (current.left != null) {
					current = current.left;
				} else {
					current.left = new BinaryTreeNode(n);
					return;
				}
			} else {
				if (current.right != null) {
					current = current.right;
				} else {
					current.right = new BinaryTreeNode(n);
					return;
				}
			}
		}
	}

	public void remove(int value) {
		BinaryTreeNode current = root;
		BinaryTreeNode parent = null;
		boolean isLeft = false;

		while (current != null) {
			if (current.value < value) {
				parent = current;
				current = current.right;
				isLeft = false;
			} else if (current.value > value) {
				parent = current;
				current = current.left;
				isLeft = true;
				
			} else if (current.value == value) {
				if (current.left == null && current.right == null) {

					if (parent == null) {
						root = null;
						return;
					}
					if (isLeft) {
						parent.left = null;
					} else {
						parent.right = null;
					}
				} else if (current.left == null) {

					if (parent == null) {
						root = current.right;
						return;
					}
					if (isLeft) {
						parent.left = current.right;
					} else {
						parent.right = current.right;
					}
				} else if (current.right == null) {

					if (parent == null) {
						root = current.left;
						return;
					}
					if (isLeft) {
						parent.left = current.left;
					} else {
						parent.right = current.left;
					}
				} else {	/* if (current.left != null && current.right != null) */

					if (parent == null) {
						root = null;
						return;
					}
					BinaryTreeNode del = current;
					BinaryTreeNode parent2 = current;

					current = current.right;

					while (current.left != null) {
						parent2 = current;
						current = current.left;
					}

					if (current.right != null && parent2 != del) {
						parent2.left = current.right;
					} else {
						parent2.left = null;

						if (isLeft) {
							parent.left = current;
						} else {
							parent.right = current;
						}
						current.right = del.right;
						current.left = del.left;
					}
				}
			}
		}
	}

	public void traverseBFS() {
		System.out.printf("BFS\n");
		Queue queue = new ArrayDeque();
		queue.offer(root);
		while (!queue.isEmpty()) {
			BinaryTreeNode node = (BinaryTreeNode) queue.poll();
			System.out.printf("%d ", node.value);
			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
		}
		System.out.printf("\n");
	}

	public void traversePreOrderIterative() {
		System.out.printf("Pre-order DFS iterative\n");
		Stack stack = new Stack();
		BinaryTreeNode node;
		stack.push(root);

		while (!stack.isEmpty()) {
			node = (BinaryTreeNode) stack.pop();
			if (node == null) {
				continue;
			}
			System.out.printf("%d ", node.value);
			stack.push(node.right);
			stack.push(node.left);
		}
		System.out.printf("\n");
	}

	public void traverseInOrderIterative() {
		System.out.printf("In-order DFS iterative\n");
		Stack stack = new Stack();
		BinaryTreeNode node = root;

		while (!stack.isEmpty() || node != null) {
			if (node != null) {
				stack.push(node);
				node = node.left;
			} else {
				node = (BinaryTreeNode) stack.pop();
				System.out.printf("%d ", node.value);
				node = node.right;
			}
		}

		System.out.printf("\n");
	}

	public void traversePostOrderIterative() {
		System.out.printf("Post-order DFS iterative\n");
		Stack stack = new Stack();
		BinaryTreeNode node = root;
		BinaryTreeNode lastVisited = null;
		
		while (!stack.isEmpty() || node != null) {
			if (node != null) {
				stack.push(node);
				node = node.left;
			} else {
				node = (BinaryTreeNode) stack.peek();
				if (node.right != null && node.right != lastVisited) {
					node = node.right;
				} else {
					node = (BinaryTreeNode) stack.pop();
					System.out.printf("%d ", node.value);
					lastVisited = node;
					node = null;
				}
			}
		}
		System.out.printf("\n");
	}

	public void traverseInOrder() {
		System.out.printf("In-order DFS recursive\n");
		traverseInOrder(root);
		System.out.printf("\n");
	}

	private void traverseInOrder(BinaryTreeNode node) {
		if (node == null) {
			return;
		}
		traverseInOrder(node.left);
		System.out.printf("%d ", node.value);
		traverseInOrder(node.right);
	}

	public BinaryTreeNode getRoot() {
		return root;
	}

	private class BinaryTreeNode {
		BinaryTreeNode(int value) {
			this.value = value;
		}
		
		int value;
		BinaryTreeNode left;
		BinaryTreeNode right;

	}
}
