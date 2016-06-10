package learn.ds.graph;

public class GraphGenerator {
    
    int nodeCount = 9;
    private GraphVertex[] graph;
    
    public GraphGenerator() {
        
    }

    public GraphVertex[] getDefaultGraph(boolean directional) {
        generateDefaultGraph(directional);
        return graph;
    }
    
    /**
     * default graph : http://www.geeksforgeeks.org//wp-content/uploads/Fig-11.jpg
     * 
     */
    private void generateDefaultGraph(boolean directional) {
        graph = new GraphVertex[nodeCount];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new GraphVertex(i);
        }
        
        addEdge(0,1,4, directional);
        addEdge(0, 7, 8, directional);
        addEdge(1, 2, 8, directional);
        addEdge(1, 7, 11, directional);
        addEdge(2, 3, 7, directional);
        addEdge(2, 8, 2, directional);
        addEdge(2, 5, 4, directional);
        addEdge(3, 4, 9, directional);
        addEdge(3, 5, 14, directional);
        addEdge(4, 5, 10, directional);
        addEdge(5, 6, 2, directional);
        addEdge(6, 7, 1, directional);
        addEdge(6, 8, 6, directional);
        addEdge(7, 8, 7, directional);
        
    }

    private void addEdge(int srcNodeId, int destNodeId, int weight, boolean directional) {
        graph[srcNodeId].getAdjacent().add(new GraphEdge(srcNodeId, destNodeId, weight));
        
        if(directional == false) {
            graph[destNodeId].getAdjacent().add(new GraphEdge(destNodeId, srcNodeId, weight));
        }
        
    }

    

}
