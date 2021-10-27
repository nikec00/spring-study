import com.nik.pojo.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/4/3 20:13
 */
public class MyTest {
    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

        Person person = context.getBean("person", Person.class);

        person.getDog().shut();

        person.getCat().shut();
    }
}
