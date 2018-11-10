/**
 * 
 */
package assignment_5;

import dsaj.queues.*;
import java.util.Random;
import net.datastructures.HeapAdaptablePriorityQueue;
import assignment_5.heapPQwithPrint;
import net.datastructures.Entry;


/**
 * @author ISHUHOME
 *
 */
public class Program {

	public static HeapAdaptablePriorityQueue<Integer, String> heapq2;
	public static heapPQwithPrint heapq;
	public static Entry<Integer, String>[] keyVal;

	public static void main(String[] args) {
		heapq2 = new HeapAdaptablePriorityQueue<>();

		Random r = new Random();
		r.setSeed(0);
		String[] val = new String[8];
		val[0] = "a";
		val[1] = "b";
		val[2] = "c";
		val[3] = "d";
		val[4] = "e";
		val[5] = "f";
		val[6] = "g";
		val[7] = "h";
		Entry<Integer, String>[] entries = new Entry[8];

		entries[0] = heapq2.insert(r.nextInt(11), "a");
		entries[1] = heapq2.insert(r.nextInt(11), "b");
		entries[2] = heapq2.insert(r.nextInt(11), "c");
		
		int hpz = heapq2.size();
		//Entry<Integer, String>[] entries2 = new Entry[hpz];
		for (int j = 0; j < hpz; j++) {
			entries[j] = heapq2.removeMin();
			System.out.print("<" + entries[j].getKey() + ", " + entries[j].getValue() + ">");
		}
		for (int j = 0; j < hpz; j++) {
			entries[j] = heapq2.insert(entries[j].getKey(), entries[j].getValue());
		}
		
		for (int i = 0; i < 5; i++) {

			for (int j = 0; j < heapq2.size(); j++) {
				heapq2.replaceKey(entries[j], (entries[j].getKey() - 1));
			}
			entries[3 + i] = heapq2.insert(r.nextInt(11), val[i + 3]);
			System.out.println("\nPrinting after addition of new key");
			hpz = heapq2.size();
			//Entry<Integer, String>[] entries2 = new Entry[hpz];
			for (int j = 0; j < hpz; j++) {
				entries[j] = heapq2.removeMin();
				System.out.print("<" + entries[j].getKey() + ", " + entries[j].getValue() + "> ");
			}
			for (int j = 0; j < hpz; j++) {
				entries[j] = heapq2.insert(entries[j].getKey(), entries[j].getValue());
			}
			
			System.out.println("\n-------- iteration " + (1 + i) + "------------");

		}
	}

}

//for (Entry<Integer, String> ent : entries) {
//	heapq2.insert(ent.getKey(), ent.getValue());
//}

// System.out.print("<" + entries2[j].getKey() + ", " + entries2[j].getValue() + ">");
//for (int i = 0; i < 5; i++) {
//	Entry<Integer,String>[] entries = heapq2.getAllEntry();
//	for (int j = 0; j < entries.length; j++) {
//		heapq2.replaceKey(entries[j], (entries[j].getKey()-1));
//	}
//	heapq2.insert(r.nextInt(11), val[i+3]);
//	System.out.println("Printing after addition of new key");
//	heapq2.printQ();
//	System.out.println("-------- iteration "+(1+i)+"------------");
//}
//heapq = new HeapAdaptablePriorityQueue<>();
//public static heapPQwithPrint heapq2;
//public static heapPQwithPrint heapq2;
//heapq2 = new heapPQwithPrint<>();
//heapq2 = new heapPQwithPrint<>();
//
//Random r = new Random();
//r.setSeed(0);
//String[] val = new String[8];
//val[0] = "a";
//val[1] = "b";
//val[2] = "c";
//val[3] = "d";
//val[4] = "e";
//val[5] = "f";
//val[6] = "g";
//val[7] = "h";
//
//heapq2.insert(r.nextInt(11), "a");
//heapq2.insert(r.nextInt(11), "b");
//heapq2.insert(r.nextInt(11), "c");
//heapq2.printQ();

//for (int j = 0; j < 5; j++) {
//	int[] key = heapq2.getAllKeys();
//	for (int i = 0; i < key.length; i++) {
//		System.out.println(key[i]);
////		heapq2.replaceKey(key[i], 1+key[i]);
//
//	}
//}
//}

//for (int i = 0; i < 100; i++) {
//	System.out.println(r.nextInt(11));
//	
//}