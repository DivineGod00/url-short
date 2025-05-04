package com.example.urlshortnering.dao;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.urlshortnering.model.UrlNoSQL;

@Repository
public interface NoSqlUrlRepo extends MongoRepository<UrlNoSQL,ObjectId>{

}
