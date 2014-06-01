 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.tcc.Presentation;

import br.com.tcc.DataAccess.CaixaDAO;
import br.com.tcc.DomainModel.Caixa;
import java.awt.Color;
import java.io.InputStream;
import java.util.Date;
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
public class frmFiltroRelatorioCaixaPorData extends javax.swing.JDialog {

    /**
     * Creates new form frmFiltroRelatorioCompras
     */
    frmSelecionaOpcaoRelatorioCaixa janelaPai;
    frmFiltroRelatorioCaixaPorData(java.awt.Frame parent, boolean modal, frmSelecionaOpcaoRelatorioCaixa janelaPai) {
        super(parent, modal);
        initComponents();
        adicionarDatasCBX1();
        adicionarDatasCBX2();
        this.janelaPai =janelaPai;
    }
    
    
    private void adicionarDatasCBX1(){
        Date dataTmp = new Date();
        /*
          * 
          * PREENCHE COMBOBOX DO DIA
          
          */
        cbxDia.removeAllItems();
         cbxDia.addItem("Dia");
         for(int i=1;i<32;i++){
             String tmp;
             if(i<=9){
                tmp = "0"+i;
             }else{
                 tmp = String.valueOf(i);
             }
             cbxDia.addItem(tmp);
         }
         
         
         /*
          * 
          * PREENCHE COMBOBOX DO MES
          
          */
         cbxMes.removeAllItems();
         cbxMes.addItem("Mês");
         for(int i=1;i<13;i++){
             String tmp;
             if(i<=9){
                tmp = "0"+i;
             }else{
                 tmp = String.valueOf(i);
             }
             cbxMes.addItem(tmp);
         }
         
         
         /*
          * 
          * PREENCHE COMBOBOX DO ANO
          
          */
         cbxAno.removeAllItems();
         cbxAno.addItem("Ano");
         int data = dataTmp.getYear() + 1900;
         for(int i=data;i<=data+1;i++){
             String tmp = String.valueOf(i);
             
             cbxAno.addItem(tmp);
         }
        
         
         //for(int h :)
         
         cbxDia.setSelectedIndex(dataTmp.getDate());
         cbxMes.setSelectedIndex(dataTmp.getMonth()+1);
         cbxAno.setSelectedIndex(1);
    
    }
    
    
    private void adicionarDatasCBX2(){
        Date dataTmp = new Date();
        /*
          * 
          * PREENCHE COMBOBOX DO DIA
          
          */
        cbxDia1.removeAllItems();
         cbxDia1.addItem("Dia");
         for(int i=1;i<32;i++){
             String tmp;
             if(i<=9){
                tmp = "0"+i;
             }else{
                 tmp = String.valueOf(i);
             }
             cbxDia1.addItem(tmp);
         }
         
         
         /*
          * 
          * PREENCHE COMBOBOX DO MES
          
          */
         cbxMes1.removeAllItems();
         cbxMes1.addItem("Mês");
         for(int i=1;i<13;i++){
             String tmp;
             if(i<=9){
                tmp = "0"+i;
             }else{
                 tmp = String.valueOf(i);
             }
             cbxMes1.addItem(tmp);
         }
         
         
         /*
          * 
          * PREENCHE COMBOBOX DO ANO
          
          */
         cbxAno1.removeAllItems();
         cbxAno1.addItem("Ano");
         int data = dataTmp.getYear() + 1900;
         for(int i=data;i<=data+1;i++){
             String tmp = String.valueOf(i);
             
             cbxAno1.addItem(tmp);
         }
        
         
         //for(int h :)
         
         cbxDia1.setSelectedIndex(dataTmp.getDate());
         cbxMes1.setSelectedIndex(dataTmp.getMonth()+1);
         cbxAno1.setSelectedIndex(1);
    
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
        lblMensagem = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        cbxDia = new javax.swing.JComboBox();
        cbxMes = new javax.swing.JComboBox();
        cbxAno = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        cbxDia1 = new javax.swing.JComboBox();
        cbxMes1 = new javax.swing.JComboBox();
        cbxAno1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("RELATÓRIO DE COMPRAS POR PERÍODO");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(228, 228, 228));
        jPanel1.setToolTipText("Criar relatório de Compras");

        lblMensagem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMensagem.setText("Selecione o Período para criar o relatório de compras");

        lblData.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblData.setText("Data:");

        cbxDia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxDia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxMes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxMes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxAno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxAno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Até");

        cbxDia1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxDia1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxMes1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxMes1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxAno1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxAno1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblMensagem)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxDia, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbxMes, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbxAno, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel1)
                        .addGap(28, 28, 28)
                        .addComponent(cbxDia1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbxMes1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(cbxAno1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblMensagem)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbxDia1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbxMes1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbxAno1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblData)
                        .addComponent(cbxDia, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbxMes, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbxAno, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Gerar Relatório");
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

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/tcc/Presentation/icones/Fechar.png"))); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton2MouseExited(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(177, 177, 177)
                .addComponent(jButton1)
                .addGap(104, 104, 104)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Date data1 = new Date();
        Date data2 = new Date();

        /*
         PEGANDO VALORES DA PRIMERA DATA
         */
        data1.setDate(cbxDia.getSelectedIndex());
        data1.setMonth(cbxMes.getSelectedIndex() - 1);
        data1.setYear(Integer.parseInt(cbxAno.getSelectedItem().toString()));

        /*
         PEGANDO VALORES DA SEGUNDA DATA
         */
        data2.setDate(cbxDia1.getSelectedIndex());
        data2.setMonth(cbxMes1.getSelectedIndex() - 1);
        data2.setYear(Integer.parseInt(cbxAno1.getSelectedItem().toString()));

        CaixaDAO tmpCaixaDAO = new CaixaDAO();
        List<Caixa> caixas;
        List<Caixa> caixasFiltro = new LinkedList<>();
        data1.setYear(data1.getYear() - 1900);
        data2.setYear(data2.getYear() - 1900);

        caixas = tmpCaixaDAO.ListarCaixasEntreDatas(data1, data2);
        
        if(caixas != null){
            for(Caixa c :caixas){
                c.setValorTotal(c.calcularTotalCaixa());
                caixasFiltro.add(c);
            }
        }
        
        
    
        //Gerando relatorio
        try {
            //Arquivo do Relatorio
            //String relatorio = "/META-INF/relatorio/relatorioEstoque.jasper";
            InputStream relatorio = this.getClass().getClassLoader().getResourceAsStream("META-INF/relatorio/relatorioCaixa.jasper");

            if (!caixasFiltro.isEmpty()) {

                //Fonte de dados
                JRBeanCollectionDataSource fonteDados = new JRBeanCollectionDataSource(caixasFiltro);

                //Gera o Relatorio
                JasperPrint relatorioGerado = JasperFillManager.fillReport(relatorio, null, fonteDados);

                //Exibe o Relatorio
                JasperViewer jasperViewer = new JasperViewer(relatorioGerado, false);
                janelaPai.dispose();
                this.dispose();
                jasperViewer.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Nenhuma compra registrada nesse periodo !");
            }

        } catch (JRException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(rootPane, "Id inválido !");
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
          Color minhaCor = new Color(115,183,253);
          this.jButton1.setBackground(minhaCor);
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseExited
        Color minhaCor = new Color (239,239,239);
        this.jButton2.setBackground(minhaCor);
    }//GEN-LAST:event_jButton2MouseExited

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        Color minhaCor = new Color(239,239,239);
        this.jButton1.setBackground(minhaCor);
    }//GEN-LAST:event_jButton1MouseExited

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        Color minhaCor = new Color(115,183,253);
        this.jButton2.setBackground(minhaCor);
    }//GEN-LAST:event_jButton2MouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbxAno;
    private javax.swing.JComboBox cbxAno1;
    private javax.swing.JComboBox cbxDia;
    private javax.swing.JComboBox cbxDia1;
    private javax.swing.JComboBox cbxMes;
    private javax.swing.JComboBox cbxMes1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblMensagem;
    // End of variables declaration//GEN-END:variables
}
