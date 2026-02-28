package src.main.java.vista.styles;

import javax.swing.*;
import java.awt.*;

public class CustomLabel extends JLabel {

    Style style = new Style();

    //Cosntructor para tamaño de fuente custom
    public CustomLabel(String texto, int size) {
        setFont(new Font("Arial", Font.BOLD, size));
        setForeground(Color.BLACK);
        setText(texto);
        setHorizontalAlignment(SwingConstants.CENTER);
    }

    //Cosntructor para tamaño de texto base
    public CustomLabel(String texto) {
        setFont(new Font("Arial", Font.BOLD, style.letraSize));
        setForeground(Color.BLACK);
        setText(texto);
        setHorizontalAlignment(SwingConstants.CENTER);
    }

}