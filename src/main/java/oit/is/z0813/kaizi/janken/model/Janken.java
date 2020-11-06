package oit.is.z0813.kaizi.janken.model;

public class Janken{
  public String syouhai;
  public Janken(String hand){
    if(hand == "Gu"){
      syouhai= "あいこ";
    }
    if(hand == "Choki"){
      syouhai="You Lose";
    }
    if(hand == "Pa"){
      syouhai = "You Win!!";
    }
  }

}
