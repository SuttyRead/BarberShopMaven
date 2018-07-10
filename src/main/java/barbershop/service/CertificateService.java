package barbershop.service;

import barbershop.domain.Certificate;
import barbershop.repository.impl.CertificateDAOH2impl;

import java.util.List;

public class CertificateService {

    private CertificateDAOH2impl certificateDAOH2impl = new CertificateDAOH2impl();

    public void addCertificate(Certificate certificate) {
        certificateDAOH2impl.addCertificate(certificate);
    }

    public List<Certificate> getAllCertificate() {
        return certificateDAOH2impl.getAllCertificate();
    }

    public void deleteCertificate(int id) {
        certificateDAOH2impl.deleteCertificate(id);
    }

}
