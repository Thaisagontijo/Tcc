/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.tcc.Presentation;

import br.com.tcc.DataAccess.CaixaDAO;
import br.com.tcc.DataAccess.ClienteDAO;
import br.com.tcc.DomainModel.Caixa;
import br.com.tcc.DomainModel.Cliente;
import br.com.tcc.DomainModel.ItemVendaProduto;
import br.com.tcc.DomainModel.Venda;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author anderson
 */
public class frmSelecionarOpcaoRelatorioVendas extends javax.swing.JDialog {

    /**
     * Creates new form frmSelecionarOpcaoRelatorioVendas
     */
    public frmSelecionarOpcaoRelatorioVendas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnProduto = new javax.swing.JButton();
        btnServico = new javax.swing.JButton();
        btnCliente = new javax.swing.JButton();
        btnPeriodo = new javax.swing.JButton();
        btnTodas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Opções de Relatório");

        btnProduto.setText("Por Produto");
        btnProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdutoActionPerformed(evt);
            }
        });

        btnServico.setText("Por Serviço");

        btnCliente.setText("Por Cliente");
        btnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteActionPerformed(evt);
            }
        });

        btnPeriodo.setText("Por Período");

        btnTodas.setText("Todas");
        btnTodas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTodasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnProduto)
                    .addComponent(btnServico)
                    .addComponent(btnCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 189, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnPeriodo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTodas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(97, 97, 97))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProduto)
                    .addComponent(btnPeriodo))
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnServico)
                    .addComponent(btnTodas))
                .addGap(46, 46, 46)
                .addComponent(btnCliente)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTodasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTodasActionPerformed
        try {
            //Arquivo do Relatorio
            //String relatorio = "/META-INF/relatorio/relatorioEstoque.jasper";
            InputStream relatorio = this.getClass().getClassLoader().getResourceAsStream("META-INF/relatorio/relatorioVendasTodas.jasper");
            //Lista a ser exibida no relatorio
            CaixaDAO caixaDAO = new CaixaDAO();
            List<Caixa> caixas = caixaDAO.ListarTodos();
            
            List <Venda> vendas = new LinkedList();
            for(Caixa c : caixas){
                vendas.addAll(c.getVendas());
            }
            System.out.print(vendas.size());
            

            //Fonte de dados
            JRBeanCollectionDataSource fonteDados = new JRBeanCollectionDataSource(vendas);

            //Gera o Relatorio
            JasperPrint relatorioGerado = JasperFillManager.fillReport(relatorio, null, fonteDados);

            //Exibe o Relatorio
            JasperViewer jasperViewer = new JasperViewer(relatorioGerado, false);
            this.dispose();
            jasperViewer.setVisible(true);
            
        }catch(JRException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnTodasActionPerformed

    private void btnProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdutoActionPerformed
         try {
            //Pegando o id do Produto

            String produto = JOptionPane.showInputDialog("Insira o Id do Produto");

            //Arquivo do Relatorio
            //String relatorio = "/META-INF/relatorio/relatorioEstoque.jasper";
            InputStream relatorio = this.getClass().getClassLoader().getResourceAsStream("META-INF/relatorio/relatorioVendasTodas.jasper");
            //Lista a ser exibida no relatorio

            CaixaDAO caixaDAO = new CaixaDAO();
            List<Caixa> caixas = caixaDAO.ListarTodos();
            
            List <Venda> vendasFiltro = new LinkedList();
            for(Caixa c : caixas){
                for(Venda v : c.getVendas()){
                    for(ItemVendaProduto p: v.getProdutos()){
                        if(p.getProduto().getId() == Integer.parseInt(produto)){
                            vendasFiltro.add(v);
                        }
                    }
                }
                //vendas.addAll(c.getVendas());
            }
            
            
          

            if (!vendasFiltro.isEmpty()) {

                //Fonte de dados
                JRBeanCollectionDataSource fonteDados = new JRBeanCollectionDataSource(vendasFiltro);

                //Gera o Relatorio
                JasperPrint relatorioGerado = JasperFillManager.fillReport(relatorio, null, fonteDados);

                //Exibe o Relatorio
                JasperViewer jasperViewer = new JasperViewer(relatorioGerado, false);
                this.dispose();
                jasperViewer.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Nenhuma venda com este produto !");
            }

        } catch (JRException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(rootPane, "Id inválido !");
        }
    }//GEN-LAST:event_btnProdutoActionPerformed

    private void btnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteActionPerformed
        try {
            String clienteId = JOptionPane.showInputDialog("Insira o Id do Cliente");
            ClienteDAO daoCliente = new ClienteDAO();

            Cliente tmp = daoCliente.Abrir(Long.parseLong(clienteId));
            if (tmp == null) {
                JOptionPane.showMessageDialog(rootPane, "Cliente não encontrado !");
            } else {

                CaixaDAO caixaDAO = new CaixaDAO();
                List<Caixa> caixas = caixaDAO.ListarTodos();

                List<Venda> vendasFiltro = new LinkedList();
                for (Caixa c : caixas) {
                    for (Venda v : c.getVendas()) {
                        if(v.getCliente().equals(tmp)){
                            vendasFiltro.add(v);
                        }
                    }
                    //vendas.addAll(c.getVendas());
                }
                this.dispose();
                frmListaVendasCliente janela = new frmListaVendasCliente(null, rootPaneCheckingEnabled, vendasFiltro);
                janela.setLocationRelativeTo(this);
                janela.setVisible(true);
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(rootPane, "Id Inválido");
        }
    }//GEN-LAST:event_btnClienteActionPerformed

    
    
    
    
    
    
    
    
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
            java.util.logging.Logger.getLogger(frmSelecionarOpcaoRelatorioVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmSelecionarOpcaoRelatorioVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmSelecionarOpcaoRelatorioVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmSelecionarOpcaoRelatorioVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmSelecionarOpcaoRelatorioVendas dialog = new frmSelecionarOpcaoRelatorioVendas(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCliente;
    private javax.swing.JButton btnPeriodo;
    private javax.swing.JButton btnProduto;
    private javax.swing.JButton btnServico;
    private javax.swing.JButton btnTodas;
    // End of variables declaration//GEN-END:variables
}
