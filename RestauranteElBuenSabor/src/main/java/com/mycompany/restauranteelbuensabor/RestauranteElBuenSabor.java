/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.restauranteelbuensabor;

import java.util.Scanner;

/**
 *
 * @author alfre
 */
public class RestauranteElBuenSabor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op = 0;
        boolean Ejecutando = true;
        int ContadorIntentos = 0;
        String Temporal = "";
        int ValorTemporal = 0;
        double totalCalculado = 0;
        boolean continuar = true;
        int contadorIntentos = 0;
        int numeroFactura = 1;
        Pedido pedido = new Pedido();
        
        System.out.println("========================================");
        System.out.println("    RESTAURANTE EL BUEN SABOR");
        System.out.println("    Calle 15 #8-32, Valledupar");
        System.out.println("    NIT: 900.123.456-7");
        System.out.println("========================================");
        
        while (Ejecutando) {
            System.out.println("1. Ver carta");
            System.out.println("2. Agregar producto al pedido");
            System.out.println("3. Ver pedido actual");
            System.out.println("4. Generar factura");
            System.out.println("5. Nueva mesa");
            System.out.println("0. Salir");
            System.out.println("========================================");
            System.out.print("Seleccione una opcion: ");
            op = sc.nextInt();
            if (op == 1) {
             Imprimir.imprimirCarta();
              System.out.println();
            } else if (op == 2) {
             System.out.println("--- AGREGAR PRODUCTO ---");
                    System.out.print("Numero de producto (1-" + Carta.productos.size() + "): ");
                    int numeroProducto = sc.nextInt();
                    System.out.print("Cantidad: ");
                    int cantidad = sc.nextInt();
                    if (numeroProducto > 0 && numeroProducto <= Carta.productos.size()) {
                        if (cantidad > 0) {
                            Producto producto = Carta.productos.get(numeroProducto - 1);
                            pedido.agregarItem(producto, cantidad);
                            System.out.println("Producto agregado al pedido.");
                            System.out.println("  -> " + producto.getNombre() + " x" + cantidad);
                        } else {
                            System.out.println("Cantidad invalida.");
                        }
                    } else {
                        System.out.println("Producto no existe.");
                    }
                    System.out.println();
                    
            } else if (op == 3) {

                 System.out.println();
                    if (pedido.tieneProductos()) {
                        Imprimir.mostrarPedido(pedido); 
                    } else {
                        System.out.println("No hay productos en el pedido.");
                    }
                    System.out.println();
            } else if (op == 4) {

               if (pedido.tieneProductos()) {
                   Factura factura = new Factura(pedido, numeroFactura);
                   Imprimir.imprimirFacturaCompleta(factura);
                   numeroFactura++;

                    } else {
                        System.out.println("No hay productos para facturar.");
                    }
            } else if (op == 5) {

                System.out.println();
                pedido.limpiar();

                ContadorIntentos = 0;
                ValorTemporal = 0;
                Temporal = "";
                totalCalculado = 0;
                continuar = true;
                System.out.println("Mesa reiniciada. Lista para nuevo cliente.");
                System.out.println();
            } else if (op == 0) {
                Ejecutando = false;
                System.out.println("Hasta luego!");
            } else {

                System.out.println("Opcion no valida. Seleccione entre 0 y 5.");        
                ContadorIntentos = ContadorIntentos + 1;
                if (ContadorIntentos > 3) {
                    System.out.println("Demasiados intentos invalidos.");
                    ContadorIntentos = 0;

                }
            }
        }
        sc.close();
    }
}
