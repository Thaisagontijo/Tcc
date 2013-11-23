/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.Presentation;

import br.com.tcc.DomainModel.Deposito;
import br.com.tcc.DomainModel.Retirada;
import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Thaisa
 */
public class frmExtratoCaixa extends javax.swing.JDialog {

    /**
     * Creates new form frmExtratoCaixa
     */
    frmMenuPrincipal janelaPai;
    public frmExtratoCaixa(java.awt.Frame parent, boolean modal,frmMenuPrincipal janelaPai) {
        super(parent, modal);
        this.janelaPai = janelaPai;
        initComponents();
         Color minhaCor = new Color(239,239,239);
        this.getContentPane().setBackground(minhaCor);
        preencheTabela();
        lblHoraAbertura.setText(horaAberturaCaixa());
        
    }

    private String horaAberturaCaixa(){
        DateFormat formato = new SimpleDateFormat("HH:mm:ss");  
        String formattedDate = formato.format(janelaPai.caixa.getDataAbertura()); 
        return formattedDate;
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
        
        model.addColumn("Data e Hora");
        model.addColumn("Descrição");
        model.addColumn("Tipo");
        model.addColumn("Envolvido");
        model.addColumn("Valor");
        
       
        
        for(Retirada p :janelaPai.caixa.getRetiradas() ){
            Vector v = new Vector();
            String data = "";
            data = p.getDataHora().getDate()+ "/"+(p.getDataHora().getMonth() +1)+"/"+p.getDataHora().getYear()+ 
                    " - "+ p.getDataHora().getHours()+":"+p.getDataHora().getMinutes();
            v.add(0,data);
            v.add(1,p.getDescricao());
            v.add(2,"Retirada");
            v.add(3,p.getFuncionario());
            v.add(4,p.getValor());
                              
            model.addRow(v);
        
        }
        
        for(Deposito p: janelaPai.caixa.getDepositos()){
            Vector v = new Vector();
        
            String data = "";
            data = p.getDataHora().getDate()+ "/"+(p.getDataHora().getMonth() +1)+"/"+p.getDataHora().getYear()+ 
                    " - "+ p.getDataHora().getHours()+":"+p.getDataHora().getMinutes();
            v.add(0,data);
            v.add(1,p.getObservacao());
            v.add(2,"Deposito");
            v.add(3,p.getFuncionario());
            v.add(4,p.getValor());
                              
            model.addRow(v);
        }
        
        
        
        tblExtrato.setModel(model);
        tblExtrato.repaint();
        tblExtrato.setAutoCreateRowSorter(true);
        

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
        tblExtrato = new javax.swing.JTable();
        lblTitulo = new javax.swing.JLabel();
        lblHoraAbertura = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(228, 228, 228));

        tblExtrato.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblExtrato);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        lblTitulo.setText("EXTRATO DO CAIXA ABERTO ÀS");

        lblHoraAbertura.setText("jLabel2");

        btnSair.setBackground(new java.awt.Color(239, 239, 239));
        btnSair.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(223, 223, 223)
                        .addComponent(lblTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblHoraAbertura, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(289, 289, 289)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitulo)
                    .addComponent(lblHoraAbertura))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSair;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHoraAbertura;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblExtrato;
    // End of variables declaration//GEN-END:variables
}
