package ru.zenegix.testtask.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PersonalData {

    @JsonProperty("client_name")
    private final String clientName;

    @JsonProperty("client_surname")
    private final String clientSurname;

    @JsonProperty("client_patronymic")
    private final String clientPatronymic;

    @JsonProperty("passport_series")
    private final int passportSeries;

    @JsonProperty("passport_number")
    private final String passportNumber;

    @JsonProperty("passport_date_of_issue")
    private final String passportIssueDate;

}
