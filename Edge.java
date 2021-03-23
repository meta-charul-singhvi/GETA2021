package undirectedWeightedGraph;

import java.util.Comparator;

public class Edge implements Comparator<Edge>  {
	Vertex source;
    Vertex destination;
    int weight;
    public Edge() {}
    /**
     * public constructor to initialize value
     * @param source
     * @param destination
     * @param weight
     */
    public Edge(int source, int destination, int weight) {
        this.source = new Vertex(source);
        this.destination =new Vertex(destination);
        this.weight = weight;
    }
    /**
     * method to get source node 
     * @return Vertex source node
     */
	public Vertex getSource() {
		return this.source;
	}
	 /**
     * method to get destination node 
     * @return Vertex destination node
     */
	public Vertex getDestination() {
		return this.destination;
	}
	 /**
     * method to get weight of edge
     * @return int weight
     */
	public int getWeight() {
		return this.weight;
	}
	@Override
	public int compare(Edge edge1, Edge edge2) {
		if(edge1.getWeight() < edge2.getWeight()) {
			return -1;
		} else if(edge1.getWeight() > edge2.getWeight()) {
			return 1;
		} else {
			return 0;
		}
	}
	@Override
	public boolean equals(Object obj) {
		if(obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		Edge edge=(Edge)obj;
		if(this.getSource().getVertex()==edge.getSource().getVertex()&& this.getDestination().getVertex()==edge.getDestination().getVertex())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}