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
        /*String[] split1 = getNodeID().split("n");
        String[] split2 = n1.getNodeID().split("n");


        return Integer.parseInt(split1[split1.length-1])-Integer.parseInt(split2[split2.length-1]);*/
        return Integer.parseInt(nodeID)-Integer.parseInt(n1.nodeID);
    }
}
