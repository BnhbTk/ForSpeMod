package org.smf;

/**
 * This class implements the @Visitor interface to define a visitor that computes the length of the list.
 */
class LengthVisitor implements Visitor{
    /**
     * The counter of the nodes
     */
    private int counter=0;

    /**
     * The visitor just increments the counter when the node is visited
     */
    public void visit(Node n){
        counter++;
    }

    /**
     * returns the value of the counter
     * @return: the value of the counter
     */
    public int getCounter(){
        return counter;
    }
}
