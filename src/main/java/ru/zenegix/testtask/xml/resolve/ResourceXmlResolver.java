package ru.zenegix.testtask.xml.resolve;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import ru.zenegix.testtask.xml.XmlTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ResourceXmlResolver implements XmlResolver {

    private final ClassLoader classLoader;

    @Override
    public String resolve(XmlTemplate xmlTemplate) {
        try {
            InputStream inputStream = classLoader.getResourceAsStream(xmlTemplate.getPath());

            if (inputStream == null) {
                return "";
            }

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            List<String> lines = new ArrayList<>();
            String next;

            while ((next = bufferedReader.readLine()) != null) {
                lines.add(next);
            }

            return String.join("", lines);
        } catch (IOException e) {
            throw new RuntimeException("Could not to resolve xml template", e);
        }
    }

}
