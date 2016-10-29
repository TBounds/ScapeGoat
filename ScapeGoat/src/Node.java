
public class Node {
	
	private int data;
	
	private Node parent;
	private Node left;
	private Node right;
	
	public Node(int d, Node p){
		data = d;
		parent = p;
		left = null;
		right = null;
	}
	
	//----- Setters and Getters -----//
	public int getData()	{ return data; }
	public Node getParent() { return parent; }
	public Node getLeft() 	{ return left; }
	public Node getRight() 	{ return right; }
	
	public void setData(int d)		{ data = d; }
	public void setParent(Node p) 	{ parent = p; }
	public void setLeft(Node l) 	{ left = l; }
	public void setRight(Node r) 	{ right = r; }
	


}
