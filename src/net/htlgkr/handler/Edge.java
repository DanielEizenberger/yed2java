package net.htlgkr.handler;

public class Edge {

    private String edgeID;
    private String sourceID;
    private String targetID;
    private Path path;

    public Edge() {
    }

    public Edge(String edgeID, String sourceID, String targetID, Path path) {
        this.edgeID = edgeID;
        this.sourceID = sourceID;
        this.targetID = targetID;
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
}
