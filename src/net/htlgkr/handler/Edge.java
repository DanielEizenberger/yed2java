package net.htlgkr.handler;

public class Edge implements Comparable{

    private String edgeID;
    private String sourceID;
    private String targetID;
    private String arrowSource;
    private Path path;
    private boolean done = false;
    public Edge() {
    }

    public Edge(String edgeID, String sourceID, String targetID, String arrowSource, Path path) {
        this.edgeID = edgeID;
        this.sourceID = sourceID;
        this.targetID = targetID;
        this.arrowSource = arrowSource;
        this.path = path;
    }

    public String getEdgeID() {
        return edgeID;
    }

    public void setEdgeID(String edgeID) {
        this.edgeID = edgeID;
    }

    public String getSourceID() {
        return sourceID;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public void setSourceID(String sourceID) {
        this.sourceID = sourceID;
    }

    public String getTargetID() {
        return targetID;
    }

    public void setTargetID(String targetID) {
        this.targetID = targetID;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public String getArrowSource() {
        return arrowSource;
    }

    public void setArrowSource(String arrowSource) {
        this.arrowSource = arrowSource;
    }

    public int compareTo(Object o) {


        Edge e1 = (Edge) o;
        String[] split1 = getEdgeID().split("e");
        String[] split2 = e1.getEdgeID().split("e");


        return Integer.parseInt(split1[split1.length-1])-Integer.parseInt(split2[split2.length-1]);
    }
}
