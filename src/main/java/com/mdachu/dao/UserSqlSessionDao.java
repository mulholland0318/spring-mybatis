package com.mdachu.dao;

import com.mdachu.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by mm on 2017/5/2.
 */
@Repository
public class UserSqlSessionDao implements BaseDao<User>{
    @Resource(name="sqlSession")
    private SqlSession sqlSession;

    @Override
    public int save(String str, User user) {
        return 0;
    }

    public int saveBatch(List<User> list){
        for(User user:list){
            sqlSession.insert("com.mdachu.mapper.UserMapper.save",user);
        }
        return 1;
    }

    @Override
    public int delete(String str, String id) {
        return 0;
    }

    @Override
    public int edit(String str, User user) {
        return 0;
    }

    @Override
    public User findById(String str, String id) {
        return null;
    }

    @Override
    public List<User> findByParam(String str, Object param) {
        return null;
    }
}
