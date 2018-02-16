package sk.sovy.emp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MySQL {
    private Connection conn;
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/employees";
    private String userName = "root";
    private String password = "";

    public List<String> getEmployees(){
        List<String> list = new ArrayList<>();
        try{
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url, userName, password);
            String query = "SELECT last_name from employees";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String name = rs.getString("last_name");
                list.add(name);
            }
        }
        catch(Exception ex){
            System.out.println("Error");
        }

        return list;
    }


    public String getSalary(String name) {
        String result = "";
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url, userName, password);
            String query = "select salary from salaries inner join employees" +
                    " on salaries.emp_no = employees.emp_no where last_name = '" + name + "'";
            System.out.println(query);
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result = rs.getString("salary");
                System.out.println(result);
            }

        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }


        return result;
    }
}
