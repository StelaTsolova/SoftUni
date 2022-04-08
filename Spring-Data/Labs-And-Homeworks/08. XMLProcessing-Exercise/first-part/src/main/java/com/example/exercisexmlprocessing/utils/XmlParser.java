package com.example.exercisexmlprocessing.utils;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface XmlParser {

    <T> T fromXml(String filePath, Class<T> typeClass) throws JAXBException, IOException;

    <T> void toXml(String filePath, T entity) throws JAXBException, IOException;
}
