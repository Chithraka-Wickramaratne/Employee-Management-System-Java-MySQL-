package com.empsystem;

public interface EmployeeInterface {

    //Create Employee
    public void createEmployee(Employee employee);

    //Show All Employee

    public void showAllEmployee();

    //Show Employee Based on ID

    public void showEmployeeBasedOnID(int id);

    //Update Employee

    public void updateEmployee(int id,String name);

    //Delete Employee
    public void deleteEmployee(int id);

}
