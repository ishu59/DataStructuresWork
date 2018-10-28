package assignment_4;

import dsaj.trees.*;
import net.datastructures.LinkedBinaryTree;
import net.datastructures.Position;;

public class Program {
	static LinkedBinaryTree<String> tree;

	public static void main(String args[]) {
		System.out.println("hello world");
		tree = new LinkedBinaryTree<>();
		createExpressionTree();

		System.out.println("The value of the final tree is "+calculateExpression(tree, tree.root()));
	}

	public static void createExpressionTree() {
		Position<String> n0 = tree.addRoot("-");
		Position<String> n1 = tree.addLeft(n0, "/");
		Position<String> n3 = tree.addLeft(n1, "*");
		Position<String> n7 = tree.addLeft(n3, "+");
		Position<String> n13 = tree.addLeft(n7, "3");
		Position<String> n14 = tree.addRight(n7, "1");
		Position<String> n8 = tree.addRight(n3, "3");
		Position<String> n4 = tree.addRight(n1, "+");
		Position<String> n9 = tree.addLeft(n4, "-");
		Position<String> n15 = tree.addLeft(n9, "9");
		Position<String> n16 = tree.addRight(n9, "5");
		Position<String> n10 = tree.addRight(n4, "2");

		Position<String> n2 = tree.addRight(n0, "+");
		Position<String> n5 = tree.addLeft(n2, "*");
		Position<String> n11 = tree.addLeft(n5, "3");
		Position<String> n12 = tree.addRight(n5, "-");
		Position<String> n17 = tree.addLeft(n12, "7");
		Position<String> n18 = tree.addRight(n12, "4");
		Position<String> n6 = tree.addRight(n2, "6");

	}

	public static int calculateExpression(LinkedBinaryTree<String> t, Position<String> n) {
		int leftVal, rightVal;
		if (t.isEmpty()) {
			return 0;
		} else {
			if (!isOperator(n.getElement())) {
				return Integer.parseInt(n.getElement());
			} else {
				leftVal = calculateExpression(t, t.left(n));
				System.out.println(leftVal);
				rightVal = calculateExpression(t, t.right(n));
				System.out.println(rightVal);
				System.out.println("printing node element below");
				System.out.println(n.getElement());
				System.out.println("Computing upper 3 values");
				System.out.println("========================");
				System.out.println(compute(leftVal, rightVal, n.getElement()));
				System.out.println("Above Value is after computation");
				System.out.println("========================");
				return compute(leftVal, rightVal, n.getElement());
			}
		}
	}

	public static boolean isOperator(String elem) {
		if (elem == "+" || elem == "-" || elem == "/" || elem == "*")
			return true;
		return false;

	}

	public static int compute(int t1, int t2, String s) {

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
