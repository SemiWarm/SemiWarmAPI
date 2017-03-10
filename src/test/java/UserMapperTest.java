import cn.semiwarm.api.entity.User;
import cn.semiwarm.api.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.sql.Timestamp;
import java.util.UUID;

/**
 * UserMapper测试类
 * 带有swagger2的单元测试需要添加@WebAppConfiguration注解
 * Created by alibct on 2017/3/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("classpath:spring/spring-*.xml")
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testAdd(){
        User user = new User();
        user.setUserId(UUID.randomUUID().toString());
        user.setUserName("呆萌的小白兔");
        user.setUserPhone("18451390226");
        user.setPassword("000000");
        user.setStatus(true);
        user.setCreateTime(new Timestamp(System.currentTimeMillis()));
        int result;
        result = userMapper.add(user);
        if (result > 0) {
            System.out.println("添加成功！");
        } else {
            System.out.println("添加失败！");
        }
    }

    @Test
    public void testFindAll(){
        System.out.println(userMapper.findAll());
    }
}
