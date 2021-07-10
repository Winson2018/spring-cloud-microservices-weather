package com.winson.spring.cloud.initializarstart.util;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;
import java.io.StringReader;

public class XmlBuilder {

    public static Object xmlStrToObject(Class<?> clazz, String xmlStr) throws Exception{
        Object xmlObject = null;
        Reader reader = null;
        JAXBContext context = JAXBContext.newInstance(clazz);

        //XML转为对象的接口
        Unmarshaller unmarshaller = context.createUnmarshaller();

        reader = new StringReader(xmlStr);
        xmlObject = unmarshaller.unmarshal(reader);

        if(reader != null){
            reader.close();
        }

        return xmlObject;
    }
}
