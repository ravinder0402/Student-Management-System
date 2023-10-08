
package studentmanagmentsystem;

import java.sql.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import java.lang.*;


public class ViewStudent extends javax.swing.JFrame {

 
    public ViewStudent() {
        initComponents();
        String col[]={"Name", "Entry Number", "Email", "Contact Number", "Homecity"};
        String url="jdbc:mysql://localhost/studentmanagementsystem";
        String username="root";
        String password="root1";
        ArrayList<Object[]> data = new ArrayList<>();
        try{
             Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,username,password);
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from student");
            
              while (rs.next()) {
                String column1 = rs.getString(1);
                String column2 = rs.getString(2);
                String column3 = rs.getString(3) ;
                String column4 = rs.getString(4);
                String column5 = rs.getString(5);
                data.add(new Object[]{column1, column2, column3, column4, column5});
            }


        }
        catch(Exception ae)
        {
            System.out.println(ae);
        }
        DefaultTableModel mt=new DefaultTableModel(data.toArray(new Object[0][0]),col);
        jTable1.setModel(mt);
        
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

  
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewStudent().setVisible(true);
            }
        });
    }

                       
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
                     
}