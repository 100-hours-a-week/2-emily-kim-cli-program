package member;

public class NonRegistered extends Member {
    public NonRegistered(){};

    public void PrintNotification(){
        System.out.println("---------------------------------------");
        System.out.println("You are a temporary member.");
        System.out.println("Your history is not logged.");
    }

}
