package cl.hamp.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.RestController;

import cl.hamp.curso.springboot.webapp.springboot_web.models.dto.ParamDTO;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("api/params")
public class RequestParamsController {

    @GetMapping("/foo")
    public ParamDTO foo(@RequestParam(required = false, defaultValue = "Hola mundo") String message) {
        ParamDTO paramDTO = new ParamDTO();
        paramDTO.setMessage(message);;
        return paramDTO;
    }
    
}
