package net.htlgkr.main;

import net.htlgkr.handler.Edge;
import net.htlgkr.handler.Node;
import net.htlgkr.handler.Point;
import sun.plugin.dom.core.CoreConstants;

public class Main {

    public static void main(String[] args) {
        ReadyEdFile readFile = new ReadyEdFile("ElectionUtilBasic.graphml");
        CodeWriter.writeToJava(readFile);
        testing(readFile);
    }

    private static void testing(ReadyEdFile ryf) {
        if(ryf == null || ryf.getNodes() == null || ryf.getEdges() == null){
            System.out.println("Something went wrong during testing! (NullPointerException)");
            return;
        }

        System.out.println("----------TESTING START----------");
        System.out.println("Nodes:\n");

        for (Node n : ryf.getNodes()) {
            System.out.println("Node ID: " + n.getNodeID() + " | Node Label: " + n.getNodeLabel());
        }
        System.out.println("Node Size: " +ryf.getNodes().size());

        System.out.println("\nEdges:\n");

        for (Edge e : ryf.getEdges()) {
            System.out.println("Edge ID: " + e.getEdgeID() + " | Source ID: " + e.getSourceID() + " | Target ID: " + e.getTargetID());

            if (e.getPath() != null) {
                int counter = 1;

                for (Point p : e.getPath().getPoints()) {
                    System.out.println("        -> Point Nr: " + counter + " | X: " + p.getX() + " | Y: " + p.getY());
                    counter++;
                }
            }
        }
        System.out.println("Edge Size: " +ryf.getEdges().size());

        System.out.println("----------TESTING END----------");
    }
}
