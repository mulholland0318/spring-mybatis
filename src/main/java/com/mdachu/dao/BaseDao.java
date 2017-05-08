package com.mdachu.dao;

import java.util.List;

/**
 * Created by mm on 2017/5/2.
 */
public interface BaseDao<T> {

    public int save(String str ,T t);

    public int delete(String str,String id );

    public int edit(String str,T t);

    public T findById(String str,String id);

   public List<T> findByParam (String str,Object param);

}
