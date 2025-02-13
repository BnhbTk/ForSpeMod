package org.smf;

import java.util.Vector;

/**
 * This class implements the Visitor interface to define a visitor that prints all the
 * list nodes in respect to the following format: [e1]->[e2]->[e3]...
 */
public class DisplayVisitor implements Visitor{
    private Vector<String> collect;
    public DisplayVisitor(){
        collect=new Vector<>();
    }
    /**
     * This visitor method just prints the node to be visited depending on whether it is the last node or not.
     */
    public void visit(Node n){
        collect.add(n.toString());
    }

    public String get(){
        return String.join("->",collect);
    }
}
