
package src.main.java.vista.ui;

import src.main.java.modelo.Cliente;
import src.main.java.modelo.ClienteObserver;
import src.main.java.vista.styles.CustomLabel;
import src.main.java.vista.styles.RoundButton;
import src.main.java.vista.styles.Style;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PnlRetirarEfectivo extends JPanel implements ClienteObserver {

    Style style = new Style();
    FrmPrincipal frame;
    
    //Límite hardcodeado para la generación automática de botones
    double max = 4000;
    double incremento = 200;

    
    int cantidadBotones = (int) (max/incremento);
    RoundButton[] botones = new RoundButton[cantidadBotones];
    
    JPanel inputs = new JPanel();
    JScrollPane scroll = new JScrollPane();
    JPanel output = new JPanel();
    JPanel acomodo = new JPanel();
    JPanel acomodo2 = new JPanel();

    public RoundButton btnRetirar = new RoundButton("Confirmar retiro");
    RoundButton btnVolver = new RoundButton("Volver");

    //Output
    CustomLabel lblEstadoCuenta = new CustomLabel("Estado de cuenta");
    public String nombreCuenta;
    CustomLabel lblNombreCuenta = new CustomLabel("Nombre: " + nombreCuenta);
    public double saldoDisponible;
    CustomLabel lblSaldoDisponible = new CustomLabel("Saldo disponible: $" + saldoDisponible);
    public double montoActual = 0;
    CustomLabel lblMontoActual = new CustomLabel("Monto a retirar: $" + montoActual);
    public double montoComision = 0;
    CustomLabel lblMontoComision = new CustomLabel("Comisión por retiro: $" + montoComision);
    public double montoTotal = 0;
    CustomLabel lblMontoTotal = new CustomLabel("Total de la transacción: $" + montoTotal);
    public double saldoFinal = 0;
    CustomLabel lblSaldoFinal = new CustomLabel("Saldo después de la transacción: $" + saldoFinal);
    
    public PnlRetirarEfectivo(FrmPrincipal frame) {
        
        this.frame = frame;
        setLayout(new BorderLayout());
        //setLayout(new GridLayout(1, 4));
        
        //Inputs
        inputs.setLayout(new BoxLayout(inputs, BoxLayout.Y_AXIS));
        inputs.add(Box.createVerticalStrut(10));
            //Fábrica de botones
        double j = 0;
        for (int i = 0; i < cantidadBotones; i++) {
            j = j +incremento;
            botones[i] = new RoundButton("$" + j);

            double monto = j;
            botones[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    seleccionarMonto(monto);
                }
            });

            inputs.add(botones[i]);
            inputs.add(Box.createRigidArea(new Dimension(0, 10)));
        }

        //Output
        actualizarDatos();
        output.setLayout(new BoxLayout(output, BoxLayout.Y_AXIS));
        output.add(lblEstadoCuenta);
        output.add(lblNombreCuenta);
        output.add(lblSaldoDisponible);
        output.add(lblMontoActual);
        output.add(lblMontoComision);
        output.add(lblMontoTotal);
        output.add(lblSaldoFinal);
        btnRetirar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                retirarEfectivo(montoActual);
            }
        });
        output.add(btnRetirar);

        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                volver();
            }
        });

        //Setup final
        inputs.repaint();
        scroll.setViewportView(inputs);

        acomodo2.add(btnVolver);
        acomodo.setLayout(new BorderLayout());
        acomodo.add(acomodo2, BorderLayout.WEST);
        acomodo.add(scroll, BorderLayout.EAST);
        add(acomodo, BorderLayout.WEST);
        add(output, BorderLayout.EAST);

        System.out.println("Calando: En PnlRetirarEefectivo");
        setVisible(true);
        
    }

    public void seleccionarMonto(double monto) {
        System.out.println("Selección: $" + monto);

        montoActual = monto;

        double comision = 0.1; // mismo 10%
        montoComision = montoActual * comision;
        montoTotal = montoActual + montoComision;
        saldoFinal = saldoDisponible - montoTotal;

        actualizarDatos();
    }

    public void actualizarDatos() {

        lblNombreCuenta.setText("Nombre: " + nombreCuenta);
        lblSaldoDisponible.setText("Saldo disponible: $" + saldoDisponible);
        lblMontoActual.setText("Monto a retirar: $" + montoActual);
        lblMontoComision.setText("Comisión por retiro: $" + montoComision);
        lblMontoTotal.setText("Total de la transacción: $" + montoTotal);
        lblSaldoFinal.setText("Saldo después de la transacción: $" + saldoFinal);

        output.revalidate();
        output.repaint();
    }

    public void retirarEfectivo(double monto){
        System.out.println("Procediendo al retiro");
    }

    @Override
    public void actualizar(Cliente cliente) {
        this.nombreCuenta = cliente.getNombre();
        this.saldoDisponible = cliente.getSaldo();

        // Reset preview después de retiro real
        montoActual = 0;
        montoComision = 0;
        montoTotal = 0;
        saldoFinal = 0;

        actualizarDatos();
    }

    public void volver() {
        System.out.println("Regresando a menù principal");
        frame.volverMenu();
    }

    
}
