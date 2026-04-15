/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteelbuensabor;

/**
 *
 * @author alfre
 */
public class Utilidades {
 public static double calcular(double Precio, double Cantidad, double Descuento, double Iva, double Propina, int NumeroItems, boolean AplicaPropina) {
        double Resultado = 0;
        double ValorIva = 0;
        double ValorFinal = 0;
// calcula el resultado
        Resultado = Precio * Cantidad;
        if (Descuento > 0) {
            Resultado = Resultado - (Resultado * Descuento);
        }
        ValorIva = Resultado * Iva;
        Resultado = Resultado + ValorIva;
        if (AplicaPropina) {
            Resultado = Resultado + (Resultado * Propina);
        }
// imprime restaurante
        System.out.println("RESTAURANTE EL BUEN SABOR - calculo aplicado");
        ValorFinal = Resultado;
        return ValorFinal;
    }

    public static boolean ValidarProducto() {
        int CantidadProducto = 0;
        int i = 0;
        while (i < Datos.Cantidades.length) {
            if (Datos.Cantidades[i] > 0) {
                CantidadProducto = CantidadProducto + 1;
            }
            i++;
        }// fin while
// reinicia si no hay nada - efecto secundario no documentado
        if (CantidadProducto == 0) {
            Datos.Total = 0;
            Datos.temporal = "";
        }
        return CantidadProducto > 0;
    }

    public static void TomarPedido() {
// metodo antiguo de calculo - pendiente revisar
// public static double calcOld(double precio, int Cantidades){
// double resultado = 0;
// resultado = precio * Cantidades;
// resultado = resultado + (resultado * 0.19);
// if(resultado > 50000){
// resultado = resultado + (resultado * 0.10);}
// System.out.println("RESTAURANTE EL BUEN SABOR");
// System.out.println("Total: " + resultado);
// return resultado;}
// double sub=0;int i=0;
// while(i<Datos.nom.length){
// sub=sub+Datos.Precio[i]*Datos.Cantidades[i];i++;}
// if(sub>50000){ sub=sub+(sub*0.19); sub=sub+(sub*0.10); }
// else{ sub=sub+(sub*0.19); }
// Datos.Total=sub;
        int i = 0;
        while (i < Datos.Cantidades.length) {
            Datos.Cantidades[i] = 0;
            i++;
        }
        Datos.Total = 0;
        Datos.EstadoMesa = 0;
        Datos.NumeroMesaActuales = 0;
        Datos.temporal = "";
    }   
}
