/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.Presentation;

import br.com.tcc.DataAccess.ClienteDAO;
import br.com.tcc.DomainModel.Cliente;
import java.awt.Color;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Thaisa
 */
public class frmClienteLista extends javax.swing.JDialog {

    /**
     * Creates new form frmCadastroServicosLista
     */
    public frmClienteLista(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        
        initComponents();
       dao = new ClienteDAO();
       lista = new LinkedList<>();
       this.setTitle("Lista de Clientes");
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
        model.addColumn("CPF");
        model.addColumn("RG");
        model.addColumn("DATA DE NASCIMENTO");
       
        
        for(Cliente p : lista){
            Vector v = new Vector();
            v.add(0,p.getId());
            v.add(1,p.getNome());
            v.add(2,p.getCpf());
            v.add(3,p.getRg());
            v.add(4,p.getDataNascimento());
                   
            model.addRow(v);
        
        }
        
        tblCliente.setModel(model);
        tblCliente.repaint();
        

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
        tblCliente = new javax.swing.JTable();
        btnNovo = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        lblFiltro = new javax.swing.JLabel();
        txtFiltro = new javax.swing.JTextField();
        cbxFiltro = new javax.swing.JComboBox();
        btnFiltrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        painelServicosCadastrados.setBackground(new java.awt.Color(228, 228, 228));
        painelServicosCadastrados.setBorder(javax.swing.BorderFactory.createTitledBorder("Funcionários Cadastrados"));

        tblCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClienteMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblCliente);

        javax.swing.GroupLayout painelServicosCadastradosLayout = new javax.swing.GroupLayout(painelServicosCadastrados);
        painelServicosCadastrados.setLayout(painelServicosCadastradosLayout);
        painelServicosCadastradosLayout.setHorizontalGroup(
            painelServicosCadastradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelServicosCadastradosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 826, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        painelServicosCadastradosLayout.setVerticalGroup(
            painelServicosCadastradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelServicosCadastradosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnNovo.setBackground(new java.awt.Color(239, 239, 239));
        btnNovo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/tcc/Presentation/icones/Novo.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.setToolTipText("Novo Funcionário");
        btnNovo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNovoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNovoMouseExited(evt);
            }
        });
        btnNovo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnNovoMouseMoved(evt);
            }
        });
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnAlterar.setBackground(new java.awt.Color(239, 239, 239));
        btnAlterar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/tcc/Presentation/icones/alterar.png"))); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.setToolTipText("Alterar dados do Funcionário");
        btnAlterar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAlterarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAlterarMouseExited(evt);
            }
        });
        btnAlterar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnAlterarMouseMoved(evt);
            }
        });
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnExcluir.setBackground(new java.awt.Color(239, 239, 239));
        btnExcluir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/tcc/Presentation/icones/excluir.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.setToolTipText("Excluir Funcionário");
        btnExcluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnExcluirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExcluirMouseExited(evt);
            }
        });
        btnExcluir.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnExcluirMouseMoved(evt);
            }
        });
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
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
        btnSair.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnSairMouseMoved(evt);
            }
        });
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        lblFiltro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblFiltro.setText("Filtro:");

        txtFiltro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        cbxFiltro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxFiltro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nenhum", "Id", "Nome" }));
        cbxFiltro.setToolTipText("Filtro");

        btnFiltrar.setBackground(new java.awt.Color(239, 239, 239));
        btnFiltrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnFiltrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/tcc/Presentation/icones/filtro.png"))); // NOI18N
        btnFiltrar.setText("Filtrar");
        btnFiltrar.setToolTipText("Listar Funcionários");
        btnFiltrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnFiltrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnFiltrarMouseExited(evt);
            }
        });
        btnFiltrar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnFiltrarMouseMoved(evt);
            }
        });
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
                        .addContainerGap()
                        .addComponent(lblFiltro)
                        .addGap(18, 18, 18)
                        .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(103, 103, 103)
                        .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(108, 108, 108)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(painelServicosCadastrados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFiltro)
                    .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(painelServicosCadastrados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
       
        /*Botão salvar*/
        frmCadastroCliente a = new frmCadastroCliente(null,rootPaneCheckingEnabled, this,true);
       
        //JDialog a = new JDialog
        a.setLocationRelativeTo(null);
       a.setVisible(rootPaneCheckingEnabled);
       
    }//GEN-LAST:event_btnNovoActionPerformed

    private void tblClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClienteMouseClicked
        
        /*
         * PEGANDO O OBJETO SELECIONADO NA TABELA COM 1 CLIQUE
         
         */
      //  tblServicos.isCellEditable(tblServicos.getSelectedRow(), tblServicos.getSelectedColumn());
        
        
        if(idSelecionadoTabela == tblCliente.getSelectedRow()){ //se está clicando na mesma linha
            qtdCliques++;
            if(qtdCliques == 2){
                JOptionPane.showMessageDialog(rootPane, "chama a descricao");
                qtdCliques =0;
            }
        }else {
            qtdCliques= 1;
        }
        
        idSelecionadoTabela = tblCliente.getSelectedRow();
        objSelecionadoNaTabela = lista.get(idSelecionadoTabela);
        
        //JOptionPane.showMessageDialog(rootPane,objSelecionadoNaTabela.getNome());
        
        
        
    }//GEN-LAST:event_tblClienteMouseClicked

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
         if(objSelecionadoNaTabela != null){
              if(JOptionPane.showConfirmDialog(rootPane, "Você Tem certeza que deseja"
                    + " excluir o Cliente ?", "Confirmação",JOptionPane.OK_CANCEL_OPTION) == 0){

                if(dao.Apagar(objSelecionadoNaTabela)){
                    JOptionPane.showMessageDialog(rootPane, "Cliente Apagado com sucesso !");
                    lista.clear();
                    lista = dao.ListarTodos();
                    preencheTabela();
                }else{
                    JOptionPane.showMessageDialog(rootPane, "Erro ao apagar o Cliente");
                }
            }
         }else{
             JOptionPane.showMessageDialog(rootPane, "Nenhum item Selecionado na lista !");
         }
        
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        if(objSelecionadoNaTabela != null){
            frmCadastroCliente j = new frmCadastroCliente(null, rootPaneCheckingEnabled, this,false);
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
            Cliente s = new Cliente();
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
            Cliente s = new Cliente();
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

    private void btnNovoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNovoMouseMoved
       //  this.btnNovo.setBackground(Color.BLUE); 
       //  this.btnNovo.setForeground(Color.white); 
    }//GEN-LAST:event_btnNovoMouseMoved

    private void btnNovoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNovoMouseExited
        Color minhaCor = new Color(239,239,239);
        this.btnNovo.setBackground(minhaCor);
    }//GEN-LAST:event_btnNovoMouseExited

    private void btnAlterarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlterarMouseMoved
      // this.btnAlterar.setBackground(Color.BLUE); 
       //this.btnAlterar.setForeground(Color.white);
    }//GEN-LAST:event_btnAlterarMouseMoved

    private void btnAlterarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlterarMouseExited
        Color minhaCor = new Color(239,239,239);
        this.btnAlterar.setBackground(minhaCor);
    }//GEN-LAST:event_btnAlterarMouseExited

    private void btnExcluirMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExcluirMouseMoved
      // this.btnExcluir.setBackground(Color.BLUE); 
      // this.btnExcluir.setForeground(Color.white);
    }//GEN-LAST:event_btnExcluirMouseMoved

    private void btnExcluirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExcluirMouseExited
        Color minhaCor = new Color(239,239,239);
        this.btnExcluir.setBackground(minhaCor);
    }//GEN-LAST:event_btnExcluirMouseExited

    private void btnSairMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSairMouseMoved
      // this.btnSair.setBackground(Color.BLUE); 
      // this.btnSair.setForeground(Color.white);
    }//GEN-LAST:event_btnSairMouseMoved

    private void btnSairMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSairMouseExited
        Color minhaCor = new Color(239,239,239);
        this.btnSair.setBackground(minhaCor);
    }//GEN-LAST:event_btnSairMouseExited

    private void btnFiltrarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFiltrarMouseMoved
      // this.btnFiltrar.setBackground(Color.BLUE); 
       //this.btnFiltrar.setForeground(Color.white);
    }//GEN-LAST:event_btnFiltrarMouseMoved

    private void btnFiltrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFiltrarMouseExited
        Color minhaCor = new Color(239,239,239);
        this.btnFiltrar.setBackground(minhaCor);
    }//GEN-LAST:event_btnFiltrarMouseExited

    private void btnNovoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNovoMouseEntered
        Color minhaCor = new Color(115,183,253);
        this.btnNovo.setBackground(minhaCor);
    }//GEN-LAST:event_btnNovoMouseEntered

    private void btnAlterarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlterarMouseEntered
        Color minhaCor = new Color(115,183,253);
        this.btnAlterar.setBackground(minhaCor);        // TODO add your handling code here:
    }//GEN-LAST:event_btnAlterarMouseEntered

    private void btnExcluirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExcluirMouseEntered
         Color minhaCor = new Color(115,183,253);
        this.btnExcluir.setBackground(minhaCor);
    }//GEN-LAST:event_btnExcluirMouseEntered

    private void btnSairMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSairMouseEntered
        Color minhaCor = new Color(115,183,253);
        this.btnSair.setBackground(minhaCor);
    }//GEN-LAST:event_btnSairMouseEntered

    private void btnFiltrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFiltrarMouseEntered
        Color minhaCor = new Color(115,183,253);
        this.btnFiltrar.setBackground(minhaCor);
    }//GEN-LAST:event_btnFiltrarMouseEntered
    
    
                                   

    /*
     
     
     * OUTRAS VARIAVEIS
     
     */
    
    private int idSelecionadoTabela;
    protected List<Cliente> lista;
    protected Cliente objSelecionadoNaTabela;
    protected ClienteDAO dao;
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
    private javax.swing.JTable tblCliente;
    private javax.swing.JTextField txtFiltro;
    // End of variables declaration//GEN-END:variables
}
