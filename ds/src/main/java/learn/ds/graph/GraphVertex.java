package learn.ds.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphVertex implements Cloneable {
    
    private int id;
    private List<GraphEdge> adjacent = new ArrayList<GraphEdge>();
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    public List<GraphEdge> getAdjacent() {
        return adjacent;
    }
    public void setAdjacent(List<GraphEdge> adjacent) {
        this.adjacent = adjacent;
    }

    public GraphVertex(int id) {
        this.id = id;
    }
    
    public GraphVertex() {
        // TODO Auto-generated constructor stub
    }
    
    public GraphVertex(GraphVertex vert) {
        id = vert.getId();
    }
    
    @Override
    public GraphVertex clone() {
        try {
            return (GraphVertex) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            throw new RuntimeException("unable to clone graph vertex");
        }
    
    }
    
}
