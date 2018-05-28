
public class TestDeque {
	private Deque<Integer> deck;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestDeque test = new TestDeque();
		test.addFRemoveL();
		test.addLRemoveF();
		System.out.println("\n");
		test.iterTest();
	}
	
	public TestDeque() {
		deck = new Deque<Integer>();
	}
	
	public void addFRemoveL() {
		for(int i = 0; i < 5; ++i) {
			deck.addFirst(i);
		}
		for(int i = 0; i < 5; ++i) {
			System.out.println(deck.removeLast());
		}
	}
	
	public void addLRemoveF() {
		for(int i = 0; i < 5; ++i) {
			deck.addLast(i);
		}
		for(int i = 0; i < 5; ++i) {
			System.out.println(deck.removeFirst());
		}
	}
	
	public void iterTest() {
		for(int i = 0; i < 5; ++i) {
			deck.addLast(i);
		}
		for(int i = 0; i < 5; ++i) {
			deck.addFirst(i);
		}
		for(Integer item : deck) {
			System.out.println(item);
		}
	}

}
