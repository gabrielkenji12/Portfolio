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
import projeto_lp3_projects.entities.Departament;
import projeto_lp3_projects.entities.Employee;

/**
 *
 * @author BadJapa
 */
public class DepartamentDAO implements GenericDAO<Departament> {

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
    public boolean create(Departament d) {

        boolean resp = false;

        //PASSO 1 - estabelecer a conexão
        Connection conn = getConnection();

        //PASSO 2 - Preparar a consulta(statement)
        String sql = "INSERT INTO departament(nameDepartament) VALUES (?);";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, d.getNameDepartament());

            //PASSO 3 - Executa a query
            int cont = pst.executeUpdate();

            //PASSO 4 - Tratar os resultados
            resp = (cont > 0) ? true : false;

            //PASSO 5 - Fechar a conexão
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(DepartamentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;

    }

    @Override
    public List<Departament> readAll() {
        List<Departament> departaments = new ArrayList<>();

        //Passo 1
        Connection conn = getConnection();

        //Passo 2
        String sql = "SELECT * FROM departament;";
        try {
            Statement stm = conn.createStatement();

            //Passo 3
            ResultSet rs = stm.executeQuery(sql);

            //Passo 4
            while (rs.next()) {
                String name = rs.getString("nameDepartament");
                int id = rs.getInt("departament_id");

                Departament d = new Departament(name);
                d.setDepartament_id(id);
                departaments.add(d);
            }

            //Passo 5
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(DepartamentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return departaments;
    }

    @Override
    public Departament readById(int id) {
        Departament d = null;
        Connection conn = getConnection();

        String sql = "SELECT * FROM departament WHERE departament_id=?;";

        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String name = rs.getString("nameDepartament");
                int id2 = rs.getInt("departament_id");

                d = new Departament(name);
                d.setDepartament_id(id2);
            }

            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(DepartamentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return d;

    }

    @Override
    public boolean update(Departament departament) {
        boolean resp = false;
        //PASSO 1 
        Connection conn = getConnection();

        //PASSO 2
        String sql = "UPDATE departament SET nameDepartament=? WHERE departament_id=?;";

        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, departament.getNameDepartament());
            pst.setInt(2, departament.getDepartament_id());

            //PASSO 3
            int cont = pst.executeUpdate();

            //PASSO 4 
            resp = (cont > 0) ? true : false;

            //PASSO 5
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(DepartamentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }

    @Override
    public boolean delete(Departament departament) {
        boolean resp = false;

        //1
        Connection conn = getConnection();

        //2
        String sql = "DELETE FROM departament WHERE departament_id=?";

        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, departament.getDepartament_id());

            //3
            int cont = pst.executeUpdate();

            //4
            resp = (cont > 0) ? true : false;

            //5
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resp;
    }
}
