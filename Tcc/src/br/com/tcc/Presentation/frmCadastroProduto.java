/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.Presentation;

import br.com.tcc.DataAccess.FornecedorDAO;
import br.com.tcc.DataAccess.ProdutoDAO;
import br.com.tcc.DataAccess.TipoProdutoDAO;
import br.com.tcc.DomainModel.Fornecedor;
import br.com.tcc.DomainModel.Produto;
import br.com.tcc.DomainModel.TipoProduto;
import br.com.tcc.utilitarios.FixedLengthDocument;
import java.awt.Color;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author thaisa
 */
public class frmCadastroProduto extends javax.swing.JDialog {

    /**
     * Creates new form frmCadastroServicosCadastroEdicao
     * 
     * 
     * NO CONSTRUTOR SE FOR TRUE É CADASTRO DE NOVO SERVICO SE FALSE É EDICAO
     * 
     */
    private frmProdutoLista janelaPai;
    private boolean cadastro;
    private boolean descricao;
    public frmCadastroProduto(java.awt.Frame parent, boolean modal, frmProdutoLista janelaPai, boolean cadastro, boolean descricao) {
       super(parent, modal);
        
        initComponents();
         Color minhaCor = new Color(239,239,239);
        this.getContentPane().setBackground(minhaCor);
        this.janelaPai = janelaPai;
        this.cadastro = cadastro;
        this.descricao = descricao;
        
        // SETANDO O TAMANHO DOS CAMPOS
        
        txtNome.setDocument(new FixedLengthDocument(100));
        txtPrecoCusto.setDocument(new FixedLengthDocument(6));
        txtPrecoVenda.setDocument(new FixedLengthDocument(6));
        txtQuantidade.setDocument(new FixedLengthDocument(6));
        txtDescricao.setDocument(new FixedLengthDocument(150));
       
        
        
        listaFornecedores = new LinkedList<>();
        daoFornecedor = new FornecedorDAO();
        listaTipoProdutos = new LinkedList<>();
        daoTipoProdutos  = new TipoProdutoDAO();
       
         cbxVendedor.removeAllItems();
         cbxTipoProduto.removeAllItems();
         
         /*
          * 
          * VALOR PADRAO DOS COMBOBOX
          * 
          */
         Fornecedor tmpFornecedor = new Fornecedor();
         tmpFornecedor.setNome("Selecione");
         TipoProduto tmpTipoProduto = new TipoProduto();
         tmpTipoProduto.setNome("Selecione");
         
         cbxTipoProduto.addItem(tmpTipoProduto);
         cbxVendedor.addItem(tmpFornecedor);
                 
                 
                 
         listaFornecedores = daoFornecedor.ListarTodos();
         listaTipoProdutos = daoTipoProdutos.ListarTodos();
         
         /*
          * 
          * PREENCHE COMBOBOX DE FORNECEDORES
          
          */
         for(Fornecedor f : listaFornecedores){
             cbxVendedor.addItem(f);
         }
         
         /*
          * 
          * PREENCHE COMBOBOX DE FORNECEDORES
          
          */
         for(TipoProduto f : listaTipoProdutos){
             cbxTipoProduto.addItem(f);
         }
        
         
         btnSair.setVisible(false);
         
        if(cadastro ==  true){
            this.setTitle("CADASTRO DE PRODUTO");
           // System.out.println("verdade");
        }else{
            
            if(descricao){
                this.setTitle("DESCRIÇÃO DO PRODUTO");
                txtDescricao.setEditable(false);
                txtNome.setEditable(false);
                txtPrecoCusto.setEditable(false);
                txtPrecoVenda.setEditable(false);
                txtQuantidade.setEditable(false);
                cbxTipoProduto.setEnabled(false);
                cbxVendedor.setEnabled(false);
                btnCancelar.setVisible(false);
                btnSair.setVisible(true);
                btnSalvar.setVisible(false);
            }else{
                this.setTitle("EDIÇÃO DO PRODUTO");
            }
            
            //System.out.println("false");
            /*setando valores recebidos da janela pai aos campos*/
            
            txtQuantidade.setText(String.valueOf(janelaPai.objSelecionadoNaTabela.getQtdEstoque()));
            txtDescricao.setText(janelaPai.objSelecionadoNaTabela.getDescricao());
            txtPrecoVenda.setText(String.valueOf(janelaPai.objSelecionadoNaTabela.getPrecoVenda()));
            txtNome.setText(janelaPai.objSelecionadoNaTabela.getNome());
            txtPrecoCusto.setText(String.valueOf(janelaPai.objSelecionadoNaTabela.getPrecoCusto()));
            
            cbxTipoProduto.setSelectedItem(janelaPai.objSelecionadoNaTabela.getTipoProduto());
            cbxVendedor.setSelectedItem(janelaPai.objSelecionadoNaTabela.getFornecedor());
           
            
            
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
        lblPrecoCusto = new javax.swing.JLabel();
        lblPrecoVenda = new javax.swing.JLabel();
        lblQuantidade = new javax.swing.JLabel();
        lblDescricao = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtPrecoVenda = new javax.swing.JTextField();
        txtPrecoCusto = new javax.swing.JTextField();
        txtQuantidade = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbxVendedor = new javax.swing.JComboBox();
        cbxTipoProduto = new javax.swing.JComboBox();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        setResizable(false);

        painelNovoServico.setBackground(new java.awt.Color(228, 228, 228));
        painelNovoServico.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Novo Produto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        painelNovoServico.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNome.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNome.setText("Nome* :");
        painelNovoServico.add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 60, -1));

        lblPrecoCusto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPrecoCusto.setText("Preço Custo* :");
        painelNovoServico.add(lblPrecoCusto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        lblPrecoVenda.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPrecoVenda.setText("Preço Venda* :");
        painelNovoServico.add(lblPrecoVenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, -1, -1));

        lblQuantidade.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblQuantidade.setText("Quantidade* :");
        painelNovoServico.add(lblQuantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, -1, -1));

        lblDescricao.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDescricao.setText("Descrição :");
        painelNovoServico.add(lblDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        txtNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        painelNovoServico.add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 650, 30));

        txtPrecoVenda.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        painelNovoServico.add(txtPrecoVenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 100, 30));

        txtPrecoCusto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPrecoCusto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecoCustoActionPerformed(evt);
            }
        });
        painelNovoServico.add(txtPrecoCusto, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 100, 30));

        txtQuantidade.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        painelNovoServico.add(txtQuantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 70, 100, 30));

        txtDescricao.setColumns(20);
        txtDescricao.setRows(5);
        jScrollPane1.setViewportView(txtDescricao);

        painelNovoServico.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 159, 650, 120));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Fornecedor* :");
        painelNovoServico.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Tipo de Produto* :");
        painelNovoServico.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, -1, -1));

        cbxVendedor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxVendedor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione o fornecedor", "Item 2", "Item 3", "Item 4" }));
        cbxVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxVendedorActionPerformed(evt);
            }
        });
        painelNovoServico.add(cbxVendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 170, 30));

        cbxTipoProduto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxTipoProduto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione o tipo do produto", "Item 2", "Item 3", "Item 4" }));
        painelNovoServico.add(cbxTipoProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 110, 200, 30));

        btnSalvar.setBackground(new java.awt.Color(239, 239, 239));
        btnSalvar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/tcc/Presentation/icones/salvar.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setToolTipText("Salvar novo Serviço");
        btnSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSalvarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSalvarMouseExited(evt);
            }
        });
        btnSalvar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnSalvarMouseMoved(evt);
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
        btnCancelar.setToolTipText("Cancelar cadastro de novo Serviço");
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancelarMouseExited(evt);
            }
        });
        btnCancelar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnCancelarMouseMoved(evt);
            }
        });
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSair.setBackground(new java.awt.Color(239, 239, 239));
        btnSair.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSair.setText("Sair");
        btnSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSairMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSairMouseExited(evt);
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
                .addGap(30, 30, 30)
                .addComponent(painelNovoServico, javax.swing.GroupLayout.PREFERRED_SIZE, 787, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(256, 256, 256)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(painelNovoServico, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPrecoCustoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecoCustoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecoCustoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
      
               
        /*Botão salvar*/
        
      
        if (txtNome.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Preencha o Nome");
        }   else if (txtPrecoCusto.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Preencha o Preço de Custo");
        } else if (txtPrecoVenda.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Preencha o Preço de Venda");
        } else if (txtQuantidade.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Preencha a Quantidade");
        } else if (cbxVendedor.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Preencha o Vendedor");
        } else if (cbxTipoProduto.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Preencha o Tipo do Produto");
        } 
        
        
        
        
        
        else if (Float.parseFloat(txtPrecoCusto.getText()) > Float.parseFloat(txtPrecoVenda.getText())){
           
           JOptionPane.showMessageDialog(rootPane, "O preço de venda não pode ser menor que o preço de custo !");
           
       }
       
       
       
       else if(JOptionPane.showConfirmDialog(rootPane, "Você tem certeza que deseja salvar o Produto",
               "Confirmação",JOptionPane.OK_CANCEL_OPTION) == 0){
           
            Produto produto = null;
            
            if(cadastro){
                produto = new Produto();
            }else{
                produto = janelaPai.objSelecionadoNaTabela;
            }
            janelaPai.dao = new ProdutoDAO();

            /*CAPTURANDO ENTRADA DE DADOS DO JDIALOG E VALIDANDO*/
            
            int ok =0; //variavel de validação
            
            produto.setDescricao(txtDescricao.getText());
            
            try{
                produto.setQtdEstoque(Integer.parseInt(txtQuantidade.getText()));
                ok++;
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(rootPane, "Quantidade Inválida!");
            }
            
            
            try{
                produto.setPrecoVenda(Float.parseFloat(txtPrecoVenda.getText()));
                ok++;
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(rootPane, "Preço de Venda Inválido!");
            }
            
            try{
                produto.setPrecoCusto(Float.parseFloat(txtPrecoCusto.getText()));
                ok++;
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(rootPane, "Preço de Custo Inválido!");
            }
            
            produto.setNome(txtNome.getText());
            
            /*
             
             * falta pegar  vendedor e o tipo de produto
             
             */
            Fornecedor fornecedor;
            fornecedor = (Fornecedor) cbxVendedor.getSelectedItem();
            
            TipoProduto tipoProduto;
            tipoProduto = (TipoProduto) cbxTipoProduto.getSelectedItem();
            
            produto.setFornecedor(fornecedor);
            produto.setTipoProduto(tipoProduto);
            
            if(ok == 3){//se a validacao está correta

                if(janelaPai.dao.Salvar(produto)){
                    JOptionPane.showMessageDialog(rootPane, "Produto Salvo com Sucesso!");
                    txtQuantidade.setText(""); txtDescricao.setText("");
                    txtPrecoVenda.setText(""); txtNome.setText(""); txtPrecoCusto.setText("");
                    janelaPai.lista.clear();
                    janelaPai.lista = janelaPai.dao.ListarTodos();
                    janelaPai.preencheTabela();
                    janelaPai.objSelecionadoNaTabela = null;
                    this.dispose();

                }else{
                    JOptionPane.showMessageDialog(rootPane, "Erro ao salvar o produto!");
                }
            }
       
       }
  
        
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if (JOptionPane.showConfirmDialog(rootPane, "Você tem certeza que deseja cancelar?", "Confirmação", JOptionPane.OK_CANCEL_OPTION) == 0) {
            this.dispose();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnCancelarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseMoved
       //this.btnCancelar.setBackground(Color.BLUE); 
       //this.btnCancelar.setForeground(Color.white);
    }//GEN-LAST:event_btnCancelarMouseMoved

    private void btnCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseExited
       Color minhaCor = new Color(239,239,239);
       this.btnCancelar.setBackground(minhaCor);
    }//GEN-LAST:event_btnCancelarMouseExited

    private void btnSalvarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarMouseMoved
     //  this.btnSalvar.setBackground(Color.BLUE); 
       //this.btnSalvar.setForeground(Color.white);
    }//GEN-LAST:event_btnSalvarMouseMoved

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

    private void btnSairMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSairMouseEntered
        Color minhaCor = new Color(115,183,253);
        this.btnSair.setBackground(minhaCor);
    }//GEN-LAST:event_btnSairMouseEntered

    private void btnSairMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSairMouseExited
          Color minhaCor = new Color(239,239,239);
       this.btnSair.setBackground(minhaCor);
    }//GEN-LAST:event_btnSairMouseExited

    private void cbxVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxVendedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxVendedorActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    /*
     *  OUTRAS VARIAVEIS
     
     */
    
    List<Fornecedor> listaFornecedores;
    FornecedorDAO daoFornecedor;
    List<TipoProduto> listaTipoProdutos;
    TipoProdutoDAO daoTipoProdutos;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox cbxTipoProduto;
    private javax.swing.JComboBox cbxVendedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPrecoCusto;
    private javax.swing.JLabel lblPrecoVenda;
    private javax.swing.JLabel lblQuantidade;
    private javax.swing.JPanel painelNovoServico;
    private javax.swing.JTextArea txtDescricao;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPrecoCusto;
    private javax.swing.JTextField txtPrecoVenda;
    private javax.swing.JTextField txtQuantidade;
    // End of variables declaration//GEN-END:variables
}
