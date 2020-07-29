package com.bsuir.vmsis.service.impl;

import com.bsuir.vmsis.dto.impl.UserDto;
import com.bsuir.vmsis.mapper.impl.UserMapper;
import com.bsuir.vmsis.model.impl.User;
import com.bsuir.vmsis.model.impl.UserDetailsImpl;
import com.bsuir.vmsis.repository.UserRepository;
import com.bsuir.vmsis.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService,EntityService<UserDto> {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserMapper mapper;

    public UserService(UserRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public UserDto create(UserDto user) {
        return mapper.toDto(repository.save(mapper.fromDto(user)));
    }

    @Override
    public UserDto update(UserDto entity) {
        return mapper.toDto(repository.save(mapper.fromDto(entity)));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public UserDto getById(Long id) {
        return mapper.toDto(repository.findById(id).get());
    }

    @Override
    public List<UserDto> getEntities() {
        return null;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
        return UserDetailsImpl.build(user);
    }
}
