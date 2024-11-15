package com.empsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeInterfaceImpl implements  EmployeeInterface{

    Connection con;

    @Override
    public void createEmployee(Employee employee) {

        con = DBConnection.createDBConnection();
        String query = "insert into employee values(?,?,?,?)";

        try{

            PreparedStatement pstm = con.prepareStatement(query);

            pstm.setInt(1,employee.getId());
            pstm.setString(2,employee.getName());
            pstm.setDouble(3,employee.getSalary());
            pstm.setInt(4,employee.getAge());
            int count = pstm.executeUpdate();

            if(count != 0)
                System.out.println("Employee Update Successfully!");
                System.out.println();

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void showAllEmployee() {

        con = DBConnection.createDBConnection();

        String query = "SELECT * FROM employeedb.employee";
        System.out.println("Employee Details");
        System.out.format("%s\t%s\t%s\t%s\n"," ID"," Name"," Salary"," Age");
        System.out.println("-------------------------------------------------");

        try{
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(query);

            while (result.next()){

                System.out.format("%d\t%s\t%f\t%d\n",result.getInt(1),result.getString(2),result.getDouble(3),result.getInt(4));
                System.out.println("-------------------------------------------------");
            }
        }catch(Exception ex){

            ex.printStackTrace();
        }

    }

    @Override
    public void showEmployeeBasedOnID(int id) {

        con = DBConnection.createDBConnection();
        String query = "SELECT * FROM employeedb.employee WHERE id ="+id;

        System.out.format("%s\t%s\t%s\t%s\n"," ID"," Name"," Salary"," Age");
        System.out.println("-------------------------------------------------");

        try{
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(query);

            while (result.next()){

                System.out.format("%d\t%s\t%f\t%d\n",result.getInt(1),result.getString(2),result.getDouble(3),result.getInt(4));

            }

        }catch(Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void updateEmployee(int id, String name) {

        con = DBConnection.createDBConnection();
        String query = "update employeedb.employee set name = ? where id = ?";

        try{

            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1,name);
            pstm.setInt(2,id);
            int count = pstm.executeUpdate();

            if(count!= 0)
                System.out.println("Employee Details Updated Successfully!"+id);

        }catch(Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void deleteEmployee(int id) {

        con = DBConnection.createDBConnection();

        String query = "delete from employeedb.employee where id= ?";

        try{

            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1,id);
           int count = pstm.executeUpdate();

           if(count != 0)

               System.out.println("Employee Deleted Successfully!"+id);

        }catch(Exception ex){
            ex.printStackTrace();
        }

    }
}
