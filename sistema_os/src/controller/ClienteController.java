/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Cliente;
import javax.swing.JOptionPane;
import service.ClienteService;

public class ClienteController extends javax.swing.JFrame {

    Cliente clienteClasse;
    private Object clienteSalvo;

    public ClienteController() {
        initComponents();
    }

    public ClienteController(Cliente cliente) {
        this.clienteClasse = cliente;
        initComponents();
        jbcadastrar.setText("cadastrar");
        prencherDados();
    }

    public void prencherDados() {
        jTNome.setText(clienteClasse.getNome());
        JOptionPane.showMessageDialog(null, "insira o nome do cliente");
        jtEmail.setText(clienteClasse.getEmail());
        JOptionPane.showMessageDialog(null, "insira o email do cliente");
        jtEndereco.setText(clienteClasse.getEndereco());
        JOptionPane.showMessageDialog(null, "insira o endereço do cliente");
        jtTelefone.setText(clienteClasse.toString());
        JOptionPane.showMessageDialog(null, "insira o telefone do cliente");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField5 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jtEmail = new javax.swing.JTextField();
        jtEndereco = new javax.swing.JTextField();
        jTNome = new javax.swing.JTextField();
        jtTelefone = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jbcadastrar = new javax.swing.JButton();
        jbcancelar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        jTextField5.setText("jTextField5");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("cadastro de clientes");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("informe seus dados:");

        jtEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtEmailActionPerformed(evt);
            }
        });

        jtEndereco.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtEnderecoActionPerformed(evt);
            }
        });

        jLabel2.setText("Nome");

        jLabel3.setText("Telefone");

        jLabel5.setText("Endereço");

        jbcadastrar.setText("Cadastrar");
        jbcadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbcadastrarActionPerformed(evt);
            }
        });

        jbcancelar.setText("Cancelar");
        jbcancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbcancelarActionPerformed(evt);
            }
        });

        jLabel6.setText("Email");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbcancelar)
                        .addGap(18, 18, 18)
                        .addComponent(jbcadastrar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                            .addComponent(jTNome)
                            .addComponent(jtEmail)
                            .addComponent(jtEndereco))))
                .addContainerGap(64, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(150, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(142, 142, 142))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbcadastrar)
                    .addComponent(jbcancelar))
                .addGap(0, 34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtEmailActionPerformed

    }//GEN-LAST:event_jtEmailActionPerformed

    private void jtEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtEnderecoActionPerformed

    private void jbcadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbcadastrarActionPerformed
        Cliente cliente = new Cliente();
        cliente.setNome(jTNome.getText());
        cliente.setTelefone(jtTelefone.getText());
        cliente.setEndereco(jtEndereco.getText());
        cliente.setEmail(jtEmail.getText());
        
        ClienteService clienteServise = new ClienteService();
        clienteServise.cadastrarCliente(cliente);
        JOptionPane.showMessageDialog(null, "cliente cadastrado com sucesso");
        this.dispose();
// try {
//            Cliente clienteSalvo;
//            if (jbcadastrar.getText().equals("cadastrar")) {
//                cliente.setId(clienteClasse.getId());
//                 clienteSalvo = clienteServise.cadastrarCliente(cliente);
//            } else {
//                clienteSalvo = clienteServise.cadastrarCliente(cliente);
//            }
//
//            if (clienteSalvo == null) {
//                JOptionPane.showMessageDialog(null, "Ocorreu um erro qualquer no banco!");
//            } else {
//                JOptionPane.showMessageDialog(null, "Contato salvo com sucesso!");
//            }
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(null, ex.getMessage());
//        }
    }//GEN-LAST:event_jbcadastrarActionPerformed

    private void jbcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbcancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbcancelarActionPerformed

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
            java.util.logging.Logger.getLogger(ClienteController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClienteController().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTNome;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JButton jbcadastrar;
    private javax.swing.JButton jbcancelar;
    private javax.swing.JTextField jtEmail;
    private javax.swing.JTextField jtEndereco;
    private javax.swing.JTextField jtTelefone;
    // End of variables declaration//GEN-END:variables

}
