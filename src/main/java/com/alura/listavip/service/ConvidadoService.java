package com.alura.listavip.service;

import com.alura.listavip.models.Convidado;
import com.alura.listavip.repository.ConvidadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by MarcosNami on 10/14/2017.
 */
@Service
public class ConvidadoService {

    @Autowired
    private ConvidadoRepository convidadoRepository;

    public Iterable<Convidado> findAll() {
        return convidadoRepository.findAll();
    }

    public void save(Convidado convidado) {
        convidadoRepository.save(convidado);
    }

    public Convidado findById(Integer id) {
        return convidadoRepository.findById(id);
    }

    public void delete(Convidado convidado) {
        convidadoRepository.delete(convidado);
    }

}
