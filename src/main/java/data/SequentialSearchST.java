package data;



public class SequentialSearchST<Key, Value> {
	Node first;

	public Iterable<Key> keys(){
		Queue<Key> queue = new Queue<Key>();
		for (Node x = first; x != null; x = x.next)
			queue.enqueue(x.key);
		return queue;
	}

	/**
	 *
	 * @param key insert or update
	 * @param val same
	 * first=new Node(first,key,val)  this can make the the first add a new node.
	 */
	public void put(Key key, Value val) {
		assert key != null && val != null;
		for(Node root=first;root!=null;root=root.next){
			if(key.equals(key)){
				root.val=val; return;
			}
		}
		first=new Node(first,key,val);
	}


	private class Node {
		Node next;

		Key key;
		Value val;

		public Node(Node next, Key key, Value val) {
			this.next = next;
			this.key = key;
			this.val = val;
		}
	}
}
