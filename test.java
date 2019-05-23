import static org.junit.Assert.*;

import org.junit.Test;

public class test {

	@Test
	public void loadTest() {
		int value[]= {10, 101, 33, 24, 5, 89, 50, 30, 21};

		BinaryTreeNode root= BinaryTree.loadData(value);
		int check[]=root.getNodeState();
		
		for(int i=0; i<check.length; i++) {
			assertEquals(value[i], check[i]);
		}

	}

	@Test
	public void sortTest() {
		int values[]= {10, 101, 33, 24, 5, 89, 50, 30, 21};
		int values2[]= {5, 10, 21, 24, 30, 33, 50, 89, 101};

		int[] sortValues= BinaryTree.sort(values);
		
		System.out.println("Test 1");
		BinaryTree.printArray(values);
		System.out.println("Sorted:");
		BinaryTree.printArray(sortValues);
		System.out.println();
		
		for(int i=0; i<sortValues.length; i++) {
			assertEquals(values2[i], sortValues[i]);
		}

	}

	@Test
	public void sameNumberTest() {
		int values[]= {10, 101, 33, 24, 5, 89, 50, 33, 21};
		int values2[]= {5, 10, 21, 24, 33, 33, 50, 89, 101};

		int[] sortValues= BinaryTree.sort(values);
		
		System.out.println("Test 2");
		BinaryTree.printArray(values);
		System.out.println("Sorted:");
		BinaryTree.printArray(sortValues);
		System.out.println();

		for(int i=0; i<sortValues.length; i++) {
			assertEquals(values2[i], sortValues[i]);
		}

	}

	@Test
	public void extremeTest1() {
		int values[]= {10, 101, 33, Integer.MAX_VALUE, 0, 89, 50, Integer.MIN_VALUE, 21};
		int values2[]= {Integer.MIN_VALUE, 0, 10, 21, 33, 50, 89, 101, Integer.MAX_VALUE};

		int[] sortValues= BinaryTree.sort(values);
		
		System.out.println("Test 3");
		BinaryTree.printArray(values);
		System.out.println("Sorted:");
		BinaryTree.printArray(sortValues);
		System.out.println();

		for(int i=0; i<sortValues.length; i++) {
			assertEquals(values2[i], sortValues[i]);
		}

	}

	@Test
	public void extremeTest2() {
		int values[]= {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE};
		int values2[]= {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE};

		int[] sortValues= BinaryTree.sort(values);
		
		System.out.println("Test 4");
		BinaryTree.printArray(values);
		System.out.println("Sorted:");
		BinaryTree.printArray(sortValues);
		System.out.println();

		for(int i=0; i<sortValues.length; i++) {
			assertEquals(values2[i], sortValues[i]);
		}

	}

	@Test
	public void extremeTest4() {
		int values[]= { Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
		int values2[]= { Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};

		int[] sortValues= BinaryTree.sort(values);
		
		System.out.println("Test 5");
		BinaryTree.printArray(values);
		System.out.println("Sorted:");
		BinaryTree.printArray(sortValues);
		System.out.println();

		for(int i=0; i<sortValues.length; i++) {
			assertEquals(values2[i], sortValues[i]);
		}
	}

	@Test
	public void extremeTest5() {
		int values[]= { 0, 0, 0, 0, 0};
		int values2[]= { 0, 0, 0, 0, 0};

		int[] sortValues= BinaryTree.sort(values);
		
		System.out.println("Test 6");
		BinaryTree.printArray(values);
		System.out.println("Sorted:");
		BinaryTree.printArray(sortValues);
		System.out.println();

		for(int i=0; i<sortValues.length; i++) {
			assertEquals(values2[i], sortValues[i]);
		}	
	}

}
