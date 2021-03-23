package undirectedWeightedGraph;

import java.util.List;

public interface Graph {
	/**
	 * method to add edge in graph
	 * @param edge represent edge containing source and destination vertex
	 */
	public void addEgde(Edge edge);
	/**
	 * method to print graph
	 */
	public void printGraph();
	/**
	 * method to check whether graph is connected or not
	 * @return true if connected else false
	 * @throws Exception
	 */
	public boolean isConnected() throws Exception;
	/**
	 * method to return list of reachable node from given node
	 * @param vertex
	 * @return List<String> list of reachable nodes
	 * @throws Exception 
	 */
	public List<Integer> reachable(int vertex) throws Exception;
	/**
	 * method to find minimum spanning tree using greedy approch
	 * @return list<Edge> list of connected edges in spanning tree
	 * @throws Exception 
	 */
	public int mst() throws Exception;
	/**
	 * method to find shortest path between two node using dijkstra algorithm
	 * @param source
	 * @param destination
	 * @return int minimum distance
	 */
	public int getShortestPath(int source, int destination);

}