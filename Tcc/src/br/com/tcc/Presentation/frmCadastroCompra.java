/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.tcc.Presentation;

import br.com.tcc.DataAccess.CompraDAO;
import br.com.tcc.DataAccess.FormaDePagamentoDAO;
import br.com.tcc.DataAccess.FuncionarioDAO;
import br.com.tcc.DataAccess.ProdutoDAO;
import br.com.tcc.DomainModel.Compra;
import br.com.tcc.DomainModel.FormaDePagamento;
import br.com.tcc.DomainModel.Funcionario;
import br.com.tcc.DomainModel.Produto;
import java.awt.Color;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Thaisa
 */
public class frmCadastroCompra extends javax.swing.JDialog {

    /**
     * Creates new form frmCadastroCompra
     */
    private frmListarCompras janelaPai;
    private boolean descricao;
    private List<Funcionario> listaF;
    private List<Produto> listaP;
    private List<FormaDePagamento> listaFo;
    
    public frmCadastroCompra(java.awt.Frame parent, boolean modal, frmListarCompras janelaPai, boolean descricao) {
        super(parent, modal);
        initComponents();
        
        Color minhaCor = new Color(239,239,239);
        this.getContentPane().setBackground(minhaCor);
        this.janelaPai = janelaPai;
        this.descricao = descricao;
   
        Funcionario funcionario = new Funcionario();
        Produto produto = new Produto();
        
        FuncionarioDAO daoF = new FuncionarioDAO();
        ProdutoDAO daoP = new ProdutoDAO();
        FormaDePagamentoDAO daoFo = new FormaDePagamentoDAO();
        
        cbxCompraFuncionario.removeAllItems();
        cbxCompraProduto.removeAllItems();
        cbxCompraPagamento.removeAllItems();
        cbxDia.removeAllItems();
        cbxMes.removeAllItems();
        cbxAno.removeAllItems();
         
        Funcionario tmpFuncionario = new Funcionario();
        tmpFuncionario.setNome("Selecione");
        Produto tmpProduto = new Produto();
        tmpProduto.setNome("Selecione");
        FormaDePagamento tmpFormaPagamento = new FormaDePagamento();
        tmpFormaPagamento.setNome("Selecione");
         
        cbxCompraFuncionario.addItem(tmpFuncionario);
        cbxCompraProduto.addItem(tmpProduto);
        cbxCompraPagamento.addItem(tmpFormaPagamento);
        
         
        
        listaF = new LinkedList<>();
        listaP = new LinkedList<>();
        listaFo = new LinkedList<>();
         
        listaF = daoF.ListarTodos();
        listaP = daoP.ListarTodos();
        listaFo = daoFo.ListarTodos();
         
         /*
          * PREENCHE COMBOBOX
          */
         for(Funcionario f : listaF){
             cbxCompraFuncionario.addItem(f);
         }
         
         /*
          * PREENCHE COMBOBOX
          */
         for(Produto f : listaP){
             cbxCompraProduto.addItem(f);
         }
         
         for(FormaDePagamento f : listaFo){
             cbxCompraPagamento.addItem(f);
         }
         
         
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
         
         
         //btnSair.setVisible(false);
         /*
          * 
          * PREENCHE COMBOBOX DO ANO
          
          */
         
         cbxAno.addItem("Ano");
         int data = new Date().getYear() + 1900;
         cbxAno.addItem(data);
         
         //setando data de hoje
         
         cbxDia.setSelectedIndex(new Date().getDate());
         cbxMes.setSelectedIndex(new Date().getMonth()+1);
         cbxAno.setSelectedIndex(1);
         
        
    }
    
    
    
    /**
     *
     * @param valorMes
     * @return
     */
    public boolean verificaData(int valorMes){
        if (valorMes == 2) { //Fevereiro
            boolean leapYear = new GregorianCalendar().isLeapYear(new Date().getYear() + 1900);
            if((!leapYear) && cbxDia.getSelectedIndex() >=29){
                JOptionPane.showMessageDialog(rootPane, "Data inválida, o mês de Fevereiro só possui 28 dias !");
                return true;
            }
            
        }else if (valorMes == 4 ) {//Abril
            if(cbxDia.getSelectedIndex() >= 31){
                JOptionPane.showMessageDialog(rootPane, "Data inválida, o mês de Abril só possui 30 dias !");
                return true;
            }
        }else if (valorMes == 6) {//junho
            if(cbxDia.getSelectedIndex() >= 31){
                JOptionPane.showMessageDialog(rootPane, "Data inválida, o mês de Junho só possui 30 dias !");
                return true;
            }
        }else if (valorMes == 9) {//Setembro
            if(cbxDia.getSelectedIndex() >= 31){
                JOptionPane.showMessageDialog(rootPane, "Data inválida, o mês de Setembro só possui 30 dias !");
                return true;
            }
        }else if (valorMes == 11) {//Novembro
            if(cbxDia.getSelectedIndex() >= 31){
                JOptionPane.showMessageDialog(rootPane, "Data inválida, o mês de Novembro só possui 30 dias !");
                return true;
            }
        }
        return false;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbxCompraProduto = new javax.swing.JComboBox();
        cbxCompraFuncionario = new javax.swing.JComboBox();
        lblQuantidade = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        lblDataVenda = new javax.swing.JLabel();
        cbxDia = new javax.swing.JComboBox();
        cbxMes = new javax.swing.JComboBox();
        cbxAno = new javax.swing.JComboBox();
        lblValorVenda = new javax.swing.JLabel();
        txtVenda = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbxCompraPagamento = new javax.swing.JComboBox();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblCampoObrigatorio = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("LANÇAMENTO DE COMPRA");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(228, 228, 228));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nova Compra", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Funcionário*:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Produto*:");

        cbxCompraProduto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxCompraProduto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxCompraFuncionario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxCompraFuncionario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblQuantidade.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblQuantidade.setText("Quantidade* :");

        txtQuantidade.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblDataVenda.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDataVenda.setText("Data da Compra* :");

        cbxDia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxDia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxMes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxMes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxAno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxAno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblValorVenda.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblValorVenda.setText("Valor da Compra* :");

        txtVenda.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Pagamento*:");

        cbxCompraPagamento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxCompraPagamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblQuantidade)
                        .addGap(18, 18, 18)
                        .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(lblValorVenda)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbxCompraPagamento, 0, 189, Short.MAX_VALUE)
                            .addComponent(cbxCompraFuncionario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblDataVenda)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbxDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbxMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbxAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 20, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxCompraProduto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(225, 225, 225))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxCompraProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxCompraFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDataVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxDia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxMes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxAno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxCompraPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblValorVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        btnSalvar.setBackground(new java.awt.Color(239, 239, 239));
        btnSalvar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/tcc/Presentation/icones/salvar.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalvarMouseClicked(evt);
            }
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

        lblCampoObrigatorio.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        lblCampoObrigatorio.setText("*Campo Obrigatório");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCampoObrigatorio)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblCampoObrigatorio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
private boolean validaDataCadastroAgenda(Date d){
                Date dataTmp1 = new Date();

                dataTmp1.setDate(Integer.parseInt((String) cbxDia.getSelectedItem()));
                //dataTmp1.setHours(Integer.parseInt((String) cbxHora.getSelectedItem()));
               // dataTmp1.setMinutes(Integer.parseInt((String) cbxMinuto.getSelectedItem()));

                //JOptionPane.showMessageDialog(rootPane, cbxMes.getSelectedItem().toString());
                int mes1 = Integer.parseInt(cbxMes.getSelectedItem().toString());
                mes1--;
                dataTmp1.setMonth(mes1);
                dataTmp1.setYear( cbxAno.getSelectedIndex());
                
                //ajustando a data
                d.setYear(d.getYear()+1900);
                //JOptionPane.showMessageDialog(rootPane, dataTmp1.getYear());
                //JOptionPane.showMessageDialog(rootPane, dataTmp1.getMonth());
                //JOptionPane.showMessageDialog(rootPane, dataTmp1.getDate());
        return dataTmp1.after(d);
                
    
    }

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
        
        if (cbxCompraFuncionario.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Preencha o Funcionário");
        } else if (cbxCompraProduto.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Preencha o Produto");
        } else if (cbxCompraPagamento.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Preencha a Forma de Pagamento");
        } else if (cbxDia.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Preencha o Dia");
        } else if (cbxMes.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Preencha o Mês");
        } else if (cbxAno.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Preencha o Ano");
        } else if (txtQuantidade.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Preencha a Quantidade");
        } else if (txtVenda.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Preencha o Valor da Compra");
        }else if (verificaData(cbxMes.getSelectedIndex())){
            //nao faz nada
        }
        
        else if(validaDataCadastroAgenda(new Date())){
             JOptionPane.showMessageDialog(rootPane, "Não é possível cadastrar compra com data superior à atual");
        }
        
        else if (JOptionPane.showConfirmDialog(rootPane, "Você tem certeza que deseja salvar a Compra? ",
               "Confirmação",JOptionPane.OK_CANCEL_OPTION) == 0){
           
           Compra compra = new Compra();
           Funcionario funcionario = new Funcionario();
           Produto produto = new Produto();
          // FormaDePagamento pagamento = new FormaDePagamento();
           
           CompraDAO dao = new CompraDAO();
          
           funcionario = (Funcionario) cbxCompraFuncionario.getSelectedItem();
           produto = (Produto) cbxCompraProduto.getSelectedItem();
           
           compra.setFuncionario(funcionario);
           compra.setProduto(produto);
           compra.setFormaDePagamento((FormaDePagamento) cbxCompraPagamento.getSelectedItem());
           
           compra.setQuantidade(Integer.parseInt(txtQuantidade.getText()));
           compra.setValor(Double.parseDouble(txtVenda.getText()));
           
           Date dataCompra = new Date();
           
           dataCompra.setDate(Integer.parseInt((String)cbxDia.getSelectedItem()));
           int mes = Integer.parseInt(cbxMes.getSelectedItem().toString());
           mes--;
           dataCompra.setMonth(mes);
           dataCompra.setYear(Integer.parseInt((String)cbxAno.getSelectedItem().toString()));
           
           //hora e minutos
           dataCompra.setHours(new Date().getHours());
           dataCompra.setMinutes(new Date().getMinutes());
           
           compra.setDataCompra(dataCompra);
           
           
           if(dao.Salvar(compra)){
                    ProdutoDAO daoProduto = new ProdutoDAO();
                    daoProduto.AtualizarEstoque(produto, compra.getQuantidade());
                    JOptionPane.showMessageDialog(rootPane,"Compra Salvo com Sucesso!");
                    janelaPai.listaCompra = dao.ListarTodos();
                    janelaPai.preencheTabela();
                    this.dispose();
                    
                }else{
                    JOptionPane.showMessageDialog(rootPane, "Erro ao salvar o Compra!");
                }
            }
       
       
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
           if (JOptionPane.showConfirmDialog(rootPane, "Você tem certeza que deseja cancelar?", "Confirmação", JOptionPane.OK_CANCEL_OPTION) == 0) {
            this.dispose();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalvarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarMouseEntered
       Color minhaCor = new Color(115,183,253);
        this.btnSalvar.setBackground(minhaCor);
    }//GEN-LAST:event_btnSalvarMouseEntered

    private void btnSalvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalvarMouseClicked

    private void btnSalvarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarMouseExited
        Color minhaCor = new Color(239,239,239);
        this.btnCancelar.setBackground(minhaCor);
    }//GEN-LAST:event_btnSalvarMouseExited

    private void btnCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseEntered
        Color minhaCor = new Color(115,183,253);
        this.btnCancelar.setBackground(minhaCor);
    }//GEN-LAST:event_btnCancelarMouseEntered

    private void btnCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseExited
       Color minhaCor = new Color(239,239,239);
        this.btnCancelar.setBackground(minhaCor);
    }//GEN-LAST:event_btnCancelarMouseExited

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox cbxAno;
    private javax.swing.JComboBox cbxCompraFuncionario;
    private javax.swing.JComboBox cbxCompraPagamento;
    private javax.swing.JComboBox cbxCompraProduto;
    private javax.swing.JComboBox cbxDia;
    private javax.swing.JComboBox cbxMes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCampoObrigatorio;
    private javax.swing.JLabel lblDataVenda;
    private javax.swing.JLabel lblQuantidade;
    private javax.swing.JLabel lblValorVenda;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JTextField txtVenda;
    // End of variables declaration//GEN-END:variables
}
