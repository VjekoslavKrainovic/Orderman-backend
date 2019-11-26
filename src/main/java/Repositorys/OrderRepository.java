package Repositorys;

import Models.Database.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

//    @Query(value = "SELECT i.description, m.name, mc.name, ot.date, ot.is_done, ot.is_started\n" +
//            "FROM dbo.item AS i\n" +
//            "INNER JOIN dbo.meal AS m ON i.meal_id = m.meal_id\n" +
//            "INNER JOIN dbo.meal_category AS mc ON m.meal_category_id = mc.meal_category_id\n" +
//            "INNER JOIN dbo.order_table AS ot ON i.order_table_id = ot.order_table_id", nativeQuery = true)
//    List<Order> findAll();

    List<Order> findAllByIsDoneIsFalseOrIsStartedIsFalseOrIsTakenIsFalse();

    Order findByDate(LocalDateTime date);

}
