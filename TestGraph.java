package undirectedWeightedGraph;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestGraph {
	@Test
	public void testGraphConnectivitySimple() {
		try {
		GraphImplementation graph=new GraphImplementation(5);
		graph.addEgde(new Edge(0,1,1));
		graph.addEgde(new Edge(0,2,7));
		graph.addEgde(new Edge(1,0,1));
		graph.addEgde(new Edge(1,2,5));
		graph.addEgde(new Edge(1,3,4));
		graph.addEgde(new Edge(1,4,3));
		graph.addEgde(new Edge(2,0,7));
		graph.addEgde(new Edge(2,1,5));
		graph.addEgde(new Edge(2,4,6));
		graph.addEgde(new Edge(3,1,4));
		graph.addEgde(new Edge(3,4,2));
		graph.addEgde(new Edge(4,1,3));
		graph.addEgde(new Edge(4,2,6));
		graph.addEgde(new Edge(4,3,2));
		assertTrue(graph.isConnected());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	@Test
	public void testGraphConnectivityMedium() {
		try {
		GraphImplementation graph=new GraphImplementation(6);
		graph.addEgde(new Edge(0,1,1));
		graph.addEgde(new Edge(0,2,7));
		graph.addEgde(new Edge(1,0,1));
		graph.addEgde(new Edge(1,2,5));
		graph.addEgde(new Edge(1,3,4));
		graph.addEgde(new Edge(1,4,3));
		graph.addEgde(new Edge(2,0,7));
		graph.addEgde(new Edge(2,1,5));
		graph.addEgde(new Edge(2,4,6));
		graph.addEgde(new Edge(3,1,4));
		graph.addEgde(new Edge(3,4,2));
		graph.addEgde(new Edge(4,1,3));
		graph.addEgde(new Edge(4,2,6));
		graph.addEgde(new Edge(4,3,2));
		graph.addEgde(new Edge(5,-1,0));
		assertFalse((graph.isConnected()));
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	@Test
	public void testReachableNodes() {
		try {
		GraphImplementation graph=new GraphImplementation(5);
		graph.addEgde(new Edge(0,1,1));
		graph.addEgde(new Edge(0,2,7));
		graph.addEgde(new Edge(1,0,1));
		graph.addEgde(new Edge(1,2,5));
		graph.addEgde(new Edge(1,3,4));
		graph.addEgde(new Edge(1,4,3));
		graph.addEgde(new Edge(2,0,7));
		graph.addEgde(new Edge(2,1,5));
		graph.addEgde(new Edge(2,4,6));
		graph.addEgde(new Edge(3,1,4));
		graph.addEgde(new Edge(3,4,2));
		graph.addEgde(new Edge(4,1,3));
		graph.addEgde(new Edge(4,2,6));
		graph.addEgde(new Edge(4,3,2));
		List<Integer> expectedList=new ArrayList<Integer>();
		expectedList.add(0);
		expectedList.add(1);
		expectedList.add(4);
		List<Integer> actualList=graph.reachable(2);
		assertEquals(expectedList, actualList);
		
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	@Test
	public void testShortestPathSimple() {
		try {
		GraphImplementation graph=new GraphImplementation(5);
		graph.addEgde(new Edge(0,1,1));
		graph.addEgde(new Edge(0,2,7));
		graph.addEgde(new Edge(1,0,1));
		graph.addEgde(new Edge(1,2,5));
		graph.addEgde(new Edge(1,3,4));
		graph.addEgde(new Edge(1,4,3));
		graph.addEgde(new Edge(2,0,7));
		graph.addEgde(new Edge(2,1,5));
		graph.addEgde(new Edge(2,4,6));
		graph.addEgde(new Edge(3,1,4));
		graph.addEgde(new Edge(3,4,2));
		graph.addEgde(new Edge(4,1,3));
		graph.addEgde(new Edge(4,2,6));
		graph.addEgde(new Edge(4,3,2));
		
		assertEquals(1, graph.getShortestPath(0, 1));
		
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	@Test
	public void testShortestPathMedium() {
		try {
		GraphImplementation graph=new GraphImplementation(5);
		graph.addEgde(new Edge(0,1,1));
		graph.addEgde(new Edge(0,2,7));
		graph.addEgde(new Edge(1,0,1));
		graph.addEgde(new Edge(1,2,5));
		graph.addEgde(new Edge(1,3,4));
		graph.addEgde(new Edge(1,4,3));
		graph.addEgde(new Edge(2,0,7));
		graph.addEgde(new Edge(2,1,5));
		graph.addEgde(new Edge(2,4,6));
		graph.addEgde(new Edge(3,1,4));
		graph.addEgde(new Edge(3,4,2));
		graph.addEgde(new Edge(4,1,3));
		graph.addEgde(new Edge(4,2,6));
		graph.addEgde(new Edge(4,3,2));
		
		assertEquals(8, graph.getShortestPath(2, 3));
		
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	@Test
	public void testMinimumSpanningtree() {
		try {
		GraphImplementation graph=new GraphImplementation(5);
		graph.addEgde(new Edge(0,1,1));
		graph.addEgde(new Edge(0,2,7));
		graph.addEgde(new Edge(1,0,1));
		graph.addEgde(new Edge(1,2,5));
		graph.addEgde(new Edge(1,3,4));
		graph.addEgde(new Edge(1,4,3));
		graph.addEgde(new Edge(2,0,7));
		graph.addEgde(new Edge(2,1,5));
		graph.addEgde(new Edge(2,4,6));
		graph.addEgde(new Edge(3,1,4));
		graph.addEgde(new Edge(3,4,2));
		graph.addEgde(new Edge(4,1,3));
		graph.addEgde(new Edge(4,2,6));
		graph.addEgde(new Edge(4,3,2));
		assertEquals(11,graph.mst());
		
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}