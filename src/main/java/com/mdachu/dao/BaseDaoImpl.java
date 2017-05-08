package com.mdachu.dao;

import com.mdachu.entity.User;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by mm on 2017/5/2.
 */

public class BaseDaoImpl extends SqlSessionDaoSupport implements BaseDao<Object>{



    @Override
    public int save(String str, Object o) {
        return getSqlSession().insert(str,o);
    }

    @Override
    public int delete(String str, String id) {
        return getSqlSession().delete(str,id);
    }

    @Override
    public int edit(String str, Object o) {
        return getSqlSession().update(str,o);
    }

    @Override
    public Object findById(String str, String id) {
        return getSqlSession().selectOne(str,id);
    }

    @Override
    public List<Object> findByParam(String str, Object param) {
        return null;
    }
}
