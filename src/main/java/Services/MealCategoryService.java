package Services;

import Models.Database.Meal;
import Models.Database.MealCategory;
import Repositorys.MealCategoryRepository;
import Repositorys.MealRepository;
import Repositorys.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealCategoryService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    MealCategoryRepository mealCategoryRepository;
    @Autowired
    MealRepository mealRepository;

    public void saveMealCategory(MealCategory mealCategory){

        for (int i = 0; i < mealCategory.getMeals().size(); i++) {
            mealCategory.getMeals().get(i).setMealCategory(mealCategory);
        }


        mealCategoryRepository.save(mealCategory);
    }

    public void updateMealCategory(MealCategory mealCategory){

        ifMealDontExistForThisMealCategoryaddToDataBase(mealCategory);

        //ifMealDontExistForThisMealCategoryDeleteFromDataBase(mealCategory);



    }

    private void ifMealDontExistForThisMealCategoryaddToDataBase(MealCategory mealCategory){

        MealCategory mealCategoryDB = mealCategoryRepository.findByName(mealCategory.getName());


        for (int i = 0; i < mealCategory.getMeals().size(); i++) {
            Integer counter = mealCategoryDB.getMeals().size();
            for (int j = 0; j < mealCategoryDB.getMeals().size(); j++) {
                if(mealCategoryDB.getMeals().get(j).getName().equals(mealCategory.getMeals().get(i).getName())){
                    break;
                }else{
                    counter--;
                }
            }

            if(counter.equals(0)){
                mealCategory.getMeals().get(i).setMealCategory(mealCategoryDB);
                mealRepository.save(mealCategory.getMeals().get(i));
            }

        }
    }

    private void ifMealDontExistForThisMealCategoryDeleteFromDataBase(MealCategory mealCategory){

        MealCategory mealCategoryDB = mealCategoryRepository.findByName(mealCategory.getName());
        mealRepository.delete(mealCategoryDB.getMeals().get(mealCategoryDB.getMeals().size()-1));

//        for (int i = 0; i < mealCategoryDB.getMeals().size(); i++) {
//            Integer counter = mealCategory.getMeals().size();
//            for (int j = 0; j < mealCategory.getMeals().size(); j++) {
//                if(mealCategoryDB.getMeals().get(i).getName().equals(mealCategory.getMeals().get(j).getName())){
//                    break;
//                }else{
//                    counter--;
//                }
//            }
//
//            if(counter.equals(0)){
//                mealRepository.deleteByNameAndMealCategory(mealCategoryDB.getMeals().get(i).getName(),mealCategoryDB);
//            }
//
//        }

    }




}
