/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab02;

/**
 *
 * @author 41528387
 */
public class Virtual extends Endereco{
    
    private String site;
    private String email;

    public Virtual(String site, String email) {
        this.site = site;
        this.email = email;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Virtual{" + "site=" + site + ", email=" + email + '}';
    }
    
    
    
    
    
    
}
