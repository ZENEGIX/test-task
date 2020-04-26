package ru.zenegix.testtask.xml.resolve;

import ru.zenegix.testtask.xml.XmlTemplate;

public interface XmlResolver {

    /**
     * Resolving xml template
     *
     * @param xmlTemplate xml template info
     * @return xml content or empty string
     */
    String resolve(XmlTemplate xmlTemplate);

}
