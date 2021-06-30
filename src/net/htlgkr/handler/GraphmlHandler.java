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
    private static final String ARROWS = "y:Arrows";
    private Set<Node> nodes = new HashSet<>();
    private Set<Edge> edges = new HashSet<>();
    private String elementValue;

    private String currentNodeID = "";
    private boolean label = false;

    private String currentEdgeID = "";
    private String currentEdgeSourceID = "";
    private String currentEdgeTargetID = "";
    private String currentArrowSource = "";
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
        System.out.println("DEBUG: Reading document stopped!"); // For debug purposes
    }

    @Override
    public void startElement(String uri, String lName, String qName, Attributes attr) throws SAXException {
        switch (qName) {
            case NODE:
                currentNodeID = attr.getValue(0);
                break;
            case NODELABEL:
                label = true;
                break;
            case EDGE:
                currentEdgeID = attr.getValue(0);
                currentEdgeSourceID = attr.getValue(1);
                currentEdgeTargetID = attr.getValue(2);

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
            case ARROWS:
                edge = true;
                currentArrowSource = attr.getValue(0);
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (elementValue != null) {
            if (label && !elementValue.equals("")) {
                nodes.add(new Node(currentNodeID, elementValue));
                elementValue = null;
                label = false;

            } else if (edge) {
                edges.add(new Edge(currentEdgeID, currentEdgeSourceID, currentEdgeTargetID, currentArrowSource, currentPath));
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
