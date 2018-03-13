import java.util.Scanner;

public class textDay0702 {
    public static void main(String[] args) {
        input();
        output();
    }
    static int year,month;
    private static void input() {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入年份：");
         year=sc.nextInt();
        System.out.println("请输入月份：");
         month=sc.nextInt();
    }

    private static void output() {
        if(month==0)
            print(year);
        else
            print(year,month);
    }
    static void print(int year){
        for (int i = 1; i <= 12; i++) {
            print(year,i);
        }
    }
    static void print(int year,int month){
        System.out.printf("\n%d年%d月\n",year,month);
        System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat");
        int weekday=weekDay(year,month,1);
        for (int i = 0; i < weekday; i++) {
            System.out.print("\t");
        }
        int lastday=days(year,month);
        for (int i = 1; i <= lastday; i++) {
            System.out.print(i+"\t");

        if (weekDay(year,month,i)==6)
            System.out.println();
        }
    }
    static int weekDay(int year,int month,int day){
        int days=0;
        for (int i = 1; i < year; i++) {
            days+=days(i);
        }
        for (int i = 1; i < month; i++) {
            days+=days(year,i);
        }
        days+=day-1;
        return (days+1)%7;
    }
    static int days(int year,int month){
        switch (month){
            case 1:case 3:case 5:case 7:case 8:case 10:case 12:
                return 31;
            case 4:case 6:case 9:case 11:
                return 30;
            case 2:
                return prime(year)?29:28;
        }
        return 0;
    }
    static int days(int year){
        return prime(year)?366:365;
    }
    static boolean prime(int year){
        return year%4==0&&year%100!=0||year%400==0;
    }
}
