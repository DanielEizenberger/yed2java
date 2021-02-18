package net.htlgkr.handler;

public class Node {

    private String nodeID;
    private String nodeLabel;

    public Node() {
    }

    public Node(String nodeID, String nodeLabel) {
        this.nodeID = nodeID;
        this.nodeLabel = nodeLabel;
    }

    public String getNodeID() {
        return nodeID;
    }

    public void setNodeID(String nodeID) {
        this.nodeID = nodeID;
    }

    public String getNodeLabel() {
        return nodeLabel;
    }

    public void setNodeLabel(String nodeLabel) {
        this.nodeLabel = nodeLabel;
    }
}
