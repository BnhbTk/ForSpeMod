package org.smf;

/**
 * This interface defines a generic visitor (a design pattern that consists
 * of visiting each node in the list)
 */
public interface Visitor{
    /**
     * Defines what to do whenever a node is visited
     * @param n: the node to be visited
     */
    public void visit(Node n);
}
