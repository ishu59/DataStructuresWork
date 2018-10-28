package assignment_4;

import dsaj.trees.*;
import net.datastructures.LinkedBinaryTree;
import net.datastructures.Position;;

public class ExpressionTree {
	LinkedBinaryTree<String> tree;

	public ExpressionTree() {
		tree = new LinkedBinaryTree<>();
	}

	public void createExpressionTree() {
		Position<String> n0 = tree.addRoot("-");
		Position<String> n1 = tree.addLeft(n0, "/");
		Position<String> n2 = tree.addRight(n0, "+");
		Position<String> n3 = tree.addLeft(n1, "*");
		Position<String> n4 = tree.addRight(n1, "+");
		Position<String> n5 = tree.addLeft(n2, "*");
		Position<String> n6 = tree.addRight(n2, "6");
		Position<String> n7 = tree.addLeft(n3, "+");
		Position<String> n8 = tree.addRight(n3, "3");
		Position<String> n9 = tree.addLeft(n4, "-");
		Position<String> n10 = tree.addRight(n4, "2");
		Position<String> n11 = tree.addLeft(n5, "3");
		Position<String> n12 = tree.addRight(n5, "-");
		Position<String> n13 = tree.addLeft(n7, "3");
		Position<String> n14 = tree.addRight(n7, "1");
		Position<String> n15 = tree.addLeft(n9, "9");
		Position<String> n16 = tree.addRight(n9, "5");
		Position<String> n17 = tree.addLeft(n10, "7");
		Position<String> n18 = tree.addRight(n10, "4");
		
		

	}

	public int calculateExpression(LinkedBinaryTree<String> t,Position<String> n) {
		
		return 1;
	}

//	Let t be the expression tree
//	If  t is not null then
//	      If t.value is operand then  
//	                Return  t.value
//	      A = solve(t.left)
//	      B = solve(t.right)
//	 
//	      // calculate applies operator 't.value' 
//	      // on A and B, and returns value
//	      Return calculate(A, B, t.value)  
	public void traverse(LinkedBinaryTree<String> t,Position<String> n) {
		
		
	}
	public int compute(int t1, int t2, String s) {

		switch (s) {
		case "+":
			return t1 + t2;
		case "-":
			return t1 - t2;
		case "/":
			return t1 / t2;
		case "*":
			return t1 * t2;
		default:
			return 0;
		}
	}

}
