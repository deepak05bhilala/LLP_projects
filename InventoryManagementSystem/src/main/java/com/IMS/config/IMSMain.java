package com.example.RishiTraders.InventoryManagementSystem.main.java.com.IMS.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@Profile("ims")
public class IMSMain implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

    }
}
