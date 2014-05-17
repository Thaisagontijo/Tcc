/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.tcc.Presentation;

import br.com.tcc.DataAccess.DepositoDAO;
import br.com.tcc.DataAccess.VendaDAO;
import br.com.tcc.DomainModel.Deposito;
import br.com.tcc.DomainModel.Venda;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Anderson
 */
public class frmPagamentoFaturaCliente extends javax.swing.JDialog {

    /**
     * Creates new form frmListaVendasCliente
     */
    private List<Venda> listaVendas;
    private frmMenuPrincipal janelaPai;
    public frmPagamentoFaturaCliente(java.awt.Frame parent, boolean modal, List<Venda> vendas, frmMenuPrincipal janelaPai) {
        super(parent, modal);
        initComponents();
        
        this.janelaPai = janelaPai;
         listaVendas = vendas;
        vendasAPrazo();
        preencheTabelaCliente();
    }
    
    public void vendasAPrazo(){
        List <Venda> tmp = new LinkedList<>();
        for(Venda v:listaVendas){
            if(v.getFormaDePagamento().getId().intValue() == 2){
                tmp.add(v);
            }
        }
        
        listaVendas = tmp;
    
    }
    
    
    
    
    /*PREENCHIMENTO DA TABELA*/
    
    protected void preencheTabelaCliente() {
        
          
        
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
        model.addColumn("DATA/HORA");
        model.addColumn("VALOR");
        model.addColumn("FORMA DE PAGAMENTO");
        model.addColumn("CAIXA");

        for (Venda ve : listaVendas) {
            Vector v = new Vector();
            v.add(0, ve.getId());
            
            String data = "";
            data = ve.getDataHora().getDate() + "/" + (ve.getDataHora().getMonth() + 1) + "/"
                    + ve.getDataHora().getYear() + " às " + ve.getDataHora().getHours() + ":" + ve.getDataHora().getMinutes();
            v.add(1, data);
            v.add(2, ve.getValorVenda());
            v.add(3, ve.getFormaDePagamento().getNome());
            v.add(4, ve.getFuncionario().getNome());

            model.addRow(v);

        }

        tblClientes.setModel(model);
        tblClientes.repaint();

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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        btnReceber = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lista de Vendas à prazo");

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblClientes);

        btnReceber.setText("Receber");
        btnReceber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReceberActionPerformed(evt);
            }
        });

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(202, 202, 202)
                        .addComponent(btnReceber, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReceber, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientesMouseClicked
       int id = tblClientes.getSelectedRow();
       objetoSelecionadoNaTabela = listaVendas.get(id);
        
       
    }//GEN-LAST:event_tblClientesMouseClicked

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnReceberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReceberActionPerformed
        try {
            float valorRecebido = Float.parseFloat(JOptionPane.showInputDialog("Informe o valor:"));
            if (valorRecebido < objetoSelecionadoNaTabela.getValorVenda()) {
                JOptionPane.showMessageDialog(rootPane, "Valor Inferior ao valor de compra !");

            } else {
                VendaDAO daoVendastmp = new VendaDAO();
                Deposito novo = new Deposito();
                DepositoDAO daoDeposito = new DepositoDAO();

                novo.setCaixa(janelaPai.caixa);
                novo.setDataHora(new Date());
                novo.setFuncionario(janelaPai.usuarioLogado.getFuncionario());
                novo.setObservacao("Recebimento relativo a venda id= " + objetoSelecionadoNaTabela.getId());
                novo.setValor(valorRecebido);
                janelaPai.caixa.addDeposito(novo);

                //novo.set
                objetoSelecionadoNaTabela.setStatus(true);
                if (daoVendastmp.Salvar(objetoSelecionadoNaTabela) && daoDeposito.Salvar(novo)) {
                    JOptionPane.showMessageDialog(rootPane, "Venda recebida com sucesso! ");
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Erro ao salvar a venda! ");
                }

            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(rootPane, "Valor Inválido!");
        }
    }//GEN-LAST:event_btnReceberActionPerformed

    private Venda objetoSelecionadoNaTabela;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReceber;
    private javax.swing.JButton btnSair;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblClientes;
    // End of variables declaration//GEN-END:variables
}