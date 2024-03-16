package ma.enset.jpahospital;

import ma.enset.jpahospital.entities.Patient;
import ma.enset.jpahospital.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class JpaHospitalApplication implements CommandLineRunner {

    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {

        SpringApplication.run(JpaHospitalApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 100; i++) {
            patientRepository.save(
                    new Patient(null,"Achraf",new Date(),
                            Math.random()>0.5?true:false,(int)(Math.random()*100)));
        }

        System.out.println("------------------");
        Patient p = patientRepository.findById(2L).orElse(null);
        System.out.println(p.toString());
        p.setScore(100);
        patientRepository.save(p);
        patientRepository.deleteById(1L);
        Page<Patient> patients = patientRepository.findAll(PageRequest.of(1,5));
        System.out.println("Total pages :"+patients.getTotalPages());
        System.out.println("Total elements :"+patients.getTotalElements());
        System.out.println("Num Page : "+patients.getNumber());
        List<Patient> content = patients.getContent();

        Page<Patient> byMalade = patientRepository.findByMalade(true, PageRequest.of(0,5));
        System.out.println("====================");
        byMalade.forEach(patient ->{
            System.out.println(patient.toString());
        });
    }
}
