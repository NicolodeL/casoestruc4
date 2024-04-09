package EmailyDiseñografico;

import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {
    public JButton createEmailButton() {
        JButton emailButton = new JButton("Comprobar Email");
        emailButton.addActionListener(e -> {
            String email = JOptionPane.showInputDialog("Introduce un correo electrónico para comprobar");
            if (email != null && !email.isEmpty()) {
                if (isValidEmail(email)) {
                    JOptionPane.showMessageDialog(null, "El correo electrónico es válido");
                } else {
                    JOptionPane.showMessageDialog(null, "El correo electrónico no es válido");
                }
            }
        });

        return emailButton;
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}