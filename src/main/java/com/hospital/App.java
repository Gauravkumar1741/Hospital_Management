package com.hospital;

import com.hospital.service.HospitalService;
import java.time.LocalDate;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        HospitalService service = new HospitalService();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1.Add Doctor");
            System.out.println("2.Add Patient");
            System.out.println("3.Book Appointment");
            System.out.println("4.Fetch Appointments by Doctor");
            System.out.println("5.List Patients by Date");
            System.out.println("6.Exit");

            int ch = sc.nextInt();

            switch (ch) {

                case 1:
                    sc.nextLine();
                    System.out.print("Doctor name: ");
                    String dn = sc.nextLine();
                    System.out.print("Specialization: ");
                    String sp = sc.nextLine();
                    service.addDoctor(dn, sp);
                    break;

                case 2:
                    sc.nextLine();
                    System.out.print("Patient name: ");
                    String pn = sc.nextLine();
                    System.out.print("Age: ");
                    int age = sc.nextInt();
                    service.addPatient(pn, age);
                    break;

                case 3:
                    System.out.print("Doctor ID: ");
                    int did = sc.nextInt();
                    System.out.print("Patient ID: ");
                    int pid = sc.nextInt();
                    service.bookAppointment(did, pid, LocalDate.now());
                    break;

                case 4:
                    System.out.print("Doctor ID: ");
                    service.fetchAppointmentsByDoctor(sc.nextInt());
                    break;

                case 5:
                    service.listPatientsByDate(LocalDate.now());
                    break;

                case 6:
                    System.exit(0);
            }
        }
    }
}