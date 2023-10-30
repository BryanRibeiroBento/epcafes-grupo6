package com.epcafes.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epcafes.model.Fertilizante;
import com.epcafes.repository.FertilizanteRepository;
import com.epcafes.util.NegocioExeption;

@Service
public class FertilizanteService implements Serializable {
    private static final long serialVersionUID = 1L;
    @Autowired
    private FertilizanteRepository fertilizanteRepository;

    public void salvar(Fertilizante fertilizante) throws NegocioExeption {

        this.fertilizanteRepository.save(fertilizante);
    }

    public void excluir(Fertilizante fertilizante) throws NegocioExeption {

        fertilizanteRepository.delete(fertilizante);
    }

    public Fertilizante buscarPeloCodigo(long codigo) throws NegocioExeption {
        return fertilizanteRepository.findById(codigo).orElse(null);

    }

    public List<Fertilizante> buscarFertilizantes(Long tenantId) {

        return fertilizanteRepository.findByTenantId(tenantId);

    }

}
