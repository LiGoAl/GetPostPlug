package com.example.test.plug.Services;

import com.example.test.plug.DTOS.UserDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class FileWorker {
    private final Path outputFilePath;
    private final Path inputFilePath;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final ThreadLocalRandom random = ThreadLocalRandom.current();

    public FileWorker(@Value("${app.file.inputFile}") String inputFilePath, @Value("${app.file.outputFile}") String outputFilePath) {
        this.inputFilePath = Path.of(inputFilePath);
        this.outputFilePath = Path.of(outputFilePath);
    }

    public void insert(UserDTO userDTO) throws IOException {
        String stringJson = objectMapper.writeValueAsString(userDTO) + System.lineSeparator();
        Files.writeString(outputFilePath, stringJson, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }

    public UserDTO select() throws IOException {
        if (!Files.exists(inputFilePath) || Files.size(inputFilePath) == 0) {
            for (int i = 1; i <= 10; i++) {
                UserDTO user = new UserDTO("admin" + i, "admin" + i, "admin" + i);
                String stringJson = objectMapper.writeValueAsString(user) + System.lineSeparator();
                Files.writeString(inputFilePath, stringJson, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            }
        }
        List<String> list = Files.readAllLines(inputFilePath);
        String randomJson = list.get(random.nextInt(list.size()));
        return objectMapper.readValue(randomJson, UserDTO.class);
    }
}
