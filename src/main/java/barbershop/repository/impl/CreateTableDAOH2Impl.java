package barbershop.repository.impl;

import barbershop.repository.CreateTable;

import java.sql.*;

import static barbershop.repository.impl.ConnectionFactory.getInstance;

public class CreateTableDAOH2Impl implements CreateTable {

    private Connection connection;
    private PreparedStatement pst = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    private static final String CREATE_ORDERS_TABLE = "CREATE TABLE IF NOT EXISTS orders (\n" +
            "\tid int(11) PRIMARY KEY AUTO_INCREMENT,\n" +
            "\tcustomer_id int(11) NOT NULL,\n" +
            "\tmaster_hand_id int(11) NOT NULL,\n" +
            "\tcost int(11) NOT NULL,\n" +
            "\tservice_id int(11) NOT NULL,\n" +
            "\tbeginning_of_admission varchar(255) NOT NULL,\n" +
            "\tend_of_admission varchar(255) NOT NULL\n" +
            ");";

    private static final String CREATE_ADMINISTRATOR_TABLE = "CREATE TABLE IF NOT EXISTS administrators (\n" +
            "\tid int(11) PRIMARY KEY AUTO_INCREMENT,\n" +
            "\tfirst_name varchar(255) NOT NULL,\n" +
            "\tlast_name varchar(255) NOT NULL,\n" +
            "\tmiddle_name varchar(255) NOT NULL,\n" +
            "\tphone_number varchar(255) NOT NULL,\n" +
            "\thiring varchar(255) NOT NULL,\n" +
            "\texperience int(11) NOT NULL\n" +
            ");";

    private static final String CREATE_CLEANING_WOMAN_TABLE = "CREATE TABLE IF NOT EXISTS cleaning_women (\n" +
            "\tid int(11) PRIMARY KEY AUTO_INCREMENT,\n" +
            "\tfirst_name varchar(255) NOT NULL,\n" +
            "\tlast_name varchar(255) NOT NULL,\n" +
            "\tmiddle_name varchar(255) NOT NULL,\n" +
            "\tphone_number varchar(255) NOT NULL,\n" +
            "\thiring varchar(255) NOT NULL,\n" +
            "\texperience int(11) NOT NULL\n" +
            ");";

    private static final String CREATE_CUSTOMER_TABLE = "CREATE TABLE IF NOT EXISTS customers (\n" +
            "\tid int(11) PRIMARY KEY AUTO_INCREMENT,\n" +
            "\tfirst_name varchar(255) NOT NULL,\n" +
            "\tlast_name varchar(255) NOT NULL,\n" +
            "\tmiddle_name varchar(255) NOT NULL,\n" +
            "\tphone_number varchar(255) NOT NULL\n" +
            ");";

    private static final String CREATE_HAIRDRESSER_TABLE = "CREATE TABLE IF NOT EXISTS hairdressers (\n" +
            "\tid int(11) PRIMARY KEY AUTO_INCREMENT,\n" +
            "\tfirst_name varchar(255) NOT NULL,\n" +
            "\tlast_name varchar(255) NOT NULL,\n" +
            "\tmiddle_name varchar(255) NOT NULL,\n" +
            "\tphone_number varchar(255) NOT NULL,\n" +
            "\thiring varchar(255) NOT NULL,\n" +
            "\texperience int(11) NOT NULL,\n" +
            "\tnumber_certificate_id int(11) NOT NULL\n" +
            ");";

    private static final String CREATE_MANICURIST_TABLE = "CREATE TABLE IF NOT EXISTS manicurists (\n" +
            "\tid int(11) PRIMARY KEY AUTO_INCREMENT,\n" +
            "\tfirst_name varchar(255) NOT NULL,\n" +
            "\tlast_name varchar(255) NOT NULL,\n" +
            "\tmiddle_name varchar(255) NOT NULL,\n" +
            "\tphone_number varchar(255) NOT NULL,\n" +
            "\thiring varchar(255) NOT NULL,\n" +
            "\texperience int(11) NOT NULL,\n" +
            "\tnumber_certificate_id int(11) NOT NULL\n" +
            ");";

    private static final String CREATE_MASTER_HAND_TABLE = "CREATE TABLE IF NOT EXISTS master_hands (\n" +
            "\tid int(11) PRIMARY KEY AUTO_INCREMENT,\n" +
            "\tfirst_name varchar(255) NOT NULL,\n" +
            "\tlast_name varchar(255) NOT NULL,\n" +
            "\tmiddle_name varchar(255) NOT NULL,\n" +
            "\tphone_number varchar(255) NOT NULL,\n" +
            "\thiring varchar(255) NOT NULL,\n" +
            "\texperience int(11) NOT NULL,\n" +
            "\tnumber_certificate_id int(11) NOT NULL\n" +
            ");";

    private static final String CREATE_SERVICES_TABLE = "CREATE TABLE IF NOT EXISTS services (\n" +
            "\tid int(11) PRIMARY KEY AUTO_INCREMENT,\n" +
            "\tservice_id varchar(255) NOT NULL,\n" +
            "\tcost int(11) NOT NULL\n" +
            ");";

    private static final String CREATE_MASTER_HAND_CUSTOMER_TABLE = "CREATE TABLE IF NOT EXISTS master_hand_customer (\n" +
            "\tid int(11) PRIMARY KEY AUTO_INCREMENT,\n" +
            "\tmaster_hand_id int(11) NOT NULL,\n" +
            "\tcustomer_id int(11) NOT NULL\n" +
            ");";

    private static final String CREATE_CERTIFICATE_TABLE = "CREATE TABLE IF NOT EXISTS certificates (\n" +
            "\tid int(11) PRIMARY KEY AUTO_INCREMENT,\n" +
            "\tnumber_certificate int(11) NOT NULL UNIQUE\n" +
            ");";

    private static final String CREATE_SERVICE_TABLE = "CREATE TABLE IF NOT EXISTS service (\n" +
            "\tid int(11) PRIMARY KEY AUTO_INCREMENT,\n" +
            "\tservice varchar(255) NOT NULL UNIQUE\n" +
            ");";

    private static final String ALTER_TABLE_ORDERS_FK0 = "ALTER TABLE orders ADD FOREIGN KEY(customer_id) REFERENCES customers(id);";

    private static final String ALTER_TABLE_ORDERS_FK1 = "ALTER TABLE orders ADD FOREIGN KEY (master_hand_id) REFERENCES master_hands(id);";

    private static final String ALTER_TABLE_ORDERS_FK2 = "ALTER TABLE orders ADD FOREIGN KEY (service_id) REFERENCES services(id);";

    private static final String ALTER_TABLE_MASTER_HAND = "ALTER TABLE orders ADD FOREIGN KEY (master_hand_id) REFERENCES master_hands(id);";

    private static final String ALTER_TABLE_CUSTOMER = "ALTER TABLE orders ADD FOREIGN KEY (customer_id) REFERENCES customers(id);";

    private static final String ALTER_TABLE_CERTIFICATE = "ALTER TABLE master_hands ADD FOREIGN KEY (number_certificate_id) REFERENCES certificates(id);";

    private static final String ALTER_TABLE_CERTIFICATE2 = "ALTER TABLE hairdressers ADD FOREIGN KEY (number_certificate_id) REFERENCES certificates(id);";

    private static final String ALTER_TABLE_CERTIFICATE3 = "ALTER TABLE manicurists ADD FOREIGN KEY (number_certificate_id) REFERENCES certificates(id);";

    private static final String ALTER_TABLE_SERVICE = "ALTER TABLE services ADD FOREIGN KEY (service_id) REFERENCES service(id);";

    private void createTableIfNotExists(String name) {
        try {
            connection = getInstance().getConnection();
            stmt = connection.createStatement();
            stmt.executeUpdate(name);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getInstance().closeStatement(stmt);
            getInstance().closeConnection(connection);
        }
    }

    @Override
    public void createTableOrder() {
        createTableIfNotExists(CREATE_ORDERS_TABLE);
    }

    @Override
    public void createTableAdministrator() {
        createTableIfNotExists(CREATE_ADMINISTRATOR_TABLE);
    }

    @Override
    public void createTableCleaningWoman() {
        createTableIfNotExists(CREATE_CLEANING_WOMAN_TABLE);
    }

    @Override
    public void createTableCustomer() {
        createTableIfNotExists(CREATE_CUSTOMER_TABLE);
    }

    @Override
    public void createTableHairdresser() {
        createTableIfNotExists(CREATE_HAIRDRESSER_TABLE);
    }

    @Override
    public void createTableManicurist() {
        createTableIfNotExists(CREATE_MANICURIST_TABLE);
    }

    @Override
    public void createTableMasterHand() {
        createTableIfNotExists(CREATE_MASTER_HAND_TABLE);
    }

    @Override
    public void createTableServices() {
        createTableIfNotExists(CREATE_SERVICES_TABLE);
    }

    @Override
    public void createTableMasterHandCustomer() {
        createTableIfNotExists(CREATE_MASTER_HAND_CUSTOMER_TABLE);
    }

    public void createTableCertificate() {
        createTableIfNotExists(CREATE_CERTIFICATE_TABLE);
    }

    public void createTableService() {
        createTableIfNotExists(CREATE_SERVICE_TABLE);
    }

    @Override
    public void createAlterTable() {
        try {
            connection = getInstance().getConnection();
            stmt = connection.createStatement();
            stmt.executeUpdate(ALTER_TABLE_ORDERS_FK0);
            stmt.executeUpdate(ALTER_TABLE_ORDERS_FK1);
            stmt.executeUpdate(ALTER_TABLE_ORDERS_FK2);
            stmt.executeUpdate(ALTER_TABLE_CUSTOMER);
            stmt.executeUpdate(ALTER_TABLE_MASTER_HAND);
            stmt.executeUpdate(ALTER_TABLE_CERTIFICATE);
            stmt.executeUpdate(ALTER_TABLE_CERTIFICATE2);
            stmt.executeUpdate(ALTER_TABLE_CERTIFICATE3);
            stmt.executeUpdate(ALTER_TABLE_SERVICE);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getInstance().closeStatement(stmt);
            getInstance().closeConnection(connection);
        }
    }
}
