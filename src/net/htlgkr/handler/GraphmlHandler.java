package net.htlgkr.handler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.*;

public class GraphmlHandler extends DefaultHandler {

    private static final String NODE = "node";
    private static final String NODELABEL = "y:NodeLabel";
    private static final String EDGE = "edge";
    private static final String PATH = "y:Path";
    private static final String POINT = "y:Point";
    private Set<Node> nodes = new TreeSet<>();
    private Set<Edge> edges = new TreeSet<>();
    private String elementValue;

    private String currentNodeID = "";
    private boolean label = false;

    private String currentEdgeID = "";
    private String currentEdgeSourceID = "";
    private String currentEdgeTargetID = "";
    private Path currentPath;
    private boolean edge = false;

    //DEBUG
    private List<String> debug = new ArrayList<>();

    @Override
    public void characters(char[] ch, int start, int length) {
        elementValue += new String(ch, start, length);
        if(elementValue.trim().equals("null")){
            elementValue = elementValue.replace("null", "");
        }
        elementValue = elementValue.replace("\n", "").trim();
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("DEBUG: Start reading document!"); // For debug purposes
    }

    @Override
    public void endDocument() throws SAXException {
        debug();
        sortNodes();

        System.out.println("DEBUG: Reading document stopped!"); // For debug purposes
    }

    private void debug(){
        debug.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o1.split(" ")[0]) - Integer.parseInt(o2.split(" ")[0]);
            }
        });

        /*List<String> temp = new ArrayList<>();
        temp.add(debug.get(0));
        debug.remove(0);
        for (int i = 0; i < temp.size(); i++){
            for(int a = 0; a < debug.size(); a++){
                if(temp.get(i).split(" ")[2].equals(debug.get(a).split(" ")[0])){
                    temp.add(debug.get(a));
                    debug.remove(a);
                }
            }
        }*/


        for(String s : debug){
            System.out.println(s);
        }
    }

    private void sortNodes(){
        Node[] no = new Node[nodes.size()];
        int counter = 1;

        int from = Integer.parseInt(debug.get(0).split(" ")[0]);
        no[counter-1] = (Node) nodes.toArray()[from];
        int to = Integer.parseInt(debug.get(0).split(" ")[2]);

        for (int i = 0; i < debug.size(); i++){
            if(counter < nodes.size()) no[counter] = (Node) nodes.toArray()[to-1];

            for(String s : debug){
                if(Integer.parseInt(s.split(" ")[0]) == to){
                    to = Integer.parseInt(s.split(" ")[2]);
                    break;
                }
            }

            counter++;
        }

        for (Node n : no){
            System.out.println(n.getNodeLabel());
        }
    }

    @Override
    public void startElement(String uri, String lName, String qName, Attributes attr) throws SAXException {
        switch (qName) {
            case NODE:
                String[] temp = attr.getValue(0).split("n");
                currentNodeID = temp[temp.length-1];

                if(attr.getValue(0).equals("n0")) currentNodeID = "-1";
                System.out.println(attr.getValue(0) + " | " + currentNodeID);
                break;
            case NODELABEL:
                label = true;
                break;
            case EDGE:
                edge = true;

                currentEdgeID = attr.getValue(0);

                String[] temp1 =attr.getValue(1).split("n");
                currentEdgeSourceID = temp1[temp1.length-1];
                String[] temp2 = attr.getValue(2).split("n");
                currentEdgeTargetID = temp2[temp2.length-1];

                debug.add(currentEdgeSourceID + " -> " + currentEdgeTargetID + " | " + attr.getValue(0));
                break;
            case PATH:
                currentPath = new Path();
                break;
            case POINT:
                Point p = new Point();
                p.setX(Float.parseFloat(attr.getValue(0)));
                p.setY(Float.parseFloat(attr.getValue(1)));

                List<Point> points = currentPath.getPoints();
                points.add(p);

                currentPath.setPoints(points);
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (elementValue != null) {
            if (label) {
                nodes.add(new Node(currentNodeID, elementValue));
                elementValue = null;
                label = false;

            } else if (edge) {
                edges.add(new Edge(currentEdgeID, currentEdgeSourceID, currentEdgeTargetID, currentPath));
                elementValue = null;
                edge = false;

            }
        }
    }

    public Set<Node> getNodes() {
        return nodes;
    }

    public Set<Edge> getEdges() {
        return edges;
    }
}
