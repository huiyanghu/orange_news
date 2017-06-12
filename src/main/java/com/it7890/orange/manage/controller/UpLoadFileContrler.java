package com.it7890.orange.manage.controller;

import com.alibaba.fastjson.JSON;
import com.it7890.orange.manage.po.FileInfo;
import com.it7890.orange.manage.utils.UpLoadFileUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author gg
 * @create 2017/6/8
 **/
@Controller
@RequestMapping("uploadFile")
public class UpLoadFileContrler {
    private static final Logger logger = LogManager.getLogger(UpLoadFileContrler.class);

    @RequestMapping("go")
    public String go(){
        return "/views/country/edit";
    }


    @RequestMapping("do")
    @ResponseBody
    public String upLoadFile(@RequestParam(value = "file", required = false) MultipartFile file){
        String fileId = null;
        String fileName = file.getOriginalFilename();
        logger.info("fileName:::::>>>>>"+fileName);
        try {
            fileId = UpLoadFileUtil.upFile(fileName,file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileInfo fileInfo = new FileInfo();
        fileInfo.setFileId(fileId);
        logger.info("上传图片生成的id是::::::::::>>>>\""+JSON.toJSONString(fileInfo));
        return JSON.toJSONString(fileInfo);
    }
}
