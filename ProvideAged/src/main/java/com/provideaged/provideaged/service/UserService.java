package com.provideaged.provideaged.service;

import com.provideaged.provideaged.entity.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {

    boolean login(User user);

    void createUser(User user);

    void updateState(User user);

    void updatePassword(User user);

    void deleteUser(String username);

    List<User> queryByRole(short role,int pageNumber,int pageSize);

    User queryByUsername(String username);


}
