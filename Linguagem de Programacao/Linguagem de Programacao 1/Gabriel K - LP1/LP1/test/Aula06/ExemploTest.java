/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula06;

import Aula04.Retangulo;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 41528387
 */
public class ExemploTest {
    @Test 
    public void construtorTest(){
        Retangulo r = new Retangulo(5,10,20,30);
        Assert.assertEquals(5,r.getX());
        
    }
    
    @Test
    public void areaTest(){
        Retangulo r = new Retangulo(5,10,20,30);
        Assert.assertEquals(600, r.Area());
    }
    
}

