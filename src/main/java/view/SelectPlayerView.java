package view;

import controller.SelectPlayerController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.io.File;

/**
 *
 * The purpose of this class is to show a drop-down to the user to get the number of players as input.
 * After selecting a value from drop-down, once the user press the OK button, then it redirects to
 * map again.
 *
 * @author Mahedi Hassan
 */

public class SelectPlayerView{

    private String[] numberOfPlayers;
    private SelectPlayerListener selectPlayerListener;
    private JFrame window;
    private SelectPlayerController selectPlayerController;


    /**
     * This interface is to give callback to the controller regarding the user actions and
     * View initialization
     */
    public interface SelectPlayerListener{
        void onViewReady();
        void onButtonSelect(String selectedItem);
    }

    /**
     *
     * This constructor initiates the listener and drop-down items
     *
     * @param window
     * @param selectPlayerListener
     */
    public SelectPlayerView(JFrame window, SelectPlayerListener selectPlayerListener){
        this.window = window;
        this.selectPlayerListener = selectPlayerListener;
        this.selectPlayerController = new SelectPlayerController();
        initView();
    }


    /**
     *
     * This method initiates the View for Selecting the number of players from the dropdown.
     */
    private void initView() {

        numberOfPlayers = selectPlayerController.getNumberOfPlayers(new File(selectPlayerController.getFileLocation()));


        window.getContentPane().removeAll();
        window.setTitle("Select Players Number");

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        window.add(panel);

        GridBagConstraints gridBag = new GridBagConstraints();
        gridBag.gridx = 0;
        gridBag.gridx = 0;
        gridBag.insets = new Insets(2,2,2,2);

        JLabel label = new JLabel("Number of Players : ");
        gridBag.gridx ++;
        panel.add(label, gridBag);


        final JComboBox comboBox = new JComboBox(numberOfPlayers);
        comboBox.setMaximumSize(comboBox.getPreferredSize());
        comboBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        gridBag.gridx = 0;
        gridBag.gridx ++;
        gridBag.fill = GridBagConstraints.HORIZONTAL;
        panel.add(comboBox, gridBag);
        gridBag.gridx ++;

        gridBag.gridx = 0;
        gridBag.gridx ++;
        final JButton btn = new JButton("OK");
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn.addActionListener(new Action() {
            public Object getValue(String key) {
                return null;
            }

            public void putValue(String key, Object value) {

            }

            public void setEnabled(boolean b) {

            }

            public boolean isEnabled() {
                return false;
            }

            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            public void actionPerformed(ActionEvent e) {
                selectPlayerListener.onButtonSelect((String) comboBox.getSelectedItem());
            }
        });
        panel.add(btn, gridBag);

        window.setVisible(true);
    }


    /**
     * This method makes the View visible and gives callback to the controller {@link controller.game.Game}
     */
    public void show(){
        window.setVisible(true);
        selectPlayerListener.onViewReady();
    }
}
