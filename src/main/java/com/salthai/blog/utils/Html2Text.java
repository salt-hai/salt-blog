package com.salthai.blog.utils;

import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.ParserDelegator;
import java.io.*;

/**
 * Html转文本
 *
 * @Author: salthai
 * @Date: 2020/3/16 20:40
 * @Version 1.0
 */
public class Html2Text extends HTMLEditorKit.ParserCallback {

    private static Html2Text html2Text = new Html2Text();

    StringBuffer s;

    public Html2Text() {
    }

    public static String getContent(String str) {
        try {
            html2Text.parse(str);
        } catch (IOException e) {

            e.printStackTrace();
        }
        return html2Text.getText();
    }

    public void parse(String str) throws IOException {

        InputStream iin = new ByteArrayInputStream(str.getBytes());
        Reader in = new InputStreamReader(iin);
        s = new StringBuffer();
        ParserDelegator delegator = new ParserDelegator();
        // the third parameter is TRUE to ignore charset directive
        delegator.parse(in, this, Boolean.TRUE);
        iin.close();
        in.close();
    }

    @Override
    public void handleText(char[] text, int pos) {
        s.append(text);
    }

    public String getText() {
        return s.toString();
    }
}
