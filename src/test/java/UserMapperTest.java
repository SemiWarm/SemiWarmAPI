import cn.semiwarm.api.entity.User;
import cn.semiwarm.api.entity.UserInfo;
import cn.semiwarm.api.mapper.UserInfoMapper;
import cn.semiwarm.api.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Date;

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
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    public void testAdd(){
        User user = new User();
        user.setUserId(new Date().getTime());
        user.setUserName("阿狸不吃糖");
        user.setUserPhone("18362666128");
        user.setPassword("941001");
        user.setStatus(true);
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

    @Test
    public void testSignUp(){
        Long userId = new Date().getTime();
        User user = new User();
        user.setUserId(userId);
        user.setUserName("呆萌的小白兔");
        user.setUserPhone("18451390226");
        user.setPassword("951212");
        user.setStatus(true);
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userId);

        if (userInfoMapper.add(userInfo) > 0 && userMapper.add(user) > 0){
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
    }

}
