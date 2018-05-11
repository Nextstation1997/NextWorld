package StudentManagement.mycompare;

import StudentManagement.entity.Student;

import java.util.Comparator;

/**
 * @author Jiang Meng Ze
 *比较器方法  实现了根据学生总分的升序排序
 * @date 2018/5/10 21:55
 */
public class AscendingSortByTotalScore implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Student s1=(Student) o1;
        Student s2= (Student) o2;
        return s1.getTotal()-s2.getTotal();
    }
}
