package ru.zenegix.testtask.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DownloadRequest {

    private final PersonalData personalData;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public DownloadRequest(@JsonProperty("personaldata") PersonalData personalData) {
        this.personalData = personalData;
    }

}
