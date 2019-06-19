package edu.mum.cs544.service;

import edu.mum.cs544.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private RestTemplate restTemplate;

    private final String allUsersUrl = "http://localhost:8888/api/users";
    private final String userUrl = "http://localhost:8888/api/user/{id}";
    private final String loggedInUser = "http://localhost:8888/api/user/login/{username}/{password}";
    private final String registeringUserUrl = "http://localhost:8888/api/user";

    public User get(Integer id) {
        return restTemplate.getForObject(userUrl, User.class, id);
    }

    // all users
    public List<User> getAll() {
        ResponseEntity<List<User>> responseEntity =
                restTemplate.exchange(allUsersUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {
                });
        return responseEntity.getBody();
    }

    public User registerUser(User user){
        HttpEntity<User> request = new HttpEntity<>(user);
        User registerdUser = restTemplate.postForObject(registeringUserUrl, request, User.class);
        //assertThat(registerdUser, notNullValue());
        return registerdUser;
    }

    public User userLogIn(String username, String password){
        return restTemplate.getForObject(loggedInUser, User.class, username,password);
    }

    public void update(User user) {
        restTemplate.put(userUrl, user, user.getId());
    }


    public void delete(Integer id) {
        restTemplate.delete(userUrl, id);
    }


}
