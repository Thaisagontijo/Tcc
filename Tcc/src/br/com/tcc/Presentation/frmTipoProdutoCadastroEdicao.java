/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.Presentation;

import br.com.tcc.DomainModel.TipoProduto;
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        painelNovoServico.setBorder(javax.swing.BorderFactory.createTitledBorder("Nova Forma de Pagamento"));

        lblNome.setText("Nome* :");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(136, 136, 136)
                .addComponent(jButton2)
                .addGap(255, 255, 255))
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
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
               
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
  
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel lblNome;
    private javax.swing.JPanel painelNovoServico;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
