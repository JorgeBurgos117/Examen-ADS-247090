
package presentacion.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import presentacion.styles.RoundButton;


public class PnlMenu extends JPanel{
    
    FrmPrincipal frame;
    
    JLabel lblTitulo = new JLabel("Menú principal");
    
    JPanel contenido = new JPanel();
    
    RoundButton btnEjemplo = new RoundButton("(Botón de ejemplo)");
    RoundButton btnRetirarEfectivo = new RoundButton("Retirar efectivo");
    
    public PnlMenu(FrmPrincipal frame){
        this.frame = frame;
        
        //Establecimiento del panel
        setLayout(new BoxLayout(this, 1));
        add(lblTitulo);
        add(contenido);
        
        btnEjemplo.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Este botón es solo un ejemplo");
                }
        });
        
        btnRetirarEfectivo.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    seleccionRetirarEfectivo();
                }
        });
        
        contenido.add(btnEjemplo);
        contenido.add(btnEjemplo);
        contenido.add(btnRetirarEfectivo);
        contenido.add(btnEjemplo);
        
        
        
    }
    
    public void seleccionRetirarEfectivo() {
        System.out.println("Procediendo al retiro de efectivo");
    }
}
