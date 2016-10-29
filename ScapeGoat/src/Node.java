
public class Node {
	
	private int key;
	
	private Node parent;
	private Node left;
	private Node right;
	
	public Node(int k){
		key = k;
		parent = null;
		left = null;
		right = null;
	}
	
	
	//----- Setters and Getters -----//
	public int getKey()	{ return key; }
	public Node getParent() { return parent; }
	public Node getLeft() 	{ return left; }
	public Node getRight() 	{ return right; }
	
	public void setData(int k)		{ key = k; }
	public void setParent(Node p) 	{ parent = p; }
	public void setLeft(Node l) 	{ left = l; }
	public void setRight(Node r) 	{ right = r; }

}
