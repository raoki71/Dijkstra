# Dijkstra's Algorithm
ComS311 Assignment. Implementation of Dijkstra's Algorithm for finding shortest paths in a given non-negative directed graph.
The DirectedGraph class implements a graph as an adjacecy list of mapping bewteen Tuple class and Vertex.
## Implemenation
#### `dijkstras()` in <ins>DirectedGraph.java file</ins>
The functions takes two arguments:
- `source`: the starting vertex in a given directed graph.
- `weights`: a mapping between edges and their corresponding weight

The functions returns a `Tuple` containing:
- the calculated distance from the source vertex to the shortest destination vertex
- the mapping from each vertex to its parent vertex as this feature can reconstruct shortest distnaces from any vertices

The runtime of implemented algorithm: $O(ElogV)$ time
Using `HashMap` and `HashSet` classes, the runtime for decreasing the key is $O(logn) time. In the minimum priority queue, the `decreaseKey` plays an important role in maintaining the newly encountered vertices in a graph. The use of hashmap, which has the average $O(1)$ runtime, allows this logarithmic speed up.
