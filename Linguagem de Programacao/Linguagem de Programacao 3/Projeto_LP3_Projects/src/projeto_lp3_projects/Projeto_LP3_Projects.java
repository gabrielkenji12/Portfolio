/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_lp3_projects;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import projeto_lp3_projects.dao.DepartamentDAO;
import projeto_lp3_projects.dao.EmployeeDAO;
import projeto_lp3_projects.entities.Departament;
import projeto_lp3_projects.entities.Employee;

/**
 *
 * @author BadJapa
 */
public class Projeto_LP3_Projects {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        EmployeeDAO EmpDAO = new EmployeeDAO();
        DepartamentDAO DepDAO = new DepartamentDAO();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Departament d = new Departament("Vendas");
            DepDAO.create(d);
            
            
            Employee e = new Employee(1, "Gabriel", "Rua a ", "123456", "9 7588 4457", "gabriel@gmail.com", new java.sql.Date(format.parse("12/12/2017").getTime()));
            EmpDAO.create(e);

            System.out.println("----- READ BY ID ------");
            Employee readE = EmpDAO.readById(1);
            System.out.println(readE);

            System.out.println("----- READ BY NAME ------");
            Employee readNameE = EmpDAO.readByName("Gabriel");
            System.out.println(readNameE);

            System.out.println("----- UPDATE ------");
            Employee UpE = new Employee(1, "Kenji", "Rua a ", "123456", "9 7588 4457", "kenji@gmail.com", new java.sql.Date(format.parse("22/12/2017").getTime()));
            UpE.setEmployee_id(1);
            boolean resp = EmpDAO.update(UpE);
            System.out.println(resp);
            
            System.out.println("----- DELETE ------");
            boolean resp2 = EmpDAO.delete(UpE);
            System.out.println(resp2);
            
            
            System.out.println("DEPARTAMENT READ ALL");
            List<Departament> dep = DepDAO.readAll();
            for (Departament departament : dep) {
                System.out.println(departament);
            }
            
            System.out.println("DEPARTAMENT READ BY ID");
            Departament d1 = DepDAO.readById(1);
            System.out.println(d1);
            
            System.out.println("DEPARTAMENT UPDATE");
            Departament d2 = new Departament("TestUpdate");
            d2.setDepartament_id(2);
            boolean resp3 = DepDAO.update(d2);
            System.out.println(resp3);
            
            System.out.println("CREATE DEPARTAMENT");
            Departament d3 = new Departament("");
            boolean resp4 = DepDAO.create(d3);
            System.out.println(resp4);
        } catch (ParseException ex) {
            Logger.getLogger(Projeto_LP3_Projects.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
