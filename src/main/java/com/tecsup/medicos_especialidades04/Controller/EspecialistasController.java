package com.tecsup.medicos_especialidades04.Controller;

import com.tecsup.medicos_especialidades04.Model.EspecialidadMedicoModel;
import com.tecsup.medicos_especialidades04.Repository.EspecialidadRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/especialidades")
public class EspecialistasController {

    private final EspecialidadRepository repository;

    public EspecialistasController(EspecialidadRepository repository) {
        this.repository = repository;
    }

    // RF-MED-07: Registrar especialidad
    @PostMapping
    public EspecialidadMedicoModel registrar(@RequestBody EspecialidadMedicoModel especialidad) {
        return repository.guardar(especialidad);
    }

    // Listar especialidades
    @GetMapping
    public List<EspecialidadMedicoModel> listar() {
        return repository.listar();
    }

    // RF-MED-09: Activar o desactivar especialidad
    @PutMapping("/{id}/estado")
    public EspecialidadMedicoModel cambiarEstado(
            @PathVariable Long id,
            @RequestParam boolean activa) {

        return repository.cambiarEstado(id, activa);
    }
}