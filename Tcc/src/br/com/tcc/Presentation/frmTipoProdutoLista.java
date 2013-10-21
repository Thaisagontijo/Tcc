/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.Presentation;

import br.com.tcc.DataAccess.TipoProdutoDAO;
import br.com.tcc.DomainModel.TipoProduto;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Thaisa
 */
public class frmTipoProdutoLista extends javax.swing.JDialog {

    /**
     * Creates new form frmCadastroServicosLista
     */
    public frmTipoProdutoLista(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        
        initComponents();
       dao = new TipoProdutoDAO();
       lista = new LinkedList<>();
       this.setTitle("Lista de Tipos de Produto");
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
        
        
        for(TipoProduto s : lista){
            Vector v = new Vector();
            v.add(0,s.getId());
            v.add(1,s.getNome());
                   
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

        painelServicosCadastrados = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblServicos = new javax.swing.JTable();
        btnNovo = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        lblFiltro = new javax.swing.JLabel();
        txtFiltro = new javax.swing.JTextField();
        cbxFiltro = new javax.swing.JComboBox();
        btnFiltrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lista de Formas de Pagamento");

        painelServicosCadastrados.setBorder(javax.swing.BorderFactory.createTitledBorder("Produtos Cadastrados"));

        tblServicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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

        javax.swing.GroupLayout painelServicosCadastradosLayout = new javax.swing.GroupLayout(painelServicosCadastrados);
        painelServicosCadastrados.setLayout(painelServicosCadastradosLayout);
        painelServicosCadastradosLayout.setHorizontalGroup(
            painelServicosCadastradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelServicosCadastradosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 836, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        painelServicosCadastradosLayout.setVerticalGroup(
            painelServicosCadastradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelServicosCadastradosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        lblFiltro.setText("Filtro:");

        cbxFiltro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nenhum", "Id", "Nome" }));
        cbxFiltro.setToolTipText("Filtro");

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
                .addComponent(painelServicosCadastrados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 32, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(btnNovo)
                        .addGap(124, 124, 124)
                        .addComponent(btnAlterar)
                        .addGap(87, 87, 87)
                        .addComponent(btnExcluir)
                        .addGap(80, 80, 80)
                        .addComponent(btnSair))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblFiltro)
                        .addGap(18, 18, 18)
                        .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92)
                        .addComponent(cbxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(btnFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFiltro)
                    .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFiltrar))
                .addGap(26, 26, 26)
                .addComponent(painelServicosCadastrados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnAlterar)
                    .addComponent(btnExcluir)
                    .addComponent(btnSair))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
       
        /*Botão salvar*/
      frmTipoProdutoCadastroEdicao b = new frmTipoProdutoCadastroEdicao(null,rootPaneCheckingEnabled, this,true);
        //JDialog a = new JDialog
      b.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_btnNovoActionPerformed

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
        objSelecionadoNaTabela = lista.get(idSelecionadoTabela);
        
        //JOptionPane.showMessageDialog(rootPane,objSelecionadoNaTabela.getNome());
        
        
        
    }//GEN-LAST:event_tblServicosMouseClicked

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
         if(objSelecionadoNaTabela != null){
              if(JOptionPane.showConfirmDialog(rootPane, "Você Tem certeza que deseja"
                    + " excluir o Tipo de Produto ?", "Confirmação",JOptionPane.OK_CANCEL_OPTION) == 0){

                if(dao.Apagar(objSelecionadoNaTabela)){
                    JOptionPane.showMessageDialog(rootPane, "Tipo de Produto Apagado com sucesso !");
                    lista.clear();
                    lista = dao.ListarTodos();
                    preencheTabela();
                }else{
                    JOptionPane.showMessageDialog(rootPane, "Erro ao apagar o Tipo de Produto");
                }
            }
         }else{
             JOptionPane.showMessageDialog(rootPane, "Nenhum item Selecionado na lista !");
         }
        
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        if(objSelecionadoNaTabela != null){
            frmTipoProdutoCadastroEdicao j = new frmTipoProdutoCadastroEdicao(null, rootPaneCheckingEnabled, this,false);
            j.setVisible(rootPaneCheckingEnabled);
        }else{
            JOptionPane.showMessageDialog(rootPane, "Nenhum item Selecionado na lista !");
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        if(cbxFiltro.getSelectedIndex() == 0){
            /* SE NAO TIVER FILTRO MOSTRA TODOS*/
            lista.clear();
            lista = dao.ListarTodos();
            preencheTabela();
           
            
        }else if(cbxFiltro.getSelectedIndex() == 1){
            /* SE O FILTRO FOR POR ID*/
            TipoProduto s = new TipoProduto();
            try{
                s.setId(Long.parseLong(txtFiltro.getText()));
                lista.clear();
                lista = dao.Buscar(s);
                preencheTabela();
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(rootPane, "ID Inválido !");
            }
            
            
           
        }else if(cbxFiltro.getSelectedIndex() == 2){
            /* SE NAO TIVER FILTRO FOR POR NOME*/
            TipoProduto s = new TipoProduto();
           try{
                s.setNome(txtFiltro.getText());
                 lista.clear();
                 lista = dao.Buscar(s);
                 preencheTabela();
           }catch(NumberFormatException ex){
               JOptionPane.showMessageDialog(rootPane, "Nome Inválido !");
           }
           
            
        }
    }//GEN-LAST:event_btnFiltrarActionPerformed
    
    /*
     
     
     * OUTRAS VARIAVEIS
     
     */
    
    private int idSelecionadoTabela;
    protected List<TipoProduto> lista;
    protected TipoProduto objSelecionadoNaTabela;
    protected TipoProdutoDAO dao;
    private int qtdCliques;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSair;
    private javax.swing.JComboBox cbxFiltro;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblFiltro;
    private javax.swing.JPanel painelServicosCadastrados;
    private javax.swing.JTable tblServicos;
    private javax.swing.JTextField txtFiltro;
    // End of variables declaration//GEN-END:variables
}
