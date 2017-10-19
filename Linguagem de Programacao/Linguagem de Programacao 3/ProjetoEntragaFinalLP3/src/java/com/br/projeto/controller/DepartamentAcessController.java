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
 * @author BadJapa
 */
public class DepartamentAcessController extends AbstractController {

    @Override
    public void execute() {
        String access = request.getParameter("controladorAcesso");
        switch (access) {
            case "1":
                returnPage = "registerDepartament.jsp";
                break;
            case "2":
                returnPage = "readAllDepartament.jsp";
                DepartamentDAO depDao = new DepartamentDAO();
                List<Departament> departaments = new ArrayList<>();
                departaments = depDao.readAll();
                request.getSession().setAttribute("departaments", departaments);
                break;
            case "3":
                returnPage = "updateDepartament.jsp";
                break;
            case "4":
                returnPage = "deleteDepartament.jsp";
                break;
            default:
                returnPage = "errorAccess.jsp";
                break;
        }
    }
}
