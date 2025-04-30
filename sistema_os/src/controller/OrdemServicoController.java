/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Aparelho;
import entity.Cliente;
import entity.OrdemServico;
import entity.PecaUsada;
import entity.Tecnico;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.Collectors;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import service.AparelhoService;
import service.ClienteService;
import service.OrdemServicoService;
import service.TecnicoService;

/**
 *
 * @author admin
 */
public class OrdemServicoController extends javax.swing.JFrame {

    int linhaSelecionada;
    private Timer timer = new Timer();
    ClienteService clienteService = new ClienteService();
    TecnicoService tecnicoService = new TecnicoService();
    AparelhoService aparelhoService = new AparelhoService();
    OrdemServicoService ordemServicoService = new OrdemServicoService();
    List<PecaUsada> pecasUsadas = new ArrayList<>();
    List<Cliente> filtroClientes = new ArrayList<>();
    List<Tecnico> filtroTecnico = new ArrayList<>();
    List<Aparelho> filtroAparelho = new ArrayList<>();
    private OrdemServico ordemServicoEditar;
    private OrdemServico ordemServicoSalvar;

    public OrdemServicoController() {
        initComponents();
        configurarLarguraColunas();
        this.setLocationRelativeTo(null);
        criaAcaoComboBox(jcbCliente, "clientes");
        criaAcaoComboBox(jcbTecnico, "tecnicos");
        criaAcaoComboBox(jcbAparelho, "aparelhos");
    }

    public OrdemServicoController(OrdemServico ordemServico) {
        initComponents();
        configurarLarguraColunas();
        this.setLocationRelativeTo(null);
        this.ordemServicoEditar = ordemServico;
        criaAcaoComboBox(jcbCliente, "clientes");
        criaAcaoComboBox(jcbTecnico, "tecnicos");
        criaAcaoComboBox(jcbAparelho, "aparelhos");
    }

    private void criaAcaoComboBox(JComboBox combo, String tipoDados) {
        JTextField editor = (JTextField) combo.getEditor().getEditorComponent();

        editor.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent evt) {
                timer.cancel();
                timer = new Timer();

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        String textoDigitado = editor.getText().trim();
                        if (!textoDigitado.isEmpty()) {
                            List<String> dados = buscarNoBanco(tipoDados, textoDigitado);
                            SwingUtilities.invokeLater(() -> preencheCombo(combo, dados));
                        }
                    }
                }, 800);
            }
        });
    }

    private void alinharColuna(int coluna, int alinhamento) {
        DefaultTableCellRenderer alinhar = new DefaultTableCellRenderer();
        alinhar.setHorizontalAlignment(alinhamento);
        jtPecasUsadas.getColumnModel().getColumn(coluna).setCellRenderer(alinhar);
    }

    private void configurarLarguraColunas() {
        ((DefaultTableCellRenderer) jtPecasUsadas.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        jtPecasUsadas.getColumnModel().getColumn(0).setPreferredWidth(jtPecasUsadas.getWidth() / 3);
        jtPecasUsadas.getColumnModel().getColumn(1).setPreferredWidth(jtPecasUsadas.getWidth() / 7);
        jtPecasUsadas.getColumnModel().getColumn(2).setPreferredWidth(jtPecasUsadas.getWidth() / 5);
        jtPecasUsadas.getColumnModel().getColumn(3).setPreferredWidth(jtPecasUsadas.getWidth() / 5);
        alinharColuna(0, SwingConstants.LEFT);
        alinharColuna(1, SwingConstants.CENTER);
        alinharColuna(2, SwingConstants.CENTER);
        alinharColuna(3, SwingConstants.CENTER);
    }

    private List<String> buscarNoBanco(String tipoDados, String filtro) {
        switch (tipoDados) {
            case "clientes":
                this.filtroClientes.clear();
                this.filtroClientes = clienteService.buscarClientes(filtro);
                return this.filtroClientes.stream().map(Cliente::getNome).collect(Collectors.toList());
            case "tecnicos":
                return tecnicoService.buscarTecnicosPorNome(filtro).stream().map(Tecnico::getNome).collect(Collectors.toList());
            case "aparelhos":
//                return aparelhoService.buscarAparelhos(filtro).stream().map(Aparelho::getModelo).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    private void preencheCombo(JComboBox combo, List<String> dados) {
        JTextField editor = (JTextField) combo.getEditor().getEditorComponent();
        String textoAtual = editor.getText();
        int posicaoCursor = editor.getCaretPosition();

        combo.setEditable(false);
        combo.removeAllItems();

        for (String item : dados) {
            combo.addItem(item);
        }

        combo.setEditable(true);
        editor.setText(textoAtual);
        editor.setCaretPosition(posicaoCursor);
    }

    private void preencheTabela(List<PecaUsada> pecasUsadas) {
        int i = 0;
        for (PecaUsada pu : pecasUsadas) {
            int k = 0;
            jtPecasUsadas.setValueAt(pu.getDescricao(), i, k++);
            jtPecasUsadas.setValueAt(pu.getQuantidade(), i, k++);
            jtPecasUsadas.setValueAt(pu.getPrecoUnitario(), i, k++);

            i++;
        }
    }

    public void limparTabela() {

        for (int i = 0; i < jtPecasUsadas.getRowCount(); i++) {
            jtPecasUsadas.setValueAt(null, i, 0);
            jtPecasUsadas.setValueAt(null, i, 1);
            jtPecasUsadas.setValueAt(null, i, 2);
        }
    }

    public boolean existeUmaLinhaSelecionadaComPecaUsada() {
        linhaSelecionada = jtPecasUsadas.getSelectedRow();
        if (linhaSelecionada > -1 && jtPecasUsadas.getValueAt(linhaSelecionada, 2) != null) {
            return true;
        }
        return false;
    }

    public double calcularValorTotal() {
        double valorTotal = Double.parseDouble(jtfValorMaoDeObra.getText());
        for (PecaUsada pu : pecasUsadas) {
            valorTotal = valorTotal + (pu.getPrecoUnitario() * pu.getQuantidade());
        }
        return valorTotal;
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
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jbSalvar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaDescricao = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaSolucao = new javax.swing.JTextArea();
        jLabel23 = new javax.swing.JLabel();
        jtfValorMaoDeObra = new javax.swing.JTextField();
        jcbCliente = new javax.swing.JComboBox<>();
        jcbAparelho = new javax.swing.JComboBox<>();
        jbNovoCliente = new javax.swing.JButton();
        jbNovoAparelho = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jcbTecnico = new javax.swing.JComboBox<>();
        jbNovoTecnico = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtPecasUsadas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Adicionar Ordem de Serviço");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Cliente:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Solução:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Descrição do Problema:");

        jbSalvar.setText("Salvar");
        jbSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarActionPerformed(evt);
            }
        });

        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Aparelho:");

        jtaDescricao.setColumns(20);
        jtaDescricao.setRows(2);
        jScrollPane1.setViewportView(jtaDescricao);

        jtaSolucao.setColumns(20);
        jtaSolucao.setLineWrap(true);
        jtaSolucao.setRows(2);
        jScrollPane2.setViewportView(jtaSolucao);

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel23.setText("Valor Mão de Obra:         R$");

        jtfValorMaoDeObra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfValorMaoDeObraActionPerformed(evt);
            }
        });

        jcbCliente.setEditable(true);
        jcbCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        jcbCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbClienteActionPerformed(evt);
            }
        });
        jcbCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcbClienteKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jcbClienteKeyReleased(evt);
            }
        });

        jcbAparelho.setEditable(true);
        jcbAparelho.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        jcbAparelho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbAparelhoActionPerformed(evt);
            }
        });
        jcbAparelho.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcbAparelhoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jcbAparelhoKeyReleased(evt);
            }
        });

        jbNovoCliente.setText("Novo");
        jbNovoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNovoClienteActionPerformed(evt);
            }
        });

        jbNovoAparelho.setText("Novo");
        jbNovoAparelho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNovoAparelhoActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setText("Técnico:");

        jcbTecnico.setEditable(true);
        jcbTecnico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        jcbTecnico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbTecnicoActionPerformed(evt);
            }
        });
        jcbTecnico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcbTecnicoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jcbTecnicoKeyReleased(evt);
            }
        });

        jbNovoTecnico.setText("Novo");
        jbNovoTecnico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNovoTecnicoActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Peças usadas:");

        jButton1.setText("Adicionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jbExcluir.setText("Excluir");
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        jbEditar.setText("Editar");
        jbEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarActionPerformed(evt);
            }
        });

        jtPecasUsadas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Peça", "Quantidade", "Valor Unitário", "Custo Unitário"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jtPecasUsadas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jbExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jbEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jcbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jcbTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jbNovoCliente)
                                            .addComponent(jbNovoTecnico)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(68, 68, 68)
                                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jcbAparelho, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(22, 22, 22)
                                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jtfValorMaoDeObra)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jbNovoAparelho)))
                                .addGap(381, 381, 381)))
                        .addGap(4, 4, 4)))
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jcbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbNovoCliente))
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbNovoTecnico)
                    .addComponent(jcbTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jcbAparelho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbNovoAparelho))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfValorMaoDeObra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbSalvar)
                            .addComponent(jbCancelar)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbEditar)))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfValorMaoDeObraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfValorMaoDeObraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfValorMaoDeObraActionPerformed

    private void jcbClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcbClienteKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbClienteKeyPressed

    private void jcbClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcbClienteKeyReleased

    }//GEN-LAST:event_jcbClienteKeyReleased

    private void jcbAparelhoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcbAparelhoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbAparelhoKeyPressed

    private void jcbAparelhoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcbAparelhoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbAparelhoKeyReleased

    private void jbNovoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNovoClienteActionPerformed
        // TODO add your handling code here:
        new ClienteController().setVisible(true);
    }//GEN-LAST:event_jbNovoClienteActionPerformed

    private void jbNovoAparelhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNovoAparelhoActionPerformed
        // TODO add your handling code here:
        new AparelhoController().setVisible(true);
    }//GEN-LAST:event_jbNovoAparelhoActionPerformed

    private void jcbAparelhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbAparelhoActionPerformed
        if (jcbAparelho.getSelectedIndex() > -1) {
            this.ordemServicoSalvar.setAparelho(this.filtroAparelho.get(jcbAparelho.getSelectedIndex()));
        }
    }//GEN-LAST:event_jcbAparelhoActionPerformed

    private void jcbTecnicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTecnicoActionPerformed
        if (jcbTecnico.getSelectedIndex() > -1) {
            this.ordemServicoSalvar.setTecnico(this.filtroTecnico.get(jcbTecnico.getSelectedIndex()));
        }
    }//GEN-LAST:event_jcbTecnicoActionPerformed

    private void jcbTecnicoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcbTecnicoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbTecnicoKeyPressed

    private void jcbTecnicoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcbTecnicoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbTecnicoKeyReleased

    private void jbNovoTecnicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNovoTecnicoActionPerformed
        new TecnicoControler().setVisible(true);
    }//GEN-LAST:event_jbNovoTecnicoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new PecaUsadaController(this).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        ordemServicoSalvar.setData_abertura(LocalDate.now());
        ordemServicoSalvar.setStatus("Aberta");
        ordemServicoSalvar.setDescricao_problema(jtaDescricao.getText());
        ordemServicoSalvar.setSolucao(jtaSolucao.getText());
        ordemServicoSalvar.setCusto_total(calcularValorTotal());
        ordemServicoService.salvarOrdemServico(ordemServicoSalvar);
    }//GEN-LAST:event_jbSalvarActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        linhaSelecionada = jtPecasUsadas.getSelectedRow();
        if (pecasUsadas.size() > 0) {
            if (jtPecasUsadas.getValueAt(linhaSelecionada, 2) != null) {
                pecasUsadas.remove(linhaSelecionada);
                limparTabela();
                preencheTabela(pecasUsadas);
            } else {
                JOptionPane.showMessageDialog(null, "Você deve selecionar uma peça para realizar essa ação");
            }
        } else {
            JOptionPane.showMessageDialog(null, "A lista de peças usadas está vazia");
        }

    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed
        if (existeUmaLinhaSelecionadaComPecaUsada()) {
            new PecaUsadaController(this, pecasUsadas.get(linhaSelecionada)).setVisible(true);
        }
    }//GEN-LAST:event_jbEditarActionPerformed

    private void jcbClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbClienteActionPerformed
        if (jcbCliente.getSelectedIndex() > -1) {
            this.ordemServicoSalvar.setCliente(this.filtroClientes.get(jcbCliente.getSelectedIndex()));
        }
    }//GEN-LAST:event_jcbClienteActionPerformed

    public void atualizarListaPecasUsadas(PecaUsada pecaUsada) {
        this.pecasUsadas.add(pecaUsada);
        limparTabela();
        preencheTabela(pecasUsadas);
    }

    public void editarListaPecasUsadas(PecaUsada pecaUsada) {
        this.pecasUsadas.set(linhaSelecionada, pecaUsada);
        limparTabela();
        preencheTabela(pecasUsadas);
    }

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
            java.util.logging.Logger.getLogger(OrdemServicoController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrdemServicoController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrdemServicoController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrdemServicoController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrdemServicoController().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbNovoAparelho;
    private javax.swing.JButton jbNovoCliente;
    private javax.swing.JButton jbNovoTecnico;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JComboBox<String> jcbAparelho;
    private javax.swing.JComboBox<String> jcbCliente;
    private javax.swing.JComboBox<String> jcbTecnico;
    private javax.swing.JTable jtPecasUsadas;
    private javax.swing.JTextArea jtaDescricao;
    private javax.swing.JTextArea jtaSolucao;
    private javax.swing.JTextField jtfValorMaoDeObra;
    // End of variables declaration//GEN-END:variables
    JTextField editor;
}
