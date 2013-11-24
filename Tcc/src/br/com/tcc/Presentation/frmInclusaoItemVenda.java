/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.Presentation;

import br.com.tcc.DataAccess.FuncionarioDAO;
import br.com.tcc.DataAccess.ProdutoDAO;
import br.com.tcc.DataAccess.ServicoDAO;
import br.com.tcc.DomainModel.Funcionario;
import br.com.tcc.DomainModel.ItemVendaProduto;
import br.com.tcc.DomainModel.ItemVendaServico;
import br.com.tcc.DomainModel.Produto;
import br.com.tcc.DomainModel.Servico;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author Thaisa
 */

public class frmInclusaoItemVenda extends javax.swing.JDialog {

    /**
     * Creates new form frmInclusaoItemVenda
     */
    private frmMenuPrincipal janelaPai;
    public frmInclusaoItemVenda(java.awt.Frame parent, boolean modal,frmMenuPrincipal janelaPai) {
        super(parent, modal);
        this.janelaPai = janelaPai;
                
        initComponents();
        Color minhaCor = new Color(239,239,239);
        this.getContentPane().setBackground(minhaCor);
        cbxProdutosServicos.removeAllItems();
        lblProdutos.setVisible(false);
        lblServicos.setVisible(false);
        lblProfissional.setVisible(false);
        cbxProfissional.setVisible(false);
        txtDesconto.setText("0");
        spnQuantidade.setValue(1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBotoesRadio = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        rbtnServicos = new javax.swing.JRadioButton();
        rbtnProdutos = new javax.swing.JRadioButton();
        lblServicos = new javax.swing.JLabel();
        lblProdutos = new javax.swing.JLabel();
        cbxProdutosServicos = new javax.swing.JComboBox();
        lblProfissional = new javax.swing.JLabel();
        cbxProfissional = new javax.swing.JComboBox();
        lblQuantidade = new javax.swing.JLabel();
        spnQuantidade = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        txtDesconto = new javax.swing.JTextField();
        lbldescontoPercentual = new javax.swing.JLabel();
        lblValorUnitario = new javax.swing.JLabel();
        lblValorUni = new javax.swing.JLabel();
        btnOk = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(228, 228, 228));

        grupoBotoesRadio.add(rbtnServicos);
        rbtnServicos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rbtnServicos.setText("Serviços");
        rbtnServicos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbtnServicosMouseClicked(evt);
            }
        });

        grupoBotoesRadio.add(rbtnProdutos);
        rbtnProdutos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rbtnProdutos.setText("Produtos");
        rbtnProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbtnProdutosMouseClicked(evt);
            }
        });

        lblServicos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblServicos.setText("Serviços*:");

        lblProdutos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblProdutos.setText("Produtos*:");

        cbxProdutosServicos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxProdutosServicos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxProdutosServicos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxProdutosServicosItemStateChanged(evt);
            }
        });

        lblProfissional.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblProfissional.setText("Profissional*:");

        cbxProfissional.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxProfissional.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblQuantidade.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblQuantidade.setText("Quantidade*:");

        spnQuantidade.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Desconto:");

        txtDesconto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lbldescontoPercentual.setText("%");

        lblValorUnitario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblValorUnitario.setText("Valor Unitário: R$");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblValorUnitario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblValorUni, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(7, 7, 7)
                .addComponent(txtDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbldescontoPercentual)
                .addGap(229, 229, 229))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(rbtnServicos)
                        .addGap(53, 53, 53)
                        .addComponent(rbtnProdutos))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblProfissional)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxProfissional, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblServicos)
                        .addGap(10, 10, 10)
                        .addComponent(cbxProdutosServicos, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblQuantidade)
                        .addGap(18, 18, 18)
                        .addComponent(spnQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblProdutos)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbtnServicos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtnProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(lblProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblQuantidade)
                        .addComponent(spnQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblServicos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbxProdutosServicos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblValorUni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbldescontoPercentual)
                        .addComponent(lblValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProfissional, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxProfissional, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62))
        );

        btnOk.setBackground(new java.awt.Color(239, 239, 239));
        btnOk.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/tcc/Presentation/icones/salvar.png"))); // NOI18N
        btnOk.setText("Ok");
        btnOk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnOkMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnOkMouseExited(evt);
            }
        });
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
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
                .addGap(188, 188, 188)
                .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(215, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void rbtnServicosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtnServicosMouseClicked
        ServicoDAO daoServico = new ServicoDAO();
        cbxProdutosServicos.removeAllItems();
        Servico tmp = new Servico();
        tmp.setNome("Selecione");
        cbxProdutosServicos.addItem(tmp);
        
        cbxProfissional.removeAllItems();
        FuncionarioDAO daoFuncionario = new FuncionarioDAO();
        
        cbxProfissional.removeAllItems();
        Funcionario tmpFuncionario = new Funcionario();
        tmpFuncionario.setNome("Selecione");
        cbxProfissional.addItem(tmpFuncionario);
        for(Funcionario f: daoFuncionario.ListarTodos()){
            cbxProfissional.addItem(f);
        }
        
        for(Servico s :daoServico.ListarTodos()){
            cbxProdutosServicos.addItem(s);
        }
        lblProfissional.setVisible(true);
        cbxProfissional.setVisible(true);
        lblServicos.setVisible(true);
        lblProdutos.setVisible(false);
        spnQuantidade.setValue(1);
        opcaoRadioButton = 1;
    }//GEN-LAST:event_rbtnServicosMouseClicked

    private void rbtnProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtnProdutosMouseClicked
        ProdutoDAO daoProduto = new ProdutoDAO();
        cbxProdutosServicos.removeAllItems();
        Produto tmp = new Produto();
        tmp.setNome("Selecione");
        cbxProdutosServicos.addItem(tmp);
        for(Produto p : daoProduto.ListarTodos()){
            cbxProdutosServicos.addItem(p);
        }
        lblServicos.setVisible(false);
        lblProdutos.setVisible(true);
        lblProfissional.setVisible(false);
        cbxProfissional.setVisible(false);
        spnQuantidade.setValue(1);
        opcaoRadioButton =2;
    }//GEN-LAST:event_rbtnProdutosMouseClicked

    private void cbxProdutosServicosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxProdutosServicosItemStateChanged
        if(opcaoRadioButton ==1){
           
            
            if(cbxProdutosServicos.getSelectedItem() == null ||  cbxProdutosServicos.getItemCount() == 1 
                    || cbxProdutosServicos.getItemCount() == 0 ){
                lblValorUni.setText("");
            }else{
                tmpServico = (Servico) cbxProdutosServicos.getSelectedItem();
                lblValorUni.setText(String.valueOf(tmpServico.getValor()));
            }
            
        }else if(opcaoRadioButton == 2){
            
            
            if(cbxProdutosServicos.getSelectedItem() == null || cbxProdutosServicos.getItemCount() == 0 
                    || cbxProdutosServicos.getItemCount() == 1){
                lblValorUni.setText("");
            }else{
                tmpProduto = (Produto) cbxProdutosServicos.getSelectedItem();
                lblValorUni.setText(String.valueOf(tmpProduto.getPrecoVenda()));
            }
        }
            
        
        
       
    }//GEN-LAST:event_cbxProdutosServicosItemStateChanged

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
       if(opcaoRadioButton == 1){
            ItemVendaServico servico = new ItemVendaServico();
            servico.setFuncionario((Funcionario)cbxProfissional.getSelectedItem());
            
            
            
            //calculando o valor do desconto
           try {
               float valor = 0;
               
               if(Float.parseFloat(txtDesconto.getText()) > 0){
                   valor = tmpServico.getValor() * (Float.parseFloat(txtDesconto.getText()) / 100);
                   valor = tmpServico.getValor() - valor;
               }else{
                   valor = tmpServico.getValor();
               }
              
               servico.setValor(valor);

               servico.setServico(tmpServico);
               //conferir
               servico.setVenda(janelaPai.novaVenda);

               janelaPai.novaVenda.addServico(servico);
               janelaPai.preencheTabelaVendas();

           } catch (NumberFormatException ex) {
               JOptionPane.showMessageDialog(rootPane, "Desconto Inválido !");
           }
            
           this.dispose();
       }else if(opcaoRadioButton == 2){
           
           //Verificando disponibilidade no estoque
           
           if (tmpProduto.getQtdEstoque() > Integer.parseInt(spnQuantidade.getValue().toString())) {
               JOptionPane.showMessageDialog(rootPane, "A quantidade do produto é maior do que o valor de estque !");

           } else {

               ItemVendaProduto produto = new ItemVendaProduto();
               produto.setProduto(tmpProduto);
               produto.setVenda(janelaPai.novaVenda);

               produto.setQtd(Integer.parseInt(spnQuantidade.getValue().toString()));
               janelaPai.novaVenda.addProduto(produto);
               janelaPai.preencheTabelaVendas();
               this.dispose();
           }
       }
    }//GEN-LAST:event_btnOkActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if (JOptionPane.showConfirmDialog(rootPane, "Você tem certeza que deseja cancelar?", "Confirmação", JOptionPane.OK_CANCEL_OPTION) == 0) {
            this.dispose();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseExited
        Color minhaCor = new Color(239,239,239);
        this.btnCancelar.setBackground(minhaCor);
    }//GEN-LAST:event_btnCancelarMouseExited

    private void btnCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseEntered
        Color minhaCor = new Color(115,183,253);
        this.btnCancelar.setBackground(minhaCor);
    }//GEN-LAST:event_btnCancelarMouseEntered

    private void btnOkMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOkMouseEntered
         Color minhaCor = new Color(115,183,253);
        this.btnOk.setBackground(minhaCor);
    }//GEN-LAST:event_btnOkMouseEntered

    private void btnOkMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOkMouseExited
        Color minhaCor = new Color(239,239,239);
        this.btnOk.setBackground(minhaCor);
    }//GEN-LAST:event_btnOkMouseExited
   private Produto tmpProduto;
   private Servico tmpServico;
   private int opcaoRadioButton;//1 - para servico 2 prar produtos
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnOk;
    private javax.swing.JComboBox cbxProdutosServicos;
    private javax.swing.JComboBox cbxProfissional;
    private javax.swing.ButtonGroup grupoBotoesRadio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblProdutos;
    private javax.swing.JLabel lblProfissional;
    private javax.swing.JLabel lblQuantidade;
    private javax.swing.JLabel lblServicos;
    private javax.swing.JLabel lblValorUni;
    private javax.swing.JLabel lblValorUnitario;
    private javax.swing.JLabel lbldescontoPercentual;
    private javax.swing.JRadioButton rbtnProdutos;
    private javax.swing.JRadioButton rbtnServicos;
    private javax.swing.JSpinner spnQuantidade;
    private javax.swing.JTextField txtDesconto;
    // End of variables declaration//GEN-END:variables
}
