package Menu;

import Menu.NameChemistry.NameChemistry;
import Menu.Taro.Taro;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Menu {
    Scanner sc=new Scanner(System.in);

    Taro taro=new Taro();
    NameChemistry nameChemistry=new NameChemistry();
    int pickNum;

    public Menu(){}
    public int PrintMenu() {
        System.out.println("---------------------------------------");
        System.out.println("        *.!  Taroro Taro  ..*!         ");
        System.out.println("         * ~.\"  *'~  *.' -.*          ");
        System.out.println();
        System.out.println("*'~  1. 타로점 보기");
        System.out.println("*'~  2. 이름 궁합 보기");
        System.out.println("*'~  3. 회원권 충전");
        System.out.println("*'~  4. 나가기");
        this.PickNum();

        return this.pickNum;
    }

    public void GoTo() throws FileNotFoundException, InterruptedException {
        switch (this.pickNum){
            case 1:
                while(taro.WelcomeTaro()!=4){
                    taro.GoTo();
                };
                break;
            case 2:
                nameChemistry.WelcomeNameChemistry();
                break;
            case 3:
                break;
            case 4:
                System.out.println("안녕히 가세요!");
                break;
            default:
                break;
        }
    }
    public void PickNum(){
        System.out.print(">>  ");
        int num=sc.nextInt();
        if(num<1|| num>4) {
            System.out.println("   잘못된 번호 입니다. 다시 입력해주세요.");
            this.PickNum();
        }
        this.pickNum=num;
        System.out.println("---------------------------------------");
    }

    public void Loading() throws InterruptedException {
        for(int i=0;i<7;i++){
            System.out.print("~ ");
            TimeUnit.MILLISECONDS.sleep(150);
            System.out.print(". ");
            TimeUnit.MILLISECONDS.sleep(150);
            System.out.print("* ");
            TimeUnit.MILLISECONDS.sleep(150);
        }
        System.out.println();
    }
    public void PrintMessage(String message) {
        System.out.println("        * ~.\"  *'~  *.'  -.*          ");
        System.out.println("      *.! " + message + " ..*!     ");
    }
    public void WaitABit() throws InterruptedException {
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(2000);
    }
}
