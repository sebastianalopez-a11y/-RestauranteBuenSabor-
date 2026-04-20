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

    private static final double Tasa_Iva = 0.19;
    private static final double Tasa_Propina = 0.10;
    private static final double Umbral_Propina = 50000;
    int total=0;

    public static void imprimirEmcabezado() {
        System.out.println("========================================");
        System.out.println("    " + Datos.Nombre_Restaurante);
        System.out.println("    " + Datos.Direccion);
        System.out.println("    NIT: " + Datos.Nit);
        System.out.println("========================================");
    }

    public static void imprimirCarta() {

        imprimirEmcabezado();
        for (int i = 0; i < Carta.productos.size(); i++) {
            Producto producto = Carta.productos.get(i);
            System.out.printf("%d. %-22s $%,.0f%n",
                    (i + 1),
                    producto.getNombre(),
                    producto.getPrecio());
        }
        System.out.println("========================================");
    }

    public static void mostrarPedido(Pedido pedido) {
        double SubTotal = 0;
        System.out.println("--- PEDIDO ACTUAL ---");

        for (ItemPedido item : pedido.getItems()) {
            double subtotalItem = item.calcularSubtotal();
            System.out.printf("%-20s x%-6d $%,.0f%n",
                    item.getProducto().getNombre(),
                    item.getCantidad(),
                    subtotalItem);

            SubTotal += subtotalItem;
        }
        System.out.println("--------------------");
        System.out.printf("%-27s $%,.0f%n", "Subtotal:", SubTotal);
    }

    private static void imprimirTotales(double subtotal, double iva, double propina, double total) {

        System.out.printf("%-27s $%,.0f%n", "Subtotal:", subtotal);
        System.out.printf("%-27s $%,.0f%n", "IVA:", iva);

        if (propina > 0) {
            System.out.printf("%-27s $%,.0f%n", "Propina:", propina);
        }

        System.out.println("----------------------------------------");
        System.out.printf("%-27s $%,.0f%n", "TOTAL:", total);
    }

    public static void imprimirFacturaCompleta(Factura factura) {

        imprimirEmcabezado();
// imprime cada item del pedido
        System.out.printf("FACTURA No. %03d%n", factura.getNumero());
        System.out.println("----------------------------------------");

        
        for (ItemPedido item : factura.getPedido().getItems()) {

            System.out.printf("%-20s x%-6d $%,.0f%n",
                    item.getProducto().getNombre(),
                    item.getCantidad(),
                    item.calcularSubtotal());
        }

        double subtotal = factura.calcularSubtotal();
        double iva = factura.calcularIVA();
        double propina = factura.calcularPropina();
        double total = factura.calcularTotal();

        System.out.println("----------------------------------------");

        System.out.printf("%-27s $%,.0f%n", "Subtotal:", subtotal);
        System.out.printf("%-27s $%,.0f%n", "IVA:", iva);

        if (propina > 0) {
            System.out.printf("%-27s $%,.0f%n", "Propina:", propina);
        }

        System.out.println("----------------------------------------");
        System.out.printf("%-27s $%,.0f%n", "TOTAL:", total);
    }
}
