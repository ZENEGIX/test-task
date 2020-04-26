package ru.zenegix.testtask.xml;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum XmlTemplate {

    REGISTER_CLIENT_REQUEST("register_client_request_template.xml");

    private final String path;

}
