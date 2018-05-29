import edu.princeton.cs.algs4.StdIn;

public class Permutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomizedQueue<String> que = new RandomizedQueue<String>();
		String s = StdIn.readString();
		while(s != null) {
			que.enqueue(s);
			s = StdIn.readString();
		}
		
		int ops = Integer.parseInt(args[0]);
		for(int i = 0; i < ops; ++i) {
			System.out.println(que.dequeue());
		}
	}

}
