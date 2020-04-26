package ru.zenegix.testtask.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.zenegix.testtask.dto.DownloadRequest;
import ru.zenegix.testtask.dto.DownloadResponse;
import ru.zenegix.testtask.service.download.DownloadService;
import ru.zenegix.testtask.xml.generator.XmlGenerator;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class AppControllerHandler {

    private final XmlGenerator xmlGenerator;
    private final DownloadService downloadService;

    public CompletableFuture<DownloadResponse> download(DownloadRequest downloadRequest) {
        UUID uuid = UUID.randomUUID();
        String xmlRequest = xmlGenerator.generateRegisterClientRequest(uuid, downloadRequest.getPersonalData());

        return this.downloadService.download(uuid, xmlRequest)
                .thenApply(DownloadResponse::new);
    }

}
