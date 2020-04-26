package ru.zenegix.testtask.service.placeholder;

import java.util.Map;

public interface PlaceholderService {

    /**
     * Apply placeholders in string
     *
     * @param target target string
     * @param placeholderMap map of placeholders
     * @return string with applied placeholders
     */
    String applyPlaceholders(String target, Map<String, Object> placeholderMap);

}
