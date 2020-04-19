package org.sid.hospital;

import org.sid.hospital.Dao.PatientRepository;
import org.sid.hospital.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.validation.constraints.Null;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class HospitalApplication implements CommandLineRunner {
    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        patientRepository.save(new Patient(null, "rachid", df.parse("31/12/1993"), true, 5));
        patientRepository.save(new Patient(null, "anas", df.parse("27/05/1998"), true, 2));
        patientRepository.save(new Patient(null, "amine", df.parse("04/08/1996"), true, 4));
        patientRepository.save(new Patient(null, "imane", df.parse("07/08/1999"), true, 4));


        patientRepository.findAll().forEach(p -> {
            System.out.println(p.getName());
        });
    }
}
