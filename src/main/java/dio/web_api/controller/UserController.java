package dio.web_api.controller;

import dio.web_api.model.User;
import dio.web_api.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping()
    public List<User> getUsers(){
        return userRepository.findAll();
    }
    @GetMapping("/login/{login}")
    public User getByLogin(@PathVariable("login") String login){
        return userRepository.findByLogin(login);
    }
    @GetMapping("/username/{username}")
    public User getByUsername(@PathVariable("username") String username){
        return userRepository.findByUsername(username);
    }
    @GetMapping("/id/{id}")
    public User getUserById(@PathVariable("id") Integer id) {
        return userRepository.findById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable ("id") Integer id){
        userRepository.deleteById(id);
    }
    @PostMapping("/batch")
    public List<User> postUsers(@RequestBody List<User> users) {
        List<User> savedUsers = new ArrayList<>();
        for (User user : users) {
            userRepository.save(user);
            savedUsers.add(user);
        }
        return savedUsers;
    }
    @PutMapping("/{id}")
    public void putUser(@PathVariable("id") Integer id, @RequestBody User user) {
        user.setId(id);
        userRepository.save(user);
    }
}
