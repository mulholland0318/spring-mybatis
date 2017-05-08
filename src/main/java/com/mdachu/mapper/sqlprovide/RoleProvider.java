package com.mdachu.mapper.sqlprovide;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

/**
 * Created by mm on 2017/5/6.
 */
public class RoleProvider {

    private static String TABLE_NAME = "mdc_role";

    public String getRoleListSql(String id){
        BEGIN();
        SELECT("id,name,seq");
        FROM(TABLE_NAME);
        if(null != null){
            WHERE("id = #{id,javaType=string,jdbcType=VARCHAR}");
        }
        return SQL();
    }


    public String deleteSql(String id){
        BEGIN();
        DELETE_FROM(TABLE_NAME);
        WHERE("id = #{id,javaType=string,jdbcType=VARCHAR}");
        return SQL();
    }

    public String updateSql(){
        BEGIN();
        UPDATE(TABLE_NAME);
        SET("name = #{name,javaType=string,jdbcType=VARCHAR}");
        SET("seq = #{seq}");
        WHERE("id = #{id}");
        return SQL();
    }

    public String insertSql(){
        BEGIN();
        INSERT_INTO(TABLE_NAME);
        VALUES("id","#{role.id}");
        VALUES("name","#{role.name}");
        VALUES("seq","#{role.seq}");
        return SQL();
    }

}
