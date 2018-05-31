package LinkedList;

/* Time spent on a3:  5 hours and 0 minutes.
 *
 * When you change the above, please do it carefully. Change hh to
 * the hours and mm to the minutes and leave everything else as is.
 * If the minutes are 0, change mm to 0. This will help us in
 * extracting times and giving you the average and max.
 * 
 * Name: Duoer Jia, Joy Li
 * Netid: dj333, ql67
 * What I thought about this assignment:
 * The assignment is good. The instructions are clear
 *
 */

/** An instance is a doubly linked list. */
public class DLList<E>  {
	private Node first; // first node of linked list (null if size is 0)
	private Node last;  // last node of linked list (null if size is 0)
	private int size;   // Number of values in the linked list.

	/** Constructor: an empty linked list. */
	public DLList() {
	}

	/** Return the number of values in this list.
	 *  This function takes constant time. */
	public int size() {
		return size;
	}

	/** Return the first node of the list (null if the list is empty). */
	public Node first() {
		return first;
	}

	/** Return the last node of the list (null if the list is empty). */
	public Node last() {
		return last;
	}

	/** Return the value of node n of this list.
	 * Precondition: n is a node of this list; it may not be null. */
	public E value(Node n) {
		assert n != null;
		return n.val;
	}

	/** Return a representation of this list: its values, with adjacent
	 * ones separated by ", ", "[" at the beginning, and "]" at the end. <br>
	 * Takes time proportional to the length of this list.<br>
	 * E.g. for the list containing 4 7 8 in that order, the result it "[4, 7, 8]".
	 * E.g. for the list containing two empty strings, the result is "[, ]" */
	public String toString() {
		String res= "[";
		Node n= first;
		// inv: res contains values of nodes before node n (all of them if n = null),
		//      with ", " after each (except for the last value)
		while (n != null) {
			res= res + n.val;
			n= n.next;
			if (n != null) {
				res= res + ", ";
			}
		}

		return res + "]";
	}

	
	/** Return a representation of this list: its values in reverse, with adjacent
	 * ones separated by ", ", "[" at the beginning, and "]" at the end. <br>
	 * Note that gnirtSot is the reverse of toString.
	 * Takes time proportional to the length of this list.
	 * E.g. for the list containing 4 7 8 in that order, the result is "[8, 7, 4]".
	 * E.g. for the list containing two empty strings, the result is "[, ]". */
	public String gnirtSot() { // Note: 
		//TODO 1. Look at toString to see how that was written.
		//        Use the same scheme. Extreme case to watch out for:
		//        E is String and values are the empty string.
		//        You can't test this fully until #2, prepend, is written.
		String res= "[";
		Node n= last;
		while (n != null) {
			res= res + n.val;
			n= n.prev;
			if (n != null) {
				res= res + ", ";
			}
		}
		return res + "]";

	}

	
	/** Add value v in a new node at the front of the list.
	 * This operation takes constant time. */
	public void prepend(E v) {
		//TODO 2. After writing this method, test this method and
		//        method gnirtSot thoroughly before starting on the next
		//        method. These two must be correct in order to be
		//        able to write and test all the others.
		if (first == null) {
			Node n = new Node (null, v, null);	
			first = n;
			size = 1;
			last = n;
		}
		
		else if (size == 1) {
			Node n = new Node (null, v, first);
			first.prev = n;
			last = first;
			first = n;
			size = size + 1;
		}
		
		else {
			Node n = new Node (null, v, first);
			first.prev = n;
			first = n;
			size = size + 1;
		}
	}

	
	/** add value v in a new node at the end of the list.
	 *  This operation takes constant time. */
	public void append(E v) {
		//TODO 3. This is the third method to write and test
		if (first == null) {
			Node n = new Node (null, v, null);	
			first = n;
			size = 1;
			last = n;
		}
		
		else {
			Node n = new Node (last, v, null);
			last.next = n;
			last = n;
			size = size + 1;
		}
	}
	
	
	/** Return node number k. 
	 *  Precondition: 0 <= k < size of the list.
	 *  If k is 0, return first node; if k = 1, return second node, ... */
	public Node getNode(int k) {
		//TODO 4. This method should take time proportional to min(k, size-k).
		// For example, if k <= size/2, search from the beginning of the
		// list, otherwise search from the end of the list.

		if (k >= 0 && k <= size / 2) {
			int a = 0;
			Node N = first; 
			while (a != k) {
				N = N.next;
				a = a + 1;
			}
			return N;
		}

		else if (k < size && k > size / 2 ) {
			int a = size - 1;
			Node N = last;
			while ( a != k) {
				N = N.prev;
				a = a - 1;
			}
			return N;
		}
		return null;
	}


	/** Remove node n from this list.
	 * This operation must take constant time.
	 * Precondition: n must be a node of this list; it may not be null. */
	public void delete(Node n) {
		//TODO 5. Make sure this method takes constant time. 
		if (first == n) {
			Node N = first.next;
			N.prev = null;
			first = N;
			size = size - 1;
		}

		else if (last == n) {
			Node N = last.prev;
			N.next = null;
			last = N;
			size = size - 1;
		}

		else {
			n.prev.next = n.next;
			n.next.prev = n.prev;
			n.prev = null;
			n.next = null;
			size = size - 1;
		}
	}


	/** Insert value v in a new node after node n.
	 * This operation takes constant time.
	 * Precondition: n must be a node of this list; it may not be null. */
	public void insertAfter(E v, Node n) {
		//TODO 6. Make sure this method takes constant time. 
		if (last == n) {
			Node m = new Node(n, v, null);
			n.next = m;
			last = m;
			size = size + 1;
			}

		else  {
			Node m = new Node(n, v, n.next);
			n.next = m;
			m.next.prev = m;
			size = size + 1;
		}
	}




	/*********************/

	/** An instance is a node of this list. */
	public class Node {
		private Node prev; // Previous node on list (null if this is first node)
		private E val;     // The value of this element
		private Node next; // Next node on list. (null if this is last node)

		/** Constructor: an instance with previous node p (can be null),
		 * value v, and next node n (can be null). */
		Node(Node p, E v, Node n) {
			prev= p;
			val= v;
			next= n;
		}

		/** Return the node previous to this one (null if this is the
		 * first node of the list). */
		public Node prev() {
			return prev;
		}

		/** Return the value of this node. */
		public E value() {
			return val;
		}

		/** Return the next node in this list (null if this is the
		 * last node of this list). */
		public Node next() {
			return next;
		}
	}

}
