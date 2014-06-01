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
 * @author Thaisa
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

        jPanel1 = new javax.swing.JPanel();
        btnProduto = new javax.swing.JButton();
        btnPeriodo = new javax.swing.JButton();
        btnTodas = new javax.swing.JButton();
        btnServico = new javax.swing.JButton();
        btnCliente = new javax.swing.JButton();
        btnVendasAVista = new javax.swing.JButton();
        btnVendasAPrazo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Opções de Relatório");
        setResizable(false);

        btnProduto.setText("Por Produto");
        btnProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdutoActionPerformed(evt);
            }
        });

        btnPeriodo.setText("Por Período");

        btnTodas.setText("Todas");
        btnTodas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTodasActionPerformed(evt);
            }
        });

        btnServico.setText("Por Serviço");

        btnCliente.setText("Por Cliente");
        btnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteActionPerformed(evt);
            }
        });

        btnVendasAVista.setText("Vendas à Vista");
        btnVendasAVista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVendasAVistaActionPerformed(evt);
            }
        });

        btnVendasAPrazo.setText("Vendas à Prazo");
        btnVendasAPrazo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVendasAPrazoActionPerformed(evt);
            }
        });

        jLabel1.setText("Selecione a opção para gerar o relatório");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                                    .addComponent(btnPeriodo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnServico, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(199, 199, 199)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnVendasAPrazo)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(btnCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnVendasAVista, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addComponent(btnTodas, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1))
                .addGap(0, 47, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProduto)
                    .addComponent(btnCliente))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnVendasAVista)
                            .addComponent(btnPeriodo))
                        .addGap(36, 36, 36)
                        .addComponent(btnVendasAPrazo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(btnServico)))
                .addGap(18, 18, 18)
                .addComponent(btnTodas)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
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

    private void btnVendasAPrazoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVendasAPrazoActionPerformed
          try {
            //Arquivo do Relatorio
            //String relatorio = "/META-INF/relatorio/relatorioEstoque.jasper";
            InputStream relatorio = this.getClass().getClassLoader().getResourceAsStream("META-INF/relatorio/relatorioVendasTodas.jasper");
            //Lista a ser exibida no relatorio
            CaixaDAO caixaDAO = new CaixaDAO();
            List<Caixa> caixas = caixaDAO.ListarTodos();
            
            List <Venda> vendas = new LinkedList();
            for(Caixa c : caixas){
                //vendas.addAll(c.getVendas());
                for(Venda v : c.getVendas()){
                    if(v.getFormaDePagamento().getId().intValue() == 2 ){
                        vendas.add(v);
                    
                    
                    }
                }
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
        
        
        
    }//GEN-LAST:event_btnVendasAPrazoActionPerformed

    private void btnVendasAVistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVendasAVistaActionPerformed
       try {
            //Arquivo do Relatorio
            //String relatorio = "/META-INF/relatorio/relatorioEstoque.jasper";
            InputStream relatorio = this.getClass().getClassLoader().getResourceAsStream("META-INF/relatorio/relatorioVendasTodas.jasper");
            //Lista a ser exibida no relatorio
            CaixaDAO caixaDAO = new CaixaDAO();
            List<Caixa> caixas = caixaDAO.ListarTodos();
            
            List <Venda> vendas = new LinkedList();
            for(Caixa c : caixas){
                //vendas.addAll(c.getVendas());
                for(Venda v : c.getVendas()){
                    if(v.getFormaDePagamento().getId().intValue() == 1 ){
                        vendas.add(v);
                    
                    
                    }
                }
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
        
        
    }//GEN-LAST:event_btnVendasAVistaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCliente;
    private javax.swing.JButton btnPeriodo;
    private javax.swing.JButton btnProduto;
    private javax.swing.JButton btnServico;
    private javax.swing.JButton btnTodas;
    private javax.swing.JButton btnVendasAPrazo;
    private javax.swing.JButton btnVendasAVista;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
