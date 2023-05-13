/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modules;

import com.mysql.jdbc.PreparedStatement;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author Sufyan
 */
public class Config extends javax.swing.JInternalFrame {

    /**
     * Creates new form Config
     */
 
    private void changePassword()
    {
        String admin1=txtAdmin1.getText();
        String pass=txtPass1.getText();        
        String newPass1=txtNewPass1.getText();
        String repass1=txtRePass.getText();
        if(pass.equals("") || newPass1.equals("") || repass1.equals("") )
        {
            JOptionPane.showMessageDialog(null, "ALL FIELDS ARE MANDATORY");
            txtAdmin1.setText("");
            txtNewPass1.setText("");            
            txtRePass.setText("");        
        }
        else
        {
            if(newPass1.equals(repass1))
            {
                try
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","");
                    Statement st=con.createStatement();
					
                    String sql= "select * from Admins where Username= '"+admin1+"' and Password='"+pass+"'";
                    ResultSet rs=st.executeQuery(sql);
                    if(rs.next())
                    {
                        rs.close();
                        con.close();
                        try
                        {
                                Class.forName("com.mysql.jdbc.Driver");
                                Connection con1= DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","");
                                
                                String sql1="UPDATE `admins` SET `Password`='"+repass1+"' WHERE `Username`='"+admin1+"'";
                                
                                Statement st1=con1.createStatement();
                                st1.executeUpdate(sql1);
                                
                                
    
                                JOptionPane.showMessageDialog(null, "PASSWORD CHANGED SUCCESSFULLY");
                                st1.close();
                                con1.close();
                                txtNewUser.setText("");
                                txtnewPass.setText("");            
                                txtrepass.setText("");
                                txtPass.setText("");
                        }
                        catch(Exception ee)
                        {
                                System.out.println(ee);
                        }
                            
                            
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "INCORRECT CURRENT ADMIN PASSWORD");
                    }
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
                }
                
            
            else
            {
                JOptionPane.showMessageDialog(null, "New Admin Passwords Do Not Match");           
                txtPass1.setText("");
                txtNewPass1.setText("");            
                txtRePass.setText("");  
            }
        }
            
    }
    
    
    public void addAdmin()
    {
        String newAdmin=txtNewUser.getText();
        String newPass=txtnewPass.getText();
        String repass=txtrepass.getText();
        String presAdmin=txtAdmin.getText();
        String adminPass=txtPass.getText();
        
        if(newAdmin.equals("") || newPass.equals("") || repass.equals("") || presAdmin.equals("") || adminPass.equals("") )
        {
            JOptionPane.showMessageDialog(null, "ALL FIELDS ARE MANDATORY");
            txtNewUser.setText("");
            txtnewPass.setText("");            
            txtrepass.setText("");
            txtPass.setText("");
        }
        else
        {
            if(newPass.equals(repass))
            {
            try
            {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","");
		Statement st=con.createStatement();
					
		String sql= "select * from Admins where Username= '"+presAdmin+"' and Password='"+adminPass+"'";
			
		ResultSet rs=st.executeQuery(sql);
		if(rs.next())
		{
                    rs.close();
                    con.close();
                    try
                    {
                                Class.forName("com.mysql.jdbc.Driver");
                                Connection con1= DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","");
                                
                                String sql1="INSERT INTO Admins(`Username`,`Password`) VALUES ('"+newAdmin+"','"+repass+"')";
                                
                                Statement st1=con1.createStatement();
                                st1.executeUpdate(sql1);
                                
                                st1.close();
                                con1.close();
    
                                JOptionPane.showMessageDialog(null, "NEW ADMIN "+newAdmin+" ADDED SUCCESSFULLY");
                                txtNewUser.setText("");
                                txtnewPass.setText("");            
                                txtrepass.setText("");
                                txtPass.setText("");
                     }
                     catch(Exception ee)
                     {
                                System.out.println(ee);
                     }
                            
                            
			}
			else
			{
                            JOptionPane.showMessageDialog(null, "INCORRECT PRESENT ADMIN PASSWORD");
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
        }
        else
        {
            JOptionPane.showMessageDialog(null, "New Admin Passwords Do Not Match");           
            txtnewPass.setText("");
            txtrepass.setText("");            
            txtPass.setText("");  
        }
        }
        
        
    }
    
    public Config() {
        initComponents();
        this.setBorder(null);
        BasicInternalFrameUI bui=(BasicInternalFrameUI) this.getUI();
        bui.setNorthPane(null);
   
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        mainPanel = new javax.swing.JPanel();
        changePassword = new javax.swing.JPanel();
        txtAdmin1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtPass1 = new javax.swing.JPasswordField();
        txtRePass = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtNewPass1 = new javax.swing.JPasswordField();
        jLabel15 = new javax.swing.JLabel();
        changePrice = new javax.swing.JPanel();
        cmbCompo = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cmbType = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtPresentPrice = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtNewPrice = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        addAdmin = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNewUser = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtAdmin = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        txtnewPass = new javax.swing.JPasswordField();
        txtrepass = new javax.swing.JPasswordField();
        jButton3 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();

        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        kGradientPanel1.setBackground(new java.awt.Color(204, 0, 51));
        kGradientPanel1.setkBorderRadius(0);
        kGradientPanel1.setkEndColor(new java.awt.Color(153, 0, 0));
        kGradientPanel1.setkFillBackground(false);
        kGradientPanel1.setkStartColor(new java.awt.Color(153, 0, 0));
        kGradientPanel1.setkTransparentControls(false);
        kGradientPanel1.setLayout(null);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("CHANGE PASSWORD");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        kGradientPanel1.add(jButton1);
        jButton1.setBounds(610, 110, 220, 41);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("ADD ADMIN");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        kGradientPanel1.add(jButton2);
        jButton2.setBounds(460, 110, 153, 41);

        mainPanel.setLayout(new java.awt.CardLayout());

        changePassword.setBackground(new java.awt.Color(204, 0, 51));
        changePassword.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 8), "CHANGE ADMIN PASSWORD", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 32), new java.awt.Color(255, 255, 255))); // NOI18N
        changePassword.setLayout(null);

        txtAdmin1.setEditable(false);
        txtAdmin1.setFont(new java.awt.Font("Verdana", 0, 19)); // NOI18N
        txtAdmin1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAdmin1FocusLost(evt);
            }
        });
        changePassword.add(txtAdmin1);
        txtAdmin1.setBounds(530, 120, 260, 40);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("USERNAME :");
        changePassword.add(jLabel6);
        jLabel6.setBounds(360, 120, 150, 40);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("CURRENT PASSWORD :");
        changePassword.add(jLabel7);
        jLabel7.setBounds(260, 180, 240, 40);
        changePassword.add(txtPass1);
        txtPass1.setBounds(530, 180, 260, 40);
        changePassword.add(txtRePass);
        txtRePass.setBounds(530, 330, 260, 40);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("RE-ENTER NEW PASSWORD :");
        changePassword.add(jLabel8);
        jLabel8.setBounds(190, 330, 300, 40);

        jButton4.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jButton4.setText("SUBMIT");
        jButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        changePassword.add(jButton4);
        jButton4.setBounds(530, 490, 170, 50);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("NEW PASSWORD :");
        changePassword.add(jLabel9);
        jLabel9.setBounds(300, 270, 200, 40);
        changePassword.add(txtNewPass1);
        txtNewPass1.setBounds(530, 270, 260, 40);

        jLabel15.setIcon(new javax.swing.ImageIcon("C:\\Users\\Sufyan\\Downloads\\cassi-josh-lhnOvu72BM8-unsplash.jpg")); // NOI18N
        jLabel15.setText("jLabel15");
        changePassword.add(jLabel15);
        jLabel15.setBounds(10, 40, 1280, 620);

        mainPanel.add(changePassword, "card3");

        changePrice.setBackground(new java.awt.Color(204, 0, 0));
        changePrice.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 8), "CHANGE PRICE", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 32), new java.awt.Color(255, 255, 255))); // NOI18N
        changePrice.setLayout(null);

        cmbCompo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        cmbCompo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--SELECT--", "Whole Blood", "RBC", "Plasma" }));
        cmbCompo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        cmbCompo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbCompoMouseClicked(evt);
            }
        });
        cmbCompo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCompoActionPerformed(evt);
            }
        });
        changePrice.add(cmbCompo);
        cmbCompo.setBounds(628, 150, 144, 36);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("TYPE :");
        changePrice.add(jLabel10);
        jLabel10.setBounds(526, 97, 53, 25);

        cmbType.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        cmbType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--SELECT--", "NORMAL", "EXCHANGE" }));
        cmbType.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        changePrice.add(cmbType);
        cmbType.setBounds(628, 93, 144, 36);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("COMPONENT :");
        changePrice.add(jLabel11);
        jLabel11.setBounds(453, 154, 126, 25);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("PRESENT PRICE :");
        changePrice.add(jLabel12);
        jLabel12.setBounds(436, 216, 143, 25);

        txtPresentPrice.setEditable(false);
        txtPresentPrice.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        changePrice.add(txtPresentPrice);
        txtPresentPrice.setBounds(628, 216, 185, 33);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("NEW PRICE :");
        changePrice.add(jLabel13);
        jLabel13.setBounds(472, 277, 107, 25);

        txtNewPrice.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        changePrice.add(txtNewPrice);
        txtNewPrice.setBounds(628, 277, 185, 33);

        jButton6.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jButton6.setText("SUBMIT");
        jButton6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        changePrice.add(jButton6);
        jButton6.setBounds(620, 402, 136, 40);

        jLabel16.setIcon(new javax.swing.ImageIcon("C:\\Users\\Sufyan\\Downloads\\cassi-josh-lhnOvu72BM8-unsplash.jpg")); // NOI18N
        jLabel16.setText("jLabel15");
        changePrice.add(jLabel16);
        jLabel16.setBounds(10, 40, 1280, 620);

        mainPanel.add(changePrice, "card4");

        addAdmin.setBackground(new java.awt.Color(204, 0, 51));
        addAdmin.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 8), "ADD ADMIN", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 32), new java.awt.Color(255, 255, 255))); // NOI18N
        addAdmin.setPreferredSize(new java.awt.Dimension(1265, 665));
        addAdmin.setLayout(null);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CURRENT ADMIN PASSWORD:");
        addAdmin.add(jLabel1);
        jLabel1.setBounds(280, 410, 320, 40);

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("NEW ADMIN USERNAME :");
        addAdmin.add(jLabel2);
        jLabel2.setBounds(320, 120, 280, 40);

        txtNewUser.setFont(new java.awt.Font("Verdana", 0, 19)); // NOI18N
        txtNewUser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNewUserFocusLost(evt);
            }
        });
        addAdmin.add(txtNewUser);
        txtNewUser.setBounds(610, 120, 260, 40);

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("RE-ENTER PASSWORD :");
        addAdmin.add(jLabel3);
        jLabel3.setBounds(340, 240, 250, 40);

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("CURRENT ADMIN:");
        addAdmin.add(jLabel4);
        jLabel4.setBounds(400, 350, 190, 40);

        txtAdmin.setEditable(false);
        txtAdmin.setFont(new java.awt.Font("Verdana", 0, 19)); // NOI18N
        addAdmin.add(txtAdmin);
        txtAdmin.setBounds(610, 350, 260, 40);
        addAdmin.add(txtPass);
        txtPass.setBounds(610, 410, 260, 40);

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("NEW ADMIN PASSWORD :");
        addAdmin.add(jLabel5);
        jLabel5.setBounds(320, 180, 280, 40);
        addAdmin.add(txtnewPass);
        txtnewPass.setBounds(610, 180, 260, 40);
        addAdmin.add(txtrepass);
        txtrepass.setBounds(610, 240, 260, 40);

        jButton3.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jButton3.setText("SUBMIT");
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        addAdmin.add(jButton3);
        jButton3.setBounds(570, 550, 150, 50);

        jLabel17.setIcon(new javax.swing.ImageIcon("C:\\Users\\Sufyan\\Downloads\\cassi-josh-lhnOvu72BM8-unsplash.jpg")); // NOI18N
        jLabel17.setText("jLabel15");
        addAdmin.add(jLabel17);
        jLabel17.setBounds(10, 40, 1280, 620);

        mainPanel.add(addAdmin, "card2");

        jScrollPane1.setViewportView(mainPanel);

        kGradientPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(110, 230, 1300, 670);

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton5.setText("UPDATE PRODUCT PRICE");
        jButton5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        kGradientPanel1.add(jButton5);
        jButton5.setBounds(830, 110, 280, 41);

        jLabel14.setIcon(new javax.swing.ImageIcon("C:\\Users\\Sufyan\\Downloads\\cassi-josh-lhnOvu72BM8-unsplash.jpg")); // NOI18N
        jLabel14.setText("jLabel14");
        kGradientPanel1.add(jLabel14);
        jLabel14.setBounds(0, -50, 1560, 1860);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1517, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 891, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        mainPanel.add(changePassword);
        mainPanel.repaint();
        mainPanel.revalidate();    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        mainPanel.add(addAdmin);
        mainPanel.repaint();
        mainPanel.revalidate();  
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
       
     
    }//GEN-LAST:event_formInternalFrameActivated

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       
        addAdmin();
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtNewUserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNewUserFocusLost
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","");
            Statement st=con.createStatement();
					
            String sql= "select * from Admins where Username= '"+txtNewUser.getText()+"' ";
			
            ResultSet rs=st.executeQuery(sql);
            if(rs.next())
            {
                JOptionPane.showMessageDialog(null, "This Username Already Been Taken");
                txtNewUser.setText("");
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }//GEN-LAST:event_txtNewUserFocusLost

    private void txtAdmin1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAdmin1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAdmin1FocusLost

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        changePassword();
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        mainPanel.add(changePrice);
        mainPanel.repaint();
        mainPanel.revalidate();  
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void cmbCompoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbCompoMouseClicked
        
 
        
        
    }//GEN-LAST:event_cmbCompoMouseClicked

    private void cmbCompoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCompoActionPerformed
        
        String type=(String) cmbType.getSelectedItem();
        String compo=(String) cmbCompo.getSelectedItem();
        if(type.equals("--SELECT--") || compo.equals("--SELECT--"))
        {
            txtPresentPrice.setText("");
        }
        else
        {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","");
            
            String sql="SELECT `"+type+"` from Price where type='"+compo+"'";
            PreparedStatement pst=(PreparedStatement) con.prepareStatement(sql);
           
            ResultSet rs=pst.executeQuery();
            if(rs.next())
            {
                String price=rs.getString(type);
                txtPresentPrice.setText(price);
            }
            rs.close();
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        }
        
    }//GEN-LAST:event_cmbCompoActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       
        String type=(String) cmbType.getSelectedItem();
        String compo=(String) cmbCompo.getSelectedItem();
        String presentPrice=txtPresentPrice.getText();
        String newPrice=txtNewPrice.getText();
        if(type.equals("--SELECT--") || compo.equals("--SELECT--") || newPrice.equals(""))
        {
            JOptionPane.showMessageDialog(this, "ALL FIELDS ARE MANDATORY", "WARNING", JOptionPane.WARNING_MESSAGE);
            txtPresentPrice.setText("");
            txtNewPrice.setText("");
        }
        else
        {
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","");
                
                String sql="UPDATE Price SET "+type+"='"+newPrice+"' WHERE Type='"+compo+"'";
                
                Statement st=con.createStatement();
                
                
                int i= JOptionPane.showConfirmDialog(this, "CONFIRM IS OPERATION", "CONFIRMATION", JOptionPane.YES_NO_OPTION);
                if(i==0)       
                {
                    st.executeUpdate(sql);
                    JOptionPane.showMessageDialog(this, "PRICE CHANGED SUCCESSFULLY");
                    st.close();
                }
               
                con.close();
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(this, e,"ERROR",JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }//GEN-LAST:event_jButton6ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel addAdmin;
    private javax.swing.JPanel changePassword;
    private javax.swing.JPanel changePrice;
    private javax.swing.JComboBox<String> cmbCompo;
    private javax.swing.JComboBox<String> cmbType;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JPanel mainPanel;
    public javax.swing.JTextField txtAdmin;
    public javax.swing.JTextField txtAdmin1;
    private javax.swing.JPasswordField txtNewPass1;
    private javax.swing.JTextField txtNewPrice;
    private javax.swing.JTextField txtNewUser;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JPasswordField txtPass1;
    private javax.swing.JTextField txtPresentPrice;
    private javax.swing.JPasswordField txtRePass;
    private javax.swing.JPasswordField txtnewPass;
    private javax.swing.JPasswordField txtrepass;
    // End of variables declaration//GEN-END:variables
}
