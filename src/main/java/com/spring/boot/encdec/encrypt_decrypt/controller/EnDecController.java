package com.spring.boot.encdec.encrypt_decrypt.controller;

import com.spring.boot.encdec.encrypt_decrypt.service.EndecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnDecController {
    @Autowired
    EndecService endecService;
    private static String encryptUsername;
    @PostMapping("/encrypt/{username}")
    public String encryptString(@PathVariable String username) throws Exception {
        System.out.println("Hi : "+username);
        this.encryptUsername=endecService.encrypt(username);
        return encryptUsername;
    }

    @PostMapping("/decrypt")
    public String decryptString() throws Exception {
        System.out.println("Hi : ");
        System.out.println(encryptUsername);
        return endecService.decrypt(encryptUsername);
    }


}
