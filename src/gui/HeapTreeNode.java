
package gui;


public  class HeapTreeNode{ 
    private  Employee item;
    protected  HeapTreeNode left;
    protected  HeapTreeNode right;
    public HeapTreeNode(){ 
        this(null,null,null); 
    }
    public HeapTreeNode(Employee item){
        this.item=item;
        this.left=null; 
        this.right=null; 
    } 
    public HeapTreeNode(Employee item, HeapTreeNode left, HeapTreeNode right){
        this.item=item;
        this.left=left;
        this.right=right; 
    }
    public void setItem(Employee item){ 
        this.item=item; }
    public Employee getItem(){
        return this.item; } 
    public void setLeft(HeapTreeNode left){ 
        this.left=left; }
public HeapTreeNode getLeft(){
    return this.left; } 
public void setight(HeapTreeNode right){
    this.right=right; } 
public HeapTreeNode getRight(){
    return this.right; } } 

