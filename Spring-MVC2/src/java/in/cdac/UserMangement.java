/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package in.cdac;

import in.cdac.db.DBOperations;
import in.cdac.db.UserLoginInfo;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author CDAC
 */
@Controller
public class UserMangement {
    
    @Autowired
    DBOperations dbops;
    
    
    @RequestMapping("/userlogin")
    public String showLoginPage(){
        return "login";
    }
    
    @RequestMapping(value="/userauthentication", method = RequestMethod.POST)
    public String verifyUser(HttpServletRequest req, Model m){
        String username = req.getParameter("username");
        String pwd = req.getParameter("password");
        
//        if(username.equals("abc")){ //verified with DB
//            m.addAttribute("msg", "Hi.."+username);
//            return "welcome";
//        }       

        if(dbops.verifyUserDetails(username, pwd)){
            m.addAttribute("msg", "Hi.."+username);
            return "welcome";
        }
        m.addAttribute("msg", "Invalid User Details");
        return "invaliddetails";
    }
    
//    @RequestMapping(value="/register")
//    public String showRegistrationPage(){
//        return "register";
//    }
//    
//    @RequestMapping(value="/userregistration", method = RequestMethod.POST)
//    public String saveUser(@RequestParam("username") String username, 
//            @RequestParam("password") String password, Model m){
//        System.out.println(username+"=="+password);
//        m.addAttribute("msg", "Registation is successful");
//        return "success";
//    }
    
    @RequestMapping(value="/register")
    public String showRegistrationPage(Model m){
//        UserLoginInfo ul = new UserLoginInfo();
//        ul.setUsername("Enter username");
//        ul.setPassword("Enter Password");
        
        m.addAttribute("command", new UserLoginInfo());
        return "register";
    }
    
    @RequestMapping(value="/userregistration", method = RequestMethod.POST)
    public String saveUser(Model m, BindingResult br)
    {              
        UserLoginInfo ulinfo = (UserLoginInfo) m.getAttribute("command");
        String status = dbops.saveUserDetails(ulinfo);
        if(status.equals("success")){
            m.addAttribute("msg", "Registered successfully");                
            return "success";
        }else if(status.equals("exits")){            
            m.addAttribute("msg", "You are already registered withus. Please login");
            return "login";
        } else {
            m.addAttribute("command", new UserLoginInfo());
            m.addAttribute("msg", "Unable to save you details. Please contact your admin");                
        }
        return "register";
    } 
    
    
}
