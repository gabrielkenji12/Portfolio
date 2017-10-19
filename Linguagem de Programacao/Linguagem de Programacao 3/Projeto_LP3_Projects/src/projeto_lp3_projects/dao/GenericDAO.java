/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_lp3_projects.dao;

import java.util.List;

/**
 *
 * @author BadJapa
 */

public interface GenericDAO<E>{
    
    public boolean create(E e);
    
    public List<E> readAll();
    public E readById(int id);
    
    public boolean update(E e);
    public boolean delete(E e);
}