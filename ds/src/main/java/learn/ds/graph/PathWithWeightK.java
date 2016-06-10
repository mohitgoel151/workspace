package learn.ds.graph;

import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.*;

/*
 * http://www.geeksforgeeks.org/find-if-there-is-a-path-of-more-than-k-length-from-a-source/
 */
public class PathWithWeightK {
    
    public PathWithWeightK() {
        // TODO Auto-generated constructor stub
    }
    
    public void execute() {
        int startIndex = 0;
        int weight = 15;
        
        GraphVertex[] graph = new GraphGenerator().getDefaultGraph(false);
        
        List<List<GraphVertex>> result = new ArrayList<List<GraphVertex>>();
        List<GraphVertex> path = new ArrayList<GraphVertex>();
        path.add(graph[startIndex]);

        getAllPaths(graph, weight, startIndex, result, path);
        
        for (List<GraphVertex> pathList : result) {
            for (GraphVertex graphVertex : pathList) {
                System.out.print(graphVertex.getId() + " -> ");
            }
            System.out.println();
        }
        
    }
    
    private void getAllPaths(GraphVertex[] graph, int sum, int srcIndex, List<List<GraphVertex>> result, List<GraphVertex> path) {

        if(graph == null || graph.length == 0) {
            return;
        }
               
        List<GraphEdge> adjEdges = graph[srcIndex].getAdjacent();
        for (GraphEdge graphEdge : adjEdges) {
            if(path.contains(graph[graphEdge.getDest()])) {
                continue;
            }
            if(sum - graphEdge.getWeight() > 0) {
                path.add(graph[graphEdge.getDest()]);
                getAllPaths(graph, sum - graphEdge.getWeight(), graphEdge.getDest(), result, path);
                path.remove(graph[graphEdge.getDest()]);
            } else if (sum - graphEdge.getWeight() == 0) {
                path.add(graph[graphEdge.getDest()]);
                
                //Method 1
//                List<GraphVertex> finalPath = new ArrayList<GraphVertex>();
//                for (GraphVertex graphVertex : path) {
//                    finalPath.add(new GraphVertex(graphVertex));
//                }
//                result.add(finalPath);
                
                //Method 2
//                result.add((List<GraphVertex>) ((ArrayList<GraphVertex>)path).clone());
                
                //Method 3,4
                //                            path.stream().map(d -> d.clone()).collect(toList());                     // retrun list
                List<GraphVertex> finalPath = path.stream().map(d -> d.clone()).collect(toCollection(ArrayList::new)); // return array list
                result.add(finalPath);

                path.remove(graph[graphEdge.getDest()]);
            }
        }
        
        
        return;
        
        
    }
    
    

}
