package ru.zenegix.testtask.xml.generator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.zenegix.testtask.dto.PersonalData;
import ru.zenegix.testtask.service.placeholder.PlaceholderService;
import ru.zenegix.testtask.xml.XmlTemplate;
import ru.zenegix.testtask.xml.resolve.XmlResolver;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class XmlGeneratorImpl implements XmlGenerator {

    private final XmlResolver xmlResolver;
    private final PlaceholderService placeholderService;

    @Override
    public String generateDownloadFileRequest(UUID uuid, PersonalData personalData) {
        String template = xmlResolver.resolve(XmlTemplate.DOWNLOAD_FILE_REQUEST);
        Map<String, Object> placeholderMap = new HashMap<>();
        placeholderMap.put("uuid", uuid);
        placeholderMap.put("first_name", personalData.getClientName());
        placeholderMap.put("last_name", personalData.getClientSurname());
        placeholderMap.put("patr_name", personalData.getClientPatronymic());
        placeholderMap.put("doc_number", personalData.getPassportSeries());
        placeholderMap.put("doc_series", personalData.getPassportNumber());
        placeholderMap.put("doc_issue_date", personalData.getPassportIssueDate());

        return this.placeholderService.applyPlaceholders(template, placeholderMap);
    }

}
