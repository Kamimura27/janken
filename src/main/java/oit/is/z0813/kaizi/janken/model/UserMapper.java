package oit.is.z0813.kaizi.janken.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

  @Select("SELECT id, name from users where id = #{id}")
  User selectById(int id);

  

  //@Insert("INSERT INTO USER (id, name) VALUES (#{id},#{name});")
  //@Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
  //void insertUSER(User user);


}
