package Controllers;

import Models.Database.Item;
import Models.Database.Meal;
import Models.Database.MealCategory;
import Models.Database.Order;
import Repositorys.MealCategoryRepository;
import Repositorys.OrderRepository;
import Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderService orderService;


    @GetMapping("/tables")
    @ResponseBody
    public List<Order> getAllTables (){

//    List<Order> orders = orderRepository.findAll();
        List<Order> orders = orderRepository.findAllByIsDoneIsFalseOrIsStartedIsFalseOrIsTakenIsFalse();


        return orders;
    }

    @PostMapping("/tables")
    public void saveOrder (@RequestBody Order order){
        orderService.saveOrder(order);

    }


    @PutMapping("/tables")
    public void changeOrder (@RequestBody Order order){
       orderService.changeOrder(order);
    }


}
