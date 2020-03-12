package com.todenterprises.wyaapp.services;

import java.util.List;
import java.util.Optional;
// import java.net.
//AIzaSyAWBPie0663q9_HbipF9dAJkd-_KVT0wYg

import com.todenterprises.wyaapp.database.OfficeMate;
import com.todenterprises.wyaapp.database.OfficeMateRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestServiceImpl implements RestService {

    @Autowired
    OfficeMateRepository repository;

    // GET METHODS
    @Override
    public List<OfficeMate> getUsers () {
        return repository.findAll();
    }

    @Override
    public Optional<OfficeMate> getUser (String id) {
        return repository.findById(id);
    }

    @Override
    public String getLocations (String location) {
        String uri = "https://maps.googleapis.com/maps/api/place/autocomplete/json?input=" + location + "&types=establishment&key=no api for you";
        
        RestTemplate restTemplate = new RestTemplate();
        
        String result = restTemplate.getForObject(uri, String.class);

        return result;
    }

    // POST METHODS
    @Override
    public OfficeMate postUser (OfficeMate officemate) {
        return repository.save(officemate);
    }

    // PUT METHODS
    @Override
    public OfficeMate updateUser (String id, OfficeMate newOfficemate) {
        
        newOfficemate.setId(id);
        
        return repository.save(newOfficemate);

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