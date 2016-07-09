import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ventana extends Canvas {

    static {
        try {
            javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

        } catch (Exception r) {
            System.out.println("--> " + r.getMessage());
        }
    }
    private final Operaciones opr= new Operaciones();
    private JFrame ventana = new JFrame("Conjuntos");
    static ArrayList conjt1 = new ArrayList(), conjt2 = new ArrayList(), conRes = new ArrayList();
    private JPanel panel = new JPanel();
    private final Embebidor emb = new Embebidor();
    private JTextArea area = new JTextArea();
    private JLabel etq1 = new JLabel("Conjunto 1"), etq2 = new JLabel("Conjunto 2");
    private JTextField con1 = new JTextField(), con2 = new JTextField();
    private final String[] ops = {"Union", "Interseccion", "Diferencia", "Diferencia Simetrica"};
    private JComboBox operaciones = new JComboBox(ops);
    private final ImageIcon fondito = new ImageIcon(new ImageIcon(getClass()
            .getResource("Nubes.gif")).getImage());
    private JButton btnCapturar = new JButton("Capturar");
    private Image dibAux;
    private Graphics gAux;
    private Dimension dimAux;
    private Dimension dimCanvi;

    public Ventana() {
        this.setPreferredSize(new Dimension(800, 600));
        this.setSize(new Dimension(800, 600));
        this.setBackground(Color.darkGray);
        dimCanvi = this.getSize();
        ventana.setVisible(true);
        ventana.setSize(800, 600);
        ventana.requestFocus();
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(3);
        ventana.add(panel);
        panel.setLayout(null);
        panel.add(operaciones);
        panel.add(area);
        panel.add(etq1);
        panel.add(etq2);
        panel.add(con1);
        panel.add(con2);
        panel.add(btnCapturar);
        panel.add(this);

        etq1.setBounds(60, 70, 120, 40);
        etq2.setBounds(60, 170, 120, 30);
        con1.setBounds(210, 70, 300, 30);
        con2.setBounds(210, 170, 300, 30);
        area.setBounds(60, 400, 610, 150);
        operaciones.setFont(emb.Russo);
        con1.setFont(emb.Russo);
        con2.setFont(emb.Russo);
        etq1.setFont(emb.Russo);
        etq2.setFont(emb.Russo);
        area.setFont(emb.Russo);
        area.setEditable(false);
        btnCapturar.setFont(emb.Russo);
        operaciones.setBounds(130, 240, 300, 30);
        btnCapturar.setBounds(450, 330, 150, 30);
        this.setBounds(0, 0, 800, 600);
        //con2.setBounds(210, 170, 300, 30);
        btnCapturar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                conjt1 = new ArrayList(); conjt2 = new ArrayList(); conRes = new ArrayList();
                capturar(operaciones.getSelectedItem(), con1.getText(), con2.getText());
            }
        });
    }

    public void capturar(Object op, String conj1, String conj2) {
        String aux = "";
        try {
            for (int i = 0; i < conj1.length(); i++) {
                if (conj1.charAt(i) != ',') {
                    aux = aux + conj1.charAt(i);
                } else {
                    conjt1.add(aux);
                    aux = "";
                }
            }
            if (conj1.charAt(conj1.length() - 1) != ',') {
                conjt1.add(aux);
            }
            aux = "";
            for (int i = 0; i < conj2.length(); i++) {
                if (conj2.charAt(i) != ',') {
                    aux = aux + conj2.charAt(i);
                } else if (i == conj2.length() - 1) {
                    conjt2.add(aux);
                } else {
                    conjt2.add(aux);
                    aux = "";
                }
            }
            if (conj2.charAt(conj2.length() - 1) != ',') {
                conjt2.add(aux);
            }
        } catch (Exception e) {
        }
        if (op.equals("Union")) {
            System.out.println(op);
            System.out.println("1");
            opr.union();
        } else if (op.equals("Interseccion")) {
            System.out.println("2");
            opr.interseccion();
        } else if (op.equals("Diferencia")) {
            System.out.println("3");
            opr.diferencia();
        } else if (op.equals("Diferencia Simetrica")) {
            System.out.println("4");
            opr.diferenciaSimetrica();
        }
        area.setText("Conjunto 1: [" + conj1 + "]\nConjunto 2: " + conjt2 + "\n" + op + "=>\n" + conRes);
    }

    

    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(fondito.getImage(), 0, 0, 800, 600, this);
    }

    public void update(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        if (gAux == null || dimAux == null || dimCanvi.width != dimAux.width
                || dimCanvi.height != dimAux.height) {
            dimAux = dimCanvi;
            dibAux = createImage(dimAux.width, dimAux.height);
            gAux = dibAux.getGraphics();
        }
        paint(gAux);
        g2d.drawImage(dibAux, 0, 0, null);
    }

}
