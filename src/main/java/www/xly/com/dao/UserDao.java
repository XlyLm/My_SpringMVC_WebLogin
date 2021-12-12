package www.xly.com.dao;

import org.apache.ibatis.annotations.*;
import www.xly.com.entity.User;

import java.util.*;
public interface UserDao {
    //根据id查询账户
    @Select("select * from user where id = #{id}")
    User queryById(Integer id);
    //根据phone查询账户名称
    @Select("select * from user where phone = #{phone}")
    User queryByPhone(String phone);
    //查询所有账户
    @Select("select * from user limit #{offset},#{limit}")
    List<User> queryAllByLimit(@Param("offset")Integer offset, @Param("limit")Integer limit);
    //更新账户
    @Update("update user set username = #{username}, password = #{password}, session = #{session}, cookie = #{cookie} where id = #{id}")
    void update(User user);
    //添加账户
    @Insert("insert into user(phone,password,session,cookie)values(#{phone},#{password},#{session},#{cookie})")
    void insert(User user);
    //删除账户
    @Delete("delete from user where id = #{id}")
    void deleteById(Integer id);
}