package org.coursera.miformulariomd.clases;

import java.io.Serializable;
import java.util.Date;

public class Contacto implements Serializable {


    private String nombreCompleto;
    private String fechaNac;
    private String telef;
    private String email;
    private String descContacto;

    public Contacto(){}

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getTelef() {
        return telef;
    }

    public void setTelef(String telef) {
        this.telef = telef;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescContacto() {
        return descContacto;
    }

    public void setDescContacto(String descContacto) {
        this.descContacto = descContacto;
    }

    @Override
    public String toString() {
        return "Contacto{" +
                "nombreCompleto='" + nombreCompleto + '\'' +
                ", fechaNac=" + fechaNac +
                ", telef='" + telef + '\'' +
                ", email='" + email + '\'' +
                ", descContacto='" + descContacto + '\'' +
                '}';
    }
}
