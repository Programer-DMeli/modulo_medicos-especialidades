package com.tecsup.medicos_especialidades04.Service;

import com.tecsup.medicos_especialidades04.Model.MedicoModel;
import com.tecsup.medicos_especialidades04.Repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository repo;

    public List<MedicoModel> listar() {
        return repo.findAll();
    }

    public MedicoModel guardar(MedicoModel medico) {
        return repo.save(medico);
    }
}
