package com.mdachu.service;

import com.mdachu.entity.Role;
import com.mdachu.mapper.RoleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by mm on 2017/5/5.
 */
@Service("roleService")
public class RoleService {
    @Resource(name="roleMapper")
    private RoleMapper roleMapper;

    public int save(Role role){
        return roleMapper.save(role);
    }

    public Role findById(String id){
        return roleMapper.findById(id);
    }

    public List<Role> findByParam(String id){
        return roleMapper.findListByParam(id);
    }

    public long deleteById(String id){
        return roleMapper.deleteById(id);
    }

    public long update(Role role){
        return roleMapper.update(role);
    }

    public long insert(Role role){
        return roleMapper.insert(role);
    }

    public long delete(String id){
        return roleMapper.delete(id);
    }

    public long saveRole(Role role){
        return roleMapper.saveRole(role);
    }

    public long updateRole(Role role){
        return roleMapper.updateRole(role);
    }

}
