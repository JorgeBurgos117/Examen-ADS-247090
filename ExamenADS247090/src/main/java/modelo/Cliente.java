package src.main.java.modelo;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nombre;
    private String cuenta;
    private double saldo;

    private List<ClienteObserver> observers = new ArrayList<>();

    public Cliente(String nombre, String cuenta, double saldo) {
        this.nombre = nombre;
        this.cuenta = cuenta;
        this.saldo = saldo;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getCuenta() {
        return cuenta;
    }

    public double getSaldo() {
        return saldo;
    }


    public void retirar(double monto) {
        this.saldo -= monto;
        notificarObservers();
    }

    //observers
    public void addObserver(ClienteObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(ClienteObserver observer) {
        observers.remove(observer);
    }

    private void notificarObservers() {
        for (ClienteObserver observer : observers) {
            observer.actualizar(this);
        }
    }
}
