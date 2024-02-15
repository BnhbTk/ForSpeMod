package org.smf;

/**
 * This class represents a node in a simple linked list (the nodes of which store integer values).
 */
public class Node {
    /**
     * The value to be stored in the nod
     */
    int value;

    /**
     * A pointer to the next nod
     */
    Node next;

    /**
     * The constructor builds one node from an integer
     * @param value
     */
    public Node(int value){
        this.value=value;
        next=null;
    }

    /**
     * Builds a string representation of the node (format: [e]).
     */
    public String toString(){
        return "["+value+"]";
    }

    /**
     * This methods appends a node at the end of the linked list.
     * @param n: the node to append
     * @return: the head of the list
     */
    public Node append(Node n){
        Node current=this;
        while (current.next!=null) current=current.next;
        current.next=n;
        return this;
    }

    /**
     * This method implements the visitor design pattern. It accepts the visitor for the current node, then propagate this behavior
     * to the next node.
     * @param v: the visitor of the nod
     */
    public void accept(Visitor v){
        v.visit(this);
        if (next!=null) next.accept(v);
    }

    public static void test1(){
        Node n=new Node(5);
        Node p=new Node(6);
        Node q=new Node(7);
        Node r=new Node(8);
        n.append(p).append(q).append(r);
        n.accept(new DisplayVisitor());
        LengthVisitor l=new LengthVisitor();
        n.accept(l);
        System.out.println(l.getCounter());
    }

    public static void test2(){
        Node n=new Node(5);
        Node p=new Node(6);
        Node q=new Node(7);
        Node r=new Node(8);
        n.append(n).append(q).append(r);
        n.accept(new DisplayVisitor());
        LengthVisitor l=new LengthVisitor();
        n.accept(l);
        System.out.println(l.getCounter());
    }

    public static void test3(){
        Node n=new Node(5);
        Node p=new Node(6);
        Node q=new Node(7);
        Node r=new Node(8);
        n.append(p).append(q).append(r);
        p.next=n;
        n.accept(new DisplayVisitor());
        LengthVisitor l=new LengthVisitor();
        n.accept(l);
        System.out.println(l.getCounter());
    }

    public static void main(String...args){
        test3();
    }
}

