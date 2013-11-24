/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.tcc.Presentation;

import br.com.tcc.DataAccess.CompraDAO;
import br.com.tcc.DataAccess.FuncionarioDAO;
import br.com.tcc.DataAccess.ProdutoDAO;
import br.com.tcc.DomainModel.Compra;
import br.com.tcc.DomainModel.Funcionario;
import br.com.tcc.DomainModel.Produto;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Thaisa
 */

public class frmListarCompras extends javax.swing.JDialog {

    /**
     * Creates new form frmListarCompras
     */
    private frmMenuPrincipal janelaPai;
    private boolean descricao;
    private List<Compra> listaCompra;
    public frmListarCompras(java.awt.Frame parent, boolean modal, frmMenuPrincipal janelaPai, boolean descricao) {
        super(parent, modal);
        initComponents();
        this.janelaPai = janelaPai;
        this.descricao = descricao;
       
        CompraDAO dao = new CompraDAO();
        Compra compra = new Compra();
        
        listaCompra = dao.ListarTodos();
        cbxFiltro.removeAllItems();
        cbxFiltro.addItem("NENHUM");
        cbxFiltro.addItem("ID");     
        
        //cbxFiltro.addItem("DATA");
        txtFiltro.setVisible(true);
        
        preencheTabela();
        
    }
    
     protected void preencheTabela(){
        
          
        DefaultTableModel model = new DefaultTableModel(){
            @Override  
          public boolean isCellEditable(int row, int col){   
                 return false;   
          }   
        };
        
        model.addColumn("ID");
        model.addColumn("PRODUTO");
        model.addColumn("FUNCIONARIO");
        model.addColumn("DATA");
        model.addColumn("QTD");
        model.addColumn("VALOR");
       
        ProdutoDAO daoP = new ProdutoDAO();
         FuncionarioDAO daoF = new FuncionarioDAO();
        for(Compra c : listaCompra){
            
            Produto p = new Produto();
            Funcionario f = new Funcionario();
            
            Vector v = new Vector();
            v.add(0,c.getId());
            p = daoP.Abrir(c.getProduto().getId());
            v.add(1, p.getNome());
            
            f = daoF.Abrir(c.getFuncionario().getId());
            v.add(2, f.getNome());
            
            String data = "";
            data = c.getDataCompra().getDate()+ "/"+(c.getDataCompra().getMonth() +1)+"/"+c.getDataCompra().getYear();
            v.add(3,data);
            v.add(4, c.getQuantidade());
            v.add(5, c.getValor());
            
                   
            model.addRow(v);
        
        }
        
        tblCompras.setModel(model);
        tblCompras.repaint();
        

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
        tblCompras = new javax.swing.JTable();
        btnNovo = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtFiltro = new javax.swing.JTextField();
        cbxFiltro = new javax.swing.JComboBox();
        btnFiltrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Compras cadastradas"));

        tblCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblCompras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblComprasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCompras);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        jLabel1.setText("Filtro");

        cbxFiltro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnFiltrar.setText("Filtrar");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(btnNovo)
                        .addGap(18, 18, 18)
                        .addComponent(btnSair))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnFiltrar)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFiltrar))
                .addGap(37, 37, 37)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnSair))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        // TODO add your handling code here:
        frmCadastroCompra janela = new frmCadastroCompra(null,rootPaneCheckingEnabled, this, false);
        janela.setLocationRelativeTo(null);
        janela.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        // TODO add your handling code here:
        Compra compra = new Compra();
        CompraDAO dao = new CompraDAO();
        
         //objSelecionadoNaTabela = null;
        if(cbxFiltro.getSelectedIndex() == 0){
            
            /* SE NAO TIVER FILTRO MOSTRA TODOS*/
            listaCompra.clear();
            listaCompra = dao.ListarTodos();
            preencheTabela();
           
            
        }else if(cbxFiltro.getSelectedIndex() == 1){
            /* SE O FILTRO FOR POR ID*/
            try{
                compra.setId(Long.parseLong(txtFiltro.getText()));
                
                listaCompra.clear();
                listaCompra = dao.Buscar(compra);
                preencheTabela();
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(rootPane, "ID Inválido!");
            }
        }
        
        /*else if(cbxFiltro.getSelectedIndex() == 2){
           // SE NAO TIVER FILTRO FOR POR NOME
                     
           Compra c = new Compra();
           try{
               
                 c.setValor(Double.parseDouble(txtFiltro.getText()));
                 listaCompra.clear();
                 listaCompra = dao.Buscar(compra);
                 preencheTabela();
           }catch(NumberFormatException ex){
               JOptionPane.showMessageDialog(rootPane, "Data Inválido!");
           }
        } */
    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void tblComprasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblComprasMouseClicked
      
    }//GEN-LAST:event_tblComprasMouseClicked



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSair;
    private javax.swing.JComboBox cbxFiltro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCompras;
    private javax.swing.JTextField txtFiltro;
    // End of variables declaration//GEN-END:variables
}
