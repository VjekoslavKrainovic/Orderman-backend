package Repositorys;

import Models.Database.Meal;
import Models.Database.MealCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface MealRepository extends JpaRepository<Meal,Integer> {

    Meal findByName(String name);
    List<Meal> findByMealCategory(MealCategory mealCategory);
    Integer deleteByNameAndMealCategory(String name, MealCategory mealCategory);

}
