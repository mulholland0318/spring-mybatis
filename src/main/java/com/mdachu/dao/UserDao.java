package com.mdachu.dao;

import com.mdachu.entity.User;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mm on 2017/5/2.
 */

public class UserDao extends SqlSessionDaoSupport {
    public int save(String str,User user){
        return getSqlSession().insert(str,user);
    }
}
