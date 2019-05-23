import static org.junit.jupiter.api.Assumptions.assumingThat;

import java.util.Map;
import java.util.Set;

class BinaryTreeNode
{ 
    private int value;
    private int index;
    private BinaryTreeNode left, right;
    private BinaryTreeNode parent; 
    private Map< Integer,BinaryTreeNode> map;
  
    public BinaryTreeNode(int[] values, int index, Map< Integer,BinaryTreeNode> map, BinaryTreeNode parent) 
    { 
        this.value= values[index];
        this.index= index;
        this.parent= parent;
        this.map=map;
        
        // map the index of binary node as key
        map.put(this.index, this);
        
        // build the leaf under the node
        this.makeLeaf(values,map);
    }
    
    public int getIndex() {
    	return this.index;
    }
    
    public int getValue() {
    	return this.value;
    }
    
    public void setValue(int value) {
    	this.value= value;
    }
    
    public BinaryTreeNode getParent() {
    	return this.parent;
    }
    
    // create children for specific node
    private void makeLeaf(int[] values, Map< Integer,BinaryTreeNode> map) {
    	int size= values.length;
    	
    	// index built of left and right should be to next binary level
    	int left= this.index*2+1;
    	int right= this.index*2+2;
    	
    	// the tree should stop growing outside the size of given elements
    	if(left<size) this.left = new BinaryTreeNode( values, left, map, this);
    	if(right<size) this.right = new BinaryTreeNode( values, right, map, this); 
    }
    
    // check if left children exist
    private boolean checkLeft() {
    	return (this.left!=null);
    }
    
    // check if right children exist
    private boolean checkRight() {
    	return (this.right!=null);
    }
    
    // switch the current node value with another specific node
    private void swap(BinaryTreeNode node) {
    	int temp=this.getValue();
    	this.setValue(node.getValue());
    	node.setValue(temp);
    }
    
    public void compare() {
    	BinaryTreeNode higher= this;
    	
    	// compare the parent node and two children nodes and store the largest in "higher"
    	if(checkLeft()&&higher.getValue()<this.left.getValue()) higher=this.left;
    	if(checkRight()&&higher.getValue()<this.right.getValue()) higher=this.right;
    	
    	// if "higher" is not the parent node, swap the largest one with the parent node
    	if(higher!=this) {
    		this.swap(higher);   
    		
    	// compare further the node that is swap with lower value
    		higher.compare();
    	}
    }
    
    // demolish the specific node
    public void killNode(BinaryTreeNode last) {
    	if(this.checkRight()&& this.right.equals(last)) this.right=null;
    	if(this.left.equals(last)) this.left=null;
    }
    
    public int[] getNodeState() {
		Set< Map.Entry< Integer, BinaryTreeNode> > st = this.map.entrySet();    
		int[] arr= new int[this.map.size()];
		int index=0;
		for (Map.Entry< Integer, BinaryTreeNode> me:st) 
		{ 
			arr[index]=me.getValue().getValue();
			index++;
		} 
		return arr;
	}
    
} 