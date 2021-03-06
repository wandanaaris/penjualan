/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Wandana
 */
public class FormTransaksi extends javax.swing.JFrame {
    public Statement st;
    public ResultSet rs;
    public DefaultTableModel tabModel;
    Connection cn = config.koneksidb.getKoneksi();
    DecimalFormat df = new DecimalFormat("##,###,###.-");
    double total, bayar, kembali, kali, jumlahtransaksi, harga;
    /**
     * Creates new form FormTransaksi
     */
    public FormTransaksi() {
        initComponents(); 
        judul();
        tampilData();
        no_transaksi();
        setLocationRelativeTo(null);
        Tnotransaksi.setText(String.valueOf(no_transaksi()));
        Tnotransaksi.setEditable(false);
        Tnamabarang.setEditable(false);
        Tharga.setEditable(false);
        Ttotal.setEditable(false);
        Tkembalian.setEditable(false);
    }
    
    private int no_transaksi() {
        String noAwal = null;
        int noSekarang = 0;
        try {
            String sql = "SELECT MAX(no_trans) AS sekarang FROM transaksi";
            rs = st.executeQuery(sql);
            if (rs.next()) {
                noAwal = rs.getString("sekarang");
            }

            if (noAwal == null) {
                noSekarang = 1;
            } else {
                noSekarang = Integer.valueOf(noAwal) + 1;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return noSekarang;
    }
    
   
    public void judul() {
        Object[] judul = {"NO TRANS", "TANGGAL", "No Pelanggan", "NAMA PELANGGAN", "KODE BARANG", "NAMA BARANG","JUMLAH", "TOTAL"};
        tabModel = new DefaultTableModel(null, judul);
        TBtransaksi.setModel(tabModel);
    }
    
        public void tampilData(){
        try {
            
           st = cn.createStatement();
            tabModel.getDataVector().removeAllElements();
            tabModel.fireTableDataChanged();
            rs = st.executeQuery("SELECT transaksi.no_trans, transaksi.tgl_trans, pelanggan.id_pel, pelanggan.nm_pel, barang.kd_barang, barang.nm_barang, transaksi.jlh_transaksi, (barang.harga*transaksi.jlh_transaksi) as total FROM transaksi JOIN pelanggan ON transaksi.id_pel = pelanggan.id_pel JOIN barang ON transaksi.kd_barang = barang.kd_barang");
            while (rs.next()) {
                Object[] data = {
                   rs.getString("transaksi.no_trans"),
                   rs.getString("transaksi.tgl_trans"),
                   rs.getString("pelanggan.id_pel"),
                   rs.getString("pelanggan.nm_pel"),
                   rs.getString("barang.kd_barang"),
                   rs.getString("barang.nm_barang"),
                   rs.getString("transaksi.jlh_transaksi"),
                   rs.getString("total")
                };
                tabModel.addRow(data);
            }
        } catch (Exception e) {
          e.printStackTrace();  
        }
        reset();
    }
    
    public void reset() {
        Tnamapelanggan.setText("");
        Talamat.setText("");
        Tnotransaksi.setText("");
        Tkdbarang.setText("");
        Tnamabarang.setText("");
        Tharga.setText("");
        Tjumlahtransaksi.setText("");
        Ttotal.setText("");
        Tbayar.setText("");
        Tkembalian.setText("");
        Tkdbarang.setEnabled(true);

    }
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Talamat = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        TBtransaksi = new javax.swing.JTable();
        Breset = new javax.swing.JButton();
        Bkeluar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        Tnotransaksi = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Tnamabarang = new javax.swing.JTextField();
        Bcari = new javax.swing.JButton();
        Tharga = new javax.swing.JTextField();
        Tkdbarang = new javax.swing.JTextField();
        DTtgltransaksi = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        Tidpelanggan = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        Tjumlahtransaksi = new javax.swing.JTextField();
        Ttotal = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        Tbayar = new javax.swing.JTextField();
        Tkembalian = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        Bsimpan = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        Tnamapelanggan = new javax.swing.JTextField();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel1.setText("TRANSAKSI");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 110, 40));

        jLabel4.setText("Alamat");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, 20));

        jLabel10.setText("No Pel");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, 20));

        Talamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TalamatActionPerformed(evt);
            }
        });
        getContentPane().add(Talamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 170, 40));

        TBtransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TBtransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBtransaksiMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TBtransaksi);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, 1044, 530));

        Breset.setText("Reset");
        Breset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BresetActionPerformed(evt);
            }
        });
        getContentPane().add(Breset, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 550, 120, -1));

        Bkeluar.setText("Keluar");
        Bkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BkeluarActionPerformed(evt);
            }
        });
        getContentPane().add(Bkeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 580, 120, -1));

        jLabel6.setText("-------------------------------------------------------------");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 250, -1));
        getContentPane().add(Tnotransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 170, -1));

        jLabel7.setText("Tgl Transaksi");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        jLabel3.setText("Kode Barang");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, 20));

        jLabel5.setText("harga");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, 20));

        jLabel11.setText("Nama");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, 20));

        Tnamabarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TnamabarangActionPerformed(evt);
            }
        });
        getContentPane().add(Tnamabarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, 170, -1));

        Bcari.setText("Cari");
        Bcari.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                BcariFocusGained(evt);
            }
        });
        Bcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BcariActionPerformed(evt);
            }
        });
        getContentPane().add(Bcari, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, 70, -1));

        Tharga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThargaActionPerformed(evt);
            }
        });
        getContentPane().add(Tharga, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, 170, -1));
        getContentPane().add(Tkdbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, 90, -1));
        getContentPane().add(DTtgltransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, 170, -1));

        jLabel8.setText("No Transaksi");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        Tidpelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TidpelangganActionPerformed(evt);
            }
        });
        getContentPane().add(Tidpelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 170, -1));

        jLabel12.setText("Input Data Pelanggan");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel13.setText("Jumlah Trans");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, -1, 20));

        Tjumlahtransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TjumlahtransaksiActionPerformed(evt);
            }
        });
        Tjumlahtransaksi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TjumlahtransaksiKeyPressed(evt);
            }
        });
        getContentPane().add(Tjumlahtransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 390, 170, -1));

        Ttotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TtotalActionPerformed(evt);
            }
        });
        getContentPane().add(Ttotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 440, 170, -1));

        jLabel14.setText("Total");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, -1, 20));

        jLabel15.setText("Bayar");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, -1, 20));

        Tbayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TbayarActionPerformed(evt);
            }
        });
        Tbayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TbayarKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TbayarKeyTyped(evt);
            }
        });
        getContentPane().add(Tbayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 470, 170, -1));

        Tkembalian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TkembalianActionPerformed(evt);
            }
        });
        getContentPane().add(Tkembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 500, 170, -1));

        jLabel16.setText("Kembalian");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, -1, 20));

        Bsimpan.setText("Simpan");
        Bsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BsimpanActionPerformed(evt);
            }
        });
        getContentPane().add(Bsimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 120, -1));

        jLabel9.setText("Input Transaksi");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        jLabel17.setText("Nama");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, 20));

        Tnamapelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TnamapelangganActionPerformed(evt);
            }
        });
        getContentPane().add(Tnamapelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 170, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TalamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TalamatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TalamatActionPerformed

    private void TBtransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBtransaksiMouseClicked

    }//GEN-LAST:event_TBtransaksiMouseClicked

    private void BresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BresetActionPerformed
        reset();
    }//GEN-LAST:event_BresetActionPerformed

    private void TnamabarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TnamabarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TnamabarangActionPerformed

    private void BcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BcariActionPerformed
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM barang where kd_barang ='"+
                Tkdbarang.getText()+"'");
            while (rs.next()){
                Tnamabarang.setText(rs.getString(2));
                Tharga.setText(rs.getString(3));

                
                JOptionPane.showMessageDialog(rootPane, "Ini Datanya Berdasarkan Kode Barang = '"+Tkdbarang.getText()+"' ");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "eror"+e);
        }
    }//GEN-LAST:event_BcariActionPerformed

    private void ThargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ThargaActionPerformed

    private void TidpelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TidpelangganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TidpelangganActionPerformed

    private void TjumlahtransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TjumlahtransaksiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TjumlahtransaksiActionPerformed

    private void BkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BkeluarActionPerformed
        int selectedOption = JOptionPane.showConfirmDialog(null,
            "Apakah anda akan menutup system?", "Tutup Aplikasi", JOptionPane.YES_NO_OPTION);
        if (selectedOption == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_BkeluarActionPerformed

    private void TtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TtotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TtotalActionPerformed

    private void TbayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TbayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TbayarActionPerformed

    private void TkembalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TkembalianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TkembalianActionPerformed

    private void BcariFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BcariFocusGained
     Tjumlahtransaksi.requestFocus();
    }//GEN-LAST:event_BcariFocusGained

    private void TbayarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TbayarKeyPressed
        int ascii = evt.getKeyChar();
        if (ascii == 8) {
            Tkembalian.setText("");
            Tbayar.setText("");
        }
        if ((ascii >= 48 && ascii <= 57)) {
            total = Integer.parseInt(Ttotal.getText().replace(",", "").replace("-", "").replace(".", ""));
            bayar = Integer.parseInt(Tbayar.getText().concat(String.valueOf(evt.getKeyChar())));
            kembali = bayar - total;
            Tkembalian.setText(String.valueOf(df.format(kembali)));
        }
    }//GEN-LAST:event_TbayarKeyPressed

    private void TbayarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TbayarKeyTyped
       char c = evt.getKeyChar();
        if (!(Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE) || c == (KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
        }

    }//GEN-LAST:event_TbayarKeyTyped

    private void TjumlahtransaksiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TjumlahtransaksiKeyPressed
        int ascii = evt.getKeyChar();

        if ((ascii >= 48 && ascii <= 57)) {
            harga = Integer.parseInt(Tharga.getText().replace(",", "").replace("-", "").replace(".", ""));
            jumlahtransaksi = Integer.parseInt(Tjumlahtransaksi.getText().concat(String.valueOf(evt.getKeyChar())));
            kali = harga * jumlahtransaksi;
            Ttotal.setText(String.valueOf(df.format(kali)));
        }
    }//GEN-LAST:event_TjumlahtransaksiKeyPressed

    private void BsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BsimpanActionPerformed
        if (Tidpelanggan.getText().isEmpty() || Talamat.getText().isEmpty() || Tkdbarang.getText().isEmpty() || Tjumlahtransaksi.getText().isEmpty() || Tbayar.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Lengkapi Data!");
        } else {
          try {
              st = cn.createStatement();
              st.executeUpdate("INSERT INTO pelanggan VALUES('"+
                      Tidpelanggan.getText()+"','"+
                      Tnamapelanggan.getText()+"','"+
                      Talamat.getText()+"')");
          } catch (Exception e) {
              System.out.println("Tambah data detail pelanggan gagal : " + e);
          }
          
         try {
              st = cn.createStatement();
              st.executeUpdate("INSERT INTO transaksi VALUES('"+
                      Tnotransaksi.getText()+"','"+
                      new SimpleDateFormat("yyyy-MM-dd").format(DTtgltransaksi.getDate())+"','"+
                      Tidpelanggan.getText()+"','"+
                      Tkdbarang.getText()+"','"+
                      Tjumlahtransaksi.getText()+"')");
                JOptionPane.showMessageDialog(null, "Berhasil Disimpan");
                tampilData();
                reset();
          } catch (Exception e) {
              System.out.println("Tambah data detail transaksi gagal : " + e);
          }
         
   
      }
    }//GEN-LAST:event_BsimpanActionPerformed

    private void TnamapelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TnamapelangganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TnamapelangganActionPerformed

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
            java.util.logging.Logger.getLogger(FormTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormTransaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bcari;
    private javax.swing.JButton Bkeluar;
    private javax.swing.JButton Breset;
    private javax.swing.JButton Bsimpan;
    private com.toedter.calendar.JDateChooser DTtgltransaksi;
    private javax.swing.JTable TBtransaksi;
    private javax.swing.JTextField Talamat;
    private javax.swing.JTextField Tbayar;
    private javax.swing.JTextField Tharga;
    private javax.swing.JTextField Tidpelanggan;
    private javax.swing.JTextField Tjumlahtransaksi;
    private javax.swing.JTextField Tkdbarang;
    private javax.swing.JTextField Tkembalian;
    private javax.swing.JTextField Tnamabarang;
    private javax.swing.JTextField Tnamapelanggan;
    private javax.swing.JTextField Tnotransaksi;
    private javax.swing.JTextField Ttotal;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
