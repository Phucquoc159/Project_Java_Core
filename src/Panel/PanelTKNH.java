/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Panel;

import Frame.FrAddTKNH;
import Class.KetNoiSQL;
import Class.TKNH;
import Frame.FrMain;
import static Frame.FrMain.ketNoi;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NHT
 */
public class PanelTKNH extends javax.swing.JPanel {

    /**
     * Creates new form PanelTKNH
     */
    private String maTKNH;
    public PanelTKNH() {
        initComponents();
        layDataTKNH();
    }
    
    public void layDataTKNH() {

        DefaultTableModel dtm = (DefaultTableModel) jTableTKNN.getModel();
        dtm.setNumRows(0);
        
      
        String sql = "select * from TKNH";
        Vector vt;
        try {
            PreparedStatement ps = ketNoi.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TKNH tknh = new TKNH(rs.getString("MaTK"), rs.getString("MaTKNH"), rs.getString("MaNH"), rs.getFloat("SoTien"));

                vt = new Vector();
                vt.add(tknh.getMaTK());
                vt.add(tknh.getMaTKNN());
                vt.add(tknh.getMaNH());

                Locale localeVN = new Locale("vi", "VN");
                NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
                String str1 = currencyVN.format(tknh.getTien());
                vt.add(str1);

                dtm.addRow(vt);
            }
            jTableTKNN.setModel(dtm);
            rs.close();
            ps.close();
           
        } catch (SQLException ex) {
            Logger.getLogger(FrMain.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void xoaTKNH(String maTKNH) {
       
        String sql = "delete from TKNH where MaTKNH = ?";
        try {
            PreparedStatement ps = ketNoi.prepareStatement(sql);
            ps.setString(1, maTKNH);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FrMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane5 = new javax.swing.JScrollPane();
        jTableTKNN = new javax.swing.JTable();
        jButtonAddTKNN = new javax.swing.JButton();
        jButtonDelTKNN = new javax.swing.JButton();
        jButtonBackTKNN = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));

        jTableTKNN.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTableTKNN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "MãTK", "MãTKNN","Tên Ngân Hàng","Số Tiền"
            }
        ));
        jTableTKNN.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTableTKNN.setFillsViewportHeight(true);
        jTableTKNN.setFocusable(false);
        jTableTKNN.setRowHeight(30);
        jTableTKNN.setSelectionBackground(new java.awt.Color(255, 0, 0));
        jTableTKNN.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jTableTKNN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTKNNMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTableTKNN);
        jTableTKNN.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 18));
        jTableTKNN.getTableHeader().setOpaque(false);
        jTableTKNN.getTableHeader().setBackground(Color.BLUE);
        jTableTKNN.getTableHeader().setForeground(new Color(0,0,0));

        jButtonAddTKNN.setText("Add");
        jButtonAddTKNN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddTKNNActionPerformed(evt);
            }
        });

        jButtonDelTKNN.setText("Delete");
        jButtonDelTKNN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDelTKNNActionPerformed(evt);
            }
        });

        jButtonBackTKNN.setText("Back");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("DANH SÁCH TÀI KHOẢN NGÂN HÀNG");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(286, 286, 286)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 928, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(450, 450, 450)
                        .addComponent(jLabel5)))
                .addContainerGap(286, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonAddTKNN, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonDelTKNN, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jButtonBackTKNN, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(610, 610, 610))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel5)
                .addGap(50, 50, 50)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonBackTKNN)
                    .addComponent(jButtonDelTKNN)
                    .addComponent(jButtonAddTKNN))
                .addContainerGap(81, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTableTKNNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTKNNMouseClicked
        // TODO add your handling code here:
        DefaultTableModel dtm = (DefaultTableModel) jTableTKNN.getModel();
        maTKNH = dtm.getValueAt(jTableTKNN.getSelectedRow(), 1).toString();
    }//GEN-LAST:event_jTableTKNNMouseClicked

    private void jButtonAddTKNNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddTKNNActionPerformed
        // TODO add your handling code here:

        int soLgNH = 0;
        int solgTK = 0;

        String sql;

        Connection ketNoi = KetNoiSQL.layKetNoi();
        sql = "select COUNT(MaTK) from NhaDauTu";
        try {
            PreparedStatement ps = ketNoi.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                solgTK = rs.getInt(1);
            }
            rs.close();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(PanelTKNH.class.getName()).log(Level.SEVERE, null, ex);

        }
        sql = "select COUNT(MaNH) from NganHang";
        try {
            PreparedStatement ps = ketNoi.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                soLgNH = rs.getInt(1);
            }
            rs.close();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(PanelTKNH.class.getName()).log(Level.SEVERE, null, ex);
        }

        int i = 0;
        String maNH[] = new String[soLgNH];
        String maTK[] = new String[solgTK];
        sql = "select DISTINCT MaTK from NhaDauTu";
        try {
            PreparedStatement ps = ketNoi.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                maTK[i++] = rs.getString("MaTK");
            }
            rs.close();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(PanelTKNH.class.getName()).log(Level.SEVERE, null, ex);

        }

        i = 0;
        sql = "select DISTINCT MaNH from NganHang";
        try {
            PreparedStatement ps = ketNoi.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                maNH[i++] = rs.getString("MaNH");
            }
            rs.close();
            ps.close();
            ketNoi.close();
        } catch (SQLException ex) {
            Logger.getLogger(PanelTKNH.class.getName()).log(Level.SEVERE, null, ex);

        }

        new FrAddTKNH(maNH, maTK).setVisible(true);
    }//GEN-LAST:event_jButtonAddTKNNActionPerformed

    private void jButtonDelTKNNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDelTKNNActionPerformed
        // TODO add your handling code here:
        if (maTKNH == null) {
            JOptionPane.showMessageDialog(this, "Vui Lòng Chọn Tài Khoản Ngan Hang");
            return;
        }
        int ret = JOptionPane.showConfirmDialog(this, "Bạn Có Chắc Chắn Muốn Xoá?", "Xác Nhận", 0);
        if (ret == JOptionPane.CANCEL_OPTION) {

        } else if (ret == JOptionPane.OK_OPTION) {
            System.out.println(maTKNH);
            xoaTKNH(maTKNH);
            JOptionPane.showMessageDialog(this, "Xóa sách thành công");
            layDataTKNH();
        }
        maTKNH = null;
    }//GEN-LAST:event_jButtonDelTKNNActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddTKNN;
    private javax.swing.JButton jButtonBackTKNN;
    private javax.swing.JButton jButtonDelTKNN;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTableTKNN;
    // End of variables declaration//GEN-END:variables

}
