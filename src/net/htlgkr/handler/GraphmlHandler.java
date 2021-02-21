package net.htlgkr.handler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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

    @Override
    public void characters(char[] ch, int start, int length) {
        elementValue = new String(ch, start, length);
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("DEBUG: Start reading document!"); // For debug purposes
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("DEBUG: Reading document stopped!"); // For debug purposes
    }

    @Override
    public void startElement(String uri, String lName, String qName, Attributes attr) throws SAXException {
        switch (qName) {
            case NODE:
                String[] temp = attr.getValue(0).split("n");
                currentNodeID = temp[temp.length-1];
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
