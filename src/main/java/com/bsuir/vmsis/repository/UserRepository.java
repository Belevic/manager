package com.bsuir.vmsis.repository;

import com.bsuir.vmsis.dto.impl.UserDto;
import com.bsuir.vmsis.model.impl.Country;
import com.bsuir.vmsis.model.impl.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    User findByLoginAndPassword(String login,String password);
    Optional<User> findByLogin(String username);
    Optional<User> findByName(String username);
    Boolean existsByName(String username);
    Boolean existsByLogin(String login);
}
