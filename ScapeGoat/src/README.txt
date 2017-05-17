Author: Tyler Bounds
Class: CS 450
Date: 11/2/2016
E-mail: tyler.bounds@wsu.edu
Worked with: Stephen Brown, Jordan Curry, and Chris Hight.

#################
### IMPORTANT ###
#################

I replaced the algorithm's flatten, rebuild, and build with an implementation of the Day Stout Warren 
algorithm. We asked Professor Mocas if this was satisfactory and she said as long as the algorithm 
was in place that it would be acceptable.
		   
The program does still find the scapegoat and re-balance based on that.

##############
### Credit ###
##############

I based the delete function from the wikipedia page for binary trees.
	- https://en.wikipedia.org/wiki/Binary_search_tree

###################
### Description ###
###################

This program takes a text file for input which contains commands on each line. The first command needs
to be buildtree <alpha> <key> and should only be called once.

This program outputs to the console the tree as if it were rotated left onto its side.

This program is a self-balancing, binary search tree which mostly implements the ScapeGoat algorithm
but also implements the Day Stout Warren for rebuild, build, and flatten.

This program checks if the inserted node is too deep, based on the alpha weight, finds the scapegoat,
and then rebalances on that scapegoat.

This program checks if the deleted node distrupts the balance and re-balances from the root if it is.

#####################
### Command Input ###
#####################

• buildtree <alpha> <key>
	- Creates the tree with alpha value and root = key.

• insert <key>
	- Inserts a node into the tree with the key value.

• delete <key>
	- Deletes a node from the tree that has the key value.

• print
	- Prints the tree in on its side. If you mentally rotate the tree 90 degrees to the right, 
	  it would be orientated like normal, with its root at the top and its branches descending down.

• traverse
	- Prints the tree in in a series of lines: node, node's parent, node's left child, node's right child.

######################
### Files Included ###
######################

• Main.java
	- The main class which the user will run the program from. Handles the input to the program.

• Node.java
	- Contains the description for the node objects.

• Tree.java
	- Contains the description for the tree object and the functions for manipulating the tree.

• README.txt
	- This file which contains author's contact info, credits, notes, program description, and instructions
	  to run load and run the program.

##############################################		
### Loading/Running the Program in Eclipse ###
##############################################

1. Download program, an archive file (.zip)
2. Run Eclipse and create a new Java project named whatever you want.
3. Right-click in the Package Explorer and select Import.
4. Expand General and select Archive File.
5. Select Browse and navigate to where you downloaded the project.
6. Select Finish
7. In the Package Explorer, expand the folder the project imported to.
8. If the files are not under the src folder, select them all, drag and drop them on src.
9. Expand the src folder and the (default package) to reveal the files.
10. Double click Main.java
11. Edit Main.java and change the filename to the input text file path.
	Example: fileName = "C:/Users/user/Desktop/test.txt"
12. Click the green circle with the white arrow at the top of Eclipse
13. Observe output in the console.

###############################################
### Loading/Running the Program in NetBeans ###
###############################################

The project is in Java, and was made using Eclipse. Below are instructions for building
the project in Netbeans which is available on the lab computers using Windows:

1. Take the included .zip file ScapeGoatTree and place it somewhere accessible.
2. Unzip the folder into your chosen directory.
3. Open Netbeans, go to file > Eclipse Project...
4. Click on "Import Project ignoring Project Dependencies".
5. Browse "Project to Import", go into the unzipped ScapeGoatTree folder and click on the ScapeGoat folder and press "open".
6. Then Browse for a destination folder to store the imported files (You can choose the same folder if you like).
7. After the project is imported, go into Scapegoat > src > scapeGoat > Main.java.
8. Change the variable "fileName" in the Main.java class to the directory where your text file is.
9. After that, click on the green arrow and "run" the project.
10. The output is then displayed in the console.

*** E-mail me with any questions/concerns.
            