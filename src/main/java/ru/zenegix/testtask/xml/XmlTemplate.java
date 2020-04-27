package ru.zenegix.testtask.xml;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum XmlTemplate {

    DOWNLOAD_FILE_REQUEST("download_file_request_template.xml");

    private final String path;

}
