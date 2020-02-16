package demo.demomybatis;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * just to use annotation for the DAO
 * 
 * @author Fu
 *
 */
@Mapper
public interface UserDao {

    //@Select("SELECT * FROM user WHERE name = #{name}")
    // will lookup the xml file to find the findUserByName
	User findUserByName(@Param("name") String name);

    @Select("SELECT * FROM user")
    List<User> findAllUser();

    @Insert("INSERT INTO user(name, age,money) VALUES(#{name}, #{age}, #{money})")
    void insertUser(@Param("name") String name, @Param("age") Integer age, @Param("money") Double money);

    @Update("UPDATE  user SET name = #{name},age = #{age},money= #{money} WHERE id = #{id}")
    void updateUser(@Param("name") String name, @Param("age") Integer age, @Param("money") Double money,
                    @Param("id") int id);

    @Delete("DELETE from user WHERE id = #{id}")
    void deleteUser(@Param("id") int id);
}
