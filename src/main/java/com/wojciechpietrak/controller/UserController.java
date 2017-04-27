package com.wojciechpietrak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wojciechpietrak.model.User;
import com.wojciechpietrak.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String getUsers(Model model) {
		model.addAttribute("user", userService.findAll());
				
		return "user";
	}
	@RequestMapping(value = "/user/create", method = RequestMethod.GET)
    public String getUserCreateView() {
        return "user-create";
    }

    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public String createUser(@ModelAttribute User user) {

//        String firstName = request.getParameter("firstName");
//        String lastName = request.getParameter("lastName");
//        String email = request.getParameter("email");

//        User user = new User();
//        user.setFirstName(firstNameController);
//        user.setLastName(lastName);
//        user.setEmail(email);

        userService.save(user);

        return "redirect:/user";
    }
/*
    @RequestMapping(value = "/user/update/{id}", method = RequestMethod.GET)
    public String getUpdateUserView(@PathVariable Long id, Model model) {

        User user = userRepository.findOne(id);
        model.addAttribute("user", user);

        return "user-update";
    }

    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    public String getUpdateUserView(@ModelAttribute User user) {

        userRepository.save(user);

        return "redirect:/admin/users";
    }

    @RequestMapping(value = "/user/delete", method = RequestMethod.POST)
    public String deleteUser(@RequestParam Long id) {

        userRepository.delete(id);

        return "redirect:/admin/users";
    }*/
    
}
