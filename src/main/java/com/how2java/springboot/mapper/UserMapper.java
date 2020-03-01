package com.how2java.springboot.mapper;
import com.how2java.springboot.entity.*;
import com.how2java.springboot.webentity.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserMapper {

    @Select("select Sno from student where Susername = #{Uname} and Spassword = #{Upassword}")
    String findById(@Param("Uname") String u, @Param("Upassword") String p);

    @Select("select Sno,Sname,Sclass,Sgender,Sbirth,Semail,Stel from student where Sno = #{Sno}")
    Student student(@Param("Sno") String username);

    @Select("select * from teacher where Tno = #{Tno}")
    Teacher teacher(@Param("Tno") String username);

    @Update("update student set Spassword = #{newpassword} where Susername = #{Uname} and Spassword = #{Upassword}")
    Integer xiugai(@Param("Uname") String username, @Param("Upassword") String password, @Param("newpassword") String newpassword);

    @Update("update student set Sname = #{student.sname} , Sclass = #{student.sclass} , Sgender = #{student.sgender} , Sbirth = #{student.sbirth} , Semail = #{student.semail} , Stel = #{student.stel} where Sno = #{student.sno}")
    Integer setperson(@Param("student") Student student);

//        @Select("select project.Kno,project.Kname,teacher.*,project.Kstatus,project.Kclass from project,teacher where project.Tno=teacher.Tno")
    @Select("select Kno,Kname,Tno,Kstatus,Kclass from course where Kclass = #{kclass} limit #{laststart},#{start}")
    @Results({
            @Result(id = true,column = "Kno",property = "kno"),
            @Result(column = "Kname",property = "kname"),
            @Result(column = "Tno",property = "teacher",one = @One(select = "com.how2java.springboot.mapper.UserMapper.getTeacher",fetchType = FetchType.EAGER)),
            @Result(column = "Kstatus",property = "kstatus"),
            @Result(column = "Kclass",property = "kclass")
    })
    List<Course> FindProject(@Param("kclass") String kclass, @Param("start")int start, @Param("laststart")int laststart);

    @Select("select * from teacher where Tno = #{Tno}")
    Teacher getTeacher(String Tno);
    @Select("select Kcontent,Ktarget from course where Kno = #{Kno}")
    Kdetail content(String Kno);
    @Select("select * from voluntary where Sno = #{sno} ")
    Voluntary serchVoluntary(String sno);
    @Update("update voluntary set Kno1 = #{voluntary.kno1}  , Kno2 = #{voluntary.kno2}  , Kno3 = #{voluntary.kno3}  , Kno4 = #{voluntary.kno4} , Kno5 = #{voluntary.kno5} where Sno = #{voluntary.sno}")
    Integer addvoluntary(@Param("voluntary") Voluntary voluntary);

    @Select("select Kno,Kname,Tno,Kstatus,Kclass from course where Kno = #{kno}")
    @Results({
            @Result(id = true,column = "Kno",property = "kno"),
            @Result(column = "Kname",property = "kname"),
            @Result(column = "Tno",property = "teacher",one = @One(select = "com.how2java.springboot.mapper.UserMapper.getTeacher",fetchType = FetchType.EAGER)),
            @Result(column = "Kstatus",property = "kstatus"),
            @Result(column = "Kclass",property = "kclass")
    })
    Course lookvoluntary(@Param("kno")String kno);

    @Update("update voluntary set Kno1 = #{voluntary.kno1}  , Kno2 = #{voluntary.kno2}  , Kno3 = #{voluntary.kno3}  , Kno4 = #{voluntary.kno4} , Kno5 = #{voluntary.kno5} where Sno = #{voluntary.sno}")
    Integer deletevoluntary(@Param("voluntary")Voluntary voluntary);
    @Select("select Kno,Kname,Tno,Kstatus,Kclass from course where Kclass = #{kclass} and Ktype = #{type} limit #{laststart},#{start}")
    @Results({
            @Result(id = true,column = "Kno",property = "kno"),
            @Result(column = "Kname",property = "kname"),
            @Result(column = "Tno",property = "teacher",one = @One(select = "com.how2java.springboot.mapper.UserMapper.getTeacher",fetchType = FetchType.EAGER)),
            @Result(column = "Kstatus",property = "kstatus"),
            @Result(column = "Kclass",property = "kclass")
    })
    List<Course> FindProject2(@Param("kclass") String kclass, @Param("start")int start, @Param("laststart")int laststart, @Param("type") String type);

    @Insert("insert into message(Sno,Smessage) values ( #{sno} , #{message} )")
    Integer savaMessage(@Param("sno") String sno, @Param("message") String message);
    @Select("select * from voluntary")
    List<Voluntary> getVoluntary();
    @Select("select Kstatus from course where Kno = #{kno}")
    String getState(@Param("kno") String kno);

    @Update("update course set Kstatus = 'yes' where Kno = #{kno}")
    Integer setState(@Param("kno")String kno);

    @Update("update course_result set State = #{state} , Sno = #{sno} where Kno = #{kno} ")
    Integer setresult(@Param("sno")String sno, @Param("kno")String kno, @Param("state")String state);
    @Select("select Kno from course_result where Sno = #{sno}")
    String getresult(@Param("sno")String sno);

    @Select("select Kname,Tno,Kcontent,Ktarget from course where Kno = #{kno} ")
    @Results({
            @Result(column = "Kname",property = "kname"),
            @Result(column = "Tno",property = "teacher",one = @One(select = "com.how2java.springboot.mapper.UserMapper.getTeacher",fetchType = FetchType.EAGER)),
            @Result(column = "Kcontent",property = "kcontent"),
            @Result(column = "Ktarget",property = "ktarget")
    })
    CourseResult courseres(@Param("kno")String kno);


    @Select("select Kno from course_result where Sno = #{sno}")
    String getup(@Param("sno")String sno);
    @Insert("insert into course_exit (Sno,Kno,Message) values ( #{sno} , #{kno} , #{message})")
    Integer savarequest(@Param("sno")String sno, @Param("kno")String kno,@Param("message") String message);
    //课程增删改查
    @Select("select * from course")
    List<FullCourse> Courses();
    @Insert("insert into course (Kno,Kname,Tno,Kstatus,Kclass,Kcontent,Ktarget,Ktype) values (#{c.kno},#{c.kname},#{c.kno},#{c.kstatus},#{kclass},#{kcontent},#{ktarget},#{ktype})")
    Integer PostCourse(@Param("c") FullCourse c);
    @Update("update course set Kno = #{c.kno},Kname = #{c.kname},Tno = #{c.tno},Kstatus = #{c.kstatus},Kclass = #{c.kclass},Kcontent = #{c.kcontent},Ktarget = #{c.tkarget},Ktype = #{c.ktype}")
    Integer PutCourse(@Param("c")FullCourse c);

    @Delete("delete from course where Kno = # {kno}")
    Integer DeleteCourse(@Param("kno")String kno);
    //志愿单查询
    @Select("select Sno ,Kno1,Kno2,Kno3,Kno4,Kno5 from voluntary")
    @Results({
            @Result(column = "Sno",property = "sname",one = @One(select = "com.how2java.springboot.mapper.UserMapper.GetStudentName",fetchType = FetchType.EAGER)),
            @Result(column = "Kno1",property = "kname1",one = @One(select = "com.how2java.springboot.mapper.UserMapper.GetKname",fetchType = FetchType.EAGER)),
            @Result(column = "Kno2",property = "kname2",one = @One(select = "com.how2java.springboot.mapper.UserMapper.GetKname",fetchType = FetchType.EAGER)),
            @Result(column = "Kno3",property = "kname3",one = @One(select = "com.how2java.springboot.mapper.UserMapper.GetKname",fetchType = FetchType.EAGER)),
            @Result(column = "Kno4",property = "kname4",one = @One(select = "com.how2java.springboot.mapper.UserMapper.GetKname",fetchType = FetchType.EAGER)),
            @Result(column = "Kno5",property = "kname5",one = @One(select = "com.how2java.springboot.mapper.UserMapper.GetKname",fetchType = FetchType.EAGER))
    })
    List<Voluntaries> GetVoluntary();
    @Select("select Sname from student where Sno = #{Sno} ")
    String GetStudentName(@Param("Sno") String Sno);
    @Select("select Kname from course where Kno = #{Kno} ")
    String GetKname(@Param("Kno") String Kno);

    //学生管理
    @Select("select * from student")
    List<FullStudent> GetStudents();

    @Insert("insert into student (Sno,Sname,Sclass,Sgender,Sbirth,Semail,Stel,Susername,Spassword) values (#{student.sno},#{student.sname},#{student.sclass},#{student.sgender},#{student.sbirth},#{student.semail},#{student.stel},#{student.susername},#{student.spassword})")
    Integer PostStudent(@Param("student")FullStudent student);

    @Update("update student set Sno = # {student.sno},Sname = # {student.sname},Sclass = # {student.sclass},Sgender = # {student.sgender},Sbirth = # {student.sbirth},Semail = # {student.semail},Stel = # {student.stel},Susername = # {student.susername},Spassword = # {student.spassword}")
    Integer PutStudent(@Param("student")FullStudent student);

    @Delete("delete from student where Sno = #{sno}")
    Integer DeleteStudent(@Param("sno") String sno);
    //教师管理
    @Select("select * from teacher")
    List<Teacher> GetTeachers();
    @Insert("insert into teacher (Tno,Tname,Tsex,Ttle,Temail,Ttitle ) values (#{teacher.tno},#{teacher.tname},#{teacher.tsex},#{teacher.ttle},#{teacher.temail},#{teacher.ttitle})")
    Integer PostTeacher(@Param("teacher")Teacher teacher);
    @Update("update teacher set Tno = # {teacher.tno},Tname = # {teacher.tname},Tsex = # {teacher.tsex},Ttle = # {teacher.ttle},Temail = # {teacher.temail},Ttitle = # {teacher.ttitle}")
    Integer PutTeacher(@Param("teacher")Teacher teacher);
    @Delete("delete from teacher where Tno = #{tno}")
    Integer DeleteTeacher(@Param("tno")String tno);

    //查看留言信息
    @Select("select Sno,Smessage from message")
    @Results({
            @Result(column = "Sno",property = "sno"),
            @Result(column = "Sno",property = "sname",one = @One(select = "com.how2java.springboot.mapper.UserMapper.GetStudentName",fetchType = FetchType.EAGER)),
            @Result(column = "Smessage",property = "smessage")
    })
    List<Message_Online> GetMessages();

    //查看选课结果
    @Select("select Kno,State,Sno from course_result")
    @Results({
            @Result(column = "Kno",property = "kno"),
            @Result(column = "Kno",property = "kname",one = @One(select = "com.how2java.springboot.mapper.UserMapper.GetKname",fetchType = FetchType.EAGER)),
            @Result(column = "State",property = "state"),
            @Result(column = "Sno",property = "sno"),
            @Result(column = "Sno",property = "sname",one = @One(select = "com.how2java.springboot.mapper.UserMapper.GetStudentName",fetchType = FetchType.EAGER))
    })
    List<ResultCourse> GetResults();
    @Select("select Sno,Kno,Message from course_exit")
    @Results({
            @Result(column = "Sno",property = "sno"),
            @Result(column = "Sno",property = "sname",one = @One(select = "com.how2java.springboot.mapper.UserMapper.GetStudentName",fetchType = FetchType.EAGER)),
            @Result(column = "Kno",property = "kno"),
            @Result(column = "Kno",property = "kname",one = @One(select = "com.how2java.springboot.mapper.UserMapper.GetKname",fetchType = FetchType.EAGER)),
            @Result(column = "Message",property = "message")
    })
    List<Message_exit> GetExits();

    @Update("update course_result set State = Null ,Sno = Null where Kno = #{kno}")
    Integer putResult(@Param("kno")String kno);
    @Update("update course set Kstatus = '未选中' where Kno=#{kno}")
    Integer putCourseStatus(@Param("kno")String kno);
    @Delete("delete from course_exit where Kno = #{kno}")
    Integer deleteExitMessage(@Param("kno")String kno);
}
