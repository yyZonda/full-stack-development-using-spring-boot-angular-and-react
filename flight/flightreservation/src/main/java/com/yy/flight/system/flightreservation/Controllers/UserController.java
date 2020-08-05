package com.yy.flight.system.flightreservation.Controllers;


import com.yy.flight.system.flightreservation.entities.User;
import com.yy.flight.system.flightreservation.repos.UserRepository;
import com.yy.flight.system.flightreservation.service.SecurityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    private Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    SecurityService securityService;

    @RequestMapping("/showReg")
    public String showRegisterPage(){
        LOGGER.info("Inside showRegistrrationPage()");
        return "login/registerUser";
    }


    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    public String register(@ModelAttribute("user") User user){
        LOGGER.info("Inside register()"+user);
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
        return "login/login";
    }

    @RequestMapping("/showLogin")
    public String showLoginPage(){
        LOGGER.info("Inside showLoginPage()");
        return "login/login";
    }

    @RequestMapping(value ="/login",method = RequestMethod.POST)
    public String login( @RequestParam(value = "email") String email, @RequestParam(value = "password") String password,ModelMap modelMap){
        boolean LoginResponse = securityService.login(email,password);
        LOGGER.info("Inside login() and the email is "+email);
//        User user=userRepository.findByEmail(email);
        if(LoginResponse)
            return "findFlights";
        else
            modelMap.addAttribute("msg","Invalid user name or password. Please try again");
        return "login/login";
    }


}
