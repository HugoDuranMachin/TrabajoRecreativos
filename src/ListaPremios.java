/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author developer
 */
public class ListaPremios {

    public Premio BALON = new Premio("Balón", Random(200), Random(20));
    public Premio PELUCHE = new Premio("Peluche", Random(200), Random(20));
    public Premio FUTBOLIN = new Premio("Futbolín", Random(200), Random(20));
    public Premio CONSOLA = new Premio("Consola", Random(200), Random(20));
    public Premio FIGURA = new Premio("Figura", Random(200), Random(20));
    public Premio CHUCHES = new Premio("Chuches", Random(200), Random(20));
    public Premio ENTRADA = new Premio("Entrada", Random(200), Random(20));
    public Premio VIDEOJUEGO = new Premio("Videojuego", Random(200), Random(20));
    public Premio ROPA = new Premio("Ropa", Random(200), Random(20));
    public Premio COMIDA = new Premio("Comida", Random(200), Random(20));
    public Premio MISTERYBOX = new Premio("Mystery box", Random(200), Random(20));

    public int Random(int limit) {
        return (int) (Math.random() * limit);
    }
    
    
}