package ma.emsi.hospital.repositories;

import ma.emsi.hospital.entities.Patient;
import ma.emsi.hospital.entities.Rendezvous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<Rendezvous,Long> {


}
