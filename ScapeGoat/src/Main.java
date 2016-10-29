
public class Main {

	public static void main(String[] args) {
		
		Tree tree = new Tree(0.71f, 9);
		
		System.out.println(tree.search(tree, 8));
		System.out.println(tree.search(tree, 9));
		
		tree.insert(tree, 10);
		tree.insert(tree, 7);
		tree.insert(tree, 11);
		tree.insert(tree, 2);
		
		tree.traverse(tree);
		
		System.out.println(tree.search(tree, 10));
		System.out.println(tree.search(tree, 2));
		System.out.println(tree.search(tree, 3));
		
		//System.out.println("root = " + root.getParent() + ", data = " + root.getData() + ", left = " + root.getLeft() + ", right = " + root.getRight());
		
	}

}
