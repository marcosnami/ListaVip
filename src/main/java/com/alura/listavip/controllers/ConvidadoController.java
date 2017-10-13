package com.alura.listavip.controllers;

import com.alura.listavip.models.Convidado;
import com.alura.listavip.repository.ConvidadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by marcos.nami on 13/10/2017.
 */
@Controller
public class ConvidadoController {

    @Autowired
    private ConvidadoRepository convidadoRepository;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("lista-convidados")
    public String listaConvidados(Model model) {

        Iterable<Convidado> convidados = convidadoRepository.findAll();
        model.addAttribute("convidados", convidados);

        return "listaconvidados";
    }

}
