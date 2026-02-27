
package src.main.java.presentacion.ui;

import src.main.java.presentacion.styles.CustomLabel;
import src.main.java.presentacion.styles.RoundButton;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PnlRetirarEfectivo extends JPanel{
    
    FrmPrincipal frame;
    
    //Límite hardcodeado para la generación automática de botones
    double max = 4000;
    double incremento = 200;
    double comision = 0.1;

    
    int cantidadBotones = (int) (max/incremento);
    RoundButton[] botones = new RoundButton[cantidadBotones];
    
    JPanel inputs = new JPanel();
    JScrollPane scroll = new JScrollPane();
    JPanel output = new JPanel();

    RoundButton btnRetirar = new RoundButton("Confirmar retiro");

    //Output
    CustomLabel lblEstadoCuenta = new CustomLabel("Estado de cuenta");
    String nombreCuenta;
    CustomLabel lblNombreCuenta = new CustomLabel("Nombre: " + nombreCuenta);
    double saldoDisponible;
    CustomLabel lblSaldoDisponible = new CustomLabel("Saldo disponible: $" + saldoDisponible);
    double montoActual = 0;
    CustomLabel lblMontoActual = new CustomLabel("Monto a retirar: $" + montoActual);
    double montoComision = 0;
    CustomLabel lblMontoComision = new CustomLabel("Comisión por retiro: $" + montoComision);
    double montoTotal = 0;
    CustomLabel lblMontoTotal = new CustomLabel("Total de la transacción: $" + montoTotal);
    double saldoFinal = 0;
    CustomLabel lblSaldoFinal = new CustomLabel("Saldo después de la transacción: $" + saldoFinal);
    
    public PnlRetirarEfectivo(FrmPrincipal frame) {
        
        this.frame = frame;
        setLayout(new BorderLayout());
        
        //Inputs
        inputs.setLayout(new BoxLayout(inputs, BoxLayout.Y_AXIS));
        inputs.add(Box.createVerticalStrut(30));
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


        //Setup final
        inputs.repaint();
        scroll.setViewportView(inputs);
        add(scroll, BorderLayout.WEST);
        output.repaint();
        add(output, BorderLayout.EAST);
        System.out.println("Calando: En PnlRetirarEefectivo");
        setVisible(true);
        
    }

    public void seleccionarMonto(double monto) {
        System.out.println("Selección: $" + monto);
        montoActual = monto;
        actualizarDatos();
    }

    public void actualizarDatos() {
        System.out.println("Asume que se actualizaron los datos del cliente");

        //gettear saldo disponible real al rato
        saldoDisponible = 400;

        lblSaldoDisponible.setText("Saldo disponible: $" + saldoDisponible);
        lblMontoActual.setText("Monto a retirar: $" + montoActual);
        montoComision = montoActual*comision;
        lblMontoComision.setText("Comisión por retiro: $" + montoComision);
        montoTotal = montoActual + montoComision;
        lblMontoTotal.setText("Total de la transacción: $" + montoTotal);
        saldoFinal = saldoDisponible-montoTotal;
        lblSaldoFinal.setText("Saldo después de la transacción: $" + saldoFinal);

        output.revalidate();
        output.repaint();
    }

    public void retirarEfectivo(double monto){
        System.out.println("Procediendo al retiro");
    }
    
}
