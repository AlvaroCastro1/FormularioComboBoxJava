import javax.swing.*;

import java.awt.event.*;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ComboBox2 extends JFrame implements ItemListener {
    private JComboBox<String> pais;
    private JComboBox<String> estado;
    private JLabel l1 = new JLabel();

    private String[] arr_paises = { "Mexico", "Estados Unidos", "Cuba" };
    private String[] arr_estadoM = { "Aguascalientes", "Baja California", "Campeche", "Chiapas", "Chihuahua",
            "Colima" };
    private String[] arr_estadosEU = { "Alabama", "Alaska", "Arizona", "Arkansas", "California", "Carolina del Norte",
            "Carolina del Sur", "Colorado", "Connecticut" };
    private String[] arr_estadosCb = { "Provincia de Pinar del Río.", "Provincia de La Habana.",
            "Provincia de Matanzas.", "Provincia de Santa Clara.", "Provincia de Puerto Príncipe.",
            "Provincia de Santiago de Cuba." };

    public ComboBox2() {
        initComponents();
        setResizable(false);
        setBounds(0, 0, 400, 500);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void initComponents() {
        pais = new JComboBox<String>();
        pais.setBounds(10, 10, 200, 20);
        pais.addItemListener(this);
        add(pais);

        estado = new JComboBox<String>();
        estado.setBounds(10, 50, 200, 20);
        add(estado);

        for (String temporal : arr_paises) {
            pais.addItem(temporal);
        }
    }

    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == pais) {
            estado.removeAllItems();
            Elegir_Estado();
        }
    }

    public void agregarImg(String ruta) {
        l1.setIcon(null);
        l1.setSize(400,500);
        ImageIcon imagen = new ImageIcon(ruta);
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(l1.getWidth(), l1.getHeight(), Image.SCALE_DEFAULT));
        l1.setIcon(icono);
        this.add(l1);

    }

    public void Elegir_Estado() {

        if ((String) pais.getSelectedItem() == "Mexico") {
            agregarImg("Mexico.jpg");
            for (String temporal : arr_estadoM) {
                estado.addItem(temporal);
            }
        }

        if ((String) pais.getSelectedItem() == "Estados Unidos") {
            agregarImg("Estados Unidos.jpg");
            for (String temporal : arr_estadosEU) {
                estado.addItem(temporal);
            }
        }

        if ((String) pais.getSelectedItem() == "Cuba") {
            agregarImg("Cuba.jpg");
            for (String temporal : arr_estadosCb) {
                estado.addItem(temporal);
            }
        }
        setTitle((String) pais.getSelectedItem());
    }

    public static void main(String[] args) {
        ComboBox2 f1 = new ComboBox2();
    }
}
