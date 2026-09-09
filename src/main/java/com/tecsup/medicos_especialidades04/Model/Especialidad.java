package com.tecsup.medicos_especialidades04.Model;

public class Especialidad {

    private Long id;
    private String codigo;
    private String nombre;
    private String descripcion;
    private int duracionConsulta;
    private boolean activa;

    public Especialidad() {
    }

    public Especialidad(Long id, String codigo, String nombre, String descripcion,
                        int duracionConsulta, boolean activa) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracionConsulta = duracionConsulta;
        this.activa = activa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDuracionConsulta() {
        return duracionConsulta;
    }

    public void setDuracionConsulta(int duracionConsulta) {
        this.duracionConsulta = duracionConsulta;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }
}
