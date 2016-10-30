import java.util.List;

public class Tree {
	
	private boolean found;	// Test
	private Node root;
	private Float alpha;
	private int maxNodeCount, nodeCount;
	
	//----- Tree Constructor -----//
	public Tree(final float alpha, final int key){
		
		this.alpha = alpha;
		root = new Node(key);
		
		nodeCount = 1;
		maxNodeCount = 1;
		
	}
	
	//----- Insert -----//
	public void insert(Tree tree, final int key){
		
		if(tree.root == null) return;
		
		nodeCount++;
		maxNodeCount = Math.max(maxNodeCount, nodeCount);
		
		Node p = tree.root;
		
		while(true){
			if(key < p.getKey()){ 		
				if(p.getLeft() != null) 
					p = p.getLeft();
				else{
					p.setLeft(new Node(key));
					p.getLeft().setParent(p);
					
					if(tooDeep(p.getLeft()))
						findScapeGoat(tree, p.getLeft()); 
					
					return;
				}
					
			}
			else if(key > p.getKey()){	 
				if(p.getRight() != null) 
					p = p.getRight();
				else{
					p.setRight(new Node(key));
					p.getRight().setParent(p);
					
					if(tooDeep(p.getRight()))
						findScapeGoat(tree, p.getRight());
					
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
		
		// System.out.println("Node = " + key + " size = " + (size(search(tree.root, key))));	// DEBUG
		
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
		
		// DEBUG
		// if(n.getParent() != null) System.out.println(n.getKey() + ", parent = " + n.getParent().getKey()); 
		// else System.out.println(n.getKey() + ", parent = null");
		
		traverse(n.getLeft());
		traverse(n.getRight());
		
		return;
	}

	//----- Tree Delete -----//
	public void delete(final Tree tree, final int key){
		
		Node toDelete, replacement;
		
		if(tree == null){
			System.out.println("DELETE: tree is null.");
			return;
		}

		delete(tree, tree.root, key);
	}
	
	//----- Node Delete -----//
	private void delete(final Tree tree, final Node root, final int key){
		
		Node toDelete, replacement;
		
		// Find which node to delete.
		if((toDelete = search(root, key)) != null){
			
			nodeCount--;
			
			// Find it's replacement node.
			replacement = findReplacement(toDelete);
			
			// Deleting a node that is not the root.
			if(toDelete.getParent() != null){
				
				// Node to be deleted is a left child
				if(toDelete.getKey() < toDelete.getParent().getKey()){
					
					// Parent of node to delete points to the replacement node.
					// Take into account toDelete might == replacement
					if(toDelete != replacement && toDelete.getParent() != null)
						toDelete.getParent().setLeft(replacement);
					else{
						toDelete.getParent().setLeft(null);
					}
						
				}
				// Node to be deleted is a right child
				else{
					
					// Parent of node to delete points to the replacement node.
					// Take into account toDelete might == replacement
					if(toDelete != replacement && toDelete.getParent() != null)
						toDelete.getParent().setRight(replacement);
					else
						toDelete.getParent().setRight(null);
				}
			}
			// Deleting the root.
			else{
				if(replacement != toDelete){
					// If the replacement is a left/right child, set the parent's left/right child to null. 
					if(replacement.getKey() < replacement.getParent().getKey())
						replacement.getParent().setLeft(null);
					else
						replacement.getParent().setRight(null);
					
					replacement.setParent(null);
					
					
					// Replace the tree's root.
					tree.setRoot(replacement);
				}
				else{
					// Remove the tree's root.
					tree.setRoot(null);
				}
				
			}
			
			// Change to parent to the children of the node to be deleted to the replacement node.
			if(toDelete.getLeft() != null)
				toDelete.getLeft().setParent(replacement);
			if(toDelete.getRight() != null)
				toDelete.getRight().setParent(replacement);
			
			// Make sure the replacement node doesn't point to itself.
			if(toDelete.getLeft() != replacement)
				replacement.setLeft(toDelete.getLeft());
			if(toDelete.getRight() != replacement)
				replacement.setRight(toDelete.getRight());

		}
		
	}
	
	//----- Node FindReplacement -----//
	private Node findReplacement(final Node n){
		
		Node replacement = null;
		
		if(n.getLeft() == null && n.getRight() == null && replacement == null) return n;
		if(n.getLeft() == null && n.getRight() != null && replacement == null)
			replacement = findReplacement(n.getRight());
		if(n.getLeft() != null && replacement == null) 
			replacement = findReplacement(n.getLeft());
		
		return replacement;
		
	}
	
	//----- Size -----//
	/* Change to private */
	private int size(Node n){
		if(n == null) return 0;
		return (size(n.getLeft()) + size(n.getRight()) + 1);
	}
	
	//----- checkDepth -----//
	private boolean tooDeep(Node n){
		
		if(n == null) return false;
		
		Node p = n;
		int count = 0; 
		
		while(p.getParent() != null){
			count++;
			p = p.getParent();
		}
		
		System.out.println("node = " + n.getKey() + ", count = " + 1 + ", node Count = " + getNodeCount() + ", math thing = " + ((Math.log(getNodeCount())/Math.log(1/alpha))));	// DEBUG
		
		if(count > (Math.log(getNodeCount())/Math.log(1/alpha)))
			return true;
		else
			return false;
		
	}
	
	//----- Find the ScapeGoat -----//
	private Node findScapeGoat(Tree tree, Node n){
		Node scapeGoat = null;
		Node p = null;
		
		if(n.getParent() != null) 
			p = n.getParent();
		
//		int size, sizeL, sizeR;
//		size = size(p);
		
		while(p.getParent() != null){
			if((size(p.getLeft()) <= tree.alpha * size(p)) &&
					(size(p.getRight()) <= tree.alpha*size(p))){
				scapeGoat = p;
			}
			p = p.getParent();
			
			// DEBUG
//			if(scapeGoat != null)
//				System.out.println("scapeGoat = node " + scapeGoat.getKey());
//			else
//				System.out.println("ScapeGoat == null.");
		}
		
		
		
		return scapeGoat;
	}

	//-----  Flatten -----//
	private List<Node> flatten(Node n, List<Node> subtreeList){
		
		if(n == null) return null;
		
		flatten(n.getLeft(), subtreeList);
		subtreeList.add(n);
		flatten(n.getRight(), subtreeList);
		
		return subtreeList;
		
	}
	
	//----- Setters and Getters -----//
	public Node getRoot() { return root; }
	private void setRoot(Node n) { root = n; }
	
	private int getMaxNodeCount() { return maxNodeCount; }
	private void setMaxNodeCount(int val) { maxNodeCount = val; }
	
	private int getNodeCount() { return nodeCount; }
	private void setNodeCount(int val) { nodeCount = val; }
	
}
