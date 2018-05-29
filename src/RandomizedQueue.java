import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
	private int size; 
	private Item[] que;
	
	public RandomizedQueue() {
		que = (Item[]) new Object[2];
		size = 0;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size() {
		return this.size;
	}
	
	private void resize(int capacity) {
		assert capacity >= size;

		Item[] temp = (Item[]) new Object[capacity];
		for (int i = 0; i < size; i++) {
			temp[i] = que[i];
		}
		que = temp;
	}
	
	public void enqueue(Item item) {
		if(item == null) {
			throw new IllegalArgumentException();
		}
		if(size == que.length) {
			resize(2*que.length);
		}
		que[size++] = item;
	}
	
	public Item dequeue() {
		if(size == 0) {
			throw new NoSuchElementException();
		}
		int index = StdRandom.uniform(size);
		Item x = null;
		while(x == null) {
			x = que[index++];
		}
		que[index] = null;
		--size;
		if (size > 0 && size == que.length/4) resize(que.length/2);
		return x;
	}

	public Item sample() {
		if(size == 0) {
			throw new NoSuchElementException();
		}
		int index = StdRandom.uniform(size);
		Item x = null;
		while(x == null) {
			x = que[index++];
		}
		que[index] = null;
		return x;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new RandQueueIterator();
	}
	
	private class RandQueueIterator implements Iterator<Item> {
		private int current, ops;
		
		public RandQueueIterator() {
			ops = 0;
			current = StdRandom.uniform(size);
			while(que[current] == null) {
				++current;
			}
		}
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return ops < size;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			while (que[current++] == null) {
			}
			if (!hasNext()) {
				throw new NoSuchElementException();
			} else {
				++ops;
				return que[current];
			}

		}
		
		public void remove() {
            throw new UnsupportedOperationException();
        }
		
	}

}
