package ma.enset.jpahospital;

import ma.enset.jpahospital.entities.*;
import ma.enset.jpahospital.repositories.ConsultationRepository;
import ma.enset.jpahospital.repositories.MedecinRepository;
import ma.enset.jpahospital.repositories.PatientRepository;
import ma.enset.jpahospital.repositories.RendezVousRepository;
import ma.enset.jpahospital.service.IHospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@SpringBootApplication
public class JpaHospitalApplication {


    public static void main(String[] args) {

        SpringApplication.run(JpaHospitalApplication.class, args);
    }

    @Bean
    CommandLineRunner start(IHospitalService hospitalService, RendezVousRepository rendezVousRepository){
        return args -> {
            Stream.of("anas","ali","fati").forEach(name ->{
                Patient patient = new Patient();
                patient.setNom(name);
                patient.setDateNaissance(new Date());
                patient.setMalade(false);
                patient.setScore(50);
                hospitalService.savePatient(patient);
            });
            Stream.of("IKRAM","SAAD","YAHYA").forEach(name ->{
                Medecin medecin = new Medecin();
                medecin.setNom(name);
                medecin.setEmail(name+"@gmail.com");
                medecin.setSpecialite(Math.random()>0.5?"generale":"dentiste");
                hospitalService.saveMedecin(medecin);
            });

            Patient patient1 = hospitalService.findPatientByNom("anas");
            Medecin medecin1 = hospitalService.findMedecinByNom("SAAD");

            RendezVous rendezVous = new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setPatient(patient1);
            rendezVous.setMedecin(medecin1);
            hospitalService.saveRDV(rendezVous);

            RendezVous rendezVous1 = rendezVousRepository.findById(1L).orElse(null);
            Consultation consultation = new Consultation();
            consultation.setDateConsultation(rendezVous1.getDate());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapport("Rapport de consultation ......");
            hospitalService.saveConsultation(consultation);
        };
    }
}