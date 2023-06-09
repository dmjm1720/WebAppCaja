package com.dmjsistemas.model;
// Generated 13/07/2022 10:51:09 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Usuario generated by hbm2java
 */
public class Usuario  implements java.io.Serializable {


     private int idusuario;
     private String nombre;
     private String correo;
     private String clave;
     private String perfil;
     private String claveSap;
     private String folio;
     private Set gastos = new HashSet(0);
     private Set polizas = new HashSet(0);

    public Usuario() {
    }

	
    public Usuario(int idusuario) {
        this.idusuario = idusuario;
    }
    public Usuario(int idusuario, String nombre, String correo, String clave, String perfil, String claveSap, String folio, Set gastos, Set polizas) {
       this.idusuario = idusuario;
       this.nombre = nombre;
       this.correo = correo;
       this.clave = clave;
       this.perfil = perfil;
       this.claveSap = claveSap;
       this.folio = folio;
       this.gastos = gastos;
       this.polizas = polizas;
    }
   
    public int getIdusuario() {
        return this.idusuario;
    }
    
    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCorreo() {
        return this.correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getClave() {
        return this.clave;
    }
    
    public void setClave(String clave) {
        this.clave = clave;
    }
    public String getPerfil() {
        return this.perfil;
    }
    
    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
    public String getClaveSap() {
        return this.claveSap;
    }
    
    public void setClaveSap(String claveSap) {
        this.claveSap = claveSap;
    }
    public String getFolio() {
        return this.folio;
    }
    
    public void setFolio(String folio) {
        this.folio = folio;
    }
    public Set getGastos() {
        return this.gastos;
    }
    
    public void setGastos(Set gastos) {
        this.gastos = gastos;
    }
    public Set getPolizas() {
        return this.polizas;
    }
    
    public void setPolizas(Set polizas) {
        this.polizas = polizas;
    }




}


