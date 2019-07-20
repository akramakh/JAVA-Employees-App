
package gui;

import javax.swing.table.DefaultTableModel;

public class HeapTree{ 
   static HeapTreeNode root; 
   static int length;
   static HeapArray ha;
    static Object[] row=new Object[6];
    public static  DefaultTableModel model=new DefaultTableModel();
    static Object[] columns={"Employee NO.","First Name","Last Name","Marital Status","Salary","Total Salary"}; 
    
public static HeapTreeNode levelWiseInsert(Employee[] h, HeapTreeNode root, int i){ //refresh
    
        if(i<ha.counter){
        HeapTreeNode tmp = new HeapTreeNode(h[i]); 
        root=tmp; 
        root.left=levelWiseInsert(h,root.left, 2*i); 
        root.right=levelWiseInsert(h,root.right, 2*i+1); 
    } 
    return root;
} 
public static void preOrderTraverse(HeapTreeNode T){ 
    if(T!=null){
        addIntoTable(T.getItem());
        preOrderTraverse(T.left);
        preOrderTraverse(T.right); 
    } }
public static void inOrderTraverse(HeapTreeNode t){ 
    if(t!=null){ 
        inOrderTraverse(t.left);
        addIntoTable(t.getItem());
        inOrderTraverse(t.right); 
    } }
public static void postOrderTraverse(HeapTreeNode t){
    if(t!=null){ 
        postOrderTraverse(t.left);
        postOrderTraverse(t.right);
        addIntoTable(t.getItem());
    } }
public static void preOrderTraversal(HeapTreeNode t){
    Stack s = new Stack(); 
    HeapTreeNode n; 
    s.push(t);
    while(!s.isEmpty()){ 
        n=(HeapTreeNode)s.pop();
        if(n!=null){ 
            addIntoTable(n.getItem());
            s.push(n.right); 
            s.push(n.left); 
        }} 
} 
public static void levelOrderTraversal(HeapTreeNode t){
    Queue q = new Queue();
    HeapTreeNode n;
    q.enqueue(t); 
    while(!q.isEmpty()){ 
        n=(HeapTreeNode)q.dequeue();
        if(n!=null){
            addIntoTable(n.getItem()); 
            q.enqueue(n.left);
            q.enqueue(n.right); 
        }} }
public static void addIntoTable(Employee item){
            model.setColumnIdentifiers(columns);
            if(item!=null){
              
                row[0]=item.getEmpNo();
                row[1]=item.getFirstName();
                row[2]=item.getLastName();
                row[3]=item.getMaritalStatus(); 
                row[4]=item.getBasicSalary();
                row[5]=item.getTotalSalary(); 
                model.addRow(row);
          
            }          
}
public static void clear(){
    try{
    
        model=new DefaultTableModel();
    
    }catch(Exception ex){
        
    }
}
public int size(){ return length; }
}