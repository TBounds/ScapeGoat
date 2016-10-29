
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
		
		if(search(tree.root, key) == null) return false;
		else return true;
		
	}
	
	//----- Node Search -----//
	private Node search(final Node n, final int key){
		
		Node found = null;
		
		if(n == null) return null;
		if(n.getKey() == key) return n;
		
		found = search(n.getLeft(), key);
		if(found == null)
			found = search(n.getRight(), key);
		
		return(found);
	
	}
	
	//----- Tree Traverse -----//
	public void traverse(final Tree tree){
		
		if(tree == null){
			System.out.println("TRAVERSE: null tree.");
			return;
		}
		
		traverse(tree.root);
		
	}
	//----- Node Traverse -----//
	private void traverse(final Node n){
		
		if(n == null) return;
		
		System.out.println(n.getKey());
		traverse(n.getLeft());
		traverse(n.getRight());
		
		return;
	}

	//----- Tree Delete -----//
//	public void delete(final Tree tree, final int key){
//		if(tree == null){
//			System.out.println("DELETE: tree is null.");
//			return;
//		}
//		
//		delete(tree.root, key);
//	}
//	
//	private void delete(final Node n, ){
//		
//	}
	
}
