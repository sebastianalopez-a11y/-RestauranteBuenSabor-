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

    public static boolean validarProducto(Pedido pedido) {
        return pedido.tieneProductos();
    }

    public static void TomarPedido(Pedido pedido) {
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
        pedido.limpiar();
    }
}
