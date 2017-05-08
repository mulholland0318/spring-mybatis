package com.mdachu.mapper;

import com.mdachu.entity.Role;
import com.mdachu.mapper.sqlprovide.RoleProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by mm on 2017/5/5.
 */
public interface RoleMapper {
    public int save(Role role);

    @Select("select * from mdc_role where id = #{id}")
    public Role findById(@Param("id")String id);

    @Update(value="update mdc_role set name=#{name},seq=#{seq} where id=#{id}")
    public long updateRole(Role role);

    @Delete("delete from mdc_role where id = #{roleId}")
    public long delete(@Param("roleId") String id );

    @Insert("insert into mdc_role (id,name,seq)values(#{id},#{name},#{seq})")
    public long saveRole(Role role);




    @SelectProvider(type = RoleProvider.class,method = "getRoleListSql")
    public List<Role> findListByParam(String id);


    @DeleteProvider(type = RoleProvider.class, method = "deleteSql")
    @Options(flushCache = Options.FlushCachePolicy.TRUE, timeout = 20000)
    public int deleteById( String id) ;

    @UpdateProvider(type=RoleProvider.class,method = "updateSql")
    @Options(flushCache =  Options.FlushCachePolicy.TRUE,timeout = 20000)
    public long update(Role role);


    @InsertProvider(type = RoleProvider.class,method = "insertSql")
    @Options(flushCache = Options.FlushCachePolicy.TRUE,timeout = 20000)
    public long insert(@Param("role") Role role);

}
