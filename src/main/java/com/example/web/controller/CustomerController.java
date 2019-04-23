package com.example.web.controller;

import com.example.entity.MstEmployee;
import com.example.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    private final CustomerService customerService;
    private final Environment environment;

    public CustomerController(CustomerService customerService, Environment environment) {
        this.customerService = customerService;
        this.environment = environment;
    }

    @GetMapping("/")
    public String index(Model model) {

        List<MstEmployee> mstEmployees = customerService.selectAll();

        logger.info("---------------- test ------------");

        Arrays.stream(environment.getActiveProfiles()).forEach(proc -> logger.info(proc));

        logger.info(mstEmployees.get(0).getEmployeeFirstName());


        return "index";
    }
}
