package Models.Database;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Table(name="item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    @JsonIgnore
    private Integer id;


    @OneToOne()
    @JoinColumn(name="meal_id")
    private Meal meal;
    private String description;
    private Integer numberOfMeals;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_table_id")
    @JsonIgnore
    private Order order;

    public Item() {
    }

    public Item(Meal meal, String description, Order order) {
        this.meal = meal;
        this.description = description;
        this.order = order;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Integer getNumberOfMeals() {
        return numberOfMeals;
    }

    public void setNumberOfMeals(Integer numberOfMeals) {
        this.numberOfMeals = numberOfMeals;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", meal=" + meal +
                ", description='" + description + ", numberOfMeals='" + numberOfMeals +
                '}';
    }
}
