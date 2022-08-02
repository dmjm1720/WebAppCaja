package com.dmjsistemas.model;
// Generated 13/07/2022 10:51:09 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Gasto generated by hbm2java
 */
public class Gasto  implements java.io.Serializable {


     private int idgasto;
     private Autos autos;
     private Tipos tipos;
     private Usuario usuario;
     private String departamento;
     private Date fechaCaptura;
     private String estado;
     private Set conceptos = new HashSet(0);

    public Gasto() {
    }

	
    public Gasto(int idgasto) {
        this.idgasto = idgasto;
    }
    public Gasto(int idgasto, Autos autos, Tipos tipos, Usuario usuario, String departamento, Date fechaCaptura, String estado, Set conceptos) {
       this.idgasto = idgasto;
       this.autos = autos;
       this.tipos = tipos;
       this.usuario = usuario;
       this.departamento = departamento;
       this.fechaCaptura = fechaCaptura;
       this.estado = estado;
       this.conceptos = conceptos;
    }
   
    public int getIdgasto() {
        return this.idgasto;
    }
    
    public void setIdgasto(int idgasto) {
        this.idgasto = idgasto;
    }
    public Autos getAutos() {
        return this.autos;
    }
    
    public void setAutos(Autos autos) {
        this.autos = autos;
    }
    public Tipos getTipos() {
        return this.tipos;
    }
    
    public void setTipos(Tipos tipos) {
        this.tipos = tipos;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public String getDepartamento() {
        return this.departamento;
    }
    
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    public Date getFechaCaptura() {
        return this.fechaCaptura;
    }
    
    public void setFechaCaptura(Date fechaCaptura) {
        this.fechaCaptura = fechaCaptura;
    }
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public Set getConceptos() {
        return this.conceptos;
    }
    
    public void setConceptos(Set conceptos) {
        this.conceptos = conceptos;
    }




}


