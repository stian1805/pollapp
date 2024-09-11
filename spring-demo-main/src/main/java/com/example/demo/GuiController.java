package com.example.demo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

@Controller
public class GuiController {

    @GetMapping("/gui/test")
    public ResponseEntity<String> showIndex() {
        return ResponseEntity.ok().contentType(MediaType.TEXT_HTML).body("""
                <html>
                <head>
                <title>GUI</title>
                </head>
                <body>
                <h1>Hello World Test</h1>
                </body>
                </html>
                """);
    }
}