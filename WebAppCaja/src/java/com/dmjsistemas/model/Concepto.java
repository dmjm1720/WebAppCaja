package com.dmjsistemas.model;
// Generated 13/07/2022 10:51:09 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Concepto generated by hbm2java
 */
public class Concepto  implements java.io.Serializable {


     private int idconcepto;
     private Gasto gasto;
     private Date fecha;
     private String dato;
     private String de;
     private String descricpion;
     private Integer importe;

    public Concepto() {
    }

	
    public Concepto(int idconcepto) {
        this.idconcepto = idconcepto;
    }
    public Concepto(int idconcepto, Gasto gasto, Date fecha, String dato, String de, String descricpion, Integer importe) {
       this.idconcepto = idconcepto;
       this.gasto = gasto;
       this.fecha = fecha;
       this.dato = dato;
       this.de = de;
       this.descricpion = descricpion;
       this.importe = importe;
    }
   
    public int getIdconcepto() {
        return this.idconcepto;
    }
    
    public void setIdconcepto(int idconcepto) {
        this.idconcepto = idconcepto;
    }
    public Gasto getGasto() {
        return this.gasto;
    }
    
    public void setGasto(Gasto gasto) {
        this.gasto = gasto;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public String getDato() {
        return this.dato;
    }
    
    public void setDato(String dato) {
        this.dato = dato;
    }
    public String getDe() {
        return this.de;
    }
    
    public void setDe(String de) {
        this.de = de;
    }
    public String getDescricpion() {
        return this.descricpion;
    }
    
    public void setDescricpion(String descricpion) {
        this.descricpion = descricpion;
    }
    public Integer getImporte() {
        return this.importe;
    }
    
    public void setImporte(Integer importe) {
        this.importe = importe;
    }




}


