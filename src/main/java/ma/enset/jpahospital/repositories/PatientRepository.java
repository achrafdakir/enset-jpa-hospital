package ma.enset.jpahospital.repositories;

import ma.enset.jpahospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
