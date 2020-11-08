package oit.is.z0813.kaizi.janken.model;

public class Janken{
  public String syouhai;
  public String yourhand;

  public Janken(int hand){

    if(hand == 0){
      syouhai = "あいこ";
      yourhand = "Gu";
    }

    if(hand == 1){
      syouhai ="You Lose";
      yourhand = "Choki";
    }

    if(hand == 2){
      syouhai = "You Win!!";
      yourhand = "Pa";
    }

  }

}
