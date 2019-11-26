package Repositorys;

import Models.Database.Meal;
import Models.Database.MealCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealCategoryRepository extends JpaRepository<MealCategory,Integer> {

    MealCategory findByMeals(Meal meals);
    MealCategory findByName(String name);
}
