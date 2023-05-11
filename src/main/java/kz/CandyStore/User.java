package kz.CandyStore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.*;

@Setter
@Getter
public class User {
    private String login,password;
    Scanner scan = new Scanner(System.in);
    ArrayList<User> userList = new ArrayList<>();
    private ArrayList<Candy> cart = new ArrayList<>();
    ArrayList<String> loginList = new ArrayList<>();
    ArrayList<String> passwordList = new ArrayList<>();
    int sum = 0;

    public User(String login,String password){
        this.login = login;
        this.password = password;
    }

    public User() {
    }

    public String getLogin(){
        return login;
    }
    public String getPassword(){
        return password;
    }

    public void signUp(){
        System.out.println("Enter your login:");
        login = scan.nextLine();
        setLogin(login);

        System.out.println("Enter your password:");
        String password = scan.nextLine();
        setPassword(password);
        password = password;
        User user1 = new User(login,password);
        userList.add(user1);
        loginList.add(login);
        passwordList.add(password);
    }
    public void logIn(){
        System.out.println("Enter your login:");
        String login1 = null;
        login1 = scan.nextLine();
        while(loginList.contains(login1)){
            login1 = scan.nextLine();
            System.out.println("Login is incorrect");
        }
        System.out.println("Login is correct");
        String password1 = null;
        password1 = scan.nextLine();
        while(passwordList.contains(password1)){
            password1 = scan.nextLine();
            System.out.println("Password is incorrect");
        }
        System.out.println("Password is correct\nContinue");
    }

    public void showLists(){
        System.out.println("Users list:");
        for(User user2 : userList){
            System.out.println(user2.getLogin());
        }
    }



    public void showCandyList(){
        CandyList candulist = new CandyList();
        candulist.addToList();
        System.out.println("HERE ARE OUR CANDIES:");
        for(int i = 0;i<candulist.candyListt.size();i++){
            System.out.println(candulist.candyListt.get(i).getName() + " " + candulist.candyListt.get(i).getCompany() + " " + candulist.candyListt.get(i).getPrice());
        }
    }
    public void buyCandies(){
        CandyList candyList = new CandyList(); // create a new CandyList object
        ArrayList<Candy> candies = new ArrayList<>();
        candyList.addToList();
        showCandyList(); // show the candy list
        System.out.println("How many candies do you want to buy?");
        int amount = scan.nextInt();
        for(int i = 0; i < amount; i++){
            System.out.println("Enter the candy number you want:");
            int choice = scan.nextInt();
            if (choice < 0) { // check if choice is valid
                System.out.println("Invalid candy number. Please enter a valid number.");
                i--; // decrement i to repeat the loop iteration
                continue;
            }
            cart.add(candyList.candyListt.get(choice));
            System.out.println("You chose " + candyList.candyListt.get(choice).getName());
            sum += candyList.candyListt.get(choice).getPrice();
        }
    }
    public void showCart(){
        System.out.println("Your cart:");
        if(!(cart.isEmpty())) {
            for (int i = 0; i < cart.size(); i++) {
                System.out.println(cart.get(i).getName() + " " + cart.get(i).getCompany() + " " + cart.get(i).getPrice());
            }
        } else {
            System.out.println("Cart is empty");
        }
        System.out.println("Full sum: " + sum);
    }
    public void clearCart(){
        cart.clear();
        sum=0;
        setSum(0);
    }
    public void updateUser(){
        System.out.println("What do you want to do?");
        System.out.println("1 - Change login\n 2 - Change password\n 3 - Delete account\n4 - Show account\n5 - Exit");
        int choice = scan.nextInt();

            if(choice == 1){
                System.out.println("Enter your current login: ");
                String currLogin = scan.next();
                while(!(currLogin.equals(getLogin()))){
                    System.out.println("Login is incorrect");
                    currLogin = scan.next();
                }

                System.out.println("Enter your new login:");
                String newLogin = scan.next();
                loginList.remove(getLogin());
                loginList.add(newLogin);
                setLogin(newLogin);
                login = newLogin;
            }
            else if(choice == 2){
                System.out.println("Enter your current password: ");
                String currPassword = scan.next();
                while(!(currPassword.equals(getPassword()))){
                    System.out.println("Password is incorrect");
                    currPassword = scan.next();
                }
                System.out.println("Enter your new password:");
                String newPassword = scan.next();
                passwordList.remove(getPassword());
                passwordList.add(newPassword);
                setPassword(newPassword);
                password = newPassword;
            } else if(choice == 3){
                loginList.remove(login);
                passwordList.remove(password);
                setLogin(null);
                setPassword(null);
                System.out.println("Account deleted");
            }
            else if(choice == 4){
                if(getLogin()!=null){
                    System.out.println("Your login is " + getLogin());
                }
                else System.out.println("You have no login");
                if(getPassword()!=null){
                    System.out.println("Your password is " + getPassword());
                }
                else System.out.println("You have no password");
            }
            else if(choice == 5){
                return;
            }

    }

}
