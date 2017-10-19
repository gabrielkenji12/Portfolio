/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.projeto.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class DepartamentController extends AbstractController {

    @Override
    public void execute() {
        String command = request.getParameter("control").split("\\.")[1].toUpperCase();
        switch (command) {
            case "REGISTER":
                register();
                break;
            case "UPDATE":
                update();
                break;
            case "DELETE":
                delete();
                break;
        }
    }

    private void register() {
        try {
            String name = request.getParameter("name");
            if (!name.isEmpty()) {
                DepartamentDAO dao = new DepartamentDAO();
                Departament d = new Departament(name);
                dao.create(d);
                request.getSession().setAttribute("resultCreate", "Departamento Registrado com sucesso <br>");
                returnPage = "registerDepartament.jsp";
            } else {
                request.getSession().setAttribute("resultCreate", "Erro ao Registrar Departamento <br>");
                returnPage = "registerDepartament.jsp";
            }
        } catch (NullPointerException | NumberFormatException ex) {
            request.getSession().setAttribute("resultCreate", "Erro ao Registrar Departamento <br>");
            returnPage = "registerDepartament.jsp";

        }
    }

    private void update() {
        try {
            int id = Integer.parseInt(request.getParameter("search"));
            DepartamentDAO dao = new DepartamentDAO();
            Departament d = dao.readById(id);
            if (d != null) {
                String name = request.getParameter("name");

                if (!name.isEmpty()) {
                    d.setNameDepartament(name);
                }

                boolean resp = dao.update(d);
                if (resp == true) {
                    request.getSession().setAttribute("resultUpdate", "Departamento Atualizado com sucesso");
                } else {
                    request.getSession().setAttribute("resultUpdate", "Erro ao Atualizar Departamento");
                }
            } else {
                request.getSession().setAttribute("resultUpdate", "ID não existe");
            }
            returnPage = "updateDepartament.jsp";
        } catch (NullPointerException | NumberFormatException ex) {
            returnPage = "updateDepartament.jsp";
            request.getSession().setAttribute("resultUpdate", "Dados Invalidos");
        }
    }

    private void delete() {
        try {
            int id = Integer.parseInt(request.getParameter("search"));
            DepartamentDAO dao = new DepartamentDAO();
            Departament d = dao.readById(id);
            if (d != null) {
                String name = d.getNameDepartament();
                boolean resp = dao.delete(d);
                if (resp == true) {
                    request.getSession().setAttribute("resultDelete", "Departamento " + name + ", Excluido com sucesso");
                } else {
                    request.getSession().setAttribute("resultDelete", "Erro ao Excluir Departamento" + name + " ");
                }
            } else {
                request.getSession().setAttribute("resultDelete", "ID não existe");
            }
            returnPage = "deleteDepartament.jsp";
        } catch (NullPointerException | NumberFormatException ex) {
            returnPage = "deleteDepartament.jsp";
            request.getSession().setAttribute("resultDelete", "ID não existe");
        }
    }

}
