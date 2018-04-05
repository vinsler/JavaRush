package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import org.omg.IOP.TaggedComponent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        String tagStart = "<" + args[0];
        String tagEnd = "</" + args[0] + ">";

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine(); // c:/tmp/1.html
        reader.close();

        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        StringBuffer stringBuffer = new StringBuffer();

        while (bufferedReader.ready()) {
            stringBuffer.append(bufferedReader.readLine());
        }
        bufferedReader.close();

        StringBuffer sbTemp = new StringBuffer();

        sbTemp.append(stringBuffer.substring(stringBuffer.indexOf(tagStart), stringBuffer.lastIndexOf(tagEnd) + tagEnd.length()));
        stringBuffer.setLength(0);

        int spanStart, spanCLose, pos;

        spanStart = sbTemp.indexOf(tagStart);
        do {
            pos = spanStart;
            spanCLose = sbTemp.indexOf(tagEnd, pos);

            int tagContainCount = TagContainCount(sbTemp.substring(pos, spanCLose), tagStart);
            int posEndTag = PosEndTag(sbTemp.substring(pos, sbTemp.length()), tagEnd, tagContainCount);
            System.out.println(sbTemp.substring(spanStart, spanStart + posEndTag));

            int posStart = spanStart, posEnd = posEndTag;

            while (tagContainCount > 0) {
                System.out.println(RetNewString(sbTemp.substring(posStart + 1, posStart + posEnd), tagStart, tagEnd));
                tagContainCount--;
                posStart = sbTemp.indexOf(tagStart, posStart + 1);
            }

            spanStart = sbTemp.indexOf(tagStart, spanStart + posEndTag);
        } while (spanStart != -1);
    }

    public static String RetNewString (String strToFind, String tagStart, String tagEnd){
        String str = "";
        int i1 = strToFind.indexOf(tagStart);
        int i2 = strToFind.indexOf(tagEnd);
        int i3 = TagContainCount(strToFind.substring(i1, i2), tagStart);
        int i4 = PosEndTag(strToFind, tagEnd, i3);
        str = strToFind.substring(i1, i4);
        return str;
    }

    public static int TagContainCount (String str, String tag){
        int i = 0, j = 0, cx = -1;
        do{
            i = j;
            j = str.indexOf(tag, i + 1);
            cx++;
        }while (j != -1);
        return cx;
    }

    public static int PosEndTag (String strBuf, String tagEnd, int count) {
        int i = 0, j = 0;
        count++;
        do {
            i = j;
            j = strBuf.indexOf(tagEnd, i + 1);
            count--;
        }while (count != 0);
        return j + tagEnd.length();
    }
}
