package Menu.NameChemistry;

import Menu.Menu;

import java.text.Normalizer;
import java.util.Scanner;
import java.util.regex.Pattern;

public class NameChemistry extends Menu {
    Scanner sc=new Scanner(System.in);

    int nameNum;
    String[] name=new String[3];
    int value=0;

    public NameChemistry(){
        name[0]="";
    }

    public void WelcomeNameChemistry() throws InterruptedException {
        System.out.println("---------------------------------------");
        System.out.println("      *.! 이름 궁합을 보고 싶나요? ..*!      ");
        System.out.println("         * ~.\"  *'~  *.'  -.*         ");
        System.out.println();
        this.PickName(1);
        this.PickName(2);
        this.CalculateResult();
        this.Loading();
        this.PrintNameChemistry();
        //System.out.println("---------------------------------------");
    }

    public boolean isValid(String name){
        return Pattern.matches("^[가-힣]*$", name);
    }
    public void PickName(int idx){
        String[] idxKor={"","첫","두"};

        System.out.println("  *.! " + idxKor[idx] + " 번째 이름을 한글로 입력해주세요 ..*!   ");
        System.out.print(">> ");
        String name=sc.next();
        if(!isValid(name)){
            System.out.println("   잘못된 형식 입니다. 다시 입력해주세요.");
            this.PickName(idx);
        }
        this.name[idx]=name;
    }

    public void PrintNameChemistry() throws InterruptedException {
        this.PrintMessage("이름 궁합 결과를 확인하세요!");
        System.out.println("               " + this.value + "%      ");
        this.WaitABit();
    }


    public void CalculateResult(){
        int[] nameList=new int[name[1].length()+name[2].length()];
        if(name[1].length() < name[2].length()){
            String tmp=name[2];
            name[2]=name[1];
            name[1]=tmp;
        }

        //글자별 획순 계산
        for(int i=0;i<name[1].length();i++) {
            nameList[i*2] = CalculateNum(String.valueOf(name[1].charAt(i)));
            nameList[i*2+1] = CalculateNum(String.valueOf(name[2].charAt(i)));
        }
        int lastIdx=name[1].length()*2;
        for(int i=name[1].length();i<name[2].length();i++){
            nameList[lastIdx++]=CalculateNum(String.valueOf(name[2].charAt(i)));
        }

        //더하기 계산
        for(int step=1;step<=nameList.length-2;step++){
            for(int i=0;i<nameList.length-step;i++) {
                nameList[i] = (nameList[i] + nameList[i + 1])%10;
            }
        }

        this.value = nameList[0]*10+nameList[1];
    }
    public int CalculateNum(String nameAt) {
        int[] jaeum={2,4,2,3,6,5,4,4,8,2,4,1,3,6,4,3,4,4,3};
        int[] moeum={2,3,3,4,2,3,3,4,2,4,5,3,3,2,4,5,3,3,1,2,1};
        int[] batchim={2,4,4,2,5,5,3,5,7,9,9,7,9,9,8,4,4,6,2,4,1,3,4,3,4,4,3};

        int num=0;
        String nfd = Normalizer.normalize(nameAt, Normalizer.Form.NFD);
        for (int idx = 0; idx < nfd.length(); idx++) {
            int hangeulIdx = nfd.codePointAt(idx);
            if (hangeulIdx >= 4352 && hangeulIdx <= 4370) {
                num += jaeum[hangeulIdx - 4352];
            }
            else if (hangeulIdx >= 4449 && hangeulIdx <= 4469) {
                num += moeum[hangeulIdx - 4449];
            }
            else if (hangeulIdx >= 4520 && hangeulIdx <= 4546) {
                num += batchim[hangeulIdx - 4520];
            }
            else {
                num += -1;
            }
        }
        return num;
    }
}
