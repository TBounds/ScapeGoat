
public class Main {

	public static void main(String[] args) {
		/*
		 * Slide 9: depth, rebalance on insert.
		 * Slide 14: nodeCount, maxNodeCount, rebalance on deletion
		 * 
		 * Check if you need to rebalance, if you do, find a scapegoat
		 */
		Tree tree = new Tree(0.71f, 9);
		
		tree.insert(tree, 10);
		tree.insert(tree, 11);
		tree.insert(tree, 12);
		tree.insert(tree, 13);
		tree.insert(tree, 14);
		
		tree.traverse(tree);
		
		tree.search(tree, 9);
		
		// System.out.println("tree root = " + tree.getRoot().getKey());
		
		//System.out.println("root = " + root.getParent() + ", data = " + root.getData() + ", left = " + root.getLeft() + ", right = " + root.getRight());
		
	}

}
