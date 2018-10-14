package com.cryptoeagle.service;

import com.cryptoeagle.entity.User;
import com.cryptoeagle.exception.UserNotFoundException;
import com.cryptoeagle.repository.UserRepository;

import com.cryptoeagle.service.abst.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    @Transactional
    public void saveAndUpdate(User user) {
        log.info("save user");
        repository.saveAndUpdate(user);
    }

    @Override
    public List<User> getAll() {
        log.info("get all users");
        return repository.getAll();
    }

    @Override
    public User get(int id) {
        log.info("get user id", id);
        User user;
        try {
            user = repository.get(id);
        } catch (Exception ex) {
            throw new UserNotFoundException( ex.getMessage()  + " User id : " + id);
        }

        return user;
    }

    @Override
    public User getByEmail(String email) {
        log.info("get user id", email);
        User user;
        try {
            user = repository.getByEmail(email);
        } catch (Exception ex) {
//            throw new UserNotFoundException(ex.getMessage()  + " User email : " + email);
            return null;
        }
        return user;
    }

    @Override
    public User getByName(String name) {
        log.info("get by name");
        User user;
        try {
            user = repository.getByName(name);
        } catch (Exception ex) {
            throw new UserNotFoundException(ex.getMessage()  + " User name : " + name);
        }
        return user;
    }

    @Override
    public void delete(int id) {
        log.info("delete user by id : " + id);
        try {
            repository.delete(id);
        } catch (Exception ex) {
            throw new UserNotFoundException(ex.getMessage()  + " User id : " + id);
        }
    }

    @Override
    public void delete(User user) {
        log.info("delete user");
        try {
            repository.delete(user.getId());
        } catch (Exception ex) {
            throw new UserNotFoundException(user.toString());
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = this.getByName(username);
        if (user == null)
            throw new UsernameNotFoundException("User :" + username + " not found!");
        return user;
    }
}
