
public class Main {

	public static void main(String[] args) {
		/*
		 * Slide 9: depth, rebalance on insert.
		 * Slide 14: nodeCount, maxNodeCount, rebalance on deletion
		 * Slide 18: Flatten
		 * 
		 * XXX Save the -1 nodes in an arraylist, then after the tree is rebuilt, remove them.
		 * 
		 * XXX After deleting something
		 * 	• Decrement size[T]
		 * 	• Then, if size[T] < alpha * max_size[T] rebuild the tree and set max_size[T] = size[T]
		 * 
		 * XXX Everytime the tree is rebuilt, max_size[T] = size[T]
		 * 
		 * Check if you need to rebalance, if you do, find a scapegoat
		 * 
		 * XXX DELETE DOESN'T WORK
		 * 
		 *  tree.insert(tree, 3);
			tree.insert(tree, 0);
			tree.insert(tree, 4);
			tree.insert(tree, 2);
			tree.insert(tree, 5);
			tree.insert(tree, 7);
			tree.insert(tree, 9);
			tree.insert(tree, 8);
			tree.delete(tree, 4);
			tree.traverse();
		 * 
		 * XXX Parents are going to be jacked up. Redo parents from the scapeGoat node.
		 * 
		 * fixParents after delete and rebuild
		 * 
		 */
		
		Tree tree = new Tree(0.5f, 1);
		
//		tree.insert(tree, 3);
//		tree.insert(tree, 0);
//		tree.insert(tree, 4);
//		tree.insert(tree, 2);
//		tree.insert(tree, 5);
		
		//----- Duplicate Nodes -----//
//		tree.insert(tree, 3);
//		tree.insert(tree, 0);
//		tree.insert(tree, 4);
//		tree.insert(tree, 2);
//		tree.insert(tree, 6);
//		tree.insert(tree, 5);
		
		//----- Null Pointer Input -----//
		tree.insert(tree, 3);
		tree.traverse(tree);
		System.out.println("---------------------------------------------");
		tree.insert(tree, 0);
		tree.traverse(tree);
		System.out.println("---------------------------------------------");
		tree.insert(tree, 4);
		tree.traverse(tree);
		System.out.println("---------------------------------------------");
		tree.insert(tree, 2);
		tree.traverse(tree);
		System.out.println("---------------------------------------------");
		tree.insert(tree, 5);
		tree.traverse(tree);
		System.out.println("---------------------------------------------");
		tree.insert(tree, 7);
		tree.traverse(tree);
		System.out.println("---------------------------------------------");
//		tree.insert(tree, 6);
//		tree.traverse(tree);
//		System.out.println("---------------------------------------------");
		tree.insert(tree, 9);
		tree.traverse(tree);
		System.out.println("---------------------------------------------");
		tree.insert(tree, 8);
		tree.traverse(tree);
		System.out.println("---------------------------------------------");
		
		tree.traverse(tree);
		System.out.println("---------------------------------------------");
		tree.printTree(tree);
		System.out.println("---------------------------------------------");

		// System.out.println(tree.search(tree, 5));
		
		// System.out.println("tree root = " + tree.getRoot().getKey());
		
		//System.out.println("root = " + root.getParent() + ", data = " + root.getData() + ", left = " + root.getLeft() + ", right = " + root.getRight());
		
	}

}
