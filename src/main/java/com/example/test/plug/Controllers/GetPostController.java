package com.example.test.plug.Controllers;

import com.example.test.plug.DTOS.GetOutputDTO;
import com.example.test.plug.DTOS.PostInputDTO;
import com.example.test.plug.DTOS.PostOutputDTO;
import com.example.test.plug.Services.Delay;
import jakarta.servlet.ServletException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class GetPostController {
    @Autowired
    private Delay delay;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getLogin() throws ServletException {
        delay.timeStop();

        GetOutputDTO getOutputDTO = new GetOutputDTO();
        getOutputDTO.setLogin("Login1");
        getOutputDTO.setStatus("ok");

        Map<String, Object> map = new HashMap<>();
        map.put("status", HttpStatus.OK.value());
        map.put("message", HttpStatus.OK.toString());
        map.put("data", getOutputDTO);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> postLogin(@Valid @RequestBody PostInputDTO postInputDTO) throws ServletException {
        delay.timeStop();

        PostOutputDTO postOutputDTO = new PostOutputDTO();
        postOutputDTO.setLogin(postInputDTO.getLogin());
        postOutputDTO.setPassword(postInputDTO.getPassword());
        postOutputDTO.setDate();

        Map<String, Object> map = new HashMap<>();
        map.put("status", HttpStatus.CREATED.value());
        map.put("message", HttpStatus.CREATED.toString());
        map.put("data", postOutputDTO);
        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }
}
