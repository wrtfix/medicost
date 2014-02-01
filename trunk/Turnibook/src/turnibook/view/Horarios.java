/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turnibook.view;

import javax.swing.JTextField;
import javax.swing.JToolBar;
import turnibook.Operaciones;

/**
 *
 * @author wrtfix
 */
public class Horarios extends javax.swing.JFrame {
    private JToolBar aviso;

    /**
     * Creates new form Agenda
     */
    public Horarios() {
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

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        intervalo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        checkLunes = new javax.swing.JCheckBox();
        checkMartes = new javax.swing.JCheckBox();
        checkMiercoles = new javax.swing.JCheckBox();
        checkJueves = new javax.swing.JCheckBox();
        lunesDesde = new javax.swing.JTextField();
        lunesHasta = new javax.swing.JTextField();
        martesHasta = new javax.swing.JTextField();
        martesDesde = new javax.swing.JTextField();
        miercolesHasta = new javax.swing.JTextField();
        miercolesDesde = new javax.swing.JTextField();
        juevesHasta = new javax.swing.JTextField();
        juevesDesde = new javax.swing.JTextField();
        checkViernes = new javax.swing.JCheckBox();
        viernesDesde = new javax.swing.JTextField();
        viernesHasta = new javax.swing.JTextField();
        checkSabado = new javax.swing.JCheckBox();
        sabadoDesde = new javax.swing.JTextField();
        sabadoHasta = new javax.swing.JTextField();
        checkDomingo = new javax.swing.JCheckBox();
        domingoDesde = new javax.swing.JTextField();
        domingoHasta = new javax.swing.JTextField();
        checkDescanso = new javax.swing.JCheckBox();
        descanso = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Generaracion de Horario");

        jButton1.setText("Regresar");

        jButton2.setText("Generar");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jLabel1.setText("Intervalors de turno");

        jLabel2.setText("Dias Laborales:");

        checkLunes.setText("Lunes");
        checkLunes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkLunesMouseClicked(evt);
            }
        });

        checkMartes.setText("Martes");
        checkMartes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkMartesMouseClicked(evt);
            }
        });

        checkMiercoles.setText("Miercoles");
        checkMiercoles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkMiercolesMouseClicked(evt);
            }
        });

        checkJueves.setText("Jueves");
        checkJueves.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkJuevesMouseClicked(evt);
            }
        });

        lunesDesde.setEditable(false);
        lunesDesde.setText("Desde");

        lunesHasta.setEditable(false);
        lunesHasta.setText("Hasta");
        lunesHasta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lunesHastaActionPerformed(evt);
            }
        });

        martesHasta.setEditable(false);
        martesHasta.setText("Hasta");

        martesDesde.setEditable(false);
        martesDesde.setText("Desde");

        miercolesHasta.setEditable(false);
        miercolesHasta.setText("Hasta");

        miercolesDesde.setEditable(false);
        miercolesDesde.setText("Desde");

        juevesHasta.setEditable(false);
        juevesHasta.setText("Hasta");

        juevesDesde.setEditable(false);
        juevesDesde.setText("Desde");

        checkViernes.setText("Viernes");
        checkViernes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkViernesMouseClicked(evt);
            }
        });

        viernesDesde.setEditable(false);
        viernesDesde.setText("Desde");

        viernesHasta.setEditable(false);
        viernesHasta.setText("Hasta");

        checkSabado.setText("Sabado");
        checkSabado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkSabadoMouseClicked(evt);
            }
        });

        sabadoDesde.setEditable(false);
        sabadoDesde.setText("Desde");

        sabadoHasta.setEditable(false);
        sabadoHasta.setText("Hasta");

        checkDomingo.setText("Domingo");
        checkDomingo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkDomingoMouseClicked(evt);
            }
        });

        domingoDesde.setEditable(false);
        domingoDesde.setText("Desde");

        domingoHasta.setEditable(false);
        domingoHasta.setText("Hasta");

        checkDescanso.setText("Descansos");
        checkDescanso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkDescansoMouseClicked(evt);
            }
        });

        descanso.setEditable(false);
        descanso.setText("Cada cuantos turnos realiza un descanzo");

        jLabel3.setText("Horario");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkViernes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(checkSabado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(checkDomingo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(checkLunes, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkMartes, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkJueves, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(checkMiercoles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(checkDescanso))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lunesDesde)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lunesHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(martesDesde)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(martesHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(miercolesDesde)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(miercolesHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(sabadoDesde)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sabadoHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(domingoDesde)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(domingoHasta)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(juevesDesde, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(viernesDesde))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(viernesHasta)
                            .addComponent(juevesHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(descanso, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(158, 158, 158))
                            .addComponent(intervalo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(intervalo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkDescanso)
                    .addComponent(descanso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkLunes)
                    .addComponent(lunesDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lunesHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkMartes)
                    .addComponent(martesDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(martesHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkMiercoles)
                    .addComponent(miercolesDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(miercolesHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkJueves)
                    .addComponent(juevesDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(juevesHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkViernes)
                    .addComponent(viernesDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(viernesHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkSabado)
                    .addComponent(sabadoDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sabadoHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkDomingo)
                    .addComponent(domingoDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(domingoHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        Operaciones o = new Operaciones();
        JTextField aviso1 = null;
      
        o.insertar("insert into horario values(0,'" + lunesDesde.getText() + "','" + lunesHasta.getText() + "','" + martesDesde.getText() + "','" + martesHasta.getText() + "','" + miercolesDesde.getText() + "','" + miercolesHasta.getText() + "','" + juevesDesde.getText() + "','" + juevesHasta.getText() + "','" + viernesDesde.getText() + "','" + viernesHasta.getText() + "','" + sabadoDesde.getText() + "','" + sabadoHasta.getText() + "','" + domingoDesde.getText() + "','" + domingoHasta.getText() + "',"+intervalo.getText()+",0)",aviso1);

    }//GEN-LAST:event_jButton2MouseClicked

    private void lunesHastaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lunesHastaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lunesHastaActionPerformed

    private void checkDescansoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkDescansoMouseClicked
        if(checkDescanso.isSelected())
            descanso.setEditable(true);
        else
            descanso.setEditable(false);
    }//GEN-LAST:event_checkDescansoMouseClicked

    private void checkLunesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkLunesMouseClicked
        if(checkLunes.isSelected()){
            lunesDesde.setEditable(true);
            lunesHasta.setEditable(true);
        }
        else{
            lunesDesde.setEditable(false);
            lunesHasta.setEditable(false);
        }
    }//GEN-LAST:event_checkLunesMouseClicked

    private void checkMartesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkMartesMouseClicked
        if(checkMartes.isSelected()){
            martesDesde.setEditable(true);
            martesHasta.setEditable(true);
        }
        else{
            martesDesde.setEditable(false);
            martesHasta.setEditable(false);
        }    }//GEN-LAST:event_checkMartesMouseClicked

    private void checkMiercolesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkMiercolesMouseClicked
        if(checkMiercoles.isSelected()){
            miercolesDesde.setEditable(true);
            miercolesHasta.setEditable(true);
        }
        else{
            miercolesDesde.setEditable(false);
            miercolesHasta.setEditable(false);
        }
    }//GEN-LAST:event_checkMiercolesMouseClicked

    private void checkJuevesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkJuevesMouseClicked
        if(checkJueves.isSelected()){
            juevesDesde.setEditable(true);
            juevesHasta.setEditable(true);
        }
        else{
            juevesDesde.setEditable(false);
            juevesHasta.setEditable(false);
        }
    }//GEN-LAST:event_checkJuevesMouseClicked

    private void checkViernesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkViernesMouseClicked
        if(checkViernes.isSelected()){
            viernesDesde.setEditable(true);
            viernesHasta.setEditable(true);
        }
        else{
            viernesDesde.setEditable(false);
            viernesHasta.setEditable(false);
        }
    }//GEN-LAST:event_checkViernesMouseClicked

    private void checkSabadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkSabadoMouseClicked
        if(checkSabado.isSelected()){
            sabadoDesde.setEditable(true);
            sabadoHasta.setEditable(true);
        }
        else{
            sabadoDesde.setEditable(false);
            sabadoHasta.setEditable(false);
        }
    }//GEN-LAST:event_checkSabadoMouseClicked

    private void checkDomingoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkDomingoMouseClicked
        if(checkDomingo.isSelected()){
            domingoDesde.setEditable(true);
            domingoHasta.setEditable(true);
        }
        else{
            domingoDesde.setEditable(false);
            domingoHasta.setEditable(false);
        }

    }//GEN-LAST:event_checkDomingoMouseClicked

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
            java.util.logging.Logger.getLogger(Horarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Horarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Horarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Horarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Horarios().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox checkDescanso;
    private javax.swing.JCheckBox checkDomingo;
    private javax.swing.JCheckBox checkJueves;
    private javax.swing.JCheckBox checkLunes;
    private javax.swing.JCheckBox checkMartes;
    private javax.swing.JCheckBox checkMiercoles;
    private javax.swing.JCheckBox checkSabado;
    private javax.swing.JCheckBox checkViernes;
    private javax.swing.JTextField descanso;
    private javax.swing.JTextField domingoDesde;
    private javax.swing.JTextField domingoHasta;
    private javax.swing.JTextField intervalo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField juevesDesde;
    private javax.swing.JTextField juevesHasta;
    private javax.swing.JTextField lunesDesde;
    private javax.swing.JTextField lunesHasta;
    private javax.swing.JTextField martesDesde;
    private javax.swing.JTextField martesHasta;
    private javax.swing.JTextField miercolesDesde;
    private javax.swing.JTextField miercolesHasta;
    private javax.swing.JTextField sabadoDesde;
    private javax.swing.JTextField sabadoHasta;
    private javax.swing.JTextField viernesDesde;
    private javax.swing.JTextField viernesHasta;
    // End of variables declaration//GEN-END:variables
}
