package com.todenterprises.wyaapp.services;

import java.util.List;
import java.util.Optional;

import com.todenterprises.wyaapp.database.OfficeMate;
import com.todenterprises.wyaapp.database.OfficeMateRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestServiceImpl implements RestService {

    @Autowired
    private OfficeMateRepository repository;

    // GET METHODS
    @Override
    public List<OfficeMate> getUsers () {
        return repository.findAll();
    }

    @Override
    public Optional<OfficeMate> getUser (String id) {
        return repository.findById(id);
    }

    // POST METHODS
    @Override
    public OfficeMate postUser (OfficeMate officemate) {
        return repository.save(officemate);
    }

    // PUT METHODS
    @Override
    public OfficeMate updateUser (String id, OfficeMate newOfficemate) {
        
        return repository.findById(id)
                .map (officemate -> {
                    officemate.setStatus(newOfficemate.getStatus());
                    officemate.setLocation(newOfficemate.getLocation());

                    return repository.save(officemate);
                })
                .orElseGet(() -> {
                    newOfficemate.setId(id);

                    return repository.save(newOfficemate);
                });

    }

    // DELETE METHODS
    @Override
    public void deleteUserByName (String name) {
        List <OfficeMate> users = repository.findAll ();

        users.forEach (officemate -> {
           
            if (officemate.getName ().replaceAll ("\\s", "").equals (name)) repository.deleteById (officemate.getId ());
            
        });

    }

    @Override
    public void deleteUser (String id) {
        repository.deleteById(id);
    }

}