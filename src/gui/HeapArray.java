
package gui;

import javax.swing.table.DefaultTableModel;


public class HeapArray{ 
    public static Employee[] item =new Employee[999];
    //public static Employee[] h = new Employee[999];
    public static int counter=1;
    static int total;
    static Object[] row=new Object[6];
    public static DefaultTableModel model=new DefaultTableModel();
    static Object[] columns={"Employee NO.","First Name","Last Name","Marital Status","Salary","Total Salary"}; 
  
    public static void add(int n, String fN, String lN, String state, int salary,int totSalary){//add
        item[counter]=new Employee(n,fN,lN,state,salary,totSalary);
        counter++;   
    }
    public static void newTrickle(Employee[] a, int parent){//make
        int leftChild=parent*2;
        int rightChild=parent*2+1; 
        int newIndex=parent;
        if(leftChild <= total && a[leftChild].getEmpNo() > a[parent].getEmpNo())
            newIndex=leftChild;
        if(rightChild <= total && a[rightChild].getEmpNo() > a[newIndex].getEmpNo())
             newIndex=rightChild;
        if(newIndex!=parent){ 
            swap(parent, newIndex);
            newTrickle(a, newIndex);
        } }
    
    public static void sortHeap(){
        total=counter-1; 
        for(int i=total/2;i>0;i--)
            newTrickle(item,i);
    
    }
          
public static void insert(int n, String fN, String lN, String state, int salary,int totSalary){
    
  if(!isFull()){ 
    
     counter++;
     item[counter-1]=new Employee(n,fN,lN,state,salary,totSalary);
     bubble(counter-1);
     
  }
}
public static void swap(int n,int parent){
  Employee tmp=new Employee();
  tmp=item[n]; 
  item[n]= item[parent];
  item[parent]= tmp; 
}
public static void bubble(int l){ 
    int i, j, x, y;
  i=l;  //child
  j=l/2;//parent
  x=item[i].getEmpNo();
  y=item[j].getEmpNo();
  if(j>0&&y<x){
      swap(i,j);
   bubble(l/2); 
  } 
}

public static Employee serve(int a){//delete
    Employee tmp=null;
  if(counter!=1){
   swap(getIndexOf(getOwner(a)),counter-1);
   tmp=item[counter-1]; 
   item[counter-1]=null;
   if(counter==2) 
       counter=1; 
   else{
       counter--;
        
  } 
   tricklingDown();
  //sortHeap();
  }
  return tmp; }

public static void tricklingDown(){ 
    int k=1; 
    int l=2*k; //left
    while(l<counter){ 
        int max=l; 
        int r=l+1; //right
        if(r<counter){
            if(item[r].getEmpNo() > item[l].getEmpNo())
                max++; 
        }
        if(item[k].getEmpNo() < item[max].getEmpNo()){
            swap(k,max); 
             
            k=max; 
            l=2*k; 
        } else
            break; 
    } 
}
/*
public static void trickle(int b, int l){
    int i ,x, y, z;
 i=b;
 x=item[i].getEmpNo(); 
 while(i<=l){ 
     if(2*i==l){
         y=item[l].getEmpNo();
   if(y>x){ 
       swap(i,2*i);
     i=l;
   }  else{
       y=item[2*i].getEmpNo();
    z=item[2*i+1].getEmpNo(); 
    if(x<y&&y>z){
        swap(i,2*i);
     i=2*i; }
    else if(x<y&&y<z){
        swap(i,2*i+1);
     i=2*i+1;
    }else 
        i=l; 
   } } 
 }
}*/
    public static Employee getOwner(int n){//get the owner 
     Employee tmp=null;
     
     for(int i=1;i<counter;i++) {
      if(n==item[i].getEmpNo())
          tmp=item[i];
   } 
  return tmp; 
    } 
public static void visit(){//print method on scs
    model.setColumnIdentifiers(columns);
    
    for(int i=1;i<counter;i++){
         if(item[i]!=null){
                row[0]=item[i].getEmpNo();
                row[1]=item[i].getFirstName();
                row[2]=item[i].getLastName();
                row[3]=item[i].getMaritalStatus(); 
                row[4]=item[i].getBasicSalary();
                row[5]=item[i].getTotalSalary(); 
                model.addRow(row);
                      
        }
    }
}
public static void clear(){
    try{
    
        model=new DefaultTableModel();
    
    }catch(Exception ex){
        
    }
}
public static boolean isExist(int n){
    boolean test=false;
  for(int i=1;i<counter;i++){
      if(item[i]!=null)
     test= item[i].getEmpNo()==n;
  }
  return test;
}
public static int getIndexOf(Employee a){
    int n=0;
  for(int i=1;i<counter;i++){
      if(item[i]!=null)
          if(item[i].getEmpNo()==a.getEmpNo())
            n=i;
  }
  return n;
}

 public static boolean isFull(){ 
     return counter==999; } 
}
 
