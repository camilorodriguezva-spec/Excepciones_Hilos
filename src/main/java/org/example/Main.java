package org.example;

public class Main {
    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria(500);
        double cantidadRetiro = 250;

        Thread cajero1 = new Thread(new Cajero(cuenta, cantidadRetiro), "Cajero-1");
        Thread cajero2 = new Thread(new Cajero(cuenta, cantidadRetiro), "Cajero-2");
        Thread cajero3 = new Thread(new Cajero(cuenta, cantidadRetiro), "Cajero-3");

        cajero1.start();
        cajero2.start();
        cajero3.start();

        try {
            cajero1.join();
            cajero2.join();
            cajero3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Saldo final: " + cuenta.getSaldo());
    }
}