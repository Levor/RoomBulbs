package com.roomsWithBulb;

import com.github.sypexgeo.SxRestClient;
import com.github.sypexgeo.model.SxGeoResult;
import com.roomsWithBulb.domain.Rooms;
import com.roomsWithBulb.repos.RoomsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping
public class BulbController {

    @Autowired
    private RoomsRepo roomsRepo;


    //Starting
    @GetMapping
    public String index(Model model){

        Iterable<Rooms> rooms = roomsRepo.findAll();
        model.addAttribute("rooms", rooms);
        return "index";
    }

    //Add rooms
    @PostMapping("add")
    public String add(@RequestParam String name,
                      @RequestParam String country,
                      Model model){



        Rooms room = new Rooms(name, country, false);
        roomsRepo.save(room);
        Iterable<Rooms> rooms = roomsRepo.findAll();
        model.addAttribute("rooms", rooms);
        return "index";
    }

    //Entered into room
    @GetMapping("{room}")
    public String roomWithBulb(@PathVariable Rooms room,
                               Model model, HttpServletRequest request)
    {

        String s  = request.getRemoteAddr();

        if(s.equals("127.0.0.1")){
            s="178.120.183.231";
        }else {
            s = s;
        }

        SxGeoResult result = SxRestClient.create(null).get(s);

        if(room.getCountry().equals(result.country.name.ru())){
            if (room.isTurnBulb()==true){model.addAttribute("turn", "on");
            }else{model.addAttribute("turn", "off");}

            Iterable<Rooms> rooms = roomsRepo.findAll();
            model.addAttribute("s",s);
            model.addAttribute("room",room);
            model.addAttribute("rooms", rooms);

            return "room";

        }else {
            return "error";
        }


    }

    //TurnBulb
    @PostMapping("{room}")
    public String turnBulb(@PathVariable Rooms room,
                           @RequestParam String turnBulb,
                           Model model){
        if (turnBulb.equals("true")){
            model.addAttribute("turn","on");
            room.setTurnBulb(true);
        } else if (turnBulb.equals("false")){
            model.addAttribute("turn","off");
            room.setTurnBulb(false);
        }
        roomsRepo.save(room);

        Iterable<Rooms> rooms = roomsRepo.findAll();
        model.addAttribute("rooms", rooms);

        return "room";
    }

}
