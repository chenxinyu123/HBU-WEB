package com.how2java.springboot.mapper;
import com.how2java.springboot.entity.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserMapper {

    @Select("select * from user where Uname = #{Uname} and Upassword = #{Upassword}")
    User findById(@Param("Uname") String u, @Param("Upassword") String p);

    @Select("select * from student where Sno = #{Sno}")
    Student student(@Param("Sno") String username);

    @Select("select * from teacher where Tno = #{Tno}")
    Teacher teacher(@Param("Tno") String username);

    @Update("update pass set Upassword = #{newpassword} where Uname = #{Uname} and Upassword = #{Upassword}")
    Integer xiugai(@Param("Uname") String username, @Param("Upassword") String password, @Param("newpassword") String newpassword);

    @Update("update student set Sname = #{student.sname} , Sclass = #{student.sclass} , Sgender = #{student.sgender} , Sbirth = #{student.sbirth} , Semail = #{student.semail} , Stel = #{student.stel} where Sno = #{student.sno}")
    Integer setperson(@Param("student") Student student);

//        @Select("select project.Kno,project.Kname,teacher.*,project.Kstatus,project.Kclass from project,teacher where project.Tno=teacher.Tno")
    @Select("select Kno,Kname,Tno,Kstatus,Kclass from project where Kclass = #{kclass} limit #{laststart},#{start}")
    @Results({
            @Result(id = true,column = "Kno",property = "kno"),
            @Result(column = "Kname",property = "kname"),
            @Result(column = "Tno",property = "teacher",one = @One(select = "com.how2java.springboot.mapper.UserMapper.getTeacher",fetchType = FetchType.EAGER)),
            @Result(column = "Kstatus",property = "kstatus"),
            @Result(column = "Kclass",property = "kclass")
    })
    List<FindProject> FindProject(@Param("kclass") String kclass,@Param("start")int start,@Param("laststart")int laststart);

    @Select("select * from teacher where Tno = #{Tno}")
    Teacher getTeacher(String Tno);
    @Select("select Kcontent,Ktarget from project where Kno = #{Kno}")
    Kdetail content(String Kno);
    @Select("select * from voluntary where Sno = #{sno} ")
    Voluntary serchVoluntary(String sno);
    @Update("update voluntary set Kno1 = #{voluntary.kno1}  , Kno2 = #{voluntary.kno2}  , Kno3 = #{voluntary.kno3}  , Kno4 = #{voluntary.kno4} , Kno5 = #{voluntary.kno5} where Sno = #{voluntary.sno}")
    Integer addvoluntary(@Param("voluntary") Voluntary voluntary);

    @Select("select Kno,Kname,Tno,Kstatus,Kclass from project where Kno = #{kno}")
    @Results({
            @Result(id = true,column = "Kno",property = "kno"),
            @Result(column = "Kname",property = "kname"),
            @Result(column = "Tno",property = "teacher",one = @One(select = "com.how2java.springboot.mapper.UserMapper.getTeacher",fetchType = FetchType.EAGER)),
            @Result(column = "Kstatus",property = "kstatus"),
            @Result(column = "Kclass",property = "kclass")
    })
    FindProject lookvoluntary(@Param("kno")String kno);

    @Update("update voluntary set Kno1 = #{voluntary.kno1}  , Kno2 = #{voluntary.kno2}  , Kno3 = #{voluntary.kno3}  , Kno4 = #{voluntary.kno4} , Kno5 = #{voluntary.kno5} where Sno = #{voluntary.sno}")
    Integer deletevoluntary(@Param("voluntary")Voluntary voluntary);
    @Select("select Kno,Kname,Tno,Kstatus,Kclass from project where Kclass = #{kclass} and Ktype = #{type} limit #{laststart},#{start}")
    @Results({
            @Result(id = true,column = "Kno",property = "kno"),
            @Result(column = "Kname",property = "kname"),
            @Result(column = "Tno",property = "teacher",one = @One(select = "com.how2java.springboot.mapper.UserMapper.getTeacher",fetchType = FetchType.EAGER)),
            @Result(column = "Kstatus",property = "kstatus"),
            @Result(column = "Kclass",property = "kclass")
    })
    List<FindProject> FindProject2(@Param("kclass") String kclass,@Param("start")int start,@Param("laststart")int laststart,@Param("type") String type);

    @Insert("insert into message(Sno,Smessage) values ( #{sno} , #{message} )")
    Integer savaMessage(@Param("sno") String sno, @Param("message") String message);
}
