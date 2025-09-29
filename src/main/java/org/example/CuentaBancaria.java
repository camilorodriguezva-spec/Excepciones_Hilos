package org.example;

public class CuentaBancaria {
    private double saldo;

    public CuentaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public synchronized void depositar(double cantidad) {
        saldo += cantidad;
        System.out.println(Thread.currentThread().getName() + " depositó " + cantidad + ". Saldo actual: " + saldo);
    }

    public synchronized void retirar(double cantidad) throws SaldoInsuficienteException {
        if (cantidad > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente para retirar " + cantidad + ". Saldo actual: " + saldo);
        }
        saldo -= cantidad;
        System.out.println(Thread.currentThread().getName() + " retiró " + cantidad + ". Saldo actual: " + saldo);
    }

    public double getSaldo() {
        return saldo;
    }
}
