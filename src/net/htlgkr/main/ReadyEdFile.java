package net.htlgkr.main;

import net.htlgkr.handler.Edge;
import net.htlgkr.handler.GraphmlHandler;
import net.htlgkr.handler.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;

public class ReadyEdFile {

    private Set<Node> nodes;
    private Set<Edge> edges;

    public ReadyEdFile(String path) {
        readXMLFile(path);
    }

    private void readXMLFile(String path) {
        try {
            File file = new File(path);

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            GraphmlHandler handler = new GraphmlHandler();

            saxParser.parse(file, handler);

            nodes = handler.getNodes();
            edges = handler.getEdges();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public Set<Node> getNodes() {
        return nodes;
    }

    public Set<Edge> getEdges() {
        return edges;
    }
}
