package com.yw.mapper;

import com.yw.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    List<User> queryUserList();

    User queryById(int id);

    int updateUsr(User user);

    int addUser(User user);

    int deleteUer(int id);
}
