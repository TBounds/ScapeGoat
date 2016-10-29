
public class Tree {
	
	private Node root;
	private Float alpha;
	
	public Tree(final float alpha, final int key){
		
		this.alpha = alpha;
		root = new Node(key);
		
	}
	
	//----- Insert -----//
	public void insert(Tree tree, final int key){
		
		if(tree.root == null) return;
		
		Node p = tree.root;
		
		while(true){
			if(key < p.getKey()){ 		
				if(p.getLeft() != null) 
					p = p.getLeft();
				else{
					p.setLeft(new Node(key));
					p.getLeft().setParent(p.getLeft());
					return;
				}
					
			}
			else if(key > p.getKey()){	 
				if(p.getRight() != null) 
					p = p.getRight();
				else{
					p.setRight(new Node(key));
					p.getRight().setParent(p.getRight());
					return;
				}
			}
		}
	}
	
	//----- Tree Search -----//
	public boolean search(final Tree tree, final int key){
		
		if(tree == null){ 
			System.out.println("Tree is null."); // DEBUG
			return false;
		}
		
		return(search(tree.root, key));
		
	}
	
	//----- Node Search -----//
	private boolean search(final Node n, final int key){
		
		if(n == null) return false;
		
		if(n.getKey() == key) return true;
		
		search(n.getLeft(), key);
		search(n.getRight(), key);
		
		return false;
	}
	
	//----- Traverse -----//

}
