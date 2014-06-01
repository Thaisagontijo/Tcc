/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.tcc.Presentation;

import br.com.tcc.DataAccess.CompraDAO;
import br.com.tcc.DomainModel.Compra;
import java.awt.Color;
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
public class frmSelecionaOpcaoRelatorioCompras extends javax.swing.JDialog {

    /**
     * Creates new form frmSelecionaOpcaoRelatorioCompras
     */
    public frmSelecionaOpcaoRelatorioCompras(java.awt.Frame parent, boolean modal) {
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
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnTodos = new javax.swing.JButton();
        btnProduto = new javax.swing.JButton();
        btnFornecedor = new javax.swing.JButton();
        btnTipoProduto = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("OPÇÕES DO RELATÓRIO");

        jPanel1.setBackground(new java.awt.Color(228, 228, 228));

        jButton1.setBackground(new java.awt.Color(239, 239, 239));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Por Período");
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

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Selecione a opção para gerar o relatório");

        btnTodos.setBackground(new java.awt.Color(239, 239, 239));
        btnTodos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTodos.setText("Todos");
        btnTodos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTodosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTodosMouseExited(evt);
            }
        });
        btnTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTodosActionPerformed(evt);
            }
        });

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

        btnFornecedor.setBackground(new java.awt.Color(239, 239, 239));
        btnFornecedor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnFornecedor.setText("Por Fornecedor");
        btnFornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnFornecedorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnFornecedorMouseExited(evt);
            }
        });
        btnFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFornecedorActionPerformed(evt);
            }
        });

        btnTipoProduto.setBackground(new java.awt.Color(239, 239, 239));
        btnTipoProduto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTipoProduto.setText("Por Tipo de Produto");
        btnTipoProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTipoProdutoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTipoProdutoMouseExited(evt);
            }
        });
        btnTipoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTipoProdutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTipoProduto)
                .addGap(126, 126, 126))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel1)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(btnTipoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        btnCancelar.setBackground(new java.awt.Color(239, 239, 239));
        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCancelar.setText("Sair");
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancelarMouseExited(evt);
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        frmFiltroRelatorioComprasPorData janela = new frmFiltroRelatorioComprasPorData(null, rootPaneCheckingEnabled, this);
        janela.setLocationRelativeTo(null);
        janela.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTodosActionPerformed
        try {
            //Arquivo do Relatorio
            //String relatorio = "/META-INF/relatorio/relatorioEstoque.jasper";
            InputStream relatorio = this.getClass().getClassLoader().getResourceAsStream("META-INF/relatorio/relatorioCompras.jasper");
            //Lista a ser exibida no relatorio
            CompraDAO compraDao = new CompraDAO();
            List<Compra> compras = new LinkedList<>();
            
            for(Compra c :compraDao.ListarTodos()){
                c.setNomeFornecedor(c.getProduto().getFornecedor().getNome());
                compras.add(c);
            }
            

            //Fonte de dados
            JRBeanCollectionDataSource fonteDados = new JRBeanCollectionDataSource(compras);

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
    }//GEN-LAST:event_btnTodosActionPerformed

    private void btnProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdutoActionPerformed

        try {
            //Pegando o id do Produto

            String produto = JOptionPane.showInputDialog("Insira o Id do Produto");

            //Arquivo do Relatorio
            //String relatorio = "/META-INF/relatorio/relatorioEstoque.jasper";
            InputStream relatorio = this.getClass().getClassLoader().getResourceAsStream("META-INF/relatorio/relatorioCompras.jasper");
            //Lista a ser exibida no relatorio

            CompraDAO compraDao = new CompraDAO();

            List<Compra> compras = compraDao.ListarTodos();
            List<Compra> comprasFiltro = new LinkedList<>();
            for (Compra c : compras) {
                if (c.getProduto().getId() == Long.parseLong(produto)) {
                    comprasFiltro.add(c);
                }
            }

            if (!comprasFiltro.isEmpty()) {

                //Fonte de dados
                JRBeanCollectionDataSource fonteDados = new JRBeanCollectionDataSource(comprasFiltro);

                //Gera o Relatorio
                JasperPrint relatorioGerado = JasperFillManager.fillReport(relatorio, null, fonteDados);

                //Exibe o Relatorio
                JasperViewer jasperViewer = new JasperViewer(relatorioGerado, false);
                this.dispose();
                jasperViewer.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Produto não encontrado!");
            }

        } catch (JRException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(rootPane, "Id inválido!");
        }
    }//GEN-LAST:event_btnProdutoActionPerformed

    private void btnFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFornecedorActionPerformed

        try {
//Pegando o id do Produto

            String fornecedor = JOptionPane.showInputDialog("Insira o Id do Fornecedor");

            //Arquivo do Relatorio
            //String relatorio = "/META-INF/relatorio/relatorioEstoque.jasper";
            InputStream relatorio = this.getClass().getClassLoader().getResourceAsStream("META-INF/relatorio/relatorioCompras.jasper");
            //Lista a ser exibida no relatorio

            CompraDAO comprasDAO = new CompraDAO();

            List<Compra> compras = comprasDAO.ListarTodos();
            List<Compra> comprasFiltro = new LinkedList<>();
            for (Compra c : compras) {
                if (c.getProduto().getFornecedor().getId() == Long.parseLong(fornecedor)) {
                    comprasFiltro.add(c);
                }
            }

            if (!comprasFiltro.isEmpty()) {

                //Fonte de dados
                JRBeanCollectionDataSource fonteDados = new JRBeanCollectionDataSource(comprasFiltro);

                //Gera o Relatorio
                JasperPrint relatorioGerado = JasperFillManager.fillReport(relatorio, null, fonteDados);

                //Exibe o Relatorio
                JasperViewer jasperViewer = new JasperViewer(relatorioGerado, false);
                this.dispose();
                jasperViewer.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Fornecedor não encontrado !");
            }

        } catch (JRException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(rootPane, "Id inválido !");
        }

    }//GEN-LAST:event_btnFornecedorActionPerformed

    private void btnTipoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTipoProdutoActionPerformed
         try {
//Pegando o id do Produto

            String fornecedor = JOptionPane.showInputDialog("Insira o Id do Tipo de Produto");

            //Arquivo do Relatorio
            //String relatorio = "/META-INF/relatorio/relatorioEstoque.jasper";
            InputStream relatorio = this.getClass().getClassLoader().getResourceAsStream("META-INF/relatorio/relatorioCompras.jasper");
            //Lista a ser exibida no relatorio

            CompraDAO comprasDAO = new CompraDAO();

            List<Compra> compras = comprasDAO.ListarTodos();
            List<Compra> comprasFiltro = new LinkedList<>();
            for (Compra c : compras) {
                if (c.getProduto().getTipoProduto().getId() == Long.parseLong(fornecedor)) {
                    comprasFiltro.add(c);
                }
            }

            if (!comprasFiltro.isEmpty()) {

                //Fonte de dados
                JRBeanCollectionDataSource fonteDados = new JRBeanCollectionDataSource(comprasFiltro);

                //Gera o Relatorio
                JasperPrint relatorioGerado = JasperFillManager.fillReport(relatorio, null, fonteDados);

                //Exibe o Relatorio
                JasperViewer jasperViewer = new JasperViewer(relatorioGerado, false);
                this.dispose();
                jasperViewer.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Tipo de Produto não encontrado !");
            }

        } catch (JRException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(rootPane, "Id inválido !");
        }
    }//GEN-LAST:event_btnTipoProdutoActionPerformed

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
         Color minhaCor = new Color(115,183,253);
          this.jButton1.setBackground(minhaCor);
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        Color minhaCor = new Color (239,239,239);
        this.jButton1.setBackground(minhaCor);
    }//GEN-LAST:event_jButton1MouseExited

    private void btnFornecedorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFornecedorMouseEntered
          Color minhaCor = new Color(115,183,253);
          this.btnFornecedor.setBackground(minhaCor);
    }//GEN-LAST:event_btnFornecedorMouseEntered

    private void btnFornecedorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFornecedorMouseExited
         Color minhaCor = new Color (239,239,239);
        this.btnFornecedor.setBackground(minhaCor);
    }//GEN-LAST:event_btnFornecedorMouseExited

    private void btnProdutoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProdutoMouseEntered
        Color minhaCor = new Color(115,183,253);
          this.btnProduto.setBackground(minhaCor);
    }//GEN-LAST:event_btnProdutoMouseEntered

    private void btnProdutoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProdutoMouseExited
         Color minhaCor = new Color (239,239,239);
        this.btnProduto.setBackground(minhaCor);
    }//GEN-LAST:event_btnProdutoMouseExited

    private void btnTodosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTodosMouseEntered
        Color minhaCor = new Color(115,183,253);
          this.btnTodos.setBackground(minhaCor);
    }//GEN-LAST:event_btnTodosMouseEntered

    private void btnTodosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTodosMouseExited
        Color minhaCor = new Color (239,239,239);
        this.btnTodos.setBackground(minhaCor);
    }//GEN-LAST:event_btnTodosMouseExited

    private void btnTipoProdutoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTipoProdutoMouseEntered
        Color minhaCor = new Color(115,183,253);
        this.btnTipoProduto.setBackground(minhaCor);
    }//GEN-LAST:event_btnTipoProdutoMouseEntered

    private void btnTipoProdutoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTipoProdutoMouseExited
       Color minhaCor = new Color (239,239,239);
        this.btnTipoProduto.setBackground(minhaCor);
    }//GEN-LAST:event_btnTipoProdutoMouseExited

    private void btnCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseEntered
        Color minhaCor = new Color(115,183,253);
        this.btnCancelar.setBackground(minhaCor);
    }//GEN-LAST:event_btnCancelarMouseEntered

    private void btnCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseExited
         Color minhaCor = new Color (239,239,239);
        this.btnCancelar.setBackground(minhaCor);
    }//GEN-LAST:event_btnCancelarMouseExited

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnFornecedor;
    private javax.swing.JButton btnProduto;
    private javax.swing.JButton btnTipoProduto;
    private javax.swing.JButton btnTodos;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
