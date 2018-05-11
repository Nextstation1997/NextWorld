package StudentManagement.studentmanager;

import StudentManagement.entity.Student;
import StudentManagement.myexception.InvalidIDException;
import StudentManagement.myexception.NotHavaComparatorException;
import StudentManagement.myexception.NotHaveStudentException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author Jiang Meng Ze
 * 工具包 用来被调用的
 * @date 2018/5/10 19:58
 */
public class studentManager {
    private String className;

    public String getClassName() {
        return className;
    }

    //new个容器 用来放学生信息用的
    private ArrayList allStus= new ArrayList();

    public studentManager() {}

    public studentManager(String className) {
        this.className = className;
    }
    /*
    * 增 删 改 查 排序 展示
    * */

    //展示所有的学生信息
    public void showAllStudents(){
        for (Object object:allStus) {
            System.out.println(object);
        }
    }

    //往容器里增加学生信息
    public  void addStudent(Student stuToAdd) throws NotHaveStudentException {
        //自定义异常  学生信息无效 抛出异常
        if (null == stuToAdd){
            throw new NotHaveStudentException("没有学生信息");
        }//如果学生信息输入有效 那么就添加到容器里
        allStus.add(stuToAdd);
    }

    //在形参里输入学生id就可以把这个学生信息从容器里删除
    public void  deleteStudentById(int id) throws InvalidIDException {
        //先调用他下面的方法用来找id
        Student stu=findStudentById(id);
        //如果找到的id不为空 那么删除这个id对应的学生信息
        if (stu!=null){
            allStus.remove(stu);
            //如果找到的id为空 那么打印一句话 没有这个学生
        }else {
            System.out.println("没有这个学生");
        }
    }
    //展示学生的方法
    public void showStudentInfoById(int id) throws InvalidIDException {
        //先调用查找方法找学生
        Student stu=findStudentById(id);
        //判断 如果找到了学生 那么返回这个学生的信息 否则打印查无此人
        if (stu!=null){
            System.out.println(stu);
        }else {
            System.out.println("查无此人");
        }
    }


    //公开方法 用来给学生排序
   public void selectSortUsingCompare(Comparator com) throws NotHavaComparatorException {
        //如果com是空
       if(null ==com){
            throw new NotHavaComparatorException("比较器不存在!!");
       }
       //new一个数组 数组长度是容器大小的长度
       Student[] sortArray =new Student[allStus.size()];
       //for循环 遍历数组
       for (int i = 0; i <allStus.size() ; i++) {
           //把容器里的数据拿出来放到上面new出来的数组里用来做排序 这边进行了一个强制类型转换
            sortArray[i]= (Student) allStus.get(i);
       }
       //控制排序的次数
       for (int i = 0; i <sortArray.length-1 ; i++) {
           //声明一个int类型的索引
           int index=i;
           //接着一个for循环遍历数组 遍历到数组的最后一位
           for (int j = i+1; j <sortArray.length ; j++) {
                //进行一个判断 调用比较器方法 判断的啥没看明白
               if(com.compare(sortArray[index],sortArray[j])>0){
                    index = j;
                }
           }
           //这边判断一哈 用来交换数据
           if(index !=i){
                Student temp=sortArray[i];
                sortArray[i]=sortArray[index];
                sortArray[index]=temp;
           }
       }
       //调用一个展示学生信息的方法用来打印排序后的学生信息
       showSortResult(sortArray);

   }

   // 比较器 用快速(调包)排序进行
   public void quicksortUsingCompare(Comparator com) throws NotHavaComparatorException {
        if (null==com){
            throw new NotHavaComparatorException("比较器不存在");
        }
       //new一个数组 数组长度是容器大小的长度
       Student[] sortArray =new Student[allStus.size()];
       //for循环 遍历数组
       for (int i = 0; i <allStus.size() ; i++) {
           //把容器里的数据拿出来放到上面new出来的数组里用来做排序 这边进行了一个强制类型转换
           sortArray[i]= (Student) allStus.get(i);
       }
       //调包使我快乐
       Arrays.sort(sortArray,com);
       showSortResult(sortArray);
   }


    //私有化方法 提供类内使用id查询对应的学生信息的方法
    private  Student findStudentById(int id) throws InvalidIDException {


        //一开始判断 如果id等于0 那么抛出个异常
        if (id<=0){
            throw  new InvalidIDException("ID不合法");
        }//这边加强for循环用来遍历容器找id
        for (Object object:allStus) {
            Student stu=(Student)object;
            //如果找到了 那么返回id
            if (stu.getId()==id){
                return stu;
            }
        }
        //压根没找到 返回null
        return null;
    }

    //用来修改学生信息
    public void modifyStudentInfoById(int id) throws InvalidIDException {
        //还是先用上面那个查询的方法找学生信息
        Student stu =findStudentById(id);
        //接着判断是不是有这个学生
        if (null==stu) {
            System.out.println("查无此人");
            return;
        }
        //定义一个布尔类型的变量flag 用来标记
        boolean flag=true;
        //new个扫描器用来接收用户输入的信息 来进行判断修改啥
        Scanner sc= new Scanner(System.in);
        System.out.println("请输入要修改的ID");
        int choose =sc.nextInt();
        //用while来个死循环
        while(flag){
            System.out.println("修改"+stu.getName()+"的信息");
            System.out.println("ID:"+stu.getId()+"sex:"+stu.getSex());
            System.out.println("数学成绩:"+stu.getMathScore()+"语文成绩:"+stu.getChnScore()+"英语成绩:"+stu.getEngScore());
            System.out.println("总成绩:"+stu.getTotal());

            System.out.println("1.修改姓名" +
                                "\n2.修改性别" +
                                "\n3.修改数学成绩" +
                                "\n4.修改语文成绩"+
                                "\n5.修改英语成绩"+
                                "\n6.退出");
            //用来接收用户输入的选择
            choose=sc.nextInt();
            //根据用户输入的选择进行对应的操作
            switch (choose){
                case 1:
                    System.out.println("请输入姓名");
                    stu.setName(sc.next());
                    break;
                case 2:
                    System.out.println("请输入性别");
                    stu.setSex(sc.next().charAt(0));
                    break;
                case 3:
                    System.out.println("请输入数学成绩");
                    stu.setMathScore(sc.nextInt());
                    break;
                case 4:
                    System.out.println("请输入语文成绩");
                    stu.setChnScore(sc.nextInt());
                    break;
                case 5:
                    System.out.println("请输入英语成绩");
                    stu.setEngScore(sc.nextInt());
                    break;
                case 6:
                    flag=false;
                    System.out.println("保存退出");
                    break;
                 default:
                     System.out.println("别乱敲 敲坏了要赔钱的");
                     break;
            }

        }
    }

    //私有化 提供类内方法用来展示排序后的方法
    private  void showSortResult(Student[] sortArray){
        for (Student student:sortArray) {
            System.out.println(student);
        }

    }




}
