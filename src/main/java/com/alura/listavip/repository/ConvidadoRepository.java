package com.alura.listavip.repository;

import com.alura.listavip.models.Convidado;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by marcos.nami on 13/10/2017.
 */
public interface ConvidadoRepository extends CrudRepository<Convidado, Long> {

    List<Convidado> findByNome(String nome);
    Convidado findById(Integer id);

}
