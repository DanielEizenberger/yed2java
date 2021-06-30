package net.htlgkr.main;

import com.sun.org.apache.bcel.internal.classfile.Code;
import net.htlgkr.handler.Edge;
import net.htlgkr.handler.Node;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class CodeWriter {

    /*public void writesToJava(){
        System.out.println("DEBUG: writeToJava()");
        for(Node n : nodes){
            System.out.println(n.getNodeID());
        }

        try {
            File f = new File(yedName+".java");
            f.delete();
            f.createNewFile();

            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            bw.write("import java.util.HashMap;\n" +
                         "import java.util.Map;\n");
            bw.write("public final class "+yedName+" {");
            bw.newLine();

            for (Node n : nodes) {
                bw.write(n.getNodeLabel());
                if(n.getNodeLabel().toLowerCase().contains("if")||n.getNodeLabel().toLowerCase().contains("for")){
                    bw.write("{");
                }
                for (Edge e : edges ) {
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

    }*/

    public static void writeToJava(ReadyEdFile ryf){
        Set<Node> nodes = ryf.getNodes();
        Set<Edge> edges = ryf.getEdges();
        String yedName = ryf.getPath();

        try {
            File f = new File(yedName + ".java");
            f.delete();
            f.createNewFile();

            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            bw.write("import java.util.HashMap;\n" +
                    "import java.util.Map;\n");
            bw.write("public final class " + yedName + " {");
            bw.newLine();


            System.out.println("DEBUG: Start fuerFortnite()");
            Node temp = nodes.stream().filter(x -> x.getNodeID().equals("n1")).findFirst().get();
            Stack<Node> nodeStack = new Stack<>();
            Stack<Edge> edgeStack = new Stack<>();
            String nextTarget = "";
            boolean whielthing = true;
            boolean stuff = false;

            boolean warum = false;
            while (whielthing && !nextTarget.equals("n0::n9")) {
                for (Edge e : edges) {
                    if (!e.isDone() && e.getSourceID().equals(temp.getNodeID())) {
                        if (!e.getArrowSource().equals("none") && !edgeStack.contains(e)) {
                            edgeStack.push(e);
                            stuff = false;

                        } else {
                            e.setDone(true);
                            Optional<Node> nodeTempThingwtf = nodes.stream().filter(x2 -> x2.getNodeID().equals(e.getTargetID())).findFirst();
                            if (nodeTempThingwtf.isPresent()) {
                                nextTarget = nodeTempThingwtf.get().getNodeID();
                                stuff = true;
                                break;
                            }
                        }
                    }
                }
                String finalNextTarget = nextTarget;
                //System.out.println(nextTarget);
                if (stuff) {

                    temp = nodes.stream().filter(y -> y.getNodeID().equals(finalNextTarget)).findFirst().get();
                    if (!nodeStack.contains(temp)) {

                        if (temp.getNodeLabel().contains("if") || temp.getNodeLabel().contains("for")) {
                            temp.setNodeLabel(temp.getNodeLabel() + "{");
                        }
                        nodeStack.add(temp);
                    }

                    stuff = false;
                } else if (edgeStack.size() > 1) {
                    nextTarget = nodes.stream().filter(x2 -> x2.getNodeID().equals(edgeStack.peek().getTargetID())).findFirst().get().getNodeID();
                    edgeStack.pop();
                    warum = true;
                }

                whielthing = false;
                for (Edge e1 : edges) {

                    if (!e1.isDone()) {
                        whielthing = true;
                        break;
                    }
                }
            }
            Node temp2 = nodes.stream().filter(y -> y.getNodeID().equals("n0::n9")).findFirst().get();
            nodeStack.push(temp2);
            nodes.clear();
            for (Node n : nodeStack) {
                nodes.add(n);
                System.out.println(n.getNodeLabel());
                bw.write(n.getNodeLabel());
                if(n.getNodeLabel().toLowerCase().contains("if")||n.getNodeLabel().toLowerCase().contains("for")){
                    bw.write("{");
                }
                for (Edge e : edges ) {
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
            bw.flush();
            bw.close();
        }catch (Exception exc){
            exc.printStackTrace();
        }

        System.out.println("DEBUG: End fuerFortnite()");
    }
}
