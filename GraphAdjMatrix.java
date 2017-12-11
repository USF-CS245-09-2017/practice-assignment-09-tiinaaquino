public class GraphAdjMatrix implements Graph{

	private int[][] graph;
	private int v;
	
	/**
	 * Constructs and returns a graph with
	 * the number of vertices passed as the
	 * argument
	 * @param vertices
	 */
	public GraphAdjMatrix(int vertices) {
		this.graph = new int[vertices][vertices];
		this.v = vertices;
		
	}
	
	@Override
	/**
	 * Adds a directed edge between two
	 * vertices from src to target
	 */
	public void addEdge(int v1, int v2) {
		// can be left unimplemented
	}

	@Override
	/**
	 * Prints one ordering of vertices
	 */
	public void topologicalSort() {
		// can be left unimplemented
	}

	@Override
	/**
	 * Adds an undirected edge or weight
	 * between two vertices
	 */
	public void addEdge(int v1, int v2, int weight) {
		graph[v1][v2] = weight;
		graph[v2][v1] = weight;
	}

	@Override
	/**
	 * Returns the weight of the edge between
	 * vertices v1 and v2. May return 0 or a
	 * negative number if such an edge does
	 * not exist
	 */
	public int getEdge(int v1, int v2) {
			return graph[v1][v2];
	}

	@Override
	/**
	 * Creates the minimum spanning tree from
	 * the source graph, removes any edges in
	 * the graph which are not in the minimum
	 * spanning tree, and returns the weight
	 * of the minimum spanning tree
	 */
	public int createSpanningTree() {
		int weight = 0;
		int parent[] = new int[v];
		int key[] = new int[v];
		boolean set[] = new boolean[v];
		
		for (int i = 0; i < v; i++) {
			key[i] = Integer.MAX_VALUE;
			set[i] = false;
		}
		key[0] = 0;
		parent[0] = -1;
		
		for (int count = 0; count < v; count++) {
			int min = minIndex(key, set);
			set[min] = true;
			
			for (int j = 0; j < v; j++) {
				if (graph[min][j] != 0 && set[j] == false && graph[min][j] < key[j]) {
					parent[j] = min;
					key[j] = graph[min][j];
				}
			}
		}
		
		for (int k = 1; k < v; k++) {
			weight += graph[k][parent[k]];
		}
		
		return weight;
	}
	
	public int minIndex(int key[], boolean set[]) {
		int min = Integer.MAX_VALUE;
		int index = -1;
		
		for (int i = 0; i < v; i++) {
			if (set[i] == false && key[i] < min) {
				min = key[i];
				index = i;
			}
		}
		return index;
	}

}