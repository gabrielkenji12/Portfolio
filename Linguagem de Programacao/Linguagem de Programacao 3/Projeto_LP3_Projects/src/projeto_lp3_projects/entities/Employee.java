/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_lp3_projects.entities;

import java.io.Serializable;
import java.sql.Date;


/**
 *
 * @author BadJapa
 */
public class Employee implements Serializable{
    
    private int employee_id,departament_fk;
    private String nameEmployee, adress, cpf, tel, email;
    private Date birthday;

    public Employee(int departament_fk, String nameEmployee, String adress, String cpf, String tel, String email, Date birthday) {
        this.departament_fk = departament_fk;
        this.nameEmployee = nameEmployee;
        this.adress = adress;
        this.cpf = cpf;
        this.tel = tel;
        this.email = email;
        this.birthday = birthday;
    }

    


    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setDepartament_fk(int departament_fk) {
        this.departament_fk = departament_fk;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }
    

    public String getCpf() {
        return cpf;
    }

    public Date getBirthday() {
        return birthday;
    }

    public int getDepartament_fk() {
        return departament_fk;
    }

    @Override
    public String toString() {
        return "Employee - " + "id = " + employee_id + ", departament = " + departament_fk + ", name = " + nameEmployee + ", adress = " + adress + ", cpf = " + cpf + ", tel = " + tel + ", email = " + email + ", birthday = " + birthday + "<br>";
    }

    
    
}
