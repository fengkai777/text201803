import java.util.Scanner;

public class textSort {

    //自动0-100生成随机数组
    static void array(int[] a){
        for (int i = 0; i < a.length; i++) {
            a[i]=(int)(Math.random()*100);
        }
    }

    //接收一个数组
    static void getArray(int[] a){
        Scanner sc=new Scanner(System.in);
        for (int i = 0; i < a.length; i++) {
            System.out.printf("请输入第%d个数\n",(i+1));
            a[i]=sc.nextInt();
        }
    }

    //冒泡排序
    static void bulSort(int[] a){
        for (int i = 0; i < a.length-1; i++) {
            for (int j = 0; j < a.length-1-i; j++) {
                if (a[j]>a[j+1]){
                    int t=a[j];
                    a[j]=a[j+1];
                    a[j+1]=t;
                }
            }
        }
    }

    //直接插入排序
    static void insSort(int[] a){
        for (int i = 1; i < a.length; i++) {
            int t=a[i];
            int j=0;
            for ( j=i-1; j >=0&&a[j]>t ; j--)
                a[j+1]=a[j];
            a[j+1]=t;
        }
    }

    //二分查找
    static int binarySearch(int[] a,int n){
        int begin = 0;
        int end=a.length-1;

        while (begin<=end){
            int middle=(begin+end)/2;
            if (a[middle]==n)
                return middle;
            if (a[middle]<n)
                begin=middle+1;
            if (a[middle]>n)
                end=middle-1;
        }
        return -1;
    }

    //快速排序
    static int quickSort(int [] a,int begin,int end){
        int i=begin-1;
        int j=end;
        int key=a[end];
        while (true){
            while (a[++i]<key);
            while (i<j&&a[--j]>key);
            if(i==j){
                a[end]=a[i];
                a[i]=key;
                return i;
            }else {
                int t=a[j];
                a[j]=a[i];
                a[i]=t;
            }
        }
    }
    static void quickSortInternal(int[] a,int begin,int end){
        if (begin>=end)
            return;
        int position=quickSort(a,begin,end);
        quickSortInternal(a,begin,position-1);
        quickSortInternal(a,position+1,end);
    }
    static void quickSorts(int[] a){
        quickSortInternal(a,0,a.length-1);
    }

    //输出
    static void input(int a[]){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+"\t");
        }
    }


    public static void main(String[] args) {
        int [] arr= new int[10];
        //array(arr);             //生成随机数组
        //bulSort(arr);         //冒泡排序
        //insSort(arr);         //插入排序
        getArray(arr);        //控制台获取数组数组
        System.out.println(binarySearch(arr,30));     //二分查找
        //quickSorts(arr);        //快速排序
        input(arr);


    }
}
