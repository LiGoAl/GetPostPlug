package com.example.test.plug.Services;

import com.example.test.plug.DTOS.GetOutputDTO;
import com.example.test.plug.DTOS.PostInputDTO;
import com.example.test.plug.DTOS.PostOutputDTO;
import org.springframework.stereotype.Service;

@Service
public class GetPostService {

    public GetOutputDTO getLogin() {
        GetOutputDTO getOutputDTO = new GetOutputDTO();
        getOutputDTO.setLogin("Login1");
        getOutputDTO.setStatus("ok");
        return getOutputDTO;
    }

    public PostOutputDTO postLogin(PostInputDTO postInputDTO) {
        PostOutputDTO postOutputDTO = new PostOutputDTO();
        postOutputDTO.setLogin(postInputDTO.getLogin());
        postOutputDTO.setPassword(postInputDTO.getPassword());
        postOutputDTO.setDate();
        return postOutputDTO;
    }
}
