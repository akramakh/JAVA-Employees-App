
package gui;

 public class Queue{ 
    
    StackQueueNode front; 
    StackQueueNode rear; 
    private int length=0;
    
    public void enqueue(HeapTreeNode newItem){
        StackQueueNode tmp=new StackQueueNode();
        tmp.item=newItem; 
        tmp.link=null;
        if(rear==null){
            front=tmp;
            rear=tmp; }
        else{
            rear.link=tmp;
            rear=tmp; 
            length++; }
    }
    public  HeapTreeNode dequeue(){
        if(rear==null)
            return null; 
        else{ 
            HeapTreeNode tmpItem=front.item; 
            front=front.link;
            if(front==null)
                rear=null; 
            length--; 
            return tmpItem;
        }
    } 
    public boolean isEmpty(){
        return (rear==null);
    }
    public int size(){ 
        return length;
    }
}