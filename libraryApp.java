package javaapplication1;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultListModel;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

public class libraryApp extends javax.swing.JFrame {
    public libraryApp() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // Coding of Search Button
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger"
            );
            Statement stmt1 = con.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE
            );

            String table_name = "";
            if (jRadioButton1.isSelected()) {
                table_name = "book";
            }
            if (jRadioButton2.isSelected()) {
                table_name = "book_issued";
            }

            int bn = Integer.parseInt(jTextField1.getText());
            ResultSet rs1 = stmt1.executeQuery(
                "select * from " + table_name + " where book_no=" + bn
            );

            if (rs1.next()) {
                jTextField2.setText(rs1.getString(2));
                jTextField3.setText(rs1.getString(3));
                jTextField4.setText(rs1.getString(4));
                jTextField2.setForeground(Color.BLACK);
                jTextField3.setForeground(Color.BLACK);
                jTextField4.setForeground(Color.BLACK);
            } else {
                jTextField2.setText("No such record");
                jTextField3.setText("No such record");
                jTextField4.setText("No such record");
                jTextField2.setForeground(Color.red);
                jTextField3.setForeground(Color.red);
                jTextField4.setForeground(Color.red);
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // coding of clear button
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
    }

    // coding of Issue button
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger"
            );
            Statement stmt1 = con.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE
            );
            Statement stmt2 = con.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE
            );

            int bn = Integer.parseInt(jTextField1.getText());
            String bname = jTextField2.getText();
            String aname = jTextField3.getText();
            String pub = jTextField4.getText();

            stmt1.executeUpdate(
                "insert into book_issued values(" + bn + ",'" + bname + "','" + aname + "','" + pub + "')"
            );
            stmt2.executeUpdate("delete from book where book_no=" + bn);

            JOptionPane.showMessageDialog(null, "Book is issued and added into table book_issued");

            jTextField1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
            jTextField4.setText("");

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // coding of return button
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger"
            );
            Statement stmt1 = con.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE
            );
            Statement stmt2 = con.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE
            );

            int bn = Integer.parseInt(jTextField1.getText());
            String bname = jTextField2.getText();
            String aname = jTextField3.getText();
            String pub = jTextField4.getText();

            stmt1.executeUpdate(
                "insert into book values(" + bn + ",'" + bname + "','" + aname + "','" + pub + "')"
            );
            stmt2.executeUpdate("delete from book_issued where book_no=" + bn);

            JOptionPane.showMessageDialog(null, "Book is returned and added into table book");

            jTextField1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
            jTextField4.setText("");

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Coding for main()
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new libraryApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration
}