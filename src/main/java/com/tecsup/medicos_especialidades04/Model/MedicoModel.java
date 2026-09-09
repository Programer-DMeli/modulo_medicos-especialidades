package com.tecsup.medicos_especialidades04.Model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "medico")
public class MedicoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medico")
    private Long idMedico;

    @Column(name = "codigo_medico", nullable = false, unique = true, length = 20)
    private String codigoMedico;

    @Column(name = "tipo_documento", nullable = false, length = 10)
    private String tipoDocumento;

    @Column(name = "numero_documento", nullable = false, unique = true, length = 15)
    private String numeroDocumento;

    @Column(name = "nombres", nullable = false, length = 100)
    private String nombres;

    @Column(name = "apellido_paterno", nullable = false, length = 100)
    private String apellidoPaterno;

    @Column(name = "apellido_materno", nullable = false, length = 100)
    private String apellidoMaterno;

    @Column(name = "cmp", nullable = false, length = 20)
    private String cmp;

    @Column(name = "rne", length = 20)
    private String rne;

    @Column(name = "telefono", length = 15)
    private String telefono;

    @Column(name = "correo", length = 150)
    private String correo;

    @Column(name = "fecha_ingreso", nullable = false)
    private LocalDate fechaIngreso;

    @Column(name = "subespecialidad", length = 100)
    private String subespecialidad;

    @Column(name = "estado", nullable = false)
    private Boolean estado = true; // true: ACTIVO, false: INACTIVO

    // Relación con Especialidad
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_especialidad", nullable = false)
    private EspecialidadesModel especialidad;

    // ==========================================
    // CONSTRUCTORES
    // ==========================================

    public MedicoModel() {
    }

    public MedicoModel(Long idMedico, String codigoMedico, String tipoDocumento, String numeroDocumento,
                       String nombres, String apellidoPaterno, String apellidoMaterno, String cmp,
                       String rne, String telefono, String correo, LocalDate fechaIngreso,
                       String subespecialidad, Boolean estado, EspecialidadesModel especialidad) {
        this.idMedico = idMedico;
        this.codigoMedico = codigoMedico;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.cmp = cmp;
        this.rne = rne;
        this.telefono = telefono;
        this.correo = correo;
        this.fechaIngreso = fechaIngreso;
        this.subespecialidad = subespecialidad;
        this.estado = estado;
        this.especialidad = especialidad;
    }

    // ==========================================
    // GETTERS Y SETTERS
    // ==========================================

    public Long getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Long idMedico) {
        this.idMedico = idMedico;
    }

    public String getCodigoMedico() {
        return codigoMedico;
    }

    public void setCodigoMedico(String codigoMedico) {
        this.codigoMedico = codigoMedico;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getCmp() {
        return cmp;
    }

    public void setCmp(String cmp) {
        this.cmp = cmp;
    }

    public String getRne() {
        return rne;
    }

    public void setRne(String rne) {
        this.rne = rne;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }
    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getSubespecialidad() {
        return subespecialidad;
    }

    public void setSubespecialidad(String subespecialidad) {
        this.subespecialidad = subespecialidad;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    public EspecialidadesModel getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(EspecialidadesModel especialidad) {
        this.especialidad = especialidad;
    }
}