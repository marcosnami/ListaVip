package com.alura.listavip.utils;

import com.alura.listavip.models.Convidado;

import javax.persistence.EntityManager;

/**
 * Created by marcos.nami on 13/10/2017.
 */
public class InsertConvidados {

    public static void main(String[] args) {

        EntityManager em = new CreateEntityManager().getEntityManager();
        em.getTransaction().begin();

        Convidado convidado1 = new Convidado();
        convidado1.setNome("Lazaro Prates Junior");
        convidado1.setEmail("lazaro@alura.com.br");
        convidado1.setTelefone("1199998888");

        Convidado convidado2 = new Convidado();
        convidado2.setNome("Maria do Carmo");
        convidado2.setEmail("maria@gmail.com");
        convidado2.setTelefone("1133442233");

        Convidado convidado3 = new Convidado();
        convidado3.setNome("Antonio da Silva");
        convidado3.setEmail("toni@alura.com.br");
        convidado3.setTelefone("1199997777");

        em.persist(convidado1);
        em.persist(convidado2);
        em.persist(convidado3);


        em.getTransaction().commit();
        em.close();
    }
}
