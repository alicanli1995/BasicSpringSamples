package com.mongodb.mongodbcrud.Controller;


import com.mongodb.mongodbcrud.Entity.MemberEntity;
import com.mongodb.mongodbcrud.Repo.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/members")
public class UserController {

    private final  UserDto userDto;

    @PostConstruct
    public void init(){
        MemberEntity memberEntity =new MemberEntity();
        memberEntity.setName("Ali");
        memberEntity.setLastName("CANLI");
        userDto.save(memberEntity);
    }

    @PostMapping
    public ResponseEntity<MemberEntity> saveMember(@RequestBody MemberEntity member){
        return ResponseEntity.ok(userDto.save(member));
    }

    @GetMapping
    public ResponseEntity<List<MemberEntity>> listAll(){
        return ResponseEntity.ok(userDto.findAll());
    }


}
