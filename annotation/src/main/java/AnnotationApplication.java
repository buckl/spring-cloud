import com.lft.annotation.bean.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.lft.annotation.config.Config;

import javax.sound.midi.Soundbank;

public class AnnotationApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        User bean = applicationContext.getBean(User.class);
        System.out.println(bean.getName());
        String[] beanNamesForType = applicationContext.getBeanNamesForType(User.class);
        for (String s : beanNamesForType) {
            System.out.println(s);
        }
    }
}
