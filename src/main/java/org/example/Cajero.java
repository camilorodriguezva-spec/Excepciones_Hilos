package org.example;

public class Cajero implements Runnable {
    private final CuentaBancaria cuenta;
    private final double cantidad;

    public Cajero(CuentaBancaria cuenta, double cantidad) {
        this.cuenta = cuenta;
        this.cantidad = cantidad;
    }

    @Override
    public void run() {
        try {
            cuenta.retirar(cantidad);
        } catch (SaldoInsuficienteException e) {
            System.out.println(Thread.currentThread().getName() + ": " + e.getMessage());
        }
    }
}

