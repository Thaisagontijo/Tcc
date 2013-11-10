/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.Presentation;

import br.com.tcc.DataAccess.ClienteDAO;
import br.com.tcc.DomainModel.Agendamento;
import br.com.tcc.DomainModel.Cliente;
import br.com.tcc.DomainModel.Servico;
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
    public frmCadastroAgendamento(java.awt.Frame parent, boolean modal, frmMenuPrincipal janelaPai, boolean cadastro) {
       super(parent, modal);
        
        initComponents();
        this.janelaPai = janelaPai;
        
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
         
         
         
       
        // cbxCliente.addItem(tmpCliente);
                 
                 
                 
         listaClientes = daoClientes.ListarTodos();
      
         
         /*
          * 
          * PREENCHE COMBOBOX DE FORNECEDORES
          
          */
         for(Cliente f : listaClientes){
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
         
         cbxMinuto.addItem("Minuto");
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
            this.setTitle("CADASTRO DE Agendamento");
           // System.out.println("verdade");
        }else{
            this.setTitle("EDIÇÃO DE Agendamento");
            //System.out.println("false");
            /*setando valores recebidos da janela pai aos campos*/
            
          //  txtQuantidade.setText(String.valueOf(janelaPai.objSelecionadoNaTabela.getQtdEstoque()));
           // txtDescricao.setText(janelaPai.objSelecionadoNaTabela.getDescricao());
           // txtPrecoVenda.setText(String.valueOf(janelaPai.objSelecionadoNaTabela.getPrecoVenda()));
            //txtNome.setText(janelaPai.objSelecionadoNaTabela.getNome());
            //txtPrecoCusto.setText(String.valueOf(janelaPai.objSelecionadoNaTabela.getPrecoCusto()));
            
           // cbxTipoProduto.setSelectedItem(janelaPai.objSelecionadoNaTabela.getTipoProduto());
            //cbxCliente.setSelectedItem(janelaPai.objSelecionadoNaTabela.getFornecedor());
           
            
            
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        painelNovoServico.setBorder(javax.swing.BorderFactory.createTitledBorder("Novo Agendamento"));

        lblServicos.setText("Serviços* :");

        lblHora.setText("Hora *:");

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

        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        cbxHora.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText(":");

        cbxMinuto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxDia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxMes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxAno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblObservacao.setText("Observação:");

        cbxCliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout painelNovoServicoLayout = new javax.swing.GroupLayout(painelNovoServico);
        painelNovoServico.setLayout(painelNovoServicoLayout);
        painelNovoServicoLayout.setHorizontalGroup(
            painelNovoServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelNovoServicoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelNovoServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelNovoServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtQuantidade, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelNovoServicoLayout.createSequentialGroup()
                            .addGroup(painelNovoServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelNovoServicoLayout.createSequentialGroup()
                                    .addComponent(txtPrecoCusto, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(210, 210, 210)
                                    .addComponent(lblQuantidade))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelNovoServicoLayout.createSequentialGroup()
                                    .addComponent(lblDescricao)
                                    .addGap(18, 18, 18)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 679, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelNovoServicoLayout.createSequentialGroup()
                                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(38, 38, 38)
                                    .addComponent(jLabel2)))
                            .addGap(458, 458, 458)
                            .addComponent(cbxTipoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelNovoServicoLayout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(cbxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblData)
                            .addGap(18, 18, 18)
                            .addComponent(cbxDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(cbxMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(cbxAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(552, 552, 552)))
                    .addGroup(painelNovoServicoLayout.createSequentialGroup()
                        .addGroup(painelNovoServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblServicos)
                            .addComponent(lblHora)
                            .addComponent(lblObservacao))
                        .addGap(18, 18, 18)
                        .addGroup(painelNovoServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelNovoServicoLayout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addGroup(painelNovoServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAdicionar)
                                    .addComponent(btnRemover)))
                            .addGroup(painelNovoServicoLayout.createSequentialGroup()
                                .addComponent(cbxHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtObservacao, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelNovoServicoLayout.setVerticalGroup(
            painelNovoServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelNovoServicoLayout.createSequentialGroup()
                .addGroup(painelNovoServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelNovoServicoLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(painelNovoServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblData)
                            .addComponent(cbxDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(painelNovoServicoLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(painelNovoServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cbxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(8, 8, 8)
                .addGroup(painelNovoServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelNovoServicoLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(painelNovoServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblHora)
                            .addComponent(cbxHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(cbxMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(66, 66, 66)
                        .addComponent(lblServicos))
                    .addGroup(painelNovoServicoLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelNovoServicoLayout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(btnAdicionar)
                        .addGap(36, 36, 36)
                        .addComponent(btnRemover)))
                .addGap(72, 72, 72)
                .addGroup(painelNovoServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblObservacao)
                    .addComponent(txtObservacao, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(135, 135, 135)
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

        jButton1.setText("Salvar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(280, 280, 280)
                        .addComponent(jButton1)
                        .addGap(136, 136, 136)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(painelNovoServico, javax.swing.GroupLayout.PREFERRED_SIZE, 924, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelNovoServico, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPrecoCustoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecoCustoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecoCustoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      

        if(cbxAno.getSelectedIndex() == 0  || cbxDia.getSelectedIndex() == 0 ||
                cbxHora.getSelectedIndex() == 0 || cbxMes.getSelectedIndex() == 0 || cbxMinuto.getSelectedIndex() == 0 || listaServicos.size() == 0){
            JOptionPane.showMessageDialog(rootPane, "Todos Os campos devem ser preenchidos!");
        
        }else{
            Agendamento agendamento = new Agendamento();
            agendamento.setCliente((Cliente)cbxCliente.getSelectedItem());
            agendamento.setObservacao(txtObservacao.getText());
            agendamento.setServicos(listaServicos);
            
            Date dataTmp = new Date();
            
            dataTmp.setDate(Integer.parseInt((String)cbxDia.getSelectedItem()));
            dataTmp.setHours(Integer.parseInt((String)cbxHora.getSelectedItem()));
            dataTmp.setMinutes(Integer.parseInt((String)cbxMinuto.getSelectedItem()));
            
            //JOptionPane.showMessageDialog(rootPane, cbxMes.getSelectedItem().toString());
            int mes = Integer.parseInt(cbxMes.getSelectedItem().toString());
            mes--;
            dataTmp.setMonth(mes);
            dataTmp.setYear(Integer.parseInt((String)cbxAno.getSelectedItem()));
            
            agendamento.setDataHora(dataTmp);
            agendamento.setFuncionario(janelaPai.usuarioLogado.getFuncionario());
          //  agendamento.setRealizado(false);
            if(janelaPai.daoAgendamento.Salvar(agendamento)){
                JOptionPane.showMessageDialog(rootPane, "Agendamento cadastrado com sucesso !");
                //janelaPai.listaAgendamentos = janelaPai.daoAgendamento.Buscar(agendamento);
                janelaPai.listaAgendamentos.add(agendamento);
                janelaPai.preencheTabelaAgendamentos();
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(rootPane, "Erro ao cadastrar agendamento !");
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
  
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        frmListaServicosParaAgenda janela = new frmListaServicosParaAgenda(null, rootPaneCheckingEnabled, this);
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
                JOptionPane.showMessageDialog(rootPane, "chama a descricao");
                qtdCliques =0;
            }
        }else {
            qtdCliques= 1;
        }
        
        idSelecionadoTabela = tblServicos.getSelectedRow();
        objSelecionadoNaTabela = listaServicos.get(idSelecionadoTabela);
        
    }//GEN-LAST:event_tblServicosMouseClicked

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
    private javax.swing.JButton btnRemover;
    private javax.swing.JComboBox cbxAno;
    private javax.swing.JComboBox cbxCliente;
    private javax.swing.JComboBox cbxDia;
    private javax.swing.JComboBox cbxHora;
    private javax.swing.JComboBox cbxMes;
    private javax.swing.JComboBox cbxMinuto;
    private javax.swing.JComboBox cbxTipoProduto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
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
