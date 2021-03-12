# GETA2021 Algorithm2

### Question1
Define the interface for an  undirected weighted graph with the following methods:
  isConnected() - it will return true if the graph is a connected graph. Use depth first search for this purpose. DFS can be implemented using stack.
  reachable(a) - it will return all the nodes that are reachable from node a
  mst() - it will return the minimum spanning tree for the graph using the greedy approach
  shortestPath(a,b) - it will return the shortest path from node a to node b using Dijkstra’s algorithm. 

### Question2
Implement the above interface using the edge list representation.

### Question3
Use Quick Sort algorithm to sort a linked-list of employees in descending order with the following strategy:-
The employee with the highest salary should be the first in the linked list and the one with the lowest salary should be last.
In case of a tie, an employee with a smaller age should go first.
Note - Do NOT use any Java Collections API
