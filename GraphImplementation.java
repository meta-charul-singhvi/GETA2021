package undirectedWeightedGraph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import linkedList.LinkedList;
import linkedList.Node;

public class GraphImplementation implements Graph {
	private int vertices;
	private LinkedList[] adjacencyList;
	/**
	 * public constructor to initialize value of parameter
	 * @param vertices
	 */
	public GraphImplementation(int vertices)
	{
		this.vertices=vertices;
		adjacencyList = new LinkedList[vertices];
		 for (int i = 0; i <vertices ; i++) {
             adjacencyList[i] = new LinkedList();
         }
	}
	/**
	 * method to add edge in adjacencylist
	 */
	 public void addEgde(Edge edge) {
         adjacencyList[edge.getSource().getVertex()].insertNode(edge); 
     }
	 /**
	  * method to print graph
	  */
	 public void printGraph()
	 {
		 for(int i=0;i<this.vertices;i++)
		 {
			 adjacencyList[i].display();
			 System.out.println();
		 }
	 }
	 /**
	  * method to check whether graph is connected or not
	  * @return true if connected else false
	  */
	 public boolean isConnected() throws Exception
	 {
		 DFS dfs = new DFS(adjacencyList);
		 if(dfs.traversing() == this.vertices)
		 {
			 return true; 
		 }
		 else
		 {
			 return false;
		 }
		
	}
	 /**
	  * method to return list of nodes reachable from given node
	 * @throws Exception 
	  */
	 public List<Integer> reachable(int vertex) throws Exception
	 {
		 if(adjacencyList.length==0)
		 {
			 throw new Exception("null list");
		 }
		 Node currentNode;
		 List<Integer> reachableNodesList= new ArrayList<Integer>();
		 for (currentNode =adjacencyList[(vertex)].getHead(); currentNode != null; currentNode = currentNode
					.getNext())
			{
			 reachableNodesList.add(currentNode.getEdge().getDestination().getVertex());
			}
		 return reachableNodesList;
	}
	 /**
	  * method to find minimum spanning tree using greedy approch
	 * @throws Exception 
	  */
	 public int mst() throws Exception
	 {
		 int minimumWeight=0;
		 if(!this.isConnected())
		 {
			 throw new Exception("no spnnaning tree");
		 }
		 Node currentNode;
		 List<Edge> edgeList= new ArrayList<Edge>();
		 List<Integer> destinationList= new ArrayList<Integer>();
		 for(int i=0 ;i<this.vertices; i++)
		 {
		 for (currentNode =adjacencyList[i].getHead(); currentNode != null; currentNode = currentNode
					.getNext())
			{
			 if(!edgeList.contains(new Edge(currentNode.getEdge().getDestination().getVertex(),currentNode.getEdge().getSource().getVertex(),currentNode.getEdge().getWeight())))
			 {
				 edgeList.add(currentNode.getEdge());
				 minimumWeight+=currentNode.getEdge().getWeight();
			 }
			}
		 }
		 edgeList.sort(new Edge());
		 destinationList.add(edgeList.get(0).getSource().getVertex());
		 Iterator<Edge> itr = edgeList.iterator();
		while(itr.hasNext())
		 {
			 Edge edge=itr.next();
			 if(destinationList.contains(edge.getSource().getVertex()) && destinationList.contains(edge.getDestination().getVertex()))
			 {
				itr.remove();
				minimumWeight-=edge.getWeight();
				 continue;
			 }
		    else if(destinationList.contains(edge.getSource().getVertex()))
			 {
				 destinationList.add(edge.getDestination().getVertex());
			 }
			 else
			 {
			 destinationList.add(edge.getSource().getVertex());
			}
			
		 }
//		 return edgeList.subList(0, this.vertices-1);
		 return minimumWeight;
		 
	 }
	 /**
	  * method to get shortest path between two nodes using dijkstra algorithm
	  */
	 public int getShortestPath(int source, int destination)
	 {
	        int distance[] = new int[this.vertices];
	        boolean shortestPath[] = new boolean[this.vertices];
	        for (int i = 0; i < this.vertices; i++) {
	            distance[i] = Integer.MAX_VALUE;
	        }
	        distance[source] = 0;
	        for (int count = 0; count < this.vertices - 1; count++) {
	        	int minDistanceVertex = getMinKeyVertex(distance, shortestPath);
	        	shortestPath[minDistanceVertex] = true;
	        	 for (Node currentNode = adjacencyList[minDistanceVertex].getHead(); currentNode != null; currentNode = currentNode
	 					.getNext())
	        	 {
	        	 int vertex=currentNode.getEdge().getDestination().getVertex();
	        	 if (!shortestPath[vertex]
	                        && distance[minDistanceVertex] != Integer.MAX_VALUE
	                        && distance[minDistanceVertex] + currentNode.getEdge().getWeight() < distance[vertex]) {
	                    distance[vertex] = distance[minDistanceVertex]
	                            + currentNode.getEdge().getWeight();
	                }
	        	 }
	        }
	        return distance[destination];
	 }
	 /**
	  * helper method to get node value which has minimum distance
	  * @param distance
	  * @param mstSet
	  * @return
	  */
	 private int getMinKeyVertex(int distance[], boolean mstSet[]) {
	        //Initialize min value
	        int min = Integer.MAX_VALUE;
	        int minIndex = -1;

	        for (int i = 0; i < this.vertices; i++)
	            if (mstSet[i] == false && distance[i] < min) {
	                min = distance[i];
	                minIndex = i;
	            }
	        return minIndex;
	    }
	
}