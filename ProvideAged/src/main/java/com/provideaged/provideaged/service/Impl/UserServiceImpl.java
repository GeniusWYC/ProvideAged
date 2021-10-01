package com.provideaged.provideaged.service.Impl;

import com.provideaged.provideaged.dao.UserDao;
import com.provideaged.provideaged.entity.User;
import com.provideaged.provideaged.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: UserServiceImpl
 * @Description: 用户服务
 * @author: 巫运辰
 * @date: 2021/08/27 14:48
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public boolean login(User user) {
        User data = userDao.login(user.getUsername(), user.getPassword());
        return data != null;
    }

    @Override
    public void createUser(User param) {
        userDao.save(param);
    }

    @Override
    public void updateState(User user) {
        userDao.updateState(user.getUsername(), user.getState());
    }

    @Override
    public void updatePassword(User user) {
        userDao.updatePassword(user.getUsername(), user.getPassword());
    }

    @Override
    public void deleteUser(String username) {
        userDao.deleteUser(username);
    }

    @Override
    public List<User> queryByRole(short role,int pageNumber,int pageSize) {
        Sort sort = Sort.by(Sort.Direction.ASC,"id");
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        return userDao.queryByRole(role,pageable);
    }

    @Override
    public User queryByUsername(String username) {
        return userDao.queryByUsername(username);
    }

}