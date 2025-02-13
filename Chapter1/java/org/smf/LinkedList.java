package org.smf;

public class LinkedList {
    Node head;
    public LinkedList(Node head){
        this.head=head;
    }

    public LinkedList append(Node n){
        if (head==null) head=n;
        else head.attach(n);
        return this;
    }

    public int size(){
        if (head==null) return 0;
        LengthVisitor lv=new LengthVisitor();
        head.accept(lv);
        return lv.get();
    }

    public String toString(){
        if (head==null) return "";
        DisplayVisitor lv=new DisplayVisitor();
        head.accept(lv);
        return lv.get();
    }

    public static void test1(){
        Node n=new Node(5);
        Node p=new Node(6);
        Node q=new Node(7);
        Node r=new Node(8);
        LinkedList ll=new LinkedList(n);
        ll.append(p).append(q).append(r);
        System.out.println(ll.size());
        System.out.println(ll);
    }

    public static void test2(){
        Node n=new Node(5);
        Node q=new Node(7);
        Node r=new Node(8);
        LinkedList ll=new LinkedList(n);
        ll.append(n).append(q).append(r);
        System.out.println(ll.size());
        System.out.println(ll);
    }

    public static void test3(){
        Node n=new Node(5);
        Node p=new Node(6);
        Node q=new Node(7);
        Node r=new Node(8);
        LinkedList ll=new LinkedList(n);
        ll.append(p).append(q).append(r);
        p.next=n;
        System.out.println(ll.size());
        System.out.println(ll);
    }

    public static void main(String...args){
        test3();
    }
}
