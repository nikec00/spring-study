import com.nik.pojo.Hello;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/4/3 12:58
 */
public class MyTest {
    public static void main(String[] args) {
        //获取spring的上下文对象
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        Hello hello = context.getBean("hello",Hello.class);
        String name = hello.getName();
        System.out.println(name);

    }
}
