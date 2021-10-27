import com.config.TestConfig;
import com.pojo.TestA;
import org.junit.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.service.UserService;
import com.service.impl.TestServiceImpl;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/4/3 12:02
 */
public class MyTest {
    public static void main(String[] args) {
//        UserService userService = new UserServiceImpl();
//        //用户需要哪个实现类就set哪个实现类，降低程序的耦合性
//        ((UserServiceImpl)userService).setUserDao(new UserDaoImpl());
//        userService.UserService();


        ApplicationContext context = new ClassPathXmlApplicationContext("Bean.xml");
        UserService bean = (UserService) context.getBean("userServiceImpl");
        bean.UserService();
    }


    @Test
    public void test1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Bean.xml");
        TestServiceImpl serviceImpl = applicationContext.getBean("testServiceImpl", TestServiceImpl.class);
        serviceImpl.testService();
    }


    @Test
    public void test2(){

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestConfig.class);
        TestA test = applicationContext.getBean("test", TestA.class);
        System.out.println(test.getName());
    }
}
