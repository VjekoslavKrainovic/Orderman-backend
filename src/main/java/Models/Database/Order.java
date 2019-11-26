package Models.Database;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Component
@Entity
@Table(name="order_table")
@JsonPropertyOrder({ "date", "isDone", "isStarted", "items" })
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_table_id")
    @JsonIgnore
    private Integer id;

    private boolean isStarted;
    private boolean isDone;
    private boolean isTaken;
    @Column(unique=true)
    private LocalDateTime date;
    private Integer tableNumber;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Item> items;


    public Order() {
    }

    public Order(List<Item> items, boolean isStarted, boolean isDone, LocalDateTime date) {
        this.items = items;
        this.isStarted = isStarted;
        this.isDone = isDone;
        this.date = date;
    }

    public Order(boolean isStarted, boolean isDone, LocalDateTime date) {
        this.isStarted = isStarted;
        this.isDone = isDone;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public boolean isStarted() {
        return isStarted;
    }

    public void setStarted(boolean started) {
        isStarted = started;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Integer getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(Integer tableNumber) {
        this.tableNumber = tableNumber;
    }

    public boolean isTaken() {
        return isTaken;
    }

    public void setTaken(boolean taken) {
        isTaken = taken;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", items=" + items +
                ", isStarted=" + isStarted +
                ", isDone=" + isDone +
                ", date=" + date +
                '}';
    }


}
