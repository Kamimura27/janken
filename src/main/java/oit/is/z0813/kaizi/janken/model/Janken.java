package oit.is.z0813.kaizi.janken.model;

public class Janken{
  public String syouhai;
  public Janken(String hand){
    if(hand == "グー"){
      syouhai= "あいこ";
    }
    if(hand == "チョキ"){
      syouhai="You Lose";
    }
    if(hand == "パー"){
      syouhai = "You Win!!";
    }
  }

}
