package ma.enset.jpahospital.service;

import jakarta.transaction.Transactional;
import ma.enset.jpahospital.entities.Consultation;
import ma.enset.jpahospital.entities.Medecin;
import ma.enset.jpahospital.entities.Patient;
import ma.enset.jpahospital.entities.RendezVous;
import ma.enset.jpahospital.repositories.ConsultationRepository;
import ma.enset.jpahospital.repositories.MedecinRepository;
import ma.enset.jpahospital.repositories.PatientRepository;
import ma.enset.jpahospital.repositories.RendezVousRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class HospotalServiceImpl implements IHospitalService{
    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RendezVousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;

    public HospotalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient findPatientByNom(String nom) {
        return patientRepository.findByNom(nom);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public Medecin findMedecinByNom(String nom) {
        return medecinRepository.findByNom(nom);
    }

    @Override
    public RendezVous saveRDV(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }


    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
