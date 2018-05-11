package StudentManagement.myexception;

/**
 * @author Jiang Meng Ze
 * 自定义异常 用来提示没有学生
 * @date 2018/5/10 20:08
 */
public class NotHaveStudentException extends Exception{
    public NotHaveStudentException(String message){
        super(message);
    }
}
