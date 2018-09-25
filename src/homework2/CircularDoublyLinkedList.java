package homework2;

public class CircularDoublyLinkedList<T extends Comparable> {
	protected Node<T> current;
	private int size = 0;
	
	private static class Node<T>{
		//#prod
	    private T element;

        private Node<T> next;
		private Node<T> prev;
		
		public Node(T e, Node<T> n, Node<T> p) {
			element = e;
			next = n;
			prev = p;
		}
		
		public Node(T e) {
			element = e;
			next = null;
			prev = null;
		}
	}
	
	/**
	 * Shows the current node.
	 */
	public void showCurrent() {
		if(isEmpty()) {
			System.out.println("List is empty.");
			return;
		}
		if(size()>2) {
			printElement(this.current.prev.element);
		}
		printElement(this.current.element);
		printElement(this.current.next.element);
	}
	
	/**
	 * Inserts new node before the current node.
	 * 
	 * @param element   This is the element to be 
	 *					inserted into the list.
	 */
	public void insertBeforeCurrent(T element) {
		if(isEmpty()) {
			System.out.println("List is empty.");
			return;
		}
		Node<T> newNode;
		newNode = new Node(element, this.current, this.current.prev);
		this.current.prev = newNode;
		this.current.prev.prev.next = newNode;
		this.size++;
	}
	
	/**
	 * Inserts new node after the current node.
	 *
	 * @param element   This is the element to be 
	 *					inserted into the list.
	 */
	public void insertAfterCurrent(T element) {
		if(isEmpty()) {
			System.out.println("List is empty.");
			return;
		}
		Node<T> newNode;
		newNode = new Node(element, this.current.next, this.current);
		this.current.next = newNode;
		this.current.next.next.prev = newNode;
		this.size++;
	}
	
	/**
	 * Moves the current node by one place depending 
	 * on direction value passed.
	 * 
	 * @param direction This is direction of current.  
	 *                  Can have values 'F' or 'B'.
	 *                
	 */
	public void moveCurrentByOne(String direction) {
		if(isEmpty()) {
			System.out.println("List is empty.");
			return;
		}
		if(direction == null ||  (!"F".equals(direction.trim()) && !"B".equals(direction.trim())) ) {
			System.out.println("Please choose direction 'F' or 'B'");
			return;
		}
		switch(direction.trim()) {
			case "F":
				this.current = this.current.next;
				break;
			case "B":
				this.current = this.current.prev;
				break;
			default:
				System.out.println("Invalid input.");
		}
	}
	
	/**
	 * Removes the node pointed by current and points 
	 * current to next of the removed node.
	 */
	public T removeCurrent() {
		this.printList();
		if(isEmpty()) {
			System.out.println("List is empty");
			return null;
		}
		this.current.prev.next = this.current.next;
		this.current.next.prev = this.current.prev;
		this.size--;
		T removedElement = this.current.element;
		
		Node<T> tempNode = this.current;
		this.current = this.current.next;
		tempNode.next = null;
		tempNode.prev = null;
		System.out.println("removed: "+removedElement.toString());
		return removedElement;
	}
	
	/**
	 * Returns size of the circularDoublyLinkedList.
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Returns the element at the current node.
	 */
	public T getCurrentElement() {
		return this.current.element;
	}
	
	/**
	 * Prints the entire circularDoublyLinkedList.
	 */
	public void printList() {
		if(isEmpty()) {
			System.out.println("List is empty");
			return;
		}
		Node<T> temp = this.current;
		for(int i=0; i<this.size; i++) {
			printElement(temp.element);
			temp = temp.next;
		}
		System.out.println("\n");
	}
	
	public void printElement(T element) {
		System.out.print(" "+ element+" ");
	}
	
	private boolean isEmpty() {
		return (size == 0);
	}
	
	public void insertNode(T element) {
		if(isEmpty()) {
			Node<T> newNode = new Node(element);
			newNode.prev = newNode;
			newNode.next = newNode;
			this.current = newNode;
			size++;
		}else {
			insertBeforeCurrent(element);
		}
	}


    /**
    *if a LESS than b :true
    * false otherwise
     */
    private static boolean less(Comparable a,Comparable b){
	    return a.compareTo(b)<0;
    }

    /**
     * In-place insertion sort of the circular doubly linked list
     * new current node contains the lowest item of all
     */
	public void insertionSort(){
		Node<T> iNode = this.current;
		while(iNode.next != this.current){
			iNode = iNode.next;
			Node<T> jNode = iNode;
			while (jNode.prev !=current){
				if(less(jNode.element,jNode.prev.element)){
					T temp = jNode.element;
					jNode.element = jNode.prev.element;
					jNode.prev.element = temp;
					jNode = jNode.prev;
				}else {
					break;
				}

			}

		}
		iNode = this.current;
		while(iNode.next!=current){
            if(less(iNode.next.element,iNode.element)){
                T temp = iNode.element;
                iNode.element = iNode.next.element;
                iNode.next.element = temp;
                iNode = iNode.next;
            }else{
                break;
            }

        }

	}
/*
 * In-place insertion sort of the circular doubly linked list with current unsorted and first node
 *
 */
//    public void insertionSortSameCurrent(){
//        Node<T> iNode = this.current;
//        while(iNode.next != this.current){
//            iNode = iNode.next;
//            Node<T> jNode = iNode;
//            while (jNode.prev !=current){
//                if(less(jNode.element,jNode.prev.element)){
//                    T temp = jNode.element;
//                    jNode.element = jNode.prev.element;
//                    jNode.prev.element = temp;
//                    jNode = jNode.prev;
//                }else {
//                    break;
//                }
//
//            }
//
//        }
//
//    }

}
