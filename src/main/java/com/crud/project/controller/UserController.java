package com.crud.project.controller;

import com.crud.project.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.crud.project.service.UserService;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    private static final int USER_PER_PAGE = 10;

    @RequestMapping("createUser")
    public ModelAndView createUser(@ModelAttribute User user) {
        return new ModelAndView("userForm");
    }

    @RequestMapping("editUser")
    public ModelAndView editUser(@RequestParam int id, @ModelAttribute User user) {
        user = userService.getUser(id);
        return new ModelAndView("userForm", "userObject", user);
    }

    @RequestMapping("saveUser")
    public ModelAndView saveUser(@ModelAttribute User user) {
        if(user.getId() == 0){ // if user id is 0 then creating user other updating user
            userService.createUser(user);
        } else {
            userService.updateUser(user);
        }
        return new ModelAndView("redirect:/");
    }

    @RequestMapping("deleteUser")
    public ModelAndView deleteUser(@RequestParam int id)
    {
        userService.deleteUser(id);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = {"getAllUsers"})
    public ModelAndView getAllUsers(){
        List<User> userList = userService.getAllUsers();
        return new ModelAndView("userList", "userList", userList);
    }

    @RequestMapping("searchUser")
    public ModelAndView searchUser(@RequestParam("name") String name){
        List<User> usersList = userService.getUsersByName(name);
        return new ModelAndView("userList", "userList", usersList);
    }

    @RequestMapping(value="/")
    public ModelAndView listOfUsers(@RequestParam(required = false) Integer page) {
        ModelAndView modelAndView = new ModelAndView("userList");

        List<User> users = userService.getAllUsers();
        PagedListHolder<User> pagedListHolder = new PagedListHolder<User>(users);
        pagedListHolder.setPageSize(USER_PER_PAGE);
        modelAndView.addObject("maxPages", pagedListHolder.getPageCount());

        if(page == null || page < 1 || page > pagedListHolder.getPageCount()){
            page=1;
        }
        modelAndView.addObject("page", page);
        if(page == null || page < 1 || page > pagedListHolder.getPageCount()){
            pagedListHolder.setPage(0);
            modelAndView.addObject("userList", pagedListHolder.getPageList());
        }
        else if(page <= pagedListHolder.getPageCount()) {
            pagedListHolder.setPage(page-1);
            modelAndView.addObject("userList", pagedListHolder.getPageList());
        }
        return modelAndView;
    }


}
