public class textStudent {

    public static void main(String[] args) {
        Student zhangsan=new Student();
        zhangsan.stuName="张三";
        zhangsan.stuAge=18;
        zhangsan.stuSex=true;
        zhangsan.stuGrade=36;
        System.out.println(zhangsan.doHomework(1));
        zhangsan.learn();
    }
}
class Student{
    String stuName;
    int stuAge;
    boolean stuSex;
    int stuGrade;
    public void learn(){
        System.out.println(stuName+"正在认真听课！");
    }
    public String doHomework(int hour){
        return "现在是北京时间："+hour+"点,"+stuName+"正在写作业！";
    }
}
