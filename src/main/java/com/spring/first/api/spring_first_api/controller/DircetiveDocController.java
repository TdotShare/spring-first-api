package com.spring.first.api.spring_first_api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.first.api.spring_first_api.model.DirectiveDoc;
import com.spring.first.api.spring_first_api.service.DirectiveDocService;


@RestController
@RequestMapping("dircetiveDoc")
public class DircetiveDocController {

    private final DirectiveDocService directiveDocService;

    public DircetiveDocController(DirectiveDocService directiveDocService) {
        this.directiveDocService = directiveDocService;
    }

    @GetMapping("/getDirectiveDocAll")
    public List<DirectiveDoc> getDirectiveDocAll(){
        return directiveDocService.getDirectiveDocAll();
    }

}
