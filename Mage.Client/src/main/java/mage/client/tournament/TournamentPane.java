

 /*
 * TournamentPane.java
 *
 * Created on 22-Jan-2011, 11:41:47 PM
 */
package mage.client.tournament;

import java.util.UUID;
import mage.client.MagePane;

/**
 *
 * @author BetaSteward_at_googlemail.com
 */
public class TournamentPane extends MagePane {

    /**
     * Creates new form TournamentPane
     */
    public TournamentPane() {
        initComponents();
    }

    public void showTournament(UUID tournamentId) {
        this.setTitle("Tournament " + tournamentId);
        this.tournamentPanel.showTournament(tournamentId);
        this.repaint();
    }

    public void removeTournament() {
        tournamentPanel.cleanUp();
        removeFrame();
    }

    @Override
    public void changeGUISize() {
        tournamentPanel.changeGUISize();
    }

    public UUID getTournamentId() {
        if (this.tournamentPanel == null) {
            return null;
        }
        return tournamentPanel.getTournamentId();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tournamentPanel = new mage.client.tournament.TournamentPanel();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tournamentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tournamentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
        );

    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private mage.client.tournament.TournamentPanel tournamentPanel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void activated() {
        tournamentPanel.startTasks();
    }

    @Override
    public void deactivated() {
        tournamentPanel.stopTasks();
    }

}
