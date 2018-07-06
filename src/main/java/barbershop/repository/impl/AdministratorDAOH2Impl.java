package barbershop.repository.impl;

import barbershop.domain.Administrator;
import barbershop.exception.AdministratorNotFoundException;
import barbershop.repository.AdministratorDAO;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static barbershop.repository.impl.ConnectionFactory.getInstance;


public class AdministratorDAOH2Impl implements AdministratorDAO {

    private Connection connection;
    private PreparedStatement pst = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    private static AdministratorDAOH2Impl instance;

    public static AdministratorDAOH2Impl instance() {
        if (instance == null) {
            instance = new AdministratorDAOH2Impl();
        }
        return instance;
    }

    private static final String INSERT_ADMINISTRATOR = String.format("INSERT INTO administrators(%s, %s, %s, %s, %s, %s)" +
            " VALUES (?, ?, ?, ?, ?, ?);", Administrator.FIRST_NAME, Administrator.LAST_NAME, Administrator.MIDDLE_NAME, Administrator.PHONE_NUMBER, Administrator.HIRING, Administrator.EXPERIENCE);

    private static final String GET_ALL_ADMINISTRATORS = "SELECT * FROM administrators";

    private static final String DELETE_ADMINISTRATOR_BY_ID = String.format("DELETE FROM administrators WHERE %s = ?;", Administrator.ID);

    private static final String GET_ADMINISTRATOR_BY_ID = "SELECT * FROM administrators WHERE id = ?";

    private static final String GET_ADMINISTRATOR_BY_NAME = "SELECT * FROM administrators WHERE first_name = ? and last_name = ? and middle_name = ?";

    private static final String UPDATE_ADMINISTRATOR = String.format("UPDATE administrators SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ? " +
            "WHERE id = ?", Administrator.FIRST_NAME, Administrator.LAST_NAME, Administrator.MIDDLE_NAME, Administrator.PHONE_NUMBER, Administrator.HIRING, Administrator.EXPERIENCE);

    @Override
    public void addAdministrator(Administrator administrator) {
        try {
            connection = getInstance().getConnection();
            pst = connection.prepareStatement(INSERT_ADMINISTRATOR);

            pst.setString(1, administrator.getFirstName());
            pst.setString(2, administrator.getLastName());
            pst.setString(3, administrator.getMiddleName());
            pst.setString(4, administrator.getPhoneNumber());
            pst.setString(5, administrator.getHiring());
            pst.setDouble(6, administrator.getExperience());

            pst.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getInstance().closePreparedStatement(pst);
            getInstance().closeConnection(connection);
        }
    }

    @Override
    public List<Administrator> getAllAdministrators() {
        List<Administrator> administrators = new ArrayList<>();

        try {
            connection = getInstance().getConnection();
            stmt = connection.createStatement();
            rs = stmt.executeQuery(GET_ALL_ADMINISTRATORS);


            while (rs.next()) {
                Administrator administrator = new Administrator();
                administrator.setId(rs.getInt(Administrator.ID));
                administrator.setFirstName(rs.getString(Administrator.FIRST_NAME));
                administrator.setLastName(rs.getString(Administrator.LAST_NAME));
                administrator.setMiddleName(rs.getString(Administrator.MIDDLE_NAME));
                administrator.setPhoneNumber(rs.getString(Administrator.PHONE_NUMBER));
                administrator.setHiring(rs.getString(Administrator.HIRING));
                administrator.setExperience(rs.getDouble(Administrator.EXPERIENCE));
                administrators.add(administrator);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getInstance().closeResultSet(rs);
            getInstance().closeStatement(stmt);
            getInstance().closeConnection(connection);
        }
        return administrators;
    }

    @Override
    public Administrator findAdministrator(Administrator administrator) {
        try {
            connection = getInstance().getConnection();
            pst = connection.prepareStatement(GET_ADMINISTRATOR_BY_NAME);
            pst.setString(1, administrator.getFirstName());
            pst.setString(2, administrator.getLastName());
            pst.setString(3, administrator.getMiddleName());
            rs = pst.executeQuery();

            while (rs.next()) {
                administrator.setId(rs.getInt(Administrator.ID));
                administrator.setFirstName(rs.getString(Administrator.FIRST_NAME));
                administrator.setLastName(rs.getString(Administrator.LAST_NAME));
                administrator.setMiddleName(rs.getString(Administrator.MIDDLE_NAME));
                administrator.setPhoneNumber(rs.getString(Administrator.PHONE_NUMBER));
                administrator.setHiring(rs.getString(Administrator.HIRING));
                administrator.setExperience(rs.getDouble(Administrator.EXPERIENCE));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getInstance().closeResultSet(rs);
            getInstance().closePreparedStatement(pst);
            getInstance().closeConnection(connection);
        }
        return administrator;
    }

    @Override
    public Administrator findAdministratorById(int idAdmin) {
        Administrator administrator = new Administrator();

        try {
            connection = getInstance().getConnection();
            pst = connection.prepareStatement(GET_ADMINISTRATOR_BY_ID);
            pst.setInt(1, idAdmin);
            rs = pst.executeQuery();

            while (rs.next()) {
                administrator.setId(rs.getInt(Administrator.ID));
                administrator.setFirstName(rs.getString(Administrator.FIRST_NAME));
                administrator.setLastName(rs.getString(Administrator.LAST_NAME));
                administrator.setMiddleName(rs.getString(Administrator.MIDDLE_NAME));
                administrator.setPhoneNumber(rs.getString(Administrator.PHONE_NUMBER));
                administrator.setHiring(rs.getString(Administrator.HIRING));
                administrator.setExperience(rs.getDouble(Administrator.EXPERIENCE));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getInstance().closeResultSet(rs);
            getInstance().closePreparedStatement(pst);
            getInstance().closeConnection(connection);
        }
        return administrator;
    }

    @Override
    public void updateAdministrator(Administrator administrator) {
        try {
            connection = getInstance().getConnection();
            pst = connection.prepareStatement(UPDATE_ADMINISTRATOR);
            pst.setString(1, administrator.getFirstName());
            pst.setString(2, administrator.getLastName());
            pst.setString(3, administrator.getMiddleName());
            pst.setString(4, administrator.getPhoneNumber());
            pst.setString(5, administrator.getHiring());
            pst.setDouble(6, administrator.getExperience());
            pst.setInt(7, administrator.getId());

            pst.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getInstance().closePreparedStatement(pst);
            getInstance().closeConnection(connection);
        }
    }

    @Override
    public void deleteAdministrator(int id) {
        try {
            connection = getInstance().getConnection();
            pst = connection.prepareStatement(DELETE_ADMINISTRATOR_BY_ID);
            pst.setInt(1, id);
            int result = pst.executeUpdate();
            if (result == 0) {
                throw new AdministratorNotFoundException();
            }
        } catch (AdministratorNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            getInstance().closePreparedStatement(pst);
            getInstance().closeConnection(connection);
        }
    }



}
