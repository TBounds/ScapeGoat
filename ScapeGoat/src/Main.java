
public class Main {

	public static void main(String[] args) {
		/*
		 * Slide 9: depth, rebalance on insert.
		 * Slide 14: nodeCount, maxNodeCount, rebalance on deletion
		 * Slide 18: Flatten
		 * 
		 * Check if you need to rebalance, if you do, find a scapegoat
		 */
		Tree tree = new Tree(0.5f, 1);
		
		tree.insert(tree, 3);
		tree.insert(tree, 0);
		tree.insert(tree, 4);
		tree.insert(tree, 2);
		tree.insert(tree, 5);
		
		
		// tree.traverse(tree);
		
		// tree.search(tree, 9);
		
		// System.out.println("tree root = " + tree.getRoot().getKey());
		
		//System.out.println("root = " + root.getParent() + ", data = " + root.getData() + ", left = " + root.getLeft() + ", right = " + root.getRight());
		
	}

}
