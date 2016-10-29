
public class Tree {
	
	private boolean found;	// Test
	private Node root;
	private Float alpha;
	
	//----- Tree Constructor -----//
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
					p.getLeft().setParent(p);
					return;
				}
					
			}
			else if(key > p.getKey()){	 
				if(p.getRight() != null) 
					p = p.getRight();
				else{
					p.setRight(new Node(key));
					p.getRight().setParent(p);
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
		
		return(search(n.getLeft(), key)||search(n.getRight(), key));
	
	}
	
	//----- Tree Traverse -----//
	public void traverse(final Tree tree){
		
		if(tree == null){
			System.out.println("TRAVERSE: null tree.");
			return;
		}
		
		traverse(tree.root);
		
	}
	//----- Tree Traverse -----//
	private void traverse(final Node n){
		
		if(n == null) return;
		
		System.out.println(n.getKey());
		traverse(n.getLeft());
		traverse(n.getRight());
		
		return;
	}

}
