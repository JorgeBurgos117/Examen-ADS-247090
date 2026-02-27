
package src.main.java.presentacion.ui;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FrmPrincipal extends JFrame{
    
    JLabel lblTitulo = new JLabel("BBVA");
    
    JPanel contenido;
        
    
    public FrmPrincipal() {
        
        //Establecimiento del frame
        //setSize(style.dimensionFrame);
        setSize(720, 480);
        //getContentPane().setBackground(style.colorBase);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        //setLayout(new BoxLayout(this, 1));
        
        contenido = new PnlMenu(this);
        contenido.add(lblTitulo);
        add(contenido);

        repaint();
        setVisible(true);
    }
    
    public void retirarEfectivo() {
        System.out.println("Desplegando menú de retiro de efectivo");
        remove(contenido);
        contenido = new PnlRetirarEfectivo(this);
        add(contenido);
        revalidate();
        repaint();
    }
    
}
