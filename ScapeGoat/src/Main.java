
public class Main {

	public static void main(String[] args) {
		
		Node root = new Node(9, null);
		
		root.setLeft(new Node(11, root));
		
		System.out.println("root = " + root.getParent() + ", data = " + root.getData() + ", left = " + root.getLeft() + ", right = " + root.getRight());
		
	}

}
