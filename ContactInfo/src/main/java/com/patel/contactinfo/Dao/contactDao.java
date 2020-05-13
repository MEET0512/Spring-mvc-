/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.patel.contactinfo.Dao;

import com.patel.contactinfo.model.Contact;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface contactDao {
    public int save (Contact contact);
    
    public int update (Contact contact);
    
    public Contact getContact(int id);
    
    public int delete(int id);
    
    public List<Contact> list();
}
