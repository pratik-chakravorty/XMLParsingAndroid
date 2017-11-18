package com.pratik.xmlparsing;

import android.content.Context;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by Pratik on 11/14/2017.
 */

public class XMLParser {
    private Movie[] data = null;
    private Context context = null;

    public XMLParser(Context c) {
        this.context = c;

        //grab the data from xml
        InputStream is = (InputStream)this.context.getResources().openRawResource(R.raw.movie);
        DocumentBuilder builder = null;
        Document doc = null;

        try {
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            doc = builder.parse(is);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //chop all the nodes
        NodeList movieNames = doc.getElementsByTagName("name");
        NodeList movieInfo = doc.getElementsByTagName("info");

        //traverse nodeList to make data array
        data = new Movie[movieNames.getLength()];

        for(int i=0;i<data.length;i++) {
            String name = movieNames.item(i).getFirstChild().getNodeValue();
            String info = movieInfo.item(i).getFirstChild().getNodeValue();

            data[i] = new Movie(name,info);

        }



    }
    public Movie[] getData() {return data;}

    public Movie getData(int i) {return data[i];}



}
