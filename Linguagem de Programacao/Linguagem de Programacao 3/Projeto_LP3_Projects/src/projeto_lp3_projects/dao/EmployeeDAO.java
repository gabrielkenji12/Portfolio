/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_lp3_projects.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import projeto_lp3_projects.entities.Employee;

/**
 *
 * @author BadJapa
 */
public class EmployeeDAO implements GenericDAO<Employee>{

    
    private String uri = "jdbc:mysql://localhost:3306/projetolp3?zeroDateTimeBehavior=convertToNull";
    private String user = "root";
    private String pwd = "";

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            return DriverManager.getConnection(uri, user, pwd);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean create(Employee e) {

        boolean resp = false;

        //PASSO 1 - estabelecer a conexão
        Connection conn = getConnection();

        //PASSO 2 - Preparar a consulta(statement)
        String sql = "INSERT INTO employee(nameEmployee,adress,cpf,tel,email,birthday,departament_fk) VALUES (?, ?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, e.getNameEmployee());
            pst.setString(2, e.getAdress());
            pst.setString(3, e.getCpf());
            pst.setString(4, e.getTel());
            pst.setString(5, e.getEmail());
            pst.setDate(6, e.getBirthday());
            pst.setInt(7, e.getDepartament_fk());

            //PASSO 3 - Executa a query
            int cont = pst.executeUpdate();

            //PASSO 4 - Tratar os resultados
            resp = (cont > 0) ? true : false;

            //PASSO 5 - Fechar a conexão
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;

    }

    @Override
    public List<Employee> readAll() {
        List<Employee> employeers = new ArrayList<>();

        //Passo 1
        Connection conn = getConnection();

        //Passo 2
        String sql = "SELECT * FROM employee;";
        try {
            Statement stm = conn.createStatement();

            //Passo 3
            ResultSet rs = stm.executeQuery(sql);

            //Passo 4
            while (rs.next()) {
                String name = rs.getString("nameEmployee");
                String adress = rs.getString("adress");
                String cpf = rs.getString("cpf");
                String tel = rs.getString("tel");
                String email = rs.getString("email");
                Date birthday = rs.getDate("birthday");
                int id = rs.getInt("employee_id");
                int fk = rs.getInt("departament_fk");

                Employee e = new Employee(fk, name, adress, cpf, tel, email, birthday);
                e.setEmployee_id(id);
                employeers.add(e);
            }

            //Passo 5
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return employeers;
    }

    @Override
    public Employee readById(int id) {
        Employee e = null;
        Connection conn = getConnection();

        String sql = "SELECT * FROM employee WHERE employee_id=?;";

        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);

            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                String name = rs.getString("nameEmployee");
                String adress = rs.getString("adress");
                String cpf = rs.getString("cpf");
                String tel = rs.getString("tel");
                String email = rs.getString("email");
                Date birthday = rs.getDate("birthday");
                int id2 = rs.getInt("employee_id");
                int fk = rs.getInt("departament_fk");

                e = new Employee(fk, name, adress, cpf, tel, email, birthday);
                e.setEmployee_id(id2);
            }
            
            
            conn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return e;

    }
    
    
    public Employee readByName(String user) {
        Employee e = null;
        Connection conn = getConnection();

        String sql = "SELECT * FROM employee WHERE nameEmployee=?;";

        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, user);

            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                String name = rs.getString("nameEmployee");
                String adress = rs.getString("adress");
                String cpf = rs.getString("cpf");
                String tel = rs.getString("tel");
                String email = rs.getString("email");
                Date birthday = rs.getDate("birthday");
                int id2 = rs.getInt("employee_id");
                int fk = rs.getInt("departament_fk");

                e = new Employee(fk, name, adress, cpf, tel, email, birthday);
                e.setEmployee_id(id2);
            }
            
            
            conn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return e;

    }

    @Override
    public boolean update(Employee employee) {
        boolean resp = false;
        //PASSO 1 
        Connection conn = getConnection();

        //PASSO 2
        String sql = "UPDATE employee SET nameEmployee=?, adress=?, tel=?, email=?, departament_fk=? WHERE employee_id=?;";

        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, employee.getNameEmployee());
            pst.setString(2, employee.getAdress());
            pst.setString(3, employee.getTel());
            pst.setString(4, employee.getEmail());
            pst.setInt(5, employee.getDepartament_fk());
            pst.setInt(6, employee.getEmployee_id());

            //PASSO 3
            int cont = pst.executeUpdate();

            //PASSO 4 
            resp = (cont > 0) ? true : false;

            //PASSO 5
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }

    @Override
    public boolean delete(Employee employee) {
        boolean resp = false;

        //1
        Connection conn = getConnection();

        //2
        String sql = "DELETE FROM employee WHERE employee_id=?";

        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, employee.getEmployee_id());

            //3
            int cont = pst.executeUpdate();

            //4
            resp = (cont > 0) ? true : false;

            //5
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resp;
    }
}
