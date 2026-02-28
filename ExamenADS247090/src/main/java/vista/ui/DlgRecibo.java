package src.main.java.vista.ui;

import javax.swing.*;
import java.awt.*;

public class DlgRecibo extends JDialog {

    public DlgRecibo(Frame parent, String nombre, String cuenta, double saldoAnterior, double monto, double comision, double total, double saldoFinal) {

        super(parent, "Resumen de la transacción", true); // modal

        setLayout(new BorderLayout());

        JPanel panelDatos = new JPanel();
        panelDatos.setLayout(new BoxLayout(panelDatos, BoxLayout.Y_AXIS));
        panelDatos.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panelDatos.add(new JLabel("Nombre: " + nombre));
        panelDatos.add(Box.createVerticalStrut(5));
        panelDatos.add(new JLabel("Cuenta: " + cuenta));
        panelDatos.add(Box.createVerticalStrut(10));
        panelDatos.add(new JLabel("Saldo anterior: $" + saldoAnterior));
        panelDatos.add(new JLabel("Monto retirado: $" + monto));
        panelDatos.add(new JLabel("Comisión (10%): $" + comision));
        panelDatos.add(new JLabel("Total descontado: $" + total));
        panelDatos.add(new JLabel("Saldo final: $" + saldoFinal));

        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(e -> dispose());

        JPanel panelBoton = new JPanel();
        panelBoton.add(btnCerrar);

        add(panelDatos, BorderLayout.CENTER);
        add(panelBoton, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(parent);
    }
}