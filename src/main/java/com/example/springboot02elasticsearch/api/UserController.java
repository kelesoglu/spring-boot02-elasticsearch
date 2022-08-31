package com.example.springboot02elasticsearch.api;

import com.example.springboot02elasticsearch.entity.User;
import com.example.springboot02elasticsearch.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/user/")
@RestController
public class UserController {
    @Autowired
    private final UserRepository userRepository;

    @PostConstruct
    public void init() {
        User user = new User();
        user.setName("Ali");
        user.setSurName("Keles");
        user.setAddress("adres1");
        user.setBirthday(Calendar.getInstance().getTime());
        user.setId("K0001");

        User user2 = new User();
        user2.setName("Ali");
        user2.setSurName("Gel");
        user2.setAddress("adres2");
        user2.setBirthday(Calendar.getInstance().getTime());
        user2.setId("K0002");

        userRepository.save(user);
        userRepository.save(user2);
    }
    @GetMapping("{search}")
    public ResponseEntity<List<User>> getUsers(@PathVariable String search){
        return ResponseEntity.ok(this.userRepository.getByCustomQuery(search));
    }

//    @GetMapping("{search}")
//    public ResponseEntity<List<User>> getUsers(@PathVariable String search){
//        return ResponseEntity.ok(this.userRepository.findByNameLikeOrSurNameLike(search, search));
//    }
}

