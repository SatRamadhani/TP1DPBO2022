/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tp1dpbo2022;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Satria Ramadhani
 */
public class Display extends javax.swing.JFrame
{
    private String currentContent = "author";
    private DBConnection con = new DBConnection();
    private ArrayList<PanelAuthor> dataAuthor;
    private ArrayList<PanelBook> dataBook;
    
    public Display()
    {
        initComponents();
        initAuthor();
    }
    
    public void initAuthor()
    {
        dataAuthor = new ArrayList<PanelAuthor>();
        dataPanel.removeAll();
        dataPanel.setLayout(new GridLayout(0, 1, 20, 20));
        
        try
        {
            String query = "SELECT * FROM author;";
            ResultSet res = con.query(query);
            
            int i = 0;
            while(res.next())
            {
                dataAuthor.add(new PanelAuthor(con, dataPanel, res.getInt("id"),
                                               res.getString("name"),
                                               res.getInt("total_book")));
                dataPanel.add(dataAuthor.get(i));
                i++;
            }
        } catch (Exception e)
        {
            System.err.println("Read failed: " + e.getMessage());
        }
        
        
        dataPanel.revalidate();
        dataPanel.repaint();
    }
    
    public void initBook()
    {
        dataBook = new ArrayList<PanelBook>();
        dataPanel.removeAll();
        dataPanel.setLayout(new GridLayout(0, 1, 20, 20));
        
        try
        {
            String query = "SELECT * FROM book;";
            ResultSet res = con.query(query);
            
            int i = 0;
            while(res.next())
            {
                dataBook.add(new PanelBook(con, dataPanel, res.getInt("id"),
                                           res.getString("title"),
                                           res.getString("publisher"),
                                           res.getString("author"),
                                           res.getString("description")));
                dataPanel.add(dataBook.get(i));
                i++;
            }
        } catch (Exception e)
        {
            System.err.println("Read failed: " + e.getMessage());
        }
        
        
        dataPanel.revalidate();
        dataPanel.repaint();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        btnBook = new javax.swing.JButton();
        btnAuthor = new javax.swing.JButton();
        btnSwitch = new javax.swing.JButton();
        scrollPanel = new javax.swing.JScrollPane();
        dataPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("TP #1 - DPBO 2022");

        btnBook.setText("Add Book");
        btnBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookActionPerformed(evt);
            }
        });

        btnAuthor.setText("Add Author");
        btnAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAuthorActionPerformed(evt);
            }
        });

        btnSwitch.setText("Switch Content");
        btnSwitch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSwitchActionPerformed(evt);
            }
        });

        scrollPanel.setBackground(new java.awt.Color(255, 255, 255));

        dataPanel.setBackground(new java.awt.Color(245, 245, 245));

        javax.swing.GroupLayout dataPanelLayout = new javax.swing.GroupLayout(dataPanel);
        dataPanel.setLayout(dataPanelLayout);
        dataPanelLayout.setHorizontalGroup(
            dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 466, Short.MAX_VALUE)
        );
        dataPanelLayout.setVerticalGroup(
            dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );

        scrollPanel.setViewportView(dataPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAuthor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBook, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btnSwitch)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrollPanel))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBook)
                    .addComponent(btnSwitch))
                .addGap(18, 18, 18)
                .addComponent(btnAuthor)
                .addGap(18, 18, 18)
                .addComponent(scrollPanel)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookActionPerformed
        // TODO add your handling code here:
        FormBook formBook = new FormBook(con, dataPanel);
        formBook.setVisible(true);
    }//GEN-LAST:event_btnBookActionPerformed

    private void btnAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAuthorActionPerformed
        // TODO add your handling code here:
        FormAuthor formAuthor = new FormAuthor(con, dataPanel);
        formAuthor.setVisible(true);
    }//GEN-LAST:event_btnAuthorActionPerformed

    private void btnSwitchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSwitchActionPerformed
        // TODO add your handling code here:
        if(currentContent == "author")
        {
            initBook();
            currentContent = "book";
        }
        else if(currentContent == "book")
        {
            initAuthor();
            currentContent = "author";
        }
    }//GEN-LAST:event_btnSwitchActionPerformed

    public static void main(String args[])
    {
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
            java.util.logging.Logger.getLogger(Display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new Display().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAuthor;
    private javax.swing.JButton btnBook;
    private javax.swing.JButton btnSwitch;
    private javax.swing.JPanel dataPanel;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JScrollPane scrollPanel;
    // End of variables declaration//GEN-END:variables
}
