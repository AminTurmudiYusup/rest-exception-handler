package com.example.demo.controller;

import com.example.demo.exception.ResourceAlreadyExistException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Departement;
import com.example.demo.repository.DepartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class DepartementController {

    @Autowired
    private DepartementRepository departementRepository;

    @GetMapping("/departements/{id}")
    public Departement getById(@PathVariable Long id){
        return departementRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Departement with id "+id+" Not Found"));
    }

    @PostMapping("/departement")
    Departement addNewDepartement(@RequestBody Departement departement){
        if (departementRepository.existsById(departement.getId()))
            throw new ResourceAlreadyExistException("Departement with id "+departement.getId()+" Already Exist");
        else
            departementRepository.save(departement);
        return departement;
    }
}
