package com.test.mongodb.springbootmongodbexample.resource;

import com.test.mongodb.springbootmongodbexample.document.Users;
import com.test.mongodb.springbootmongodbexample.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/users")
public class UsersResource {

    private UserRepository userRepository;

    public UsersResource(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/all")
    public List<Users> getAll() {
        return userRepository.findAll();
    }

       @GetMapping("/add")
    public Users addUser(@RequestParam(name = "name") String name, @RequestParam(name = "team") String team,@RequestParam(name = "salary") Long sal) {
        Users user = new Users();
        user.setName(name);
        user.setSalary(sal);
        user.setTeamName(team);
        userRepository.save(user);
        return  user;
    }

}
