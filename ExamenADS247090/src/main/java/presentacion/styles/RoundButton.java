
package src.main.java.presentacion.styles;

import javax.swing.JButton;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RoundButton extends JButton{

    int cornerRadius;
    Color color, colorHover;
    boolean borde = false;
    boolean hovered = false;

    double monto;

    Style style = new Style();

    //Botón base
    public RoundButton(String texto) {
        super(texto);
        this.cornerRadius = style.cornerRadius;
        this.color = style.colorPrincipal;
        //setSize(style.dimensionBoton);
        setForeground(style.colorTexto);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setOpaque(false);


        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                hovered = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hovered = false;
                repaint();
            }
        });
        setUI(new BasicButtonUI());
    }

    //Botón que indica dinero
    public RoundButton(String texto, double monto) {
        super(texto);
        this.cornerRadius = style.cornerRadius;
        this.color = style.colorPrincipal;
        //setSize(style.dimensionBoton);
        setForeground(style.colorTexto);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setOpaque(false);

        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                hovered = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hovered = false;
                repaint();
            }
        });
        setUI(new BasicButtonUI());
    }

    public RoundButton(String texto, Color color) {
        super(texto);
        this.cornerRadius = style.cornerRadius;
        this.color = color;
        //setSize(style.dimensionBoton);
        setForeground(style.colorTexto);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setOpaque(false);


        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                hovered = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hovered = false;
                repaint();
            }
        });
        setUI(new BasicButtonUI());
    }

    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(hovered ? colorHover : color);
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);
        if (borde){
            g2d.setStroke(new BasicStroke(.5f));
            g2d.setColor(Color.white);
            g2d.drawRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);
        }
        g2d.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, cornerRadius, cornerRadius);
        super.paintComponent(g);
        g2d.dispose();

    }
}
