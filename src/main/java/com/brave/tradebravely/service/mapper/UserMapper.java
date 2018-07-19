package com.brave.tradebravely.service.mapper;

import com.brave.tradebravely.domain.Authority;
import com.brave.tradebravely.domain.User;
import com.brave.tradebravely.service.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Mapper for the entity User and its DTO called UserDTO.
 *
 * Normal mappers are generated using MapStruct, this one is hand-coded as MapStruct
 * support is still in beta, and requires a manual step with an IDE.
 */
@Service
public class UserMapper {

    public UserDTO userToUserDTO(User user) {
        return new UserDTO(user);
    }

    public User userDTOToUser(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        } else {
            Set<Authority> authorities = this.authoritiesFromStrings(userDTO.getAuthorities());
            return new User(userDTO.getId(), userDTO.getLogin(), authorities);
        }
    }

    public User userFromId(Integer id) {
        if (id == null) {
            return null;
        }
        return new User(id, null, null);
    }

    private Set<Authority> authoritiesFromStrings(Set<String> strings) {
        return strings.stream().map(string -> {
            Authority auth = new Authority();
            auth.setName(string);
            return auth;
        }).collect(Collectors.toSet());
    }
}
