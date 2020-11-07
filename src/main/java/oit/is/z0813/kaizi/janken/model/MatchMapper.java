package oit.is.z0813.kaizi.janken.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MatchMapper {

  @Select("SELECT * from matches")
  ArrayList<Match> selectAll();

  @Insert("INSERT INTO Matches (user_1, user_2, user_1_hand, user_2_hand, is_active) VALUES (#{user_1}, #{user_2}, #{user_1_hand}, #{user_2_hand}, #{is_active});")
  @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
  void insertMatch(Match match);
}
