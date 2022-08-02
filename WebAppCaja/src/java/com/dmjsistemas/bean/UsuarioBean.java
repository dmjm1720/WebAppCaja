package com.dmjsistemas.bean;

import com.dmjsistemas.dao.IGenericaDao;
import com.dmjsistemas.impl.GenericaDaoImpl;
import com.dmjsistemas.model.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "usuario")
@ViewScoped
public class UsuarioBean implements Serializable {

    private List<Usuario> lista;
    private Usuario usuario;

    public List<Usuario> getLista() {
        IGenericaDao iDao = new GenericaDaoImpl();
        lista = (List<Usuario>) (Object) iDao.listaGenerica("FROM Usuario");
        return lista;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioBean() {
    }

    @PostConstruct
    public void init() {
        lista = new ArrayList<>();
        usuario = new Usuario();
    }

    public void guardar() {
        IGenericaDao iDao = new GenericaDaoImpl();
        iDao.guardar(usuario);
        usuario = new Usuario();
    }

    public void actualizar() {
        IGenericaDao iDao = new GenericaDaoImpl();
        iDao.actualizar(usuario);
        usuario = new Usuario();
    }

}
