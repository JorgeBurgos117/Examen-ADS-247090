
package src.main.java.vista.ui;

import src.main.java.controlador.RetiroController;
import src.main.java.modelo.Cliente;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FrmPrincipal extends JFrame{
    
    JLabel lblTitulo = new JLabel("BBVA");
    
    JPanel contenido;
    Cliente cliente;
        
    
    public FrmPrincipal(Cliente cliente) {
        
        //Establecimiento del frame
        //setSize(style.dimensionFrame);
        setSize(720, 480);
        //getContentPane().setBackground(style.colorBase);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        //setLayout(new BoxLayout(this, 1));
        this.cliente = cliente;
        
        contenido = new PnlMenu(this);
        contenido.add(lblTitulo);
        add(contenido);

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
    
}
