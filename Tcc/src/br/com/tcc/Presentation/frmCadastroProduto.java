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
    public frmCadastroProduto(java.awt.Frame parent, boolean modal, frmProdutoLista janelaPai, boolean cadastro) {
       super(parent, modal);
        
        initComponents();
        this.janelaPai = janelaPai;
        
        
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
        
         
         
         
        if(cadastro ==  true){
            this.setTitle("CADASTRO DE PRODUTO");
           // System.out.println("verdade");
        }else{
            this.setTitle("EDIÇÃO DE PRODUTO");
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        painelNovoServico.setBorder(javax.swing.BorderFactory.createTitledBorder("Novo Serviço"));
        painelNovoServico.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNome.setText("Nome* :");
        painelNovoServico.add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 41, -1, -1));

        lblPrecoCusto.setText("Preço Custo* :");
        painelNovoServico.add(lblPrecoCusto, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 75, -1, -1));

        lblPrecoVenda.setText("Preço Venda* :");
        painelNovoServico.add(lblPrecoVenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(491, 34, -1, -1));

        lblQuantidade.setText("Quantidade* :");
        painelNovoServico.add(lblQuantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, -1, -1));

        lblDescricao.setText("Descrição* :");
        painelNovoServico.add(lblDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 200, -1, -1));
        painelNovoServico.add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 27, 362, 28));
        painelNovoServico.add(txtPrecoVenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(591, 27, 180, 28));

        txtPrecoCusto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecoCustoActionPerformed(evt);
            }
        });
        painelNovoServico.add(txtPrecoCusto, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 68, 189, 28));
        painelNovoServico.add(txtQuantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(591, 68, 180, 28));

        txtDescricao.setColumns(20);
        txtDescricao.setRows(5);
        jScrollPane1.setViewportView(txtDescricao);

        painelNovoServico.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 148, 679, 131));

        jLabel1.setText("Vendedor* :");
        painelNovoServico.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 117, -1, -1));

        jLabel2.setText("Tipo de Produto* :");
        painelNovoServico.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 120, -1, -1));

        cbxVendedor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        painelNovoServico.add(cbxVendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 114, 220, -1));

        cbxTipoProduto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        painelNovoServico.add(cbxTipoProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 110, 180, -1));

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
                        .addComponent(painelNovoServico, javax.swing.GroupLayout.PREFERRED_SIZE, 787, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelNovoServico, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
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
      
               
        /*Botão salvar*/
        
        if(txtQuantidade.getText().isEmpty() || txtDescricao.getText().isEmpty() 
               || txtPrecoVenda.getText().isEmpty() || txtNome.getText().isEmpty() || 
                txtPrecoCusto.getText().isEmpty() || (cbxTipoProduto.getSelectedIndex() == 0) || (cbxVendedor.getSelectedIndex() == 0) ){
           JOptionPane.showMessageDialog(rootPane, "Todos os Campos devem ser Preenchidos !");
       }else if (JOptionPane.showConfirmDialog(rootPane, "Você tem certeza que deseja salvar o Produto ",
               "Confirmação",JOptionPane.OK_CANCEL_OPTION) == 0){
           
            Produto produto = new Produto();
            janelaPai.dao = new ProdutoDAO();

            /*CAPTURANDO ENTRADA DE DADOS DO JDIALOG E VALIDANDO*/
            
            int ok =0; //variavel de validação
            
            produto.setDescricao(txtDescricao.getText());
            
            try{
                produto.setQtdEstoque(Integer.parseInt(txtQuantidade.getText()));
                ok++;
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(rootPane, "Quantidade Inválida !");
            }
            
            
            try{
                produto.setPrecoVenda(Float.parseFloat(txtPrecoVenda.getText()));
                ok++;
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(rootPane, "Preço de Venda Inválido !");
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
             
             */
            Fornecedor fornecedor;
            fornecedor = (Fornecedor) cbxVendedor.getSelectedItem();
            
            TipoProduto tipoProduto;
            tipoProduto = (TipoProduto) cbxTipoProduto.getSelectedItem();
            
            produto.setFornecedor(fornecedor);
            produto.setTipoProduto(tipoProduto);
            
            if(ok == 3){//se a validacao está correta

                if(janelaPai.dao.Salvar(null)){
                    JOptionPane.showMessageDialog(rootPane, "Serviço Salvo com Sucesso !");
                    txtQuantidade.setText(""); txtDescricao.setText("");
                    txtPrecoVenda.setText(""); txtNome.setText(""); txtPrecoCusto.setText("");
                    janelaPai.lista.clear();
                    janelaPai.lista = janelaPai.dao.ListarTodos();
                    janelaPai.preencheTabela();
                    this.dispose();

                }else{
                    JOptionPane.showMessageDialog(rootPane, "Erro ao salvar o serviço !");
                }
            }
       
       }
  
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    /*
     *  OUTRAS VARIAVEIS
     
     */
    
    List<Fornecedor> listaFornecedores;
    FornecedorDAO daoFornecedor;
    List<TipoProduto> listaTipoProdutos;
    TipoProdutoDAO daoTipoProdutos;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbxTipoProduto;
    private javax.swing.JComboBox cbxVendedor;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
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
