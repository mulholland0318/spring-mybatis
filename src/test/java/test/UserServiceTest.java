package test;

import com.mdachu.dao.BaseDaoImpl;
import com.mdachu.entity.User;
import com.mdachu.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import test.BaseJunitDaoTest;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * Created by mm on 2017/5/3.
 */
public class UserServiceTest extends BaseJunitDaoTest {

    @Resource(name="userService")
    private UserService service;

    @Test
    public void saveTest(){
        User user = new User();
        user.setId("332d11112");
        user.setUsername("wangwu");
        user.setPassword("password");
        user.setPhone("13516269745");
        user.setEmail("email");
        user.setLastlogin("lastLogin");
        user.setFlag("flag");
        service.save(user);
        //dao.save(user);
    }

    @Test
    public void saveMapperTest(){
        User user = new User();
        user.setId(UUID.randomUUID().toString().replace("-",""));
        user.setUsername("wangwu");
        user.setPassword("password");
        user.setPhone("13516269745");
        user.setEmail("email");
        user.setLastlogin("lastLogin");
        user.setFlag("flag");
        service.saveOne(user);
    }


    @Test
    public void findObjByIdTest(){
        String id = "33";
        User user = service.findById(id);
        Assert.assertNotEquals(null ,user);
    }


    @Test
    public void editTest(){
        User user = new User();
        user.setId("33");
        user.setUsername("wangwu1");
        user.setPassword("password1");
        user.setPhone("135162697451");
        user.setEmail("email1");
        user.setLastlogin("lastLogin1");
        user.setFlag("flag1");
        int size = service.edit(user );

        Assert.assertEquals(1,size);
    }
}
