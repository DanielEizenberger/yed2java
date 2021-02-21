package net.htlgkr.main;

import net.htlgkr.handler.Edge;
import net.htlgkr.handler.Node;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class CodeWriter {

    public static void writeToJava(Set<Node> nodes, Set<Edge> edges, String yedName){

        try {
            File f = new File(yedName+".java");
            f.delete();
            f.createNewFile();

            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            bw.write("public class "+yedName+" {");
            bw.newLine();

            for (Node n : nodes) {
                bw.write(n.getNodeLabel());
                if(n.getNodeLabel().toLowerCase().contains("if")||n.getNodeLabel().toLowerCase().contains("for")){
                    bw.write("{");
                }
                for (Edge e: edges ) {
                    if(e.getSourceID().equals(n.getNodeID())){
                        if(e.getPath().getPoints().size()>1){
                            bw.newLine();
                            bw.write("}");
                        }
                    }
                }
                bw.newLine();
            }
            bw.write("}");
            bw.write("}");
            bw.close();
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void writeToJava(ReadyEdFile ryf){
        writeToJava(ryf.getNodes(),ryf.getEdges(),ryf.getPath());
    }
}
