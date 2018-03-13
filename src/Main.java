import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
      display();
      input();
      display();
      isGameOver();
    }

    //判断游戏是否结束
    private static void isGameOver() {
        while (true){
            if (isWin()==3){
                isO();
                input();
                display();
            }
            else
                inputWin();
            break;
        }
    }

    //输出输赢
    static void inputWin(){
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

    //判断输赢
    static int isWin(){
        for (int i = 0; i < a.length; i++) {
            int r=a[i][0]&a[i][1]&a[i][2];
            if (r!=0)
            return r;
        }
        for (int i = 0; i < a.length; i++) {
            int r=a[0][i]&a[1][i]&a[2][i];
            if (r!=0)
            return r;
        }
        {int r=a[0][0]&a[1][1]&a[2][2];
        if (r!=0)
            return r;}
        int r=a[0][2]&a[1][1]&a[2][0];
        if (r!=0)
            return r;
        return isfull()?0:3;
    }

    //判断棋盘满没满
    private static boolean isfull() {
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[i].length; j++)
                if (a[i][j] == 0)
                    return false;
        return true;
    }

    //下棋的位置
    private static void input() {
        Scanner sc=new Scanner(System.in);
        System.out.printf("请%C输入下棋的位置（例 1 2）：\n",OX?'O':'X');
        int x=sc.nextInt();
        int y=sc.nextInt();
        a[x][y]=OX?1:2;
    }

    //判断是第几个玩家
    static void isO(){
        OX=!OX;
    }

    static int [][] a=new int[3][3];
    static boolean OX=false;
    //显示棋盘
    private static void display() {
        for (int i = 0; i <a.length ; i++) {
            for (int j = 0; j < a[i].length; j++) {
                switch (a[i][j]){
                    case 0:
                        System.out.print(".");
                        break;
                    case 1:
                        System.out.print("O");
                        break;
                    case 2:
                        System.out.print("X");
                        break;
                }
            }
            System.out.println();
        }
        isGameOver();
    }
}
