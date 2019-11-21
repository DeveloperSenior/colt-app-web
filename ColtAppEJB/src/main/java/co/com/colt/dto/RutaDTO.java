/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.colt.dto;

/**
 *
 * @author user
 */
public class RutaDTO {
    
    private int idRuta;
    private String descripcion;
    private String codigo;
    private CiudadDTO origen;
    private CiudadDTO destino;

    public RutaDTO() {
    }


    public int getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public CiudadDTO getOrigen() {
        return origen;
    }

    public void setOrigen(CiudadDTO origen) {
        this.origen = origen;
    }

    public CiudadDTO getDestino() {
        return destino;
    }

    public void setDestino(CiudadDTO destino) {
        this.destino = destino;
    }

    public Object[] showDataTable() {
        return new Object[]{this,codigo,descripcion,origen.getNombre(),destino.getNombre()};
    }
    
}
