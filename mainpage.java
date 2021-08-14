import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class mainpage {
    public static void main(String args[]) {


        final int[] Time = {1};
        int getNumber;

        Table t = new Table();
        Score s = new Score();
        Timer countDown = new Timer();

        TimerTask timeOver = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Time Over");
                Time[0] = 0;
                System.out.println("SCORE ::: " + s.GameScore);
                s.checkHighScore();
            }
        };

        countDown.schedule(timeOver, 60000);
        System.out.println("Game Start");

        while (Time[0] == 1) {
            int confirm = 0;
            t.makeTable();
            //s.changeRoundScore(1);
            t.printTable();

            while (confirm == 0 && Time[0] == 1) {
                Scanner sc = new Scanner(System.in);
                getNumber = sc.nextInt();
                if (Time[0] == 0) break;
                /*
                if (getNumber == 0) confirm = 1;    //0입력시 채점
                else t.changeTable(getNumber - 1);
                */
                t.changeTable(getNumber - 1);
                if (t.checkTable(1) == 1) {
                    confirm = 1;
                }
                t.printTable();
            }

            s.changeGameScore(t.checkTable(1));
        }
    }
}

class Table {
    Random r = new Random();
    int [][] table;
    int size = 3;
    int TableScore;

    void makeTable(){
        table = new int[size][size];
        for(int i = 0; i < size; i++){
            for(int k = 0; k < size; k++){
                table[i][k] = r.nextInt(2);
            }
        }
    }

    void printTable(){
        for(int i = 0; i < size; i++){
            for(int k = 0; k < size; k++){
                System.out.print(table[i][k]);
            }
            System.out.println();
        }
    }

    void changeTable(int getNumber){
        if (getNumber + 1 > size * size) System.out.println("wrong number");
        else if (getNumber <= 0) System.out.println("wrong number");
        else if (table[getNumber / size][getNumber % size] == 0) table[getNumber / size][getNumber % size] = 1;
        else if(table[getNumber / size][getNumber % size] == 1) table[getNumber / size][getNumber % size] = 0;


    }

    /*int checkTableScore(){
        TableScore = 0;
        for(int i = 0; i < size; i++){
            for(int k = 0; k < size; k++){
                if (table[i][k] != 0) {
                    TableScore++;
                }
            }
        }
        return TableScore;
    }*/

    int checkTable(int roundScore){
        for(int i = 0; i < size; i++){
            for(int k = 0; k < size; k++){
                if (table[i][k] != table[0][0]) {
                    return 0;  //틀린게 있을시 반영될 점수
                }
            }
        }
        return roundScore;  //맞았을경우 반영될 점수
    }
}

class Score{
    //int RoundScore = 0; //해당 테이블의 기대 점수
    int GameScore = 0; //해당 게임의 점수
    int HighScore = 0; //최고 게임점수

    /*void changeRoundScore(int score){
        RoundScore = score;
    }*/

    void changeGameScore(int getScore){
        GameScore = GameScore + getScore;
    }

    void checkHighScore(){
        if (HighScore < GameScore){
            HighScore = GameScore;
            System.out.println("New High Score");
        }
    }
}