package com.ncpc.backend.controller;





import com.ncpc.backend.model.EmailRequest;
import com.ncpc.backend.service.EmailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class EmailController {
  @Autowired
  private EmailService emailService;

  @RequestMapping("/welcome")
  public String welcome(){
    return "hello this is my email api";
  }

  // api to send email
  @RequestMapping(value = "/sendmail" , method = RequestMethod.POST)
  public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request) throws MessagingException {

    System.out.println(request);
       boolean result = this.emailService.sendEmail(request.getSubject() , request.getMessage() , request.getTo());
       if(result){
       return ResponseEntity.ok("Email is sent successfully");
  }else {
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email not send");
       }
  }
}
