/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteelbuensabor;

/**
 *
 * @author alfre
 */
public class Proceso {
 public static double CalcularHacerFactura() {
        double Subtotal = 0;
        double iva = 0;
        double Total = 0;
        double SubtotalConDescuento = 0;
        int CantidadProducto = 0;
        int i = 0;
        while (i < Datos.NombresPlatos.length) {
            if (Datos.Cantidades[i] > 0) {
// multiplica precio por cantidad
                Subtotal = Subtotal + Datos.Precio[i] * Datos.Cantidades[i];
                CantidadProducto = CantidadProducto + 1;
            }
            i++;
        }// fin while
        if (CantidadProducto > 3) {
            if (Subtotal > 0) {
                SubtotalConDescuento = Subtotal - (Subtotal * 0.05);
                if (SubtotalConDescuento > 50000) {
                    iva = SubtotalConDescuento * 0.19;
// suma iva al subtotal con descuento
                    Total = SubtotalConDescuento + iva;
                    Total = Total + (Total * 0.10);
                } else {
// suma iva al subtotal
                    iva = SubtotalConDescuento * 0.19;
                    Total = SubtotalConDescuento + iva;
                }
            }// fin if Subtotal>0
// version anterior - no borrar
// Subtotal = Subtotal * 1.19;
// if(Subtotal > 40000) Subtotal = Subtotal + (Subtotal*0.10);
// return Subtotal;
        } else {
            if (Subtotal > 50000) {
                iva = Subtotal * 0.19;
// suma iva al subtotal
                Total = Subtotal + iva;
                Total = Total + (Total * 0.10);
            } else {
                iva = Subtotal * 0.19;
                Total = Subtotal + iva;
            }
        }// fin if-else CantidadProducto
        Datos.EstadoMesa = 1;
        Datos.Total = Total;
        return Total;
    }

    public static double CalcularTotal(double Precio, double Cantidad, double Descuento, double Iva, double Propina, int NumeroItems, boolean AplicaPropina) {
        double Resultado = 0;
        double iva = 0;
        double ValorPropina = 0;
        double ValorIva = 0;
// calcula subtotal con cantidad
        Resultado = Precio * Cantidad;
        if (Descuento > 0) {
// aplica descuento
            Resultado = Resultado - (Resultado * Descuento);
        }
// calcula iva
        iva = Resultado * Iva;
        ValorIva = iva;
        Resultado = Resultado + ValorIva;
        if (AplicaPropina) {
// aplica propina si corresponde
            ValorPropina = Resultado * Propina;
            Resultado = Resultado + ValorPropina;
        }
        if (NumeroItems > 3) {
            Resultado = Resultado - (Resultado * 0.01);
        }
        return Resultado;
    }
}
