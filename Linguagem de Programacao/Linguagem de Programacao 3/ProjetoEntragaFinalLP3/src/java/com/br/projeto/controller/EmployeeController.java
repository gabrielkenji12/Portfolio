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
import projeto_lp3_projects.dao.EmployeeDAO;
import projeto_lp3_projects.entities.Employee;

/**
 *
 * @author 41528387
 */
public class EmployeeController extends AbstractController {

    @Override
    public void execute() {
        String command = request.getParameter("control").split("\\.")[1].toUpperCase();
        switch (command) {
            case "REGISTER":
                try {
                    register();
                } catch (ParseException ex) {
                    Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
                }

                break;
            case "READBYID":
                readById();
                break;
            case "UPDATE":
                update();
                break;
            case "DELETE":
                delete();
                break;
        }
    }

    private void register() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date birth;
        try {
            String name = request.getParameter("name");
            String adress = request.getParameter("adress");
            String cpf = request.getParameter("cpf");
            String tel = request.getParameter("tel");
            String email = request.getParameter("email");
            String birthday = request.getParameter("birthday");
            int departament = Integer.parseInt(request.getParameter("departament"));
            try {
                birth = new java.sql.Date(format.parse(birthday).getTime());
            } catch (ParseException ex) {
                request.getSession().setAttribute("resultBirthday", "Erro ao inserir Nascimento, favor alterar depois");
                birth = new java.sql.Date(format.parse("01/01/2017").getTime());
            }
            EmployeeDAO dao = new EmployeeDAO();
            Employee e = new Employee(departament, name, adress, cpf, tel, email, birth);
            dao.create(e);
            request.getSession().setAttribute("resultCreate", "Funcionario Registrado com sucesso <br>");
            returnPage = "registerEmployee.jsp";
        } catch (NullPointerException | NumberFormatException ex) {
            request.getSession().setAttribute("resultCreate", "Erro ao Registrar Funcionario <br>");
            returnPage = "registerEmployee.jsp";

        }
    }

    private void readById() {
        try {
            int id = Integer.parseInt(request.getParameter("searchID"));
            EmployeeDAO dao = new EmployeeDAO();
            Employee e = dao.readById(id);
            if (e != null) {
                request.getSession().setAttribute("employee", e);
            } else {
                request.getSession().setAttribute("employee", "ID não existe");
            }
            returnPage = "readByIdEmployee.jsp";
        } catch (NullPointerException | NumberFormatException ex) {
            returnPage = "readByIdEmployee.jsp";
            request.getSession().setAttribute("employee", "Dados Incorretos");
        }
    }

    private void update() {
        try {
            int id = Integer.parseInt(request.getParameter("search"));
            EmployeeDAO dao = new EmployeeDAO();
            Employee e = dao.readById(id);
            if (e != null) {
                String name = request.getParameter("name");
                String adress = request.getParameter("adress");
                String tel = request.getParameter("tel");
                String email = request.getParameter("email");
                String dep = request.getParameter("departament");

                if (!name.isEmpty()) {
                    e.setNameEmployee(name);
                }
                if (!adress.isEmpty()) {
                    e.setAdress(adress);
                }
                if (!tel.isEmpty()) {
                    e.setTel(tel);
                }
                if (!email.isEmpty()) {
                    e.setEmail(email);
                }
                if (!dep.isEmpty()) {
                    int departament = Integer.parseInt(request.getParameter("departament"));
                    e.setDepartament_fk(departament);
                }

                boolean resp = dao.update(e);
                if (resp == true) {
                    request.getSession().setAttribute("resultUpdate", "Funcionario Atualizado com sucesso");
                } else {
                    request.getSession().setAttribute("resultUpdate", "Erro ao Atualizar Funcionario");
                }
            } else {
                request.getSession().setAttribute("resultUpdate", "ID não existe");
            }
            returnPage = "updateEmployee.jsp";
        } catch (NullPointerException | NumberFormatException ex) {
            returnPage = "updateEmployee.jsp";
            request.getSession().setAttribute("resultUpdate", "Dados Invalidos");
        }
    }

    private void delete() {
        try {
            int id = Integer.parseInt(request.getParameter("search"));
            EmployeeDAO dao = new EmployeeDAO();
            Employee e = dao.readById(id);
            if (e != null) {
                String name = e.getNameEmployee();
                boolean resp = dao.delete(e);
                if (resp == true) {
                    request.getSession().setAttribute("resultDelete", "Funcionario " + name + ", Excluido com sucesso");
                } else {
                    request.getSession().setAttribute("resultDelete", "Erro ao Excluir Funcionario" + name + " ");
                }
            } else {
                request.getSession().setAttribute("resultDelete", "ID não existe");
            }
            returnPage = "deleteEmployee.jsp";
        } catch (NullPointerException | NumberFormatException ex) {
            returnPage = "deleteEmployee.jsp";
            request.getSession().setAttribute("resultDelete", "ID não existe");
        }
    }

}
