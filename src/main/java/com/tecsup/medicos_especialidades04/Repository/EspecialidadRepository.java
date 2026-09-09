package com.tecsup.medicos_especialidades04.Repository;

import com.tecsup.medicos_especialidades04.Model.EspecialidadMedicoModel;

import java.util.List;

public interface EspecialidadRepository {

    EspecialidadMedicoModel guardar(EspecialidadMedicoModel especialidad);

    List<EspecialidadMedicoModel> listar();

    EspecialidadMedicoModel cambiarEstado(Long id, boolean activa);
}
