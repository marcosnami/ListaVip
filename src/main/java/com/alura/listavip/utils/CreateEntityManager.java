package com.alura.listavip.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by marcos.nami on 13/10/2017.
 */
public class CreateEntityManager {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("listavip-postgresql");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

}
