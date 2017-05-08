package test;

import com.mdachu.dao.UserBaseDao;
import com.mdachu.dao.UserDao;
import com.mdachu.dao.UserSqlSessionDao;
import com.mdachu.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mm on 2017/5/2.
 */
//@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
public class UserDaoTest extends AbstractJUnit4SpringContextTests{


    private UserBaseDao dao;

    @Resource
    private UserSqlSessionDao sessionDao;



    //@Test
    public void userSaveTest(){
        User user = new User();
        user.setId("1234");
        user.setUsername("zhangsan");
        user.setPassword("pwd1234");
        user.setPhone("13516269745");
        int size = dao.save("UserMapper.save",user);
        //Assert.assertEquals(1,size);
    }
    @Test
    public void saveBatchTest(){
        List<User> users = new ArrayList<User>();
        for(int i= 0 ;i<3;i++){
            User u = new User();
            u.setFlag("f"+i);
            u.setLastlogin("log"+i);
            u.setId("i"+i);
            u.setUsername("name"+i);
            u.setEmail("e"+i);
            u.setPassword("p"+i);
            users.add(u);
        }
        sessionDao.saveBatch(users);


    }
}
