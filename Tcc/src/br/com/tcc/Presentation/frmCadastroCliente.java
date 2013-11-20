/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.Presentation;

import br.com.tcc.DataAccess.CidadeDAO;
import br.com.tcc.DataAccess.ClienteDAO;
import br.com.tcc.DomainModel.Cidade;
import br.com.tcc.DomainModel.Cliente;
import br.com.tcc.DomainModel.Estado;
import java.awt.Color;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Thaisa
 */
public class frmCadastroCliente extends javax.swing.JDialog {

    /**
     * Creates new form frmCadastroFuncionario
     */
    private frmClienteLista janelaPai;
    private boolean cadastro;
    public frmCadastroCliente(java.awt.Frame parent, boolean modal, frmClienteLista janelaPai, boolean cadastro) {
        super(parent, modal);
        initComponents();
        
        Color minhaCor = new Color(239,239,239);
        this.getContentPane().setBackground(minhaCor);
        
        this.janelaPai = janelaPai;
        this.cadastro = cadastro;
        
        listaCidades = new LinkedList<>();
        listaEstados = new Estado();
        daoCidade = new CidadeDAO();
        
        cbxCidade.removeAllItems();
        cbxEstado.removeAllItems();
        cbxSexo.removeAllItems();
        cbxDia.removeAllItems();
        cbxMes.removeAllItems();
        cbxAno.removeAllItems();
        
        /*
         
         * SETAND VALORES PARA COMBOBOX
         
         */
        
         Cidade tmpCidade = new Cidade();
         tmpCidade.setNome("Selecione Um Estado");
        
        
         
         cbxCidade.addItem(tmpCidade);
         
                   
         listaCidades = daoCidade.ListarTodos();
         
         /*
          * 
          * PREENCHE COMBOBOX DE ESTADOS
          
          */
         for(String f : listaEstados.getEstados()){
             cbxEstado.addItem(f);
         }
         
         /*
          * 
          * PREENCHE COMBOBOX DE SEXO
          
          */
         
         String [] tmpSexo = {"Selecione","Masculino","Feminino"};
         for(String s : tmpSexo){
             cbxSexo.addItem(s);
         }
         
         
          /*
          * 
          * PREENCHE COMBOBOX DE DIA
          
          */
         
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
         Date tmpData = new Date();
         int anoAtual = tmpData.getYear() + 1900;
         for(int i=(anoAtual - 90) ;i<=anoAtual;i++){
             cbxAno.addItem(i);
         
         }
         
         
         
         //continuar a parte de edicao
         
         if(cadastro){
              this.setTitle("CADASTRO DE CLIENTE");
         }else{
              this.setTitle("EDIÇÃO DE CLIENTE");
              
              txtBairro.setText(janelaPai.objSelecionadoNaTabela.getEnderecoBairro());
              txtCelular.setText(janelaPai.objSelecionadoNaTabela.getCelular());
              txtCep.setText(janelaPai.objSelecionadoNaTabela.getEnderecoCep());
              txtComplemento.setText(janelaPai.objSelecionadoNaTabela.getEnderecoComplemento());
              txtCpf.setText(janelaPai.objSelecionadoNaTabela.getCpf());
              //txtData.setText(janelaPai.objSelecionadoNaTabela.getDataNascimento().toString());
              cbxDia.setSelectedIndex((janelaPai.objSelecionadoNaTabela.getDataNascimento().getDate()) );
              cbxMes.setSelectedIndex(((janelaPai.objSelecionadoNaTabela.getDataNascimento().getMonth()) + 1));
              cbxAno.setSelectedItem((janelaPai.objSelecionadoNaTabela.getDataNascimento().getYear()) );
              
              txtNome.setText(janelaPai.objSelecionadoNaTabela.getNome());
              txtNumero.setText(String.valueOf(janelaPai.objSelecionadoNaTabela.getEnderecoNumero()));
              txtRg.setText(janelaPai.objSelecionadoNaTabela.getRg());
              txtRua.setText(janelaPai.objSelecionadoNaTabela.getEnderecoRua());
              txtTelefone.setText(janelaPai.objSelecionadoNaTabela.getTelefone());
              cbxEstado.setSelectedIndex(janelaPai.objSelecionadoNaTabela.getEnderecoCidade().getIdEstado());
              cbxCidade.setSelectedItem(janelaPai.objSelecionadoNaTabela.getEnderecoCidade());
              cbxSexo.setSelectedIndex(janelaPai.objSelecionadoNaTabela.getSexo());
              
              
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

        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jPanel1 = new javax.swing.JPanel();
        lblnome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblCpf = new javax.swing.JLabel();
        lblRg = new javax.swing.JLabel();
        lblDataNascimento = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtRg = new javax.swing.JTextField();
        cbxSexo = new javax.swing.JComboBox();
        cbxDia = new javax.swing.JComboBox();
        cbxMes = new javax.swing.JComboBox();
        cbxAno = new javax.swing.JComboBox();
        txtCpf = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtRua = new javax.swing.JTextField();
        txtBairro = new javax.swing.JTextField();
        txtNumero = new javax.swing.JTextField();
        txtComplemento = new javax.swing.JTextField();
        lblEstado = new javax.swing.JLabel();
        lblCidade = new javax.swing.JLabel();
        cbxEstado = new javax.swing.JComboBox();
        cbxCidade = new javax.swing.JComboBox();
        txtCep = new javax.swing.JFormattedTextField();
        jPanel3 = new javax.swing.JPanel();
        lblTelefone = new javax.swing.JLabel();
        lblCelular = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JFormattedTextField();
        txtCelular = new javax.swing.JFormattedTextField();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        jFormattedTextField1.setText("jFormattedTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(228, 228, 228));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastro de Cliente"));

        lblnome.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblnome.setText("Nome* :");

        txtNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblCpf.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCpf.setText("CPF:");

        lblRg.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblRg.setText("RG :");

        lblDataNascimento.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDataNascimento.setText("Data de Nascimento* :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Sexo* :");

        txtRg.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        cbxSexo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxDia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxDia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxMes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxMes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxAno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxAno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCpf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCpfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblnome)
                    .addComponent(lblRg))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(lblCpf)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(txtRg, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblDataNascimento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxAno, 0, 1, Short.MAX_VALUE)))
                .addGap(0, 8, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCpf)
                    .addComponent(lblnome)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbxDia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbxMes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbxAno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblDataNascimento)
                        .addComponent(jLabel4)
                        .addComponent(txtRg, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblRg))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(228, 228, 228));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Endereço"));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Rua* :");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Bairro* :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("CEP*:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Número*:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Complemento*:");

        txtRua.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtBairro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtNumero.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtComplemento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblEstado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblEstado.setText("Estado*:");

        lblCidade.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCidade.setText("Cidade*:");

        cbxEstado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxEstado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxEstadoItemStateChanged(evt);
            }
        });

        cbxCidade.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxCidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        try {
            txtCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCep.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblEstado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(lblCidade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCep)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCidade)
                            .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEstado))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(228, 228, 228));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Contatos"));

        lblTelefone.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTelefone.setText("Telefone :");

        lblCelular.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCelular.setText("Celular :");

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        try {
            txtCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCelular.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTelefone)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(lblCelular)
                .addGap(18, 18, 18)
                .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTelefone)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblCelular))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
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
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancelarMouseExited(evt);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 894, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(289, 289, 289)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
                       
        /*Botão salvar*/
        
        if(txtNome.getText().isEmpty() || (cbxSexo.getSelectedIndex()== 0) || cbxDia.getSelectedIndex() == 0 || cbxMes.getSelectedIndex() ==0 ||
               cbxAno.getSelectedIndex() == 0||  txtCpf.getText().isEmpty() || txtRg.getText().isEmpty() || txtRua.getText().isEmpty() || 
                txtNumero.getText().isEmpty() || txtBairro.getText().isEmpty() || txtCep.getText().isEmpty()){
           JOptionPane.showMessageDialog(rootPane, "Todos os Campos obrigatórios devem ser Preenchidos!");
       }else if (JOptionPane.showConfirmDialog(rootPane, "Você tem certeza que deseja salvar o Cliente?",
               "Confirmação",JOptionPane.OK_CANCEL_OPTION) == 0){
           
           Cliente Cliente = null;
           
           if(cadastro){
               Cliente = new Cliente();
           
           }else{
               Cliente = janelaPai.objSelecionadoNaTabela;
           }
           
           
           janelaPai.dao = new ClienteDAO();

            /*CAPTURANDO ENTRADA DE DADOS DO JDIALOG E VALIDANDO*/
            
            int ok =0; //variavel de validação
            
                    
            
            try{
                Cliente.setEnderecoNumero(Integer.parseInt(txtNumero.getText()));
                ok++;
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(rootPane, "Número Endereço Inválido!");
            }
            
            Cliente.setNome(txtNome.getText());
            Date dataCadastro = new Date();
            Date dataNascimento = new Date();
            Cliente.setDataCadastro(dataCadastro);
            Cliente.setObservacao(" ");
            
            dataNascimento.setDate(Integer.parseInt((String)cbxDia.getSelectedItem()));
            int mes = Integer.parseInt(cbxMes.getSelectedItem().toString());
            mes--;
            dataNascimento.setMonth(mes);
            dataNascimento.setYear(Integer.parseInt((String)cbxAno.getSelectedItem().toString()));
            
            Cliente.setDataNascimento(dataNascimento);//mudar
            
            Cliente.setEnderecoBairro(txtBairro.getText());
            Cliente.setEnderecoCep(txtCep.getText());
            Cliente.setEnderecoCidade((Cidade) cbxCidade.getSelectedItem());
            Cliente.setEnderecoComplemento(txtComplemento.getText());
            Cliente.setCpf(txtCpf.getText());
            Cliente.setRg(txtRg.getText());
            Cliente.setSexo(cbxSexo.getSelectedIndex());
            Cliente.setCelular(txtCelular.getText());
            Cliente.setEnderecoRua(txtRua.getText());
            Cliente.setTelefone(txtTelefone.getText());
            
          
            if(ok == 1){//se a validacao está correta

                if(janelaPai.dao.Salvar(Cliente)){
                    JOptionPane.showMessageDialog(rootPane, "Cliente Salvo com Sucesso!");
                    janelaPai.lista.clear();
                    janelaPai.lista = janelaPai.dao.ListarTodos();
                    janelaPai.preencheTabela();
                    this.dispose();

                }else{
                    JOptionPane.showMessageDialog(rootPane, "Erro ao salvar o Cliente!");
                }
            }
       
       }

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void cbxEstadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxEstadoItemStateChanged
     /*
        * QUANDO MUDAR O ESTADO MUDAR TABEM AS CIDADES REFERENTES AO ESTADO
        */
        
        estadoSelecionado = cbxEstado.getSelectedIndex();
        
        cbxCidade.removeAllItems();
        for(Cidade c : listaCidades){
             if(c.getIdEstado() == estadoSelecionado)
                cbxCidade.addItem(c);
         }
        
        
    }//GEN-LAST:event_cbxEstadoItemStateChanged

    private void btnSalvarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarMouseEntered
        Color minhaCor = new Color(115,183,253);
        this.btnSalvar.setBackground(minhaCor);
    }//GEN-LAST:event_btnSalvarMouseEntered

    private void btnCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseEntered
        Color minhaCor = new Color(115,183,253);
        this.btnCancelar.setBackground(minhaCor);
    }//GEN-LAST:event_btnCancelarMouseEntered

    private void btnSalvarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarMouseExited
        Color minhaCor = new Color(239,239,239);
        this.btnSalvar.setBackground(minhaCor);
    }//GEN-LAST:event_btnSalvarMouseExited

    private void btnCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseExited
        Color minhaCor = new Color(239,239,239);
        this.btnCancelar.setBackground(minhaCor);
    }//GEN-LAST:event_btnCancelarMouseExited

    private void txtCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCpfActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if (JOptionPane.showConfirmDialog(rootPane, "Você tem certeza que deseja cancelar o cadastro do cliente?", "Confirmação", JOptionPane.OK_CANCEL_OPTION) == 0) {
            this.dispose();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    
    private List<Cidade> listaCidades;
    private CidadeDAO daoCidade;
    private Estado listaEstados;
    private int estadoSelecionado;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox cbxAno;
    private javax.swing.JComboBox cbxCidade;
    private javax.swing.JComboBox cbxDia;
    private javax.swing.JComboBox cbxEstado;
    private javax.swing.JComboBox cbxMes;
    private javax.swing.JComboBox cbxSexo;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblCelular;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblDataNascimento;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblRg;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JLabel lblnome;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JFormattedTextField txtCelular;
    private javax.swing.JFormattedTextField txtCep;
    private javax.swing.JTextField txtComplemento;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtRg;
    private javax.swing.JTextField txtRua;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
