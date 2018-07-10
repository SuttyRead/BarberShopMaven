package barbershop.repository.impl;

import barbershop.domain.Hairdresser;
import barbershop.domain.Service;
import barbershop.domain.Services;
import barbershop.exception.HairdresserNotFoundException;
import barbershop.exception.ServiceNotFoundException;
import barbershop.repository.ServiceDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static barbershop.repository.impl.ConnectionFactory.getInstance;

public class ServiceDAOH2impl implements ServiceDAO {

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

    private static final String INSERT_SERVICE = String.format("INSERT INTO service(%s)" +
            " VALUES (?);", Service.SERVICE);

    private static final String GET_ALL_SERVICE = "SELECT * FROM service";

    private static final String DELETE_SERVICE_BY_ID = String.format("DELETE FROM service WHERE %s = ?;", Service.ID);


    @Override
    public void addService(Service service) {

        try {
            connection = getInstance().getConnection();
            pst = connection.prepareStatement(INSERT_SERVICE);
            pst.setString(1, service.getService());
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getInstance().closePreparedStatement(pst);
            getInstance().closeConnection(connection);
        }
    }

    @Override
    public void deleteService(int id) {
        try {
            connection = getInstance().getConnection();
            pst = connection.prepareStatement(DELETE_SERVICE_BY_ID);
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

    @Override
    public List<Service> getAllService() {
        List<Service> serviceList = new ArrayList<>();

        try {
            connection = getInstance().getConnection();
            stmt = connection.createStatement();
            rs = stmt.executeQuery(GET_ALL_SERVICE);

            while (rs.next()) {
                Service service = new Service();
                service.setId(rs.getInt(Service.ID));
                service.setService(rs.getString(Service.SERVICE));
                serviceList.add(service);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getInstance().closeResultSet(rs);
            getInstance().closeStatement(stmt);
            getInstance().closeConnection(connection);
        }
        return serviceList;
    }
}

