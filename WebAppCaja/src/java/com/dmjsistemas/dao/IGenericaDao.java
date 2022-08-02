package com.dmjsistemas.dao;

import com.dmjsistemas.model.Usuario;
import java.util.List;

public interface IGenericaDao {

    public List<Object> listaGenerica(String query);

    public Usuario obtenerDatosUsuario(Usuario usuario);

    public Usuario login(Usuario usuario);

    public void guardar(Object object);

    public void actualizar(Object object);

    public void borrar(Object object);
    
}
