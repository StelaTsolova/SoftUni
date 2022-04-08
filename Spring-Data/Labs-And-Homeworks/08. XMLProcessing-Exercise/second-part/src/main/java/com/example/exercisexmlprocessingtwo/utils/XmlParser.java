package com.example.exercisexmlprocessingtwo.utils;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface XmlParser {

   <T> T fromXml(String pathName, Class<T> typeClass) throws JAXBException, FileNotFoundException;

   <T> void toXml(String pathName, T entity) throws JAXBException;
 }
