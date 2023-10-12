package starcraft;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;
import starcraft.unit.*;
import starcraft.unit.zerg.*;
import starcraft.unit.terran.*;
import starcraft.unit.protos.*;

public class StarcraftExcute {
    static Scanner sc = new Scanner(System.in);

    static ArrayList<Unit> myUnitList;
    static ArrayList<Unit> computerUnitList;
    private static Brood selectBrood(){
         Brood userBrood = null;
        String userInput;

        while(Objects.isNull(userBrood)){
            System.out.println("Select your Brood : Terran (1), Protos (2), Zerg(3)");
            userInput = sc.nextLine();
            switch(userInput){
                case "0":
                    System.exit(0);
                    break;
                case "1":
                    userBrood = Brood.TERRAN;
                    break;
                case "2":
                    userBrood = Brood.PROTOS;
                    break;
                case "3":
                    userBrood = Brood.ZERG;
                    break;
                default:
                    System.out.println("Wrong Input. EXIT is 0\n");
            }
        }
        return userBrood;
    }

    private static Brood selectRandomBrood(){
        int random = (int)(Math.random()*3);

        if(random == 0)
            return Brood.ZERG;
         else if (random == 1)
            return Brood.TERRAN;
         else
            return Brood.PROTOS;
    }

    private static ArrayList<Unit> createRandomUnit(Brood userBrood) {
        ArrayList<Unit> unitList = new ArrayList<>();
        if(userBrood == Brood.ZERG) {
            for (int i = 0; i < 8; i++) {
                int randomNumber = (int) (Math.random() * 5);
                switch (randomNumber) {
                    case 0:
                        unitList.add(new Zergling());
                        break;
                    case 1:
                        unitList.add(new Hydralisk());
                        break;
                    case 2:
                        unitList.add(new Mutalisk());
                        break;
                    case 3:
                        unitList.add(new Ultralisk());
                        break;
                    case 4:
                        unitList.add(new Guardian());
                        break;
                }
            }
        }
        else if(userBrood == Brood.TERRAN) {
            for (int i = 0; i < 5; i++) {
                int randomNumber = (int) (Math.random() * 5);
                switch (randomNumber) {
                    case 0:
                        unitList.add(new Marine());
                        break;
                    case 1:
                        unitList.add(new Tank());
                        break;
                    case 2:
                        unitList.add(new Goliath());
                        break;
                    case 3:
                        unitList.add(new Wraith());
                        break;
                    case 4:
                        unitList.add(new Valkyrie());
                }
            }
        }
        else{
            for (int i = 0; i < 4; i++) {
                int randomNumber = (int)(Math.random()*5);
                switch (randomNumber){
                    case 0:
                        unitList.add(new Zealot());
                        break;
                    case 1:
                        unitList.add(new Dragoon());
                        break;
                    case 2:
                        unitList.add(new HighTempler());
                        break;
                    case 3:
                        unitList.add(new Scout());
                        break;
                    case 4:
                        unitList.add(new Corsair());
                        break;
                }
            }
        }
        return unitList;
    }

    private static void showUnitList(ArrayList<Unit> unitList){
        for (int i = 0; i < unitList.size(); i++) {
            System.out.println(i+". "+ unitList.get(i).getUnitName()+
                    " (현재 체력:"+unitList.get(i).getStamina()+"/"+
                    unitList.get(i).getDefaultStamina()+")");
        }
        System.out.println();
    }
    private static void attack() {
        System.out.print("아군 선택 : ");
        Unit choosenAlly = myUnitList.get(unitChoice(myUnitList));
        System.out.print("적군 선택 : ");
        int choosenEnemyInt =  unitChoice(computerUnitList);
        Unit choosenEnemy = computerUnitList.get(choosenEnemyInt);

        choosenAlly.attack(choosenEnemy);

        System.out.println(choosenAlly.getUnitName()+" : attack Power : "+choosenAlly.getAttackPower()+" -> "+
                choosenEnemy.getUnitName()+" : "+choosenEnemy.getStamina()+"/"+choosenEnemy.getDefaultStamina());

        if(choosenEnemy.getStamina() < 0){
            computerUnitList.remove(choosenEnemyInt);
        }
    }

    private static void computerAttack() {
        Unit choosenAlly = computerUnitList.get((int)(Math.random()* computerUnitList.size()));
        int choosenEnemyInt =  (int)(Math.random()* myUnitList.size());
        Unit choosenEnemy = myUnitList.get(choosenEnemyInt);

        choosenAlly.attack(choosenEnemy);

        System.out.println(choosenAlly.getUnitName()+" : attack Power : "+choosenAlly.getAttackPower()+" -> "+
                choosenEnemy.getUnitName()+" : "+choosenEnemy.getStamina()+"/"+choosenEnemy.getDefaultStamina());

        if(choosenEnemy.getStamina() <= 0){
            myUnitList.remove(choosenEnemyInt);
        }
    }

    private static int unitChoice(ArrayList<Unit> unitList) {
        while(true) {
            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("정수만 입력가능합니다.");
                continue;
            }
            if (choice > unitList.size() || choice < 0) {
                System.out.println("유닛 리스트에 포함되지 않은 정수입니다.");
                continue;
            }
            return choice;
        }
    }

    public static void main(String[] args) {
        Brood userBrood = selectBrood();
        Brood computerBrood = selectRandomBrood();

        myUnitList = createRandomUnit(userBrood);
        computerUnitList = createRandomUnit(computerBrood);

        while(true){
            System.out.println("적군 : "+computerBrood);
            showUnitList(computerUnitList);
            System.out.println("아군 : "+userBrood);
            showUnitList(myUnitList);
            System.out.println("공격을 수행할 아군 유닛과 적군 유닛을 선택하세요.");
            attack();
            computerAttack();

            if(computerUnitList.isEmpty() && myUnitList.isEmpty()){
                System.out.println("Draw!");
                break;
            }else if(computerUnitList.isEmpty()){
                System.out.println("User Win!");
                break;
            }else if(myUnitList.isEmpty()){
                System.out.println("Computer Win!");
                break;
            }
        }
    }
}
