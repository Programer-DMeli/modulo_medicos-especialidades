package com.tecsup.medicos_especialidades04.Server;

import com.tecsup.medicos_especialidades04.Model.Especialidad;
import com.tecsup.medicos_especialidades04.Repository.EspecialidadRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EspecialidadServer implements EspecialidadRepository {

    private final List<Especialidad> especialidades = new ArrayList<>();
    private Long siguienteId = 1L;

    @Override
    public Especialidad guardar(Especialidad especialidad) {
        especialidad.setId(siguienteId);
        siguienteId++;
        especialidades.add(especialidad);
        return especialidad;
    }

    @Override
    public List<Especialidad> listar() {
        return especialidades;
    }

    @Override
    public Especialidad cambiarEstado(Long id, boolean activa) {
        for (Especialidad especialidad : especialidades) {
            if (especialidad.getId().equals(id)) {
                especialidad.setActiva(activa);
                return especialidad;
            }
        }

        return null;
    }
}
