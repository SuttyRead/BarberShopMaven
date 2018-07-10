package barbershop.repository;

import barbershop.domain.Certificate;

import java.util.List;

public interface CertificateDAO {

    void addCertificate(Certificate certificate);

    List<Certificate> getAllCertificate();

    void deleteCertificate(int id);

}
