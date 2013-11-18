/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.Presentation;

import br.com.tcc.DataAccess.FuncionarioDAO;
import br.com.tcc.DataAccess.UsuarioDAO;
import br.com.tcc.DomainModel.Funcionario;
import br.com.tcc.DomainModel.Usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author Ana Luiza
 */
public class frmCadastroUsuario extends javax.swing.JDialog {

    /**
     * Creates new form frmCadastroUsuario
     */
    private frmUsuarioLista janelaPai;
    private boolean cadastro;
    public frmCadastroUsuario(java.awt.Frame parent, boolean modal,frmUsuarioLista janelaPai,boolean cadastro) {
        super(parent, modal);
        initComponents();
        this.cadastro = cadastro;
        
        cbxFuncionario.removeAllItems();
        daoFuncionario = new FuncionarioDAO();
        daoUsuario = new UsuarioDAO();
        this.janelaPai = janelaPai;
        
        Funcionario tmp = new Funcionario();
        tmp.setNome("Selecione");
        
        cbxFuncionario.addItem(tmp);
        
        for(Funcionario f : daoFuncionario.ListarTodos()){
            cbxFuncionario.addItem(f);
        }
        
        
        
        if(cadastro){
            this.setTitle("Edição de Usuário");
        
        }else{
            
            this.setTitle("Cadastro de Usuário");
            cbxFuncionario.setSelectedItem(janelaPai.objSelecionadoNaTabela.getFuncionario());
            txtUsuario.setText(janelaPai.objSelecionadoNaTabela.getNome());
        
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

        jPanel1 = new javax.swing.JPanel();
        lblFuncionario = new javax.swing.JLabel();
        cbxFuncionario = new javax.swing.JComboBox();
        lblUsuario = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        lblSenha = new javax.swing.JLabel();
        txtSenha1 = new javax.swing.JPasswordField();
        lblConfirmar = new javax.swing.JLabel();
        txtSenha2 = new javax.swing.JPasswordField();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblFuncionario.setText("Funcionário*:");

        cbxFuncionario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblUsuario.setText("Usuario *:");

        lblSenha.setText("Senha*:");

        lblConfirmar.setText("Confirmar Senha*:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFuncionario)
                            .addComponent(lblUsuario)
                            .addComponent(lblSenha))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxFuncionario, 0, 255, Short.MAX_VALUE)
                            .addComponent(txtUsuario)
                            .addComponent(txtSenha1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblConfirmar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSenha2)))
                .addContainerGap(329, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFuncionario)
                    .addComponent(cbxFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsuario)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSenha)
                    .addComponent(txtSenha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblConfirmar)
                    .addComponent(txtSenha2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(btnSalvar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if(cbxFuncionario.getSelectedIndex() == 0 || txtUsuario.getText().isEmpty() || txtSenha1.getText().isEmpty() || txtSenha2.getText().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Todos os campos devem ser preenchidos !");
        }else if(!txtSenha1.getText().equals(txtSenha2.getText()))   {
            JOptionPane.showMessageDialog(rootPane, "As senhas não coincidem !");
        }else{
            Usuario tmpUsuario = null;
            
            if(cadastro){
                tmpUsuario = new Usuario();
            }else{
                tmpUsuario = janelaPai.objSelecionadoNaTabela;
            }
            
            tmpUsuario.setFuncionario((Funcionario)cbxFuncionario.getSelectedItem());
            tmpUsuario.setNome(txtUsuario.getText());
            tmpUsuario.setSenha(txtSenha1.getText());
            
            if(daoUsuario.Salvar(tmpUsuario)){
                JOptionPane.showMessageDialog(rootPane, "Usuario salvo com sucesso !");
                this.janelaPai.lista.clear();
                this.janelaPai.lista = janelaPai.dao.ListarTodos();
                this.janelaPai.preencheTabela();
                this.dispose();
                
            }else{
                JOptionPane.showMessageDialog(rootPane, "Erro ao salvar o usuario!");
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    FuncionarioDAO daoFuncionario;
    UsuarioDAO daoUsuario;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox cbxFuncionario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblConfirmar;
    private javax.swing.JLabel lblFuncionario;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPasswordField txtSenha1;
    private javax.swing.JPasswordField txtSenha2;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
