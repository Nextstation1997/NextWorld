package StudentManagement.mycompare;

import StudentManagement.entity.Student;

import java.util.Comparator;

/**
 * @author Jiang Meng Ze
 * 比较器方法 按照数学成绩降序排列
 * @date 2018/5/11 8:08
 */
public class DesendingSortByMathScore implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Student s1= (Student) o1;
        Student s2= (Student) o2;
        return s2.getMathScore()-s1.getMathScore();
    }
}
