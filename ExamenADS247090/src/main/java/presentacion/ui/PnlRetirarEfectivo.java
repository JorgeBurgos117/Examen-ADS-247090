
package presentacion.ui;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import presentacion.styles.RoundButton;

public class PnlRetirarEfectivo extends JPanel{
    
    FrmPrincipal frame;
    
    //Límite hardcodeado para la generación de botones
    double max = 8000;
    double incremento = 200;
    
    int cantidadBotones = (int) (max/incremento);
    RoundButton[] botones = new RoundButton[cantidadBotones];
    
    JPanel inputs;
    JPanel output;
    
    public PnlRetirarEfectivo(FrmPrincipal frame) {
        
        this.frame = frame;
        setLayout(new BorderLayout());
        
        //nota: settear inputspara que sea scrolleable
        
        for (double i = incremento; i <= max; i = i+incremento) {
            botones[(int)(i)] = new RoundButton("$" + i);
            inputs.add(botones[(int)(i)]);
        }
        
        add(inputs, BorderLayout.WEST);
        add(output, BorderLayout.EAST);
        
        
    }
    
}
