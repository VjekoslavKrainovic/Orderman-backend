package Controllers;

import Models.Database.Meal;
import Models.Database.MealCategory;
import Repositorys.MealCategoryRepository;
import Services.MealCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class MealCategoryController {

    @Autowired
    MealCategoryRepository  mealCategoryRepository;
    @Autowired
    MealCategoryService mealCategoryService;

    @GetMapping("/mealCategory")
    public List<MealCategory> getAllMealCategory(){

        List<MealCategory> mealCategorys = mealCategoryRepository.findAll();

        return mealCategorys;

    }

    @PutMapping("/mealCategory")
    public void putMealCategory(@RequestBody MealCategory mealCategory){

        mealCategoryService.saveMealCategory(mealCategory);

    }

    @PostMapping("/mealCategory")
    public void postMealCategory(@RequestBody MealCategory mealCategory){

        System.out.println(mealCategory);
        mealCategoryService.updateMealCategory(mealCategory);
    }
}
