package homework2;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
		Random r = new Random();
		r.setSeed(99);

        System.out.println("---------------");
        System.out.println();
		CircularDoublyLinkedList<Double> list = new CircularDoublyLinkedList<>();
//      list.insertNode(new Double(10));
//      list.insertNode(new Double(11));
//		list.insertNode(new Double(1));
//		list.insertNode(new Double(2));
//		list.insertNode(new Double(7));
//		list.insertNode(new Double(8));
//		list.insertNode(new Double(6));
//		list.insertNode(new Double(3));
//		list.insertNode(new Double(8));insertionSort
//		list.insertNode(new Double(4));

        System.out.println("A:- Adding 5 random numbers to list");
        for(int k=0;k<5;k++){
            list.insertNode(new Double(r.nextDouble()));
        }
        System.out.println("\n\n");
        System.out.println("B:- Printing the List");
		list.printList();
        System.out.println("\n\n");

		System.out.println("Printing current");
		list.showCurrent();
        System.out.println("Printing current");

		double maxVal = Double.MIN_VALUE;
		Double maxNode = null;

		for(int i=0; i<list.size(); i++) {
			if(list.getCurrentElement() > maxVal) {
				maxVal = list.getCurrentElement();
			}
			list.moveCurrentByOne("F");
		}

		//initializing number of iterations as the list size decreases with each deletion
		int itrNum = list.size();
		for(int j=0; j<itrNum; j++) {
			System.out.println("curr: "+list.getCurrentElement()+"\tmax: "+maxVal+"\tj:"+j);
			if(list.getCurrentElement() == maxVal) {
				list.moveCurrentByOne("B");
				list.removeCurrent();
				list.printList();
			}
			list.moveCurrentByOne("F");
		}
        System.out.println();
		System.out.print("D:- Printing Final list: ");
		list.printList();
		System.out.println("Printing current");
		list.showCurrent();


		System.out.println("\n\n");
        System.out.println("-------Implementing insertion sort for extra points------");
        System.out.println("\n-------Inserting 10 more random elements for display of sorting------");

		for(int k =0;k<10;k++){
		    list.insertNode(r.nextDouble());
        }
        System.out.println("\n-------List before sort------");
        list.printList();

        list.insertionSort();
        System.out.println("\n-------List After sort------");
        list.printList();
        System.out.println();


	}
}
