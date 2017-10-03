package union;

/**
 * @author qiao
 * email: tyrantqiao@icloud.com
 * time: 2017/9/21 15:07
 */
public class UF {
	private int[] id;
	private int count;

	public UF(int N) {
		id = new int[N];
		for (int i = 0; i < N; i++)
			id[i] = i;
	}

	public int getCount() {
		return count;
	}

	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	//TODO finish the find function
	public int find(int i) {
		return id[i];
	}

	public void connect(int p, int q) {
		id[p] = id[q];
	}

	public static void main(String[] args) {

	}
}
