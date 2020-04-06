package main.util;

import java.io.*;
import java.util.Properties;

/**
 * @Author He
 * @Date 2020/4/3 18:20
 * @Version 1.0
 */
public class LoadDataUtil {
    public Properties  loadProp(String Path) {
        Properties prop=new Properties();

        try {
            InputStream in = new FileInputStream(Path);
            prop.load(in);
            in.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("properties文件路径书写有误，请检查！");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return prop;
    }

}
