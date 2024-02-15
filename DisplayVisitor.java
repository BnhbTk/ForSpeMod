package org.smf;

/**
 * This class implements the Visitor interface to define a visitor that prints all the
 * list nodes in respect to the following format: [e1]->[e2]->[e3]...
 */
public class DisplayVisitor implements Visitor{
    /**
     * This visitor method just prints the node to be visited depending on whether it is the last node or not.
     */
    public void visit(Node n){
        if (n.next==null) System.out.println(n);
        else System.out.print(n+"->");
    }
}
