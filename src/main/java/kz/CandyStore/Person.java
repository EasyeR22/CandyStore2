package kz.CandyStore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.SQLOutput;
import java.util.Scanner;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Person extends Admin{
    Scanner scan = new Scanner(System.in);



    private String login,password;

    public Person(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public void func(){
        System.out.println("1 - User\n2 - Admin");
        int choice = scan.nextInt();
        if(choice ==1 ){
            userFunc();
        }
        else if(choice == 2){
            adminFunc();
        }

    }
    public void signUp() {
        System.out.println("1 - User\n 2 - Admin");
        int choice = scan.nextInt();
        if(choice==1){
            User user = new User(login,password);
            user.signUp();
            setLogin(user.getLogin());
            setPassword(user.getPassword());
            userList.add(user);
        } else if (choice==2) {
            Admin admin = new Admin(login,password);
            admin.signUp();
            setLogin(admin.getLogin());
            setPassword(admin.getPassword());
            adminList.add(admin);
        }
    }
    public void logIn(){
        System.out.println("1 - User\n2 - Admin");
        int choice = scan.nextInt();
        if(choice == 1){
            User user = new User(login,password);
            user.logIn();
        }
        else if(choice == 2){
            Admin admin = new Admin(login,password);
            admin.logIn();
        }
    }

    @Override
    public void showLists(){
        System.out.println("Users list:");
        for(User user2 : userList) {
            System.out.println(user2.getLogin() + " " + user2.getPassword());
        }
        System.out.println("Admins list:");
        for(Admin admin2 : adminList){
            System.out.println(admin2.getLogin() + " " + admin2.getPassword());
        }
        /*Admin adm = new Admin(login,password);
        for(Admin admin2 : adm.adminList){
            System.out.println(admin2.getLogin() + " " + admin2.getPassword());
        }*/
    }
    public void userFunc(){
        System.out.println("1 - Sign up\n2 - Log in");
        int choice = scan.nextInt();
        if(choice==1){
            User user = new User(login,password);
            user.signUp();
            setLogin(user.getLogin());
            setPassword(user.getPassword());
            userList.add(user);
        }
        else if(choice==2){
            User user = new User(login,password);
            user.signUp();
            setLogin(user.getLogin());
            setPassword(user.getPassword());
            userList.add(user);

            user.logIn();
        }

        int choice1=0;
        while(choice1!=5) {
            System.out.println("Functions:\n1 - Buy candies\n2 - Show cart\n3 - Clear cart\n4 - Change profile\n5 - Close programme");
            choice1 = scan.nextInt();
            switch(choice1) {
                case 1:
                    buyCandies();
                    break;
                case 2:
                    showCart();
                    break;
                case 3:
                    clearCart();
                    break;
                case 4:
                    updateUser();
                    break;
                default:
                    System.out.println("Incorrect input(");
            }
        }
        System.out.println("Programme is closed");
    }
    public void adminFunc(){
        System.out.println("1 - Sign up\n2 - Log in");
        int choice = scan.nextInt();
        if(choice==1){
            Admin admin = new Admin(login,password);
            admin.signUp();
            setLogin(admin.getLogin());
            setPassword(admin.getPassword());
            adminList.add(admin);
        }
        else if(choice==2){
            Admin admin = new Admin(login,password);
            admin.signUp();
            setLogin(admin.getLogin());
            setPassword(admin.getPassword());
            userList.add(admin);
            admin.logIn();
        }
        int choice1=0;
        while(choice1!=6) {
            System.out.println("Functions:\n1 - Show user List\n2 - Show admin List\n3 - Change Data\n 4 - Add candies\n 5 - Delete candies\n6 - Close programme");
            choice1 = scan.nextInt();
            switch(choice1){
                case 2:
                    showUserList();
                    break;
                case 1:
                    showAdminList();
                    break;
                case 3:
                    changeData();
                    break;
                case 4:
                    addCandy();
                    break;
                case 5:
                    deleteCandy();
                    break;
                default:
                    System.out.println("Incorrect input");
            }
        }
        System.out.println("Programme is closed");
    }




}
