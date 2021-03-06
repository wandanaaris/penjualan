/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Wandana
 */
public class FormBarang extends javax.swing.JFrame {
    public Statement st;
    public ResultSet rs;
    public DefaultTableModel tabModel;
    Connection cn = config.koneksidb.getKoneksi();
    /**
     * Creates new form FormBarang
     */
    public FormBarang() {
        initComponents();
        judul();
        tampilData();
        setLocationRelativeTo(null);
    }
    
    public void reset() {
        Tkdbarang.setText("");
        Tnama.setText("");
        Tharga.setText("");
        Tstok.setText("");
        Tkdbarang.setEnabled(true);
        Bsave.setEnabled(true);
        Bedit.setEnabled(true);
        Bdelete.setEnabled(true);
    }
        
    public void judul() {
        Object[] judul = {"KODE BARANG", "NAMA BARANG", "HARGA", "SATUAN", "STOCK"};
        tabModel = new DefaultTableModel(null, judul);
        TBbarang.setModel(tabModel);
    }
    
    public void tampilData(){
        try {
           st = cn.createStatement();
            tabModel.getDataVector().removeAllElements();
            tabModel.fireTableDataChanged();
            rs = st.executeQuery("select * from barang");
            while (rs.next()) {
                Object[] data = {
                   rs.getString("kd_barang"),
                   rs.getString("nm_barang"),
                   rs.getString("harga"),
                   rs.getString("satuan"),
                   rs.getString("stok")
                };
                tabModel.addRow(data);
            }
        } catch (Exception e) {
          e.printStackTrace();  
        }
        reset();
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Tnama = new javax.swing.JTextField();
        Tstok = new javax.swing.JTextField();
        Csatuan = new javax.swing.JComboBox<>();
        Bcari = new javax.swing.JButton();
        Tharga = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        TBbarang = new javax.swing.JTable();
        Bsave = new javax.swing.JButton();
        Badd = new javax.swing.JButton();
        Bedit = new javax.swing.JButton();
        Bdelete = new javax.swing.JButton();
        Breset = new javax.swing.JButton();
        Bkeluar = new javax.swing.JButton();
        Tkdbarang = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel1.setText("DATA BARANG");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, -1, -1));

        jLabel3.setText("Kode Barang");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, 20));

        jLabel4.setText("Harga");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, 20));

        jLabel5.setText("Satuan");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, 20));

        jLabel7.setText("Stock");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, 20));

        jLabel10.setText("Nama");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, 20));

        Tnama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TnamaActionPerformed(evt);
            }
        });
        getContentPane().add(Tnama, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 220, -1));

        Tstok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TstokActionPerformed(evt);
            }
        });
        getContentPane().add(Tstok, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 220, -1));

        Csatuan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Unit", "Buah", "Pcs", "Batang", "Dus" }));
        Csatuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CsatuanActionPerformed(evt);
            }
        });
        getContentPane().add(Csatuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 220, -1));

        Bcari.setText("Cari");
        Bcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BcariActionPerformed(evt);
            }
        });
        getContentPane().add(Bcari, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 60, -1));

        Tharga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThargaActionPerformed(evt);
            }
        });
        getContentPane().add(Tharga, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 220, -1));

        TBbarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TBbarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBbarangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TBbarang);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 480, 220));

        Bsave.setText("Simpan");
        Bsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BsaveActionPerformed(evt);
            }
        });
        getContentPane().add(Bsave, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, 80, -1));

        Badd.setText("Tambah");
        Badd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BaddActionPerformed(evt);
            }
        });
        getContentPane().add(Badd, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 70, 80, -1));

        Bedit.setText("Update");
        Bedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BeditActionPerformed(evt);
            }
        });
        getContentPane().add(Bedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, 80, -1));

        Bdelete.setText("Delete");
        Bdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BdeleteActionPerformed(evt);
            }
        });
        getContentPane().add(Bdelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 160, 80, -1));

        Breset.setText("Reset");
        Breset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BresetActionPerformed(evt);
            }
        });
        getContentPane().add(Breset, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, -1, -1));

        Bkeluar.setText("Keluar");
        Bkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BkeluarActionPerformed(evt);
            }
        });
        getContentPane().add(Bkeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 100, -1, -1));
        getContentPane().add(Tkdbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 150, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TnamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TnamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TnamaActionPerformed

    private void TstokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TstokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TstokActionPerformed

    private void CsatuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CsatuanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CsatuanActionPerformed

    private void BcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BcariActionPerformed
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM barang where kd_barang ='"+
                Tkdbarang.getText()+"'");
            while (rs.next()){

                Tnama.setText(rs.getString(2));
                Tharga.setText(rs.getString(3));
                Csatuan.setSelectedItem(rs.getString(4));
                Tstok.setText(rs.getString(5));
                
                JOptionPane.showMessageDialog(rootPane, "Ini Datanya Berdasarkan Kode Barang = '"+Tkdbarang.getText()+"' ");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "eror"+e);
        }
    }//GEN-LAST:event_BcariActionPerformed

    private void ThargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ThargaActionPerformed

    private void TBbarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBbarangMouseClicked
        try {
            Tkdbarang.setText(tabModel.getValueAt(TBbarang.getSelectedRow(), 0).toString());
            Tnama.setText(tabModel.getValueAt(TBbarang.getSelectedRow(), 1).toString());
            Tharga.setText(tabModel.getValueAt(TBbarang.getSelectedRow(), 2).toString());
            Csatuan.setSelectedItem(tabModel.getValueAt(TBbarang.getSelectedRow(), 3).toString());
            Tstok.setText(tabModel.getValueAt(TBbarang.getSelectedRow(), 4).toString());
            Bsave.setEnabled(false);
            Bedit.setEnabled(true);
            Bdelete.setEnabled(true);
            Tkdbarang.setEnabled(false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_TBbarangMouseClicked

    private void BsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BsaveActionPerformed
        if (Tkdbarang.getText().isEmpty() || Tnama.getText().isEmpty() || Tharga.getText().isEmpty() || Tstok.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Lengkapi Data!");
        } else {
          try {
              st = cn.createStatement();
              st.executeUpdate("INSERT INTO barang VALUES('"+
                      Tkdbarang.getText()+"','"+
                      Tnama.getText()+"','"+
                      Tharga.getText()+"','"+
                      Csatuan.getSelectedItem()+"','"+
                      Tstok.getText()+"')");
              JOptionPane.showMessageDialog(null, "Berhasil Disimpan");
                tampilData();
                reset();
          } catch (Exception e) {
              e.printStackTrace();
          }
      }
    }//GEN-LAST:event_BsaveActionPerformed

    private void BeditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BeditActionPerformed
       if (Tkdbarang.getText().isEmpty() || Tnama.getText().isEmpty() || Tharga.getText().isEmpty() || Tstok.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Lengkapi Data!");
       } else {
           try {
               st = cn.createStatement();
                st.executeUpdate("UPDATE barang set nm_barang='"+Tnama.getText()
                        + "', harga='"+Tharga.getText()
                        + "', satuan='"+Csatuan.getSelectedItem()
                        + "', stok='"+ Tstok.getText()
                        + "' WHERE kd_barang='"+ Tkdbarang.getText()+"'");
                JOptionPane.showMessageDialog(null, "Berhasil Diupdate");
                tampilData();
                reset();
           } catch (Exception e) {
               e.printStackTrace();
           }
       }
    }//GEN-LAST:event_BeditActionPerformed

    private void BdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BdeleteActionPerformed
        int jawab;
        if ((jawab = JOptionPane.showConfirmDialog(null, "Ingin Menghapus Data?", "Konfirmasi", JOptionPane.YES_NO_OPTION)) == 0) {
            try {
              st = cn.createStatement();
                st.executeUpdate("delete from barang where kd_barang='" + Tkdbarang.getText()+ "'");
                JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
                tampilData();
                reset();  
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_BdeleteActionPerformed

    private void BkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BkeluarActionPerformed
        int selectedOption = JOptionPane.showConfirmDialog(null,
        "Apakah anda akan menutup system?", "Tutup Aplikasi", JOptionPane.YES_NO_OPTION);
        if (selectedOption == JOptionPane.YES_OPTION) {
        System.exit(0);
        }
    }//GEN-LAST:event_BkeluarActionPerformed

    private void BresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BresetActionPerformed
      reset();
    }//GEN-LAST:event_BresetActionPerformed

    private void BaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BaddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BaddActionPerformed

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
            java.util.logging.Logger.getLogger(FormBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormBarang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Badd;
    private javax.swing.JButton Bcari;
    private javax.swing.JButton Bdelete;
    private javax.swing.JButton Bedit;
    private javax.swing.JButton Bkeluar;
    private javax.swing.JButton Breset;
    private javax.swing.JButton Bsave;
    private javax.swing.JComboBox<String> Csatuan;
    private javax.swing.JTable TBbarang;
    private javax.swing.JTextField Tharga;
    private javax.swing.JTextField Tkdbarang;
    private javax.swing.JTextField Tnama;
    private javax.swing.JTextField Tstok;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
