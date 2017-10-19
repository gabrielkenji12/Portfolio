/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_lp3_projects.entities;

import java.io.Serializable;

/**
 *
 * @author BadJapa
 */
public class Departament implements Serializable{
    
    private String nameDepartament;
    private int departament_id;

    public Departament(String nameDepartament) {
        this.nameDepartament = nameDepartament;
    }

    public String getNameDepartament() {
        return nameDepartament;
    }

    public void setNameDepartament(String nameDepartament) {
        this.nameDepartament = nameDepartament;
    }

    public int getDepartament_id() {
        return departament_id;
    }

    public void setDepartament_id(int departament_id) {
        this.departament_id = departament_id;
    }

    @Override
    public String toString() {
        return "Departament - " + "Name = " + nameDepartament + " - ID = " + departament_id + "<br>";
    }
    
    
}
