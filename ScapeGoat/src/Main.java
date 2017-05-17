import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanIn = null;
		String str = "";
		
		/* CHANGE THIS TO THE PATH OF YOUR TXT FILE 
		 * 
		 * example: "C:/Users/user/Desktop/test.txt"
		 */
		String fileName = "change this";
		
		int key = 0;
		double alpha = 0;
		Tree tree = null;
		  
		try {
			scanIn = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Invalid file path.");
			e.printStackTrace();
			return;
			
		}
		  
		while(scanIn.hasNextLine()) {
		   str = scanIn.next();
		   
		   switch(str.toLowerCase()) {
			   case "buildtree": {
				   alpha = Double.parseDouble(scanIn.next());
				   key = Integer.parseInt(scanIn.next());
				   tree = new Tree(alpha, key);
				   break;
			   }
			   case "insert": {
				   key = Integer.parseInt(scanIn.next());
				   
				   tree.insert(key);
				   break;
			   }
			   case "delete": {
				   key = Integer.parseInt(scanIn.next());
			     
				   tree.delete(key);
	
				   break;
			   }
			   case "search": {
				   key = Integer.parseInt(scanIn.next());
				   boolean result = tree.search(key);
			     
				   if(result)
					   System.out.println("Found " + key);
				   else
					   System.out.println("Could not find " + key);
			     
				   break;
			   }
			   case "print": {
				   tree.printTree();
			     
				   break;
			   }
			   case "traverse" : {
				   tree.traverse(tree);
				   
				   break;
			   }
			   default : {
				   System.out.println("Invalid command: " + str);
				   return;
			   }
		   }
		}
	}
}
