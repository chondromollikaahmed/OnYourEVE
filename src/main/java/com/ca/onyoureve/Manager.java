package com.ca.onyoureve;

import java.util.Scanner;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// This class will store/edit/remove the manager's information The information will be stored in ManagerDB
// It is inherited from Employee
// Manager -> ManagerDB
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class Manager extends Employee
{

    public Manager()
    {
        super();
    }

    /////////////// CALLING EMPLOYEE DATABASE METHODS ///////////////

    public void viewAllEmployees()
    {
        DBEmployee obj = new DBEmployee();
      //  obj.displayAllEmployees();
    }

    public void viewEmployee()
    {
        DBEmployee obj = new DBEmployee();
        String id = new String();
        System.out.print("Viewing employee details. Enter employee ID: ");
        Scanner input = new Scanner(System.in);
        id = input.nextLine();

      //  obj.displayEmployee(id);
    }

    public void addEmployee()                               //Add a new employee
    {
        DBEmployee obj = new DBEmployee();
        employee_id = obj.insertEmployee(this);
    }

    public void deleteEmployee()                            //Delete an existing Employee
    {
        DBEmployee obj = new DBEmployee();
        String id = new String();
        System.out.print("Removing an employee. Enter employee ID: ");
        Scanner input = new Scanner(System.in);
        id = input.nextLine();

        obj.removeEmployee(id);
    }

    @Override
    public void editEmployee() {
        DBEmployee obj = new DBEmployee();
        String id = new String();
        System.out.print("Editing an employee. Enter employee ID: ");
        Scanner input = new Scanner(System.in);
        id = input.nextLine();

        //obj.editEmployee(id);
    }

    void changeEmployeeManager() {
        DBEmployee obj = new DBEmployee();
        String mid, eid;

        System.out.print("Enter employee ID: ");
        Scanner input = new Scanner(System.in);
        eid = input.nextLine();

        System.out.print("Enter manager ID: ");
        mid = input.nextLine();

        obj.changeManager(eid, mid);
    }

    /////////////// CALLING CUSTOMER DATABASE METHODS ///////////////

    public void viewAllCustomers() {
        DBCustomer obj = new DBCustomer();
       // obj.displayAllCustomers();
    }

    public void viewCustomer() {
        DBCustomer obj = new DBCustomer();
        String id = "";
        System.out.print("Viewing a customer. Enter customer ID: ");
        Scanner input = new Scanner(System.in);
        id = input.nextLine();

       //obj.displayCustomer(id);
    }

    public void createCustomerAccount()                     //Manager can create customer's account
    {
        DBCustomer obj = new DBCustomer();
       // obj.insertCustomer();
    }

    public void editCustomerAccount()                     //Manager can edit customer's account details
    {
        DBCustomer obj = new DBCustomer();
        String id = new String();
        System.out.print("Editing a customer. Enter ID: ");
        Scanner input = new Scanner(System.in);
        id = input.nextLine();

      //  obj.editCustomer(id);
    }

    public void deleteCustomerAccount()                     //Manager can delete customer's account
    {
        DBCustomer obj = new DBCustomer();
        String id = "";
        System.out.print("Deleting a customer. Enter ID: ");
        Scanner input = new Scanner(System.in);
        id = input.nextLine();

        obj.removeCustomer(id);
    }

    /////////////////// CALLING VENUE DATABASE METHODS ////////////////////

    public void addVenue() {
        DBVenue obj = new DBVenue();
        obj.addVenue();
    }

    public void deleteVenue() {
        String id = "";
        System.out.print("Removing a venue record. Enter venue ID: ");
        Scanner input = new Scanner(System.in);
        id = input.nextLine();

        DBVenue obj = new DBVenue();
        obj.deleteVenue(id);
    }

    public void viewVenue() {
        String id = "";
        System.out.print("Viewing venue details. Enter venue ID: ");
        Scanner input = new Scanner(System.in);
        id = input.nextLine();

        DBVenue obj = new DBVenue();
        obj.displayVenue(id);
    }

    public void viewAllVenues() {
        DBVenue obj = new DBVenue();
        obj.displayAllVenues();
    }

    public void editVenue() {
        String id = "";
        System.out.print("Editing a venue record. Enter venue ID: ");
        Scanner input = new Scanner(System.in);
        id = input.nextLine();

        DBVenue obj = new DBVenue();
        obj.editVenue(id);
    }

    ////////////////// CALLING STUDIO DATABASE METHODS ///////////////////

    public void addStudio() {
        DBStudio obj = new DBStudio();
        obj.addStudio();
    }

    public void deleteStudio() {
        String id = "";
        System.out.print("Deleting a studio. Enter it's studio ID: ");
        Scanner input = new Scanner(System.in);
        id = input.nextLine();

        DBStudio obj = new DBStudio();
        obj.removeStudio(id);
    }

    public void viewAllStudios() {
        DBStudio obj = new DBStudio();
        obj.displayAllStudios();
    }

    public void viewStudio() {
        String id = "";
        System.out.print("Viewing a studio. Enter it's studio ID: ");
        Scanner input = new Scanner(System.in);
        id = input.nextLine();

        DBStudio obj = new DBStudio();
        obj.displayStudio(id);
    }

    public void editStudio() {
        String id = "";
        System.out.print("Editing a studio. Enter it's studio ID: ");
        Scanner input = new Scanner(System.in);
        id = input.nextLine();

        DBStudio obj = new DBStudio();
        obj.editStudio(id);
    }

    /////////////////////// CALLING MENU DATABASE METHODS ////////////////

    public void viewMenu() {
        System.out.print("Viewing a menu. Enter it's ID: ");
        Scanner sc = new Scanner(System.in);
        String id = sc.nextLine();

        DBMenu obj = new DBMenu();
        obj.displayMenu(id);
    }

    public void viewAllMenus() {
        DBMenu obj = new DBMenu();
        obj.displayAllMenus();
    }

    public void deleteMenu() {
        System.out.print("Deleting a menu. Enter it's ID: ");
        Scanner sc = new Scanner(System.in);
        String id = sc.nextLine();

        DBMenu obj = new DBMenu();
        obj.removeMenu(id);
    }

    /////////////////////// CALLING CATERING SERVICE DATABASE METHODS ///////////////

    public void viewAllCateringServices()
    {
        CateringServicesDB obj = new CateringServicesDB();
        obj.displayAllCatering();
    }

    public void viewCateringService()
    {
        CateringServicesDB obj = new CateringServicesDB();
        String id = new String();
        System.out.print("Viewing a catering service. Enter it's ID: ");
        Scanner input = new Scanner(System.in);
        id = input.nextLine();

        obj.displayCatering(id);
    }

    public void addCateringService()
    {
        CateringServicesDB obj = new CateringServicesDB();
        obj.addCateringVendor();
    }

    public void deleteCateringService()
    {
        CateringServicesDB obj = new CateringServicesDB();
        String id = new String();
        System.out.print("Deleting a catering service. Enter it's ID: ");
        Scanner input = new Scanner(System.in);
        id = input.nextLine();

        obj.removeCatering(id);
    }

    public void editCateringService() {
        CateringServicesDB obj = new CateringServicesDB();
        String id = new String();
        System.out.print("Editing a catering service. Enter it's ID: ");
        Scanner input = new Scanner(System.in);
        id = input.nextLine();

        obj.editCatering(id);
    }

    /////////////////// CALLING MEDIA REQUIREMENTS DATABASE METHODS ///////////////////

    public void viewAllMediaRequirements() {
        Media_RequirementsDB obj = new Media_RequirementsDB();
        obj.displayAllMediaRequirements();
    }

    public void viewMediaRequirement() {
        Media_RequirementsDB obj = new Media_RequirementsDB();
        String id = "";
        System.out.print("Viewing a media requirement record. Enter ID: ");
        Scanner input = new Scanner(System.in);
        id = input.nextLine();

        obj.displayMediaRequirement(id);
    }

    public void createMediaRequirement()
    {
        Media_RequirementsDB obj = new Media_RequirementsDB();
        obj.addMediaRequirement();
    }

    public void editMediaRequirement()
    {
        Media_RequirementsDB obj = new Media_RequirementsDB();
        String id = new String();
        System.out.print("Editing a media requirement record. Enter it's ID: ");
        Scanner input = new Scanner(System.in);
        id = input.nextLine();

        obj.editMediaRequirement(id);
    }

    public void deleteMediaRequirement()
    {
        Media_RequirementsDB obj = new Media_RequirementsDB();
        String id = "";
        System.out.print("Deleting a media requirement record. Enter it's ID: ");
        Scanner input = new Scanner(System.in);
        id = input.nextLine();

        obj.removeMediaRequirement(id);
    }



    public void approveEvent(String eventid) {
        DBManager obj = new DBManager();
        obj.approveEvent(eventid);
    }
}
