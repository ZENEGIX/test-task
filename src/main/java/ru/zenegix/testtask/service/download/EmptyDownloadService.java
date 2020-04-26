package ru.zenegix.testtask.service.download;

import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class EmptyDownloadService implements DownloadService {

    @Override
    public CompletableFuture<String> download(UUID uuid, String xmlRequest) {
        return CompletableFuture.completedFuture(Base64.getEncoder().encodeToString("empty file".getBytes()));
    }

}
