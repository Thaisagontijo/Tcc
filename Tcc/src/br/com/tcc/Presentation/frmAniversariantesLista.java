/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.tcc.Presentation;

import br.com.tcc.DataAccess.ClienteDAO;
import br.com.tcc.DomainModel.Cliente;
import java.awt.Color;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Thaisa
 */
public class frmAniversariantesLista extends javax.swing.JDialog {

    /**
     * Creates new form frmAniversariantesLista
     */
    private ClienteDAO daoCliente = new ClienteDAO();
    public frmAniversariantesLista(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
         Color minhaCor = new Color(239,239,239);
        this.getContentPane().setBackground(minhaCor);
        lista = daoCliente.ListarTodos();
        preencheTabela();
        this.setTitle("LISTA DE ANIVERSARIANTES DO MÊS");
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
        model.addColumn("DATA DE NASCIMENTO");
        model.addColumn("TELEFONE");
        model.addColumn("CELULAR");
        
        
       
        
          for (Cliente s : lista) {
              if (s.getDataNascimento().getMonth() == new Date().getMonth() ) {
                  Vector v = new Vector();

                  v.add(0, s.getId());
                  v.add(1, s.getNome());
                  String data;
                  data = s.getDataNascimento().getDate()+ "/"+(s.getDataNascimento().getMonth() +1)+"/"+(s.getDataNascimento().getYear()+ 1900);
                
                  v.add(2,data);
                  
                  
                  v.add(3, s.getTelefone());
                  v.add(4, s.getCelular());
                  

                  model.addRow(v);
              }

          }

        tblAniversariantes.setModel(model);
        tblAniversariantes.repaint();
        tblAniversariantes.setAutoCreateRowSorter(true);
        

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
        tblAniversariantes = new javax.swing.JTable();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(228, 228, 228));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Aniversariantes do Mês", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tblAniversariantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblAniversariantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAniversariantesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAniversariantes);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 15, Short.MAX_VALUE))
        );

        btnSair.setBackground(new java.awt.Color(239, 239, 239));
        btnSair.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSair.setText("Sair");
        btnSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSairMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSairMouseEntered(evt);
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblAniversariantesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAniversariantesMouseClicked
       
                /*
         * PEGANDO O OBJETO SELECIONADO NA TABELA COM 1 CLIQUE
         
         */
        //  tblServicos.isCellEditable(tblServicos.getSelectedRow(), tblServicos.getSelectedColumn());
        
        
        if(idSelecionadoTabela == tblAniversariantes.getSelectedRow()){ //se está clicando na mesma linha
            qtdCliques++;
            if(qtdCliques == 2){
             //   JOptionPane.showMessageDialog(rootPane, "chama a descricao");
                /*
                    CHAMA O FORMULARIO DE CADASTROMCOM OS CAMPOS INATIVOS
                */
                
                frmCadastroCliente janela = 
                        new frmCadastroCliente(null, rootPaneCheckingEnabled, this, true);
                janela.setLocationRelativeTo(null);
                janela.setVisible(rootPaneCheckingEnabled);
                
                
                qtdCliques =0;
            }
        }else {
            qtdCliques= 1;
        }
        
        idSelecionadoTabela = tblAniversariantes.getSelectedRow();
        objSelecionadoNaTabela = lista.get(idSelecionadoTabela);
        

    }//GEN-LAST:event_tblAniversariantesMouseClicked

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnSairMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSairMouseEntered
        Color minhaCor = new Color(115,183,253);
        this.btnSair.setBackground(minhaCor);
    }//GEN-LAST:event_btnSairMouseEntered

    private void btnSairMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSairMouseExited
        Color minhaCor = new Color(239,239,239);
        this.btnSair.setBackground(minhaCor);
    }//GEN-LAST:event_btnSairMouseExited

    private int idSelecionadoTabela;
    protected Cliente objSelecionadoNaTabela;
    private int qtdCliques;
    private List<Cliente> lista;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSair;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAniversariantes;
    // End of variables declaration//GEN-END:variables
}
