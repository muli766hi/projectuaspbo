/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Project.View;

import java.sql.*;
import javax.swing.*;
/**
 *
 * @author Muliani
 */
public class KonfirmasiAkunFrame extends javax.swing.JFrame {
    static AkunPanel akun;
    /**
     * Creates new form KonfirmasiAkunFrame
     */
    public KonfirmasiAkunFrame() {
        initComponents();
    }

    KonfirmasiAkunFrame(AkunPanel aThis) {
        this.akun = aThis;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        warningLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        idTextField = new javax.swing.JTextField();
        konfirmasiButton = new javax.swing.JButton();
        konfirmasiComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setText("Konfirmasi Akun");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project/account.png"))); // NOI18N

        warningLabel.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel5.setText("ID :");

        idTextField.setBackground(new java.awt.Color(102, 0, 102));
        idTextField.setFont(new java.awt.Font("OCR-A BT", 0, 12)); // NOI18N
        idTextField.setForeground(new java.awt.Color(255, 204, 255));

        konfirmasiButton.setBackground(new java.awt.Color(204, 255, 255));
        konfirmasiButton.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        konfirmasiButton.setForeground(new java.awt.Color(0, 0, 102));
        konfirmasiButton.setText("Konfirmasi");
        konfirmasiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                konfirmasiButtonActionPerformed(evt);
            }
        });

        konfirmasiComboBox.setBackground(new java.awt.Color(102, 0, 102));
        konfirmasiComboBox.setFont(new java.awt.Font("OCR-A BT", 0, 12)); // NOI18N
        konfirmasiComboBox.setForeground(new java.awt.Color(255, 204, 255));
        konfirmasiComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Diterima", "Belum Diterima" }));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel2.setText("Konfirmasi :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(12, 12, 12))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(konfirmasiComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(konfirmasiButton)
                    .addComponent(warningLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(konfirmasiComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(29, 29, 29)
                        .addComponent(warningLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(konfirmasiButton)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private boolean validasi(){
        if("".equals(idTextField.getText())){
            warningLabel.setText("Id tidak boleh kosong");
            return false;
        }
        try{
            Integer.parseInt(idTextField.getText());
        } catch(Exception e){
            warningLabel.setText("Id harus dalam bentuk angka");
            return false;
        }
        return true;
    }
    private void konfirmasiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_konfirmasiButtonActionPerformed
        // TODO add your handling code here:
        if(validasi()){
            try {
                Akun akun = new Akun();
                akun.setKonfirmasi(String.valueOf(konfirmasiComboBox.getSelectedItem()));
                akun.setId(idTextField.getText());
                if(Database.getInstance().konfirmasiAkun(akun)){
                    JOptionPane.showMessageDialog(null,"Akun sudah berhasil dikonfirmasi!");
                    this.akun.loadTableData();
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null,"Akun gagal dikonfirmasi!");
                    this.akun.loadTableData();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_konfirmasiButtonActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField idTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton konfirmasiButton;
    private javax.swing.JComboBox<String> konfirmasiComboBox;
    private javax.swing.JLabel warningLabel;
    // End of variables declaration//GEN-END:variables
}
