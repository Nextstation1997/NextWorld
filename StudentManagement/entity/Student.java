package StudentManagement.entity;

/**
 * @author Jiang Meng Ze
 * @date 2018/5/10 19:28
 */
public class Student {
    //学生id
    private  int id;
    //学生姓名
    private  String name;
    //学生性别
    private  char sex;
    //学生数学成绩
    private  int mathScore;
    //学生语文成绩
    private  int chnScore;
    //学生英语成绩
    private  int engScore;
    //学生总成绩
    private  int total;
    //这里给学生id赋值写死 保证唯一性
    private static int count =1;
    //构造代码块
    {   //每次生成id都把id给+1 保证唯一性
        this.id = count++;
    }

    public Student() {}

    public Student(String name, char sex, int mathScore, int chnScore, int engScore) {
       //这里的带参构造器用set方法 进行约束
        this.setName(name);
        this.setSex(sex);
        this.setMathScore(mathScore);
        this.setChnScore(chnScore);
        this.setEngScore(engScore);
    }
    //set跟get方法
    public int getId() {
        return id;
    }
    /*  先注释掉 不用
        public void setId(int id) {
        this.id = id;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }
    //约束学生性别只能是男或女
    public void setSex(char sex) {
        if ('男'==sex||'女'==sex) {
            this.sex = sex;
            //这边如果是人妖那么就给他默认成男
        } else {
            sex='男';
        }
    }

    public int getMathScore() {
        return mathScore;
    }
    //约束学生成绩
    public void setMathScore(int mathScore) {
        //如果学生的数学成绩大于100或者小于0
        if (mathScore>100||mathScore<0) {
            //乱输成绩就默认赋值成0
            this.mathScore=0;
            //成绩输入没问题就正常赋值
        } else {
            this.mathScore = mathScore;
        }
        //总分在数学语文英语上都来一个 稳
        total=this.getMathScore()+this.getChnScore()+this.getEngScore();
    }

    public int getChnScore() {
        return chnScore;
    }
    //  约束学生成绩
    public void setChnScore(int chnScore) {
        //如果学生的数学成绩大于100或者小于0
        if (chnScore>100||chnScore<0) {
            //乱输成绩就默认赋值成0
            this.chnScore=0;
        } else {
            //成绩输入没问题就正常赋值
            this.chnScore = chnScore;
        }
        //总分在数学语文英语上都来一个 稳
        total=this.getMathScore()+this.getChnScore()+this.getEngScore();
    }

    public int getEngScore() {
        return engScore;
    }
    //约束学生成绩
    public void setEngScore(int engScore) {
        if (engScore>100||engScore<0) {
            //乱输成绩就默认赋值成0
            this.engScore =0;
        } else {
            //成绩输入没问题就正常赋值
            this.engScore = engScore;
        }
        //总分在数学语文英语上都来一个 稳
        total=this.getMathScore()+this.getChnScore()+this.getEngScore();
    }

    public int getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "学生信息{" + "学生id=" + id +", 姓名='" + name + '\'' + ", 性别=" + sex + ", 数学成绩=" + mathScore + ", 语文成绩=" + chnScore + ", 英语成绩=" + engScore + ", 总分=" + total + '}';
    }
}
