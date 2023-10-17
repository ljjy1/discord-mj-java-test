package com.github.dmj.utils;

import cn.hutool.core.util.StrUtil;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @author ljjy1
 * @classname FileUtils
 * @description TODO
 * @date 2023/6/19 17:59
 */
public class FileUtils {

    public static File multipartFileToFile(MultipartFile multiFile) {
        if(multiFile == null || multiFile.isEmpty()){
            return null;
        }
        // 获取文件名
        String fileName = multiFile.getOriginalFilename();
        if(StrUtil.isBlank(fileName)){
            return null;
        }
        // 获取文件后缀
        String prefix =  fileName.substring(fileName.lastIndexOf("."));
        try {
            File file = File.createTempFile(fileName, prefix);
            multiFile.transferTo(file);
            return file;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
