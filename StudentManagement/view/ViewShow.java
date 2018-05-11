package StudentManagement.view;

import StudentManagement.entity.Student;
import StudentManagement.mycompare.AscendingSortByTotalScore;
import StudentManagement.mycompare.DesendingSortByChnScore;
import StudentManagement.mycompare.DesendingSortByEngScore;
import StudentManagement.mycompare.DesendingSortByMathScore;
import StudentManagement.myexception.InvalidIDException;
import StudentManagement.myexception.NotHavaComparatorException;
import StudentManagement.myexception.NotHaveStudentException;
import StudentManagement.studentmanager.studentManager;

import java.util.Scanner;

/**
 * @author Jiang Meng Ze
 * 学生管理系统主界面 alpha版本
 * @date 2018/5/11 8:26
 */
public class ViewShow {
    public static void main(String[] args) throws NotHaveStudentException, InvalidIDException, NotHavaComparatorException {
        Student stu1 = new Student("宝骏", '男', 80, 80, 80);
        Student stu2 = new Student("赵鹏", '男', 70, 70, 70);
        Student stu3 = new Student("刘鹏飞", '男', 77, 77, 77);
        Student stu4 = new Student("程辉", '男', 88, 55, 76);
        Student stu5 = new Student("鹏战飞", '男', 84, 79, 100);
        //new一个学校容器 放学生
        studentManager manager = new studentManager("北京尚学堂");
        //把学生扔容器里
        manager.addStudent(stu1);
        manager.addStudent(stu2);
        manager.addStudent(stu3);
        manager.addStudent(stu4);
        manager.addStudent(stu5);
        //顶一个int类型的变量ID用来储存用户输入的学生id
        int id=0;
        //定义个布尔类型的flag变量 用来控制退出循环
        boolean flag=true;
        //定义个int类型的变量 用来存放用户输入的选择
        int choose =0;
        //new个扫描器 用来接收用户输入的选择
        Scanner sc=new Scanner(System.in);
        //搞个死循环 用来当界面
        while (flag) {
            System.out.println("欢迎来到" + manager.getClassName()+"学生管理系统alpha版本");
            System.out.println("1.查看所有学生" +
                    "\n2.添加学生信息" +
                    "\n3.根据ID查找学生信息" +
                    "\n4.根据ID修改学生信息" +
                    "\n5.根据ID删除学生信息" +
                    "\n6.按照总分升序排序" +
                    "\n7.按照数学成绩降序排序" +
                    "\n8.按照语文成绩降序排序" +
                    "\n9.按照英语成绩降序排序" +
                    "\n10.退出");

                choose=sc.nextInt();
                switch (choose){
                    case 1:
                        //向控制台输出容器里的所有内容
                        manager.showAllStudents();
                        break;
                    case 2:
                        //往容器里添加学生信息
                        System.out.println("请输入学生姓名");
                        String name=sc.next();
                        System.out.println("请输入学生性别 男/女");
                        char sex=sc.next().charAt(0);
                        System.out.println("请输入学生数学分数 0-100");
                        int mathScore=sc.nextInt();
                        System.out.println("请输入学生语文分数 0-100");
                        int chnScore=sc.nextInt();
                        System.out.println("请输入学生英语分数 0-100");
                        int engScore=sc.nextInt();
                        //把修改完的学生信息保存到容器里
                        Student stuToAdd=new Student(name,sex,mathScore, chnScore ,engScore );
                        manager.addStudent(stuToAdd);
                        break;
                    case 3:
                        System.out.println("请输入要查询的学生id");
                        id=sc.nextInt();
                        //调用包里的查询方法 根据id查
                        manager.showStudentInfoById(id);
                        break;
                    case 4:
                        //调用修改方法进行修改学生信息 根据id改
                        System.out.println("请输入要修改的学生id");
                        id=sc.nextInt();

                        manager.modifyStudentInfoById(id);
                        break;
                    case 5:
                        //调用删除方法进行删除学生信息 根据id删
                        System.out.println("请输入要删除的学生id");
                        id=sc.nextInt();

                        manager.deleteStudentById(id);
                        break;
                    case 6:
                        //调包 查总分 升序查
                        System.out.println("请输入要查询的学生id");
                       manager.selectSortUsingCompare(new AscendingSortByTotalScore());
                        break;
                    case 7:
                        //调包 查数学成绩 降序查
                        System.out.println("请输入要查询的学生id");
                        manager.quicksortUsingCompare(new DesendingSortByMathScore());
                        break;
                    case 8:
                        //调包 查语文成绩 降序查
                        System.out.println("请输入要查询的学生id");
                        manager.quicksortUsingCompare(new DesendingSortByChnScore());
                        break;
                    case 9:
                        //调包 查英语成绩 降序查
                        System.out.println("请输入要查询的学生id");
                       manager.quicksortUsingCompare(new DesendingSortByEngScore());
                        break;
                    case 10:
                        //退出按钮
                        flag=false;
                        System.out.println("您已退出北京尚学堂学生管理系统alpha版本 谢谢您的使用");
                        break;

                    default:
                        System.out.println("别乱敲 敲坏了要收钱的!");
                        break;
                }
        }
    }
}
