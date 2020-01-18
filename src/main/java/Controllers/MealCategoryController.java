package Controllers;

import Models.Database.Meal;
import Models.Database.MealCategory;
import Repositorys.MealCategoryRepository;
import Services.MealCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Object> putMealCategory(@RequestBody MealCategory mealCategory){

        mealCategoryService.saveMealCategory(mealCategory);

        return ResponseEntity.ok(mealCategory);
    }

    @PostMapping("/mealCategory")
    public ResponseEntity<Object> postMealCategory(@RequestBody MealCategory mealCategory){

        mealCategoryService.updateMealCategory(mealCategory);

        return ResponseEntity.ok(mealCategory);
    }
}
