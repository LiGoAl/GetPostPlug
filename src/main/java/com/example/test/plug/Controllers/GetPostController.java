package com.example.test.plug.Controllers;

import com.example.test.plug.DTOS.GetOutputDTO;
import com.example.test.plug.DTOS.PostInputDTO;
import com.example.test.plug.DTOS.PostOutputDTO;
import com.example.test.plug.Services.GetPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class GetPostController {
    private final GetPostService getPostService;

    @Autowired
    public GetPostController(GetPostService getPostService) {
        this.getPostService = getPostService;
    }

    @GetMapping
    public GetOutputDTO getLogin() {
        return getPostService.getLogin();
    }

    @PostMapping
    public PostOutputDTO postLogin(@RequestBody PostInputDTO postInputDTO) {
        return getPostService.postLogin(postInputDTO);
    }
}
