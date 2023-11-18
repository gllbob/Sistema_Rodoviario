/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package modal.views;

/**
 *
 * @author gllbo
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
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

        dpmenu = new javax.swing.JDesktopPane();
        btnusuario = new javax.swing.JButton();
        btncidade = new javax.swing.JButton();
        btnpassagem = new javax.swing.JButton();
        btnveiculo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnusuario.setText("Usuario");

        btncidade.setText("Cidade");
        btncidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncidadeActionPerformed(evt);
            }
        });

        btnpassagem.setText("Passagem");
        btnpassagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpassagemActionPerformed(evt);
            }
        });

        btnveiculo.setText("Veiculo");
        btnveiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnveiculoActionPerformed(evt);
            }
        });

        dpmenu.setLayer(btnusuario, javax.swing.JLayeredPane.DEFAULT_LAYER);
        dpmenu.setLayer(btncidade, javax.swing.JLayeredPane.DEFAULT_LAYER);
        dpmenu.setLayer(btnpassagem, javax.swing.JLayeredPane.DEFAULT_LAYER);
        dpmenu.setLayer(btnveiculo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout dpmenuLayout = new javax.swing.GroupLayout(dpmenu);
        dpmenu.setLayout(dpmenuLayout);
        dpmenuLayout.setHorizontalGroup(
            dpmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dpmenuLayout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(btnpassagem, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 300, Short.MAX_VALUE)
                .addGroup(dpmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncidade, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(110, 110, 110))
            .addGroup(dpmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(dpmenuLayout.createSequentialGroup()
                    .addGap(89, 89, 89)
                    .addComponent(btnveiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(551, Short.MAX_VALUE)))
        );
        dpmenuLayout.setVerticalGroup(
            dpmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dpmenuLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(dpmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnpassagem, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 163, Short.MAX_VALUE)
                .addComponent(btncidade, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
            .addGroup(dpmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dpmenuLayout.createSequentialGroup()
                    .addContainerGap(271, Short.MAX_VALUE)
                    .addComponent(btnveiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(91, 91, 91)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dpmenu)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dpmenu)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnveiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnveiculoActionPerformed
        // TODO add your handling code here:
        VeiculoViews veiculoviews = new VeiculoViews();
        veiculoviews.setVisible(true);
        dpmenu.add(veiculoviews);
        btncidade.setVisible(false);
        btnveiculo.setVisible(false);
        btnusuario.setVisible(false);
        btnpassagem.setVisible(false);
    }//GEN-LAST:event_btnveiculoActionPerformed

    private void btncidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncidadeActionPerformed
        // TODO add your handling code here:
        CidadeViews cidadeviews = new CidadeViews();
        cidadeviews.setVisible(true);
        dpmenu.add(cidadeviews);
        btncidade.setVisible(false);
        btnveiculo.setVisible(false);
        btnusuario.setVisible(false);
        btnpassagem.setVisible(false);
    }//GEN-LAST:event_btncidadeActionPerformed

    private void btnpassagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpassagemActionPerformed
        // TODO add your handling code here:
        PassagemViews passagemviews = new PassagemViews();
        passagemviews.setVisible(true);
        dpmenu.add(passagemviews);
        btncidade.setVisible(false);
        btnveiculo.setVisible(false);
        btnusuario.setVisible(false);
        btnpassagem.setVisible(false);
    }//GEN-LAST:event_btnpassagemActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btncidade;
    public javax.swing.JButton btnpassagem;
    public javax.swing.JButton btnusuario;
    public javax.swing.JButton btnveiculo;
    public javax.swing.JDesktopPane dpmenu;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JDesktopPane getDpmenu() {
        return dpmenu;
    }
}
