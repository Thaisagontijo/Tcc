/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.Presentation;

import br.com.tcc.DomainModel.TipoProduto;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author thaisa
 */
public class frmTipoProdutoCadastroEdicao extends javax.swing.JDialog {

    /**
     * Creates new form frmCadastroServicosCadastroEdicao
     * 
     * 
     * NO CONSTRUTOR SE FOR TRUE É CADASTRO DE NOVO SERVICO SE FALSE É EDICAO
     * 
     */
    private frmTipoProdutoLista janelaPai;
    public frmTipoProdutoCadastroEdicao(java.awt.Frame parent, boolean modal, frmTipoProdutoLista janelaPai, boolean cadastro) {
       super(parent, modal);
        
        initComponents();
        this.janelaPai = janelaPai;
       
        
        if(cadastro ==  true){
            this.setTitle("CADASTRO DE TIPO DE PRODUTO");
            //System.out.println("verdade");
        }else{
            this.setTitle("EDIÇÃO DE TIPO DE PRODUTO");
            //System.out.println("false");
            /*setando valores recebidos da janela pai aos campos*/
            
            txtNome.setText(janelaPai.objSelecionadoNaTabela.getNome());
            
            
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
        txtNome = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        painelNovoServico.setBackground(new java.awt.Color(228, 228, 228));
        painelNovoServico.setBorder(javax.swing.BorderFactory.createTitledBorder("Novo Tipo de Produto"));

        lblNome.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNome.setText("Nome* :");

        txtNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout painelNovoServicoLayout = new javax.swing.GroupLayout(painelNovoServico);
        painelNovoServico.setLayout(painelNovoServicoLayout);
        painelNovoServicoLayout.setHorizontalGroup(
            painelNovoServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelNovoServicoLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblNome)
                .addGap(18, 18, 18)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(97, Short.MAX_VALUE))
        );
        painelNovoServicoLayout.setVerticalGroup(
            painelNovoServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelNovoServicoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelNovoServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        btnSalvar.setBackground(new java.awt.Color(239, 239, 239));
        btnSalvar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/tcc/Presentation/icones/salvar.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setToolTipText("Salvar Tipo de Produto");
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(191, 191, 191))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelNovoServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelNovoServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
      
               
        /*Botão salvar*/
        
        if(txtNome.getText().isEmpty()){
           JOptionPane.showMessageDialog(rootPane, "O Campo nome deve ser Preenchido !");
       }else if (JOptionPane.showConfirmDialog(rootPane, "Você tem certeza que deseja salvar o Tipo de Produto ",
               "Confirmação",JOptionPane.OK_CANCEL_OPTION) == 0){
           
                TipoProduto novoTipo= new TipoProduto();

            /*CAPTURANDO ENTRADA DE DADOS DO JDIALOG E VALIDANDO*/
                        
            
            novoTipo.setNome(txtNome.getText());
           
           

                if(janelaPai.dao.Salvar(novoTipo)){
                    JOptionPane.showMessageDialog(rootPane, "Tipo de Produto Salvo com Sucesso !");
                    txtNome.setText("");
                    janelaPai.lista.clear();
                    janelaPai.lista = janelaPai.dao.ListarTodos();
                    janelaPai.preencheTabela();
                    this.dispose();

                }else{
                    JOptionPane.showMessageDialog(rootPane, "Erro ao salvar o Tipo de Produto !");
                }
           
       
       }
  
        
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
         this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalvarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarMouseMoved
      // this.btnSalvar.setBackground(Color.BLUE); 
      // this.btnSalvar.setForeground(Color.white);
    }//GEN-LAST:event_btnSalvarMouseMoved

    private void btnSalvarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarMouseExited
        Color minhaCor = new Color(239,239,239);
        this.btnSalvar.setBackground(minhaCor); 
    }//GEN-LAST:event_btnSalvarMouseExited

    private void btnCancelarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseMoved
     //  this.btnCancelar.setBackground(Color.BLUE); 
     //  this.btnCancelar.setForeground(Color.white);
    }//GEN-LAST:event_btnCancelarMouseMoved

    private void btnCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseExited
        Color minhaCor = new Color(239,239,239);
        this.btnSalvar.setBackground(minhaCor);
    }//GEN-LAST:event_btnCancelarMouseExited

    private void btnSalvarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarMouseEntered
        Color minhaCor = new Color(115,183,253);
        this.btnCancelar.setBackground(minhaCor);
    }//GEN-LAST:event_btnSalvarMouseEntered

    private void btnCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseEntered
        Color minhaCor = new Color(115,183,253);
        this.btnSalvar.setBackground(minhaCor);
    }//GEN-LAST:event_btnCancelarMouseEntered

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel lblNome;
    private javax.swing.JPanel painelNovoServico;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
