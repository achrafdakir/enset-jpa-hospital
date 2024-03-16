package ma.enset.jpahospital.repositories;

import ma.enset.jpahospital.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
    Medecin findByNom(String n);
}
