import com.nik.pojo.User;
import com.nik.service.UserService;
import com.nik.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/4/3 21:10
 */
public class MyTest {

    @Test
    public void tes1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = context.getBean("user", User.class);
        System.out.println(user);
    }


    @Test
    public void test2() {
       ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserServiceImpl service = context.getBean("userServiceImpl", UserServiceImpl.class);
        UserServiceImpl service2 = context.getBean("userServiceImpl", UserServiceImpl.class);
        System.out.println(service2 == service);
        service.getUser();
    }
}
