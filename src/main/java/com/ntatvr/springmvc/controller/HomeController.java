package com.ntatvr.springmvc.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

  @RequestMapping(value = {"/home"}, method = RequestMethod.GET)
  public String homePage(Model model) {

    model.addAttribute("title", "Welcome to Spring MVC project of ntatvr");
    model.addAttribute("message", "This is home page!");
    return "home";

  }

  @RequestMapping(value = {"/", "/welcome**"}, method = RequestMethod.GET)
  public String welcomePage(Model model) {

    model.addAttribute("title", "Welcome to Spring MVC project of ntatvr");
    model.addAttribute("message", "This is welcome page!");
    return "index";

  }

  @RequestMapping(value = "/admin**", method = RequestMethod.GET)
  public String adminPage(Model model) {

    model.addAttribute("title", "Welcome to Spring MVC project of ntatvr");
    model.addAttribute("message", "This is protected page - Admin Page!");
    return "admin";

  }

  @RequestMapping(value = "/dba**", method = RequestMethod.GET)
  public String dbaPage(Model model) {

    model.addAttribute("title", "Welcome to Spring MVC project of ntatvr");
    model.addAttribute("message", "This is protected page - Database Page!");
    return "admin";

  }

  // Spring Security see this :
  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String login(Model model, @RequestParam(value = "error", required = false) String error,
      @RequestParam(value = "logout", required = false) String logout) {

    if (error != null) {
      model.addAttribute("error", "Invalid username and password!");
    }

    if (logout != null) {
      model.addAttribute("msg", "You've been logged out successfully.");
    }

    return "login";

  }

  // for 403 access denied page
  @RequestMapping(value = "/403", method = RequestMethod.GET)
  public String accesssDenied(Model model) {

    // check if user is login
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    if (!(auth instanceof AnonymousAuthenticationToken)) {
      UserDetails userDetail = (UserDetails) auth.getPrincipal();
      model.addAttribute("username", userDetail.getUsername());
    }

    return "error/403";

  }

}
