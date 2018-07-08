package barbershop.controller;

import barbershop.domain.*;
import barbershop.repository.impl.CreateTableDAOH2Impl;
import barbershop.service.*;

import java.util.Scanner;

public class MainController {

    private AdministratorService administratorService = new AdministratorService();
    private CleaningWomanService cleaningWomanService = new CleaningWomanService();
    private CustomerService customerService = new CustomerService();
    private HairdresserService hairdresserService = new HairdresserService();
    private ManicuristService manicuristService = new ManicuristService();
    private MasterHandService masterHandService = new MasterHandService();
    private OrderService orderService = new OrderService();
    private ServicesService servicesService = new ServicesService();

    static {
        MainController.initDatabase();
    }

    public void doWork() {
        showHelloMessage();
        while (true) {
            showMenu();
            makeChoice();
        }
    }

    private void showMenu() {

        System.out.println("Choose who to act on: ");
        System.out.println("1. Administrator");
        System.out.println("2. CleaningWoman");
        System.out.println("3. Customer");
        System.out.println("4. Hairdresser");
        System.out.println("5. Manicurist");
        System.out.println("6. MasterHand");
        System.out.println("7. Order");
        System.out.println("8. Service");

        System.out.println("\n0. Exit");

    }

    private void makeChoice() {

        Scanner sc = new Scanner(System.in);
        int choice = 0;
        try {
            choice = sc.nextInt();

        } catch (Exception e) {
            System.out.println("Error");
            System.out.println("Try again");
            makeChoice();
        }

        switch (choice) {
            case 1: {
                methodAdministrator();
                break;
            }
            case 2: {
                methodCleaningWoman();
                break;
            }
            case 3: {
                methodCustomer();
                break;
            }
            case 4: {
                methodHairdresser();
                break;
            }
            case 5: {
                methodManicurist();
                break;
            }
            case 6: {
                methodMasterHand();
                break;
            }
            case 7: {
                methodOrder();
                break;
            }
            case 8: {
                methodServices();
                break;
            }
            case 0: {
                System.out.println("Goodbye!!!");
                System.exit(1);
            }
            default: {
                System.out.println("Wrong choice");
                makeChoice();
            }
        }
    }





    private void methodAdministrator() {
        Scanner sc = new Scanner(System.in);
        showMenuAdministrator();
        int choice2 = 0;
        try {
            choice2 = sc.nextInt();

        } catch (Exception e) {
            System.out.println("Error");
            System.out.println("Try again");
            makeChoice();
        }

        switch (choice2) {
            case 1: {
                addAdministrator();
                break;
            }
            case 2: {
                System.out.println(administratorService.getAllAdministrators());
                break;
            }
            case 3: {
                findAdministratorByName();
                break;
            }
            case 4: {
                int idAdministrator = sc.nextInt();
                System.out.println(administratorService.findAdministratorById(idAdministrator));
                break;
            }
            case 5: {
                updateAdministrator();
                break;
            }
            case 6: {
                deleteAdministrator();
                break;
            }
            case 0: {
                System.out.println("Goodbye!!!");
                System.exit(1);
            }
            default: {
                System.out.println("Wrong choice");
                makeChoice();
            }
        }

    }

    private void showMenuAdministrator(){
        System.out.println("Make your choice: ");
        System.out.println("1. Add administrator");
        System.out.println("2. Get all administrators");
        System.out.println("3. Find administrator by name");
        System.out.println("4. Find administrator by id");
        System.out.println("5. Update administrator");
        System.out.println("6. Delete administrator");
        System.out.println("\n0. Exit");
    }

    private void findAdministratorByName() {
        Administrator administrator = new Administrator();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first name");
        administrator.setFirstName(sc.next());
        System.out.println("Enter last name");
        administrator.setLastName(sc.next());
        System.out.println("Enter middle name");
        administrator.setMiddleName(sc.next());
        System.out.println("Enter phone number");
        administrator.setPhoneNumber(sc.next());
        System.out.println(administratorService.findAdministrator(administrator));
    }

    private void addAdministrator() {
        Administrator administrator = new Administrator();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first name");
        administrator.setFirstName(sc.next());
        System.out.println("Enter last name");
        administrator.setLastName(sc.next());
        System.out.println("Enter middle name");
        administrator.setMiddleName(sc.next());
        System.out.println("Enter phone number");
        administrator.setPhoneNumber(sc.next());
        System.out.println("Enter hiring");
        administrator.setHiring(sc.next());
        System.out.println("Enter experience");
        administrator.setExperience(sc.nextInt());
        administratorService.addAdministrator(administrator);
    }

    private void updateAdministrator() {

        Scanner sc = new Scanner(System.in);
        AdministratorService administratorService = new AdministratorService();
        System.out.println("Enter the administrator's which you want to change");
        administratorService.getAllAdministrators();
        int n = sc.nextInt() - 1;

        try {
            Administrator administrator = administratorService.getAllAdministrators().get(n);

            System.out.println("Enter first name: ");
            administrator.setFirstName(sc.next());
            System.out.println("Enter last name: ");
            administrator.setLastName(sc.next());
            System.out.println("Enter middle name: ");
            administrator.setMiddleName(sc.next());
            System.out.println("Enter phone number");
            administrator.setPhoneNumber(sc.next());
            System.out.println("Enter hiring");
            administrator.setHiring(sc.next());
            System.out.println("Enter experience: ");
            administrator.setExperience(sc.nextInt());
            administratorService.updateAdministrator(administrator);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteAdministrator() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id administrator");
        int idAdmin = sc.nextInt();
        administratorService.deleteAdministrator(idAdmin);
    }


    private void methodCleaningWoman() {
        Scanner sc = new Scanner(System.in);
        showMenuCleaningWoman();
        int choice2 = 0;
        try {
            choice2 = sc.nextInt();

        } catch (Exception e) {
            System.out.println("Error");
            System.out.println("Try again");
            makeChoice();
        }

        switch (choice2) {
            case 1: {
                addCleaningWoman();
                break;
            }
            case 2: {
                System.out.println(cleaningWomanService.getAllCleaningWomen());
                break;
            }
            case 3: {
                findCleaningWomanByName();
                break;
            }
            case 4: {
                int idCleaningWoman = sc.nextInt();
                System.out.println(cleaningWomanService.findCleaningWomanById(idCleaningWoman));
                break;
            }
            case 5: {
                updateCleaningWoman();
                break;
            }
            case 6: {
                deleteCleaningWoman();
                break;
            }
            case 0: {
                System.out.println("Goodbye!!!");
                System.exit(1);
            }
            default: {
                System.out.println("Wrong choice");
                makeChoice();
            }
        }

    }

    private void showMenuCleaningWoman(){
        System.out.println("Make your choice: ");
        System.out.println("1. Add cleaning woman");
        System.out.println("2. Get all cleaning women");
        System.out.println("3. Find cleaning woman by name");
        System.out.println("4. Find cleaning woman by id");
        System.out.println("5. Update cleaning woman");
        System.out.println("6. Delete cleaning woman");
        System.out.println("\n0. Exit");
    }

    private void findCleaningWomanByName() {
        CleaningWoman cleaningWoman = new CleaningWoman();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first name");
        cleaningWoman.setFirstName(sc.next());
        System.out.println("Enter last name");
        cleaningWoman.setLastName(sc.next());
        System.out.println("Enter middle name");
        cleaningWoman.setMiddleName(sc.next());
        System.out.println("Enter phone number");
        cleaningWoman.setPhoneNumber(sc.next());
        System.out.println(cleaningWomanService.findCleaningWoman(cleaningWoman));
    }

    private void addCleaningWoman() {
        CleaningWoman cleaningWoman = new CleaningWoman();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first name");
        cleaningWoman.setFirstName(sc.next());
        System.out.println("Enter last name");
        cleaningWoman.setLastName(sc.next());
        System.out.println("Enter middle name");
        cleaningWoman.setMiddleName(sc.next());
        System.out.println("Enter phone number");
        cleaningWoman.setPhoneNumber(sc.next());
        System.out.println("Enter hiring");
        cleaningWoman.setHiring(sc.next());
        System.out.println("Enter experience");
        cleaningWoman.setExperience(sc.nextInt());
        cleaningWomanService.addCleaningWoman(cleaningWoman);
    }

    private void updateCleaningWoman() {

        Scanner sc = new Scanner(System.in);
        CleaningWomanService cleaningWomanService = new CleaningWomanService();
        System.out.println("Enter the cleaning women which you want to change");
        cleaningWomanService.getAllCleaningWomen();
        int n = sc.nextInt() - 1;

        try {
            CleaningWoman cleaningWoman = cleaningWomanService.getAllCleaningWomen().get(n);

            System.out.println("Enter first name: ");
            cleaningWoman.setFirstName(sc.next());
            System.out.println("Enter last name: ");
            cleaningWoman.setLastName(sc.next());
            System.out.println("Enter middle name: ");
            cleaningWoman.setMiddleName(sc.next());
            System.out.println("Enter phone number");
            cleaningWoman.setPhoneNumber(sc.next());
            System.out.println("Enter hiring");
            cleaningWoman.setHiring(sc.next());
            System.out.println("Enter experience: ");
            cleaningWoman.setExperience(sc.nextInt());
            cleaningWomanService.updateCleaningWoman(cleaningWoman);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteCleaningWoman() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id cleaning woman");
        int idClean = sc.nextInt();
        cleaningWomanService.deleteCleaningWoman(idClean);
    }



    private void methodHairdresser() {
        Scanner sc = new Scanner(System.in);
        showMenuHairdresser();
        int choice2 = 0;
        try {
            choice2 = sc.nextInt();

        } catch (Exception e) {
            System.out.println("Error");
            System.out.println("Try again");
            makeChoice();
        }

        switch (choice2) {
            case 1: {
                addHairdresser();
                break;
            }
            case 2: {
                System.out.println(hairdresserService.getAllHairdresser());
                break;
            }
            case 3: {
                findHairdresserByName();
                break;
            }
            case 4: {
                int idHairdresser = sc.nextInt();
                System.out.println(hairdresserService.findHairdresserById(idHairdresser));
                break;
            }
            case 5: {
                updateHairdresser();
                break;
            }
            case 6: {
                deleteHairdresser();
                break;
            }
            case 0: {
                System.out.println("Goodbye!!!");
                System.exit(1);
            }
            default: {
                System.out.println("Wrong choice");
                makeChoice();
            }
        }

    }

    private void showMenuHairdresser(){
        System.out.println("Make your choice: ");
        System.out.println("1. Add hairdresser");
        System.out.println("2. Get all hairdresser");
        System.out.println("3. Find hairdresser by name");
        System.out.println("4. Find hairdresser by id");
        System.out.println("5. Update hairdresser");
        System.out.println("6. Delete hairdresser");
        System.out.println("\n0. Exit");
    }

    private void findHairdresserByName() {
        Hairdresser hairdresser = new Hairdresser();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first name");
        hairdresser.setFirstName(sc.next());
        System.out.println("Enter last name");
        hairdresser.setLastName(sc.next());
        System.out.println("Enter middle name");
        hairdresser.setMiddleName(sc.next());
        System.out.println("Enter phone number");
        hairdresser.setPhoneNumber(sc.next());
        System.out.println(hairdresserService.findHairdresser(hairdresser));
    }

    private void addHairdresser() {
        Hairdresser hairdresser = new Hairdresser();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first name");
        hairdresser.setFirstName(sc.next());
        System.out.println("Enter last name");
        hairdresser.setLastName(sc.next());
        System.out.println("Enter middle name");
        hairdresser.setMiddleName(sc.next());
        System.out.println("Enter phone number");
        hairdresser.setPhoneNumber(sc.next());
        System.out.println("Enter hiring");
        hairdresser.setHiring(sc.next());
        System.out.println("Enter experience");
        hairdresser.setExperience(sc.nextInt());
        hairdresserService.addHairdresser(hairdresser);
    }

    private void updateHairdresser() {

        Scanner sc = new Scanner(System.in);
        HairdresserService hairdresserService = new HairdresserService();
        System.out.println("Enter the hairdresser's which you want to change");
        hairdresserService.getAllHairdresser();
        int n = sc.nextInt() - 1;

        try {
            Hairdresser hairdresser = hairdresserService.getAllHairdresser().get(n);

            System.out.println("Enter first name: ");
            hairdresser.setFirstName(sc.next());
            System.out.println("Enter last name: ");
            hairdresser.setLastName(sc.next());
            System.out.println("Enter middle name: ");
            hairdresser.setMiddleName(sc.next());
            System.out.println("Enter phone number");
            hairdresser.setPhoneNumber(sc.next());
            System.out.println("Enter hiring");
            hairdresser.setHiring(sc.next());
            System.out.println("Enter experience: ");
            hairdresser.setExperience(sc.nextInt());
            hairdresserService.updateHairdresser(hairdresser);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteHairdresser() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id hairdresser");
        int idClean = sc.nextInt();
        hairdresserService.deleteHairdresser(idClean);
    }


    private void methodManicurist() {
        Scanner sc = new Scanner(System.in);
        showMenuManicurist();
        int choice2 = 0;
        try {
            choice2 = sc.nextInt();

        } catch (Exception e) {
            System.out.println("Error");
            System.out.println("Try again");
            makeChoice();
        }

        switch (choice2) {
            case 1: {
                addManicurist();
                break;
            }
            case 2: {
                System.out.println(manicuristService.getAllManicurists());
                break;
            }
            case 3: {
                findManicuristByName();
                break;
            }
            case 4: {
                int idManicurist = sc.nextInt();
                System.out.println(manicuristService.findManicuristById(idManicurist));
                break;
            }
            case 5: {
                updateManicurist();
                break;
            }
            case 6: {
                deleteManicurist();
                break;
            }
            case 0: {
                System.out.println("Goodbye!!!");
                System.exit(1);
            }
            default: {
                System.out.println("Wrong choice");
                makeChoice();
            }
        }

    }

    private void showMenuManicurist(){
        System.out.println("Make your choice: ");
        System.out.println("1. Add manicurist");
        System.out.println("2. Get all manicurists");
        System.out.println("3. Find manicurist by name");
        System.out.println("4. Find manicurist by id");
        System.out.println("5. Update manicurist");
        System.out.println("6. Delete manicurist");
        System.out.println("\n0. Exit");
    }

    private void findManicuristByName() {
        Manicurist manicurist = new Manicurist();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first name");
        manicurist.setFirstName(sc.next());
        System.out.println("Enter last name");
        manicurist.setLastName(sc.next());
        System.out.println("Enter middle name");
        manicurist.setMiddleName(sc.next());
        System.out.println("Enter phone number");
        manicurist.setPhoneNumber(sc.next());
        System.out.println(manicuristService.findManicurist(manicurist));
    }

    private void addManicurist() {
        Manicurist manicurist = new Manicurist();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first name");
        manicurist.setFirstName(sc.next());
        System.out.println("Enter last name");
        manicurist.setLastName(sc.next());
        System.out.println("Enter middle name");
        manicurist.setMiddleName(sc.next());
        System.out.println("Enter phone number");
        manicurist.setPhoneNumber(sc.next());
        System.out.println("Enter hiring");
        manicurist.setHiring(sc.next());
        System.out.println("Enter experience");
        manicurist.setExperience(sc.nextInt());
        manicuristService.addManicurist(manicurist);
    }

    private void updateManicurist() {

        Scanner sc = new Scanner(System.in);
        ManicuristService manicuristService = new ManicuristService();
        System.out.println("Enter the manicurist's which you want to change");
        manicuristService.getAllManicurists();
        int n = sc.nextInt() - 1;

        try {
            Manicurist manicurist = manicuristService.getAllManicurists().get(n);

            System.out.println("Enter first name: ");
            manicurist.setFirstName(sc.next());
            System.out.println("Enter last name: ");
            manicurist.setLastName(sc.next());
            System.out.println("Enter middle name: ");
            manicurist.setMiddleName(sc.next());
            System.out.println("Enter phone number");
            manicurist.setPhoneNumber(sc.next());
            System.out.println("Enter hiring");
            manicurist.setHiring(sc.next());
            System.out.println("Enter experience: ");
            manicurist.setExperience(sc.nextInt());
            manicuristService.updateManicurist(manicurist);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteManicurist() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id manicurist");
        int idManic = sc.nextInt();
        manicuristService.deleteManicurist(idManic);
    }


    private void methodMasterHand() {
        Scanner sc = new Scanner(System.in);
        showMenuMasterHand();
        int choice2 = 0;
        try {
            choice2 = sc.nextInt();

        } catch (Exception e) {
            System.out.println("Error");
            System.out.println("Try again");
            makeChoice();
        }

        switch (choice2) {
            case 1: {
                addMasterHand();
                break;
            }
            case 2: {
                System.out.println(masterHandService.getAllMasterHand());
                break;
            }
            case 3: {
                findMasterHandByName();
                break;
            }
            case 4: {
                int idMasterHand = sc.nextInt();
                System.out.println(masterHandService.findMasterHandById(idMasterHand));
                break;
            }
            case 5: {
                updateMasterHand();
                break;
            }
            case 6: {
                deleteMasterHand();
                break;
            }
            case 0: {
                System.out.println("Goodbye!!!");
                System.exit(1);
            }
            default: {
                System.out.println("Wrong choice");
                makeChoice();
            }
        }

    }

    private void showMenuMasterHand(){
        System.out.println("Make your choice: ");
        System.out.println("1. Add master-hand");
        System.out.println("2. Get all master-hands");
        System.out.println("3. Find master-hand by name");
        System.out.println("4. Find master-hand by id");
        System.out.println("5. Update master-hand");
        System.out.println("6. Delete master-hand");
        System.out.println("\n0. Exit");
    }

    private void findMasterHandByName() {
        MasterHand masterHand = new MasterHand();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first name");
        masterHand.setFirstName(sc.next());
        System.out.println("Enter last name");
        masterHand.setLastName(sc.next());
        System.out.println("Enter middle name");
        masterHand.setMiddleName(sc.next());
        System.out.println("Enter phone number");
        masterHand.setPhoneNumber(sc.next());
        System.out.println(masterHandService.findMasterHand(masterHand));
    }

    private void addMasterHand() {
        MasterHand masterHand = new MasterHand();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first name");
        masterHand.setFirstName(sc.next());
        System.out.println("Enter last name");
        masterHand.setLastName(sc.next());
        System.out.println("Enter middle name");
        masterHand.setMiddleName(sc.next());
        System.out.println("Enter phone number");
        masterHand.setPhoneNumber(sc.next());
        System.out.println("Enter hiring");
        masterHand.setHiring(sc.next());
        System.out.println("Enter experience");
        masterHand.setExperience(sc.nextInt());
        masterHandService.addMasterHand(masterHand);
    }

    private void updateMasterHand() {

        Scanner sc = new Scanner(System.in);
        MasterHandService masterHandService = new MasterHandService();
        System.out.println("Enter the master-hand's which you want to change");
        masterHandService.getAllMasterHand();
        int n = sc.nextInt() - 1;

        try {
            MasterHand masterHand = masterHandService.getAllMasterHand().get(n);

            System.out.println("Enter first name: ");
            masterHand.setFirstName(sc.next());
            System.out.println("Enter last name: ");
            masterHand.setLastName(sc.next());
            System.out.println("Enter middle name: ");
            masterHand.setMiddleName(sc.next());
            System.out.println("Enter phone number");
            masterHand.setPhoneNumber(sc.next());
            System.out.println("Enter hiring");
            masterHand.setHiring(sc.next());
            System.out.println("Enter experience: ");
            masterHand.setExperience(sc.nextInt());
            masterHandService.updateMasterHand(masterHand);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteMasterHand() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id master-hand");
        int idMaster = sc.nextInt();
        masterHandService.deleteMasterHand(idMaster);
    }


    private void methodCustomer() {
        Scanner sc = new Scanner(System.in);
        showMenuCustomer();
        int choice2 = 0;
        try {
            choice2 = sc.nextInt();

        } catch (Exception e) {
            System.out.println("Error");
            System.out.println("Try again");
            makeChoice();
        }

        switch (choice2) {
            case 1: {
                addCustomer();
                break;
            }
            case 2: {
                System.out.println(customerService.getAllCustomers());
                break;
            }
            case 3: {
                int idCustomer = sc.nextInt();
                System.out.println(customerService.findCustomerById(idCustomer));
                break;
            }
            case 0: {
                System.out.println("Goodbye!!!");
                System.exit(1);
            }
            default: {
                System.out.println("Wrong choice");
                makeChoice();
            }
        }

    }

    private void showMenuCustomer(){
        System.out.println("Make your choice: ");
        System.out.println("1. Add customer");
        System.out.println("2. Get all customer");
        System.out.println("2. Find customer by id");
        System.out.println("\n0. Exit");
    }

    private void addCustomer() {
        Customer customer = new Customer();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first name");
        customer.setFirstName(sc.next());
        System.out.println("Enter last name");
        customer.setLastName(sc.next());
        System.out.println("Enter middle name");
        customer.setMiddleName(sc.next());
        System.out.println("Enter phone number");
        customer.setPhoneNumber(sc.next());
;
        customerService.addCustomer(customer);
    }


    private void methodServices() {
        Scanner sc = new Scanner(System.in);
        showMenuServices();
        int choice2 = 0;
        try {
            choice2 = sc.nextInt();

        } catch (Exception e) {
            System.out.println("Error");
            System.out.println("Try again");
            makeChoice();
        }

        switch (choice2) {
            case 1: {
                addServices();
                break;
            }
            case 2: {
                System.out.println(servicesService.getAllServices());
                break;
            }
            case 3: {
                int idServices = sc.nextInt();
                System.out.println(servicesService.findServicesById(idServices));
                break;
            }
            case 4: {
                updateServices();
                break;
            }
            case 5: {
                deleteServices();
                break;
            }
            case 0: {
                System.out.println("Goodbye!!!");
                System.exit(1);
            }
            default: {
                System.out.println("Wrong choice");
                makeChoice();
            }
        }

    }

    private void showMenuServices(){
        System.out.println("Make your choice: ");
        System.out.println("1. Add services");
        System.out.println("2. Get all services");
        System.out.println("3. Find services by name");
        System.out.println("4. Find services by id");
        System.out.println("5. Update services");
        System.out.println("6. Delete services");
        System.out.println("\n0. Exit");
    }

    private void addServices() {
        Services services = new Services();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter service");
        services.setServiceList(sc.next());
        System.out.println("Enter cost");
        services.setCost(sc.nextInt());
        servicesService.addServices(services);
    }

    private void updateServices() {

        Scanner sc = new Scanner(System.in);
        ServicesService servicesService = new ServicesService();
        System.out.println("Enter the service's which you want to change");
        servicesService.getAllServices();
        int n = sc.nextInt() - 1;

        try {
            Services services = servicesService.getAllServices().get(n);
            System.out.println("Enter service");
            services.setServiceList(sc.next());
            System.out.println("Enter cost");
            services.setCost(sc.nextInt());
            servicesService.updateServices(services);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteServices() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id services");
        int idSer = sc.nextInt();
        servicesService.deleteServices(idSer);
    }


    private void methodOrder() {
        Scanner sc = new Scanner(System.in);
        showMenuOrder();
        int choice2 = 0;
        try {
            choice2 = sc.nextInt();

        } catch (Exception e) {
            System.out.println("Error");
            System.out.println("Try again");
            makeChoice();
        }

        switch (choice2) {
            case 1: {
                addOrder();
                break;
            }
            case 2: {
                System.out.println(orderService.getAllOrders());
                break;
            }
            case 3: {
                deleteOrder();
                break;
            }
            case 0: {
                System.out.println("Goodbye!!!");
                System.exit(1);
            }
            default: {
                System.out.println("Wrong choice");
                makeChoice();
            }
        }

    }

    private void showMenuOrder(){
        System.out.println("Make your choice: ");
        System.out.println("1. Add order");
        System.out.println("2. Get all orders");
        System.out.println("3. Delete order");
    }

    private void addOrder() {
        Order order = new Order();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter customerId");
        order.setCustomerId(sc.nextInt());
        System.out.println("Enter masterHandId");
        order.setMasterHandId(sc.nextInt());
        System.out.println("Enter cost");
        order.setCost(sc.nextInt());
        System.out.println("Enter service");
        order.setServicesId(sc.nextInt());
        System.out.println("Enter beginningOfAdmission");
        order.setBeginningOfAdmission(sc.next());
        System.out.println("Enter endOfAdmission");
        order.setEndOfAdmission(sc.next());
        orderService.addOrder(order);
    }

    private void deleteOrder() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id order");
        int idOrder = sc.nextInt();
        orderService.deleteOrder(idOrder);
    }

    private void showHelloMessage() {
        System.out.println("*******************");
        System.out.println("BarberShop DataBase");
        System.out.println("*******************");
        System.out.println();
    }

    private static void initDatabase(){
        CreateTableDAOH2Impl createTableDAOH2 = new CreateTableDAOH2Impl();
        createTableDAOH2.createTableMasterHand();
        createTableDAOH2.createTableCustomer();
        createTableDAOH2.createTableAdministrator();
        createTableDAOH2.createTableCleaningWoman();
        createTableDAOH2.createTableHairdresser();
        createTableDAOH2.createTableManicurist();
        createTableDAOH2.createTableServices();
        createTableDAOH2.createTableOrder();
        createTableDAOH2.createAlterTable();
    }



}
