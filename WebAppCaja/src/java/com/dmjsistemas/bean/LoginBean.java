package com.dmjsistemas.bean;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.dmjsistemas.dao.IGenericaDao;
import com.dmjsistemas.impl.GenericaDaoImpl;
import com.dmjsistemas.model.Usuario;

import java.io.Serializable;

@Named("login")
@SessionScoped

public class LoginBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LoginBean() {

    }

    @PostConstruct
    public void init() {
        this.usuario = new Usuario();
    }

    public void login(ActionEvent event) {

        boolean loggedIn = false;
        String ruta = "";
        IGenericaDao usuarioDao = new GenericaDaoImpl();
        this.usuario = usuarioDao.login(this.usuario);

        if (this.usuario != null) {

            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("nombre", usuario);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "¡BIENVENIDO!", this.usuario.getNombre()));
            loggedIn = true;
            if (this.usuario.getPerfil().equals("Administrador")) {
                ruta = "Views/Usuarios.xhtml";
            } else if (this.usuario.getPerfil().equals("Usuario")) {
                ruta = "Views/Usuarios.xhtml";
            }
        } else {
            loggedIn = false;
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "¡ERROR DE ACCESO!", "¡VERIFIQUE SUS CREDENCIALES!"));
            this.usuario = new Usuario();
        }

        PrimeFaces.current().ajax().addCallbackParam("loggedIn", loggedIn);
        PrimeFaces.current().ajax().addCallbackParam("ruta", ruta);
    }

    public void cerrarSesion() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }

}
