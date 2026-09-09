package com.tecsup.medicos_especialidades04.Service;

import com.tecsup.medicos_especialidades04.Model.Consultorio;
import com.tecsup.medicos_especialidades04.Model.EstadoConsultorio;
import com.tecsup.medicos_especialidades04.Repository.ConsultorioRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@Service
public class ConsultorioService {

    private final ConsultorioRepository consultorioRepository;
    private final HorarioRepository horarioRepository;

    public ConsultorioService(
            ConsultorioRepository consultorioRepository,
            HorarioRepository horarioRepository) {

        this.consultorioRepository = consultorioRepository;
        this.horarioRepository = horarioRepository;
    }

    // RF-MED-15: registrar consultorios
    @Transactional
    public Consultorio registrar(Consultorio consultorio) {

        validarDatos(consultorio);

        String codigoNormalizado =
                consultorio.getCodigo().trim().toUpperCase();

        boolean codigoExistente =
                consultorioRepository
                        .existsByCodigoIgnoreCase(codigoNormalizado);

        if (codigoExistente) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Ya existe un consultorio con el código "
                            + codigoNormalizado
            );
        }

        consultorio.setId(null);
        consultorio.setCodigo(codigoNormalizado);
        consultorio.setNombre(consultorio.getNombre().trim());
        consultorio.setArea(consultorio.getArea().trim());

        if (consultorio.getEstado() == null) {
            consultorio.setEstado(
                    EstadoConsultorio.DISPONIBLE
            );
        }

        return consultorioRepository.save(consultorio);
    }

    // Sirve para comprobar los consultorios registrados
    @Transactional(readOnly = true)
    public List<Consultorio> listar() {
        return consultorioRepository.findAll();
    }

    // RF-MED-16: asignar un consultorio al horario de un médico
    @Transactional
    public Map<String, Object> asignarConsultorio(
            Long consultorioId,
            Long horarioId) {

        Consultorio consultorio =
                consultorioRepository
                        .findById(consultorioId)
                        .orElseThrow(() ->
                                new ResponseStatusException(
                                        HttpStatus.NOT_FOUND,
                                        "No existe el consultorio con ID "
                                                + consultorioId
                                )
                        );

        if (consultorio.getEstado()
                == EstadoConsultorio.INACTIVO) {

            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "No se puede asignar un consultorio inactivo"
            );
        }

        HorarioAtencion horario =
                horarioRepository
                        .findById(horarioId)
                        .orElseThrow(() ->
                                new ResponseStatusException(
                                        HttpStatus.NOT_FOUND,
                                        "No existe el horario con ID "
                                                + horarioId
                                )
                        );

        if (horario.getMedico() == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El horario no tiene un médico asociado"
            );
        }

        horario.setConsultorio(consultorio);
        horarioRepository.save(horario);

        return Map.of(
                "mensaje",
                "Consultorio asignado correctamente al médico",
                "horarioId",
                horario.getId(),
                "consultorioId",
                consultorio.getId(),
                "codigoConsultorio",
                consultorio.getCodigo()
        );
    }

    private void validarDatos(Consultorio consultorio) {

        if (consultorio.getCodigo() == null
                || consultorio.getCodigo().isBlank()) {

            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El código del consultorio es obligatorio"
            );
        }

        if (consultorio.getNombre() == null
                || consultorio.getNombre().isBlank()) {

            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El nombre del consultorio es obligatorio"
            );
        }

        if (consultorio.getPiso() == null
                || consultorio.getPiso() < 0) {

            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El piso debe ser un número válido"
            );
        }

        if (consultorio.getArea() == null
                || consultorio.getArea().isBlank()) {

            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El área del consultorio es obligatoria"
            );
        }
    }
}
