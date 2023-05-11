package kz.CandyStore;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Item {
    Candy candy = new Candy();
    private int quantity;


    public Candy getCandy() {
        return candy;
    }
    public int getQuantity() {
        return quantity;
    }
    public int getTotalPrice() {
        return candy.getPrice() * quantity;
    }
}
