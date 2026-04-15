/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteelbuensabor;

/**
 *
 * @author alfre
 */
public class Imprimir {
public static void ImprimirCarta() {
        System.out.println("========================================");
        System.out.println("    RESTAURANTE EL BUEN SABOR");
        System.out.println("    --- NUESTRA CARTA ---");
        System.out.println("========================================");
        int i = 0;
        while (i < Datos.NombresPlatos.length) {
            System.out.printf("%d. %-22s $%,.0f%n", (i + 1), Datos.NombresPlatos[i], Datos.Precio[i]);
            i++;
        }// fin while
        System.out.println("========================================");
    }

    public static void mostrarPedido() {
        double SubTotal = 0;
        int i = 0;
        System.out.println("--- PEDIDO ACTUAL ---");
        while (i < Datos.NombresPlatos.length) {
            if (Datos.Cantidades[i] > 0) {
// imprime producto con cantidad y subtotal parcial
                System.out.printf("%-20s x%-6d $%,.0f%n", Datos.NombresPlatos[i], Datos.Cantidades[i], (Datos.Precio[i] * Datos.Cantidades[i]));
// suma al subtotal
                SubTotal = SubTotal + Datos.Precio[i] * Datos.Cantidades[i];
            }
            i++;
        }// fin while
        System.out.println("--------------------");
        System.out.printf("%-27s $%,.0f%n", "Subtotal:", SubTotal);
    }

    public static void imprimirFacturaCompleta() {
        double Subtotal = 0;
        double iva = 0;
        double Total = 0;
        double ValorPropina = 0;
        int CantidadProducto = 0;
        double SubtotalDescuento = 0;
// calcula subtotal otra vez
        int i = 0;
        while (i < Datos.NombresPlatos.length) {
            if (Datos.Cantidades[i] > 0) {
                Subtotal = Subtotal + Datos.Precio[i] * Datos.Cantidades[i];
                CantidadProducto = CantidadProducto + 1;
            }
            i++;
        }// fin while
        if (CantidadProducto > 3) {
            SubtotalDescuento = Subtotal - (Subtotal * 0.05);
        } else {
            SubtotalDescuento = Subtotal;
        }
        if (SubtotalDescuento > 50000) {
            iva = SubtotalDescuento * 0.19;
            Total = SubtotalDescuento + iva;
            ValorPropina = Total * 0.10;
            Total = Total + ValorPropina;
        } else {
            iva = SubtotalDescuento * 0.19;
            Total = SubtotalDescuento + iva;
            ValorPropina = 0;
        }// fin if-else
        String sep = "========================================";
        System.out.println(sep);
        System.out.println("    RESTAURANTE EL BUEN SABOR");
        System.out.println("    Calle 15 #8-32, Valledupar");
        System.out.println("    NIT: 900.123.456-7");
        System.out.println(sep);
        System.out.printf("FACTURA No. %03d%n", Datos.NumeroFacturas);
        System.out.println("----------------------------------------");
// imprime cada item del pedido
        int j = 0;
        while (j < Datos.NombresPlatos.length) {
            if (Datos.Cantidades[j] > 0) {
                System.out.printf("%-20s x%-6d $%,.0f%n", Datos.NombresPlatos[j], Datos.Cantidades[j], (Datos.Precio[j] * Datos.Cantidades[j]));
            }
            j++;
        }// fin while
        System.out.println("----------------------------------------");
        System.out.printf("%-27s $%,.0f%n", "Subtotal:", SubtotalDescuento);
        System.out.printf("%-27s $%,.0f%n", "IVA (19%):", iva);
        if (ValorPropina > 0) {
            System.out.printf("%-27s $%,.0f%n", "Propina (10%):", ValorPropina);
        }// fin if ValorPropina
        System.out.println("----------------------------------------");
        System.out.printf("%-27s $%,.0f%n", "TOTAL:", Total);
        System.out.println(sep);
        System.out.println("Gracias por su visita!");
        System.out.println("El Buen Sabor - Valledupar");
        System.out.println(sep);
// actualiza estado e incrementa factura - tres responsabilidades en un metodo
        Datos.NumeroFacturas = Datos.NumeroFacturas + 1;
        Datos.EstadoMesa = 0;
        Datos.Total = Total;
    }

    public static void imprimirFacturaResumen() {
        double Subtotal = 0;
        double iva = 0;
        double Total = 0;
        double ValorPropina = 0;
        int CantidadProducto = 0;
        double SubtotalDescuento = 0;
// calcula subtotal otra vez igual que en imprimirFacturaCompleta
        int i = 0;
        while (i < Datos.NombresPlatos.length) {
            if (Datos.Cantidades[i] > 0) {
                Subtotal = Subtotal + Datos.Precio[i] * Datos.Cantidades[i];
                CantidadProducto = CantidadProducto + 1;
            }
            i++;
        }// fin while
        if (CantidadProducto > 3) {
            SubtotalDescuento = Subtotal - (Subtotal * 0.05);
        } else {
            SubtotalDescuento = Subtotal;
        }
        if (SubtotalDescuento > 50000) {
            iva = SubtotalDescuento * 0.19;
            Total = SubtotalDescuento + iva;
            ValorPropina = Total * 0.10;
            Total = Total + ValorPropina;
        } else {
            iva = SubtotalDescuento * 0.19;
            Total = SubtotalDescuento + iva;
            ValorPropina = 0;
        }// fin if-else
        String sep = "========================================";
        System.out.println(sep);
        System.out.println("    RESTAURANTE EL BUEN SABOR");
        System.out.println("    Calle 15 #8-32, Valledupar");
        System.out.println("    NIT: 900.123.456-7");
        System.out.println(sep);
        System.out.printf("FACTURA No. %03d (RESUMEN)%n", Datos.NumeroFacturas);
        System.out.println("----------------------------------------");
        System.out.printf("%-27s $%,.0f%n", "Subtotal:", SubtotalDescuento);
        System.out.printf("%-27s $%,.0f%n", "IVA (19%):", iva);
        if (ValorPropina > 0) {
            System.out.printf("%-27s $%,.0f%n", "Propina (10%):", ValorPropina);
        }// fin if ValorPropina
        System.out.println("----------------------------------------");
        System.out.printf("%-27s $%,.0f%n", "TOTAL:", Total);
        System.out.println(sep);
    }
}
