package com.hospital.service;

import com.hospital.entity.*;
import com.hospital.util.JPAUtil;

import jakarta.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

public class HospitalService {

    public void addDoctor(String name, String spec) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        Doctor d = new Doctor();
        d.setName(name);
        d.setSpecialization(spec);

        em.persist(d);
        em.getTransaction().commit();
        em.close();
    }

    public void addPatient(String name, int age) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        Patient p = new Patient();
        p.setName(name);
        p.setAge(age);

        em.persist(p);
        em.getTransaction().commit();
        em.close();
    }

    public void bookAppointment(int doctorId, int patientId, LocalDate date) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        Doctor d = em.find(Doctor.class, doctorId);
        Patient p = em.find(Patient.class, patientId);

        Appointment a = new Appointment();
        a.setDoctor(d);
        a.setPatient(p);
        a.setAppointmentDate(date);

        em.persist(a);

        em.getTransaction().commit();
        em.close();
    }

    public void fetchAppointmentsByDoctor(int doctorId) {
        EntityManager em = JPAUtil.getEntityManager();

        List<Appointment> list =
                em.createQuery(
                    "from Appointment where doctor.doctorId = :id",
                    Appointment.class)
                .setParameter("id", doctorId)
                .getResultList();

        for (Appointment a : list) {
            System.out.println(
                    a.getAppointmentId() + " "
                  + a.getAppointmentDate() + " "
                  + a.getPatient().getName());
        }

        em.close();
    }

    public void listPatientsByDate(LocalDate date) {
        EntityManager em = JPAUtil.getEntityManager();

        List<Appointment> list =
                em.createQuery(
                    "from Appointment where appointmentDate = :dt",
                    Appointment.class)
                .setParameter("dt", date)
                .getResultList();

        for (Appointment a : list) {
            System.out.println(a.getPatient().getName());
        }

        em.close();
    }
}