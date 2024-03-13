package com.ABCLaboratories.TestRegistrationSystem.controller;

import com.ABCLaboratories.TestRegistrationSystem.model.LoginProcess;
import com.ABCLaboratories.TestRegistrationSystem.model.LoginUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loginuser")
@CrossOrigin("http://localhost:3000")
public class UserLoginController {
public static String ConfirmedEmail;

    @PostMapping("/check")
    public String check(@RequestBody LoginUser loginu){
        LoginProcess login = new LoginProcess();
        if (login.ifLogged(loginu.getEmail().toString(), loginu.getPassword().toString())) {

            ConfirmedEmail = loginu.getEmail().toString();
            return ConfirmedEmail;
        }else {
            ConfirmedEmail="Incorrect Credential";
            return ConfirmedEmail;
        }


    }

    @GetMapping("/Authenticaton")
    public ResponseEntity<String> sendString() {
        String stringValue = ConfirmedEmail;

        return ResponseEntity.ok().body(stringValue);
    }
}
