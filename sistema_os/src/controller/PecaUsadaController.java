/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.PecaUsada;
import javax.swing.JOptionPane;
import service.PecaUsadaService;

/**
 *
 * @author Escola
 */
public class PecaUsadaController extends javax.swing.JFrame {

    PecaUsada pecaUsadaClasse;
    private OrdemServicoController ordemServicoController;
    PecaUsadaService pecasUsadasService = new PecaUsadaService();

    public PecaUsadaController() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public PecaUsadaController(OrdemServicoController ordemServicoController) {
        this.ordemServicoController = ordemServicoController;
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public PecaUsadaController(PecaUsada pecaUsada) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.pecaUsadaClasse = pecaUsada;
        jbSalvar.setText("Editar");
        preencherDados();
    }

    public void preencherDados() {
        jtfDescricao.setText(pecaUsadaClasse.getDescricao());
        jtfQuantidade.setText(pecaUsadaClasse.getQuantidade() + "");
        jtfPrecoUnitario.setText(pecaUsadaClasse.getPrecoUnitario() + "");
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtfDescricao = new javax.swing.JTextField();
        jtfQuantidade = new javax.swing.JTextField();
        jtfPrecoUnitario = new javax.swing.JTextField();
        jbSalvar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de peças usadas");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Peças Usadas");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Descrição:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Quantidade:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Preço Unitário:");

        jtfDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfDescricaoActionPerformed(evt);
            }
        });

        jtfQuantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfQuantidadeActionPerformed(evt);
            }
        });

        jbSalvar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jbSalvar.setText("Salvar");
        jbSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarActionPerformed(evt);
            }
        });

        jbCancelar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jtfQuantidade, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                    .addComponent(jtfPrecoUnitario, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfDescricao)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfPrecoUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbSalvar)
                    .addComponent(jbCancelar))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfDescricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfDescricaoActionPerformed

    private void jtfQuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfQuantidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfQuantidadeActionPerformed

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        // TODO add your handling code here:
        PecaUsada pecaUsada = new PecaUsada();
        pecaUsada.setDescricao(jtfDescricao.getText());
        try {
            pecaUsada.setQuantidade(Integer.parseInt(jtfQuantidade.getText()));
            pecaUsada.setPrecoUnitario(Double.parseDouble(jtfPrecoUnitario.getText()));

        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Apenas números são permitidos.");
        }

//        pecasUsadasService.salvarPeca(pecasUsadas);
//        PecaUsada pecaUsadaSalva;
//        try {
//            pecaUsadaSalva = pecasUsadasService.salvarPeca(pecaUsada);
//            if (pecaUsadaSalva != null) {
//                JOptionPane.showMessageDialog(null, "Peça salva com sucesso.");
//            } else {
//                JOptionPane.showMessageDialog(null, "Não foi possível salvar a peça.");
//            }
//        } catch (NullPointerException nex) {
//            JOptionPane.showMessageDialog(null, nex.getMessage());
//        }

        if (ordemServicoController != null) {
            ordemServicoController.editarListaPecasUsadas(pecaUsada);
        } else {
            ordemServicoController.atualizarListaPecasUsadas(pecaUsada);
        }
        this.dispose();
    }//GEN-LAST:event_jbSalvarActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jbCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(PecaUsadaController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PecaUsadaController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PecaUsadaController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PecaUsadaController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PecaUsadaController().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JTextField jtfDescricao;
    private javax.swing.JTextField jtfPrecoUnitario;
    private javax.swing.JTextField jtfQuantidade;
    // End of variables declaration//GEN-END:variables
}
