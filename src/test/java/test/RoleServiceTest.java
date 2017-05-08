package test;

import com.mdachu.entity.Role;
import com.mdachu.service.RoleService;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import static org.junit.Assert.*;

/**
 * Created by mm on 2017/5/5.
 */
public class RoleServiceTest extends BaseJunitDaoTest {

    @Resource(name="roleService")
    private RoleService roleService;

    @Test
    public void save() throws Exception {
        Role role = new Role();
        role.setId(UUID.randomUUID().toString().replace("-",""));
        role.setIndex(1);
        role.setName("roleName");
        int save = roleService.save(role);
        int size = save;
        //Assert.assertEquals(1,size);
    }

    @Test
    public void findByIdTest(){
        String id = "88b947774e6c469cbe78bd7a983a5ae6";
        Role role = roleService.findById(id);
        System.out.println(role.getName());
        Assert.assertNotEquals(null,role);
    }

    @Test
    public void findListByParamTest(){
        List<Role> roles = roleService.findByParam(null);
        Assert.assertEquals(6,roles.size());
    }

    @Test
    public void deleteTest(){
        String id = "28b3d58137274d66a7cebac586722ada";
        long size = roleService.deleteById(id);
        Assert.assertEquals(1,size);
    }

    @Test
    public void updateTest(){
        Role role = new Role();
        role.setId("88b947774e6c469cbe78bd7a983a5ae6");
        role.setName("sdfsdfs");
        role.setSeq(3);
        roleService.update(role);

    }

    @Test
    public void insertTest(){
        Role role = new Role();
        role.setId("sdfa11a");
        role.setName("inserta");
        role.setSeq(6);
        roleService.insert(role);
    }

    @Test
    public void onedeleteTest(){
        String id = "sdfsdjava.util.Random@4bd1f8dd";
        roleService.delete(id);
    }


    @Test
    public void saveRoleTest(){
        Role role = new Role();
        role.setId("sdfa11a7");
        role.setName("inserta7");
        role.setSeq(7);
        roleService.saveRole(role);

    }

    @Test
    public void updateRole(){
        Role role = new Role();
        role.setId("sdfa11a7");
        role.setName("inserta8");
        role.setSeq(8);
        roleService.updateRole(role);
    }

}