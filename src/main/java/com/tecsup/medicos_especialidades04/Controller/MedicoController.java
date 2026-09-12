package com.tecsup.medicos_especialidades04.Controller;

import com.tecsup.medicos_especialidades04.Model.MedicoModel;
import com.tecsup.medicos_especialidades04.Service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class MedicoController {
    @Autowired
    private MedicoService service;

    @GetMapping
    public List<MedicoModel> listar() {
        return service.listar();
    }

    @PostMapping
    public ResponseEntity<MedicoModel> guardar(@RequestBody MedicoModel medico) {
        return ResponseEntity.status(201).body(service.guardar(medico));
    }
}
