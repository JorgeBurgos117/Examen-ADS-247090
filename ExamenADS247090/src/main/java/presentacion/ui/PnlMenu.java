
package src.main.java.presentacion.ui;

import src.main.java.presentacion.styles.RoundButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class PnlMenu extends JPanel{
    
    FrmPrincipal frame;
    
    JLabel lblTitulo = new JLabel("Menú principal");
    
    JPanel contenido = new JPanel();
    
    RoundButton btnEjemplo1 = new RoundButton("(Botón de ejemplo)");
    RoundButton btnEjemplo2 = new RoundButton("(Botón de ejemplo)");
    RoundButton btnRetirarEfectivo = new RoundButton("Retirar efectivo");
    RoundButton btnEjemplo3 = new RoundButton("(Botón de ejemplo)");
    
    public PnlMenu(FrmPrincipal frame){
        this.frame = frame;
        
        //Establecimiento del panel
        setLayout(new BoxLayout(this, 1));
        add(lblTitulo);
        add(contenido);


        ActionListener l = new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Este botón es solo un ejemplo");
                }
        };
        btnEjemplo1.addActionListener(l);
        btnEjemplo2.addActionListener(l);
        btnEjemplo3.addActionListener(l);
        
        btnRetirarEfectivo.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    seleccionRetirarEfectivo();
                }
        });
        
        contenido.add(btnEjemplo1);
        contenido.add(btnEjemplo2);
        contenido.add(btnRetirarEfectivo);
        contenido.add(btnEjemplo3);
        
        
        
    }
    
    public void seleccionRetirarEfectivo() {
        System.out.println("Procediendo al retiro de efectivo");
        frame.retirarEfectivo();
    }
}
