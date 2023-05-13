/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modules;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.JTableHeader;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Sufyan
 */
public class AddBlood extends javax.swing.JInternalFrame {

    /**
     * Creates new form AddBlood
     */
    
    Connection con;
    String ID;
    int expirydate;
    
    public void addPlasmaUnit()
    {
        String grp=txtGrp.getText();
        String bgWid=txtBagID.getText();
        String adddateWB=txtAddDate.getText();
        String adddateWB1=txtExpiryDate.getText();
        String statusWB="ACTIVE";
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","");
            
            String sql="INSERT INTO Plasma (`Donor ID`, `Bag ID`, `Blood Group`, `Date Added`, `Expiry Date`, `Status`,`Type`) VALUES (?,?,?,?,?,?,?)";

            PreparedStatement pst=con.prepareStatement(sql);
            
            pst.setString(1, ID);
            pst.setString(2, bgWid);
            pst.setString(3, grp);
            pst.setString(4, adddateWB);
            pst.setString(5, adddateWB1);
            pst.setString(6, statusWB);
            pst.setString(7, "PLASMA");
    
            
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "ADDED SUCCESSFULLY");
      
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    
    public void addRBCUnit()
    {
        String grp=txtGrp.getText();
        String bgWid=txtBagID.getText();
        String adddateWB=txtAddDate.getText();
        String adddateWB1=txtExpiryDate.getText();
        String statusWB="ACTIVE";
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","");
            
            String sql="INSERT INTO RBC (`Donor ID`, `Bag ID`, `Blood Group`, `Date Added`, `Expiry Date`, `Status`,`Type`) VALUES (?,?,?,?,?,?,?)";

            PreparedStatement pst=con.prepareStatement(sql);
            
            pst.setString(1, ID);
            pst.setString(2, bgWid);
            pst.setString(3, grp);
            pst.setString(4, adddateWB);
            pst.setString(5, adddateWB1);
            pst.setString(6, statusWB);
            pst.setString(7, "RBC");
    
            
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "ADDED SUCCESSFULLY");
      
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public int getPsExpiry()
    {
        int expDays = 0;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","");
            
            String sql="SELECT `Plasma` FROM ExpiryDates";
            PreparedStatement pst=con.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            while(rs.next())
            {
                expDays=rs.getInt("Plasma");
              
            }
           
            rs.close();
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
           System.out.println(e);
        }
       return(expDays);
    }
    
    public void fillPlasmaBagID()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","");
            
            Statement st= con.createStatement();
            
            ResultSet rs= st.executeQuery("SELECT Max(`Bag ID`) FROM plasma");
            rs.next();
            
        
          
          if(rs.getString("Max(`Bag ID`)")==null)
          {
              txtBagID.setText("PS10001");
          }
          else
          {
              Long id= Long.parseLong(rs.getString("Max(`Bag ID`)").substring(2, rs.getString("Max(`Bag ID`)").length()));
              id++;
              txtBagID.setText("PS"+String.format("%03d", id));
    
          }
            
            
            rs.close();
            st.close();
            con.close();
     
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void fillRBCBagID()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","");
            
            Statement st= con.createStatement();
            
            ResultSet rs= st.executeQuery("SELECT Max(`Bag ID`) FROM RBC");
            rs.next();
            
        
          
          if(rs.getString("Max(`Bag ID`)")==null)
          {
              txtBagID.setText("RB10001");
          }
          else
          {
              Long id= Long.parseLong(rs.getString("Max(`Bag ID`)").substring(2, rs.getString("Max(`Bag ID`)").length()));
              id++;
              txtBagID.setText("RB"+String.format("%03d", id));
    
          }
            
            
            rs.close();
            st.close();
            con.close();
     
        }
        catch(Exception e)
        {
           System.out.println(e);
        }
    }
    
    public void addWBUnit()
    {
        String grp=txtGrp.getText();
        String bgWid=txtBagID.getText();
        String adddateWB=txtAddDate.getText();
        String adddateWB1=txtExpiryDate.getText();
        String statusWB="ACTIVE";
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","");
            
            String sql="INSERT INTO WholeBlood (`Donor ID`, `Bag ID`, `Blood Group`, `Date Added`, `Expiry Date`, `Status`,`Type`) VALUES (?,?,?,?,?,?,?)";

            PreparedStatement pst=con.prepareStatement(sql);
            
            pst.setString(1, ID);
            pst.setString(2, bgWid);
            pst.setString(3, grp);
            pst.setString(4, adddateWB);
            pst.setString(5, adddateWB1);
            pst.setString(6, statusWB);
            pst.setString(7, "WholeBlood");
            
            
            
            
            
            
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "ADDED SUCCESSFULLY");
      
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
    
    public int fillWBExpiry()
    {
        int ex=0;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","");
            
            String sql="SELECT WholeBlood FROM ExpiryDates";
            PreparedStatement pst=con.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            while(rs.next())
            {
                ex=rs.getInt("WholeBlood");
              
            }
            rs.close();
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return(ex);
    }
    
    public int getRBCExpiry()
    {
        int expDays = 0;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","");
            
            String sql="SELECT `RBC` FROM ExpiryDates";
            PreparedStatement pst=con.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            while(rs.next())
            {
                expDays=rs.getInt("RBC");
              
            }
           
            rs.close();
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
       return(expDays);
    }
    
    public void fillWBBagID()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","");
            
            Statement st= con.createStatement();
            
            ResultSet rs= st.executeQuery("SELECT Max(`Bag ID`) FROM WholeBlood");
            rs.next();
            
        
          
          if(rs.getString("Max(`Bag ID`)")==null)
          {
              txtBagID.setText("WB10001");
          }
          else
          {
              Long wbid= Long.parseLong(rs.getString("Max(`Bag ID`)").substring(2, rs.getString("Max(`Bag ID`)").length()));
              wbid++;
              txtBagID.setText("WB"+String.format("%03d", wbid));
    
          }
            
            
            rs.close();
            st.close();
            con.close();
     
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void fillGrp()
    {
        String id=(String) cmbID.getSelectedItem();
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(id);
        while(m.find()) {
             ID=m.group();
        }
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","");
            
            String sql="SELECT Bloodgrp FROM Donors WHERE ID='"+ID+"'";
            PreparedStatement pst=con.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            while(rs.next())
            {
                String id1=rs.getString("Bloodgrp");
                txtGrp.setText(id1);
  
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
    
    public void addComboID()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","");
            
            String sql="SELECT CONCAT(Name,'--',ID) AS IDName FROM Donors";
            PreparedStatement pst=con.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            while(rs.next())
            {
                String id=rs.getString("IDName");
                cmbID.addItem(id);
                
                
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
    
    
    public AddBlood() {
        initComponents();
        this.setBorder(null);
        BasicInternalFrameUI bui=(BasicInternalFrameUI) this.getUI();
        bui.setNorthPane(null);

        addComboID();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbID = new javax.swing.JComboBox<>();
        txtGrp = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnRBC = new javax.swing.JButton();
        btnWB = new javax.swing.JButton();
        btnPlsma = new javax.swing.JButton();
        pnlComponents = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtExpiryDate = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtBagID = new javax.swing.JTextField();
        lblML = new javax.swing.JLabel();
        txtAddDate = new javax.swing.JTextField();
        addUnit = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        lblUnit = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblType = new javax.swing.JLabel();
        lblShelflife = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        jScrollPane1.setPreferredSize(new java.awt.Dimension(1485, 959));

        jPanel1.setBackground(new java.awt.Color(204, 0, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(1485, 959));
        jPanel1.setLayout(null);

        kGradientPanel1.setBackground(new java.awt.Color(204, 0, 0));
        kGradientPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 14), "ADD BLOOD BAG", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        kGradientPanel1.setkBorderRadius(0);
        kGradientPanel1.setkEndColor(new java.awt.Color(204, 204, 204));
        kGradientPanel1.setkFillBackground(false);
        kGradientPanel1.setkStartColor(new java.awt.Color(204, 204, 204));
        kGradientPanel1.setkTransparentControls(false);
        kGradientPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DONOR ID :");
        kGradientPanel1.add(jLabel1);
        jLabel1.setBounds(460, 90, 112, 34);

        cmbID.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        cmbID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--SELECT ID--" }));
        cmbID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cmbIDFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmbIDFocusLost(evt);
            }
        });
        cmbID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbIDActionPerformed(evt);
            }
        });
        kGradientPanel1.add(cmbID);
        cmbID.setBounds(590, 90, 287, 34);

        txtGrp.setEditable(false);
        txtGrp.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txtGrp.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGrpActionPerformed(evt);
            }
        });
        kGradientPanel1.add(txtGrp);
        txtGrp.setBounds(620, 150, 228, 38);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("BLOOD GROUP :");
        kGradientPanel1.add(jLabel3);
        jLabel3.setBounds(450, 150, 160, 27);

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("CLICK ON THE COMPONENTS YOU WANT TO ADD BELOW");
        kGradientPanel1.add(jLabel4);
        jLabel4.setBounds(440, 210, 470, 30);

        btnRBC.setFont(new java.awt.Font("Verdana", 1, 22)); // NOI18N
        btnRBC.setForeground(new java.awt.Color(0, 51, 51));
        btnRBC.setText("RBC");
        btnRBC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnRBC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRBC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRBCActionPerformed(evt);
            }
        });
        kGradientPanel1.add(btnRBC);
        btnRBC.setBounds(630, 250, 131, 38);

        btnWB.setFont(new java.awt.Font("Verdana", 1, 22)); // NOI18N
        btnWB.setForeground(new java.awt.Color(51, 51, 51));
        btnWB.setText("WHOLE BLOOD");
        btnWB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnWB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnWB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWBActionPerformed(evt);
            }
        });
        kGradientPanel1.add(btnWB);
        btnWB.setBounds(400, 250, 213, 38);

        btnPlsma.setFont(new java.awt.Font("Verdana", 1, 22)); // NOI18N
        btnPlsma.setForeground(new java.awt.Color(0, 51, 51));
        btnPlsma.setText("PLASMA");
        btnPlsma.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnPlsma.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPlsma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlsmaActionPerformed(evt);
            }
        });
        kGradientPanel1.add(btnPlsma);
        btnPlsma.setBounds(770, 250, 155, 38);

        pnlComponents.setBackground(new java.awt.Color(204, 0, 51));
        pnlComponents.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 8));
        pnlComponents.setForeground(new java.awt.Color(255, 255, 255));
        pnlComponents.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("DATE ADDED :");
        pnlComponents.add(jLabel2);
        jLabel2.setBounds(41, 138, 148, 27);

        txtExpiryDate.setEditable(false);
        txtExpiryDate.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        pnlComponents.add(txtExpiryDate);
        txtExpiryDate.setBounds(200, 220, 194, 34);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("BAG ID :");
        pnlComponents.add(jLabel5);
        jLabel5.setBounds(85, 70, 85, 27);

        txtBagID.setEditable(false);
        txtBagID.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        pnlComponents.add(txtBagID);
        txtBagID.setBounds(201, 70, 194, 34);

        lblML.setBackground(new java.awt.Color(255, 255, 255));
        lblML.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblML.setForeground(new java.awt.Color(255, 255, 255));
        pnlComponents.add(lblML);
        lblML.setBounds(410, 290, 220, 32);

        txtAddDate.setEditable(false);
        txtAddDate.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        txtAddDate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAddDateFocusLost(evt);
            }
        });
        pnlComponents.add(txtAddDate);
        txtAddDate.setBounds(201, 138, 194, 34);

        addUnit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        addUnit.setText("ADD 1 UNIT TO GRID");
        addUnit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        addUnit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addUnit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUnitActionPerformed(evt);
            }
        });
        pnlComponents.add(addUnit);
        addUnit.setBounds(410, 420, 200, 52);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("UNIT :");
        pnlComponents.add(jLabel7);
        jLabel7.setBounds(110, 290, 69, 27);

        lblUnit.setEditable(false);
        lblUnit.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        lblUnit.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblUnit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblUnitActionPerformed(evt);
            }
        });
        pnlComponents.add(lblUnit);
        lblUnit.setBounds(200, 290, 194, 32);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("EXPIRY DATE :");
        pnlComponents.add(jLabel8);
        jLabel8.setBounds(40, 220, 148, 27);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("yyyy-mm-dd");
        pnlComponents.add(jLabel9);
        jLabel9.setBounds(410, 220, 141, 27);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Edit Date");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        pnlComponents.add(jLabel11);
        jLabel11.setBounds(550, 140, 88, 27);

        lblType.setBackground(new java.awt.Color(255, 255, 255));
        lblType.setFont(new java.awt.Font("Times New Roman", 1, 32)); // NOI18N
        lblType.setForeground(new java.awt.Color(255, 255, 255));
        lblType.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlComponents.add(lblType);
        lblType.setBounds(100, 20, 424, 37);

        lblShelflife.setBackground(new java.awt.Color(255, 255, 255));
        lblShelflife.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblShelflife.setForeground(new java.awt.Color(255, 255, 255));
        lblShelflife.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlComponents.add(lblShelflife);
        lblShelflife.setBounds(130, 180, 310, 30);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("yyyy-mm-dd");
        pnlComponents.add(jLabel14);
        jLabel14.setBounds(410, 140, 141, 27);

        jLabel10.setIcon(new javax.swing.ImageIcon("C:\\Users\\Sufyan\\Downloads\\cassi-josh-lhnOvu72BM8-unsplash.jpg")); // NOI18N
        jLabel10.setText("jLabel10");
        pnlComponents.add(jLabel10);
        jLabel10.setBounds(10, 10, 640, 490);

        kGradientPanel1.add(pnlComponents);
        pnlComponents.setBounds(330, 300, 660, 510);

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Sufyan\\Downloads\\cassi-josh-lhnOvu72BM8-unsplash.jpg")); // NOI18N
        jLabel6.setText("jLabel6");
        kGradientPanel1.add(jLabel6);
        jLabel6.setBounds(10, 30, 1240, 830);

        jPanel1.add(kGradientPanel1);
        kGradientPanel1.setBounds(100, 13, 1267, 868);

        jLabel12.setIcon(new javax.swing.ImageIcon("C:\\Users\\Sufyan\\Downloads\\cassi-josh-lhnOvu72BM8-unsplash.jpg")); // NOI18N
        jLabel12.setText("jLabel12");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(0, 0, 1450, 910);

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1469, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 923, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtGrpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGrpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGrpActionPerformed

    private void cmbIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbIDFocusLost
        
        
        
    }//GEN-LAST:event_cmbIDFocusLost

    private void btnWBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWBActionPerformed
       

        if(txtGrp.getText().equals("") || cmbID.getSelectedItem().equals("--SELECT ID--"))
        {
            JOptionPane.showMessageDialog(null, "SELECT DONOR ID AND BLOOD GROUP FIRST");
        }
        else
        {
            lblType.setText("WHOLE BLOOD");
            lblML.setText("approx 450ml");
            lblUnit.setText("1");
            DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
            Date date=new Date();
            txtAddDate.setText(df.format(date));
            fillWBBagID();
            
            expirydate= fillWBExpiry();
            lblShelflife.setText("Shelf Life "+expirydate+" Days");
  
            DateFormat df1=new SimpleDateFormat("yyyy-MM-dd");
            Calendar cal=Calendar.getInstance();
            cal.add(Calendar.DATE, expirydate);
            String expdate=df1.format(cal.getTime());
            txtExpiryDate.setText(expdate);  
 
        }

    }//GEN-LAST:event_btnWBActionPerformed

    private void btnRBCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRBCActionPerformed
        
        if(txtGrp.getText().equals("") || cmbID.getSelectedItem().equals("--SELECT ID--"))
        {
            JOptionPane.showMessageDialog(null, "SELECT DONOR ID AND BLOOD GROUP FIRST");
        }
        else
        {
            lblType.setText("RED BLOOD CELLS");
            lblML.setText("approx 220-350ml");
            lblUnit.setText("1");
            DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
            Date date=new Date();
            txtAddDate.setText(df.format(date));
            fillRBCBagID();
            
            expirydate=getRBCExpiry();
            lblShelflife.setText("Shelf life "+expirydate+" Days");
            
            DateFormat df1=new SimpleDateFormat("yyyy-MM-dd");
            Calendar cal=Calendar.getInstance();
            cal.add(Calendar.DATE, expirydate);
            String expdate=df1.format(cal.getTime());
            txtExpiryDate.setText(expdate);
        }
    }//GEN-LAST:event_btnRBCActionPerformed
///////////////////////  GUI IMPLEMENTATION
    
    private void btnPlsmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlsmaActionPerformed
 
        if(txtGrp.getText().equals("") || cmbID.getSelectedItem().equals("--SELECT ID--"))
        {
            JOptionPane.showMessageDialog(null, "SELECT DONOR ID AND BLOOD GROUP FIRST");
        }
        else
        {
            lblType.setText("PLASMA");
            lblML.setText("approx 200-250ml");
            lblUnit.setText("1");
            DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
            Date date=new Date();
            txtAddDate.setText(df.format(date));
           
            fillPlasmaBagID();
            
            
            expirydate=getPsExpiry();
            lblShelflife.setText("Shelf life "+expirydate+" Days");
            
            DateFormat df1=new SimpleDateFormat("yyyy-MM-dd");
            Calendar cal=Calendar.getInstance();
            cal.add(Calendar.DATE, expirydate);
            String expdate=df1.format(cal.getTime());
            txtExpiryDate.setText(expdate);
        }
       
    }//GEN-LAST:event_btnPlsmaActionPerformed

    private void lblUnitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblUnitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblUnitActionPerformed

    private void addUnitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUnitActionPerformed

        if(ID.equals("") || txtGrp.getText().equals("") || txtBagID.getText().equals("") || txtAddDate.getText().equals("") || txtExpiryDate.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "ALL FIELDS ARE MANDATORY");
        }
        else
        {
            if(txtBagID.getText().substring(0, 2).equals("WB"))
            {
                addWBUnit();
            }
            else if(txtBagID.getText().substring(0, 2).equals("RB"))
            {
                addRBCUnit();
            }
            else
            {
                addPlasmaUnit();
            }
        }
        txtBagID.setText("");
        txtAddDate.setText("");
        txtExpiryDate.setText("");        
    }//GEN-LAST:event_addUnitActionPerformed

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
     
        txtAddDate.setEditable(true);
        
        
    }//GEN-LAST:event_jLabel11MouseClicked

    private void txtAddDateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAddDateFocusLost
       
        try {
                 String getdate=txtAddDate.getText();
                Date d1=new SimpleDateFormat("yyyy-MM-dd").parse(getdate);
                
                GregorianCalendar cal=new GregorianCalendar();
                cal.setTime(d1);
                cal.add(Calendar.DATE, expirydate);
                DateFormat df1=new SimpleDateFormat("yyyy-MM-dd");
                Date newDate=cal.getTime();
                txtExpiryDate.setText(df1.format(newDate));
                
                
                
                /*    DateFormat df1=new SimpleDateFormat("yyyy-MM-dd");
                Calendar cal=Calendar.getInstance();
                cal.add(Calendar.DATE, edate);
                String expdate=df1.format(cal.getTime());
                txtExpiryDate.setText(expdate);  */
            } catch (ParseException ex) {
                Logger.getLogger(AddBlood.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }//GEN-LAST:event_txtAddDateFocusLost

    private void cmbIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbIDActionPerformed
        
        fillGrp();
    }//GEN-LAST:event_cmbIDActionPerformed

    private void cmbIDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbIDFocusGained
        
        txtGrp.setText("");
        txtBagID.setText("");
        txtAddDate.setText("");
        txtExpiryDate.setText("");
        
    }//GEN-LAST:event_cmbIDFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addUnit;
    private javax.swing.JButton btnPlsma;
    private javax.swing.JButton btnRBC;
    private javax.swing.JButton btnWB;
    private javax.swing.JComboBox<String> cmbID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JLabel lblML;
    private javax.swing.JLabel lblShelflife;
    private javax.swing.JLabel lblType;
    private javax.swing.JTextField lblUnit;
    private javax.swing.JPanel pnlComponents;
    private javax.swing.JTextField txtAddDate;
    private javax.swing.JTextField txtBagID;
    private javax.swing.JTextField txtExpiryDate;
    private javax.swing.JTextField txtGrp;
    // End of variables declaration//GEN-END:variables
}
