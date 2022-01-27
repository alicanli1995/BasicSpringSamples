package com.flyway.springflyway.dto;

import com.flyway.springflyway.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDto extends JpaRepository<User,Long> {
}
