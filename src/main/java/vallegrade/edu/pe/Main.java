package vallegrade.edu.pe;

import vallegrade.edu.pe.view.FrmLogin;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FrmLogin().setVisible(true));
    }
}
