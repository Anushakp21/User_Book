package com.example.User.service;

import com.example.User.dto.BookDto;
import com.example.User.dto.UserWithBooksResponse;
import com.example.User.entity.User;
import com.example.User.repository.UserRepository;
import com.example.User.template.RestTemplateConfig;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;



import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User user) {
        User existing = userRepository.findById(id).orElseThrow();
        existing.setName(user.getName());
        existing.setEmail(user.getEmail());
        return userRepository.save(existing);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserWithBooksResponse getUserWithBooks(Long userId) {
        User user = userRepository.findById(userId).orElseThrow();

        // REST call to Book Microservice
        BookDto[] books = restTemplate.getForObject(
                "http://localhost:8081/books/user/" + userId,
                BookDto[].class
        );

        return new UserWithBooksResponse(user, Arrays.asList(books));
    }
}
