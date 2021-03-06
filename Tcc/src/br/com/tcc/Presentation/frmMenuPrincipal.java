/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.Presentation;

import br.com.tcc.DataAccess.AgendamentoDAO;
import br.com.tcc.DataAccess.CaixaDAO;
import br.com.tcc.DataAccess.CaixaDAO2;
import br.com.tcc.DataAccess.ClienteDAO;
import br.com.tcc.DataAccess.ConexaoBanco;
import br.com.tcc.DataAccess.DepositoDAO;
import br.com.tcc.DataAccess.ProdutoDAO;
import br.com.tcc.DataAccess.VendaDAO;
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
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
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

        /*
         INICIANDO DAO CAIXA
         */
        daoCaixa = new CaixaDAO();

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
        //Agendamento tmpAgendamento = new Agendamento();
        //tmpAgendamento.setRealizado(false);
        listaAgendamentos = daoAgendamento.Buscar(null);

        initComponents();

        verificaAdmin();//verifica se o usuario logado eh o administrador para mostrar a opcao de cadastrarnovos usuarios
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
        btnReceberFatura.setVisible(false);

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
        tblVendaServicos.setEnabled(false);
        btnIncluirItemVenda.setEnabled(false);

        btnExcluirItemVenda.setEnabled(false);
        btnReceberValorVenda.setEnabled(false);
        btnCancelarVenda.setEnabled(false);
        lblCliente.setEnabled(false);
        jMenuItemFormasDePagamentos.setVisible(false);//nao mostra menu de forma de pagamento

        //FULL SCREEN
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        /* coloca uma figura na barra de título da janela  
         URL url = this.getClass().getResource("./icones/logo1.png");  
         Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);  
         this.setIconImage(imagemTitulo);
         */
    }
    
    private void verificaAdmin(){
        if(usuarioLogado.getId() != 1){
            jMenuItemUsuarios.setVisible(false);
        }
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

        if (listaAgendamentos.isEmpty()) {
            btnAgendamentoApagar.setEnabled(false);
            btnAgendamentoEditar.setEnabled(false);
            btnAgendamentoRealizado.setEnabled(false);
        } else {
            btnAgendamentoApagar.setEnabled(true);
            btnAgendamentoEditar.setEnabled(true);
            btnAgendamentoRealizado.setEnabled(true);
        }

    }

    protected void preencheTabelaVendasServicos() {
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
        model.addColumn("NOME");
        model.addColumn("FUNCIONARIO");
        model.addColumn("VALOR TOTAL");

        int i = 1;
        for (ItemVendaServico s : novaVenda.getServicos()) {
            Vector v = new Vector();

            v.add(0, i++);
            v.add(1, s.getServico().getNome());
            v.add(2, s.getFuncionario().getNome());
            v.add(3, s.getValor());

            model.addRow(v);

        }

        

        tblVendaServicos.setModel(model);
        tblVendaServicos.repaint();

    }
    
    protected void preencheTabelaVendasProduto() {
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
        model.addColumn("NOME");
       model.addColumn("QUANTIDADE");
        model.addColumn("VALOR TOTAL");

        int i = 1;
     

        for (ItemVendaProduto p : novaVenda.getProdutos()) {
            Vector v = new Vector();

            v.add(0, i++);
            v.add(1, p.getProduto().getNome());
            v.add(2, p.getQtd());
            v.add(3, (p.getValor()));

            model.addRow(v);

        }

        tblVendaProdutos.setModel(model);
        tblVendaProdutos.repaint();

    }

    protected void desativarVenda() {
        novaVenda.getServicos().clear();
        novaVenda.getProdutos().clear();
        preencheTabelaVendasProduto();
        preencheTabelaVendasServicos();
        
        
        cbxCliente.setEnabled(false);
        tblVendaServicos.setEnabled(false);
        btnIncluirItemVenda.setEnabled(false);
    
        btnExcluirItemVenda.setEnabled(false);
        btnReceberValorVenda.setEnabled(false);
        btnCancelarVenda.setEnabled(false);
        lblCliente.setEnabled(false);

        novaVenda = null;
        btnNovaVenda.setEnabled(true);

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
        jPanelCaixa = new javax.swing.JPanel();
        btnAbrirCaixa = new javax.swing.JButton();
        btnRetirada = new javax.swing.JButton();
        btnDeposito = new javax.swing.JButton();
        btnSaldoCaixa = new javax.swing.JButton();
        btnSaldoCaixaDetalhado = new javax.swing.JButton();
        btnFecharCaixa = new javax.swing.JButton();
        btnReceberFatura = new javax.swing.JButton();
        jPanelVendas = new javax.swing.JPanel();
        lblCliente = new javax.swing.JLabel();
        cbxCliente = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVendaServicos = new javax.swing.JTable();
        btnIncluirItemVenda = new javax.swing.JButton();
        btnExcluirItemVenda = new javax.swing.JButton();
        btnReceberValorVenda = new javax.swing.JButton();
        btnCancelarVenda = new javax.swing.JButton();
        btnNovaVenda = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblVendaProdutos = new javax.swing.JTable();
        jPanelAgenda = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAgenda = new javax.swing.JTable();
        btnNovoAgendamento = new javax.swing.JButton();
        btnAgendamentoRealizado = new javax.swing.JButton();
        btnAgendamentoEditar = new javax.swing.JButton();
        btnAgendamentoApagar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuCadastros = new javax.swing.JMenu();
        jMenuItemClientes = new javax.swing.JMenuItem();
        jMenuItemFuncionarios = new javax.swing.JMenuItem();
        jMenuItemFormasDePagamentos = new javax.swing.JMenuItem();
        jMenuItemFornecedores = new javax.swing.JMenuItem();
        jMenuItemServicos = new javax.swing.JMenuItem();
        jMenuItemProdutos = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItemUsuarios = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItemEstoque = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        relatorioAgendamentos = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItemRelatorioCaixas = new javax.swing.JMenuItem();
        jMenuItemCompras = new javax.swing.JMenuItem();
        jMenuItemAniversariantes = new javax.swing.JMenuItem();
        jMenuItemRelatorioVendas = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItemFazerBackup = new javax.swing.JMenuItem();
        jMenuItemRecuperarBackup = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItemSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        btnAbrirCaixa.setBackground(new java.awt.Color(239, 239, 239));
        btnAbrirCaixa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAbrirCaixa.setText("ABRIR CAIXA");
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
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSaldoCaixaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSaldoCaixaMouseExited(evt);
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

        btnReceberFatura.setBackground(new java.awt.Color(239, 239, 239));
        btnReceberFatura.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnReceberFatura.setText("Receber Fatura Cliente");
        btnReceberFatura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnReceberFaturaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnReceberFaturaMouseExited(evt);
            }
        });
        btnReceberFatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReceberFaturaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelCaixaLayout = new javax.swing.GroupLayout(jPanelCaixa);
        jPanelCaixa.setLayout(jPanelCaixaLayout);
        jPanelCaixaLayout.setHorizontalGroup(
            jPanelCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCaixaLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanelCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnRetirada, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSaldoCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(121, 121, 121)
                .addGroup(jPanelCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSaldoCaixaDetalhado, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(jPanelCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnReceberFatura)
                    .addComponent(btnFecharCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74))
            .addGroup(jPanelCaixaLayout.createSequentialGroup()
                .addGap(320, 320, 320)
                .addComponent(btnAbrirCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelCaixaLayout.setVerticalGroup(
            jPanelCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCaixaLayout.createSequentialGroup()
                .addContainerGap(105, Short.MAX_VALUE)
                .addComponent(btnAbrirCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRetirada, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReceberFatura, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(jPanelCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaldoCaixaDetalhado, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFecharCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSaldoCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(149, Short.MAX_VALUE))
        );

        jTabbedPanelPrincipal.addTab("Caixa", jPanelCaixa);

        lblCliente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCliente.setText("Cliente*:");

        cbxCliente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxCliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        tblVendaServicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblVendaServicos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVendaServicosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblVendaServicos);

        btnIncluirItemVenda.setBackground(new java.awt.Color(239, 239, 239));
        btnIncluirItemVenda.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnIncluirItemVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/tcc/Presentation/icones/Novo.png"))); // NOI18N
        btnIncluirItemVenda.setText("Incluir Item");
        btnIncluirItemVenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnIncluirItemVendaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnIncluirItemVendaMouseExited(evt);
            }
        });
        btnIncluirItemVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirItemVendaActionPerformed(evt);
            }
        });

        btnExcluirItemVenda.setBackground(new java.awt.Color(239, 239, 239));
        btnExcluirItemVenda.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnExcluirItemVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/tcc/Presentation/icones/excluir.png"))); // NOI18N
        btnExcluirItemVenda.setText("Excluir Item");
        btnExcluirItemVenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnExcluirItemVendaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExcluirItemVendaMouseExited(evt);
            }
        });
        btnExcluirItemVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirItemVendaActionPerformed(evt);
            }
        });

        btnReceberValorVenda.setBackground(new java.awt.Color(239, 239, 239));
        btnReceberValorVenda.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnReceberValorVenda.setText("Receber");
        btnReceberValorVenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnReceberValorVendaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnReceberValorVendaMouseExited(evt);
            }
        });
        btnReceberValorVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReceberValorVendaActionPerformed(evt);
            }
        });

        btnCancelarVenda.setBackground(new java.awt.Color(239, 239, 239));
        btnCancelarVenda.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCancelarVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/tcc/Presentation/icones/Fechar.png"))); // NOI18N
        btnCancelarVenda.setText("Cancelar");
        btnCancelarVenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelarVendaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancelarVendaMouseExited(evt);
            }
        });
        btnCancelarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarVendaActionPerformed(evt);
            }
        });

        btnNovaVenda.setBackground(new java.awt.Color(239, 239, 239));
        btnNovaVenda.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNovaVenda.setText("Nova");
        btnNovaVenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNovaVendaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNovaVendaMouseExited(evt);
            }
        });
        btnNovaVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovaVendaActionPerformed(evt);
            }
        });

        jLabel3.setText("Tabela de Produtos");

        jLabel4.setText("Tabela de Serviços");

        tblVendaProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblVendaProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVendaProdutosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblVendaProdutos);

        javax.swing.GroupLayout jPanelVendasLayout = new javax.swing.GroupLayout(jPanelVendas);
        jPanelVendas.setLayout(jPanelVendasLayout);
        jPanelVendasLayout.setHorizontalGroup(
            jPanelVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVendasLayout.createSequentialGroup()
                .addGroup(jPanelVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelVendasLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jPanelVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelVendasLayout.createSequentialGroup()
                                .addComponent(lblCliente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelVendasLayout.createSequentialGroup()
                                .addGap(571, 571, 571)
                                .addGroup(jPanelVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnIncluirItemVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnExcluirItemVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanelVendasLayout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(btnNovaVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(btnReceberValorVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(btnCancelarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelVendasLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(jPanelVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addContainerGap(106, Short.MAX_VALUE))
            .addGroup(jPanelVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelVendasLayout.createSequentialGroup()
                    .addGap(70, 70, 70)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(257, Short.MAX_VALUE)))
        );
        jPanelVendasLayout.setVerticalGroup(
            jPanelVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVendasLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanelVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanelVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelVendasLayout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(btnIncluirItemVenda)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluirItemVenda)
                        .addGap(19, 19, 19))
                    .addGroup(jPanelVendasLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(10, 10, 10)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanelVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReceberValorVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovaVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
            .addGroup(jPanelVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelVendasLayout.createSequentialGroup()
                    .addGap(118, 118, 118)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(265, Short.MAX_VALUE)))
        );

        jTabbedPanelPrincipal.addTab("Vendas", jPanelVendas);

        jPanelAgenda.setBackground(new java.awt.Color(228, 228, 228));

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

        btnNovoAgendamento.setBackground(java.awt.Color.lightGray);
        btnNovoAgendamento.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNovoAgendamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/tcc/Presentation/icones/Novo.png"))); // NOI18N
        btnNovoAgendamento.setText("Novo Agendamento");
        btnNovoAgendamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNovoAgendamentoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNovoAgendamentoMouseExited(evt);
            }
        });
        btnNovoAgendamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoAgendamentoActionPerformed(evt);
            }
        });

        btnAgendamentoRealizado.setBackground(java.awt.Color.lightGray);
        btnAgendamentoRealizado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAgendamentoRealizado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/tcc/Presentation/icones/salvar.png"))); // NOI18N
        btnAgendamentoRealizado.setText("Realizado");
        btnAgendamentoRealizado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAgendamentoRealizadoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAgendamentoRealizadoMouseExited(evt);
            }
        });
        btnAgendamentoRealizado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendamentoRealizadoActionPerformed(evt);
            }
        });

        btnAgendamentoEditar.setBackground(java.awt.Color.lightGray);
        btnAgendamentoEditar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAgendamentoEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/tcc/Presentation/icones/alterar.png"))); // NOI18N
        btnAgendamentoEditar.setText("Editar");
        btnAgendamentoEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAgendamentoEditarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAgendamentoEditarMouseExited(evt);
            }
        });
        btnAgendamentoEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendamentoEditarActionPerformed(evt);
            }
        });

        btnAgendamentoApagar.setBackground(java.awt.Color.lightGray);
        btnAgendamentoApagar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAgendamentoApagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/tcc/Presentation/icones/excluir.png"))); // NOI18N
        btnAgendamentoApagar.setText("Excluir");
        btnAgendamentoApagar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAgendamentoApagarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAgendamentoApagarMouseExited(evt);
            }
        });
        btnAgendamentoApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendamentoApagarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelAgendaLayout = new javax.swing.GroupLayout(jPanelAgenda);
        jPanelAgenda.setLayout(jPanelAgendaLayout);
        jPanelAgendaLayout.setHorizontalGroup(
            jPanelAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAgendaLayout.createSequentialGroup()
                .addGroup(jPanelAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAgendaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanelAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAgendamentoRealizado, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgendamentoEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAgendamentoApagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanelAgendaLayout.createSequentialGroup()
                        .addGap(252, 252, 252)
                        .addComponent(btnNovoAgendamento)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelAgendaLayout.setVerticalGroup(
            jPanelAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAgendaLayout.createSequentialGroup()
                .addGroup(jPanelAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAgendaLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelAgendaLayout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(btnAgendamentoRealizado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnAgendamentoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnAgendamentoApagar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNovoAgendamento)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jTabbedPanelPrincipal.addTab("Agenda", jPanelAgenda);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/tcc/Presentation/icones/logo350px.png"))); // NOI18N
        jLabel2.setText("jLabel2");

        jMenuCadastros.setText("Cadastros");
        jMenuCadastros.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jMenuItemClientes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItemClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/tcc/Presentation/icones/cliente.png"))); // NOI18N
        jMenuItemClientes.setText("Clientes");
        jMenuItemClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemClientesActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemClientes);

        jMenuItemFuncionarios.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItemFuncionarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/tcc/Presentation/icones/funcionario.png"))); // NOI18N
        jMenuItemFuncionarios.setText("Funcionários");
        jMenuItemFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFuncionariosActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemFuncionarios);

        jMenuItemFormasDePagamentos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItemFormasDePagamentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/tcc/Presentation/icones/pagamento.png"))); // NOI18N
        jMenuItemFormasDePagamentos.setText("Formas de Pagamento");
        jMenuItemFormasDePagamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFormasDePagamentosActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemFormasDePagamentos);

        jMenuItemFornecedores.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItemFornecedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/tcc/Presentation/icones/fornecedor.png"))); // NOI18N
        jMenuItemFornecedores.setText("Fornecedores");
        jMenuItemFornecedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFornecedoresActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemFornecedores);

        jMenuItemServicos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItemServicos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/tcc/Presentation/icones/servicos.png"))); // NOI18N
        jMenuItemServicos.setText("Serviços");
        jMenuItemServicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemServicosActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemServicos);

        jMenuItemProdutos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItemProdutos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/tcc/Presentation/icones/produtos.png"))); // NOI18N
        jMenuItemProdutos.setText("Produtos");
        jMenuItemProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemProdutosActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemProdutos);

        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/tcc/Presentation/icones/tiposproduto.png"))); // NOI18N
        jMenuItem1.setText("Tipo de Produto");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItem1);

        jMenuItemUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/tcc/Presentation/icones/user.png"))); // NOI18N
        jMenuItemUsuarios.setText("Usuários");
        jMenuItemUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemUsuariosActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemUsuarios);

        jMenuBar1.add(jMenuCadastros);

        jMenu3.setText("Estoques");
        jMenu3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jMenuItemEstoque.setText("Estoque Atual");
        jMenuItemEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEstoqueActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItemEstoque);

        jMenuItem6.setText("Lançar Compra");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        jMenuBar1.add(jMenu3);

        jMenu5.setText("Relatórios");
        jMenu5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        relatorioAgendamentos.setText("Agendamentos Realizados");
        relatorioAgendamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                relatorioAgendamentosActionPerformed(evt);
            }
        });
        jMenu5.add(relatorioAgendamentos);

        jMenuItem5.setText("Clientes Cadastrados");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem5);

        jMenuItemRelatorioCaixas.setText("Caixas");
        jMenuItemRelatorioCaixas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRelatorioCaixasActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItemRelatorioCaixas);

        jMenuItemCompras.setText("Compras");
        jMenuItemCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemComprasActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItemCompras);

        jMenuItemAniversariantes.setText("Clientes Aniversariantes do Mês");
        jMenuItemAniversariantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAniversariantesActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItemAniversariantes);

        jMenuItemRelatorioVendas.setText("Vendas");
        jMenuItemRelatorioVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRelatorioVendasActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItemRelatorioVendas);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("Sistema");
        jMenu6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jMenuItem3.setText("Sobre");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem3);

        jMenu2.setText("Backup");

        jMenuItemFazerBackup.setText("Fazer backup");
        jMenuItemFazerBackup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFazerBackupActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemFazerBackup);

        jMenuItemRecuperarBackup.setText("Recuperar Backup");
        jMenuItemRecuperarBackup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRecuperarBackupActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemRecuperarBackup);

        jMenu6.add(jMenu2);
        jMenu6.add(jSeparator1);

        jMenuItemSair.setText("Sair");
        jMenuItemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSairActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItemSair);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 877, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(446, 446, 446)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(jLabel2)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemClientesActionPerformed
        frmClienteLista janela = new frmClienteLista(this, rootPaneCheckingEnabled, this);
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
                
                frmCadastroAgendamento janela = new frmCadastroAgendamento(this, rootPaneCheckingEnabled, this, false, true);
                janela.setLocationRelativeTo(null);
                janela.setVisible(rootPaneCheckingEnabled);

                //JOptionPane.showMessageDialog(rootPane, "chama a descricao");
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
        frmCadastroAgendamento janela = new frmCadastroAgendamento(this, rootPaneCheckingEnabled, this, rootPaneCheckingEnabled,false);
        janela.setLocationRelativeTo(null);
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
           // caixa.setDataFechamento(new Date());
//            daoCaixa.Salvar(caixa);  JHDJKASHDJKASHDJK VERIFICAR
            
            CaixaDAO2 dao2 = new CaixaDAO2();
            
            Long id = dao2.Salvar(caixa);
            caixa.setId(id);
            
            /*ADICIOnANDO DEPOSITO*/
            DepositoDAO daoDeposito = new DepositoDAO();
            daoDeposito.Salvar(depositoEntrada);

            btnDeposito.setVisible(true);
            btnRetirada.setVisible(true);
            btnSaldoCaixa.setVisible(true);
            btnSaldoCaixaDetalhado.setVisible(true);
            btnAbrirCaixa.setVisible(false);
            btnFecharCaixa.setVisible(true);
            btnReceberFatura.setVisible(true);

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
        if (novaVenda == null) {
            caixa.setDataFechamento(new Date());
            CaixaDAO2 dao = new CaixaDAO2();
            dao.atualizarHoraFechamentoCaixa(caixa);
            // caixa.setFuncionario(usuarioLogado.getFuncionario());
            // if (daoCaixa.Salvar(caixa)) {
            JOptionPane.showMessageDialog(rootPane, "Caixa Fechado com sucesso!");

            btnDeposito.setVisible(false);
            btnRetirada.setVisible(false);
            btnSaldoCaixa.setVisible(false);
            btnSaldoCaixaDetalhado.setVisible(false);
            btnAbrirCaixa.setVisible(true);
            btnFecharCaixa.setVisible(false);
            btnReceberFatura.setVisible(false);
            caixa = null;
        } else {
            JOptionPane.showMessageDialog(rootPane, "Não foi possivel fechar o caixa porque existe uma venda ativa!");
        }
    }//GEN-LAST:event_btnFecharCaixaActionPerformed

    private void btnIncluirItemVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirItemVendaActionPerformed
        frmInclusaoItemVenda janela = new frmInclusaoItemVenda(this, rootPaneCheckingEnabled, this, false);
        janela.setLocationRelativeTo(null);
        janela.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_btnIncluirItemVendaActionPerformed

    private void btnNovaVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovaVendaActionPerformed

        //Validando venda 
        if (caixa == null) {
            JOptionPane.showMessageDialog(rootPane, "Para realzar a venda o caixa deve ser aberto !");
        } else {

            cbxCliente.setEnabled(true);
            tblVendaServicos.setEnabled(true);
            btnIncluirItemVenda.setEnabled(true);

            btnExcluirItemVenda.setEnabled(true);
            btnReceberValorVenda.setEnabled(true);
            btnCancelarVenda.setEnabled(true);
            lblCliente.setEnabled(true);

            novaVenda = new Venda();
            //preencheTabelaVendas();
            novaVenda.setFuncionario(usuarioLogado.getFuncionario());
            novaVenda.setCaixa(caixa);
            preencheComboClientes();

            btnNovaVenda.setEnabled(false);

            //  VendaDAO a = new VendaDAO();
            //a.Salvar(novaVenda);
        }
    }//GEN-LAST:event_btnNovaVendaActionPerformed

    private void btnCancelarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarVendaActionPerformed
        if (JOptionPane.showConfirmDialog(rootPane, "Você tem certeza que deseja cancelar a compra?", "Pergunta", JOptionPane.OK_CANCEL_OPTION) == 0) {
            desativarVenda();
            btnNovaVenda.setEnabled(true);

        }

    }//GEN-LAST:event_btnCancelarVendaActionPerformed

    private void jMenuItemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSairActionPerformed
        if (caixa != null) {
            JOptionPane.showMessageDialog(rootPane, "O caixa deve ser fechado antes de sair !");
        } else {
            this.dispose();
            frmLogin janela = new frmLogin();
            janela.setLocationRelativeTo(null);
            janela.setVisible(true);
        }

    }//GEN-LAST:event_jMenuItemSairActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        JOptionPane.showMessageDialog(rootPane, "BeatuySystem 1.0 © Todos os direitos reservados ");
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItemUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemUsuariosActionPerformed
        frmUsuarioLista janela = new frmUsuarioLista(this, rootPaneCheckingEnabled);
        janela.setLocationRelativeTo(null);
        janela.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jMenuItemUsuariosActionPerformed

    private void btnReceberValorVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReceberValorVendaActionPerformed
        if(cbxCliente.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(rootPane, "Nenhum Cliente Selecionado !");
        }else if(tblVendaServicos.getRowCount() < 1){
            JOptionPane.showMessageDialog(rootPane, "Nenhum Item na Compra !");
        }else{
            frmReceberPagamentoVenda janela = new frmReceberPagamentoVenda(this, rootPaneCheckingEnabled, this);
            janela.setLocationRelativeTo(null);
            clienteCOmboVenda = (Cliente) cbxCliente.getSelectedItem();
            // JOptionPane.showMessageDialog(rootPane, cbxCliente.getSelectedItem());
            janela.setVisible(rootPaneCheckingEnabled);
        }

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
        frmListarCompras janela = new frmListarCompras(this, rootPaneCheckingEnabled, this, false);
        janela.setLocationRelativeTo(null);
        janela.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void tblVendaServicosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVendaServicosMouseClicked

        /*
         *      PEGANDO O OBJETO SELECIONADO NA TABELA COM 1 CLIQUE
         
         */
        selecionadoTabelaVendaServicos = true;
       idObjetoTabelaVendas = tblVendaServicos.getSelectedRow();
       selecionadoTabelaVendaProdutos = false;
      
    }//GEN-LAST:event_tblVendaServicosMouseClicked

    private void jMenuItemEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEstoqueActionPerformed
       try {
            //Arquivo do Relatorio
            //String relatorio = "/META-INF/relatorio/relatorioEstoque.jasper";
            InputStream relatorio = this.getClass().getClassLoader().getResourceAsStream("META-INF/relatorio/relatorioEstoque.jasper");
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
            JOptionPane.showMessageDialog(this, e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItemEstoqueActionPerformed

                                     
    private void relatorioAgendamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_relatorioAgendamentosActionPerformed
        try {
            //Arquivo do Relatorio
            //String relatorio = "/META-INF/relatorio/relatorioEstoque.jasper";
            InputStream relatorio = this.getClass().getClassLoader().getResourceAsStream("META-INF/relatorio/agendamentosRealizados.jasper");
            //Lista a ser exibida no relatorio
            AgendamentoDAO agendamentoDAO = new AgendamentoDAO();

            Agendamento tmp = new Agendamento();
            tmp.setRealizado(true);
            List<Agendamento> agendamentos = agendamentoDAO.Buscar(tmp);

            //Fonte de dados
            JRBeanCollectionDataSource fonteDados = new JRBeanCollectionDataSource(agendamentos);

            //Gera o Relatorio
            JasperPrint relatorioGerado = JasperFillManager.fillReport(relatorio, null, fonteDados);

            //Exibe o Relatorio
            JasperViewer jasperViewer = new JasperViewer(relatorioGerado, false);
            //this.dispose();
            jasperViewer.setVisible(true);

        } catch (JRException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }//GEN-LAST:event_relatorioAgendamentosActionPerformed

    private void jMenuItemComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemComprasActionPerformed
        frmSelecionaOpcaoRelatorioCompras janela = new frmSelecionaOpcaoRelatorioCompras(this, rootPaneCheckingEnabled);
        janela.setLocationRelativeTo(null);
        janela.setVisible(rootPaneCheckingEnabled);
        
        
        /* try {
            //Arquivo do Relatorio
            //String relatorio = "/META-INF/relatorio/relatorioEstoque.jasper";
            InputStream relatorio = this.getClass().getClassLoader().getResourceAsStream("META-INF/relatorio/Compra.jasper");
            //Lista a ser exibida no relatorio
            CompraDAO compraDao = new CompraDAO();
            List<Compra> compra = compraDao.ListarTodos();

            //Fonte de dados
            JRBeanCollectionDataSource fonteDados = new JRBeanCollectionDataSource(compra);

            //Gera o Relatorio
            JasperPrint relatorioGerado = JasperFillManager.fillReport(relatorio, null, fonteDados);

            //Exibe o Relatorio
            JasperViewer jasperViewer = new JasperViewer(relatorioGerado, false);
            jasperViewer.setVisible(true);
        }catch(JRException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
  */      
    }//GEN-LAST:event_jMenuItemComprasActionPerformed

    private void jMenuItemAniversariantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAniversariantesActionPerformed
       frmAniversariantesLista janela = new frmAniversariantesLista(this, rootPaneCheckingEnabled);
       janela.setLocationRelativeTo(null);
       janela.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jMenuItemAniversariantesActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        try {
            //Arquivo do Relatorio
            //String relatorio = "/META-INF/relatorio/relatorioEstoque.jasper";
            InputStream relatorio = this.getClass().getClassLoader().getResourceAsStream("META-INF/relatorio/relatorioClientes.jasper");
            //Lista a ser exibida no relatorio
            ClienteDAO clienteDao = new ClienteDAO();
            List<Cliente> clientes = clienteDao.ListarTodos();

            //Fonte de dados
            JRBeanCollectionDataSource fonteDados = new JRBeanCollectionDataSource(clientes);

            //Gera o Relatorio
            JasperPrint relatorioGerado = JasperFillManager.fillReport(relatorio, null, fonteDados);

            //Exibe o Relatorio
            JasperViewer jasperViewer = new JasperViewer(relatorioGerado, false);
            jasperViewer.setVisible(true);
        }catch(JRException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void btnAgendamentoRealizadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendamentoRealizadoActionPerformed
        if(objetoAgendamentoSelecionadoNaTabela != null){
            if (JOptionPane.showConfirmDialog(rootPane, "Você Tem certeza que deseja"
                    + " Marcar como realizado o Agendamento?", "Confirmação", JOptionPane.OK_CANCEL_OPTION) == 0) {

                objetoAgendamentoSelecionadoNaTabela.setRealizado(true);
                AgendamentoDAO dao = new AgendamentoDAO();

                dao.Salvar(objetoAgendamentoSelecionadoNaTabela);

                listaAgendamentos.clear();
                listaAgendamentos = dao.Buscar(null);
                preencheTabelaAgendamentos();
                objetoAgendamentoSelecionadoNaTabela = null;
            }
            
            
            
        }
    }//GEN-LAST:event_btnAgendamentoRealizadoActionPerformed

    private void btnAgendamentoEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendamentoEditarActionPerformed
        if(objetoAgendamentoSelecionadoNaTabela != null){
            frmCadastroAgendamento janela = new frmCadastroAgendamento(this, rootPaneCheckingEnabled, this, false, false);
            janela.setLocationRelativeTo(null);
            janela.setVisible(rootPaneCheckingEnabled);
        }
        
        
    }//GEN-LAST:event_btnAgendamentoEditarActionPerformed

    private void btnAgendamentoApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendamentoApagarActionPerformed
        if (objetoAgendamentoSelecionadoNaTabela != null) {
            if (JOptionPane.showConfirmDialog(rootPane, "Você Tem certeza que deseja"
                + " excluir o Agendamento?", "Confirmação", JOptionPane.OK_CANCEL_OPTION) == 0) {
                AgendamentoDAO dao = new AgendamentoDAO();
                objetoAgendamentoSelecionadoNaTabela.setRealizado(false);
                objetoAgendamentoSelecionadoNaTabela.setAtivo(false);
                dao.Apagar(objetoAgendamentoSelecionadoNaTabela);
                listaAgendamentos.clear();
                listaAgendamentos = dao.Buscar(null);
                //preencheTabelaAgendamentos();
                objetoAgendamentoSelecionadoNaTabela = null;
                preencheTabelaAgendamentos();

            }

        }
    }//GEN-LAST:event_btnAgendamentoApagarActionPerformed

    private void jMenuItemRelatorioVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRelatorioVendasActionPerformed
        frmSelecionarOpcaoRelatorioVendas janela = new frmSelecionarOpcaoRelatorioVendas(this, rootPaneCheckingEnabled,this);
        janela.setLocationRelativeTo(this);
        janela.setVisible(rootPaneCheckingEnabled);
        
    }//GEN-LAST:event_jMenuItemRelatorioVendasActionPerformed

    private void btnExcluirItemVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirItemVendaActionPerformed
        if(selecionadoTabelaVendaProdutos){
            novaVenda.getProdutos().remove(idObjetoTabelaVendas);
            idObjetoTabelaVendas = 0;
            preencheTabelaVendasProduto();
           tblVendaProdutos.clearSelection();
        }else if(selecionadoTabelaVendaServicos){
            novaVenda.getServicos().remove(idObjetoTabelaVendas);
            preencheTabelaVendasServicos();
            tblVendaServicos.clearSelection();
        }
        
        
        /*    
        if(idObjetoTabelaVendas >= novaVenda.getServicos().size()){
            //ObjServicoTabelaVendas = novaVenda.getServicos().get(idObjetoTabelaVendas);
            novaVenda.getServicos().remove(idObjetoTabelaVendas);
    //        JOptionPane.showMessageDialog(rootPane, ObjServicoTabelaVendas.getServico().getNome());
           // preencheTabelaVendas();
        }else{
            novaVenda.getProdutos().remove(idObjetoTabelaVendas);
            //preencheTabelaVendas();
        }
  */
        //preencheTabelaVendasProduto();
       
        tblVendaServicos.clearSelection();
    }//GEN-LAST:event_btnExcluirItemVendaActionPerformed

    private void jMenuItemFazerBackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFazerBackupActionPerformed
  
        JFileChooser pasta = new JFileChooser();
        pasta.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        pasta.showOpenDialog(this);
        String caminhoBackup = pasta.getSelectedFile().getPath();

        //CONFIGURANDO A DATA
        Date data = new Date();
        int dia = data.getDate();
        int mes = data.getMonth() + 1;
        int ano = data.getYear() + 1900;

        File diretorio = new File(caminhoBackup);
        File bck = new File(caminhoBackup + "/Backup_" + dia + "-" + mes + "-" + ano + ".sql");
// os zeros é para diferenciar um backup do outro  

        // Cria diretório  
        if (!diretorio.isDirectory()) {
            new File(caminhoBackup).mkdir();
        } else {

        }

        // Cria Arquivo de Backup  
        try {
            if (!bck.isFile()) {
                Runtime.getRuntime().exec("cmd /c mysqldump -u root  beautysystem > " + bck.getAbsoluteFile());
            } else {

                while (bck.isFile()) {

                    bck = new File(caminhoBackup + "/Backup " + dia + "-" + mes + "-" + ano + ".sql");
                }

                Runtime.getRuntime().exec("cmd /c mysqldump -u root  beautysystem > " + bck.getAbsoluteFile());
                JOptionPane.showMessageDialog(rootPane, "Backup realizado com sucesso!");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "Falha ao criar Backup. \\n Verifique as configurações ou entre em contato com o suporte !");
        }


    }//GEN-LAST:event_jMenuItemFazerBackupActionPerformed

    private void jMenuItemRecuperarBackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRecuperarBackupActionPerformed
        JFileChooser pasta = new JFileChooser();
        pasta.setFileSelectionMode(JFileChooser.FILES_ONLY);
        pasta.showOpenDialog(this);
        String caminhoBackup = pasta.getSelectedFile().getPath();
        // JOptionPane.showMessageDialog(rootPane, caminhoBackup);

        File diretorio = new File(caminhoBackup);
        File bck = new File(caminhoBackup);
// os zeros é para diferenciar um backup do outro  

            // Cria diretório  
        //  if(!diretorio.isDirectory()) {  
        //     new File(caminhoBackup).mkdir();  
        // } else {  
        // }  
        // Cria Arquivo de Backup 
        ConexaoBanco conexao = new ConexaoBanco();
        try {
            java.sql.Statement stm = conexao.getConexao().createStatement();
            stm.execute("drop database beautysystem");

            //java.sql.Statement stm = conexao.getConexao().createStatement(); 
            stm.execute("create database beautysystem");

        } catch (SQLException ex) {
            Logger.getLogger(frmMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            if (!bck.isFile()) {
                Runtime.getRuntime().exec("cmd /c mysqldump -u root  beautysystem < " + bck.getAbsoluteFile());
            } else {

                  //  while(bck.isFile()) {  
                //Runtime.getRuntime().exec("cmd /c mysqldump -u root  beautysystem < "+bck.getAbsoluteFile());  
                //    bck = new File(caminhoBackup+"/Backup "+dia+"_"+mes+"_"+ano+".sql");  
                //    }  
                Runtime.getRuntime().exec("cmd /c mysql -u root  beautysystem < " + bck.getAbsoluteFile());
                JOptionPane.showMessageDialog(rootPane, "Restauração Efetuada com sucesso!");
                System.out.print(bck.getAbsoluteFile());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.print("erro");
        }
 
    }//GEN-LAST:event_jMenuItemRecuperarBackupActionPerformed

    private void btnReceberFaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReceberFaturaActionPerformed
        VendaDAO dao = new VendaDAO();
        frmPagamentoFaturaCliente janela = new frmPagamentoFaturaCliente(this, rootPaneCheckingEnabled, dao.ListarVendasAPrazo(), this);
        janela.setLocationRelativeTo(this);
        janela.setVisible(true);
    }//GEN-LAST:event_btnReceberFaturaActionPerformed

    private void btnReceberFaturaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReceberFaturaMouseEntered
        Color minhaCor = new Color(115, 183, 253);
        this.btnReceberFatura.setBackground(minhaCor);
    }//GEN-LAST:event_btnReceberFaturaMouseEntered

    private void btnReceberFaturaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReceberFaturaMouseExited
        Color minhaCor = new Color(239, 239, 239);
        this.btnReceberFatura.setBackground(minhaCor);
    }//GEN-LAST:event_btnReceberFaturaMouseExited

    private void btnNovoAgendamentoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNovoAgendamentoMouseEntered
        Color minhaCor = new Color(115,183,253);
        this.btnNovoAgendamento.setBackground(minhaCor);
    }//GEN-LAST:event_btnNovoAgendamentoMouseEntered

    private void btnNovoAgendamentoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNovoAgendamentoMouseExited
         Color minhaCor = new Color(239,239,239);
        this.btnNovoAgendamento.setBackground(minhaCor);
    }//GEN-LAST:event_btnNovoAgendamentoMouseExited

    private void btnAgendamentoRealizadoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgendamentoRealizadoMouseEntered
        Color minhaCor = new Color(115,183,253);
        this.btnAgendamentoRealizado.setBackground(minhaCor);
    }//GEN-LAST:event_btnAgendamentoRealizadoMouseEntered

    private void btnAgendamentoRealizadoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgendamentoRealizadoMouseExited
        Color minhaCor = new Color(239,239,239);
        this.btnAgendamentoRealizado.setBackground(minhaCor);
    }//GEN-LAST:event_btnAgendamentoRealizadoMouseExited

    private void btnAgendamentoEditarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgendamentoEditarMouseEntered
       Color minhaCor = new Color(115,183,253);
        this.btnAgendamentoEditar.setBackground(minhaCor);
    }//GEN-LAST:event_btnAgendamentoEditarMouseEntered

    private void btnAgendamentoEditarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgendamentoEditarMouseExited
          Color minhaCor = new Color(239,239,239);
        this.btnAgendamentoEditar.setBackground(minhaCor);
    }//GEN-LAST:event_btnAgendamentoEditarMouseExited

    private void btnAgendamentoApagarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgendamentoApagarMouseEntered
         Color minhaCor = new Color(115,183,253);
        this.btnAgendamentoApagar.setBackground(minhaCor);
    }//GEN-LAST:event_btnAgendamentoApagarMouseEntered

    private void btnAgendamentoApagarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgendamentoApagarMouseExited
          Color minhaCor = new Color(239,239,239);
        this.btnAgendamentoApagar.setBackground(minhaCor);
    }//GEN-LAST:event_btnAgendamentoApagarMouseExited

    private void jMenuItemRelatorioCaixasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRelatorioCaixasActionPerformed
        frmSelecionaOpcaoRelatorioCaixa janela = new frmSelecionaOpcaoRelatorioCaixa(this, rootPaneCheckingEnabled);
        janela.setLocationRelativeTo(this);
        janela.setVisible(true);
    }//GEN-LAST:event_jMenuItemRelatorioCaixasActionPerformed

    private void btnNovaVendaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNovaVendaMouseEntered
        Color minhaCor = new Color(115,183,253);
        this.btnNovaVenda.setBackground(minhaCor);
    }//GEN-LAST:event_btnNovaVendaMouseEntered

    private void btnNovaVendaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNovaVendaMouseExited
          Color minhaCor = new Color(239,239,239);
        this.btnNovaVenda.setBackground(minhaCor);
    }//GEN-LAST:event_btnNovaVendaMouseExited

    private void btnReceberValorVendaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReceberValorVendaMouseEntered
       Color minhaCor = new Color(115,183,253);
        this.btnReceberValorVenda.setBackground(minhaCor);
    }//GEN-LAST:event_btnReceberValorVendaMouseEntered

    private void btnReceberValorVendaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReceberValorVendaMouseExited
           Color minhaCor = new Color(239,239,239);
        this.btnReceberValorVenda.setBackground(minhaCor);
    }//GEN-LAST:event_btnReceberValorVendaMouseExited

    private void btnCancelarVendaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarVendaMouseEntered
        Color minhaCor = new Color(115,183,253);
        this.btnCancelarVenda.setBackground(minhaCor);
    }//GEN-LAST:event_btnCancelarVendaMouseEntered

    private void btnCancelarVendaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarVendaMouseExited
          Color minhaCor = new Color(239,239,239);
        this.btnCancelarVenda.setBackground(minhaCor);
    }//GEN-LAST:event_btnCancelarVendaMouseExited

    private void btnIncluirItemVendaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIncluirItemVendaMouseEntered
       Color minhaCor = new Color(115,183,253);
        this.btnIncluirItemVenda.setBackground(minhaCor);
    }//GEN-LAST:event_btnIncluirItemVendaMouseEntered

    private void btnExcluirItemVendaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExcluirItemVendaMouseEntered
        Color minhaCor = new Color(115,183,253);
        this.btnExcluirItemVenda.setBackground(minhaCor);
    }//GEN-LAST:event_btnExcluirItemVendaMouseEntered

    private void btnIncluirItemVendaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIncluirItemVendaMouseExited
          Color minhaCor = new Color(239,239,239);
        this.btnIncluirItemVenda.setBackground(minhaCor);
    }//GEN-LAST:event_btnIncluirItemVendaMouseExited

    private void btnExcluirItemVendaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExcluirItemVendaMouseExited
           Color minhaCor = new Color(239,239,239);
        this.btnExcluirItemVenda.setBackground(minhaCor);
    }//GEN-LAST:event_btnExcluirItemVendaMouseExited

    private void tblVendaProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVendaProdutosMouseClicked
        selecionadoTabelaVendaProdutos =  true;
        idObjetoTabelaVendas = tblVendaProdutos.getSelectedRow();
        
        selecionadoTabelaVendaServicos = false;
    }//GEN-LAST:event_tblVendaProdutosMouseClicked

    /*
     *  OUTRAS VARIÁVEIS
     */
    private boolean selecionadoTabelaVendaProdutos;
    private boolean selecionadoTabelaVendaServicos;
    private int idObjetoTabelaVendas;
    private ItemVendaServico ObjServicoTabelaVendas;
    private ItemVendaProduto ObjProdutoTabelaVendas;
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
    protected CaixaDAO daoCaixa;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrirCaixa;
    private javax.swing.JButton btnAgendamentoApagar;
    private javax.swing.JButton btnAgendamentoEditar;
    private javax.swing.JButton btnAgendamentoRealizado;
    private javax.swing.JButton btnCancelarVenda;
    private javax.swing.JButton btnDeposito;
    private javax.swing.JButton btnExcluirItemVenda;
    private javax.swing.JButton btnFecharCaixa;
    private javax.swing.JButton btnIncluirItemVenda;
    private javax.swing.JButton btnNovaVenda;
    private javax.swing.JButton btnNovoAgendamento;
    private javax.swing.JButton btnReceberFatura;
    private javax.swing.JButton btnReceberValorVenda;
    private javax.swing.JButton btnRetirada;
    private javax.swing.JButton btnSaldoCaixa;
    private javax.swing.JButton btnSaldoCaixaDetalhado;
    private javax.swing.JComboBox cbxCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuCadastros;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItemAniversariantes;
    private javax.swing.JMenuItem jMenuItemClientes;
    private javax.swing.JMenuItem jMenuItemCompras;
    private javax.swing.JMenuItem jMenuItemEstoque;
    private javax.swing.JMenuItem jMenuItemFazerBackup;
    private javax.swing.JMenuItem jMenuItemFormasDePagamentos;
    private javax.swing.JMenuItem jMenuItemFornecedores;
    private javax.swing.JMenuItem jMenuItemFuncionarios;
    private javax.swing.JMenuItem jMenuItemProdutos;
    private javax.swing.JMenuItem jMenuItemRecuperarBackup;
    private javax.swing.JMenuItem jMenuItemRelatorioCaixas;
    private javax.swing.JMenuItem jMenuItemRelatorioVendas;
    private javax.swing.JMenuItem jMenuItemSair;
    private javax.swing.JMenuItem jMenuItemServicos;
    private javax.swing.JMenuItem jMenuItemUsuarios;
    private javax.swing.JPanel jPanelAgenda;
    private javax.swing.JPanel jPanelCaixa;
    private javax.swing.JPanel jPanelVendas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPanelPrincipal;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JMenuItem relatorioAgendamentos;
    private javax.swing.JTable tblAgenda;
    private javax.swing.JTable tblVendaProdutos;
    private javax.swing.JTable tblVendaServicos;
    // End of variables declaration//GEN-END:variables
}
