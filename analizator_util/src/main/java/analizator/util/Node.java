package main.java.analizator.util;

public class Node {

    private TypeOfNode nodeType;

    private String nodeName;

    public Node(){}

    public Node(TypeOfNode nodeType,String nodeName){
        this.nodeType = nodeType;
        this.nodeName = nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public void setNodeType(TypeOfNode nodeType) {
        this.nodeType = nodeType;
    }

    public TypeOfNode getNodeType() {
        return nodeType;
    }

    public String getNodeName() {
        return nodeName;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){return true;}
        if(obj == null){return false;}
        if(this.getClass() != obj.getClass()){return false;}

        Node node = (Node) obj;
        if(this.nodeName != null){
            if (!this.nodeName.equals(node.nodeName)){return false;}
        }
        if(!this.nodeType.equals(node.nodeType)){return false;}
        return true;
    }

    @Override
    public int hashCode() {
        int price = 12;
        int result = 1;
        result = result * price + this.nodeType.hashCode();
        result = result * price + this.nodeName.hashCode();
        return result;
    }
}
