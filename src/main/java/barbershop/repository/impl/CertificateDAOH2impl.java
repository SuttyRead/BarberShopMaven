package barbershop.repository.impl;

import barbershop.controller.MainController;
import barbershop.domain.Certificate;
import barbershop.exception.CertificateDuplicatedException;
import barbershop.exception.ServiceNotFoundException;
import barbershop.repository.CertificateDAO;
import org.h2.jdbc.JdbcSQLException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static barbershop.repository.impl.ConnectionFactory.getInstance;

public class CertificateDAOH2impl implements CertificateDAO {


    private Connection connection;
    private PreparedStatement pst = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    private static ServiceDAOH2impl instance;

    public static ServiceDAOH2impl instance() {
        if (instance == null) {
            instance = new ServiceDAOH2impl();
        }
        return instance;
    }

    private static final String INSERT_CERTIFICATES = String.format("INSERT INTO certificates(%s)" +
            " VALUES (?);", barbershop.domain.Certificate.NUMBER_CERTIFICATE);

    private static final String GET_ALL_CERTIFICATE = "SELECT * FROM certificates";

    private static final String DELETE_CERTIFICATE_BY_ID = String.format("DELETE FROM certificates WHERE %s = ?;", Certificate.ID);

    private static final String GET_CERTIFICATE = "SELECT * FROM certificates WHERE number_certificate = ?;";


    @Override
    public void addCertificate(Certificate certificate) {

        try {
            checkToDuplicate(certificate);
            connection = getInstance().getConnection();
            pst = connection.prepareStatement(INSERT_CERTIFICATES);
            pst.setInt(1, certificate.getNumberCertificate());
            pst.execute();
        }catch (JdbcSQLException e1) {

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getInstance().closePreparedStatement(pst);
            getInstance().closeConnection(connection);
        }
    }

    @Override
    public List<Certificate> getAllCertificate() {
        List<Certificate> certificates = new ArrayList<>();

        try {
            connection = getInstance().getConnection();
            stmt = connection.createStatement();
            rs = stmt.executeQuery(GET_ALL_CERTIFICATE);

            while (rs.next()) {
                Certificate certificate = new Certificate();
                certificate.setId(rs.getInt(Certificate.ID));
                certificate.setNumberCertificate(rs.getInt(Certificate.NUMBER_CERTIFICATE));
                certificates.add(certificate);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getInstance().closeResultSet(rs);
            getInstance().closeStatement(stmt);
            getInstance().closeConnection(connection);
        }
        return certificates;
    }

    @Override
    public void deleteCertificate(int id) {
        try {
            connection = getInstance().getConnection();
            pst = connection.prepareStatement(DELETE_CERTIFICATE_BY_ID);
            pst.setInt(1, id);
            int result = pst.executeUpdate();
            if (result == 0) {
                throw new ServiceNotFoundException();
            }
        } catch (ServiceNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            getInstance().closePreparedStatement(pst);
            getInstance().closeConnection(connection);
        }
    }

    private void checkToDuplicate(Certificate certificate){
        Certificate certificate2 = new Certificate();
        try {
            connection = getInstance().getConnection();
            pst = connection.prepareStatement(GET_CERTIFICATE);
            pst.setInt(1, certificate.getNumberCertificate());
            rs = pst.executeQuery();

            while (rs.next()) {
                certificate2.setId(rs.getInt(Certificate.ID));
                certificate2.setNumberCertificate(rs.getInt(Certificate.NUMBER_CERTIFICATE));
            }


            if (certificate2.getNumberCertificate() != 0){
                try {
                    throw new CertificateDuplicatedException();
                } catch (CertificateDuplicatedException e) {
                    System.out.println("Duplicate");

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            getInstance().closeResultSet(rs);
        }




    }

}
