import com.test.dao.*;
import com.test.model.*;
import com.test.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.io.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * Created by 张宏浩 on 2017/2/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-*.xml"})
public class TestUser {



    @Resource
    private SchoolMapper schoolMapper;

    @Resource
    private AcademyMapper academyMapper;

    @Resource
    private GradeMapper gradeMapper;

    @Resource
    private TbClassMapper classMapper;

    @Resource
    private CourseMapper courseMapper;

    @Resource
    private TeacherMapper teacherMapper;

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private TbClassService tbClassService;

    @Autowired
    private TeacherService teacherService;




    @Test
    public void selectBySchoolName(){
        School school = new School();
        school =schoolMapper.selectBySchoolName("湖北工业大学");
        System.out.println(school.getId());
    }

    @Test
    public void selectByAcademy(){
        Academy academy = new Academy();
        academy = academyMapper.selectByIdAndName("计算机学院",1);
        System.out.println(academy.getId());
    }

    @Test
    public void selectByGrade(){
        Grade grade = new Grade();
        grade = gradeMapper.selectByIdAndName("13级",1);
        System.out.println(grade.getId());
    }

    @Test
    public void selectByTbClass(){
        TbClass tbClass = new TbClass();
        tbClass = classMapper.selectByIdAndName("网络2班",1);
        System.out.println(tbClass.getId());
    }

    @Test
    public void insertStudent(){
        studentService.insert("C:\\Users\\张宏浩\\Desktop\\student.xlsx");
    }

    @Test
    public void listOfStudent(){
        List<Student> list = new ArrayList<Student>();
        list = studentService.list();
        System.out.println(list);
    }

    @Test
    public void getByNumber(){
        Student student = studentService.getByNumber("1234");
        System.out.println(student);
    }

    //根据班级id 查询所有的课程
    @Test
    public void getByClassId(){
        System.out.println(tbClassService.getById(4));
        System.out.println(courseService.listByClassId(1));
    }

    @Test
    public void insertClass(){
        TbClass tbClass = new TbClass();
        tbClass.setGradeId(1);
        tbClass.setClaName("数字媒体1班");
        tbClass.setIntroducation("总计36名学生");
        tbClass.setGmtCreate(new Date());
        System.out.println(tbClassService.insertClass(tbClass));
    }

    @Test
    public void insertCourse(){
        Course course = new Course();
        course.setCourseName("离散数学");
        course.setCourseTime("1-8周");
        course.setTeacherName("刘凯");
        System.out.println(courseMapper.insertSelective(course));
        System.out.println(course.getId());
    }

    @Test
    public void getTeacherByNumber(){
        Teacher teacher = new Teacher();
        teacher = teacherService.getByNumber("20100001");
        System.out.println(teacher);
    }


    //根据关键字查找
    @Test
    public void listByKeyword(){
        System.out.println(classMapper.listByKeyword("12"));
    }

    @Test
    public void count(){
        String keyword = "";
        System.out.println(studentService.getCount(1,keyword));
    }

    @Test
    public void list(){
        System.out.println(studentService.listForClassId(1));
    }

    //读取properties文件
    @Test
    public void properties() throws IOException {
       Properties p = new Properties();
       InputStream in = TestUser.class.getResourceAsStream("/password.properties");
       p.load(in);
       in.close();
       System.out.println(p.getProperty("password"));
    }
}
