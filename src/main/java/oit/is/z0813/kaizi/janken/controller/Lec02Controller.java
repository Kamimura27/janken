package oit.is.z0813.kaizi.janken.controller;

import java.security.Principal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import oit.is.z0813.kaizi.janken.model.User;
import oit.is.z0813.kaizi.janken.model.UserMapper;
import oit.is.z0813.kaizi.janken.model.Entry;
import oit.is.z0813.kaizi.janken.model.Janken;
import oit.is.z0813.kaizi.janken.model.Match;
import oit.is.z0813.kaizi.janken.model.MatchMapper;


//import oit.is.z0813.kaizi.janken.model.ChamberUser;
//import oit.is.z0813.kaizi.janken.model.UserInfo;

@Controller
public class Lec02Controller {

  @Autowired
  private Entry room;

  @Autowired
  UserMapper userMapper;

  @Autowired
  MatchMapper matchMapper;

  @PostMapping("/lec02")
  public String index(String name, ModelMap model) {
    model.addAttribute("username",name);
    return "lec02.html";
  }

  @GetMapping("/match")
  public String match(Principal prin, ModelMap model){
    String loginUser = prin.getName();
    model.addAttribute("user", loginUser);
    return "match.html";
  }

  @GetMapping("/match/gu")
    public String gu(ModelMap model){
      String hand ="Gu";
      Janken janken = new Janken(hand);
      Match match = new Match();

      match.setUser_1(2);
      match.setUser_2(1);
      match.setUser_1_hand("Gu");
      match.setUser_2_hand(hand);
      matchMapper.insertMatch(match);

      model.addAttribute("yourhand", hand);
      model.addAttribute("syouhai", janken.syouhai);
      return "match.html";
    }
  @GetMapping("/match/choki")
    public String choki(ModelMap model){
      String hand ="Choki";
      Janken janken = new Janken(hand);
      Match match = new Match();

      match.setUser_1(2);
      match.setUser_2(1);
      match.setUser_1_hand("Gu");
      match.setUser_2_hand(hand);
      matchMapper.insertMatch(match);

      model.addAttribute("yourhand", hand);
      model.addAttribute("syouhai", janken.syouhai);
      return "match.html";
    }
  @GetMapping("/match/pa")
    public String pa(ModelMap model){
      String hand ="Pa";
      Janken janken = new Janken(hand);
      Match match = new Match();

      match.setUser_1(2);
      match.setUser_2(1);
      match.setUser_1_hand("Gu");
      match.setUser_2_hand(hand);
      matchMapper.insertMatch(match);

      model.addAttribute("yourhand", hand);
      model.addAttribute("syouhai", janken.syouhai);
      return "match.html";
    }

  @GetMapping("lec02")
  public String sample38(Principal prin, ModelMap model) {
    String loginUser = prin.getName();
    this.room.addUser(loginUser);
    model.addAttribute("room", this.room);
    model.addAttribute("user", loginUser);

    ArrayList<User> user2 = userMapper.selectAll();
    model.addAttribute("user2", user2);

    ArrayList<Match> match2 = matchMapper.selectAll();
    model.addAttribute("match2", match2);
    return "lec02.html";
  }
}
