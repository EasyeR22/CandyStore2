package kz.CandyStore;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
public class CandyList {
    public ArrayList<Candy> candyListt = new ArrayList<Candy>();
    Candy candy1 = new Candy("Snickers", "Mars", 150);
    Candy candy2 = new Candy("KitKat", "Nestle", 120);
    Candy candy3 = new Candy("Twix", "Mars", 170);
    Candy candy4 = new Candy("Raffaelo", "Ferrero", 250);
    Candy candy5 = new Candy("Bounty", "Procter&Gamble", 130);

    public void addToList(){
        candyListt.add(candy1);
        candyListt.add(candy2);
        candyListt.add(candy3);
        candyListt.add(candy4);
        candyListt.add(candy5);
    }
}
