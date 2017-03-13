import cn.semiwarm.api.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

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
    public void testFindAll(){
        System.out.println(userMapper.findAll());
    }

}
