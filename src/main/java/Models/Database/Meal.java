package Models.Database;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Table(name="meal")
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meal_id")
    @JsonIgnore
    private Integer id;
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "meal_category_id")
    private MealCategory mealCategory;

    @OneToOne()
    @PrimaryKeyJoinColumn
    @JsonIgnore
    public Item item;

    public Meal() {
    }

    public Meal(String name, MealCategory mealCategory) {
        this.name = name;
        this.mealCategory = mealCategory;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public MealCategory getMealCategory() {
        return mealCategory;
    }

    @JsonProperty
    public void setMealCategory(MealCategory mealCategory) {
        this.mealCategory = mealCategory;
    }



    @Override
    public String toString() {
        return "Meal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
