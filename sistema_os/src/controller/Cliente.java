/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JOptionPane;

/**
 *
 * @author kelvin
 */
public class Cliente extends javax.swing.JFrame {

        Cliente clienteClasse;
    

    public Cliente Cliente() {
        initComponents();
        return null;
    }

    public Cliente(Cliente cliente) {
        this.clienteClasse = cliente;
        initComponents();
        jbcadastrar.setText("editar");
        prencherDados();
    }

    public void prencherDados() {
        jTNome.setText(clienteClasse.getName());
        jtEmail.setText(clienteClasse.getEmail));
        jtEndereco.setText(clienteClasse.getEndereco());
        jtTelefone.setText(clienteClasse.getTelefone());

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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jbcadastrar = new javax.swing.JButton();
        jbcancelar = new javax.swing.JButton();

        jTextField5.setText("jTextField5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Cadastro de Clientes");

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

        jLabel4.setText("Email");

        jLabel5.setText("Endereço");

        jbcadastrar.setText("Cadastrar");
        jbcadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbcadastrarActionPerformed(evt);
            }
        });

        jbcancelar.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                    .addComponent(jTNome)
                    .addComponent(jtEmail)
                    .addComponent(jtEndereco))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(226, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(246, 246, 246))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbcancelar)
                        .addGap(34, 34, 34)
                        .addComponent(jbcadastrar)
                        .addGap(46, 46, 46))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jLabel4)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbcadastrar)
                            .addComponent(jbcancelar))
                        .addGap(0, 22, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtEmailActionPerformed

    private void jtEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtEnderecoActionPerformed

    private void jbcadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbcadastrarActionPerformed
      Cliente cliente = new Cliente();
        cliente.setNome(jtNome.getClass().toString());
        cliente.setTelefone(jtTendereco.getText());
        cliente.setEmail(jtemail.getText());
        cliente.setLinkedin(jtlink.getText());
        Agenda agenda = new Agenda(6, "minha agenda", 100);
        contato.setAgenda(agenda);
        ContatoService contatoService = new ContatoService();
//      
//        if (contatoService.SalvarContato(contato) == null) {
//            JOptionPane.showMessageDialog(null, "não foi ´possivel salvar o contado");
//        } else {
//
//            JOptionPane.showMessageDialog(null, "contato salvo com sucesso");
//        }

        try {
            Contato contatoSalvo;
            if (jbsalvar.getText().equals("editar")) {
                contato.setId(contatoClasse.getId());
                contatoSalvo = contatoService.editarContato(contato);
            } else {
                contatoSalvo = contatoService.SalvarContato(contato);
            }

            if (contatoSalvo == null) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro qualquer no banco!");
            } else {
                JOptionPane.showMessageDialog(null, "Contato salvo com sucesso!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
                                            

    }//GEN-LAST:event_jbcadastrarActionPerformed

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
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTNome;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JButton jbcadastrar;
    private javax.swing.JButton jbcancelar;
    private javax.swing.JTextField jtEmail;
    private javax.swing.JTextField jtEndereco;
    private javax.swing.JTextField jtTelefone;
    // End of variables declaration//GEN-END:variables

    private void initComponents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
}}
