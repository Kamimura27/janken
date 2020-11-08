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
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import oit.is.z0813.kaizi.janken.model.User;
import oit.is.z0813.kaizi.janken.model.UserMapper;
import oit.is.z0813.kaizi.janken.model.Entry;
import oit.is.z0813.kaizi.janken.model.Janken;
import oit.is.z0813.kaizi.janken.model.Match;
import oit.is.z0813.kaizi.janken.model.MatchMapper;
import oit.is.z0813.kaizi.janken.model.MatchInfo;
import oit.is.z0813.kaizi.janken.model.MatchInfoMapper;
import oit.is.z0813.kaizi.janken.service.AsyncKekka;

@Controller
public class Lec02Controller {

  @Autowired
  private Entry room;

  @Autowired
  UserMapper userMapper;

  @Autowired
  MatchMapper matchMapper;

  @Autowired
  MatchInfoMapper matchInfoMapper;

  @Autowired
  AsyncKekka kekka;

  @PostMapping("/lec02")
  public String index(String name, ModelMap model) {
    model.addAttribute("username",name);
    return "lec02.html";
  }

  @GetMapping("/match")
  //@Transactional
  public String match(Principal prin, ModelMap model, @RequestParam Integer id){
    String loginUser = prin.getName();
    MatchInfo matchInfo = new MatchInfo();
    User user = userMapper.selectById(id);

    matchInfo.setUser_1(2);
    matchInfo.setUser_2(1);
    matchInfo.setIs_active(true);
    matchInfoMapper.insertMatchInfo(matchInfo);

    model.addAttribute("user", loginUser);
    model.addAttribute("user2", user);
    return "match.html";
  }

  @GetMapping("/result")
  public String result(Principal prin, ModelMap model, @RequestParam Integer id, @RequestParam Integer hand){

    String loginUser = prin.getName();
    Janken janken = new Janken(hand);
    Match match = new Match();
    User user = userMapper.selectById(id);

    match.setUser_1(2);
    match.setUser_2(1);
    match.setUser_1_hand("Gu");
    match.setUser_2_hand(janken.yourhand);
    matchMapper.insertMatch(match);

    model.addAttribute("yourhand", janken.yourhand);
    model.addAttribute("syouhai", janken.syouhai);
    model.addAttribute("user", loginUser);
    model.addAttribute("user3", user);
      return "wait.html";
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

  @GetMapping("live")
  public SseEmitter Wait(){
    final SseEmitter sseEmitter = new SseEmitter();
    this.kekka.asyncWait(sseEmitter);
    return sseEmitter;
  }
}
