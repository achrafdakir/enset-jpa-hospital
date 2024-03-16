package ma.enset.jpahospital.service;

import ma.enset.jpahospital.entities.Consultation;
import ma.enset.jpahospital.entities.Medecin;
import ma.enset.jpahospital.entities.Patient;
import ma.enset.jpahospital.entities.RendezVous;

import java.util.Optional;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Patient findPatientByNom(String nom);
    Medecin saveMedecin(Medecin medecin);

    Medecin findMedecinByNom(String nom);
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);
}
