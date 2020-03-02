package com.example.javademo.io;

import java.io.File;
import java.io.FileFilter;

/**
 * 实现FileFilter接口，在其他地方使用File构造方法时，可以传入这里的FileFilter_Demo实例化对象，实现accept()方法中定义的文件过滤逻辑。
 */
public class FileFilter_Demo implements FileFilter
{
    /**
     * accept判断pathname是否满足要求，满足就return true，将该File对象添加到File.listFiles()的返回数组中。否则就不添加。
     * @param pathname
     * @return
     */
    @Override
    public boolean accept(File pathname)
    {
        if(pathname.isDirectory())
        {
            return true;
        }
        if(pathname.getName().endsWith(".java"))
        {
            return true;
        }
        else
        {
            return false;
        }


    }
}
