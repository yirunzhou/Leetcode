public class UF{
	
	private int[] id;
	private int[] size;
	public int component;


	public UF(int n){
		id = new int[n];
		size = new int[n];
		component = n;

		for(int i = 0; i < n; i ++){
			id[i] = i;
			size[i] = 1;
		}
	}

	public boolean connected(int i, int j){
		return find(i) == find(j);
	}

	public int find (int i){
		while(id[i] != i){
			id[i] = id[id[i]];
			i = id[i];
		}
		return i;
	}

	public void union(int i, int j){
		int ir = find(i);
		int jr = find(j);

		if(ir == jr){
			return;
		}

		if(size[ir] < size[jr]){
			id[ir] = jr;
			size[jr] += size[ir];
		} else {
			id[jr] = ir;
			size[ir] += size[jr];
		}

		component -= 1;
	}
}