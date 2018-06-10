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
		int tmpIndx = 0;
		for (int i = 0; i < que.length; ++i) {
			if (que[i] != null) {
				temp[tmpIndx++] = que[i];
			}
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
		int x = StdRandom.uniform(que.length);
		for(int i = x; i < que.length + x; ++i) {
			if(que[i % que.length] == null) {
				que[i % que.length] = item;
				i = que.length + x;
			}
		}
		++size;
	}
	
	public Item dequeue() {
		if(size == 0) {
			throw new NoSuchElementException();
		}
		int index = StdRandom.uniform(que.length);
		Item x = null;
		while(x == null) {
			x = que[++index % que.length];
		}
		que[index % que.length] = null;
		--size;
		if (size > 0 && size <= que.length/4) resize(que.length/2);
		return x;
	}

	public Item sample() {
		if(size == 0) {
			throw new NoSuchElementException();
		}
		int index = StdRandom.uniform(que.length);
		Item x = null;
		while(x == null) {
			x = que[++index % que.length];
		}
		return x;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomizedQueue<Integer> que = new RandomizedQueue<Integer>();
		que.enqueue(10);
		que.enqueue(14);
		que.enqueue(25);
		que.enqueue(75);
		System.out.println(que.dequeue());
		System.out.println(que.dequeue());
		System.out.println(que.dequeue());
		System.out.println(que.dequeue());

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
			current = StdRandom.uniform(que.length);
		}
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return ops < size;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			++current;
			while (que[current % que.length] == null) {
				++current;
			}
			++ops;
			return que[current % que.length];

		}
		
		public void remove() {
            throw new UnsupportedOperationException();
        }
		
	}

}
