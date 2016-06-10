package hello.controllers;

import hello.dao.UserDao;
import hello.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class GreetingController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/greeting")
    public String greeging(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
        List<User> users = userDao.getAll();
        model.addAttribute("name", users.get(0).getEmail());
        return "greeting";
    }

}
