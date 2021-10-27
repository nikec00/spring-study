import com.nik.config.NkcConfig;
import com.nik.config.UserConfig;
import com.nik.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/4/3 22:14
 */
public class MyTest {

    @Test
    public void test() {
        ApplicationContext context = new AnnotationConfigApplicationContext(NkcConfig.class);
        User getUser = context.getBean("getUser", User.class);
        System.out.println(getUser.toString());
    }
}
