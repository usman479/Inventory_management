/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainFiles;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author pratap
 */
public class addtocart extends javax.swing.JFrame {

    /**
     * Creates new form addtocart
     */
    String roll;
    public addtocart() {
        initComponents();
        viewCart();
        roll="";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        table2.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "item_id", "item_name", "quantity", "unit price", "total price"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table2.setRowHeight(25);
        table2.setRowMargin(3);
        jScrollPane1.setViewportView(table2);
        if (table2.getColumnModel().getColumnCount() > 0) {
            table2.getColumnModel().getColumn(1).setMinWidth(140);
        }

        jButton2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel1.setText("Total Amount");

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N

        jButton3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jButton3.setText("Proceed to bill");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 46, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1003, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(34, 34, 34))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(245, 245, 245)
                                                .addComponent(jLabel1)
                                                .addGap(42, 42, 42)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(322, 322, 322)
                                                .addComponent(jButton3)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addComponent(jButton3)
                                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        viewCart();
    }//GEN-LAST:event_jButton1ActionPerformed

    public void viewCart(){
        DefaultTableModel model = (DefaultTableModel) table2.getModel();
        model.setRowCount(0);
        int  total = 0;
        String tot = "";
        try {
            Connection con = DBConnect.ConnectDb();

            Statement stmt = con.createStatement();
            String query = "select * from cart ";
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()) {
                String id = rs.getString("item_id");
                String name = rs.getString("item_name");
                String qun = rs.getString("quantity");
                String price1 = rs.getString("price");
                String mfd = rs.getString("totprice");

                model.addRow(new Object[] {id,name,qun,price1,mfd});
            }
            rs.close();
        }catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            //e.printStackTrace();
        }
        int sum=0;
        for(int i=0;i<table2.getRowCount();i++)
        {
            sum = sum+Integer.parseInt(table2.getValueAt(i,4).toString());
        }
        jLabel2.setText(Integer.toString(sum));

    }
    private boolean jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DefaultTableModel model = (DefaultTableModel) table2.getModel();
        if(model.getRowCount() == 0){
            this.setVisible(false);
            Searchproduct mm = new Searchproduct();
            mm.setVisible(true);
            return true;
        }
        if (JOptionPane.showConfirmDialog(null, "Do you want to clear cart?", "WARNING",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            // yes option
            DBConnect.truncateBill();

        } else {
            // no option
        }
        this.setVisible(false);
        Searchproduct mm=new Searchproduct();
        mm.setVisible(true);
        return true;
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private boolean jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        DefaultTableModel model=(DefaultTableModel)table2.getModel();
        if(model.getRowCount() == 0){
            JOptionPane.showMessageDialog(this,"Your Cart is Empty.");
            return true;
        }
        if(!workWithDatabase()){
            JOptionPane.showMessageDialog(null, "Quantity not available",
                    "Hey!", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        try {
            Connection con = DBConnect.ConnectDb();
            int i = 0;
            int success = 0;
            String random_int = Integer.toString((int)Math.floor(Math.random()*(9999-99+1)+99));
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date();
            String currentDate = formatter.format(date);
            while (model.getRowCount() > i){
                String a=model.getValueAt(i,0).toString();
                String b=model.getValueAt(i,1).toString();
                String c=model.getValueAt(i,2).toString();
                String d=model.getValueAt(i,3).toString();
                String e=model.getValueAt(i,4).toString();
                String query = "insert into bill(item_id,item_name,quantity,price,totprice,date,bill_no) values('"+a+"','"+b+"','"+c+"','"+d+"','"+e+"','"+currentDate+"','"+random_int+"')";
                PreparedStatement pst = con.prepareStatement(query);
                success = pst.executeUpdate();
                i++;
            }
            if(success==1) {
                JOptionPane.showMessageDialog(this, "Product Successfully Added to bill ");
                this.setVisible(false);
                bill mm=new bill();
                mm.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Problem in Saving. Retry");
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return true;
    }


    public boolean workWithDatabase() {
        Connection c=null;
        Statement  s=null;
        ResultSet rs1=null;
        int flag=0;
        try{
            c=DBConnect.ConnectDb();
            s=c.createStatement();

            DefaultTableModel model = (DefaultTableModel) table2.getModel();
            int i=0;
            while (model.getRowCount() > i) {
                String a=model.getValueAt(i,0).toString();
                String c1=model.getValueAt(i,2).toString();
                String s1=a;
                int id=Integer.parseInt(c1);
                rs1 = s.executeQuery ("select quantity from items where item_id="+"'"+s1+"'");
                while(rs1.next()) {
                    String id1=rs1.getString("quantity");
                    int id2=Integer.parseInt(id1);
                    int id3=id2-id;
                    System.out.println("ye"+id3);
                    if(id3 < 0){
                        return false;
                    }
                    s.executeUpdate("Update items set quantity="+id3+" where item_id="+"'"+s1+"'");
                }
                i++;
            }
            rs1.close();
        } catch(SQLException | ClassNotFoundException e1) {
            System.out.println(e1);
        }
        try {
            Connection con = DBConnect.ConnectDb();

            Statement stmt = con.createStatement();
            String query = "delete from cart ";

            int success=stmt.executeUpdate(query);

        } catch (Exception e) {
        }
        return true;
//  String b=jLabel2.getText();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(addtocart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addtocart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addtocart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addtocart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addtocart().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table2;
    // End of variables declaration
}
