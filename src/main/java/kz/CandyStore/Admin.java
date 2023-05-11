package kz.CandyStore;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Scanner;

@Setter
@Getter
public class Admin extends User implements IAdmin{
    private String login,password;
    Scanner scan = new Scanner(System.in);
    ArrayList<Admin> adminList = new ArrayList<>();
    private ArrayList<String> AdminLoginList = new ArrayList<>();
    private ArrayList<String> AdminPasswordList = new ArrayList<>();

    public Admin(String login,String password){
        this.login = login;
        this.password = password;
    }

    public Admin() {
    }

    public String getLogin(){
        return login;
    }
    public String getPassword(){
        return password;
    }
    public void signUp(){
        System.out.println("Enter your login:");
        String login = scan.nextLine();
        setLogin(login);
        AdminLoginList.add(login);
        System.out.println("Enter your password:");
        String password = scan.nextLine();
        setPassword(password);
        AdminPasswordList.add(password);
        Admin admin1 = new Admin(login,password);
        adminList.add(admin1);
    }
    public void logIn(){
        System.out.println("Enter your login:");
        String login1 = null;
        while(AdminLoginList.contains(login1)){
            login1 = scan.nextLine();
            System.out.println("Login is incorrect");
        }
        System.out.println("Login is correct");
        String password1 = null;
        while(AdminPasswordList.contains(password1)){
            password1 = scan.nextLine();
            System.out.println("Password is incorrect");
        }
        System.out.println("Password is correct\nContinue");
    }
    @Override
    public void showUserList(){
        User user = new User();
        user.showLists();
    }
    @Override
    public void showAdminList(){
        System.out.println("Admins list:");
        for(Admin admin1 : adminList){
            System.out.println(admin1.getLogin() + " " + admin1.getPassword());
        }
    }

    @Override
    public void changeData() {
        System.out.println("1 - Change User data\n2 - Change Admin data");
        int choice = scan.nextInt();
        if(choice == 1){
            System.out.println("1 - Change login\n 2 - Change password\n 3 - Delete account\n4 - Show account\n5 - Exit");
            int choice1 = scan.nextInt();
            if(choice1==1) {
                System.out.println("Enter new login:");
                String newLogin = scan.next();
                loginList.remove(getLogin());
                loginList.add(newLogin);
                setLogin(newLogin);
                login = newLogin;
            } else if (choice1==2) {
                System.out.println("Enter new password:");
                String newPassword = scan.next();
                passwordList.remove(getPassword());
                passwordList.add(newPassword);
                setPassword(newPassword);
                password = newPassword;
            } else if (choice==3) {
                loginList.remove(login);
                passwordList.remove(password);
                setLogin(null);
                setPassword(null);
                System.out.println("Account deleted");
            }
        } else if (choice==2) {
            System.out.println("1 - Change login\n 2 - Change password\n 3 - Delete account\n4 - Show account\n5 - Exit");
            int choice1 = scan.nextInt();
            if(choice1==1) {
                System.out.println("Enter new login:");
                String newLogin = scan.next();
                AdminLoginList.remove(getLogin());
                AdminLoginList.add(newLogin);
                setLogin(newLogin);
                login = newLogin;
            } else if (choice1==2) {
                System.out.println("Enter new password:");
                String newPassword = scan.next();
                AdminPasswordList.remove(getPassword());
                AdminPasswordList.add(newPassword);
                setPassword(newPassword);
                password = newPassword;
            } else if (choice==3) {
                AdminLoginList.remove(login);
                AdminPasswordList.remove(password);
                setLogin(null);
                setPassword(null);
                System.out.println("Account deleted");
            }
        }

    }

    @Override
    public void addCandy() {
        String candyName = scan.next();
        String candyCompany = scan.next();
        int candyPrice = scan.nextInt();
        CandyList candyListClass = new CandyList();
        Candy candy = new Candy(candyName,candyCompany,candyPrice);
        candyListClass.candyListt.add(candy);
    }

    @Override
    public void deleteCandy() {
        String candyName = scan.next();
        CandyList candyListClass = new CandyList();
        for (int i = 0; i < candyListClass.candyListt.size(); i++) {
            if(candyName==candyListClass.candyListt.get(i).getName()){
                candyListClass.candyListt.remove(candyListClass.candyListt.get(i).getName());
                return;
            }
        }
        System.out.println("There is no " + candyName);
    }
}
