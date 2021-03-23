package undirectedWeightedGraph;

import java.util.HashSet;
import java.util.Set;
import linkedList.LinkedList;
import linkedList.Node;
import Stack.Stack;
import Stack.StackImplementation;

public class DFS {
	private LinkedList[] adjacencyList;
	Set<String> vertexList = new HashSet<String>();
	Stack stack=new StackImplementation();
	public DFS(LinkedList[] adjacencyList)
	{
		this.adjacencyList=adjacencyList;
	}
	/**
	 * method for traversing graph using depth first search
	 * @return number of node traversed
	 * @throws Exception
	 */
	public int traversing() throws Exception
	{
		if(adjacencyList.length==0)
		{
			throw new Exception ("List is Empty!");
		}
		stack.push(Integer.toString((adjacencyList[0].getHead().getEdge().getSource().getVertex())));
		Node currentNode =(adjacencyList[0].getHead());
		while(!stack.isEmpty())
		{
			String vertex=stack.pop();
			vertexList.add(vertex);
			for (currentNode = adjacencyList[Integer.parseInt(vertex)].getHead(); currentNode != null; currentNode = currentNode
					.getNext())
			{
				if(!this.isVisited(Integer.toString(currentNode.getEdge().getDestination().getVertex())))
				{
					stack.push(Integer.toString(currentNode.getEdge().getDestination().getVertex()));
				}
			}
		
		
		}
		return vertexList.size();
	}
	/**
	 * helper function to check whether a node is visited or not
	 * @param vertex
	 * @return
	 */
	public boolean isVisited(String vertex)
	{
		if(stack.isContain((vertex)) ||  vertexList.contains(vertex))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
}