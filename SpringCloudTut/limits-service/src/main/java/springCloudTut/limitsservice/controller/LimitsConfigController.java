package springCloudTut.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springCloudTut.limitsservice.Config;
import springCloudTut.limitsservice.service.FileReaderService;

import java.io.File;
import java.io.IOException;

@RestController
public class LimitsConfigController {

    @Autowired
    private Config config;

    @Autowired
    private FileReaderService fileservice;

    @GetMapping("/limits")
    public Config retrieveLimitsFromConfigurations() {
        return new Config(config.getMinimum(), config.getMaximum());
    }

    @GetMapping("/file")
    public String readFile() throws IOException {
        return fileservice.readFile();
    }
}
