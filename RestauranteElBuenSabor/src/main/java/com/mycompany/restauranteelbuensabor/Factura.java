/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteelbuensabor;

/**
 *
 * @author alfre
 */
public class Factura {

    private final Pedido pedido;
    private final int numero;

    private static final double Tasa_Iva = 0.19;
    private static final double Tasa_Propina = 0.10;
    private static final double Tasa_Descuento = 0.05;
    private static final double Umbral_Propina = 50000;
    private static final double Descuento = 0.01;
    private static final int Min_Items_Descuento = 3;

    public Factura(Pedido pedido, int numero) {
        this.pedido = pedido;
        this.numero = numero;
    }
    public double calcularSubtotal() {
        return pedido.calcularSubtotal();
    }

    public int contarItems() {
        return pedido.contarItemsDiferentes();
    }

    public double calcularDescuento() {
        double subtotal = calcularSubtotal();

        if (contarItems() > Min_Items_Descuento) {
            return subtotal * Tasa_Descuento;
        }

        return 0;
    }

    public double calcularBase() {
        return calcularSubtotal() - calcularDescuento();
    }

    public double calcularIVA() {
        return calcularBase() * Tasa_Iva;
    }

    public double calcularPropina() {
        double base = calcularBase();

        if (base > Umbral_Propina) {
            return base * Tasa_Propina;
        }

        return 0;
    }

    public double calcularTotal() {
        return calcularBase() + calcularIVA() + calcularPropina();
    }

    public int getNumero() {
        return numero;
    }

    public Pedido getPedido() {
        return pedido;
    }
}
