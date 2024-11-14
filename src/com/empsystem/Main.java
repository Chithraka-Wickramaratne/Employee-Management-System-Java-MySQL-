package com.empsystem;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        EmployeeInterface employeeInterface = new EmployeeInterfaceImpl();

        System.out.println();
        System.out.println("--------------------- Welcome to Employee Management System ---------------------");
        System.out.println();

        do{
            System.out.println("1.Add Employee");
            System.out.println("2.Show All Employee");
            System.out.println("3.Show Employee Based On ID");
            System.out.println("4.Update The Employee");
            System.out.println("5.Delete The Employee");
            System.out.println("6.Exit");

            System.out.println();

            System.out.println("Select Option: ");
            int ch = input.nextInt();

            switch (ch){
                case 1:

                    Employee employee = new Employee();

                    System.out.println("Enter ID: ");
                    int id = input.nextInt();

                    System.out.println("Enter Name: ");
                    String name = input.next();

                    System.out.println("Enter Salary: ");
                    double salary =  input.nextDouble();

                    System.out.println("Enter Age: ");
                    int age = input.nextInt();

                    employee.setId(id);
                    employee.setName(name);
                    employee.setSalary(salary);
                    employee.setAge(age);

                    employeeInterface.createEmployee(employee);
                    break;

                case 2:
                    employeeInterface.showAllEmployee();
                    break;

                case 3:
                    System.out.println("Enter Employee ID: ");
                    int empID = input.nextInt();

                    employeeInterface.showEmployeeBasedOnID(empID);
                    break;

                case 4:

                    System.out.println("Enter ID Want to be Updated: ");
                    int empid = input.nextInt();

                    System.out.println("Enter Name to be Updated: ");
                    String empname = input.next();

                    employeeInterface.updateEmployee(empid,empname);

                    break;

                case 5:

                    System.out.println("Enter the ID Want to be Delete: ");
                    int eid = input.nextInt();

                    employeeInterface.deleteEmployee(eid);
                    break;
                case 6:
                    System.out.println("--------------------- Thank You For Using Employee Management System ---------------------");
                    System.exit(0);

                default:
                    System.out.println("Enter Valid Choice");
                    break;
            }

        }while (true);
    }
}
