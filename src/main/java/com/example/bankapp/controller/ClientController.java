package com.example.bankapp.controller;

import com.example.bankapp.entities.ClientEntity;
import com.example.bankapp.service.ClientService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/client")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;


    public List<ClientEntity> getAll(){
        return clientService.getAll();
    }
}
