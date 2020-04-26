package ru.zenegix.testtask.xml.generator;

import ru.zenegix.testtask.dto.PersonalData;

import java.util.UUID;

public interface XmlGenerator {

    /**
     * Generate the xml register client request
     *
     * @param uuid the uuid of the xml request
     * @param personalData client data for fill
     * @return filled xml request
     */
    String generateRegisterClientRequest(UUID uuid, PersonalData personalData);

}
