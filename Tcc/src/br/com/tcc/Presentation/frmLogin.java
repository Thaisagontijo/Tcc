/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.Presentation;

import br.com.tcc.DataAccess.UsuarioDAO;
import br.com.tcc.DomainModel.Usuario;
import java.awt.Color;
import javax.swing.JOptionPane;
import br.com.tcc.utilitarios.CryptographyTripleDES;
import java.awt.event.KeyEvent;

/**
 *
 * @author Modric
 */
public class frmLogin extends javax.swing.JFrame {

    /**
     * Creates new form frmLogin
     */
    public frmLogin() {
        initComponents();
        Color minhaCor = new Color(239, 239, 239);
        this.getContentPane().setBackground(minhaCor);
        dao = new UsuarioDAO();
        usuario = new Usuario();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUsuario = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtSenha = new javax.swing.JPasswordField();
        btnlogar = new javax.swing.JButton();
        lblIconeCadeado = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Autenticação");

        lblUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblUsuario.setText("Usuário");

        lblSenha.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSenha.setText("Senha");

        txtUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtUsuario.setToolTipText("Nome do Usuário");

        txtSenha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtSenha.setToolTipText("Senha do Usuário");
        txtSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSenhaKeyPressed(evt);
            }
        });

        btnlogar.setBackground(new java.awt.Color(239, 239, 239));
        btnlogar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnlogar.setText("Entrar");
        btnlogar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnlogarMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnlogarMouseEntered(evt);
            }
        });
        btnlogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlogarActionPerformed(evt);
            }
        });

        lblIconeCadeado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/tcc/Presentation/icones/cadeado.png"))); // NOI18N

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitulo.setText("AUTENTICAÇÃO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnlogar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(lblIconeCadeado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(52, 52, 52))
            .addGroup(layout.createSequentialGroup()
                .addGap(239, 239, 239)
                .addComponent(lblTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblIconeCadeado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(btnlogar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnlogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlogarActionPerformed
        
        try {
            
            CryptographyTripleDES criptografia = CryptographyTripleDES.newInstance();

            if (txtUsuario.getText().isEmpty() && txtSenha.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Os Campos devem ser Preenchidos !");
            } else {
                usuario.setNome(txtUsuario.getText());
                usuario.setSenha(criptografia.encrypt(txtSenha.getText()));

                Usuario autenticado = dao.Autenticar(usuario);
                if (autenticado != null) {
                    frmMenuPrincipal janela = new frmMenuPrincipal(autenticado);

                    janela.setLocationRelativeTo(null);
                    janela.setVisible(rootPaneCheckingEnabled);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Login Incorreto !");
                }
            }

        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnlogarActionPerformed

    private void btnlogarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlogarMouseEntered
        Color minhaCor = new Color(115, 183, 253);
        this.btnlogar.setBackground(minhaCor);
    }//GEN-LAST:event_btnlogarMouseEntered

    private void btnlogarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlogarMouseExited
        Color minhaCor = new Color(239, 239, 239);
        this.btnlogar.setBackground(minhaCor);
    }//GEN-LAST:event_btnlogarMouseExited

    private void txtSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSenhaKeyPressed
       //AO PRESSIONAR O ENTER
        
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){    
            btnlogarActionPerformed(null);
        }  
        
        
        
    }//GEN-LAST:event_txtSenhaKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmLogin().setVisible(true);
            }
        });
    }

    UsuarioDAO dao;
    Usuario usuario;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnlogar;
    private javax.swing.JLabel lblIconeCadeado;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
