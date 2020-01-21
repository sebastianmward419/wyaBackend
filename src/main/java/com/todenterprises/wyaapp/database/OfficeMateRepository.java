package com.todenterprises.wyaapp.database;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface OfficeMateRepository extends MongoRepository <OfficeMate, String> {
    public List <OfficeMate> findAll ();
} 