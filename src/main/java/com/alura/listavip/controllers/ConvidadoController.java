package com.alura.listavip.controllers;

import com.alura.listavip.models.Convidado;
import com.alura.listavip.service.ConvidadoService;
import com.alura.listavip.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/**
 * Created by marcos.nami on 13/10/2017.
 */
@Controller
public class ConvidadoController {

    @Autowired
    private ConvidadoService convidadoService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("lista-convidados")
    public String listaConvidados(Model model) {

        Iterable<Convidado> convidados = convidadoService.findAll();
        model.addAttribute("convidados", convidados);

        return "listaconvidados";
    }

    @RequestMapping(value = "salvar", method = RequestMethod.POST)
    public String salvar(@RequestParam("nome") String name,
                         @RequestParam("email") String email,
                         @RequestParam("telefone") String phone,
                         Model model) {

        convidadoService.save(new Convidado(name, email, phone));

        new EmailService().enviar(name, email);

        Iterable<Convidado> convidados = convidadoService.findAll();
        model.addAttribute("convidados", convidados);

        return "listaconvidados";
    }

    @RequestMapping("delete/{id}")
    public String deletar(Model model,
                         @PathVariable("id") Integer id) {

        Convidado convidado = convidadoService.findById(id);

        convidadoService.delete(convidado);
        Iterable<Convidado> convidados = convidadoService.findAll();
        model.addAttribute("convidados", convidados);

        return "listaconvidados";
    }

    @RequestMapping("initial-data")
    @ResponseBody
    public String initialData() {
        convidadoService.save(new Convidado("Marcos Nami", "marcos@alura.com.br", "11999998888"));
        convidadoService.save(new Convidado("Ana Paula", "anapaula@alura.com.br", "11999997777"));
        convidadoService.save(new Convidado("Isabella Oliveira", "isabella@alura.com.br", "11999996666"));
        convidadoService.save(new Convidado("Daniel Nami", "daniel@alura.com.br", "11999995555"));

        return "Done";
    }


}
