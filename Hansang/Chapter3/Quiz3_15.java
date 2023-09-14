package Chapter3;

public class Quiz3_15 {
    public static void main(String[] args) {
        double[] raceTime = {0.1, 1.2, 3.45, 5.5, 7.3, 8.4, 9.9};
        double maxNum = 0;
        double minNum = raceTime[0];
        double range;

        for(int i = 0; i < raceTime.length; i++){
            if(raceTime[i] > maxNum){
                maxNum = raceTime[i];
            }else if(raceTime[i] < minNum){
                minNum = raceTime[i];
            }
        }
        range = maxNum - minNum;

        System.out.println(range);
    }
}
