import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class historial {
    JPanel panel3;
    private JMenuBar menuBar1;
    private JMenu jmenu2;
    private JMenu historialMenu;
    private JMenu salirMenu;
    private JLabel hnombre;
    private JLabel hclave;
    private JLabel hpeso;
    private JLabel haltura;
    private JLabel hestatus;
    String nombre1;
    double txtpeso,txtestatura,txtestatus;
String clave1;
    public historial(String nombre1, String clave1) {
        this.nombre1=nombre1;
        hnombre.setText(nombre1);
        this.clave1= String.valueOf(clave1);
        hclave.setText(String.valueOf(clave1));

        salirMenu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                    super.mouseClicked(e);
                    System.exit(0);

            }
        });
        jmenu2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JFrame frame = new JFrame("IMC");
                frame.setContentPane(new prueba(hnombre.getText(), hclave.getText().toCharArray()));
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setSize(1000, 1000);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
