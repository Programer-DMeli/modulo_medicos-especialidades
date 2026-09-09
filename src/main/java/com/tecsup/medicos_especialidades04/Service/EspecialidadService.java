package com.tecsup.medicos_especialidades04.Service;

import com.tecsup.medicos_especialidades04.Model.EspecialidadMedicoModel;
import com.tecsup.medicos_especialidades04.Repository.EspecialidadRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EspecialidadService implements EspecialidadRepository {

    private final List<EspecialidadMedicoModel> especialidades = new ArrayList<>();
    private Long siguienteId = 1L;

    @Override
    public EspecialidadMedicoModel guardar(EspecialidadMedicoModel especialidad) {
        especialidad.setId(siguienteId);
        siguienteId++;
        especialidades.add(especialidad);
        return especialidad;
    }

    @Override
    public List<EspecialidadMedicoModel> listar() {
        return especialidades;
    }

    @Override
    public EspecialidadMedicoModel cambiarEstado(Long id, boolean activa) {
        for (EspecialidadMedicoModel especialidad : especialidades) {
            if (especialidad.getId().equals(id)) {
                especialidad.setActiva(activa);
                return especialidad;
            }
        }

        return null;
    }
}
