package com.base.tool.io;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: jre
 * @date: 2021-01-11 18:34
 * @description: https://gitee.com/doudio/notebook/blob/master/JavaBase/java.io/io%E6%93%8D%E4%BD%9C%E4%B8%80%E8%A1%8C%E6%96%87%E4%BB%B6.md
 **/
@Slf4j
public class IOUtil {

    // 读
    public static List<String> readList(File file) {
        List<String> data = new ArrayList<>();
        try (BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(file)));) {
            String line = null;
            while ((line = input.readLine()) != null) {
                data.add(line);
            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return data;
    }

    // 写
    public static void writeList(File file, List<String> list) {
        if (null == list || list.isEmpty()) return;
        try (BufferedWriter output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));) {
            for (String context : list) {
                output.write(String.format("%s%n", context));
            }
        } catch (FileNotFoundException e) {
            log.error(e.getMessage(), e);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }

}
