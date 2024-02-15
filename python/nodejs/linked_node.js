class Node{
    constructor(elt){
        this.element=elt
        this.next=null
    }

    append(n){
        let last=this
        while (last.next!=null) last=last.next
        last.next=n
        return this
    }

    toString(){
        return `[${this.element}]`
    }

    accept(visitor){
        visitor.visit(this)
        if (this.next!=null)
            this.next.accept(visitor)
        return visitor

    }
}

class Visitor{
    visit(n){}
}

class DisplayVisitor extends Visitor{
    visit(n){
        let end=n.next?"->":"\n"
        process.stdout.write(n.toString()+end)
    }
}

class LengthVisitor extends Visitor{
    constructor(){
        super()
        this.length=0
    }
    visit(n){
        this.length++
    }
}

function test1(){
    let a=new Node(5)
    let b=new Node(6)
    let c=new Node(7)
    let d=new Node(8)
    a.append(b).append(c).append(d)

    a.accept(new DisplayVisitor())
    let len=new LengthVisitor()
    a.accept(len)
    console.log(len.length)
}

function test2(){
    let a=new Node(5)
    let b=new Node(6)
    let c=new Node(7)
    let d=new Node(8)
    a.append(a).append(c).append(d)

    a.accept(new DisplayVisitor())
    let len=new LengthVisitor()
    a.accept(len)
    console.log(len.length)
}

function test3(){
    let a=new Node(5)
    let b=new Node(6)
    let c=new Node(7)
    let d=new Node(8)
    a.append(b).append(c).append(d)
    b.next=a

    a.accept(new DisplayVisitor())
    let len=new LengthVisitor()
    a.accept(len)
    console.log(len.length)
}


test1()
//or test2()
//or test3()
