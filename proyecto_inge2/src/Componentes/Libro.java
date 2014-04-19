/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Componentes;

public abstract class Libro {

    private String cod_libro;
    private String nombre_libro;
    private String autor;
    private String anho_publicacion;
    private int cantidad;
    private Editorial cod_editorial;

    public String getCod_libro() {
        return cod_libro;
    }

    public void setCod_libro(String cod_libro) {
        this.cod_libro = cod_libro;
    }

    public String getNombre_libro() {
        return nombre_libro;
    }

    public void setNombre_libro(String nombre_libro) {
        this.nombre_libro = nombre_libro;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAnho_publicacion() {
        return anho_publicacion;
    }

    public void setAnho_publicacion(String anho_publicacion) {
        this.anho_publicacion = anho_publicacion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Editorial getCod_editorial() {
        return cod_editorial;
    }

    public void setCod_editorial(Editorial cod_editorial) {
        this.cod_editorial = cod_editorial;
    }

    
    
    
    
}
