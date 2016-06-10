package learn.ds.graph;

public class GraphEdge {
    
    private int src;
    private int dest;
    private int weight;
    
    public int getSrc() {
        return src;
    }
    public void setSrc(int src) {
        this.src = src;
    }
    public int getDest() {
        return dest;
    }
    public void setDest(int dest) {
        this.dest = dest;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    
    public GraphEdge() {
        // TODO Auto-generated constructor stub
    }
    
    public GraphEdge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

}
