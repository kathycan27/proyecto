import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Login extends pantalla{
    private JLabel usuario;
    private JTextField escribirUsuario;
    private JPanel panel1;
    private JButton entrarButton;
    private JPasswordField escribirContra;

    public Login() {
        entrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean ingreso = false;
                String user = "mateo";
                String contrasenia = "mateo123";
                String pass = new String(escribirContra.getPassword()); //Transformamos a estring la contrasenia

                if(escribirUsuario.getText().equals(user) && pass.equals(contrasenia)){ //validamos las credenciales
                        ingreso = true;
                }
                else {
                    JOptionPane.showMessageDialog(null,
                            "El usuario o contraseña son incorrectos");

                }

                if (!ingreso) {
                    JOptionPane.showMessageDialog(null,
                            "Se a suspendido el numero de intentos permitidos");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Bienvenido al sistema");
                    JFrame frame = new JFrame("IMC");
                    frame.setContentPane(new pantalla().panel2);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.pack();
                    frame.setSize(1000, 1000);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                }
            }
        });
    }

    public static void main (String[] args){
        JFrame frame = new JFrame("Log-in");
        frame.setContentPane(new Login().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}