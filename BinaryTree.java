import java.util.*;


public class BinaryTree {
	private static BinaryTreeNode root= null;
	private static Map< Integer,BinaryTreeNode> map =  new HashMap< Integer,BinaryTreeNode>();
	
	//Binary Tree is built with sequence index manner
	//               0
	//             1     2
	//           3   4  5  6
	//          7  8
	public static int[] sort(int[] arr) {

		int size = arr.length; 
		
		// Create returned result in same size
		int[] sorted= new int[size];
		
		// Build a descent Binary Tree based on array
		BinaryTreeNode root=loadData(arr);
		
		// Search the smallest non-leaf 
		int lastNonLeaf= size/2-1;

		// push the first highest value up to root
		for( int i= lastNonLeaf; i>=0; i--) {
			BinaryTreeNode minimalNonLeaf=map.get(i);
			minimalNonLeaf.compare();
			
		}

		
		// cutting the size of binary tree each loop
		for( int i=size-1; i>0; i--) {
			// point to the last leaf node
			BinaryTreeNode smallest= map.get(i);
			
			// record the root (highest number)
			sorted[i]= root.getValue();
			
			// swap the last leaf with root
			root.setValue(smallest.getValue());
			
			// removing the root, cut the size of binary tree
			smallest.getParent().killNode(smallest);
			map.remove(i);
		
			// push up the next level higher value in top to down manner 
			root.compare(); 	   
		}
		
		// check in the last root
		sorted[0]=root.getValue();
		
		return sorted;
	}

	public static BinaryTreeNode loadData(int[] arr) {
		return new BinaryTreeNode( arr, 0, map, null);
	}
	
	private static void print() {
		Set< Map.Entry< Integer, BinaryTreeNode> > st = map.entrySet();    
		
		for (Map.Entry< Integer, BinaryTreeNode> me:st) 
		{ 
			System.out.print(me.getValue().getValue()+", "); 
		} 
		System.out.println();
	}
	
	public static void printArray(int[] arr) {  
		
		for (int i=0; i<arr.length-1; i++) 
		{ 
			System.out.print(arr[i]+", "); 
		} 
		System.out.println(arr[arr.length-1]);
	}
	
	public int[] getNodeState() {
		Set< Map.Entry< Integer, BinaryTreeNode> > st = map.entrySet();    
		int[] arr= new int[map.size()];
		int index=0;
		for (Map.Entry< Integer, BinaryTreeNode> me:st) 
		{ 
			arr[index]=me.getValue().getValue();
			index++;
		} 
		return arr;
	}

}
