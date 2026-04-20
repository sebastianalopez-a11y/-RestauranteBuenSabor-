/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteelbuensabor;

import java.util.ArrayList;
import java.util.List;

public class Carta {

    public static List<Producto> productos = new ArrayList<>();

    static {
        productos.add(new Producto("Bandeja Paisa", 32000));
        productos.add(new Producto("Sancocho de Gallina", 28000));
        productos.add(new Producto("Arepa con Huevo", 8000));
        productos.add(new Producto("Jugo Natural", 7000));
        productos.add(new Producto("Gaseosa", 4500));
        productos.add(new Producto("Cerveza Poker", 6000));
        productos.add(new Producto("Agua Panela", 3500));
        productos.add(new Producto("Arroz con Pollo", 25000));
    }
}
