from __future__ import annotations

class Node:
    """This class represents a node in a simple linked list
    """
    
    def __init__(self,value:int) -> None:
        """Build one node which has no next node.

        Args:
            value (int): the value to be stored in the nod
        """
        self.value=value
        self.next=None
        
    def __str__(self) -> str:
        """Builds a string representation of the node

        Returns:
            str: the string representation
        """
        return f"[{self.value}]"
    
    
    def append(self,n:Node) -> Node:
        """Appends a node at the end of the list.

        Args:
            n (Node): the node be added.

        Returns:
            Nod: The head of the list
        """
        if self.next==None:
            self.next=n
        else:
            self.next.append(n)
        return self


    def accept(self,v:Visitor) -> None:
        """This methods implements the visitor design pattern

        Args:
            v (Visitor): the visitor of the node.
        """
        v.visit(self)
        if self.next:self.next.accept(v)

class Visitor:
    """A class that represents a generic visitor
    """
    def visit(self,n:Node) -> None :
        """The behavior of the visitor at node n.

        Args:
            n (Node): the node which is currently visited
        """
        pass

class DisplayVisitor(Visitor):
    """This the visitor which display all the list nodes
    """
    def visit(self, n: Node) -> None:
        end="->" if n.next else "\n"
        print(n,end=end)

class LengthVisitor(Visitor):
    """This the visitor which counts the nodes in the list.
    """
    
    def __init__(self) -> None:
        """A counter is used to count the nodes, initialized to 0.
        """
        self.counter=0
    
    def visit(self, n: Node) -> None:
        self.counter+=1

def test1():
    n=Node(5)
    p=Node(6)
    q=Node(7)
    r=Node(8)
    n.append(p).append(q).append(r)
    n.accept(DisplayVisitor())
    l=LengthVisitor()
    n.accept(l)
    print(l.counter)

def test2():
    n=Node(5)
    p=Node(6)
    q=Node(7)
    r=Node(8)
    n.append(n).append(q).append(r)
    n.accept(DisplayVisitor())
    l=LengthVisitor()
    n.accept(l)
    print(l.counter)

def test3():
    n=Node(5)
    p=Node(6)
    q=Node(7)
    r=Node(8)
    n.append(p).append(q).append(r)
    p.next=n
    n.accept(DisplayVisitor())
    l=LengthVisitor()
    n.accept(l)
    print(l.counter)


if __name__=="__main__":
    test3()
