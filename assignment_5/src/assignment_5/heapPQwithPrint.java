package assignment_5;
import dsaj.queues.*;
import net.datastructures.Entry;
import net.datastructures.HeapAdaptablePriorityQueue;

public class heapPQwithPrint<K, V> extends HeapAdaptablePriorityQueue<K, V>{
	public heapPQwithPrint() {super();}
	
	public void printQ() {
		for (Entry<K, V> entry : heap) {
			System.out.print("<"+entry.getKey()+", "+entry.getValue()+"> ");
			
		}
		if(heap.size()<0) {
			System.out.println("No data to print");
		}
		else {
		
		}
		System.out.println();
	}
	
//	public void decrementBy1() {
//		
//	}
	public Entry[] getAllEntry() {
		Entry[] keys =  new Entry[this.size()];
		int i = 0;
		for (Entry<K, V> entry : heap) {
			keys[i++] =  entry;
		}
		
		return keys;
	}
}
