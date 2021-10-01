package com.provideaged.provideaged.dao;

import com.provideaged.provideaged.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserDao extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
    @Query("from User where username = ?1 and password = ?2")
    User login(String username, String password);

    @Query("from User where role_id = ?1")
    List<User> queryByRole(short role_id, Pageable pageable);

    @Query("from User where username = ?1")
    User queryByUsername(String username);

    @Modifying
    @Query("delete from User where username = ?1")
    void deleteUser(String username);

    @Modifying
    @Query("update User set password = ?2 where username = ?1")
    void updatePassword(String username,String password);

    @Modifying
    @Query("update User set state = ?2 where username = ?1")
    void updateState (String username,short state);

}
