
package gui;

public class Stack{ 
    StackQueueNode topNode;
    private int length=0; 
    
    public void push(HeapTreeNode item){ 
        StackQueueNode newNode=new StackQueueNode(); 
        newNode.item=item; 
        newNode.link=topNode;
        topNode=newNode; 
        length++;
    }
    public HeapTreeNode peak(){ 
        if(topNode ==null) 
            return null; 
        else
            return topNode.item;
    } 
    public HeapTreeNode pop(){
        if(topNode==null) 
            return null; 
        else{
            StackQueueNode tmpNode =topNode;
            topNode=topNode.link;
            length--; 
            return tmpNode.item;
        }
    } 
    public boolean isEmpty(){ 
        return (topNode==null);
    }
    public int size(){
        return length;} 
    }