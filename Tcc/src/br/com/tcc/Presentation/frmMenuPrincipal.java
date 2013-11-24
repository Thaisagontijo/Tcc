/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.Presentation;

import br.com.tcc.DataAccess.AgendamentoDAO;
import br.com.tcc.DataAccess.CaixaDAO;
import br.com.tcc.DataAccess.ClienteDAO;
import br.com.tcc.DataAccess.DepositoDAO;
import br.com.tcc.DataAccess.ProdutoDAO;
import br.com.tcc.DomainModel.Agendamento;
import br.com.tcc.DomainModel.Caixa;
import br.com.tcc.DomainModel.Cliente;
import br.com.tcc.DomainModel.Deposito;
import br.com.tcc.DomainModel.ItemVendaProduto;
import br.com.tcc.DomainModel.ItemVendaServico;
import br.com.tcc.DomainModel.Produto;
import br.com.tcc.DomainModel.Servico;
import br.com.tcc.DomainModel.Usuario;
import br.com.tcc.DomainModel.Venda;
import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Thaisa
 */
public class frmMenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form frmMenuPrincipal
     */
    /*
     
     * Pegando a data/hora do sistema ... vai ser usada em todos os cadastros
     
     */
    /*
     * Criando objeto data e formatando a data/hora
     */
    private Date dataAtual = new Date();

    DateFormat formato = new SimpleDateFormat("HH:mm:ss");
    String formattedDate = formato.format(dataAtual);

    public frmMenuPrincipal(Usuario usuarioLogado) {

        this.usuarioLogado = usuarioLogado;
        this.getContentPane().setBackground(Color.WHITE);
        //this.setLocationRelativeTo(null);
        /*
         
         *  CARREGANDO OBJETOS AO INICIAR
         * 
         * 1) Tabela de agendamentos
         * 2) Tabela de Caixa ou não
         */

        daoAgendamento = new AgendamentoDAO();
        listaAgendamentos = new LinkedList<>();
        objetoAgendamentoSelecionadoNaTabela = new Agendamento();
        tblAgenda = new JTable();

        /*
         *  PREPARANDO OBJETOS PARA SER MOSTRADOS AO INICIAR O PROGRAMA
         
         */
        Agendamento tmpAgendamento = new Agendamento();
        tmpAgendamento.setRealizado(false);
        listaAgendamentos = daoAgendamento.Buscar(tmpAgendamento);

        initComponents();
        Color minhaCor = new Color(239, 239, 239);
        this.getContentPane().setBackground(minhaCor);

        /*
         PREENCHENDO TABELA DE AGENDAMENTOS
         
         */
        preencheTabelaAgendamentos();

        btnDeposito.setVisible(false);
        btnRetirada.setVisible(false);
        btnSaldoCaixa.setVisible(false);
        btnSaldoCaixaDetalhado.setVisible(false);
        btnFecharCaixa.setVisible(false);

        /*
         * PREPARANDO TELA DE VENDAS
         
         
         cbxCliente.removeAllItems();
         Cliente clienteTmp = new Cliente();
         clienteTmp.setNome("Selecione");
         cbxCliente.addItem(clienteTmp);
         daoCliente = new ClienteDAO();
         for(Cliente c:daoCliente.ListarTodos()){
         cbxCliente.addItem(c);
         }
         */
        preencheComboClientes();

        /*
         * Ao iniciar o programa as vendas estão bloqueadas até q se inicie uma nova venda
         
         */
        cbxCliente.setEnabled(false);
        tblVendas.setEnabled(false);
        btnIncluirItemVenda.setEnabled(false);
        btnAlterarItemVenda.setEnabled(false);
        btnExcluirItemVenda.setEnabled(false);
        btnReceberValorVenda.setEnabled(false);
        btnCancelarVenda.setEnabled(false);
        lblCliente.setEnabled(false);
    }

    protected void preencheComboClientes() {
        cbxCliente.removeAllItems();
        Cliente clienteTmp = new Cliente();
        clienteTmp.setNome("Selecione");
        cbxCliente.addItem(clienteTmp);
        daoCliente = new ClienteDAO();
        for (Cliente c : daoCliente.ListarTodos()) {
            cbxCliente.addItem(c);
        }

    }

    protected void preencheTabelaAgendamentos() {
        /*
         
         * DEFININDO "TABLE MODEL" COM LINHAS NÃO EDITAVEIS
         * 
         * http://www.guj.com.br/java/44193-jtable-nao-editavel
         
         */

        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };

        model.addColumn("ID");
        model.addColumn("FUNCIONÁRIO RESPONSÁVEL");
        model.addColumn("CLIENTE");
        model.addColumn("DATA/HORA");

        for (Agendamento p : listaAgendamentos) {
            Vector v = new Vector();
            v.add(0, p.getId());
            v.add(1, p.getFuncionario().getNome());
            v.add(2, p.getCliente().getNome());

            String data = "";
            data = p.getDataHora().getDate() + "/" + (p.getDataHora().getMonth() + 1) + "/"
                    + p.getDataHora().getYear() + " às " + p.getDataHora().getHours() + ":" + p.getDataHora().getMinutes();
            v.add(3, data);

            model.addRow(v);

        }

        tblAgenda.setModel(model);
        tblAgenda.repaint();

    }

    protected void preencheTabelaVendas() {
        /*
         
         * DEFININDO "TABLE MODEL" COM LINHAS NÃO EDITAVEIS
         * 
         * http://www.guj.com.br/java/44193-jtable-nao-editavel
         
         */

        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };

        model.addColumn("ID");
        model.addColumn("DESCRIÇÃO");
        model.addColumn("QUANTIDADE");
        model.addColumn("VALOR TOTAL");

        int i = 1;
        for (ItemVendaServico s : novaVenda.getServicos()) {
            Vector v = new Vector();

            v.add(0, i++);
            v.add(1, "Serviço");
            v.add(2, "conferir");

            model.addRow(v);

        }

        for (ItemVendaProduto p : novaVenda.getProdutos()) {
            Vector v = new Vector();

            v.add(0, i++);
            v.add(1, "Produto");
            v.add(2, p.getQtd());
            v.add(3, (p.getQtd() * p.getProduto().getPrecoVenda()));

            model.addRow(v);

        }

        tblVendas.setModel(model);
        tblVendas.repaint();

    }

    protected void desativarVenda() {
        cbxCliente.setEnabled(false);
        tblVendas.setEnabled(false);
        btnIncluirItemVenda.setEnabled(false);
        btnAlterarItemVenda.setEnabled(false);
        btnExcluirItemVenda.setEnabled(false);
        btnReceberValorVenda.setEnabled(false);
        btnCancelarVenda.setEnabled(false);
        lblCliente.setEnabled(false);

        novaVenda = null;

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
        jTabbedPanelPrincipal = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        btnAbrirCaixa = new javax.swing.JButton();
        btnRetirada = new javax.swing.JButton();
        btnDeposito = new javax.swing.JButton();
        btnSaldoCaixa = new javax.swing.JButton();
        btnSaldoCaixaDetalhado = new javax.swing.JButton();
        btnFecharCaixa = new javax.swing.JButton();
        jPanelVendas = new javax.swing.JPanel();
        lblCliente = new javax.swing.JLabel();
        cbxCliente = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVendas = new javax.swing.JTable();
        btnIncluirItemVenda = new javax.swing.JButton();
        btnAlterarItemVenda = new javax.swing.JButton();
        btnExcluirItemVenda = new javax.swing.JButton();
        btnReceberValorVenda = new javax.swing.JButton();
        btnCancelarVenda = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAgenda = new javax.swing.JTable();
        btnNovoAgendamento = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemClientes = new javax.swing.JMenuItem();
        jMenuItemFuncionarios = new javax.swing.JMenuItem();
        jMenuItemFormasDePagamentos = new javax.swing.JMenuItem();
        jMenuItemFornecedores = new javax.swing.JMenuItem();
        jMenuItemServicos = new javax.swing.JMenuItem();
        jMenuItemProdutos = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPanelPrincipal.setBackground(new java.awt.Color(0, 0, 0));

        btnAbrirCaixa.setBackground(new java.awt.Color(239, 239, 239));
        btnAbrirCaixa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAbrirCaixa.setText("Abrir Caixa");
        btnAbrirCaixa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAbrirCaixaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAbrirCaixaMouseExited(evt);
            }
        });
        btnAbrirCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirCaixaActionPerformed(evt);
            }
        });

        btnRetirada.setBackground(new java.awt.Color(239, 239, 239));
        btnRetirada.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRetirada.setText("Retirada");
        btnRetirada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRetiradaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRetiradaMouseExited(evt);
            }
        });
        btnRetirada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetiradaActionPerformed(evt);
            }
        });

        btnDeposito.setBackground(new java.awt.Color(239, 239, 239));
        btnDeposito.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDeposito.setText("Entrada");
        btnDeposito.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDepositoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDepositoMouseExited(evt);
            }
        });
        btnDeposito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepositoActionPerformed(evt);
            }
        });

        btnSaldoCaixa.setBackground(new java.awt.Color(239, 239, 239));
        btnSaldoCaixa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSaldoCaixa.setText("Saldo do Caixa");
        btnSaldoCaixa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSaldoCaixaMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSaldoCaixaMouseEntered(evt);
            }
        });
        btnSaldoCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaldoCaixaActionPerformed(evt);
            }
        });

        btnSaldoCaixaDetalhado.setBackground(new java.awt.Color(239, 239, 239));
        btnSaldoCaixaDetalhado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSaldoCaixaDetalhado.setText("Extrato Caixa");
        btnSaldoCaixaDetalhado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSaldoCaixaDetalhadoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSaldoCaixaDetalhadoMouseExited(evt);
            }
        });
        btnSaldoCaixaDetalhado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaldoCaixaDetalhadoActionPerformed(evt);
            }
        });

        btnFecharCaixa.setBackground(new java.awt.Color(239, 239, 239));
        btnFecharCaixa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnFecharCaixa.setText("Fechar Caixa");
        btnFecharCaixa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnFecharCaixaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnFecharCaixaMouseExited(evt);
            }
        });
        btnFecharCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharCaixaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSaldoCaixa, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                            .addComponent(btnRetirada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(100, 100, 100)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnDeposito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSaldoCaixaDetalhado, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(281, 281, 281)
                        .addComponent(btnFecharCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(243, 243, 243)
                        .addComponent(btnAbrirCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(262, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(btnAbrirCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRetirada, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(btnDeposito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(45, 45, 45)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaldoCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSaldoCaixaDetalhado, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addComponent(btnFecharCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );

        jTabbedPanelPrincipal.addTab("Caixa", jPanel2);

        lblCliente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCliente.setText("Cliente*:");

        cbxCliente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxCliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        tblVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblVendas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVendasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblVendas);

        btnIncluirItemVenda.setText("Incluir");
        btnIncluirItemVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirItemVendaActionPerformed(evt);
            }
        });

        btnAlterarItemVenda.setText("Alterar");
        btnAlterarItemVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarItemVendaActionPerformed(evt);
            }
        });

        btnExcluirItemVenda.setText("Excluir");

        btnReceberValorVenda.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnReceberValorVenda.setText("Receber");
        btnReceberValorVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReceberValorVendaActionPerformed(evt);
            }
        });

        btnCancelarVenda.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCancelarVenda.setText("Cancelar");
        btnCancelarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarVendaActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setText("Nova");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelVendasLayout = new javax.swing.GroupLayout(jPanelVendas);
        jPanelVendas.setLayout(jPanelVendasLayout);
        jPanelVendasLayout.setHorizontalGroup(
            jPanelVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVendasLayout.createSequentialGroup()
                .addGroup(jPanelVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelVendasLayout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addGroup(jPanelVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelVendasLayout.createSequentialGroup()
                                .addComponent(lblCliente)
                                .addGap(18, 18, 18)
                                .addComponent(cbxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelVendasLayout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(74, 74, 74)
                                .addGroup(jPanelVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnIncluirItemVenda)
                                    .addComponent(btnExcluirItemVenda)
                                    .addComponent(btnAlterarItemVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanelVendasLayout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(btnReceberValorVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(btnCancelarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanelVendasLayout.setVerticalGroup(
            jPanelVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVendasLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanelVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanelVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelVendasLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(btnIncluirItemVenda)
                        .addGap(18, 18, 18)
                        .addComponent(btnAlterarItemVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluirItemVenda))
                    .addGroup(jPanelVendasLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43)
                .addGroup(jPanelVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReceberValorVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(119, Short.MAX_VALUE))
        );

        jTabbedPanelPrincipal.addTab("Vendas", jPanelVendas);

        jPanel1.setBackground(new java.awt.Color(228, 228, 228));

        tblAgenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblAgenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAgendaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAgenda);

        btnNovoAgendamento.setBackground(new java.awt.Color(239, 239, 239));
        btnNovoAgendamento.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNovoAgendamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/tcc/Presentation/icones/Novo.png"))); // NOI18N
        btnNovoAgendamento.setText("Novo Agendamento");
        btnNovoAgendamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoAgendamentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(252, 252, 252)
                        .addComponent(btnNovoAgendamento)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNovoAgendamento)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jTabbedPanelPrincipal.addTab("Agenda", jPanel1);

        jMenu1.setText("Cadastros");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jMenuItemClientes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItemClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/tcc/Presentation/icones/cliente.png"))); // NOI18N
        jMenuItemClientes.setText("Clientes");
        jMenuItemClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemClientesActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemClientes);

        jMenuItemFuncionarios.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItemFuncionarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/tcc/Presentation/icones/funcionario.png"))); // NOI18N
        jMenuItemFuncionarios.setText("Funcionários");
        jMenuItemFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFuncionariosActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemFuncionarios);

        jMenuItemFormasDePagamentos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItemFormasDePagamentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/tcc/Presentation/icones/pagamento.png"))); // NOI18N
        jMenuItemFormasDePagamentos.setText("Formas de Pagamento");
        jMenuItemFormasDePagamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFormasDePagamentosActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemFormasDePagamentos);

        jMenuItemFornecedores.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItemFornecedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/tcc/Presentation/icones/fornecedor.png"))); // NOI18N
        jMenuItemFornecedores.setText("Fornecedores");
        jMenuItemFornecedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFornecedoresActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemFornecedores);

        jMenuItemServicos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItemServicos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/tcc/Presentation/icones/servico.png"))); // NOI18N
        jMenuItemServicos.setText("Serviços");
        jMenuItemServicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemServicosActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemServicos);

        jMenuItemProdutos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItemProdutos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/tcc/Presentation/icones/produto.png"))); // NOI18N
        jMenuItemProdutos.setText("Produtos");
        jMenuItemProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemProdutosActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemProdutos);

        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/tcc/Presentation/icones/tipoproduto.png"))); // NOI18N
        jMenuItem1.setText("Tipo de Produto");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem4.setText("Usuários");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Agenda");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Estoques");
        jMenu3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jMenuItem5.setText("Estoque Atual");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenuItem6.setText("Lançar Compra");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Caixas");
        jMenu4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuBar1.add(jMenu4);

        jMenu5.setText("Relatórios");
        jMenu5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuBar1.add(jMenu5);

        jMenu6.setText("Sistema");
        jMenu6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jMenuItem2.setText("Sair");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem2);

        jMenuItem3.setText("Sobre");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem3);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 818, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(153, 153, 153)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemClientesActionPerformed
        frmClienteLista janela = new frmClienteLista(this, rootPaneCheckingEnabled);
        janela.setLocationRelativeTo(null);
        janela.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jMenuItemClientesActionPerformed

    private void jMenuItemServicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemServicosActionPerformed
        frmCadastroServicosLista janela = new frmCadastroServicosLista(this, rootPaneCheckingEnabled);
        janela.setLocationRelativeTo(null);
        janela.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jMenuItemServicosActionPerformed

    private void jMenuItemFormasDePagamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFormasDePagamentosActionPerformed
        frmCadastroFormaDePagamentoLista janela = new frmCadastroFormaDePagamentoLista(this, rootPaneCheckingEnabled);
        janela.setLocationRelativeTo(null);
        janela.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jMenuItemFormasDePagamentosActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        frmTipoProdutoLista janela = new frmTipoProdutoLista(this, rootPaneCheckingEnabled);
        janela.setLocationRelativeTo(null);
        janela.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItemProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemProdutosActionPerformed
        frmProdutoLista janela = new frmProdutoLista(this, rootPaneCheckingEnabled);
        janela.setLocationRelativeTo(null);
        janela.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jMenuItemProdutosActionPerformed

    private void jMenuItemFornecedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFornecedoresActionPerformed
        frmFornecedorLista janela = new frmFornecedorLista(this, rootPaneCheckingEnabled);
        janela.setLocationRelativeTo(null);
        janela.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jMenuItemFornecedoresActionPerformed

    private void tblAgendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAgendaMouseClicked

        /*
         * PEGANDO O OBJETO SELECIONADO NA TABELA COM 1 CLIQUE
         
         */
      //  tblServicos.isCellEditable(tblServicos.getSelectedRow(), tblServicos.getSelectedColumn());
        if (idItemAgendaSelecionado == tblAgenda.getSelectedRow()) { //se está clicando na mesma linha
            qtdCliques++;
            if (qtdCliques == 2) {
                JOptionPane.showMessageDialog(rootPane, "chama a descricao");
                qtdCliques = 0;
            }
        } else {
            qtdCliques = 1;
        }

        idItemAgendaSelecionado = tblAgenda.getSelectedRow();
        objetoAgendamentoSelecionadoNaTabela = listaAgendamentos.get(idItemAgendaSelecionado);

        //JOptionPane.showMessageDialog(rootPane,objSelecionadoNaTabela.getNome());

    }//GEN-LAST:event_tblAgendaMouseClicked

    private void btnNovoAgendamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoAgendamentoActionPerformed
        frmCadastroAgendamento janela = new frmCadastroAgendamento(this, rootPaneCheckingEnabled, this, rootPaneCheckingEnabled);
        janela.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_btnNovoAgendamentoActionPerformed

    private void jMenuItemFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFuncionariosActionPerformed
        frmFuncionarioLista janela = new frmFuncionarioLista(this, rootPaneCheckingEnabled);
        janela.setLocationRelativeTo(null);
        janela.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jMenuItemFuncionariosActionPerformed

    private void btnAbrirCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirCaixaActionPerformed

        try {
            float entrada = Float.parseFloat(JOptionPane.showInputDialog("Informe o valor para troco a inserir no caixa"));
            Deposito depositoEntrada = new Deposito();
            depositoEntrada.setValor(entrada);
            depositoEntrada.setFuncionario(usuarioLogado.getFuncionario());
            depositoEntrada.setObservacao("Deposito inicial de abertura de caixa");
            caixa = new Caixa();
            depositoEntrada.setCaixa(caixa);
            caixa.addDeposito(depositoEntrada);
            caixa.setFuncionario(usuarioLogado.getFuncionario());
            CaixaDAO daoCaixa = new CaixaDAO();
            daoCaixa.Salvar(caixa);

            btnDeposito.setVisible(true);
            btnRetirada.setVisible(true);
            btnSaldoCaixa.setVisible(true);
            btnSaldoCaixaDetalhado.setVisible(true);
            btnAbrirCaixa.setVisible(false);
            btnFecharCaixa.setVisible(true);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(rootPane, "Valor Invalido !");
        }

    }//GEN-LAST:event_btnAbrirCaixaActionPerformed

    private void btnSaldoCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaldoCaixaActionPerformed
        JOptionPane.showMessageDialog(rootPane, "O saldo atual é R$ " + caixa.calcularTotalCaixa());
    }//GEN-LAST:event_btnSaldoCaixaActionPerformed

    private void btnRetiradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetiradaActionPerformed
        frmRetiradaCaixa janela = new frmRetiradaCaixa(this, rootPaneCheckingEnabled, this);
        janela.setLocationRelativeTo(null);
        janela.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_btnRetiradaActionPerformed

    private void btnDepositoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDepositoActionPerformed
        frmDepositoCaixa janela = new frmDepositoCaixa(this, rootPaneCheckingEnabled, this);
        janela.setLocationRelativeTo(null);
        janela.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_btnDepositoActionPerformed

    private void btnSaldoCaixaDetalhadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaldoCaixaDetalhadoActionPerformed
        frmExtratoCaixa janela = new frmExtratoCaixa(this, rootPaneCheckingEnabled, this);
        janela.setLocationRelativeTo(null);
        janela.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_btnSaldoCaixaDetalhadoActionPerformed

    private void btnFecharCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharCaixaActionPerformed

        CaixaDAO daoCaixa = new CaixaDAO();
    //    daoDeposito = new DepositoDAO();

        caixa.setDataFechamento(new Date());
        caixa.setFuncionario(usuarioLogado.getFuncionario());
        if (daoCaixa.Salvar(caixa)) {
            JOptionPane.showMessageDialog(rootPane, "Caixa Fechado com sucesso!");

            btnDeposito.setVisible(false);
            btnRetirada.setVisible(false);
            btnSaldoCaixa.setVisible(false);
            btnSaldoCaixaDetalhado.setVisible(false);
            btnAbrirCaixa.setVisible(true);
            btnFecharCaixa.setVisible(false);
            caixa = null;
        } else {
            JOptionPane.showMessageDialog(rootPane, "Erro ao fechar o caixa!");
        }
    }//GEN-LAST:event_btnFecharCaixaActionPerformed

    private void btnIncluirItemVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirItemVendaActionPerformed
        frmInclusaoItemVenda janela = new frmInclusaoItemVenda(this, rootPaneCheckingEnabled, this, false);
        janela.setLocationRelativeTo(null);
        janela.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_btnIncluirItemVendaActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        //Validando venda 
        if (caixa == null) {
            JOptionPane.showMessageDialog(rootPane, "Para realzar a venda o caixa deve ser aberto !");
        } else {

            cbxCliente.setEnabled(true);
            tblVendas.setEnabled(true);
            btnIncluirItemVenda.setEnabled(true);
            btnAlterarItemVenda.setEnabled(true);
            btnExcluirItemVenda.setEnabled(true);
            btnReceberValorVenda.setEnabled(true);
            btnCancelarVenda.setEnabled(true);
            lblCliente.setEnabled(true);

            novaVenda = new Venda();
            preencheTabelaVendas();
            novaVenda.setFuncionario(usuarioLogado.getFuncionario());
            novaVenda.setCaixa(caixa);
            preencheComboClientes();

            //  VendaDAO a = new VendaDAO();
            //a.Salvar(novaVenda);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnCancelarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarVendaActionPerformed
        if (JOptionPane.showConfirmDialog(rootPane, "Pergunta", "Você tem certeza que deseja cancelar a compra?", JOptionPane.OK_CANCEL_OPTION) == 0) {
            desativarVenda();

        }

    }//GEN-LAST:event_btnCancelarVendaActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        this.dispose();
        frmLogin janela = new frmLogin();
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        JOptionPane.showMessageDialog(rootPane, "BeatuySystem Todos os direitos reservados");
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        frmUsuarioLista janela = new frmUsuarioLista(this, rootPaneCheckingEnabled);
        janela.setLocationRelativeTo(null);
        janela.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void btnReceberValorVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReceberValorVendaActionPerformed
        frmReceberPagamentoVenda janela = new frmReceberPagamentoVenda(this, rootPaneCheckingEnabled, this);
        janela.setLocationRelativeTo(null);
        clienteCOmboVenda = (Cliente) cbxCliente.getSelectedItem();
        // JOptionPane.showMessageDialog(rootPane, cbxCliente.getSelectedItem());
        janela.setVisible(rootPaneCheckingEnabled);

    }//GEN-LAST:event_btnReceberValorVendaActionPerformed

    private void btnAbrirCaixaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAbrirCaixaMouseEntered
        Color minhaCor = new Color(115, 183, 253);
        this.btnAbrirCaixa.setBackground(minhaCor);
    }//GEN-LAST:event_btnAbrirCaixaMouseEntered

    private void btnRetiradaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRetiradaMouseEntered
        Color minhaCor = new Color(115, 183, 253);
        this.btnRetirada.setBackground(minhaCor);
    }//GEN-LAST:event_btnRetiradaMouseEntered

    private void btnDepositoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDepositoMouseEntered
        Color minhaCor = new Color(115, 183, 253);
        this.btnDeposito.setBackground(minhaCor);
    }//GEN-LAST:event_btnDepositoMouseEntered

    private void btnSaldoCaixaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaldoCaixaMouseEntered
        Color minhaCor = new Color(115, 183, 253);
        this.btnSaldoCaixa.setBackground(minhaCor);
    }//GEN-LAST:event_btnSaldoCaixaMouseEntered

    private void btnFecharCaixaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFecharCaixaMouseEntered
        Color minhaCor = new Color(115, 183, 253);
        this.btnFecharCaixa.setBackground(minhaCor);
    }//GEN-LAST:event_btnFecharCaixaMouseEntered

    private void btnAbrirCaixaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAbrirCaixaMouseExited
        Color minhaCor = new Color(239, 239, 239);
        this.btnAbrirCaixa.setBackground(minhaCor);
    }//GEN-LAST:event_btnAbrirCaixaMouseExited

    private void btnRetiradaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRetiradaMouseExited
        Color minhaCor = new Color(239, 239, 239);
        this.btnRetirada.setBackground(minhaCor);
    }//GEN-LAST:event_btnRetiradaMouseExited

    private void btnDepositoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDepositoMouseExited
        Color minhaCor = new Color(239, 239, 239);
        this.btnDeposito.setBackground(minhaCor);
    }//GEN-LAST:event_btnDepositoMouseExited

    private void btnSaldoCaixaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaldoCaixaMouseExited
        Color minhaCor = new Color(239, 239, 239);
        this.btnSaldoCaixa.setBackground(minhaCor);
    }//GEN-LAST:event_btnSaldoCaixaMouseExited

    private void btnSaldoCaixaDetalhadoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaldoCaixaDetalhadoMouseEntered
        Color minhaCor = new Color(115, 183, 253);
        this.btnSaldoCaixaDetalhado.setBackground(minhaCor);
    }//GEN-LAST:event_btnSaldoCaixaDetalhadoMouseEntered

    private void btnSaldoCaixaDetalhadoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaldoCaixaDetalhadoMouseExited
        Color minhaCor = new Color(239, 239, 239);
        this.btnSaldoCaixaDetalhado.setBackground(minhaCor);
    }//GEN-LAST:event_btnSaldoCaixaDetalhadoMouseExited

    private void btnFecharCaixaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFecharCaixaMouseExited
        Color minhaCor = new Color(239, 239, 239);
        this.btnFecharCaixa.setBackground(minhaCor);
    }//GEN-LAST:event_btnFecharCaixaMouseExited

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        frmCadastroCompra janela = new frmCadastroCompra(this, rootPaneCheckingEnabled, this, false);
        janela.setLocationRelativeTo(null);
        janela.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void btnAlterarItemVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarItemVendaActionPerformed
        if (objetoAgendamentoSelecionadoNaTabela != null) {
            frmInclusaoItemVenda janela = new frmInclusaoItemVenda(this, rootPaneCheckingEnabled, this, true);
            janela.setLocationRelativeTo(null);
            janela.setVisible(rootPaneCheckingEnabled);
        }

    }//GEN-LAST:event_btnAlterarItemVendaActionPerformed

    private void tblVendasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVendasMouseClicked

        /*
         *      PEGANDO O OBJETO SELECIONADO NA TABELA COM 1 CLIQUE
         
         */

    }//GEN-LAST:event_tblVendasMouseClicked

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        try {
            //Arquivo do Relatorio
            String relatorio = System.getProperty("user.dir") + "/relatorio/relatorioEstoque.jasper";

            //Lista a ser exibida no relatorio
            ProdutoDAO produtoDAO = new ProdutoDAO();
            List<Produto> produtos = produtoDAO.ListarTodos();

            //Fonte de dados
            JRBeanCollectionDataSource fonteDados = new JRBeanCollectionDataSource(produtos);

            //Gera o Relatorio
            JasperPrint relatorioGerado = JasperFillManager.fillReport(relatorio, null, fonteDados);

            //Exibe o Relatorio
            JasperViewer jasperViewer = new JasperViewer(relatorioGerado, false);
            jasperViewer.setVisible(true);
        }catch(JRException e){
            System.out.println("Erro ao gerar relatorio: " + e.getMessage());
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
       
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    /*
     *  OUTRAS VARIÁVEIS
     */
    protected Usuario usuarioLogado;
    protected AgendamentoDAO daoAgendamento;
    protected List<Agendamento> listaAgendamentos;
    protected Agendamento objetoAgendamentoSelecionadoNaTabela;
    protected int idItemAgendaSelecionado;
    protected int qtdCliques;
    protected Caixa caixa;
    private ClienteDAO daoCliente;
    protected Venda novaVenda;
    private DepositoDAO daoDeposito;
    protected Cliente clienteCOmboVenda;
    protected Servico objetoServicoSelecionadoNaTabela;
    protected Produto objetoProdutoSelecionadoNaTabela;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrirCaixa;
    private javax.swing.JButton btnAlterarItemVenda;
    private javax.swing.JButton btnCancelarVenda;
    private javax.swing.JButton btnDeposito;
    private javax.swing.JButton btnExcluirItemVenda;
    private javax.swing.JButton btnFecharCaixa;
    private javax.swing.JButton btnIncluirItemVenda;
    private javax.swing.JButton btnNovoAgendamento;
    private javax.swing.JButton btnReceberValorVenda;
    private javax.swing.JButton btnRetirada;
    private javax.swing.JButton btnSaldoCaixa;
    private javax.swing.JButton btnSaldoCaixaDetalhado;
    private javax.swing.JComboBox cbxCliente;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItemClientes;
    private javax.swing.JMenuItem jMenuItemFormasDePagamentos;
    private javax.swing.JMenuItem jMenuItemFornecedores;
    private javax.swing.JMenuItem jMenuItemFuncionarios;
    private javax.swing.JMenuItem jMenuItemProdutos;
    private javax.swing.JMenuItem jMenuItemServicos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelVendas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPanelPrincipal;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JTable tblAgenda;
    private javax.swing.JTable tblVendas;
    // End of variables declaration//GEN-END:variables
}
