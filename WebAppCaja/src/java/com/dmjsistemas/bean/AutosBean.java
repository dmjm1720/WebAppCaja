package com.dmjsistemas.bean;

import com.dmjsistemas.dao.IGenericaDao;
import com.dmjsistemas.impl.GenericaDaoImpl;
import com.dmjsistemas.model.Autos;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "autos")
@ViewScoped
public class AutosBean implements Serializable{

    private List<Autos> lista;
    private Autos autos;

    public List<Autos> getLista() {
        IGenericaDao iDao = new GenericaDaoImpl();
        lista = (List<Autos>) (Object) iDao.listaGenerica("FROM Autos");
        return lista;
    }

    public Autos getAutos() {
        return autos;
    }

    public void setAutos(Autos autos) {
        this.autos = autos;
    }

    public AutosBean() {
    }

    @PostConstruct
    public void init() {
        lista = new ArrayList<>();
        autos = new Autos();
    }

    public void guardar() {
        IGenericaDao iDao = new GenericaDaoImpl();
        iDao.guardar(autos);
        autos = new Autos();
    }

    public void actualizar() {
        IGenericaDao iDao = new GenericaDaoImpl();
        iDao.actualizar(autos);
        autos = new Autos();
    }
    
    public void borrar(){
        IGenericaDao iDao = new GenericaDaoImpl();
        iDao.borrar(autos);
    }

}
