package com.example.bankapp.controller;

import com.example.bankapp.entities.ClientEntity;
import com.example.bankapp.service.impl.ClientServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
//@GetMapping("/")
//@RequestMapping(«/api/client)
//@RestController
//@RequiredArgsConstructor*/
public class ClientController {
    private final ClientService clientService;
    public List<ClientEntity> getAll(){
        return clientService.getAll();
    }
}
