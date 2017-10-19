/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.projeto.controller;

import java.util.ArrayList;
import java.util.List;
import projeto_lp3_projects.dao.DepartamentDAO;
import projeto_lp3_projects.dao.EmployeeDAO;
import projeto_lp3_projects.entities.Departament;
import projeto_lp3_projects.entities.Employee;

/**
 *
 * @author 41528387
 */
public class EmployeeAcessController extends AbstractController{

    @Override
    public void execute() {
        String access = request.getParameter("controladorAcesso");
        switch(access){
            case "1":
                returnPage = "registerEmployee.jsp";
                DepartamentDAO dao = new DepartamentDAO();
                List<Departament> departaments = new ArrayList<>();
                departaments = dao.readAll();
                request.getSession().setAttribute("departaments", departaments);
                break;
            case "2":
                returnPage = "readAllEmployee.jsp";
                EmployeeDAO Edao = new EmployeeDAO();
                List<Employee> employees = new ArrayList<>();
                employees = Edao.readAll();
                request.getSession().setAttribute("employees", employees);
                break;
            case "3":
                returnPage = "readByIdEmployee.jsp";
                break;
            case "4":
                returnPage = "updateEmployee.jsp";
                break;
            case "5":
                returnPage = "deleteEmployee.jsp";
                break;
            default:
                returnPage = "errorAccess.jsp";
                break;
        }
    }
    
}
