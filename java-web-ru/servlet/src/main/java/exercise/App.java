package exercise;

import exercise.servlet.WelcomeServlet;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.Context;

import java.io.File;

public class App {

    private static int getPort() {
        String port = System.getenv("PORT");
        if (port != null) {
            return Integer.valueOf(port);
        }
        return 5000;
    }

    public static Tomcat getApp(int port) {
        Tomcat app = new Tomcat();

        app.setBaseDir(System.getProperty("java.io.tmpdir"));
        app.setPort(port);

        Context ctx = app.addContext("", new File(".").getAbsolutePath());

        // BEGIN
        // Регистрируем сервлет
        app.addServlet(ctx, "WelcomeServlet", new WelcomeServlet());
        // Назначаем сервлет как обработчик запросов по пути "/hello"
        // На примере хоста и порта выше - "http://localhost:8080/hello"
        ctx.addServletMappingDecoded("/", "WelcomeServlet");
        // END

        return app;
    }

    public static void main(String[] args) throws LifecycleException {
        Tomcat app = getApp(getPort());
        app.start();
        app.getServer().await();
    }
}

/*
public class Example {
    public static void main(String[] args) throws LifecycleException {
        // создаём инстанс контейнера сервлетов Tomcat
        Tomcat app = new Tomcat();

        // Tomcat требуется указать директорию для временных файлов
        // Это метод должен быть вызван первым после создания инстанса
        app.setBaseDir(System.getProperty("java.io.tmpdir"));

        // Задаём порт на котором можно будет открыть приложение
        // По умолчанию Tomcat будет использовать хост 0.0.0.0, то есть
        // все доступные в системе, в т.ч localhost
        app.setPort(8080);

        // Создание контекста в программном режиме (без web.xml)
        Context ctx = app.addContext("", new File(".").getAbsolutePath());

        // Регистрируем сервлет
        app.addServlet(ctx, "HelloServlet", new HelloServlet());
        // Назначаем сервлет как обработчик запросов по пути "/hello"
        // На примере хоста и порта выше - "http://localhost:8080/hello"
        ctx.addServletMappingDecoded("/hello", "HelloServlet");

        // Запуск сервера
        app.start();
        app.getServer().await();

        // Программная остановка сервера
        // app.stop();
    }
}
*/
