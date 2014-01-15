/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.Presentation;

import br.com.tcc.DataAccess.ClienteDAO;
import br.com.tcc.DataAccess.FuncionarioDAO;
import br.com.tcc.DomainModel.Agendamento;
import br.com.tcc.DomainModel.Cliente;
import br.com.tcc.DomainModel.Funcionario;
import br.com.tcc.DomainModel.Servico;
import java.awt.Color;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author thaisa
 */
public class frmCadastroAgendamento extends javax.swing.JDialog {

    /**
     * Creates new form frmCadastroServicosCadastroEdicao
     * 
     * 
     * NO CONSTRUTOR SE FOR TRUE É CADASTRO DE NOVO SERVICO SE FALSE É EDICAO
     * 
     */
    private frmMenuPrincipal janelaPai;
    private boolean descricao;
    public frmCadastroAgendamento(java.awt.Frame parent, boolean modal, frmMenuPrincipal janelaPai, boolean cadastro,boolean descricao) {
       super(parent, modal);
        
        initComponents();
        Color minhaCor = new Color(239,239,239);
        this.getContentPane().setBackground(minhaCor);
        
       
        this.janelaPai = janelaPai;
        this.descricao = descricao;
        
        Date dataTmp = new Date();
        listaClientes = new LinkedList<>();
        daoClientes = new ClienteDAO();
       
        listaServicos = new LinkedList<>();
       
         cbxCliente.removeAllItems();
         cbxTipoProduto.removeAllItems();
         cbxHora.removeAllItems();
         cbxMinuto.removeAllItems();
         cbxDia.removeAllItems();
         cbxMes.removeAllItems();
         cbxAno.removeAllItems();
         /*
          * 
          * VALOR PADRAO DOS COMBOBOX
          * 
          */
         Cliente tmpCliente = new Cliente();
         tmpCliente.setNome("Selecione");
         
         
         
       
        cbxCliente.addItem(tmpCliente);
                 
                 
                 
         listaClientes = daoClientes.ListarTodos();
      
         
         /*
          * 
          * PREENCHE COMBOBOX DE FORNECEDORES
          
          */
         
         FuncionarioDAO asdas = new FuncionarioDAO();
         for(Cliente f : daoClientes.ListarTodos()){
             cbxCliente.addItem(f);
         }
         
    //     cbxCliente.setSelectedIndex(1);//remover
         /*
          * 
          * PREENCHE COMBOBOX DE HORA
          
          */
         cbxHora.addItem("Hora");
         for(int i=7;i<=22;i++){
             String tmp = "";
             if(i<=9){
                tmp = "0"+i;
             }else{
                 tmp = String.valueOf(i);
             }
             cbxHora.addItem(tmp);
         }
         
         /*
          * 
          * PREENCHE COMBOBOX DO MINUTO
          
          */
         
         cbxMinuto.addItem("Minutos");
         for(int i= 0 ;i<60; i = i+10){
             String tmp;
             if(i == 0){
                 tmp = "0"+i;
                
             }else{
                tmp = String.valueOf(i);
             }
            cbxMinuto.addItem(tmp);
           
         }
         
         /*
          * 
          * PREENCHE COMBOBOX DO DIA
          
          */
         cbxDia.addItem("Dia");
         for(int i=1;i<32;i++){
             String tmp;
             if(i<=9){
                tmp = "0"+i;
             }else{
                 tmp = String.valueOf(i);
             }
             cbxDia.addItem(tmp);
         }
         
         
         /*
          * 
          * PREENCHE COMBOBOX DO MES
          
          */
         
         cbxMes.addItem("Mês");
         for(int i=1;i<13;i++){
             String tmp;
             if(i<=9){
                tmp = "0"+i;
             }else{
                 tmp = String.valueOf(i);
             }
             cbxMes.addItem(tmp);
         }
         
         
         /*
          * 
          * PREENCHE COMBOBOX DO ANO
          
          */
         
         cbxAno.addItem("Ano");
         int data = dataTmp.getYear() + 1900;
         for(int i=data;i<=data+1;i++){
             String tmp = String.valueOf(i);
             
             cbxAno.addItem(tmp);
         }
        
         
         //for(int h :)
         
         cbxDia.setSelectedIndex(dataTmp.getDate());
         cbxMes.setSelectedIndex(dataTmp.getMonth()+1);
         cbxAno.setSelectedIndex(1);
         
         
         
         
         
        if(cadastro ==  true){
            this.setTitle("CADASTRO DE AGENDAMENTO");
           // System.out.println("verdade");
        }else{
            
            if(descricao){
                this.setTitle("DESCRIÇÃO DE AGENDAMENTO");
                cbxAno.setEnabled(false);
                cbxCliente.setEnabled(false);
                cbxDia.setEnabled(false);
                cbxHora.setEnabled(false);
                cbxMes.setEnabled(false);
                cbxMinuto.setEnabled(false);
                txtDescricao.setEditable(false);
                txtNome.setEditable(false);
                btnAdicionar.setVisible(false);
                btnRemover.setVisible(false);
                btnSalvar.setVisible(false);
                
                
                //txtPrecoCusto.set
            }else{
                this.setTitle("EDIÇÃO DE AGENDAMENTO");
            }
            
            //System.out.println("false");
            /*setando valores recebidos da janela pai aos campos*/
            
            cbxDia.setSelectedIndex((janelaPai.objetoAgendamentoSelecionadoNaTabela.getDataHora().getDate()) );
            cbxMes.setSelectedIndex(((janelaPai.objetoAgendamentoSelecionadoNaTabela.getDataHora().getMonth()) + 1));
            cbxAno.setSelectedItem((janelaPai.objetoAgendamentoSelecionadoNaTabela.getDataHora().getYear()) );
            
            cbxCliente.setSelectedItem(janelaPai.objetoAgendamentoSelecionadoNaTabela.getCliente());
            cbxHora.setSelectedItem("0"+String.valueOf(janelaPai.objetoAgendamentoSelecionadoNaTabela.getDataHora().getHours()));
            cbxMinuto.setSelectedItem(String.valueOf(janelaPai.objetoAgendamentoSelecionadoNaTabela.getDataHora().getMinutes()));
            
            listaServicos = janelaPai.objetoAgendamentoSelecionadoNaTabela.getServicos();
              txtDescricao.setText(janelaPai.objetoAgendamentoSelecionadoNaTabela.getObservacao());
            preencheTabela();
          
         
        }
    }
    
    
    
    protected void preencheTabela(){
        
        /*
         
         * DEFININDO "TABLE MODEL" COM LINHAS NÃO EDITAVEIS
         * 
         * http://www.guj.com.br/java/44193-jtable-nao-editavel
         
         */
        
        
        DefaultTableModel model = new DefaultTableModel(){
            @Override  
          public boolean isCellEditable(int row, int col){   
                 return false;   
          }   
        };
        
        model.addColumn("ID");
        model.addColumn("NOME");
        model.addColumn("VALOR (R$)");
        model.addColumn("DURAÇÃO MÁXIMA (Minutos)");
        model.addColumn("DESCONTO MÁXIMO ");
       
        
          for(Servico s : listaServicos){
            Vector v = new Vector();
            v.add(0,s.getId());
            v.add(1,s.getNome());
            v.add(2,s.getValor());
            v.add(3,s.getDuracaoAproximada());
            v.add(4,s.getDescontoMaximo() + "%");
                   
            model.addRow(v);
        
        }
        
        tblServicos.setModel(model);
        tblServicos.repaint();
        

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelNovoServico = new javax.swing.JPanel();
        lblServicos = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        lblQuantidade = new javax.swing.JLabel();
        lblDescricao = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtPrecoCusto = new javax.swing.JTextField();
        txtQuantidade = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbxTipoProduto = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblServicos = new javax.swing.JTable();
        btnAdicionar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        cbxHora = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        cbxMinuto = new javax.swing.JComboBox();
        cbxDia = new javax.swing.JComboBox();
        cbxMes = new javax.swing.JComboBox();
        cbxAno = new javax.swing.JComboBox();
        lblObservacao = new javax.swing.JLabel();
        txtObservacao = new javax.swing.JTextField();
        cbxCliente = new javax.swing.JComboBox();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        painelNovoServico.setBackground(new java.awt.Color(228, 228, 228));
        painelNovoServico.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Novo Agendamento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        lblServicos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblServicos.setText("Serviços* :");

        lblHora.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblHora.setText("Hora *:");

        lblData.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblData.setText("Data *:");

        lblQuantidade.setText("Quantidade* :");

        lblDescricao.setText("Descrição* :");

        txtPrecoCusto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecoCustoActionPerformed(evt);
            }
        });

        txtDescricao.setColumns(20);
        txtDescricao.setRows(5);
        jScrollPane1.setViewportView(txtDescricao);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Cliente* :");

        jLabel2.setText("Tipo de Produto* :");

        cbxTipoProduto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        tblServicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblServicos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblServicosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblServicos);

        btnAdicionar.setBackground(new java.awt.Color(239, 239, 239));
        btnAdicionar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/tcc/Presentation/icones/Novo.png"))); // NOI18N
        btnAdicionar.setText("Adicionar");
        btnAdicionar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAdicionarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAdicionarMouseExited(evt);
            }
        });
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnRemover.setBackground(new java.awt.Color(239, 239, 239));
        btnRemover.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/tcc/Presentation/icones/excluir.png"))); // NOI18N
        btnRemover.setText("Remover");
        btnRemover.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRemoverMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRemoverMouseExited(evt);
            }
        });
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        cbxHora.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxHora.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText(":");

        cbxMinuto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxMinuto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxDia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxDia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxMes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxMes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxAno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxAno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblObservacao.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblObservacao.setText("Observação:");

        cbxCliente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxCliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout painelNovoServicoLayout = new javax.swing.GroupLayout(painelNovoServico);
        painelNovoServico.setLayout(painelNovoServicoLayout);
        painelNovoServicoLayout.setHorizontalGroup(
            painelNovoServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelNovoServicoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelNovoServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelNovoServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(painelNovoServicoLayout.createSequentialGroup()
                            .addGroup(painelNovoServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1)
                                .addComponent(lblHora))
                            .addGap(18, 18, 18)
                            .addGroup(painelNovoServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(painelNovoServicoLayout.createSequentialGroup()
                                    .addComponent(cbxHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbxMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(painelNovoServicoLayout.createSequentialGroup()
                                    .addComponent(cbxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(54, 54, 54)
                                    .addComponent(lblData)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cbxDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(10, 10, 10)
                                    .addComponent(cbxMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbxAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(painelNovoServicoLayout.createSequentialGroup()
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(painelNovoServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnRemover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addContainerGap())
                        .addComponent(txtQuantidade, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelNovoServicoLayout.createSequentialGroup()
                            .addGroup(painelNovoServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(painelNovoServicoLayout.createSequentialGroup()
                                    .addComponent(lblObservacao)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtObservacao, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(painelNovoServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(painelNovoServicoLayout.createSequentialGroup()
                                        .addComponent(lblDescricao)
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 679, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(painelNovoServicoLayout.createSequentialGroup()
                                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(38, 38, 38)
                                        .addComponent(jLabel2))
                                    .addGroup(painelNovoServicoLayout.createSequentialGroup()
                                        .addComponent(txtPrecoCusto, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(210, 210, 210)
                                        .addComponent(lblQuantidade))))
                            .addGap(458, 458, 458)
                            .addComponent(cbxTipoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(painelNovoServicoLayout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(jLabel3))
                    .addComponent(lblServicos)))
        );
        painelNovoServicoLayout.setVerticalGroup(
            painelNovoServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelNovoServicoLayout.createSequentialGroup()
                .addGroup(painelNovoServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelNovoServicoLayout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jLabel3)
                        .addGroup(painelNovoServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelNovoServicoLayout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(lblServicos))
                            .addGroup(painelNovoServicoLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(painelNovoServicoLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(painelNovoServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cbxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblData)
                            .addComponent(cbxDia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxMes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxAno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelNovoServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxHora, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblHora))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(painelNovoServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtObservacao, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblObservacao))
                .addGap(215, 215, 215)
                .addGroup(painelNovoServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPrecoCusto, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painelNovoServicoLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(lblQuantidade))
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(painelNovoServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painelNovoServicoLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2))
                    .addGroup(painelNovoServicoLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(cbxTipoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelNovoServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelNovoServicoLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelNovoServicoLayout.createSequentialGroup()
                        .addComponent(lblDescricao)
                        .addGap(70, 70, 70))))
        );

        btnSalvar.setBackground(new java.awt.Color(239, 239, 239));
        btnSalvar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/tcc/Presentation/icones/salvar.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSalvarMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSalvarMouseEntered(evt);
            }
        });
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(239, 239, 239));
        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/tcc/Presentation/icones/Fechar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancelarMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelarMouseEntered(evt);
            }
        });
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(painelNovoServico, javax.swing.GroupLayout.PREFERRED_SIZE, 856, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(280, 280, 280))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(painelNovoServico, javax.swing.GroupLayout.PREFERRED_SIZE, 389, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPrecoCustoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecoCustoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecoCustoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
      

        if(cbxAno.getSelectedIndex() == 0  || cbxDia.getSelectedIndex() == 0 || cbxCliente.getSelectedIndex() ==0 ||
                cbxHora.getSelectedIndex() == 0 || cbxMes.getSelectedIndex() == 0 || cbxMinuto.getSelectedIndex() == 0 || listaServicos.size() == 0){
            JOptionPane.showMessageDialog(rootPane, "Todos Os campos devem ser preenchidos!");
        
        }else {

            if (JOptionPane.showConfirmDialog(rootPane, "Você tem certeza que deseja salvar o Agendamento?", "Confirmação", JOptionPane.OK_CANCEL_OPTION) == 0) {


                Agendamento agendamento = new Agendamento();
                agendamento.setCliente((Cliente) cbxCliente.getSelectedItem());
                agendamento.setObservacao(txtObservacao.getText());
                agendamento.setServicos(listaServicos);

                Date dataTmp = new Date();

                dataTmp.setDate(Integer.parseInt((String) cbxDia.getSelectedItem()));
                dataTmp.setHours(Integer.parseInt((String) cbxHora.getSelectedItem()));
                dataTmp.setMinutes(Integer.parseInt((String) cbxMinuto.getSelectedItem()));

                //JOptionPane.showMessageDialog(rootPane, cbxMes.getSelectedItem().toString());
                int mes = Integer.parseInt(cbxMes.getSelectedItem().toString());
                mes--;
                dataTmp.setMonth(mes);
                dataTmp.setYear(Integer.parseInt((String) cbxAno.getSelectedItem()));

                agendamento.setDataHora(dataTmp);
                agendamento.setFuncionario(janelaPai.usuarioLogado.getFuncionario());
                //  agendamento.setRealizado(false);
                if (janelaPai.daoAgendamento.Salvar(agendamento)) {
                    JOptionPane.showMessageDialog(rootPane, "Agendamento cadastrado com sucesso !");
                    //janelaPai.listaAgendamentos = janelaPai.daoAgendamento.Buscar(agendamento);
                    janelaPai.listaAgendamentos.add(agendamento);
                    janelaPai.preencheTabelaAgendamentos();
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Erro ao cadastrar agendamento !");
                }
            }

        }
        
        
        
        //JOptionPane.showMessageDialog(rootPane, "mes "+mes);
        //JOptionPane.showMessageDialog(rootPane, "ano "+ano);
/*               
        /*Botão salvar
        
        if(txtQuantidade.getText().isEmpty() || txtDescricao.getText().isEmpty() 
              ||  txtNome.getText().isEmpty() || 
                txtPrecoCusto.getText().isEmpty() || (cbxTipoProduto.getSelectedIndex() == 0) || (cbxCliente.getSelectedIndex() == 0) ){
           JOptionPane.showMessageDialog(rootPane, "Todos os Campos devem ser Preenchidos !");
       }else if (JOptionPane.showConfirmDialog(rootPane, "Você tem certeza que deseja salvar o Produto ",
               "Confirmação",JOptionPane.OK_CANCEL_OPTION) == 0){
           
            Produto produto = new Produto();
            janelaPai.dao = new ProdutoDAO();

            /*CAPTURANDO ENTRADA DE DADOS DO JDIALOG E VALIDANDO*/
            
        /*
            int ok =0; //variavel de validação
            
            produto.setDescricao(txtDescricao.getText());
            
            try{
                produto.setQtdEstoque(Integer.parseInt(txtQuantidade.getText()));
                ok++;
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(rootPane, "Quantidade Inválida !");
            }
            
            
          
            
            try{
                produto.setPrecoCusto(Float.parseFloat(txtPrecoCusto.getText()));
                ok++;
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(rootPane, "Preço de Custo Inválido !");
            }
            
            produto.setNome(txtNome.getText());
            
            /*
             
             * falta pegar  vendedor e o tipo de produto
             
             
        
            Fornecedor fornecedor;
            fornecedor = (Fornecedor) cbxCliente.getSelectedItem();
            
            TipoProduto tipoProduto;
            tipoProduto = (TipoProduto) cbxTipoProduto.getSelectedItem();
            
            produto.setFornecedor(fornecedor);
            produto.setTipoProduto(tipoProduto);
            
            if(ok == 3){//se a validacao está correta

                if(janelaPai.dao.Salvar(produto)){
                    JOptionPane.showMessageDialog(rootPane, "Serviço Salvo com Sucesso !");
                    txtQuantidade.setText(""); txtDescricao.setText("");
                  txtNome.setText(""); txtPrecoCusto.setText("");
                    janelaPai.lista.clear();
                    janelaPai.lista = janelaPai.dao.ListarTodos();
                    janelaPai.preencheTabela();
                    this.dispose();

                }else{
                    JOptionPane.showMessageDialog(rootPane, "Erro ao salvar o serviço !");
                }
            }
       
       }
       */
  
        
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if (JOptionPane.showConfirmDialog(rootPane, "Você tem certeza que deseja cancelar o agendamento?", "Confirmação", JOptionPane.OK_CANCEL_OPTION) == 0) {
            this.dispose();
        }


    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        frmListaServicosParaAgenda janela = new frmListaServicosParaAgenda(null, rootPaneCheckingEnabled, this);
        janela.setLocationRelativeTo(null);
        janela.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        if(objSelecionadoNaTabela != null){
            listaServicos.remove(objSelecionadoNaTabela);
            objSelecionadoNaTabela = null;
            preencheTabela();
        }else{
            JOptionPane.showMessageDialog(rootPane, "Nenhum servico Selecionado!");
        }
        
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void tblServicosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblServicosMouseClicked
       /*
         * PEGANDO O OBJETO SELECIONADO NA TABELA COM 1 CLIQUE
         
         */
      //  tblServicos.isCellEditable(tblServicos.getSelectedRow(), tblServicos.getSelectedColumn());
        
        
        if(idSelecionadoTabela == tblServicos.getSelectedRow()){ //se está clicando na mesma linha
            qtdCliques++;
            if(qtdCliques == 2){
               // JOptionPane.showMessageDialog(rootPane, "chama a descricao");
                qtdCliques =0;
            }
        }else {
            qtdCliques= 1;
        }
        
        idSelecionadoTabela = tblServicos.getSelectedRow();
        objSelecionadoNaTabela = listaServicos.get(idSelecionadoTabela);
        
    }//GEN-LAST:event_tblServicosMouseClicked

    private void btnSalvarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarMouseExited
    Color minhaCor = new Color(239,239,239);
    this.btnSalvar.setBackground(minhaCor);
    }//GEN-LAST:event_btnSalvarMouseExited

    private void btnSalvarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarMouseEntered
        Color minhaCor = new Color(115,183,253);
        this.btnSalvar.setBackground(minhaCor);
    }//GEN-LAST:event_btnSalvarMouseEntered

    private void btnCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseEntered
       Color minhaCor = new Color(115,183,253);
        this.btnCancelar.setBackground(minhaCor);
    }//GEN-LAST:event_btnCancelarMouseEntered

    private void btnCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseExited
        Color minhaCor = new Color(239,239,239);
        this.btnCancelar.setBackground(minhaCor);
    }//GEN-LAST:event_btnCancelarMouseExited

    private void btnAdicionarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdicionarMouseEntered
         Color minhaCor = new Color(115,183,253);
        this.btnAdicionar.setBackground(minhaCor);
    }//GEN-LAST:event_btnAdicionarMouseEntered

    private void btnRemoverMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoverMouseEntered
         Color minhaCor = new Color(115,183,253);
        this.btnRemover.setBackground(minhaCor);
    }//GEN-LAST:event_btnRemoverMouseEntered

    private void btnAdicionarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdicionarMouseExited
          Color minhaCor = new Color(239,239,239);
            this.btnAdicionar.setBackground(minhaCor);
    }//GEN-LAST:event_btnAdicionarMouseExited

    private void btnRemoverMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoverMouseExited
         Color minhaCor = new Color(239,239,239);
         this.btnRemover.setBackground(minhaCor);
    }//GEN-LAST:event_btnRemoverMouseExited

    /*
     *  OUTRAS VARIAVEIS
     
     */
    
    private List<Cliente> listaClientes;
    private ClienteDAO daoClientes;
    protected List<Servico> listaServicos;
    private int idSelecionadoTabela;
    private Servico objSelecionadoNaTabela;
    private int qtdCliques;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox cbxAno;
    private javax.swing.JComboBox cbxCliente;
    private javax.swing.JComboBox cbxDia;
    private javax.swing.JComboBox cbxHora;
    private javax.swing.JComboBox cbxMes;
    private javax.swing.JComboBox cbxMinuto;
    private javax.swing.JComboBox cbxTipoProduto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblObservacao;
    private javax.swing.JLabel lblQuantidade;
    private javax.swing.JLabel lblServicos;
    private javax.swing.JPanel painelNovoServico;
    private javax.swing.JTable tblServicos;
    private javax.swing.JTextArea txtDescricao;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtObservacao;
    private javax.swing.JTextField txtPrecoCusto;
    private javax.swing.JTextField txtQuantidade;
    // End of variables declaration//GEN-END:variables
}
