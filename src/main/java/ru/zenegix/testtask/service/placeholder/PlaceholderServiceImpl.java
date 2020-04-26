package ru.zenegix.testtask.service.placeholder;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class PlaceholderServiceImpl implements PlaceholderService {

    private final Pattern pattern = Pattern.compile("\\$\\{\\w+}");

    @Override
    public String applyPlaceholders(String target, Map<String, Object> placeholderMap) {
        if (target == null || target.isEmpty()) {
            return target;
        }

        Matcher matcher = this.pattern.matcher(target);
        StringBuilder sb = new StringBuilder();

        while (matcher.find()) {
            String group = matcher.group();
            group = group.substring(2, group.length() - 1);
            Object rawValue = placeholderMap.getOrDefault(group, "");
            String value = rawValue == null ? "" : rawValue.toString();

            matcher.appendReplacement(sb, value);
        }

        matcher.appendTail(sb);

        return sb.toString();
    }

}
