package com.binarytree.codingninja;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import com.tree.TreeNode;

public class BinaryTreeUse{
	
	
	public static BinaryTreeNode<Integer>takeInput(Scanner s)
	{
		int rootData;
		System.out.println("Enter root data");
		rootData=s.nextInt();
		if(rootData==-1)
		{
			return null;
		}
		BinaryTreeNode<Integer>root=new BinaryTreeNode<Integer>(rootData);
		root.left=takeInput(s);
		root.right=takeInput(s);
		return root; 
		 
	}
	public static void printTree(BinaryTreeNode<Integer>root)
	{
		if(root==null)
		{
			return;
		}
		String toBePrinted=root.data+" ";
		if(root.left!=null)
		{
			toBePrinted+="L:"+root.left.data+",";
		}
		if(root.right!=null)
		{
			toBePrinted+="R:"+root.right.data+",";
		}
		System.out.println(toBePrinted);
		printTree(root.left);
		printTree(root.right);
	}
	
	public static BinaryTreeNode<Integer>takeInputLevelWise(){
		Scanner s=new Scanner(System.in);
		Queue<BinaryTreeNode<Integer>>pendingNodes=new LinkedList<BinaryTreeNode<Integer>>();
		System.out.println("Enter root data");
		int rootData=s.nextInt();
		if(rootData==-1)
		{
			return null;
		}
		BinaryTreeNode<Integer>root=new BinaryTreeNode<Integer>(rootData);
		pendingNodes.add(root);
		while(!pendingNodes.isEmpty())
		{
			BinaryTreeNode<Integer>front=pendingNodes.remove();
			
			System.out.println("Enter left child of "+front.data);
			int leftChild=s.nextInt();
			if(leftChild!=-1)
			{
				BinaryTreeNode<Integer>child=new BinaryTreeNode<Integer>(leftChild);
				pendingNodes.add(child);
				front.left=child;
			}
			System.out.println("Enter right  child of "+front.data);
			int rightChild=s.nextInt();
			if(rightChild!=-1)
			{
				BinaryTreeNode<Integer>child=new BinaryTreeNode<Integer>(rightChild);
				pendingNodes.add(child);
				front.right=child;
			}
		}
		return root;
	}
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root=new BinaryTreeNode<>(1);
		BinaryTreeNode<Integer> node1=new BinaryTreeNode<>(2);
		root.left=node1;
		BinaryTreeNode<Integer> node2=new BinaryTreeNode<>(3);
		root.right=node2;
		Scanner s=new Scanner(System.in);
//		BinaryTreeNode<Integer>node=takeInput(s);
		BinaryTreeNode<Integer>node=takeInputLevelWise();
		printTree(node);
	}

}
