
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Login1 extends javax.swing.JFrame {
    private JTextField escribirUsuario;
    private JButton entrarButton;
    private JPasswordField escribirContra;
    JPanel panel1;
    private JLabel usuario;
    private JLabel jlimagInicio;
    private ImageIcon icon;
    private ImageIcon image;
    private  Image image3;


    public  Login1 ()  {
        entrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                if(escribirUsuario.getText().equals("") || escribirContra.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Loscampos estan vacios");
                }
                else {

                    JOptionPane.showMessageDialog(null, "Bienvenido al sistema");

                    JFrame frame = new JFrame("IMC");
                    frame.setContentPane(new prueba(escribirUsuario.getText(),escribirContra.getPassword()).panel2);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.pack();
                    frame.setSize(1000, 1000);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);

                }
            }
        });
        jlimagInicio.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                Image mImagen = new ImageIcon(getClass().getResource("/imagenes/dinodoctor.jpg")).getImage();
                ImageIcon mIcono = new ImageIcon(mImagen.getScaledInstance(300, 300
                        , Image.SCALE_SMOOTH));

                jlimagInicio.setIcon(mIcono);
            }
        });
    }

    public static void main (String[] args){
        JFrame frame = new JFrame("Log-in");
        frame.setContentPane(new Login1().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
