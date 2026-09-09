package com.tecsup.medicos_especialidades04.Controller;

import com.tecsup.medicos_especialidades04.Model.Consultorio;
import com.tecsup.medicos_especialidades04.Service.ConsultorioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/consultorios")
public class ConsultorioController {

    private final ConsultorioService consultorioService;

    public ConsultorioController(
            ConsultorioService consultorioService) {

        this.consultorioService = consultorioService;
    }

    // RF-MED-15
    @PostMapping
    public ResponseEntity<Consultorio> registrar(
            @RequestBody Consultorio consultorio) {

        Consultorio consultorioRegistrado =
                consultorioService.registrar(consultorio);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(consultorioRegistrado);
    }

    // Método para visualizar los consultorios
    @GetMapping
    public ResponseEntity<List<Consultorio>> listar() {

        return ResponseEntity.ok(
                consultorioService.listar()
        );
    }

    // RF-MED-16
    @PutMapping("/{consultorioId}/horarios/{horarioId}")
    public ResponseEntity<Map<String, Object>>
    asignarConsultorio(
            @PathVariable Long consultorioId,
            @PathVariable Long horarioId) {

        return ResponseEntity.ok(
                consultorioService.asignarConsultorio(
                        consultorioId,
                        horarioId
                )
        );
    }
}
