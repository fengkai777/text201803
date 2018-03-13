import java.util.Scanner;

public class textDay0703 {
    public static void main(String[] args) {
        display();
        input();
        display();
        isGameOver();
    }

    private static void isGameOver() {
        while (true){
            if (isWin()==3){
                isOx();
                input();
                display();
            }
            else
                isOver();
            break;
        }

    }

    private static void isOver() {
        switch (isWin()){
            case 0:
                System.out.println("win-win");
                break;
            case 1:
                System.out.println("O-win");
                break;
            case 2:
                System.out.println("X-win");
                break;
            default:
                break;
        }
    }

    private static void isOx() {
        Ox=!Ox;
    }

    static boolean isFull(){
        for (int i = 0; i <a.length; i++)
            for (int j = 0; j < a[i].length; j++)
                if (a[i][j]==0)
                    return false;
        return true;
    }
    static int isWin(){
        for (int i = 0; i < a.length; i++) {
            int r=a[0][i]&a[1][i]&a[2][i];
            if (r!=0)
                return r;
        }
        for (int i = 0; i < a.length; i++) {
            int r=a[i][0]&a[i][1]&a[i][2];
            if (r!=0)
                return r;
        }
        {
            int r=a[0][0]&a[1][1]&a[2][2];
            if (r!=0)
                return r;
        }
        {
            int r=a[2][0]&a[1][1]&a[0][2];
            if (r!=0)
                return r;
        }
        return isFull()?0:3;
    }

    private static int input() {
        System.out.printf("请%c输入下棋的位置：例(1 2)",Ox?'O':'X');
        int x=sc.nextInt();
        int y=sc.nextInt();
        return a[x][y]=Ox?1:2;
    }

    static int [] [] a=new int[3][3];
    static Scanner sc=new Scanner(System.in);
    static boolean Ox=false;

    private static void display() {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                switch (a[i][j]){
                    case 0:
                        System.out.print(". ");
                        break;
                    case 1:
                        System.out.print("O ");
                        break;
                    case 2:
                        System.out.print("X ");
                        break;
                }
            }
            System.out.println();
        }
        isGameOver();
    }
}
