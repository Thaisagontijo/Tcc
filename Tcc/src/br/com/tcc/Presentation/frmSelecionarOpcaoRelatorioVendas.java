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
import br.com.tcc.DomainModel.ItemVendaServico;
import br.com.tcc.DomainModel.Venda;
import java.awt.Color;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JFrame;
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
    frmMenuPrincipal janelaPai;
    public frmSelecionarOpcaoRelatorioVendas(java.awt.Frame parent, boolean modal,frmMenuPrincipal janelaPai) {
        super(parent, modal);
        initComponents();
        this.janelaPai = janelaPai;
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
        setTitle("OPÇÕES DO RELATÓRIO");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(228, 228, 228));

        btnProduto.setBackground(new java.awt.Color(239, 239, 239));
        btnProduto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnProduto.setText("Por Produto");
        btnProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnProdutoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnProdutoMouseExited(evt);
            }
        });
        btnProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdutoActionPerformed(evt);
            }
        });

        btnPeriodo.setBackground(new java.awt.Color(239, 239, 239));
        btnPeriodo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPeriodo.setText("Por Período");
        btnPeriodo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPeriodoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPeriodoMouseExited(evt);
            }
        });
        btnPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPeriodoActionPerformed(evt);
            }
        });

        btnTodas.setBackground(new java.awt.Color(239, 239, 239));
        btnTodas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTodas.setText("Todas");
        btnTodas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTodasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTodasMouseExited(evt);
            }
        });
        btnTodas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTodasActionPerformed(evt);
            }
        });

        btnServico.setBackground(new java.awt.Color(239, 239, 239));
        btnServico.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnServico.setText("Por Serviço");
        btnServico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnServicoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnServicoMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnServicoMousePressed(evt);
            }
        });
        btnServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnServicoActionPerformed(evt);
            }
        });

        btnCliente.setBackground(new java.awt.Color(239, 239, 239));
        btnCliente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCliente.setText("Por Cliente");
        btnCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnClienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnClienteMouseExited(evt);
            }
        });
        btnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteActionPerformed(evt);
            }
        });

        btnVendasAVista.setBackground(new java.awt.Color(239, 239, 239));
        btnVendasAVista.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnVendasAVista.setText("Vendas à Vista");
        btnVendasAVista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnVendasAVistaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnVendasAVistaMouseExited(evt);
            }
        });
        btnVendasAVista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVendasAVistaActionPerformed(evt);
            }
        });

        btnVendasAPrazo.setBackground(new java.awt.Color(239, 239, 239));
        btnVendasAPrazo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnVendasAPrazo.setText("Vendas à Prazo");
        btnVendasAPrazo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnVendasAPrazoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnVendasAPrazoMouseExited(evt);
            }
        });
        btnVendasAPrazo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVendasAPrazoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Selecione a opção para gerar o relatório");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnPeriodo, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                    .addComponent(btnProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnServico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnVendasAPrazo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVendasAVista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jLabel1)
                .addContainerGap(72, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTodas, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(136, 136, 136))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(btnCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(btnProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnVendasAVista, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnServico, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVendasAPrazo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnTodas, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jButton1.setBackground(new java.awt.Color(239, 239, 239));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Sair");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });
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
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            InputStream relatorio = this.getClass().getClassLoader().getResourceAsStream("META-INF/relatorio/relatorioVendasAPrazo.jasper");
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
            InputStream relatorio = this.getClass().getClassLoader().getResourceAsStream("META-INF/relatorio/relatorioVendasAVista.jasper");
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

    private void btnPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPeriodoActionPerformed
       frmFiltroRelatorioVendas janela = new frmFiltroRelatorioVendas(null, rootPaneCheckingEnabled, this);
       janela.setLocationRelativeTo(this);
       janela.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_btnPeriodoActionPerformed

    private void btnProdutoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProdutoMouseEntered
       Color minhaCor = new Color(115,183,253);
        this.btnProduto.setBackground(minhaCor);
    }//GEN-LAST:event_btnProdutoMouseEntered

    private void btnProdutoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProdutoMouseExited
         Color minhaCor = new Color(239,239,239);
        this.btnProduto.setBackground(minhaCor);
    }//GEN-LAST:event_btnProdutoMouseExited

    private void btnPeriodoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPeriodoMouseEntered
       Color minhaCor = new Color(115,183,253);
        this.btnPeriodo.setBackground(minhaCor);
    }//GEN-LAST:event_btnPeriodoMouseEntered

    private void btnPeriodoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPeriodoMouseExited
       Color minhaCor = new Color(239,239,239);
        this.btnPeriodo.setBackground(minhaCor);
    }//GEN-LAST:event_btnPeriodoMouseExited

    private void btnServicoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnServicoMouseEntered
        Color minhaCor = new Color(115,183,253);
        this.btnServico.setBackground(minhaCor);
    }//GEN-LAST:event_btnServicoMouseEntered

    private void btnServicoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnServicoMousePressed
        Color minhaCor = new Color(239,239,239);
        this.btnServico.setBackground(minhaCor);
    }//GEN-LAST:event_btnServicoMousePressed

    private void btnServicoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnServicoMouseExited
         Color minhaCor = new Color(239,239,239);
        this.btnServico.setBackground(minhaCor);
    }//GEN-LAST:event_btnServicoMouseExited

    private void btnClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClienteMouseEntered
       Color minhaCor = new Color(115,183,253);
        this.btnCliente.setBackground(minhaCor);
    }//GEN-LAST:event_btnClienteMouseEntered

    private void btnClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClienteMouseExited
         Color minhaCor = new Color(239,239,239);
        this.btnCliente.setBackground(minhaCor);
    }//GEN-LAST:event_btnClienteMouseExited

    private void btnVendasAVistaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVendasAVistaMouseEntered
       Color minhaCor = new Color(115,183,253);
        this.btnVendasAVista.setBackground(minhaCor);
    }//GEN-LAST:event_btnVendasAVistaMouseEntered

    private void btnVendasAVistaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVendasAVistaMouseExited
         Color minhaCor = new Color(239,239,239);
        this.btnVendasAVista.setBackground(minhaCor);
    }//GEN-LAST:event_btnVendasAVistaMouseExited

    private void btnVendasAPrazoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVendasAPrazoMouseEntered
        Color minhaCor = new Color(115,183,253);
        this.btnVendasAPrazo.setBackground(minhaCor);
    }//GEN-LAST:event_btnVendasAPrazoMouseEntered

    private void btnVendasAPrazoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVendasAPrazoMouseExited
         Color minhaCor = new Color(239,239,239);
        this.btnVendasAPrazo.setBackground(minhaCor);
    }//GEN-LAST:event_btnVendasAPrazoMouseExited

    private void btnTodasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTodasMouseEntered
        Color minhaCor = new Color(115,183,253);
        this.btnTodas.setBackground(minhaCor);
    }//GEN-LAST:event_btnTodasMouseEntered

    private void btnTodasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTodasMouseExited
         Color minhaCor = new Color(239,239,239);
        this.btnTodas.setBackground(minhaCor);
    }//GEN-LAST:event_btnTodasMouseExited

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        Color minhaCor = new Color(115,183,253);
        this.jButton1.setBackground(minhaCor);
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
         Color minhaCor = new Color(239,239,239);
        this.jButton1.setBackground(minhaCor);
    }//GEN-LAST:event_jButton1MouseExited

    private void btnServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnServicoActionPerformed
        try {
            //Pegando o id do Produto

            String servico = JOptionPane.showInputDialog("Insira o Id do Serviço");

            //Arquivo do Relatorio
            //String relatorio = "/META-INF/relatorio/relatorioEstoque.jasper";
            InputStream relatorio = this.getClass().getClassLoader().getResourceAsStream("META-INF/relatorio/relatorioVendasTodas.jasper");
            //Lista a ser exibida no relatorio

            CaixaDAO caixaDAO = new CaixaDAO();
            List<Caixa> caixas = caixaDAO.ListarTodos();

            List<Venda> vendasFiltro = new LinkedList();
            for (Caixa c : caixas) {
                for (Venda v : c.getVendas()) {
                    for (ItemVendaServico p : v.getServicos()) {
                        if (p.getServico().getId() == Integer.parseInt(servico)) {
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
    }//GEN-LAST:event_btnServicoActionPerformed

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
