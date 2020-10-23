package oit.is.z0813.kaizi.janken.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import oit.is.z0813.kaizi.janken.model.Entry;

import oit.is.z0813.kaizi.janken.model.Janken;

@Controller
public class Lec02Controller {

  @Autowired
  private Entry room;

  @PostMapping("/lec02")
  public String index(String name, ModelMap model) {
    model.addAttribute("username", "Hi "+ name);
    return "lec02.html";
  }
  @GetMapping("/gu")
    public String gu(ModelMap model){
      String hand ="グー";
      Janken janken = new Janken(hand);

      model.addAttribute("yourhand", hand);
      model.addAttribute("syouhai", janken.syouhai);
      return "lec02.html";
    }
  @GetMapping("/choki")
    public String choki(ModelMap model){
      String hand ="チョキ";
      Janken janken = new Janken(hand);

      model.addAttribute("yourhand", hand);
      model.addAttribute("syouhai", janken.syouhai);
      return "lec02.html";
    }
  @GetMapping("/pa")
    public String pa(ModelMap model){
      String hand ="パー";
      Janken janken = new Janken(hand);

      model.addAttribute("yourhand", hand);
      model.addAttribute("syouhai", janken.syouhai);
      return "lec02.html";
    }

  @GetMapping("lec02")
  public String sample38(Principal prin, ModelMap model) {
    String loginUser = prin.getName();
    this.room.addUser(loginUser);
    model.addAttribute("room", this.room);
    model.addAttribute("user", "Hi "+loginUser);

    return "lec02.html";
  }

}
