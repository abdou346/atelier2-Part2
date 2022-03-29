package ma.emsi.hospital.service;

import ma.emsi.hospital.entities.Consultation;
import ma.emsi.hospital.entities.Medecin;
import ma.emsi.hospital.entities.Patient;
import ma.emsi.hospital.entities.Rendezvous;

public interface HospitalService {
    public Patient savePatient (Patient patient);
    Medecin saveMedecin (Medecin medecin);
    Rendezvous saveRDV(Rendezvous rendezvous);
    Consultation saveconsultation (Consultation consultation);



}
