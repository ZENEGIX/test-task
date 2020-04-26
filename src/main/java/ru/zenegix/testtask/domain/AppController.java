package ru.zenegix.testtask.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.zenegix.testtask.dto.DownloadRequest;
import ru.zenegix.testtask.dto.DownloadResponse;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/app")
@RequiredArgsConstructor
public class AppController {

    private final AppControllerHandler appControllerHandler;

    @PostMapping("/nbkirequest")
    public CompletableFuture<DownloadResponse> post(@RequestBody DownloadRequest request) {
        return this.appControllerHandler.download(request);
    }

}
