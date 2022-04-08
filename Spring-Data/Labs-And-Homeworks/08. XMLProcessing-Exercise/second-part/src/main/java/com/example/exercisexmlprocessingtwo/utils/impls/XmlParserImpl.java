package com.example.exercisexmlprocessingtwo.utils.impls;

import com.example.exercisexmlprocessingtwo.utils.XmlParser;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

@Component
public class XmlParserImpl implements XmlParser {

    private JAXBContext jaxbContext;

    @Override
    @SuppressWarnings("unchecked")
    public <T> T fromXml(String pathName, Class<T> typeClass) throws JAXBException, FileNotFoundException {
        this.jaxbContext = JAXBContext.newInstance(typeClass);
        Unmarshaller unmarshaller = this.jaxbContext.createUnmarshaller();

        return (T) unmarshaller.unmarshal(new FileReader(pathName));
    }

    @Override
    public <T> void toXml(String pathName, T entity) throws JAXBException {
        this.jaxbContext = JAXBContext.newInstance(entity.getClass());
        Marshaller marshaller = this.jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshaller.marshal(entity, new File(pathName));
    }
}
