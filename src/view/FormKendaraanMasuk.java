package view;
import model.KoneksiDB;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import javax.swing.Timer;
import java.awt.HeadlessException;

public class FormKendaraanMasuk extends javax.swing.JFrame {
    public static String no, plat_no, jns, jmmasuk, tglmasuk;
    KoneksiDB connector = new KoneksiDB();
    
    private DefaultTableModel model;
    
    public FormKendaraanMasuk() {
        initComponents();
        setTitle("Kendaraan Masuk");
        tglskrg();
        Tampil_Jam();
        
        model = new DefaultTableModel();
        tabledata.setModel(model);
        model.addColumn("No Tiket");
        model.addColumn("Tanggal Masuk");
        model.addColumn("Nomor Plat");
        model.addColumn("Jenis Kendaraan");
        model.addColumn("Jam Masuk");
        
        getData();
    }
    
    public void Tampil_Jam(){
        ActionListener taskPerformer = new ActionListener() {
 
        @Override
            public void actionPerformed(ActionEvent evt) {
            String nol_jam = "", nol_menit = "",nol_detik = "";
 
            java.util.Date dateTime = new java.util.Date();
            int nilai_jam = dateTime.getHours();
            int nilai_menit = dateTime.getMinutes();
            int nilai_detik = dateTime.getSeconds();
 
            if(nilai_jam <= 9) nol_jam= "0";
            if(nilai_menit <= 9) nol_menit= "0";
            if(nilai_detik <= 9) nol_detik= "0";
 
            String jam = nol_jam + Integer.toString(nilai_jam);
            String menit = nol_menit + Integer.toString(nilai_menit);
            String detik = nol_detik + Integer.toString(nilai_detik);
 
            txtJam.setText(jam+":"+menit+":"+detik+"");
            }
        };
    new Timer(1000, taskPerformer).start();
    }   
    
    public void tglskrg(){
        Date skrg= new Date();
        SimpleDateFormat format= new SimpleDateFormat("dd-MM-yyyy");
        String tgl = format.format(skrg);
        txtTanggal.setText(format.format(skrg));
    }
    
    public void getData(){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        try{
            Statement stat = connector.getConnection().createStatement( );
            String sql        = "Select * from parkirmasuk";
            ResultSet res   = stat.executeQuery(sql);
            
            while(res.next()){
                Object[] obj = new Object[5];
                obj[0] = res.getString("notiket");
                obj[1] = res.getString("tanggalmasuk");
                obj[2] = res.getString("noplat");
                obj[3] = res.getString("jeniskendaraan");
                obj[4] = res.getString("jammasuk");
                model.addRow(obj);
            }
        }
        catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage() );
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNoTiket = new javax.swing.JTextField();
        txtPlat = new javax.swing.JTextField();
        txtTanggal = new javax.swing.JTextField();
        txtJam = new javax.swing.JTextField();
        CBKendaraan = new javax.swing.JComboBox<>();
        btnSimpan = new javax.swing.JButton();
        kem = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabledata = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 153, 255));

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));

        jLabel1.setText("No Tiket");

        jLabel2.setText("Plat No");

        jLabel3.setText("Jenis Kendaraan");

        jLabel4.setText("Tanggal Masuk");

        jLabel5.setText("Jam Masuk");

        txtTanggal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTanggalActionPerformed(evt);
            }
        });

        txtJam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJamActionPerformed(evt);
            }
        });

        CBKendaraan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mobil", "Motor", "Sepeda" }));

        btnSimpan.setText("Masuk");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        kem.setText("Menu Utama");
        kem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kemActionPerformed(evt);
            }
        });

        btnUbah.setText("Ubah");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        tabledata.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No Tiket", "Plat Nomor", "Jenis Kendaraan", "Tanggal Masuk", "Jam Masuk"
            }
        ));
        tabledata.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabledataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabledata);

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel6.setText("Kendaraan Masuk");

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(253, 253, 253)
                        .addComponent(kem))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNoTiket)
                            .addComponent(txtPlat)
                            .addComponent(CBKendaraan, 0, 100, Short.MAX_VALUE)
                            .addComponent(txtTanggal)
                            .addComponent(txtJam))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnReset, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                            .addComponent(btnUbah, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSimpan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(kem))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNoTiket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(btnReset))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(txtPlat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnUbah, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CBKendaraan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(btnSimpan))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtJam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:
        no = txtNoTiket.getText();
        plat_no = txtPlat.getText();
        jns = (String)CBKendaraan.getSelectedItem();
        jmmasuk = txtJam.getText();
        tglmasuk = txtTanggal.getText();

        if(no.equals("")||tglmasuk.equals("")||plat_no.equals("")||jns.equals("")||jmmasuk.equals("")){
            JOptionPane.showMessageDialog(null, "HARAP MASUKAN DATA LENGKAP!");
        }
        else{
            try {
                String query = "UPDATE `parkirmasuk` SET `noplat` = '"+plat_no+"', `jeniskendaraan` = '"+jns+"', `tanggalmasuk` = '"+tglmasuk+"', `jammasuk` = '"+jmmasuk+"' WHERE notiket = '"+no+"'";
                connector.statement = connector.koneksi.createStatement();
                connector.statement.executeUpdate(query);

                System.out.println("Data Berhasil diubah");
                JOptionPane.showMessageDialog(null,"Data Berhasil Diubah!!");
                
                getData();
            }
            catch (HeadlessException | SQLException ex){
                System.out.println(ex.getMessage());
                JOptionPane.showMessageDialog(null, "Data Gagal Diubah");
            }
        }
    }//GEN-LAST:event_btnUbahActionPerformed

    private void kemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kemActionPerformed
        // TODO add your handling code here:
        HomePage kem = new HomePage(); //menuju halaman home penjual
        kem.setVisible(true);
        dispose();
    }//GEN-LAST:event_kemActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        no = txtNoTiket.getText();
        plat_no = txtPlat.getText();
        jns = (String)CBKendaraan.getSelectedItem();
        jmmasuk = txtJam.getText();
        tglmasuk = txtTanggal.getText();

        if(no.equals("")||tglmasuk.equals("")||plat_no.equals("")||jns.equals("")||jmmasuk.equals("")){
            JOptionPane.showMessageDialog(null, "HARAP MASUKAN DATA LENGKAP!");
        }
        else{
            try {
                String query = "INSERT INTO `parkirmasuk` VALUES ('"+no+"','"+tglmasuk+"','"+plat_no+"','"+jns+"','"+jmmasuk+"','','','')";
                connector.statement = connector.koneksi.createStatement();
                connector.statement.executeUpdate(query);

                System.out.println("Data Berhasil disimpan");
                JOptionPane.showMessageDialog(null,"Data Berhasil disimpan!!");
                
                getData();
            }
            catch (HeadlessException | SQLException ex){
                System.out.println(ex.getMessage());
                JOptionPane.showMessageDialog(null, "Data Gagal disimpan");
            }
        }

    }//GEN-LAST:event_btnSimpanActionPerformed

    private void txtJamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJamActionPerformed

    private void txtTanggalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTanggalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTanggalActionPerformed

    private void tabledataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabledataMouseClicked
        // TODO add your handling code here:
        int i = tabledata.getSelectedRow();
        if (i == -1){
            return;
        }
        txtNoTiket.setText(tabledata.getValueAt(i, 0).toString());
        txtPlat.setText(tabledata.getValueAt(i, 2).toString());
        
    }//GEN-LAST:event_tabledataMouseClicked

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        txtNoTiket.setText("");
        txtPlat.setText("");
    }//GEN-LAST:event_btnResetActionPerformed

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
            java.util.logging.Logger.getLogger(FormKendaraanMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormKendaraanMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormKendaraanMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormKendaraanMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormKendaraanMasuk().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CBKendaraan;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUbah;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton kem;
    private javax.swing.JTable tabledata;
    private javax.swing.JTextField txtJam;
    private javax.swing.JTextField txtNoTiket;
    private javax.swing.JTextField txtPlat;
    private javax.swing.JTextField txtTanggal;
    // End of variables declaration//GEN-END:variables
}
