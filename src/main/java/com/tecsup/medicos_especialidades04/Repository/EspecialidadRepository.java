package com.tecsup.medicos_especialidades04.Repository;

import com.tecsup.medicos_especialidades04.Model.Especialidad;

import java.util.List;

public interface EspecialidadRepository {

    Especialidad guardar(Especialidad especialidad);

    List<Especialidad> listar();

    Especialidad cambiarEstado(Long id, boolean activa);
}
