package com.bchandra.datastructure;

import java.util.LinkedList;
import java.util.Queue;

public class OO8BinaryTree {

	public static void main(String[] args) {
		OO8BinaryTree binaryTree = new OO8BinaryTree();
		binaryTree.insert(10);
		binaryTree.insert(20);
		binaryTree.insert(30);
		binaryTree.insert(40);
		binaryTree.insert(50);
		binaryTree.insert(60);
		binaryTree.insert(70);
		binaryTree.insert(80);
		binaryTree.insert(90);
		System.out.println("Pre Order");
		binaryTree.preOrderTraversal(binaryTree.root);
		System.out.println("\nIn Order");
		binaryTree.inOrderTraversal(binaryTree.root);
		System.out.println("\nPost Order");
		binaryTree.postOrderTraversal(binaryTree.root);
		System.out.println("\nLevel Order");
		binaryTree.levelOrderTraversal();
		binaryTree.search(30);
		binaryTree.search(300);
		binaryTree.getDeepestNode();
		binaryTree.deleteNodeFromBinaryTree(30);
		binaryTree.levelOrderTraversal();
		binaryTree.deleteNodeFromBinaryTree(40);
		binaryTree.levelOrderTraversal();
		binaryTree.deleteEntireBineryTree();
		binaryTree.levelOrderTraversal();
	}
	
	//declare
	OO8BinaryTreeNode root = null;

	private OO8BinaryTreeNode createBlankBinaryTreeNode(int aValue) {
		OO8BinaryTreeNode newNode = new OO8BinaryTreeNode();
		newNode.setValue(aValue);
		newNode.setLeftNode(null);
		newNode.setRightNode(null);
		return newNode;
	}

	/**
	 * insert
	 * insert happens at deepest node
	 * use level order traversal as it is fast
	 */
	private void insert(int aValue) {
		OO8BinaryTreeNode newNode = createBlankBinaryTreeNode(aValue);
		
		Queue<OO8BinaryTreeNode> queue = new LinkedList<OO8BinaryTreeNode>();// only used for level order traversal
		if(root==null) {
			root=newNode;
			queue.add(root);
		}else {
			queue.add(root);
			while(!queue.isEmpty()) {
				OO8BinaryTreeNode currentNode = queue.remove();
				if(currentNode.getLeftNode()==null) {
					//queue.add(newNode); - wrong - Queue is only used for traversal and not for insertion
					//insertion still happens in the Binary node - left or right nodes
					currentNode.setLeftNode(newNode);
					break;//exit the while loop once the value is set
				}else if(currentNode.getRightNode()==null) {
					//queue.add(newNode);- wrong - Queue is only used for traversal and not for insertion
					// insertion still happens in the Binary node - left or right nodes
					currentNode.setRightNode(newNode);
					break;//exit the while loop once the value is set
				}else {
					queue.add(currentNode.getLeftNode());
					queue.add(currentNode.getRightNode());
				}
				
			}
		}
		
	}

	/**
	 * level order traversal
	 * @param aValue
	 */
	void search(int aValue) {
		if(root==null) {
			System.out.println("ROOT is null");
			return ;
		}
		Queue<OO8BinaryTreeNode> queue = new LinkedList<OO8BinaryTreeNode>();
		queue.add(root);
		OO8BinaryTreeNode currentNode = null;
		while(!queue.isEmpty()) {
			currentNode = queue.remove();
			if(currentNode.getValue() == aValue) {
				System.out.println();
				System.out.println(aValue + " SUCCESS");
				return;
			}else {
				if(currentNode.getLeftNode()!=null)
					queue.add(currentNode.getLeftNode());
				if(currentNode.getRightNode()!=null)
					queue.add(currentNode.getRightNode());
			}
		}
		System.out.println(aValue + " FAILED");
	}
	
	/**
	 * level order traversal
	 * search this node in binary tree
	 * replace it with deepest node
	 * delete deepest node
	 * 
	 * 1. Starting at root, find the deepest and rightmost node in binary tree and node which we want to delete.
	 * 2. Replace the deepest rightmost node’s data with node to be deleted.
	 * 3. Then delete the deepest rightmost node.
	 */
	void deleteNodeFromBinaryTree(int aValue) {
		if(root==null) {
			System.out.println("ROOT is null");
			return ;
		}
		Queue<OO8BinaryTreeNode> queue = new LinkedList<OO8BinaryTreeNode>();
		queue.add(root);
		
		// Find the node to be deleted
		OO8BinaryTreeNode currentNode = null;
		while(!queue.isEmpty()) {
			currentNode = queue.remove();
			if(currentNode.getValue() == aValue) {
				// currentNode is to be deleted
				//deepestNode = findDeepestNode()
				//temNode = currentNode;
				//currentNode = deepestNode
				//deepestnode = tempNode
				//deleteDeepestNode
				
				OO8BinaryTreeNode tempNode = currentNode;
				currentNode.setValue(getDeepestNode().getValue());
				deleteDeepestNode();
				break;
			}else {
				if(currentNode.getLeftNode()!=null)
					queue.add(currentNode.getLeftNode());
				if(currentNode.getRightNode()!=null)
					queue.add(currentNode.getRightNode());
			}
		}
		
	}
	
	/**
	 * get last node of last level of binary tree
	 * @return
	 */
	public OO8BinaryTreeNode getDeepestNode() {
		if(root==null) {
			System.out.println("ROOT is null");
			return null;
		}
		Queue<OO8BinaryTreeNode> queue = new LinkedList<OO8BinaryTreeNode>();
		queue.add(root);
		OO8BinaryTreeNode currentNode = null;
		while(!queue.isEmpty()) {
			currentNode = queue.remove();
			if(currentNode.getLeftNode()!=null)
				queue.add(currentNode.getLeftNode());
			if(currentNode.getRightNode()!=null)
				queue.add(currentNode.getRightNode());
		}
		System.out.println("DeepestNode: "+currentNode.getValue());
		return currentNode;
	}
	

	public void deleteDeepestNode() {
		if(root==null) {
			System.out.println("ROOT is null");
			return;
		}
		Queue<OO8BinaryTreeNode> queue = new LinkedList<OO8BinaryTreeNode>();
		queue.add(root);
		OO8BinaryTreeNode currentNode = null;
		OO8BinaryTreeNode previousNode = null;
		while(!queue.isEmpty()) {
			previousNode = currentNode;//for root previousNode is null
			currentNode = queue.remove();
			if(currentNode.getLeftNode()==null) {
				if(previousNode == null) {//i.e. only one node in the tree i.e. only root node
					root=null;
					return;
				}
				previousNode.setRightNode(null);
				return;
			}
			if(currentNode.getRightNode()==null) {
				currentNode.setLeftNode(null);
				return;
			}
			if(currentNode.getLeftNode()!=null)
				queue.add(currentNode.getLeftNode());
			if(currentNode.getRightNode()!=null)
				queue.add(currentNode.getRightNode());
		}
	}
	
	/**
	 * level order traversal uses a queue
	 * 
	 */
	private void levelOrderTraversal() {
		if(root==null) {
			System.out.println("\nBinary node is empty.");
			return;
		}
		Queue<OO8BinaryTreeNode> queue = new LinkedList<OO8BinaryTreeNode>();
		queue.add(root);
		OO8BinaryTreeNode currentNode = null;
		while(!queue.isEmpty()) {
			currentNode=queue.remove();
			System.out.print(currentNode.getValue() + " ");
			if(currentNode.getLeftNode()!=null)
				queue.add(currentNode.getLeftNode());
			if(currentNode.getRightNode()!=null)
				queue.add(currentNode.getRightNode());
		}
		System.out.println();
	}
	
	/**
	 * delete entire node
	 */
	private void deleteEntireBineryTree() {
		root=null;
	}
	
	/**
	 * pre-order traversal
	 * uses recursion - which internally processes as stack
	 */
	void preOrderTraversal(OO8BinaryTreeNode node) {
		if(node==null)
			return;
		System.out.print(node.getValue() + " ");
		preOrderTraversal(node.getLeftNode());
		preOrderTraversal(node.getRightNode());
	}

	/**
	 * in-order traversal
	 * uses recursion - which internally processes as stack
	 */
	void inOrderTraversal(OO8BinaryTreeNode node) {
		if(node==null)
			return;
		inOrderTraversal(node.getLeftNode());
		System.out.print(node.getValue() + " ");
		inOrderTraversal(node.getRightNode());
	}

	/**
	 * post-order traversal
	 * uses recursion - which internally processes as stack
	 */
	void postOrderTraversal(OO8BinaryTreeNode node) {
		if(node==null)
			return;
		postOrderTraversal(node.getLeftNode());
		postOrderTraversal(node.getRightNode());
		System.out.print(node.getValue() + " ");
	}
}
