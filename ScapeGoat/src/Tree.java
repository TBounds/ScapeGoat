public class Tree {
	
	private Node root;
	private double alpha;
	private int maxNodeCount, nodeCount;
	
	//----- Tree Constructor -----//
	public Tree(final double alpha, final int key){
		
		this.alpha = alpha;
		root = new Node(key);
		
		nodeCount = 1;
		maxNodeCount = 1;
		
	}
	
	//----- Insert -----//
	public void insert(final int key){
		
		if(this.root == null) return;
		
		nodeCount++;
		maxNodeCount = Math.max(maxNodeCount, nodeCount);
		
		Node p = this.root;
		
		while(true){
			if(key < p.getKey()){ 		
				if(p.getLeft() != null) 
					p = p.getLeft();
				else{
					p.setLeft(new Node(key));
					p.getLeft().setParent(p);
					
					// Check if the inserted node is too deep.
					if(tooDeep(p.getLeft())){
						
						Node SG = findScapeGoat(p.getLeft());
						
						if(SG != null)
							rebuildTree(SG);
					}
					
					return;
				}
				
			}
			else if(key > p.getKey()){	 
				if(p.getRight() != null) 
					p = p.getRight();
				else{
					p.setRight(new Node(key));
					p.getRight().setParent(p);
					
					if(tooDeep(p.getRight())){

						Node SG = findScapeGoat(p.getRight());
						
						if(SG != null)
							rebuildTree(SG); 
					}
					
					return;
				}
			}
		}
	}
	
	//----- Tree Search -----//
	public boolean search(final int key){
		
		if(this.root == null){ 
			return false;
		}
		
		if(search(this.root, key) == null) return false;
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
		
		//System.out.println(n.getKey());
		
		// DEBUG
		if(n.getParent() != null) System.out.print(n.getKey() + ": parent = " + n.getParent().getKey()); 
		else System.out.print(n.getKey() + ": parent = null");
	
		if(n.getLeft() != null) System.out.print(", left child = " + n.getLeft().getKey() + " "); 
		else System.out.print(", left child = null ");
		
		if(n.getRight() != null) System.out.print(", right child = " + n.getRight().getKey() + " "); 
		else System.out.print(", right child = null ");
		
		System.out.println(" ");
		
		traverse(n.getLeft());
		traverse(n.getRight());
		
		return;
	}

	//----- Delete -----//
	public void delete(int key){
		
		if(search(this.root, key) != null){
			
			if(root.getLeft() == null && root.getRight() == null) // Delete the root
				root = null;
			else{
				this.delete(this.root, key);
				nodeCount--;
	    
				if(nodeCount <= alpha*maxNodeCount){
					Node flattenedList = flatten(root);
	     
					buildTree(flattenedList, size(flattenedList));
					maxNodeCount = nodeCount;
				}
	    
				fixParents(this.root);
			}
		}
	}
	 
	//----- Delete -----//
	private void delete(Node n, int key){
		if(key < n.getKey())
			delete(n.getLeft(), key);
		else if(key > n.getKey())
			delete(n.getRight(), key);
		else{
			if(n.getLeft() != null && n.getRight() != null){ // Left & Right Children
				Node successor = findReplacement(n.getRight());
				n.setKey(successor.getKey());
				delete(successor, successor.getKey());
			}
			else if(n.getLeft() != null){		// Left Child
				replaceNodeInParent(n, n.getLeft());
			}
			else if(n.getRight() != null){	// Right child
				replaceNodeInParent(n, n.getRight()); 
			}
			else{ 							// No children
				replaceNodeInParent(n, null);
			}
		}
	}
	
	//----- Replace Parent Node -----//
	private void replaceNodeInParent(Node root, Node newValue){
		if(root.getParent() != null){
			if(root == root.getParent().getLeft())
				root.getParent().setLeft(newValue);
			else
				root.getParent().setRight(newValue);
		}
		if(newValue != null)
			newValue.setParent(root.getParent());
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
		
		if(count > Math.floor((float)(Math.log(getNodeCount())/Math.log((float)1/alpha))))
			return true;
		else
			return false;
		
	}
	
	//----- Find the ScapeGoat -----//
	private Node findScapeGoat(Node n){
		Node scapeGoat = null;
		Node p = null;
		
		// scapeGoat needs to start above the node passed in.
		if(n.getParent() != null) 
			p = n.getParent();
		
		// Find the scapeGoat nearest to the root (but not the root).
		while(p != null){
			
			if((size(p.getLeft()) <= this.alpha * size(p)) && (size(p.getRight()) <= this.alpha*size(p))){
				
				scapeGoat = p;
			}
			
			if(p.getParent() != null)
				p = p.getParent();
			else
				p = null;
			
			// DEBUG
//			if(scapeGoat != null)
//				System.out.println("scapeGoat = node " + scapeGoat.getKey());
//			else
//				System.out.println("ScapeGoat == null.");
			
		}
		
		return scapeGoat;
	}

	//----- Rotate Left -----//
	public Node leftRotate(Node n){
		if(n.getRight() != null){
			Node rightChild = n.getRight();
			n.setRight(rightChild.getRight());
			rightChild.setRight(rightChild.getLeft());
			rightChild.setLeft(n.getLeft());
			n.setLeft(rightChild);
   
			int temp = n.getKey();
			n.setKey(rightChild.getKey());
			rightChild.setKey(temp);
		}
		return n;
	}
	 
	//----- Rotate Right -----//
	public Node rightRotate(Node n){
		if(n.getLeft() != null){
			Node leftChild = n.getLeft();
			n.setLeft(leftChild.getLeft());
			leftChild.setLeft(leftChild.getRight());
			leftChild.setRight(n.getRight());
			n.setRight(leftChild);
	   
			int temp = n.getKey();
			n.setKey(leftChild.getKey());
			leftChild.setKey(temp);
		}
		return n;
	}
	 
	//----- Flatten -----//
	public Node flatten(Node n){
		
		while(n.getLeft() != null){
			n = rightRotate(n);
		}
		
		if (n.getRight() != null){
			n.setRight(flatten(n.getRight()));
		}
		
		return n;
	}
	 
	//----- Build Tree -----//
	public Node buildTree(Node n, int nodeCount){
		int times = (int) ((int)Math.log(nodeCount)/Math.log(2));
		
		Node newRoot = n;
		
		for(int i = 0; i < times; i++){
			newRoot = leftRotate(newRoot);
			n = newRoot.getRight();
			
			for(int j = 0; j < nodeCount/2 - 1; j++){
				n = leftRotate(n);
				n = n.getRight();
			}
			nodeCount >>= 1;
		}
		return newRoot;
	}
	 
	//----- Rebuild -----//
	private void rebuildTree(Node scapeGoat){
		
		Node z = flatten(scapeGoat);
		
		buildTree(z, size(scapeGoat));
		
		// fixParents(scapeGoat);
		
	}
	
	//----- Tree Print Tree -----//
	public void printTree() {
		
		if(this.root != null)
			printTree(this.root, 0);
	}
	
	//----- Node Print Tree -----//
	public void printTree(final Node n, int level){
		
		if(n == null) return;
		
		if(n.getRight() != n)
			printTree(n.getRight(), level + 1);
		else{
			n.setRight(null);
		}
		for(int i = 0; i < level*3; i++) System.out.print(" ");
		System.out.println(n.getKey());
		printTree(n.getLeft(), level + 1);
		
		return;
	}
	
	//----- Fix Parents -----//
	public void fixParents(Node n){
		
		if(n == null) return;
		
		// Fix parents.
		if(n.getLeft() != null) n.getLeft().setParent(n);
		if(n.getRight() != null) n.getRight().setParent(n);
		
		fixParents(n.getLeft());
		fixParents(n.getRight());
		
		return;
		
	}
	
	
	//----- Setters and Getters -----//
	public Node getRoot() { return root; }
//	private void setRoot(Node n) { root = n; }
	
//	private int getMaxNodeCount() { return maxNodeCount; }
//	private void setMaxNodeCount(int val) { maxNodeCount = val; }
	
	private int getNodeCount() { return nodeCount; }
//	private void setNodeCount(int val) { nodeCount = val; }
	
}
