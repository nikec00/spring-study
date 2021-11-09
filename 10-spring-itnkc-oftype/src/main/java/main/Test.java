package main;

import dao.DemoDAO;
import dao.Impl.MysqlDAOImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/11/9 14:29
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Map<String, DemoDAO> ofTypes = context.getBeansOfType(DemoDAO.class);
        ofTypes.forEach((beanName,bean) -> {
            System.out.println(beanName + " : " + bean.toString());
        });
    }
}
