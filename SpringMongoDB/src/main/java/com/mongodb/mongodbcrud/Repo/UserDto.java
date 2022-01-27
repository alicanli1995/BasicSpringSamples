package com.mongodb.mongodbcrud.Repo;

import com.mongodb.mongodbcrud.Entity.MemberEntity;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserDto extends MongoRepository<MemberEntity,String> {
}
