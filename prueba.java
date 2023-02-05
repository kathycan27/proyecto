import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class prueba extends javax.swing.JFrame{
    private JPanel panel1;


    private JButton btncambio;
    private JLabel jlicono;
    private JRadioButton rbKg;
    private JRadioButton rbLb;
    private JRadioButton rbM;
    private JSpinner spPeso;
    private JSpinner spEstatura;
    private JButton Calculos;
    private JRadioButton rbCm;
    private JSlider slcambio;
    private JLabel sltexto;
    private JLabel txtpeso;
    private JLabel pesor;
    private JLabel total;
    private JLabel txtestatura;
    private JLabel txtem;
    private JLabel txtte;
    private JLabel jlIMC;
    private JLabel jestatus;
    private JMenuBar jmenu;
    private JFileChooser jfchooser;



    private ImageIcon icon;
    private ImageIcon image;
    private  Image image1;
    int valor;
    double pesos;
    double estaturas;
    double cIMC;
    double fipeso;
    double fialtura;




    public prueba() {
        ButtonGroup grupopeso = new ButtonGroup();
        grupopeso.add(rbKg);
        grupopeso.add(rbLb);
        ButtonGroup grupoestatura=new ButtonGroup();
        grupoestatura.add(rbM);
        grupoestatura.add(rbCm);
        DecimalFormat df=new DecimalFormat("###.##");
       //pesos= (double) spPeso.getValue();
        btncambio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Ruta = "";
                JFileChooser jFileChooser = new JFileChooser();
                FileNameExtensionFilter filtrado = new FileNameExtensionFilter("JGP,PNG & GIF", "jpg", "png", "gif");
                jFileChooser.setFileFilter(filtrado);
                int respuesta = jFileChooser.showOpenDialog(null);
                if (respuesta == JFileChooser.APPROVE_OPTION) {
                    Ruta = jFileChooser.getSelectedFile().getPath();
                    Image mImagen = new ImageIcon(Ruta).getImage();
                    ImageIcon mIcono = new ImageIcon(mImagen.getScaledInstance(200, 200, Image.SCALE_SMOOTH));
                    jlicono.setIcon(mIcono);
                }

            }
        });
        jlicono.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                Image mImagen = new ImageIcon(getClass().getResource("/imagenes/batman.jpeg")).getImage();
                ImageIcon mIcono = new ImageIcon(mImagen.getScaledInstance(200, 200
                        , Image.SCALE_SMOOTH));

                jlicono.setIcon(mIcono);


            }
        });

        slcambio.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                valor=slcambio.getValue();
                sltexto.setFont(new Font("Seriff", Font.PLAIN, valor));
                jlIMC.setFont(new Font("Seriff", Font.PLAIN, valor));
                jestatus.setFont(new Font("Seriff", Font.PLAIN, valor));
                sltexto.setText(String.valueOf("Tamano de letra: "+valor));



            }
        });
        txtpeso.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);


            }
        });

        spPeso.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

                spPeso.getValue();
                pesos= Double.parseDouble(String.valueOf(spPeso.getValue()));
                txtpeso.setText(String.valueOf(pesos));



            }
        });
        Calculos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cIMC=fipeso/Math.pow(fialtura,2);
                jlIMC.setText("Su IMC es: "+df.format(cIMC));
                if(cIMC<18.49)
                {
                    jestatus.setText("Se encuentre bajo de peso");
                }
                else if (cIMC==18.5|| cIMC<=24.9)
                {
                    jestatus.setText("Su peso es saludables");
                } else if (cIMC==25||cIMC<=29.9) {
                    jestatus.setText("Tiene sobrepeso");


                }else if(cIMC>=30){
                    jestatus.setText("Tiene obesidad");

                }


            }
        });

        rbKg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                spPeso.getValue();
                pesor.setText("Kg");
                total.setText(String.valueOf("El peso en kilogramos es: "+ pesos+" Kg"));
                fipeso=pesos;


            }
        });
        rbLb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                pesor.setText("Lb");
                total.setText(String.valueOf(" El peso de libras: "+df.format(pesos*0.453592))+" Kg");
                fipeso= Double.parseDouble(df.format(pesos*0.453592));
            }
        });
        spPeso.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);

                if(e.getKeyCode()==KeyEvent.VK_ENTER) {
                    pesos= Double.parseDouble(String.valueOf(spPeso.getValue()));

                }
                txtpeso.setText(String.valueOf(pesos));
            }
        });

        rbM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                spEstatura.getValue();
                txtem.setText("m");
                txtte.setText(String.valueOf("La estatura en metros es: "+ estaturas+" m"));
                fialtura=estaturas;

            }
        });
        spPeso.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                SpinnerModel spnrModelo = new SpinnerNumberModel(0,0,300, 0.05);
                spPeso.setModel(spnrModelo);
            }
        });
        spEstatura.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                spEstatura.getValue();
                estaturas= Double.parseDouble(String.valueOf(spEstatura.getValue()));
                txtestatura.setText(String.valueOf(estaturas));

            }
        });
        spEstatura.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);

                if(e.getKeyCode()==KeyEvent.VK_ENTER) {
                    spEstatura.getValue();
                    estaturas= Double.parseDouble(String.valueOf(spEstatura.getValue()));

                }
                txtestatura.setText(String.valueOf(estaturas));
            }
        });
        spEstatura.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                SpinnerModel spnrModelo = new SpinnerNumberModel(0,0,280, 0.05);
                spEstatura.setModel(spnrModelo);
            }
        });

        rbCm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                txtem.setText("cm");
                txtte.setText(String.valueOf(" Estatura de cm : "+df.format(estaturas*0.01))+" m");
                fialtura= Double.parseDouble(df.format(estaturas*0.01));

            }
        });
    total.addComponentListener(new ComponentAdapter() { } );

    }


    public static void main(String[] args) {
                JFrame frame = new JFrame("Calculadora IMC");

                frame.setContentPane(new prueba().panel1);
                frame.setSize(250, 250);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);


            }



}

