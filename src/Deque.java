import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

	private class Node {
		private Item item;
		private Node next;
		private Node previous;
		
		public Node(Item item, Node next, Node previous) {
			this.item = item;
			this.next = next;
			this.previous = previous;
		}
	}
	
	private Node head;
	private Node tail;
	private int size;
	
	public Deque() {
		size = 0;
		head = null;
		tail = null;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public int size() {
		return size;
	}
	
	public void addFirst(Item item) {
		if(item == null) {
			IllegalArgumentException e = new IllegalArgumentException();
			throw e;
		}
		Node addition = new Node(item, head, null);
		this.head = addition;
		if(size == 0) {
			this.tail = addition;
		}
		if(size > 0) {
			addition.next.previous = addition;
		}
		++this.size;
	}
	
	public void addLast(Item item) {
		if(item == null) {
			IllegalArgumentException e = new IllegalArgumentException();
			throw e;
		}
		Node addition = new Node(item, null, tail);
		this.tail = addition;
		if(size == 0) {
			this.head = addition;
		}
		if(size > 0) {
			addition.previous.next = addition;
		}
		++this.size;
	}
	
	public Item removeFirst() {
		if(size == 0) {
			NoSuchElementException e = new NoSuchElementException();
			throw e;
		}
		Item retVal = head.item;
		head = head.next;
		if(size != 1) {
			head.previous = null;
		}
		else {
			tail = null;
		}
		--this.size;
		return retVal;
	}
	
	public Item removeLast() {
		if(size == 0) {
			NoSuchElementException e = new NoSuchElementException();
			throw e;
		}
		Item retVal = tail.item;
		tail = tail.previous;
		if(size != 1) {
			tail.next = null;
		}
		else {
			head = null;
		}
		--this.size;
		return retVal;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new DequeIterator();
	}
	
	private class DequeIterator implements Iterator<Item> {
		private Node current = head;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current != null;
		}

		@Override
		public Item next() {
			if(!hasNext()) {
				throw new UnsupportedOperationException();
			}
			Item retVal = current.item;
			current = current.next;
			return retVal;
		}
		
		public void remove() {
            throw new UnsupportedOperationException();
        }
	}

}
