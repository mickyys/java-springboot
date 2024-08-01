package cl.hamp.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.hamp.curso.springboot.webapp.springboot_web.models.User;
import cl.hamp.curso.springboot.webapp.springboot_web.models.dto.UserDto;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @GetMapping("/details")
    public UserDto details(Model model){

        User user = new User("Hector","Martinez");

        UserDto userDto = new UserDto();
        userDto.setTitle("Hola Mundo");
        userDto.setUser(user);
        // Map<String, Object> body = new HashMap<>();

        // body.put("title", "Hola Mundo");
        // body.put("user", user);
        // body.put("name", "Hector");
        // body.put("lastName", "Martinez");
        
        return userDto;
    }

}
