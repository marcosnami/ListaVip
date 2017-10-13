package com.alura.listavip.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by marcos.nami on 13/10/2017.
 */
@Controller
public class ConvidadoController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("lista-convidados")
    public String listaConvidados() {
        return "listaconvidados";
    }

}
