package com.example.test.plug.Controllers;

import com.example.test.plug.DTOS.UserDTO;
import com.example.test.plug.Repositories.DataBaseWorker;
import com.example.test.plug.Services.Delay;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/login")
public class GetPostController {
    @Autowired
    private Delay delay;

    @Autowired
    private DataBaseWorker dataBaseWorker;

    @GetMapping("/{login}")
    public ResponseEntity<?> getUser(@PathVariable String login) {
        delay.timeStop();

        UserDTO userDTO = null;
        try {
            userDTO = dataBaseWorker.select(login);
        } catch (SQLException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> postUser(@Valid @RequestBody UserDTO userDTO) {
        delay.timeStop();

        try {
            dataBaseWorker.insert(userDTO);
        } catch (SQLException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>("Entity add in database", HttpStatus.CREATED);
    }
}
