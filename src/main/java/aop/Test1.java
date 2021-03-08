package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(MyConfig.class);
        var library = context.getBean("library", Library.class);
        library.getBook();
        context.close();
    }
}
