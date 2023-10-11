/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventaris.dao;

import java.util.List;

/**
 *
 * @author admin
 */
public interface ImpDao {
    public void insert ();
    
    public void delete (String id);
    
    public void update (String id);
    
    public List<Object> getAll();
}
