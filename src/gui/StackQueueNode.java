
package gui;

public class StackQueueNode{ 
    HeapTreeNode item; 
    StackQueueNode link;
public StackQueueNode(){
    this(null,null);
} 
public StackQueueNode(HeapTreeNode item, StackQueueNode link){
    this.item=item; 
    this.link=link; }
public HeapTreeNode getItem(){
    return this.item; 
}
public void setItem(HeapTreeNode item){
this.item=item; 
}
public StackQueueNode getLink(){
    return this.link;
}
public void setLink(StackQueueNode link){
this.link=link;}
}

