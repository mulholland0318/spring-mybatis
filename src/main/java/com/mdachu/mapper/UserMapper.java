package com.mdachu.mapper;

import com.mdachu.entity.User;
import org.springframework.stereotype.Repository;

/**
 * Created by mm on 2017/5/2.
 */
//@Repository("userMapper")
public interface UserMapper {
    public int save(User user);

    public User findById(String id );

    public int edit(User user );
}
