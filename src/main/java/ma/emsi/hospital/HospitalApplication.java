package ma.emsi.hospital;

import ma.emsi.hospital.entities.*;
import ma.emsi.hospital.repositories.ConsultationRepository;
import ma.emsi.hospital.repositories.MedecinRepository;
import ma.emsi.hospital.repositories.PatientRepository;
import ma.emsi.hospital.repositories.RendezVousRepository;
import ma.emsi.hospital.service.HospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);
	}
	@Bean
	CommandLineRunner start(HospitalService hospitalService,
							MedecinRepository medecinRepository,
							PatientRepository patientRepository,
							RendezVousRepository rendezVousRepository){

		return args -> {
			Stream.of("Mohammed","Hassan","Najat")
					.forEach(name-> {
						Patient patient = new Patient();
						patient.setNom(name);
						patient.setDateNaissance(new Date());
						patient.setMalade(false);
						hospitalService.savePatient(patient);
					});
			Stream.of("ayman","hanane","yasmine")
					.forEach(name-> {
						Medecin medecin=new Medecin();
						medecin.setNom(name);
						medecin.setEmail(name+"@gmail.com");
						medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
						hospitalService.saveMedecin(medecin);
					});


			Patient patient=patientRepository.findById(1L).orElse(null);
			Patient patien=patientRepository.findByNom("Mohammed");
			Medecin medecin=medecinRepository.findByNom("yasmine");
			Rendezvous rendezVous=new Rendezvous();
			rendezVous.setDate(new Date());
			rendezVous.setStatus(StatusRdv.PENDING);
			rendezVous.setMedecin(medecin);
			rendezVous.setPatient(patient);
			Rendezvous saveRDV=rendezVousRepository.save(rendezVous);
			System.out.println(saveRDV.getId());
			Rendezvous rendezvous1=rendezVousRepository.findById(1L).orElse(null);
			Consultation consultation=new Consultation();
			consultation.setDateConsultation(new Date());
			consultation.setRendezVous(rendezvous1);
			consultation.setRapport("rapport .....");
			hospitalService.saveconsultation(consultation);
		};

	}

}
