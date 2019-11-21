/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.colt.dto;

/**
 *
 * @author
 */
public class CiudadDTO {
    
    private int idCiudad;
    String nombre;
    String departamento;
    String pais;

    public CiudadDTO() {
    }

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
    public Object[] showDataTable() {
        return new Object[]{this, idCiudad,nombre,departamento,pais};
    }

    @Override
    public String toString() {
        return idCiudad+"-"+nombre;
    }
    
}
