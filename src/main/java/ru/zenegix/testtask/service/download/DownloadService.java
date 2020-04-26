package ru.zenegix.testtask.service.download;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface DownloadService {

    /**
     * Download the file
     *
     * @param uuid the uuid of xml request
     * @param xmlRequest request in xml
     * @return file in base64 wrapper in completable future
     */
    CompletableFuture<String> download(UUID uuid, String xmlRequest);

}
