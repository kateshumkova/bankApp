package com.example.bankapp.service.impl;

import com.example.bankapp.entities.ClientEntity;
import com.example.bankapp.repository.ClientRepository;
import com.example.bankapp.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
//@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    @Override
    public List<ClientEntity> getAll() {
      return clientRepository.findAll();
    }

}
