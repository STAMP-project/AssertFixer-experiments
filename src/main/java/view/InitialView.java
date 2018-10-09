package view;

import controller.map.GeographicalMapController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

/**
 * @author Mina
 * this class is made to make an initial  jfram for choosing the mapfile and creating the map.
 */
public class InitialView {

    private JFrame window;
    private JPanel panel;


    public InitialView(WindowListener windowListener) {

        window = new JFrame("Risk");
        window.addWindowListener(windowListener);
        window.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        panel = new JPanel();
        addComponentToPane(panel);
        window.add(panel);

        window.setMinimumSize(new Dimension(500, 500));
        window.pack();
        window.setLocationRelativeTo(null);
        window.toFront();


    }


    /**
     * method for adding the component (buttons and ChooseFile to JPanel)
     *
     * @param pane
     */
    private void addComponentToPane(Container pane) {

        //Put the JComboBox in a JPanel to get a nicer look.
        GeographicalMapController geographicalMapController = new GeographicalMapController();
        String fileMapName;
        final JButton jButtonChooseMap = new JButton("choose map");
        final JFileChooser jFileChooserMap = new JFileChooser(geographicalMapController.getMapFileDirectory());
        jButtonChooseMap.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                jButtonChooseMap.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        if (jFileChooserMap.showOpenDialog(window) == JFileChooser.APPROVE_OPTION) {

                        }
                    }
                });
            }
        });


        JButton jButtonCreateMap = new JButton("Create map");
        jButtonCreateMap.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                GeographicalMapController geographicalMapController = new GeographicalMapController();
                MessagePanel messagePanel=new MessagePanel();
                if(jFileChooserMap.getSelectedFile()!=null) {
                    geographicalMapController.parseMapFile(jFileChooserMap.getSelectedFile().getPath());
                }else{
                    messagePanel.showErrorMessage("you should choose a file at first");
                }
            }

        });

        //Create the "riskPanel".
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(jButtonChooseMap);
        buttonPanel.add(jButtonCreateMap);

        //Create the panel that contains the "riskPanel".
        panel = new JPanel(new CardLayout());
        panel.add(buttonPanel, " Button Panel ");
        pane.add(panel, BorderLayout.CENTER);
    }


    public void show() {
        window.setVisible(true);
    }

    /**
     *
     * This method initialize the View for selecting the number of players.
     * It creates an object of {@link SelectPlayerView} by providing values and an interface {@link view.SelectPlayerView.SelectPlayerListener}
     * which gives a callback regarding the actions.
     *
     * Call this method when you wants show the View for Player selection.
     *
     */
    public void showSelectUsersPanel(){
        SelectPlayerView selectPlayerView = new SelectPlayerView(window, new SelectPlayerView.SelectPlayerListener() {
            public void onViewReady() {

            }

            public void onButtonSelect() {

            }
        });
        selectPlayerView.show();
    }
}
