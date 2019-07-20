
package gui;


public class Employee{ 
    int empNo;
 String ﬁrstName; 
 String lastName;
 String maritalStatus;
 int basicSalary; 
 int totalSalary;
 public Employee(){
    // this(null,null,null,null,null,null);
 } 
 public Employee(int n, String fN, String lN, String state, int salary,int totSalary){
     this.empNo=n;
     this.ﬁrstName=fN; 
     this.lastName=lN; 
     this.maritalStatus=state;
     this.basicSalary=salary; 
     this.totalSalary=totSalary; 
     }
public int getEmpNo(){
    return this.empNo;
} 
public void setEmpNo(int n){ 
    this.empNo=n;
} 
public String getFirstName(){
    return this.ﬁrstName;
} 
public void setFirstName(String fN){ 
    this.ﬁrstName=fN;
} 
public String getLastName(){ 
    return this.lastName;
} 
public void setLastName(String lN){ 
    this.lastName=lN;
        }
public String getMaritalStatus(){ 
    return this.maritalStatus;
} 
public void setMaritalstatus(String state){ 
    this.maritalStatus=state;
} 
public int getBasicSalary(){
    return this.basicSalary;
}
public void setBasicSalary(int salary){
     this.basicSalary=salary;
}
public int getTotalSalary(){
    return this.totalSalary;
}
public void setTotalSalary(int salary){
     this.totalSalary=salary;
}
}