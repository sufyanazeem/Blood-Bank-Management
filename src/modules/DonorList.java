/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modules;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import java.sql.*;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import javax.net.ssl.HttpsURLConnection;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Sufyan
 */
public class DonorList extends javax.swing.JInternalFrame {

    /** Creates new form DonorList */
    
    Connection con;
    PreparedStatement pst;
    
    public void theader()
    {
        JTableHeader thead=jTable1.getTableHeader();
        thead.setForeground(Color.red);
        thead.setBackground(Color.ORANGE);
        thead.setFont(new Font("Tahome",Font.BOLD,24));
     
    }
    
    public DonorList() {
        initComponents();
        
         this.setBorder(null);
        BasicInternalFrameUI bui=(BasicInternalFrameUI) this.getUI();
        bui.setNorthPane(null);
        
        showTableData();
        
        theader();
        
    }

    public void showTableData()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","");
            
            String sql= "SELECT * FROM Donors";
            
            pst=con.prepareStatement(sql);
            
            ResultSet rs= pst.executeQuery();
            
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            
            
            
            
             rs.close();
            pst.close();
            con.close();     

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        txtSearch = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        kButton3 = new keeptoo.KButton();
        kButton4 = new keeptoo.KButton();
        kButton7 = new keeptoo.KButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable(){
            public boolean isCellEditable(int row,int column)
            {
                Object o= getValueAt(row, column);
                if(true) return false;
                return true;
            }
        }

        ;
        jLabel2 = new javax.swing.JLabel();
        txtGrp = new javax.swing.JComboBox<>();
        kButton9 = new keeptoo.KButton();
        jLabel3 = new javax.swing.JLabel();

        kGradientPanel1.setBackground(new java.awt.Color(255, 0, 0));
        kGradientPanel1.setkBorderRadius(0);
        kGradientPanel1.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel1.setkStartColor(new java.awt.Color(204, 204, 204));
        kGradientPanel1.setLayout(null);

        txtSearch.setFont(new java.awt.Font("Yu Gothic", 1, 16)); // NOI18N
        txtSearch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        kGradientPanel1.add(txtSearch);
        txtSearch.setBounds(186, 54, 310, 40);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("SEARCH :");
        kGradientPanel1.add(jLabel1);
        jLabel1.setBounds(53, 47, 115, 45);

        kButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        kButton3.setText("BY ID");
        kButton3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        kButton3.setkBorderRadius(0);
        kButton3.setkEndColor(new java.awt.Color(255, 255, 255));
        kButton3.setkForeGround(new java.awt.Color(0, 0, 0));
        kButton3.setkHoverColor(new java.awt.Color(0, 0, 0));
        kButton3.setkHoverEndColor(new java.awt.Color(204, 204, 204));
        kButton3.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton3.setkHoverStartColor(new java.awt.Color(0, 0, 0));
        kButton3.setkIndicatorColor(new java.awt.Color(0, 0, 0));
        kButton3.setkPressedColor(new java.awt.Color(255, 255, 255));
        kButton3.setkStartColor(new java.awt.Color(255, 255, 255));
        kButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton3ActionPerformed(evt);
            }
        });
        kGradientPanel1.add(kButton3);
        kButton3.setBounds(528, 78, 155, 45);

        kButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        kButton4.setText("BY BLOOD GROUP");
        kButton4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        kButton4.setkBorderRadius(0);
        kButton4.setkEndColor(new java.awt.Color(255, 255, 255));
        kButton4.setkForeGround(new java.awt.Color(0, 0, 0));
        kButton4.setkHoverColor(new java.awt.Color(0, 0, 0));
        kButton4.setkHoverEndColor(new java.awt.Color(204, 204, 204));
        kButton4.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton4.setkHoverStartColor(new java.awt.Color(0, 0, 0));
        kButton4.setkIndicatorColor(new java.awt.Color(0, 0, 0));
        kButton4.setkPressedColor(new java.awt.Color(255, 255, 255));
        kButton4.setkStartColor(new java.awt.Color(255, 255, 255));
        kButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton4ActionPerformed(evt);
            }
        });
        kGradientPanel1.add(kButton4);
        kButton4.setBounds(1142, 57, 220, 40);

        kButton7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        kButton7.setText("BY NAME");
        kButton7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        kButton7.setkBorderRadius(0);
        kButton7.setkEndColor(new java.awt.Color(255, 255, 255));
        kButton7.setkForeGround(new java.awt.Color(0, 0, 0));
        kButton7.setkHoverColor(new java.awt.Color(0, 0, 0));
        kButton7.setkHoverEndColor(new java.awt.Color(204, 204, 204));
        kButton7.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton7.setkHoverStartColor(new java.awt.Color(0, 0, 0));
        kButton7.setkIndicatorColor(new java.awt.Color(0, 0, 0));
        kButton7.setkPressedColor(new java.awt.Color(255, 255, 255));
        kButton7.setkStartColor(new java.awt.Color(255, 255, 255));
        kButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton7ActionPerformed(evt);
            }
        });
        kGradientPanel1.add(kButton7);
        kButton7.setBounds(528, 27, 155, 45);

        jTable1.setFont(new java.awt.Font("Trebuchet MS", 1, 20));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable1.setRowHeight(40);
        jTable1.setSelectionBackground(new java.awt.Color(255, 0, 0));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        kGradientPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(32, 156, 1404, 571);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("OR");
        kGradientPanel1.add(jLabel2);
        jLabel2.setBounds(710, 50, 62, 41);

        txtGrp.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtGrp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A +", "A -", "B +", "B -", "AB +", "AB -", "O +", "O -" }));
        txtGrp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txtGrp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtGrp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGrpActionPerformed(evt);
            }
        });
        kGradientPanel1.add(txtGrp);
        txtGrp.setBounds(836, 57, 220, 40);

        kButton9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        kButton9.setText("UPDATE");
        kButton9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        kButton9.setkBorderRadius(0);
        kButton9.setkEndColor(new java.awt.Color(255, 255, 255));
        kButton9.setkForeGround(new java.awt.Color(0, 0, 0));
        kButton9.setkHoverColor(new java.awt.Color(0, 0, 0));
        kButton9.setkHoverEndColor(new java.awt.Color(204, 204, 204));
        kButton9.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton9.setkHoverStartColor(new java.awt.Color(0, 0, 0));
        kButton9.setkIndicatorColor(new java.awt.Color(0, 0, 0));
        kButton9.setkPressedColor(new java.awt.Color(255, 255, 255));
        kButton9.setkStartColor(new java.awt.Color(255, 255, 255));
        kButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton9ActionPerformed(evt);
            }
        });
        kGradientPanel1.add(kButton9);
        kButton9.setBounds(594, 852, 210, 45);

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Sufyan\\Downloads\\anirudh-UiwUtEqROEs-unsplash.jpg")); // NOI18N
        jLabel3.setText("jLabel3");
        kGradientPanel1.add(jLabel3);
        jLabel3.setBounds(0, 0, 1470, 2000);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1451, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 986, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton7ActionPerformed
      
        String name= txtSearch.getText();
        if(name.equals(""))
        {
            showTableData();
        }
        else
        {
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","");
            
                String sql= "SELECT * FROM Donors WHERE Name='"+name+"'";
            
                pst=con.prepareStatement(sql);
            
                ResultSet rs=pst.executeQuery();
            
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));

                rs.close();
                pst.close();
                con.close();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        
    }//GEN-LAST:event_kButton7ActionPerformed

    private void txtGrpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGrpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGrpActionPerformed

    private void kButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton4ActionPerformed
      
        String group= (String) txtGrp.getSelectedItem();
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","");
            
            String sql= "SELECT * FROM Donors WHERE Bloodgrp='"+group+"'";
            
            pst=con.prepareStatement(sql);
            
            ResultSet rs=pst.executeQuery();
            
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));

            rs.close();
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        
    }//GEN-LAST:event_kButton4ActionPerformed

    private void kButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton3ActionPerformed
      
        String id= txtSearch.getText();
        
        if(id.equals(""))
        {
            showTableData();
        }
        else
        {
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","");
            
                String sql= "SELECT * FROM Donors WHERE ID='"+id+"'";
            
                pst=con.prepareStatement(sql);
            
                ResultSet rs=pst.executeQuery();
            
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));

                rs.close();
                pst.close();
                con.close();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        
    }//GEN-LAST:event_kButton3ActionPerformed

    private void kButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton9ActionPerformed
        
        try
        {
            int index= jTable1.getSelectedRow();
            TableModel model= jTable1.getModel();

            UpdateDonor ud1= new UpdateDonor(null,true);

            String id= model.getValueAt(index, 0).toString();
            String name= model.getValueAt(index, 2).toString();
            String height= model.getValueAt(index, 5).toString();
            String weight= model.getValueAt(index, 6).toString();
            String address= model.getValueAt(index, 7).toString();
            String phone= model.getValueAt(index, 8).toString();
            String email= model.getValueAt(index, 9).toString();

            ud1.txtID.setText(id);
            ud1.txtName.setText(name);
            ud1.txtWeight.setText(weight);
            ud1.txtHeight.setText(height);
            ud1.txtAddress.setText(address);
            ud1.txtPhone.setText(phone);
            ud1.txtEmail.setText(email);
            
            
            ud1.show();
        
        }
        catch(ArrayIndexOutOfBoundsException ae)
        {
            JOptionPane.showMessageDialog(null, "PLEASE SELECT THE ROW FIRST");
        }
        
          
    }//GEN-LAST:event_kButton9ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private keeptoo.KButton kButton3;
    private keeptoo.KButton kButton4;
    private keeptoo.KButton kButton7;
    private keeptoo.KButton kButton9;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JComboBox<String> txtGrp;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

}