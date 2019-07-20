package gui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.table.*;


public class Gui extends JFrame{ 
    JMenuBar menuBar;
    JMenu heap_Menu, view_Menu, heapTree_Menu, binaryTree_Menu; 
    JMenuItem make_MI, insert_MI,add_MI, delete_MI, refresh_MI, exit_MI, heapArray_MI, usingStack_MI, usingQueue_MI, inOrder_MI, preOrder_MI, postOrder_MI;
    private JPanel content_Panel, insert_Panel, delete_Panel, default_Panel, table_Panel;
    private JLabel empNo_L, fName_L, lName_L, maritalStatus_L, salary_L, totSalary_L, message_L,message_LD,empNo_LD,empty_L; 
    private JTextField empNo_TF, fName_TF, lName_TF, salary_TF, totSalary_TF, empNo_TFD;
    private JRadioButton single_RB,maried_RB;
    private ButtonGroup group;
     private JLabel empNo1_L, fName1_L, lName1_L, maritalStatus1_L, salary1_L, totSalary1_L, message1_L,empty1_L; 
    private JTextField empNo1_TF, fName1_TF, lName1_TF, salary1_TF, totSalary1_TF;
    private JRadioButton single1_RB,maried1_RB;
    private ButtonGroup group1;
    private JButton insert_Btn,delete_Btn, exit_Btn, add_Btn;
    private JCheckBox selectedTable_CB;
    int no; 
    public String maritalState,fname,lname;
    int s,ts;
    JTable table;
    JScrollPane pane;
    public boolean test=false;
    Object[] columns={"Employee NO.","First Name","Last Name","Marital Status","Salary","Total Salary"};
    HeapArray ha;
    HeapTree ht;
    static Employee tmp;
   
    public Gui(){
        super ("EMPLOYEES SYSTEM");
       
        exit_Btn=new JButton("EXIT");
        exit_Btn.setBounds(250,30,100,30); 
        exit_Btn.setBackground(Color.RED);
        exit_Btn.setForeground(Color.white);
        exit_Btn.addActionListener(new java.awt.event.ActionListener() {
                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        System.exit(0);
                    }
                });
     
        menuBar=new JMenuBar(); 
        heap_Menu=new JMenu("Heap");
        view_Menu=new JMenu("View"); 
        heapTree_Menu=new JMenu("Heap Tree");
        binaryTree_Menu=new JMenu("Binary Tree");
        make_MI=new JMenuItem("Make");
        add_MI=new JMenuItem("Add");
        insert_MI=new JMenuItem("Insert"); 
        delete_MI=new JMenuItem("Delete"); 
        refresh_MI=new JMenuItem("Refresh"); 
        exit_MI=new JMenuItem("EXIT");
        heapArray_MI=new JMenuItem("Heap Array"); 
        usingStack_MI=new JMenuItem("Using Stack"); 
        usingQueue_MI=new JMenuItem("Using Queue"); 
        inOrder_MI=new JMenuItem("In Order");
        preOrder_MI=new JMenuItem("Pre Order");
        postOrder_MI=new JMenuItem("Post Order");

        binaryTree_Menu.add(inOrder_MI); 
        binaryTree_Menu.add(preOrder_MI);
        binaryTree_Menu.add(postOrder_MI); 
        heapTree_Menu.add(usingStack_MI);
        heapTree_Menu.add(usingQueue_MI); 
        view_Menu.add(heapArray_MI);
        heap_Menu.add(add_MI);
        heap_Menu.add(make_MI);
        heap_Menu.add(insert_MI);
        heap_Menu.add(delete_MI); 
        heap_Menu.add(refresh_MI);
        view_Menu.add(heapTree_Menu);
        heapTree_Menu.add(binaryTree_Menu);
        menuBar.add(heap_Menu); 
        menuBar.add(view_Menu); 
        menuBar.add(exit_MI);
        menuBar.setBounds(50,5, 130, 30);
make_MI.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){ 
       
       try{
        ha.sortHeap();
        }catch(Exception ex){
         JOptionPane.showMessageDialog(null,ex);
        }
    } });

insert_MI.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
        remove(delete_Panel);
        remove(default_Panel);
        add(insert_Panel);
        table.setModel(ha.model);
    } });
add_MI.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
        remove(delete_Panel);
        remove(insert_Panel);
        add(default_Panel);
        table.setModel(ha.model);
    } });
delete_MI.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e){
    remove(insert_Panel);
    remove(default_Panel);
     add(delete_Panel);
     table.setEnabled(false);
     table.setModel(new DefaultTableModel(null,columns));
     table.setModel(ha.model);
} });
refresh_MI.addActionListener(new ActionListener(){ 
    public void actionPerformed(ActionEvent e){
        try{
        ht.root=ht.levelWiseInsert(ha.item, ht.root, 1);
        
         }catch(Exception ex){
         JOptionPane.showMessageDialog(null,ex);
        }
        
    } });
heapArray_MI.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
        try{
            ha.clear();
            ha.visit();
            table.setModel(ha.model);
       }catch(Exception ex){
         JOptionPane.showMessageDialog(null,ex);
        } 
    } });
usingStack_MI.addActionListener(new ActionListener(){ 
    public void actionPerformed(ActionEvent e){ 
        try{
            ht.clear();
        ht.preOrderTraversal(ht.root);
       
        table.setModel(ht.model);
       
        }catch(Exception ex){
         JOptionPane.showMessageDialog(null, ex);
        }
        
    } });
usingQueue_MI.addActionListener(new ActionListener(){ 
    public void actionPerformed(ActionEvent e){ 
        try{
         ht.clear();   
         ht.levelOrderTraversal(ht.root);
         table.setModel(ht.model);
         }catch(Exception ex){
         JOptionPane.showMessageDialog(null, ex);
        }
    } });
inOrder_MI.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
        try{
            ht.clear();
           ht.inOrderTraverse(ht.root);
         
         table.setModel(ht.model);
         }catch(Exception ex){
         JOptionPane.showMessageDialog(null, ex);
        }
    } });
preOrder_MI.addActionListener(new ActionListener(){ 
    public void actionPerformed(ActionEvent e){
        try{
            ht.clear();
         ht.preOrderTraverse(ht.root);
         
         table.setModel(ht.model);
         }catch(Exception ex){
         JOptionPane.showMessageDialog(null, ex);
        }
    } });
postOrder_MI.addActionListener(new ActionListener(){ 
    public void actionPerformed(ActionEvent e){ 
        try{
            ht.clear();
         ht.postOrderTraverse(ht.root);
         
         table.setModel(ht.model);
         }catch(Exception ex){
         JOptionPane.showMessageDialog(null, ex);
        }
    } });
exit_MI.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){ 
        System.exit(0); }
});

        /*########################################*/
        empNo_L=new JLabel("Employee NO");
        empNo_L.setBounds(20,20,100,30); 
        fName_L=new JLabel("First Name"); 
        fName_L.setBounds(20,60,100,30);
        lName_L=new JLabel("Last Name");
        lName_L.setBounds(20,100,100,30);
        maritalStatus_L=new JLabel("Marital Status");
        maritalStatus_L.setBounds(20,140,100,30); 
        salary_L=new JLabel("Salary"); 
        salary_L.setBounds(20,180,100,30); 
        totSalary_L=new JLabel("tot Salary"); 
        totSalary_L.setBounds(260,180,100,30);
        message_L=new JLabel(""); 
        message_L.setLayout(null);
        message_L.setBounds(250,20,250,70);
        message_L.setForeground(Color.red);
        empty_L=new JLabel(""); 
        empNo_TF=new JTextField(); 
        empNo_TF.setBounds(130,20,100,30); 
        fName_TF=new JTextField(); 
        fName_TF.setBounds(130,60,100,30); 
        lName_TF=new JTextField();
        lName_TF.setBounds(130,100,100,30); 
        salary_TF=new JTextField();
        salary_TF.setBounds(130,180,100,30);
        totSalary_TF=new JTextField();
        totSalary_TF.setBounds(340,180,100,30); 
        totSalary_TF.setEditable(false);
        insert_Btn=new JButton("Insert"); 
        insert_Btn.setBounds(18,230,100,30); 
        insert_Btn.setBackground(Color.GREEN);
        single_RB=new JRadioButton("Single",false);
        single_RB.setBounds(130,140,70,30);        
        maried_RB=new JRadioButton("Maried",false); 
        maried_RB.setBounds(210,140,70,30);
        maried_RB.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
               if(maried_RB.isSelected()==true){
                  maritalState="maried";
                  salary_TF.setText("");
                  totSalary_TF.setText("");
                   }
            
        }});
        single_RB.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
               if(single_RB.isSelected()==true){
                  maritalState="single";
                  salary_TF.setText("");
                  totSalary_TF.setText("");
                   }
              
        }});
        group=new ButtonGroup();
        group.add(single_RB);
        group.add(maried_RB);
        insert_Panel=new JPanel(); 
        insert_Panel.setBounds(0,20,550,570); 
        empNo_LD=new JLabel("Employee NO");
        empNo_LD.setBounds(20,20,100,30);; 
        empNo_TFD=new JTextField(); 
        empNo_TFD.setBounds(130,20,100,30); 
        message_LD=new JLabel(""); 
        message_LD.setBounds(250,20,250,70);
        message_LD.setForeground(Color.red);
      
        /*-------------------------------------------------*/
        default_Panel=new JPanel(); 
        default_Panel.setBounds(0,20,550,570); 
     
        empNo1_L=new JLabel("Employee NO");
        empNo1_L.setBounds(20,20,100,30); 
        fName1_L=new JLabel("First Name"); 
        fName1_L.setBounds(20,60,100,30);
        lName1_L=new JLabel("Last Name");
        lName1_L.setBounds(20,100,100,30);
        maritalStatus1_L=new JLabel("Marital Status");
        maritalStatus1_L.setBounds(20,140,100,30); 
        salary1_L=new JLabel("Salary"); 
        salary1_L.setBounds(20,180,100,30); 
        totSalary1_L=new JLabel("tot Salary"); 
        totSalary1_L.setBounds(260,180,100,30);
        message1_L=new JLabel(""); 
        message1_L.setLayout(null);
        message1_L.setBounds(250,20,250,70);
        message1_L.setForeground(Color.red);
        empty1_L=new JLabel(""); 
        empNo1_TF=new JTextField(); 
        empNo1_TF.setBounds(130,20,100,30); 
        fName1_TF=new JTextField(); 
        fName1_TF.setBounds(130,60,100,30); 
        lName1_TF=new JTextField();
        lName1_TF.setBounds(130,100,100,30); 
        salary1_TF=new JTextField();
        salary1_TF.setBounds(130,180,100,30);
        totSalary1_TF=new JTextField();
        totSalary1_TF.setBounds(340,180,100,30); 
        totSalary1_TF.setEditable(false);
        add_Btn=new JButton("ADD"); 
        add_Btn.setBounds(18,230,100,30); 
        add_Btn.setBackground(Color.GREEN);
        single1_RB=new JRadioButton("Single",false);
        single1_RB.setBounds(130,140,70,30); 
        maried1_RB=new JRadioButton("Maried",false); 
        maried1_RB.setBounds(210,140,70,30);
        maried1_RB.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
               if(maried1_RB.isSelected()==true){
                  maritalState="maried";
                  salary1_TF.setText("");
                  totSalary1_TF.setText("");
               
               }
            
        }});
        single1_RB.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
               if(single1_RB.isSelected()==true){
                  maritalState="single";
                  salary1_TF.setText("");
                  totSalary1_TF.setText("");
               
               }
              
        }});
        group=new ButtonGroup();
        group.add(single1_RB);
        group.add(maried1_RB);
        default_Panel.add(add_Btn);
        default_Panel.add(empNo1_L);
        default_Panel.add(fName1_L);   
        default_Panel.add(lName1_L); 
        default_Panel.add(salary1_L);
        default_Panel.add(totSalary1_L);
        default_Panel.add(maritalStatus1_L); 
        default_Panel.add(single1_RB);
        default_Panel.add(maried1_RB);
        default_Panel.add(empNo1_TF);
        default_Panel.add(fName1_TF); 
        default_Panel.add(lName1_TF); 
        default_Panel.add(salary1_TF);
        default_Panel.add(totSalary1_TF);
        default_Panel.add(message1_L);
       // default_Panel.add(table_Panel);
        default_Panel.add(empty_L);
        default_Panel.setLayout(null);
        /*********************************************************/
        fName_TF.addKeyListener(new KeyListener(){
            public void keyReleased(KeyEvent e){
                if(fName_TF.getText().matches("[\\w]+[\\s]*[\\w]*")){
                    message_L.setText("");
            
                    fName_TF.setBorder(BorderFactory.createLineBorder(Color.GREEN));
                    test=true;
                } else{
                    message_L.setText("This Field accepts Characters Only");
                  fName_TF.setBorder(BorderFactory.createLineBorder(Color.RED));
                  test=false;
                } 
            }

            public void keyTyped(KeyEvent ke) {
                 }

            public void keyPressed(KeyEvent ke) {
                 }
        });
lName_TF.addKeyListener(new KeyListener(){ 
    public void keyReleased(KeyEvent e){ 
        if(lName_TF.getText().matches("[\\w]+[\\s]*[\\w]*")){
            message_L.setText("");
         lName_TF.setBorder(BorderFactory.createLineBorder(Color.GREEN)); 
         test=true;
        } else{
            message_L.setText("This Field accepts Characters Only");
          lName_TF.setBorder(BorderFactory.createLineBorder(Color.RED));
          test=false;
} }
 
            public void keyTyped(KeyEvent ke) {
                 }

            public void keyPressed(KeyEvent ke) {
                 }});
empNo_TF.addKeyListener(new KeyListener(){
    public void keyReleased(KeyEvent e){ 
        if(empNo_TF.getText().trim().matches("[\\d]{1,4}")&&(Integer.parseInt(empNo_TF.getText().trim())>=1)&&(Integer.parseInt(empNo_TF.getText().trim())<=1000)){ 
        message_L.setText("");
        empNo_TF.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        test=true;
       int n= Integer.parseInt(empNo_TF.getText().trim());
       if(ha.isExist(n)){/*h.isExist(n)*/
           message_L.setText("This Number is already taken !!!");
           empNo_TF.setBorder(BorderFactory.createLineBorder(Color.RED)); 
       test=false;
       } 
        }
        else{
            message_L.setText("This Field accepts must be [1-1000]");
            empNo_TF.setBorder(BorderFactory.createLineBorder(Color.RED)); 
            test=false;
        } 
    }
            public void keyTyped(KeyEvent ke) {
                 }

            public void keyPressed(KeyEvent ke) {
                 }});
salary_TF.addKeyListener(new KeyListener() { 
    public void keyReleased(KeyEvent e){
        if(salary_TF.getText().trim().matches("[\\d]{1,4}[.]{0,1}[\\d]{0,2}") && Integer.parseInt(salary_TF.getText().trim())>=0.0){
            
            message_L.setText("");
            salary_TF.setBorder(BorderFactory.createLineBorder(Color.GREEN)); 
            test=true;
            totSalary_TF.setBorder(BorderFactory.createLineBorder(Color.black));
            int f= Integer.parseInt(salary_TF.getText().trim()); 
            if(maritalState.equals("single")){
                totSalary_TF.setText(""+(f*11/10));
            } else if(maritalState.equals("maried")){
                totSalary_TF.setText(""+(f*15/10));
            } else{ 
                message_L.setText("You must select a marital status !!!");
                totSalary_TF.setBorder(BorderFactory.createLineBorder(Color.RED));
                test=false;
            } 
        } else{
            message_L.setText("enter correct salary number !!!"); 
            salary_TF.setBorder(BorderFactory.createLineBorder(Color.RED)); 
            test=false;
            totSalary_TF.setText(""); 
        } }

            public void keyTyped(KeyEvent ke) {
                 }

            public void keyPressed(KeyEvent ke) {
                 }});
        
        /*########################################*/
        selectedTable_CB=new JCheckBox("or select from the table"); 
        selectedTable_CB.setBounds(20,60,150,30);
        selectedTable_CB.addItemListener(new ItemListener() {
           
            public void itemStateChanged(ItemEvent ie) {
               if(selectedTable_CB.isSelected()==true)
               table.setEnabled(true);
               else
                table.setEnabled(false);  
            }
        });
        
        /*###############################################*/
        
        fName1_TF.addKeyListener(new KeyListener(){
            public void keyReleased(KeyEvent e){
                if(fName1_TF.getText().matches("[\\w]+[\\s]*[\\w]*")){
                    message1_L.setText("");
                    fName1_TF.setBorder(BorderFactory.createLineBorder(Color.GREEN)); 
                    test=true;
                } else{
                    message1_L.setText("This Field accepts Characters Only !!!");
                  fName1_TF.setBorder(BorderFactory.createLineBorder(Color.RED));
                  test=false;
                } 
            }

            public void keyTyped(KeyEvent ke) {
                 }

            public void keyPressed(KeyEvent ke) {
                 }
        });
lName1_TF.addKeyListener(new KeyListener(){ 
    public void keyReleased(KeyEvent e){ 
        if(lName1_TF.getText().matches("[\\w]+[\\s]*[\\w]*")){ 
            message1_L.setText("");
         lName1_TF.setBorder(BorderFactory.createLineBorder(Color.GREEN)); 
         test=true;
        } else{
            message1_L.setText("This Field accepts Characters Only");
          lName1_TF.setBorder(BorderFactory.createLineBorder(Color.RED));
          test=false;
} }
            public void keyTyped(KeyEvent ke) {}

            public void keyPressed(KeyEvent ke) {}
});
empNo1_TF.addKeyListener(new KeyListener(){
    public void keyReleased(KeyEvent e){ 
        if(empNo1_TF.getText().trim().matches("[\\d]{1,4}")&&(Integer.parseInt(empNo1_TF.getText().trim())>=1)&&(Integer.parseInt(empNo1_TF.getText().trim())<=1000)){ 
        message1_L.setText("");
        empNo1_TF.setBorder(BorderFactory.createLineBorder(Color.GREEN));
       int n= Integer.parseInt(empNo1_TF.getText().trim());
       test=true;
       if(ha.isExist(n)){/*h.isExist(n)*/
           message1_L.setText("This Number is already taken !!!");
           empNo1_TF.setBorder(BorderFactory.createLineBorder(Color.RED)); } 
       test=false;
        }
        else{
            message1_L.setText("This Field accepts must be [1-1000]");
            empNo1_TF.setBorder(BorderFactory.createLineBorder(Color.RED)); 
            test=false;
        } 
    }
            public void keyTyped(KeyEvent ke) {}
            public void keyPressed(KeyEvent ke) {}
});
salary1_TF.addKeyListener(new KeyListener() { 
    public void keyReleased(KeyEvent e){
        if(salary1_TF.getText().trim().matches("[\\d]{1,4}[.]{0,1}[\\d]{0,2}") && Integer.parseInt(salary1_TF.getText().trim())>=0){
            message1_L.setText("");
            salary1_TF.setBorder(BorderFactory.createLineBorder(Color.GREEN)); 
            totSalary1_TF.setBorder(BorderFactory.createLineBorder(Color.black));
            int f= Integer.parseInt(salary1_TF.getText().trim()); 
            if(maritalState.equals("single")){
                totSalary1_TF.setText(""+(f*11/10));
            } else if(maritalState.equals("maried")){
                totSalary1_TF.setText(""+(f*15/10));
            } else{ 
                message1_L.setText("You must select a marital status !!!");
                totSalary1_TF.setBorder(BorderFactory.createLineBorder(Color.RED)); 
            } 
            test=true;
        } else{
            message1_L.setText("Please enter correct salary number !!!"); 
            salary1_TF.setBorder(BorderFactory.createLineBorder(Color.RED)); 
            totSalary1_TF.setText(""); 
            test=false;
        } }
            public void keyTyped(KeyEvent ke) {}
            public void keyPressed(KeyEvent ke) {}
});
        
        /*########################################*/
     
        
        delete_Btn=new JButton("Delete");
        delete_Btn.setBounds(18,120,100,30);
        delete_Btn.setBackground(Color.RED);
        delete_Btn.setForeground(Color.white);
        delete_Panel=new JPanel(); 
        delete_Panel.setBounds(0,20,550,520);
        delete_Panel.add(delete_Btn);
        delete_Panel.add(selectedTable_CB); 
        delete_Panel.add(empNo_LD); 
        delete_Panel.add(empNo_TFD);
        delete_Panel.add(message_LD);
        delete_Panel.add(empty_L);
        delete_Panel.setLayout(null);
       
        /*########################################*/
  
        table=new JTable();
        pane=new JScrollPane(table);
        pane.setBounds(500,30,650,500); 
        table.setRowHeight(28); 
        Font font=new Font("",1,10);
        table.setFont(font); 
     
        table.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                int i= table.getSelectedRow(); 
                empNo_TFD.setText(ha.model.getValueAt(i, 0).toString()); 
            }});
       /*******************************************************************************/

/*///////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////*/
    
    insert_Btn.addActionListener(new ActionListener(){ 
    public void actionPerformed(ActionEvent e){ 
        if(!test)        
            message_L.setText("You must ﬁll all ﬁelds !!!");
        else{
            try{
         
                no=Integer.parseInt(empNo_TF.getText()); 
                fname=fName_TF.getText();
                lname=lName_TF.getText();
                s=Integer.parseInt(salary_TF.getText());
                ts=Integer.parseInt(totSalary_TF.getText());
                message_L.setText("New Emploee added sucssesfuly" );
                clearFields();
                ha.insert(no,fname,lname,maritalState,s,ts); 
                
                ha.clear();
                ha.visit();
                table.setModel(ha.model);
                
            }catch(Exception ex){
                 }
                   } } }); 

delete_Btn.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){ 
        if(selectedTable_CB.isSelected()){
            try{
            int i=table.getSelectedRow();
            if(i>=0){
                 int n=Integer.parseInt(ha.model.getValueAt(i, 0).toString());
                 tmp=ha.serve(n); 
                 ha.clear();
                 ha.visit();
                 table.setModel(ha.model);
                 message_LD.setText("deleted the Employee with number : "+n);
            } else message_LD.setText("Please select an Employee !!!"); 
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex);
                        
            }
        } else if(selectedTable_CB.isSelected()==false){
            try{
            int n=Integer.parseInt(empNo_TFD.getText()); 
               tmp=ha.serve(n);
               ha.clear();
               ha.visit();
               table.setModel(ha.model);
            message_LD.setText("deleted the Employee with number : "+n); 
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex);
                        
            }
        } else 
        message_L.setText("You got an ERROR !!! ");
        
    }});

add_Btn.addActionListener(new ActionListener(){ 
    public void actionPerformed(ActionEvent e){ 
        if(!test)    
       message1_L.setText("You must ﬁll all ﬁelds !!!"); 
        else{ 
            try{
            no=Integer.parseInt(empNo1_TF.getText()); 
            fname=fName1_TF.getText();
            lname=lName1_TF.getText();
            s=Integer.parseInt(salary1_TF.getText());
            ts=Integer.parseInt(totSalary1_TF.getText());
            
            ha.add(no,fname,lname,maritalState,s,ts);
            ha.clear();
            ha.visit();
            table.setModel(ha.model);
            clearFields1(); 
            message1_L.setText("New Employee added sucssesfuly ");
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex);
            }
         }
    }}); 
 
  /*///////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////*/
        
        /************************************************************************/
        add(pane);
        add(empty_L);
        setJMenuBar(menuBar);
        content_Panel=new JPanel(); 
        content_Panel.setBounds(0,100,550,520); 
        content_Panel.setLayout(null);
        insert_Panel.add(insert_Btn);
        insert_Panel.add(empNo_L);
        insert_Panel.add(fName_L);   
        insert_Panel.add(lName_L); 
        insert_Panel.add(salary_L);
        insert_Panel.add(totSalary_L); 
        insert_Panel.add(maritalStatus_L); 
        insert_Panel.add(single_RB);
        insert_Panel.add(maried_RB);
        insert_Panel.add(empNo_TF);
        insert_Panel.add(fName_TF); 
        insert_Panel.add(lName_TF); 
        insert_Panel.add(salary_TF);
        insert_Panel.add(totSalary_TF);
        insert_Panel.add(message_L);
        insert_Panel.add(empty_L);
        insert_Panel.setLayout(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE); 
        setSize(1200,670); 
        setVisible(true);
        setLayout(null);
        
     
     
    }
public void clearFields(){ 
        empNo_TF.setText(""); 
        fName_TF.setText(""); 
        lName_TF.setText(""); 
        single_RB.setSelected(false);
        maried_RB.setSelected(false);
        salary_TF.setText("");
        totSalary_TF.setText(""); 
        empNo_TF.setBorder(null); 
        fName_TF.setBorder(null); 
        lName_TF.setBorder(null); 
        salary_TF.setBorder(null);
        totSalary_TF.setBorder(null); 
  
    }
public void clearFields1(){ 
        
        empNo1_TF.setText(""); 
        fName1_TF.setText(""); 
        lName1_TF.setText(""); 
        single1_RB.setSelected(false);
        maried1_RB.setSelected(false);
        salary1_TF.setText("");
        totSalary1_TF.setText("");
        empNo1_TF.setBorder(null); 
        fName1_TF.setBorder(null); 
        lName1_TF.setBorder(null); 
        salary1_TF.setBorder(null);
        totSalary1_TF.setBorder(null); 
       
    }

public static void main(String args[]) {
  
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

                Gui g=new Gui();
          
    }

   
}
 
   
