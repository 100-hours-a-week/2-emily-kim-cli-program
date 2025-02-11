package Menu;

import Menu.ChargeCredit.ChargeCredit;
import Menu.Music.MusicPlay;
import Menu.NameChemistry.NameChemistry;
import Menu.Taro.Taro;
import Member.Member;
import Member.NonRegistered;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Menu {
    Scanner sc=new Scanner(System.in);

    public Member customer;
    Taro taro;
    NameChemistry nameChemistry;
    ChargeCredit chargeCredit;
    MusicPlay musicPlay;

    public Menu(){
    }
    public Menu(MusicPlay musicPlay){
        this.musicPlay=musicPlay;
    }
    public Menu(Member customer, MusicPlay musicPlay){
        this.customer=customer;
        this.musicPlay=musicPlay;
    }
    public int WelcomeMenu() {
        System.out.println("-------------------------------------------");
        System.out.println("          *.!  Taroro Taro  ..*!           ");
        System.out.println("           * ~.\"  *'~  *.' -.*            ");
        System.out.println();
        System.out.println("*'~  1. 타로점 보기\t\t\t  2000-4000 크레딧");
        System.out.println("*'~  2. 이름 궁합 보기\t\t\t  3000 크레딧");
        System.out.println("*'~  3. 회원권 충전");
        System.out.println("*'~  4. 배경음악 변경");
        System.out.println("*'~  5. 나가기");


        return this.PickNum(1,5);
    }
    public void GoTo() throws IOException, InterruptedException, UnsupportedAudioFileException, LineUnavailableException {
        while(true) {
            switch (this.WelcomeMenu()) {
                case 1:
                    taro = new Taro(customer);
                    taro.GoTo();
                    break;
                case 2:
                    this.GoNameChemistry();
                    break;
                case 3:
                    this.GoChargeCredit();
                    break;
                case 4:
                    //musicPlay=new MusicPlay();
                    musicPlay.GoTo();
                    break;
                case 5:
                    return;
                default:
                    break;
            }
        }
    }
    public void GoNameChemistry() throws InterruptedException {
        NonRegistered nonRegistered=new NonRegistered();

        nameChemistry=new NameChemistry();
        if(isNonRegistered()){
            nonRegistered.Charge(nameChemistry.getPrice());
        }
        else{
            while(!customer.isUpdateBalance(nameChemistry.getPrice()));
        }
        nameChemistry.WelcomeNameChemistry();
    }
    public void GoChargeCredit(){
        NonRegistered nonRegistered=new NonRegistered();

        chargeCredit=new ChargeCredit(customer);
        if(isNonRegistered()) {
            nonRegistered.ChargingError();
        }
        else{
            chargeCredit.GoTo();
        }
    }

    //from~to까지 숫자를 입력 받아 리턴
    public int PickNum(int from, int to) {
        while (true) {
            System.out.print(">>  ");
            try {
                int num = sc.nextInt();
                if (num >= from && num <= to) {
                    return num;
                } else {
                    System.out.println("   잘못된 번호입니다. 다시 입력해주세요.");
                }
            } catch (Exception e) {
                System.out.println("   숫자를 입력해주세요.");
                sc.nextLine();
            }
        }
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
        System.out.println("          * ~.\"  *'~  *.'  -.*            ");
        System.out.println("        *.! " + message + " ..*!           ");
    }
    public void WaitABit() throws InterruptedException {
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(1000);
    }

    public boolean isNonRegistered(){
        return customer == null;
    }
}
