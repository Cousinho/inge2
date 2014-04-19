/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Componentes;

//clase editorial 
public abstract class Editorial {

    private String cod_editorial;
    private String nombre_editorial;

    public String getCod_Editorial() {
        return cod_editorial;
    }

    public void setCod_Editorial(String set_editorial) {
        this.cod_editorial = set_editorial;
    }

    public String getNombre_Editorial() {
        return nombre_editorial;
    }

    public void setNombre(String set_nombre) {
        this.nombre_editorial = set_nombre;
    }
}
