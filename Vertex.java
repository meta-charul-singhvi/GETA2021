package undirectedWeightedGraph;


public class Vertex {
	private Integer vertex;
	private Integer status;
	/**
	 * public constructor to initialize parameters
	 * @param vertex
	 */
	public Vertex(int vertex)
	{
		this.vertex=vertex;
		this.status=1;
	}
	/**
	 * method to get vertex value
	 * @return int vertex
	 */
	public int getVertex() {
		return vertex;
	}
	/**
	 * method to get status value
	 * @return int status
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * method to set status value
	 * @param int status
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public int hashCode() {
		return this.vertex.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		Vertex vertex = (Vertex)obj;
		return this.vertex.equals(vertex.getVertex());
	}

}