package net.htlgkr.handler;

import java.util.Comparator;

public class Node implements Comparable {

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

    @Override
    public int compareTo(Object o) {
        Node n1 = (Node) o;
        return nodeID.compareTo(n1.getNodeID());
    }
}
