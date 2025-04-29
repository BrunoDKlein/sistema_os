/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Aparelho;
import entity.Cliente;
import entity.OrdemServico;
import entity.Tecnico;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableCellRenderer;
import service.AparelhoService;
import service.ClienteService;
import service.SistemaOsService;
import service.TecnicoService;

/**
 *
 * @author admin
 */
public class SistemaOsController extends javax.swing.JFrame {

    SistemaOsService sistemaOsService = new SistemaOsService();
    ClienteService clienteService = new ClienteService();
    TecnicoService tecnicoService = new TecnicoService();
    AparelhoService aparelhoService = new AparelhoService();
    /**
     * Creates new form SistemaOsController
     */
    public SistemaOsController() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        configurarLarguraColunas();
        preencheTabela(sistemaOsService.buscarTodasAsOs());
    }

    private void configurarLarguraColunas() {
        ((DefaultTableCellRenderer) jtOs.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        jtOs.getColumnModel().getColumn(0).setPreferredWidth(jtOs.getWidth() / 25);
        jtOs.getColumnModel().getColumn(1).setPreferredWidth(jtOs.getWidth() / 16);
        jtOs.getColumnModel().getColumn(2).setPreferredWidth(jtOs.getWidth() / 16);
        jtOs.getColumnModel().getColumn(3).setPreferredWidth(jtOs.getWidth() / 16);
        jtOs.getColumnModel().getColumn(4).setPreferredWidth(jtOs.getWidth() / 12);
        jtOs.getColumnModel().getColumn(5).setPreferredWidth(jtOs.getWidth() / 12);
        jtOs.getColumnModel().getColumn(6).setPreferredWidth(jtOs.getWidth() / 16);
        jtOs.getColumnModel().getColumn(7).setPreferredWidth(jtOs.getWidth() / 6);
        jtOs.getColumnModel().getColumn(8).setPreferredWidth(jtOs.getWidth() / 6);
        jtOs.getColumnModel().getColumn(9).setPreferredWidth(jtOs.getWidth() / 16);
        jtOs.getColumnModel().getColumn(10).setPreferredWidth(jtOs.getWidth() / 25);
        alinharColuna(0, SwingConstants.CENTER);
        alinharColuna(1, SwingConstants.LEFT);
        alinharColuna(2, SwingConstants.LEFT);
        alinharColuna(3, SwingConstants.LEFT);
        alinharColuna(4, SwingConstants.CENTER);
        alinharColuna(5, SwingConstants.CENTER);
        alinharColuna(6, SwingConstants.CENTER);
        alinharColuna(7, SwingConstants.LEFT);
        alinharColuna(8, SwingConstants.LEFT);
        alinharColuna(9, SwingConstants.CENTER);
        alinharColuna(10, SwingConstants.CENTER);
    }

    private void alinharColuna(int coluna, int alinhamento) {
        DefaultTableCellRenderer alinhar = new DefaultTableCellRenderer();
        alinhar.setHorizontalAlignment(alinhamento);
        jtOs.getColumnModel().getColumn(coluna).setCellRenderer(alinhar);
    }

    public void limparTabela() {

        for (int i = 0; i < jtOs.getRowCount(); i++) {
            jtOs.setValueAt(null, i, 0);
            jtOs.setValueAt(null, i, 1);
            jtOs.setValueAt(null, i, 2);
            jtOs.setValueAt(null, i, 3);
            jtOs.setValueAt(null, i, 4);
            jtOs.setValueAt(null, i, 5);
            jtOs.setValueAt(null, i, 6);
            jtOs.setValueAt(null, i, 7);
            jtOs.setValueAt(null, i, 8);
            jtOs.setValueAt(null, i, 9);
            jtOs.setValueAt(null, i, 10);
        }
    }

    private void preencheTabela(List<OrdemServico> ordensServico) {
        int i = 0;
        for (OrdemServico os : ordensServico) {
            int k = 0;
            jtOs.setValueAt(os.getId(), i, k++);
            jtOs.setValueAt(os.getCliente().getNome(), i, k++);
            jtOs.setValueAt(os.getAparelho().getMarca() + " - " + os.getAparelho().getModelo(), i, k++);
            jtOs.setValueAt(os.getTecnico().getNome(), i, k++);
            jtOs.setValueAt(os.getData_abertura(), i, k++);
            jtOs.setValueAt(os.getData_fechamento(), i, k++);
            jtOs.setValueAt(os.getStatus(), i, k++);
            jtOs.setValueAt(os.getDescricao_problema(), i, k++);
            jtOs.setValueAt(os.getSolucao(), i, k++);
            jtOs.setValueAt(os.getPecasUsadas() != null ? os.getPecasUsadas().size() : "", i, k++);
            jtOs.setValueAt(os.getCusto_total(), i, k++);

            i++;
        }
    }

    public boolean linhaEstaSelecionada() {
        return jtOs.getSelectedRow() > -1;
    }

    public OrdemServico lerQualOsEstaSelecionada() {
        OrdemServico osSelecionada = new OrdemServico();
        osSelecionada = sistemaOsService.buscarOsPorId(Integer.parseInt(jtOs.getValueAt(jtOs.getSelectedRow(), 0).toString()));
        return osSelecionada;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pecasUsadasService1 = new service.PecaUsadaService();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtOs = new javax.swing.JTable();
        jbCriarNovaOs = new javax.swing.JButton();
        jbAtualizar = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jbEditar1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmFazerPagamento = new javax.swing.JMenu();
        jmiCadastrarCliente = new javax.swing.JMenuItem();
        jmiEditarCliente = new javax.swing.JMenuItem();
        jmiExcluirCliente = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jmiCadastrarTecnico = new javax.swing.JMenuItem();
        jmiEditarTecnico = new javax.swing.JMenuItem();
        jmiRelatorioTecnico = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jmiFazerPagamento = new javax.swing.JMenuItem();
        jmiCadastrarAparelho = new javax.swing.JMenuItem();
        jmiEditarAparelho = new javax.swing.JMenuItem();
        jmiRelatorioAparelhos = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("...::: Sistema de Controle de Ordens de Serviço - Técnica :::...");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sistema de Gerenciamento de Ordens de Servico");

        jtOs.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jtOs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id ", "Cliente", "Aparelho", "Técnico", "Data da Abertura", "Data do Fechamento", "Status", "Descrição do Problema", "Solução", "Peças usadas", "Custo Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtOs.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtOs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtOsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtOs);
        jtOs.getAccessibleContext().setAccessibleName("");

        jbCriarNovaOs.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbCriarNovaOs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/adicionar.png"))); // NOI18N
        jbCriarNovaOs.setText("Criar");
        jbCriarNovaOs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCriarNovaOsActionPerformed(evt);
            }
        });

        jbAtualizar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/engrenagem.png"))); // NOI18N
        jbAtualizar.setText("Atualizar");
        jbAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAtualizarActionPerformed(evt);
            }
        });

        jbEditar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/editar.png"))); // NOI18N
        jbEditar.setText("Editar");
        jbEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarActionPerformed(evt);
            }
        });

        jbExcluir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excluir.png"))); // NOI18N
        jbExcluir.setText("Excluir");
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/logo.png"))); // NOI18N

        jbEditar1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbEditar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/editar.png"))); // NOI18N
        jbEditar1.setText("Atender");
        jbEditar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditar1ActionPerformed(evt);
            }
        });

        jMenu1.setText("Arquivo");
        jMenuBar1.add(jMenu1);

        jmFazerPagamento.setText("Opções");

        jmiCadastrarCliente.setText("Cadastrar Cliente");
        jmiCadastrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCadastrarClienteActionPerformed(evt);
            }
        });
        jmFazerPagamento.add(jmiCadastrarCliente);

        jmiEditarCliente.setText("Editar Cliente");
        jmiEditarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiEditarClienteActionPerformed(evt);
            }
        });
        jmFazerPagamento.add(jmiEditarCliente);

        jmiExcluirCliente.setText("Excluir Cliente");
        jmFazerPagamento.add(jmiExcluirCliente);
        jmFazerPagamento.add(jSeparator1);

        jmiCadastrarTecnico.setText("Cadastrar Técnico");
        jmiCadastrarTecnico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCadastrarTecnicoActionPerformed(evt);
            }
        });
        jmFazerPagamento.add(jmiCadastrarTecnico);

        jmiEditarTecnico.setText("Editar Técnico");
        jmiEditarTecnico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiEditarTecnicoActionPerformed(evt);
            }
        });
        jmFazerPagamento.add(jmiEditarTecnico);

        jmiRelatorioTecnico.setText("Relatorio Técnicos");
        jmiRelatorioTecnico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiRelatorioTecnicoActionPerformed(evt);
            }
        });
        jmFazerPagamento.add(jmiRelatorioTecnico);
        jmFazerPagamento.add(jSeparator2);

        jmiFazerPagamento.setText("Fazer Pagamento");
        jmiFazerPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiFazerPagamentoActionPerformed(evt);
            }
        });
        jmFazerPagamento.add(jmiFazerPagamento);

        jmiCadastrarAparelho.setText("Cadastrar Aparelho");
        jmiCadastrarAparelho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCadastrarAparelhoActionPerformed(evt);
            }
        });
        jmFazerPagamento.add(jmiCadastrarAparelho);

        jmiEditarAparelho.setText("Editar Aparelho");
        jmiEditarAparelho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiEditarAparelhoActionPerformed(evt);
            }
        });
        jmFazerPagamento.add(jmiEditarAparelho);

        jmiRelatorioAparelhos.setText("Relatorio de Aparelhos");
        jmiRelatorioAparelhos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiRelatorioAparelhosActionPerformed(evt);
            }
        });
        jmFazerPagamento.add(jmiRelatorioAparelhos);

        jMenuBar1.add(jmFazerPagamento);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbCriarNovaOs, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbEditar1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 436, Short.MAX_VALUE)
                        .addComponent(jbAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCriarNovaOs, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbEditar1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCriarNovaOsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCriarNovaOsActionPerformed
        new OrdemServicoController().setVisible(true);
    }//GEN-LAST:event_jbCriarNovaOsActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        boolean osExcluida = false;
        int linhaSelecionada = jtOs.getSelectedRow();
        try {
            if (linhaEstaSelecionada()) {
                osExcluida = sistemaOsService.excluirOs(Integer.parseInt(jtOs.getValueAt(linhaSelecionada, 0).toString()));
            } else {
                JOptionPane.showMessageDialog(null, "Para realizar essa ação, selecione uma ordem de serviço");
            }
            if (osExcluida) {
                JOptionPane.showMessageDialog(null, "Ordem de serviço excluída com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro qualquer no banco!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed
        if (linhaEstaSelecionada()) {
            new OrdemServicoController(lerQualOsEstaSelecionada()).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Para realizar essa ação, selecione uma ordem de serviço");
        }
    }//GEN-LAST:event_jbEditarActionPerformed

    private void jbAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAtualizarActionPerformed
        limparTabela();
        preencheTabela(sistemaOsService.buscarTodasAsOs());
    }//GEN-LAST:event_jbAtualizarActionPerformed

    private void jmiCadastrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCadastrarClienteActionPerformed

        new ClienteController().setVisible(true);
    }//GEN-LAST:event_jmiCadastrarClienteActionPerformed

    private void jtOsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtOsMouseClicked
        if (jtOs.getValueAt(jtOs.getSelectedRow(), jtOs.getSelectedColumn()) != null) {
            OrdemServico ordemServico = lerQualOsEstaSelecionada();

            switch (jtOs.getSelectedColumn()) {
                case 7:
                    JOptionPane.showMessageDialog(rootPane, ordemServico.getDescricao_problema(), "DESCRIÇÃO DO PROBLEMA", 1);
                    break;
                case 8:
                    JOptionPane.showMessageDialog(rootPane, ordemServico.getSolucao(), "SOLUÇÃO", 1);
                    break;
                case 9:
                    JOptionPane.showMessageDialog(rootPane, ordemServico.getPecasUsadas(), "PEÇAS USADAS", 1);
                    break;
                default:
                    break;
            }
        }
    }//GEN-LAST:event_jtOsMouseClicked

    private void jmiFazerPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiFazerPagamentoActionPerformed
        new PagamentoController(lerQualOsEstaSelecionada()).setVisible(true);
    }//GEN-LAST:event_jmiFazerPagamentoActionPerformed

    private void jmiCadastrarTecnicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCadastrarTecnicoActionPerformed
        // TODO add your handling code here:
        new TecnicoControler().setVisible(true);
    }//GEN-LAST:event_jmiCadastrarTecnicoActionPerformed

    private void jbEditar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbEditar1ActionPerformed

    private void jmiEditarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiEditarClienteActionPerformed
        int id_cliente = Integer.parseInt(JOptionPane.showInputDialog("id_cliente"));
        Cliente cliente = clienteService.buscarClientePorID(id_cliente);
        if (cliente == null) {
            JOptionPane.showMessageDialog(null, "Cliente não localizavel!");
        } else {
            new ClienteController(cliente).setVisible(true);
        }
    }//GEN-LAST:event_jmiEditarClienteActionPerformed

    private void jmiEditarTecnicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiEditarTecnicoActionPerformed
int id_tecnico = Integer.parseInt(JOptionPane.showInputDialog("id_tecnico"));
        Tecnico tecnico = tecnicoService.buscarTecnicoPorID(id_tecnico);
        if (tecnico == null) {
            JOptionPane.showMessageDialog(null, "Tecnico não localizavel!");
        } else {
            new TecnicoControler(tecnico).setVisible(true);
        }



//         TODO add your handling code here:
//       int id_tecnico = Integer.parseInt(JOptionPane.showInputDialog("id_tecnico"));
//        Tecnico tecnico = tecnicoService.buscarTecnicoPorId(id_tecnico);
//        if (tecnico == null) {
//            JOptionPane.showMessageDialog(null, "Tecnico não localizado!");
//        } else {
//            new TecnicoController(tecnico).setVisible(true);
//        }  
    }//GEN-LAST:event_jmiEditarTecnicoActionPerformed
  
    private void jmiCadastrarAparelhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCadastrarAparelhoActionPerformed
        new AparelhoController().setVisible(true);
        
    }//GEN-LAST:event_jmiCadastrarAparelhoActionPerformed

    private void jmiEditarAparelhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiEditarAparelhoActionPerformed
         int id_aparelho = Integer.parseInt(JOptionPane.showInputDialog("Informe o id do aparelho que você deseja buscar"));
        Aparelho aparelho = aparelhoService.buscarAparelhoPorId(id_aparelho);
        if (aparelho == null) {
           JOptionPane.showMessageDialog(null, "Aparelho não localizavel!");
       } else {
            new AparelhoController(aparelho).setVisible(true);
        }
    }//GEN-LAST:event_jmiEditarAparelhoActionPerformed


    private void jmiRelatorioAparelhosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiRelatorioAparelhosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmiRelatorioAparelhosActionPerformed

    private void jmiRelatorioTecnicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiRelatorioTecnicoActionPerformed
        // TODO add your handling code here:
        List<String> tituloColunas = Arrays.asList("Id","Nome Tecnico","Telefone","Email");
        List<String> tituloAtributos = Arrays.asList("id","nome","telefone","email");
// RelatorioPDF<Tecnico> relatorio = new RelatorioPDF<>;
 
        
    }//GEN-LAST:event_jmiRelatorioTecnicoActionPerformed


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
            java.util.logging.Logger.getLogger(SistemaOsController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SistemaOsController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SistemaOsController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SistemaOsController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        try {
            //</editor-fold>
            UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SistemaOsController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(SistemaOsController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(SistemaOsController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(SistemaOsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SistemaOsController().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JButton jbAtualizar;
    private javax.swing.JButton jbCriarNovaOs;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbEditar1;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JMenu jmFazerPagamento;
    private javax.swing.JMenuItem jmiCadastrarAparelho;
    private javax.swing.JMenuItem jmiCadastrarCliente;
    private javax.swing.JMenuItem jmiCadastrarTecnico;
    private javax.swing.JMenuItem jmiEditarAparelho;
    private javax.swing.JMenuItem jmiEditarCliente;
    private javax.swing.JMenuItem jmiEditarTecnico;
    private javax.swing.JMenuItem jmiExcluirCliente;
    private javax.swing.JMenuItem jmiFazerPagamento;
    private javax.swing.JMenuItem jmiRelatorioAparelhos;
    private javax.swing.JMenuItem jmiRelatorioTecnico;
    private javax.swing.JTable jtOs;
    private service.PecaUsadaService pecasUsadasService1;
    // End of variables declaration//GEN-END:variables
}
