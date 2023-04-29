package org.example.quickstart.controller;

import org.example.quickstart.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 23167
 * @description Java is the best language
 * @date 2023/1/23--@20:06
 */
@RestController
@RequestMapping("/message")
public class MessageController {

    private final MessageService service;

    public MessageController(MessageService service) {
        this.service = service;
    }
    @GetMapping("/{str}")
    public String sendMessage(@PathVariable("str") String str){
        service.sendMessage(str);
        return "success";
    }

    @GetMapping("/get/one")
    public String getMessage(){
        return service.doMessage();
    }
}
