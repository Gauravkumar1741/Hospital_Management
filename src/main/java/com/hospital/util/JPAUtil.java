package com.hospital.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {

    // Create EntityManagerFactory only once
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("hospitalPU");

    // Method to get EntityManager
    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}