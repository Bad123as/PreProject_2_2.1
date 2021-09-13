package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      Car car1 = new Car("BMW", "M5");
      User user1 = new User("User1", "Lastname1", "user1@mail.ru", car1);
      userService.add(user1);
      car1.setUser(user1);

      Car car2 = new Car("Mercedes", "Benz");
      User user2 = new User("User2", "Lastname2", "user2@mail.ru", car2);
      userService.add(user2);
      car2.setUser(user2);

      Car car3 = new Car("Honda", "Civic");
      User user3 = new User("User3", "Lastname3", "user3@mail.ru", car3);
      userService.add(user3);
      car3.setUser(user3);

      Car car4 = new Car("Aston", "Martin");
      User user4 = new User("User4", "Lastname4", "user4@mail.ru", car4);
      userService.add(user4);
      car4.setUser(user4);

      System.out.println(userService.getUserByNameAndSeries(car1.getName(), car1.getSeries()).toString());

      context.close();
   }
}
