package com.dmjsistemas.bean;

import com.dmjsistemas.dao.IGenericaDao;
import com.dmjsistemas.impl.GenericaDaoImpl;
import com.dmjsistemas.model.Autos;
import com.dmjsistemas.model.Gasto;
import com.dmjsistemas.model.Tipos;
import com.dmjsistemas.model.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "gastos")
@ViewScoped
public class GastosBean implements Serializable {

    private List<Gasto> lista;
    private Gasto gasto;
    private Usuario usuario;
    private Autos autos;
    private List<String> listaAutos;
    private List<Autos> listarAutos;
    private String nombreVehiculo;
    private String tipoGastos;
    private List<String> listaTipo;
    private List<Tipos> listarTipos;
    private Tipos tipos;
    Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");

    public List<Gasto> getLista() {
        IGenericaDao iDao = new GenericaDaoImpl();
        lista = (List<Gasto>) (Object) iDao.listaGenerica("FROM Gasto");
        return lista;
    }

    public List<Autos> getListarAutos() {
        return listarAutos;
    }

    public Gasto getGasto() {
        return gasto;
    }

    public void setGasto(Gasto gasto) {
        this.gasto = gasto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Autos getAutos() {
        return autos;
    }

    public void setAutos(Autos autos) {
        this.autos = autos;
    }

    public List<String> getListaAutos() {
        return listaAutos;
    }

    public void setListaAutos(List<String> listaAutos) {
        this.listaAutos = listaAutos;
    }

    public String getNombreVehiculo() {
        return nombreVehiculo;
    }

    public void setNombreVehiculo(String nombreVehiculo) {
        this.nombreVehiculo = nombreVehiculo;
    }

    public String getTipoGastos() {
        return tipoGastos;
    }

    public void setTipoGastos(String tipoGastos) {
        this.tipoGastos = tipoGastos;
    }

    public List<String> getListaTipo() {
        return listaTipo;
    }

    public void setListaTipo(List<String> listaTipo) {
        this.listaTipo = listaTipo;
    }

    public List<Tipos> getListarTipos() {
        return listarTipos;
    }

    public void setListarTipos(List<Tipos> listarTipos) {
        this.listarTipos = listarTipos;
    }

    public Tipos getTipos() {
        return tipos;
    }

    public void setTipos(Tipos tipos) {
        this.tipos = tipos;
    }

    public GastosBean() {
    }

    @PostConstruct
    public void init() {
        lista = new ArrayList<>();
        gasto = new Gasto();
        autos = new Autos();
        usuario = new Usuario();
        listaAutos = new ArrayList<>();
        listaTipo = new ArrayList<>();
        listarTipos = new ArrayList<>();
        tipos = new Tipos();
        listaAutos();
        listaTipos();
    }

    public void guardar() {
        IGenericaDao iDao = new GenericaDaoImpl();

        //**BUSCAR EL ID DEL VEHÍCULO**//
        IGenericaDao bDao = new GenericaDaoImpl();
        List<Autos> listaBusquedaAutos;
        listaBusquedaAutos = (List<Autos>) (Object) bDao
                .listaGenerica("FROM Autos WHERE nombreVehiculo = '" + nombreVehiculo.trim() + "'");
        listaBusquedaAutos.forEach((a) -> {
            autos.setIdauto(a.getIdauto());
        });

        //**BUSCAR EL ID DEL TIPO DE GASTO**//
        IGenericaDao tDao = new GenericaDaoImpl();
        List<Tipos> listaBusquedaTipos;
        listaBusquedaTipos = (List<Tipos>) (Object) tDao
                .listaGenerica("FROM Tipos WHERE tipoGasto = '" + tipoGastos + "'");
        listaBusquedaTipos.forEach((a) -> {
            tipos.setIdtipo(a.getIdtipo());
        });

        gasto.setTipos(tipos);
        gasto.setAutos(autos);
        gasto.setUsuario(us);
        iDao.guardar(gasto);
        gasto = new Gasto();
        autos = new Autos();
        usuario = new Usuario();
        tipos = new Tipos();
        nombreVehiculo = "";
        tipoGastos = "";
    }

    public void actualizar() {
        IGenericaDao iDao = new GenericaDaoImpl();
        iDao.actualizar(gasto);
        gasto = new Gasto();
        autos = new Autos();
        usuario = new Usuario();
    }

    public void borrar() {
        IGenericaDao iDao = new GenericaDaoImpl();
        iDao.borrar(gasto);
    }

    public void listaAutos() {
        IGenericaDao iDao = new GenericaDaoImpl();
        listarAutos = new ArrayList<>();
        listaAutos = new ArrayList<>();
        listarAutos = (List<Autos>) (Object) iDao.listaGenerica("FROM Autos");
        listarAutos.forEach((a) -> {
            listaAutos.add(a.getNombreVehiculo());
        });
    }

    private void listaTipos() {
        IGenericaDao iDao = new GenericaDaoImpl();
        listaTipo = new ArrayList<>();
        listarTipos = new ArrayList<>();
        listarTipos = (List<Tipos>) (Object) iDao.listaGenerica("FROM Tipos");
        listarTipos.forEach((a) -> {
            listaTipo.add(a.getTipoGasto());
        });
    }

}
