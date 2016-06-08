/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import NapakalakiGame.*;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JPanel;
/**
 *
 * @author Minim
 */
public class PlayerView extends javax.swing.JPanel {
    private Player playerModel;
    private Napakalaki napakalakiModel;
    
    public void setNapakalaki(Napakalaki n){
        napakalakiModel = n;
        isCultist.setText("");
        repaint();
        revalidate();
    }
    /**
     * Creates new form PlayerView
     */
    public PlayerView() {
        initComponents();
    }
    
    
private void fillTreasurePanel (JPanel aPanel, ArrayList<Treasure> aList) {
    // Se elimina la información antigua, si la hubiera
    aPanel.removeAll();
    // Se recorre la lista de tesoros construyendo y añadiendo sus vistas
// al panel
    for (Treasure t : aList) {
       TreasureView aTreasureView = new TreasureView();
       aTreasureView.setTreasure (t);
       aTreasureView.setVisible (true);
       aPanel.add (aTreasureView);
    }
    // Se fuerza la actualización visual del panel
    aPanel.repaint();
    aPanel.revalidate();
}
    
    public void setPlayer(Player p){
        this.playerModel=p;
        nivel.setText(Integer.toString(playerModel.getLevels()));
        combatLevel.setText(Integer.toString(playerModel.getCombatLevel()));
        name.setText(playerModel.getName());
        pendingBadConsequenceView1.setPendingBadConsequence(playerModel.getPendingBadConsequence());
        fillTreasurePanel(visibleTreasures, playerModel.getVisibleTreasures());
        fillTreasurePanel(hidden, playerModel.getHiddenTreasures());
        if(playerModel.getClass() == CultistPlayer.class){
            isCultist.setText(((CultistPlayer) playerModel).getCultistName());
        }
        repaint();
        revalidate();
    }
    
    private ArrayList<Treasure> getSelectedTreasures(JPanel aPanel) {
         // Se recorren los tesoros que contiene el panel,
         //    almacenando en un vector aquellos que están seleccionados.
         //    Finalmente se devuelve dicho vector.
         TreasureView tv;
         ArrayList<Treasure> output = new ArrayList();
         for (Component c : aPanel.getComponents()) {
            tv = (TreasureView) c;
            if ( tv.isSelected() )
               output.add ( tv.getTreasure() );
         }
         return output; 
    }
    
    
    public void setEnabledmakeVisible(boolean b){
        makeVisible.setEnabled(b);
    }
    
    public void setEnableddiscardAll(boolean b){
        discardall.setEnabled(b);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nivel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        combatLevel = new javax.swing.JLabel();
        hidden = new javax.swing.JPanel();
        visibleTreasures = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        hiddenTreasures = new javax.swing.JLabel();
        isCultist = new javax.swing.JLabel();
        makeVisible = new javax.swing.JButton();
        discard = new javax.swing.JButton();
        discardall = new javax.swing.JButton();
        pendingBadConsequenceView1 = new GUI.PendingBadConsequenceView();

        setBackground(new java.awt.Color(255, 204, 153));

        jLabel1.setFont(new java.awt.Font("Luminari", 0, 13)); // NOI18N
        jLabel1.setText("Turno del jugador");

        name.setFont(new java.awt.Font("Luminari", 0, 13)); // NOI18N
        name.setText("nombre");

        jLabel2.setFont(new java.awt.Font("Luminari", 0, 13)); // NOI18N
        jLabel2.setText("Nivel");

        nivel.setFont(new java.awt.Font("Luminari", 0, 13)); // NOI18N
        nivel.setText("nivel");

        jLabel3.setFont(new java.awt.Font("Luminari", 0, 13)); // NOI18N
        jLabel3.setText("Nivel de combate");

        combatLevel.setFont(new java.awt.Font("Luminari", 0, 13)); // NOI18N
        combatLevel.setText("combate");

        hidden.setBackground(new java.awt.Color(255, 153, 51));
        hidden.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        visibleTreasures.setBackground(new java.awt.Color(255, 153, 51));
        visibleTreasures.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Luminari", 0, 13)); // NOI18N
        jLabel4.setText("Tesoros visibles");

        hiddenTreasures.setFont(new java.awt.Font("Luminari", 0, 13)); // NOI18N
        hiddenTreasures.setText("Tesoros ocultos");

        isCultist.setFont(new java.awt.Font("Luminari", 1, 13)); // NOI18N
        isCultist.setText("SECTARIO");

        makeVisible.setFont(new java.awt.Font("Luminari", 0, 13)); // NOI18N
        makeVisible.setText("Hacer tesoros visibles");
        makeVisible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeVisibleActionPerformed(evt);
            }
        });

        discard.setFont(new java.awt.Font("Luminari", 0, 13)); // NOI18N
        discard.setText("Descartar tesoros");
        discard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discardActionPerformed(evt);
            }
        });

        discardall.setFont(new java.awt.Font("Luminari", 0, 13)); // NOI18N
        discardall.setText("Descartar todos");
        discardall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discardallActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(hidden, javax.swing.GroupLayout.PREFERRED_SIZE, 753, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(combatLevel))
                            .addComponent(hiddenTreasures)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(32, 32, 32)
                                .addComponent(name)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nivel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 769, Short.MAX_VALUE)
                        .addComponent(isCultist, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(pendingBadConsequenceView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(visibleTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, 753, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(discard, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(discardall, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(makeVisible, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(29, 29, 29))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(name))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nivel)
                    .addComponent(isCultist, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(combatLevel))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(discard)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(discardall)
                        .addGap(9, 9, 9)
                        .addComponent(makeVisible)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(visibleTreasures, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)))
                .addComponent(hiddenTreasures)
                .addGap(18, 18, 18)
                .addComponent(hidden, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pendingBadConsequenceView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void makeVisibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeVisibleActionPerformed
        ArrayList <Treasure> selHidden = getSelectedTreasures(hidden);
        napakalakiModel.makeTreasuresVisible(selHidden);
        setPlayer (napakalakiModel.getCurrentPlayer());
    }//GEN-LAST:event_makeVisibleActionPerformed

    private void discardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discardActionPerformed
        ArrayList <Treasure> selHidden = getSelectedTreasures(hidden);
        ArrayList <Treasure> selVisible = getSelectedTreasures(visibleTreasures);
        for(Treasure t: selHidden){
            playerModel.discardHiddenTreasure(t);
        }
        for(Treasure t1: selVisible){
            playerModel.discardVisibleTreasure(t1);
        }
        setPlayer(napakalakiModel.getCurrentPlayer());
    }//GEN-LAST:event_discardActionPerformed

    private void discardallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discardallActionPerformed
        playerModel.discardAllTreasures();
        setPlayer(napakalakiModel.getCurrentPlayer());
    }//GEN-LAST:event_discardallActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel combatLevel;
    private javax.swing.JButton discard;
    private javax.swing.JButton discardall;
    private javax.swing.JPanel hidden;
    private javax.swing.JLabel hiddenTreasures;
    private javax.swing.JLabel isCultist;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton makeVisible;
    private javax.swing.JLabel name;
    private javax.swing.JLabel nivel;
    private GUI.PendingBadConsequenceView pendingBadConsequenceView1;
    private javax.swing.JPanel visibleTreasures;
    // End of variables declaration//GEN-END:variables
}
