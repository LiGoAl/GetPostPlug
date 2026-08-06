package com.example.test.plug.Controllers;

import com.example.test.plug.DTOS.GetOutputDTO;
import com.example.test.plug.DTOS.PostInputDTO;
import com.example.test.plug.DTOS.PostOutputDTO;
import com.example.test.plug.Services.Delay;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class GetPostController {
    @Autowired
    private Delay delay;

    @GetMapping
    public ResponseEntity<?> getLogin() {
        delay.timeStop();

        GetOutputDTO getOutputDTO = new GetOutputDTO("Login1", "ok");

        return new ResponseEntity<>(getOutputDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> postLogin(@Valid @RequestBody PostInputDTO postInputDTO) {
        delay.timeStop();

        PostOutputDTO postOutputDTO = new PostOutputDTO(postInputDTO.getLogin(), postInputDTO.getPassword());

        return new ResponseEntity<>(postOutputDTO, HttpStatus.CREATED);
    }
}
