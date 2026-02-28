
package src.main.java.vista.ui;

import src.main.java.controlador.RetiroController;
import src.main.java.modelo.Cliente;
import src.main.java.vista.styles.CustomLabel;
import src.main.java.vista.styles.Style;

import javax.swing.*;
import java.awt.*;

public class FrmPrincipal extends JFrame{

    Style style = new Style();

    JPanel encabezado = new JPanel();
    CustomLabel lblTitulo = new CustomLabel("  BBVA", 48);
    JPanel raya = new JPanel();


    JPanel contenido;
    Cliente cliente;
        
    
    public FrmPrincipal(Cliente cliente) {
        
        //Establecimiento del frame
        setSize(style.dimensionFrame);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        this.cliente = cliente;

        encabezado.setLayout(new BoxLayout(encabezado, BoxLayout.Y_AXIS));
        encabezado.setSize(400, 80);
        //encabezado.setLayout(new GridLayout(4, 1));
        encabezado.add(lblTitulo);
        raya.setSize(style.frameX, 20);
        raya.setBackground(style.colorPrincipal);
        encabezado.add(raya);
        add(encabezado, BorderLayout.NORTH);
        contenido = new PnlMenu(this);
        add(contenido, BorderLayout.CENTER);

        repaint();
        setVisible(true);
    }
    
    public void retirarEfectivo() {
        System.out.println("Desplegando menú de retiro de efectivo");
        remove(contenido);
        PnlRetirarEfectivo pnlRetirarEfectivo = new PnlRetirarEfectivo(this);
        RetiroController controller = new RetiroController(cliente, pnlRetirarEfectivo);
        contenido = pnlRetirarEfectivo;
        add(contenido);
        revalidate();
        repaint();
    }

    public void volverMenu() {
        remove(contenido);
        contenido = new PnlMenu(this);
        add(contenido);
        revalidate();
        repaint();
    }
    
}
