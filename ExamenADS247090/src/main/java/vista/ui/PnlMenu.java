
package src.main.java.vista.ui;

import src.main.java.vista.styles.CustomLabel;
import src.main.java.vista.styles.RoundButton;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class PnlMenu extends JPanel{
    
    FrmPrincipal frame;
    
    CustomLabel lblTitulo = new CustomLabel("Menú principal", 32);

    JPanel acomodo = new JPanel();
    JPanel contenido = new JPanel();
    
    RoundButton btnEjemplo1 = new RoundButton("(Botón de ejemplo)");
    RoundButton btnEjemplo2 = new RoundButton("(Botón de ejemplo)");
    RoundButton btnRetirarEfectivo = new RoundButton("Retirar efectivo");
    RoundButton btnEjemplo3 = new RoundButton("(Botón de ejemplo)");
    
    public PnlMenu(FrmPrincipal frame){
        this.frame = frame;
        
        //Establecimiento del panel
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        contenido.setLayout(new BoxLayout(contenido, BoxLayout.Y_AXIS));

        acomodo.setLayout(new GridLayout(1, 4));
        acomodo.add(new JLabel(""));
        acomodo.add(contenido);
        acomodo.add(new JLabel(""));
        acomodo.add(new JLabel(""));
        add(acomodo);


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

        contenido. add(lblTitulo);
        contenido.add(Box.createRigidArea(new Dimension(0, 30)));
        contenido.add(btnEjemplo1);
        contenido.add(Box.createRigidArea(new Dimension(0, 10)));
        contenido.add(btnEjemplo2);
        contenido.add(Box.createRigidArea(new Dimension(0, 10)));
        contenido.add(btnRetirarEfectivo);
        contenido.add(Box.createRigidArea(new Dimension(0, 10)));
        contenido.add(btnEjemplo3);

    }

    public void seleccionRetirarEfectivo() {
        System.out.println("Procediendo al retiro de efectivo (inicio del caso de uso)");
        frame.retirarEfectivo();
    }
}
