package exercise;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import java.util.List;
import java.util.ArrayList;

@Component
public class QueueListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(QueueListener.class);

    // Для наглядности в список будут добавляться все сообщения,
    // которые получены из очереди
    // Так их можно будет легко просмотреть
    private List<String> messages = new ArrayList<>();
    public List<String> getAllMessages() {
        return messages;
    }

    // BEGIN
    @RabbitListener(queues = "queue")
    public void process(String message) {
        // В простейшем случае просто выводим полученное сообщение
        // В общем случае этот сервис может делать с сообщением все что угодно.
        // Например, можно использовать данные пользователя из сообщения
        // и создавать аккаунт или отправлять пользователю письмо или смс
        // Получатель никак не зависит от отправителя, отправитель сообщения даже не знает,
        // кто и как будет использовать полученное сообщение
        System.out.println(message);
    }
    // END
}
/* Создайте метод, который будет прослушивать очередь и при появлении нового сообщения
добавлять это сообщение в список messages. Чтобы метод прослушивал сообщения из очереди,
нужно отметить его аннотацией @RabbitListener, указав имя очереди. В качестве аргумента метод принимает сообщение.

@RabbitListener(queues = "queue")
public void process(String message) {
    // Выполняем какие-то действия
}

Метод будет выполнен каждый раз, когда в прослушиваемой очереди появится новое сообщение
Для наглядности реализуйте логгирование полученного сообщения. Так можно будет увидеть полученное сообщение в консоли.


Откройте новое окно в терминале и запустите оба приложения при помощи команды make start в корне упражнения.
Не забудьте предварительно запустить сервер RabbitMQ. Попробуйте зарегистрировать и удалить пользователя.
Убедитесь, что в консоль выводятся логи о том, что сообщение было отправлено и получено.
Также посмотреть список всех отправленных в очередь сообщений можно будет, отправив GET запрос
второму приложению на адрес localhost:5001/messages
*/