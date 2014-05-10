/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.Presentation;

import br.com.tcc.DataAccess.CidadeDAO;
import br.com.tcc.DataAccess.FornecedorDAO;
import br.com.tcc.DomainModel.Cidade;
import br.com.tcc.DomainModel.Estado;
import br.com.tcc.DomainModel.Fornecedor;
import br.com.tcc.utilitarios.FixedLengthDocument;
import java.awt.Color;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author thaisa
 */
public class frmCadastroFornecedor extends javax.swing.JDialog {

    /**
     * Creates new form frmCadastroServicosCadastroEdicao
     * 
     * 
     * NO CONSTRUTOR SE FOR TRUE É CADASTRO DE NOVO SERVICO SE FALSE É EDICAO
     * 
     */
    private frmFornecedorLista janelaPai;
    private boolean cadastro;
    private boolean descricao; 
    public frmCadastroFornecedor(java.awt.Frame parent, boolean modal, frmFornecedorLista janelaPai, boolean cadastro,boolean descricao) {
       super(parent, modal);
        
        initComponents();
       Color minhaCor = new Color(239,239,239);
        this.getContentPane().setBackground(minhaCor);
        
        
        
        //SETANDO TAMANHO MAXIMO DO CAMPO
        
        txtNome.setDocument(new FixedLengthDocument(100));
        txtRazaoSocial.setDocument(new FixedLengthDocument(100));
        txtBairro.setDocument(new FixedLengthDocument(100));
        txtComplemento1.setDocument(new FixedLengthDocument(100));
        txtEmail.setDocument(new FixedLengthDocument(100));
        txtInscricaoEstadual.setDocument(new FixedLengthDocument(100));
        txtInscricaoMunicipal.setDocument(new FixedLengthDocument(100));
        txtNumero.setDocument(new FixedLengthDocument(6));
        txtObservacao.setDocument(new FixedLengthDocument(150));
        txtSite.setDocument(new FixedLengthDocument(100));
        
        //SETANDO TAMANHO MAXIMO DO CAMPO ==============
        
        this.janelaPai = janelaPai;
        this.cadastro = cadastro;
        this.descricao = descricao;
        
        
        listaCidades = new LinkedList<>();
        daoCidade = new CidadeDAO();
        listaEstados = new Estado();
        
       
         cbxCidades.removeAllItems();
         cbxEstados.removeAllItems();
         
         /*
          * 
          * SETANDO VALOR PADRAO DOS COMBOBOX
          * 
          */
         Cidade tmpCidade = new Cidade();
         tmpCidade.setNome("Selecione Um Estado");
        
        
         
         cbxCidades.addItem(tmpCidade);
         
                 
                 
                 
         listaCidades = daoCidade.ListarTodos();
         
         
         /*
          * 
          * PREENCHE COMBOBOX DE CIDADES
          
          
         for(Cidade c : listaCidades){
             cbxCidades.addItem(c);
         }
         
         /*
          * 
          * PREENCHE COMBOBOX DE ESTADOS
          
          */
         for(String f : listaEstados.getEstados()){
             cbxEstados.addItem(f);
         }
        
         
         btnSair.setVisible(false);
         
        if(cadastro){
            this.setTitle("CADASTRO DE FORNECEDORES");
           // System.out.println("verdade");
        }else{
            
            if(descricao){
                this.setTitle("DESCRIÇÃO DE FORNECEDORES");
                
                txtBairro.setEditable(false);
                txtCep.setEditable(false);
                txtCnpj.setEditable(false);
                txtComplemento1.setEditable(false);
                txtEmail.setEditable(false);
                txtInscricaoEstadual.setEditable(false);
                txtInscricaoMunicipal.setEditable(false);
                txtNome.setEditable(false);
                txtNumero.setEditable(false);
                txtObservacao.setEditable(false);
                txtRazaoSocial.setEditable(false);
                txtRua.setEditable(false);
                txtSite.setEditable(false);
                txtTelefone.setEditable(false);
                cbxCidades.setEnabled(false);
                cbxEstados.setEnabled(false);
                
                btnSair.setVisible(true);
                btnCancelar.setVisible(false);
                btnSalvar.setVisible(false);
            }else{
                this.setTitle("EDIÇÃO DE FORNECEDORES");
            }
            //System.out.println("false");
            /*setando valores recebidos da janela pai aos campos*/
            
            
            txtInscricaoEstadual.setText(janelaPai.objSelecionadoNaTabela.getInscricaoEstadual());
            txtObservacao.setText(janelaPai.objSelecionadoNaTabela.getObservacoes());
            txtInscricaoMunicipal.setText(janelaPai.objSelecionadoNaTabela.getIncricaoMunicipal());
            txtNome.setText(janelaPai.objSelecionadoNaTabela.getNome());
            txtRazaoSocial.setText(janelaPai.objSelecionadoNaTabela.getRazaoSocial());
            txtRua.setText(janelaPai.objSelecionadoNaTabela.getEnderecoRua());
            txtSite.setText(janelaPai.objSelecionadoNaTabela.getSite());
            txtTelefone.setText(janelaPai.objSelecionadoNaTabela.getTelefone());
            txtComplemento1.setText(janelaPai.objSelecionadoNaTabela.getEnderecoComplemento());
            txtCnpj.setText(janelaPai.objSelecionadoNaTabela.getCnpj());
            txtBairro.setText(janelaPai.objSelecionadoNaTabela.getEnderecoBairro());
            txtNumero.setText(String.valueOf(janelaPai.objSelecionadoNaTabela.getEnderecoNumero()));
            txtCep.setText(janelaPai.objSelecionadoNaTabela.getEnderecoCep());
            txtEmail.setText(janelaPai.objSelecionadoNaTabela.getEmail());
            cbxEstados.setSelectedItem(listaEstados.getEstadoPorId(janelaPai.objSelecionadoNaTabela.getEnderecoCidade().getIdEstado()));
            cbxCidades.setSelectedItem(janelaPai.objSelecionadoNaTabela.getEnderecoCidade());
            
            
           
           
            
            
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

        painelNovoServico = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        lblRazaoSocial = new javax.swing.JLabel();
        lblInscricaoMunicipal = new javax.swing.JLabel();
        lblInscricaoEstadual = new javax.swing.JLabel();
        lblObservacao = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtInscricaoMunicipal = new javax.swing.JTextField();
        txtRazaoSocial = new javax.swing.JTextField();
        txtInscricaoEstadual = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObservacao = new javax.swing.JTextArea();
        lblCnpj = new javax.swing.JLabel();
        txtCnpj = new javax.swing.JFormattedTextField();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblRua = new javax.swing.JLabel();
        txtRua = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        lblComplemento = new javax.swing.JLabel();
        lblCep = new javax.swing.JLabel();
        lblTelefone = new javax.swing.JLabel();
        txtComplemento1 = new javax.swing.JTextField();
        lblSite = new javax.swing.JLabel();
        txtSite = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblNumero = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        lblCiade = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        cbxCidades = new javax.swing.JComboBox();
        cbxEstados = new javax.swing.JComboBox();
        txtCep = new javax.swing.JFormattedTextField();
        txtTelefone = new javax.swing.JFormattedTextField();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        painelNovoServico.setBackground(new java.awt.Color(228, 228, 228));
        painelNovoServico.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Novo Fornecedor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        lblNome.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNome.setText("Nome* :");

        lblRazaoSocial.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblRazaoSocial.setText("Razão Social*:");

        lblInscricaoMunicipal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblInscricaoMunicipal.setText("Inscrição Municipal*:");

        lblInscricaoEstadual.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblInscricaoEstadual.setText("Inscrição Estadual*:");

        lblObservacao.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblObservacao.setText("Observações:");

        txtNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtInscricaoMunicipal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtRazaoSocial.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtRazaoSocial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRazaoSocialActionPerformed(evt);
            }
        });

        txtInscricaoEstadual.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtInscricaoEstadual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInscricaoEstadualActionPerformed(evt);
            }
        });

        txtObservacao.setColumns(20);
        txtObservacao.setRows(5);
        jScrollPane1.setViewportView(txtObservacao);

        lblCnpj.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCnpj.setText("CNPJ*:");

        try {
            txtCnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCnpj.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout painelNovoServicoLayout = new javax.swing.GroupLayout(painelNovoServico);
        painelNovoServico.setLayout(painelNovoServicoLayout);
        painelNovoServicoLayout.setHorizontalGroup(
            painelNovoServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelNovoServicoLayout.createSequentialGroup()
                .addGroup(painelNovoServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelNovoServicoLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblObservacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelNovoServicoLayout.createSequentialGroup()
                        .addComponent(lblInscricaoMunicipal)
                        .addGap(28, 28, 28)
                        .addComponent(txtInscricaoMunicipal, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblInscricaoEstadual)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtInscricaoEstadual, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelNovoServicoLayout.createSequentialGroup()
                        .addGroup(painelNovoServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRazaoSocial)
                            .addComponent(lblNome))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelNovoServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelNovoServicoLayout.createSequentialGroup()
                                .addComponent(txtRazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblCnpj)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCnpj))
                            .addGroup(painelNovoServicoLayout.createSequentialGroup()
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 715, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        painelNovoServicoLayout.setVerticalGroup(
            painelNovoServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelNovoServicoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelNovoServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(painelNovoServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblRazaoSocial)
                    .addComponent(txtRazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painelNovoServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCnpj)
                        .addComponent(txtCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(painelNovoServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelNovoServicoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelNovoServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblInscricaoEstadual)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelNovoServicoLayout.createSequentialGroup()
                                .addComponent(txtInscricaoEstadual, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7))))
                    .addGroup(painelNovoServicoLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(painelNovoServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtInscricaoMunicipal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblInscricaoMunicipal))))
                .addGroup(painelNovoServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelNovoServicoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelNovoServicoLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(lblObservacao)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnSalvar.setBackground(new java.awt.Color(239, 239, 239));
        btnSalvar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/tcc/Presentation/icones/salvar.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSalvarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSalvarMouseExited(evt);
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

        jPanel1.setBackground(new java.awt.Color(228, 228, 228));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contatos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        lblRua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblRua.setText("Rua *:");

        txtRua.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Bairro *:");

        txtBairro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblComplemento.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblComplemento.setText("Complemento :");

        lblCep.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCep.setText("CEP*:");

        lblTelefone.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTelefone.setText("Telefone *:");

        txtComplemento1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblSite.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSite.setText("Site:");

        txtSite.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblEmail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblEmail.setText("Email:");

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblNumero.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNumero.setText("Nº*:");

        txtNumero.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblCiade.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCiade.setText("Cidade *:");

        lblEstado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblEstado.setText("Estado *:");

        cbxCidades.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxCidades.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxEstados.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxEstados.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxEstados.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxEstadosItemStateChanged(evt);
            }
        });

        try {
            txtCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCep.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblEstado)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRua)
                            .addComponent(jLabel1)))
                    .addComponent(lblSite))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblComplemento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtComplemento1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCep)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCep))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblNumero)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtSite, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(lblEmail))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbxEstados, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblCiade)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbxCidades, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblTelefone)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTelefone)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblRua)
                            .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(lblNumero))
                    .addComponent(txtNumero, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(6, 6, 6))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblComplemento)
                                        .addGap(7, 7, 7))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblCep)
                                        .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtComplemento1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxCidades, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxEstados, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCiade, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblEstado, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTelefone)
                            .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSite, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblEmail))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblSite)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnSair.setBackground(new java.awt.Color(239, 239, 239));
        btnSair.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSair.setText("Sair");
        btnSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSairMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSairMouseEntered(evt);
            }
        });
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(painelNovoServico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(27, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(272, 272, 272)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(painelNovoServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtRazaoSocialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRazaoSocialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRazaoSocialActionPerformed

    private void cbxEstadosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxEstadosItemStateChanged
       /*
        * QUANDO MUDAR O ESTADO MUDAR TABEM AS CIDADES REFERENTES AO ESTADO
        */
        
        estadoSelecionado = cbxEstados.getSelectedIndex();
        
        cbxCidades.removeAllItems();
        for(Cidade c : listaCidades){
             if(c.getIdEstado() == estadoSelecionado)
                cbxCidades.addItem(c);
         }
    }//GEN-LAST:event_cbxEstadosItemStateChanged

    private void txtInscricaoEstadualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInscricaoEstadualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtInscricaoEstadualActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if (JOptionPane.showConfirmDialog(rootPane, "Você tem certeza que deseja cancelar?", "Confirmação", JOptionPane.OK_CANCEL_OPTION) == 0) {
            this.dispose();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        /*Botão salvar*/

        if(txtInscricaoEstadual.getText().isEmpty()
            || txtInscricaoMunicipal.getText().isEmpty() || txtNome.getText().isEmpty() ||
            txtRazaoSocial.getText().isEmpty() || (cbxCidades.getSelectedIndex() == 0) || (cbxEstados.getSelectedIndex() == 0)
            || txtRua.getText().isEmpty() || txtBairro.getText().isEmpty() || txtTelefone.getText().isEmpty() || txtNumero.getText().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Todos os Campos devem ser Preenchidos !");
        }else if (JOptionPane.showConfirmDialog(rootPane, "Você tem certeza que deseja salvar o Fornecedor?",
            "Confirmação",JOptionPane.OK_CANCEL_OPTION) == 0){

            Fornecedor fornecedor  = null;
            if(cadastro){
                fornecedor  = new Fornecedor();
            }else{
                fornecedor = janelaPai.objSelecionadoNaTabela;
            }
            
        
        janelaPai.dao = new FornecedorDAO();

        /*CAPTURANDO ENTRADA DE DADOS DO JDIALOG E VALIDANDO*/

        int ok =0; //variavel de validação

        try{
            fornecedor.setEnderecoNumero(Integer.parseInt(txtNumero.getText()));
            ok++;
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(rootPane, "Número Endereço Inválido !");
        }

        fornecedor.setCnpj(txtCnpj.getText());
        Date d = new Date();
        fornecedor.setDataCadastro(d);
        fornecedor.setEmail(txtEmail.getText());
        fornecedor.setEnderecoBairro(txtBairro.getText());
        fornecedor.setEnderecoCep(txtCep.getText());
        fornecedor.setEnderecoCidade((Cidade) cbxCidades.getSelectedItem());
        fornecedor.setEnderecoComplemento(txtComplemento1.getText());
        fornecedor.setEnderecoNumero(Integer.parseInt(txtNumero.getText()));
        fornecedor.setEnderecoRua(txtRua.getText());
        fornecedor.setIncricaoMunicipal(txtInscricaoMunicipal.getText());
        fornecedor.setInscricaoEstadual(txtInscricaoEstadual.getText());
        fornecedor.setNome(txtNome.getText());
        fornecedor.setObservacoes(txtObservacao.getText());
        fornecedor.setRazaoSocial(txtRazaoSocial.getText());
        fornecedor.setSite(txtSite.getText());
        fornecedor.setTelefone(txtTelefone.getText());

        if(ok == 1){//se a validacao está correta

            if(janelaPai.dao.Salvar(fornecedor)){
                JOptionPane.showMessageDialog(rootPane, "Fornecedor Salvo com Sucesso!");
                txtInscricaoEstadual.setText(""); txtObservacao.setText("");
                txtInscricaoMunicipal.setText(""); txtNome.setText(""); txtRazaoSocial.setText("");
                janelaPai.lista.clear();
                janelaPai.lista = janelaPai.dao.ListarTodos();
                janelaPai.objSelecionadoNaTabela = null;
                janelaPai.preencheTabela();
                this.dispose();

            }else{
                JOptionPane.showMessageDialog(rootPane, "Erro ao salvar o Fornecedor!");
            }
        }

        }

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnSalvarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarMouseEntered
        Color minhaCor = new Color(115,183,253);
        this.btnSalvar.setBackground(minhaCor);
    }//GEN-LAST:event_btnSalvarMouseEntered

    private void btnSalvarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarMouseExited
        Color minhaCor = new Color(239,239,239);
        this.btnSalvar.setBackground(minhaCor);
    }//GEN-LAST:event_btnSalvarMouseExited

    private void btnCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseEntered
        Color minhaCor = new Color(115,183,253);
        this.btnCancelar.setBackground(minhaCor);
    }//GEN-LAST:event_btnCancelarMouseEntered

    private void btnCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseExited
        Color minhaCor = new Color(239,239,239);
        this.btnCancelar.setBackground(minhaCor);
    }//GEN-LAST:event_btnCancelarMouseExited

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
       this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnSairMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSairMouseEntered
        Color minhaCor = new Color(115,183,253);
        this.btnSair.setBackground(minhaCor);
    }//GEN-LAST:event_btnSairMouseEntered

    private void btnSairMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSairMouseExited
        Color minhaCor = new Color(239,239,239);
        this.btnSair.setBackground(minhaCor);
    }//GEN-LAST:event_btnSairMouseExited

    /*
     *  OUTRAS VARIAVEIS
     
     */
    
    List<Cidade> listaCidades;
    CidadeDAO daoCidade;
    Estado listaEstados;
    int estadoSelecionado;
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox cbxCidades;
    private javax.swing.JComboBox cbxEstados;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCep;
    private javax.swing.JLabel lblCiade;
    private javax.swing.JLabel lblCnpj;
    private javax.swing.JLabel lblComplemento;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblInscricaoEstadual;
    private javax.swing.JLabel lblInscricaoMunicipal;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblObservacao;
    private javax.swing.JLabel lblRazaoSocial;
    private javax.swing.JLabel lblRua;
    private javax.swing.JLabel lblSite;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JPanel painelNovoServico;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JFormattedTextField txtCep;
    private javax.swing.JFormattedTextField txtCnpj;
    private javax.swing.JTextField txtComplemento1;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtInscricaoEstadual;
    private javax.swing.JTextField txtInscricaoMunicipal;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextArea txtObservacao;
    private javax.swing.JTextField txtRazaoSocial;
    private javax.swing.JTextField txtRua;
    private javax.swing.JTextField txtSite;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
