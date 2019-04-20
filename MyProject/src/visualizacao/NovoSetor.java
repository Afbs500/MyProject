/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualizacao;

import modelo.Setor;
import repository.SetorRepository;

/**
 *
 * @author flavia.goncalves
 */
public class NovoSetor extends javax.swing.JFrame {

    /**
     * Creates new form NovoSetor
     */
    public NovoSetor() {
        initComponents();
        desabilitarComponentes();
    }
    
    public void desabilitarComponentes(){
        jlblIdSetor.setVisible(false);
        jtfId.setVisible(false);
        
        jbtAcao.setText("Incluir");
    }
    
     public void habilitarComponentes(){
        jlblIdSetor.setVisible(true);
        jtfId.setVisible(true);
    }
     
    public void alterarTituloSetor(){
        jlblTitulo.setText(".::: Alterar Setor :::.");
        
        jbtAcao.setText("Alterar");
    } 
     
    public void excluirTituloSetor(){
         jlblTitulo.setText(".::: Excluir Setor :::.");
        
         jbtAcao.setText("Excluir");
         
        
    }
    
    public void desabilitarComponentesExcluir(){
        jLabel2.setVisible(false);
        jtfSigla.setVisible(false);
        
        jLabel3.setVisible(false);
        jtfNomeSetor.setVisible(false);
        
    }
    
    
    public void executarAcoes(){
        
        Setor setor = new Setor();
        SetorRepository srepository = new SetorRepository();
        
        //o atributo está recebendo os dados da tela
        setor.setSigla(jtfSigla.getText());
        setor.setNomeSetor(jtfNomeSetor.getText());
     
        int id = Integer.parseInt(jtfId.getText());
        
        if (jbtAcao.getText().equalsIgnoreCase("Incluir")){
            srepository.Insert(setor);
        }
        
        if (jbtAcao.getText().equalsIgnoreCase("Alterar")){
            srepository.Update(setor, id);
        }
        
        if (jbtAcao.getText().equalsIgnoreCase("Excluir")){
           
            srepository.Delete(id);
        }
        
    }
    
    
    public void limparTudo(){
        jtfId.setText("Informe o numero do setor");
        jtfNomeSetor.setText("Informe o nome do Setor");
        jtfSigla.setText("Informe a sigla do Setor");
    }
       
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlblTitulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfSigla = new javax.swing.JTextField();
        jtfNomeSetor = new javax.swing.JTextField();
        jbtCancelar = new javax.swing.JButton();
        jbtAcao = new javax.swing.JButton();
        jlblIdSetor = new javax.swing.JLabel();
        jtfId = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));

        jlblTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jlblTitulo.setText(".::: Incluir Novo Setor :::.");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Sigla do Setor: ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nome do Setor:");

        jtfSigla.setText("Informe a sigla do Setor");
        jtfSigla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtfSiglaMouseClicked(evt);
            }
        });

        jtfNomeSetor.setText("Informe  nome do Setor");
        jtfNomeSetor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtfNomeSetorMouseClicked(evt);
            }
        });

        jbtCancelar.setText("Cancelar");
        jbtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtCancelarActionPerformed(evt);
            }
        });

        jbtAcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAcaoActionPerformed(evt);
            }
        });

        jlblIdSetor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblIdSetor.setForeground(new java.awt.Color(255, 255, 255));
        jlblIdSetor.setText("Id Setor: ");

        jtfId.setText("Informe o numero do ID");
        jtfId.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtfIdMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlblTitulo)
                .addGap(135, 135, 135))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jbtCancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbtAcao))
                            .addComponent(jtfNomeSetor, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jlblIdSetor)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtfId, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(29, 29, 29)
                            .addComponent(jtfSigla, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jlblTitulo)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblIdSetor)
                    .addComponent(jtfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfSigla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfNomeSetor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtAcao, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAcaoActionPerformed
      executarAcoes();
      limparTudo();
    }//GEN-LAST:event_jbtAcaoActionPerformed

    private void jbtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCancelarActionPerformed
        limparTudo();
        dispose();
        
    }//GEN-LAST:event_jbtCancelarActionPerformed

    private void jtfIdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtfIdMouseClicked
        jtfId.setText("");
    }//GEN-LAST:event_jtfIdMouseClicked

    private void jtfSiglaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtfSiglaMouseClicked
       jtfSigla.setText("");
    }//GEN-LAST:event_jtfSiglaMouseClicked

    private void jtfNomeSetorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtfNomeSetorMouseClicked
        jtfNomeSetor.setText("");
    }//GEN-LAST:event_jtfNomeSetorMouseClicked

    /**
     * @param args the command line arguments
     */
  
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbtAcao;
    private javax.swing.JButton jbtCancelar;
    private javax.swing.JLabel jlblIdSetor;
    private javax.swing.JLabel jlblTitulo;
    private javax.swing.JTextField jtfId;
    private javax.swing.JTextField jtfNomeSetor;
    private javax.swing.JTextField jtfSigla;
    // End of variables declaration//GEN-END:variables
}
