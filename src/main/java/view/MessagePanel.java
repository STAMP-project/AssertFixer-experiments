package view;

import javax.swing.*;


/**
 * @author Mina
 * This class is made for methoding related to messages
 */
public class MessagePanel
{

    public static final String Message_Error="Error";
    public static final String Message_Info="Info";

    /**
     * This method is made for showing error message
     * @param message
     */
    public  void showErrorMessage(String message) {
        final JPanel panel = new JPanel();
        JOptionPane.showMessageDialog(panel, message, Message_Error, JOptionPane.ERROR_MESSAGE);
    }

}
