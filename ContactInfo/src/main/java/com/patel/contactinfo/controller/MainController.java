
package com.patel.contactinfo.controller;

import com.patel.contactinfo.Dao.contactDao;
import com.patel.contactinfo.Dao.contactDaoImp;
import com.patel.contactinfo.model.Contact;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author DELL
 */
@Controller
public class MainController {
    @Autowired
    private contactDao contactDao;
    
    @RequestMapping(value = "/")
    public ModelAndView listContact(ModelAndView model){
        //ModelAndView model = new ModelAndView();
        //contactDao = new contactDaoImp();
        List<Contact> contactlist = contactDao.list();
        
        model.addObject("contacts",contactlist);
        model.addObject("m", "meet");
        model.setViewName("index");
        return model;
    }
    
    @RequestMapping("/new")
    public ModelAndView addContact(ModelAndView model){
        Contact newcontact = new Contact();
        model.addObject("contact", newcontact);
        model.setViewName("contact_form");
        return model;
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView saveContact(@ModelAttribute Contact contact){
        if(contact.getId() == null){
            contactDao.save(contact);
        } else {
            contactDao.update(contact);
        }
        
        return new ModelAndView("redirect:/");
    }
    
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest req){
        int id = Integer.parseInt(req.getParameter("id"));
        Contact contact = contactDao.getContact(id);
        ModelAndView model = new ModelAndView();
        model.addObject("contact", contact);
        model.setViewName("contact_form");
        return model;
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView deleteContact(@RequestParam int id){
        contactDao.delete(id);
        return new ModelAndView("redirect:/");
    }
}
