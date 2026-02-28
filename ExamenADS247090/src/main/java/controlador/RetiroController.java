package src.main.java.controlador;

import src.main.java.modelo.Cliente;
import src.main.java.vista.ui.DlgRecibo;
import src.main.java.vista.ui.PnlRetirarEfectivo;

public class RetiroController {

    private Cliente cliente;
    private PnlRetirarEfectivo vista;

    private double comision = 0.1; // 10%

    public RetiroController(Cliente cliente, PnlRetirarEfectivo vista) {
        this.cliente = cliente;
        this.vista = vista;

        inicializar();
    }

    private void inicializar() {
        cliente.addObserver(vista);

        vista.nombreCuenta = cliente.getNombre();
        vista.saldoDisponible = cliente.getSaldo();
        vista.actualizarDatos();

        vista.btnRetirar.addActionListener(e -> procesarRetiro());
    }

    private void procesarRetiro() {

        double monto = vista.montoActual;

        if (monto <= 0) {
            System.out.println("Selecciona un monto válido.");
            return;
        }

        double montoComision = monto * comision;
        double montoTotal = monto + montoComision;

        if (montoTotal > cliente.getSaldo()) {
            System.out.println("Saldo insuficiente.");
            return;
        }

        double saldoAnterior = cliente.getSaldo();

        cliente.retirar(montoTotal);

        double saldoFinal = cliente.getSaldo();

        //recibo
        DlgRecibo dialog = new DlgRecibo(null, cliente.getNombre(), cliente.getCuenta(), saldoAnterior, monto, montoComision, montoTotal, saldoFinal);

        dialog.setVisible(true);

        System.out.println("Retiro exitoso.");
    }


}