package Services;

import Models.Database.Meal;
import Models.Database.MealCategory;
import Models.Database.Order;
import Repositorys.MealCategoryRepository;
import Repositorys.MealRepository;
import Repositorys.OrderRepository;
import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    MealCategoryRepository mealCategoryRepository;
    @Autowired
    MealRepository mealRepository;

    public void saveOrder(Order order){

        for(int i = 0; i < order.getItems().size() ;i++){
            Meal meal = mealRepository.findByName(order.getItems().get(i).getMeal().getName());
            MealCategory mealCategory = mealCategoryRepository.findByMeals(meal);
            order.getItems().get(i).setMeal(meal);
            order.getItems().get(i).getMeal().setMealCategory(mealCategory);
            order.getItems().get(i).setOrder(order);
        }



        LocalDateTime dateAndTimeAtThisPoint = LocalDateTime.now();
        order.setDate(dateAndTimeAtThisPoint);

        orderRepository.save(order);


    }

    public void changeOrder(Order order){

        Order dbOrder = orderRepository.findByDate(order.getDate());
        dbOrder.setDone(order.isDone());
        dbOrder.setStarted(order.isStarted());
        dbOrder.setTaken(order.isTaken());


        orderRepository.save(dbOrder);


    }

}
