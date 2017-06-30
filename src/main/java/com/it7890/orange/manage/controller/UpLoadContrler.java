package com.it7890.orange.manage.controller;

import com.alibaba.fastjson.JSON;
import com.avos.avoscloud.AVFile;
import com.it7890.orange.manage.po.FileInfo;
import com.it7890.orange.manage.utils.MD5;
import com.it7890.orange.manage.utils.StringUtil;
import com.it7890.orange.manage.utils.UpLoadFileUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author gg
 * @create 2017/6/8
 **/
@Controller
@RequestMapping("upload")
public class UpLoadContrler {

    private static final Logger logger = LogManager.getLogger(UpLoadContrler.class);

    @RequestMapping(value = "/ueditor")
    @ResponseBody
    public String BinaryUpload(HttpServletRequest req, @RequestParam(value = "action", required = false) String action, @RequestParam(value = "upfile", required = false) MultipartFile file) {

        if("config".equals(action)) {
            return "{\"snapscreenInsertAlign\":\"none\",\"imageUrlPrefix\":\"\",\"imageAllowFiles\":[\".png\",\".jpg\",\".jpeg\",\".gif\",\".bmp\"],\"filePathFormat\":\"/ueditor/jsp/upload/file/{yyyy}{mm}{dd}/{time}{rand:6}\",\"fileMaxSize\":51200000,\"fileManagerListPath\":\"/ueditor/jsp/upload/file/\",\"catcherUrlPrefix\":\"\",\"scrawlInsertAlign\":\"none\",\"imageManagerUrlPrefix\":\"\",\"scrawlUrlPrefix\":\"\",\"imageFieldName\":\"upfile\",\"fileManagerAllowFiles\":[\".png\",\".jpg\",\".jpeg\",\".gif\",\".bmp\",\".flv\",\".swf\",\".mkv\",\".avi\",\".rm\",\".rmvb\",\".mpeg\",\".mpg\",\".ogg\",\".ogv\",\".mov\",\".wmv\",\".mp4\",\".webm\",\".mp3\",\".wav\",\".mid\",\".rar\",\".zip\",\".tar\",\".gz\",\".7z\",\".bz2\",\".cab\",\".iso\",\".doc\",\".docx\",\".xls\",\".xlsx\",\".ppt\",\".pptx\",\".pdf\",\".txt\",\".md\",\".xml\"],\"imageMaxSize\":2048000,\"catcherPathFormat\":\"/ueditor/jsp/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}\",\"imageManagerInsertAlign\":\"none\",\"scrawlFieldName\":\"upfile\",\"imagePathFormat\":\"/ueditor/jsp/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}\",\"scrawlActionName\":\"uploadscrawl\",\"imageManagerActionName\":\"listimage\",\"imageActionName\":\"uploadimage\",\"imageManagerListSize\":20,\"imageManagerAllowFiles\":[\".png\",\".jpg\",\".jpeg\",\".gif\",\".bmp\"],\"fileAllowFiles\":[\".png\",\".jpg\",\".jpeg\",\".gif\",\".bmp\",\".flv\",\".swf\",\".mkv\",\".avi\",\".rm\",\".rmvb\",\".mpeg\",\".mpg\",\".ogg\",\".ogv\",\".mov\",\".wmv\",\".mp4\",\".webm\",\".mp3\",\".wav\",\".mid\",\".rar\",\".zip\",\".tar\",\".gz\",\".7z\",\".bz2\",\".cab\",\".iso\",\".doc\",\".docx\",\".xls\",\".xlsx\",\".ppt\",\".pptx\",\".pdf\",\".txt\",\".md\",\".xml\"],\"snapscreenActionName\":\"uploadimage\",\"fileFieldName\":\"upfile\",\"fileActionName\":\"uploadfile\",\"catcherActionName\":\"catchimage\",\"fileManagerListSize\":20,\"catcherAllowFiles\":[\".png\",\".jpg\",\".jpeg\",\".gif\",\".bmp\"],\"snapscreenPathFormat\":\"/ueditor/jsp/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}\",\"imageCompressBorder\":1600,\"snapscreenUrlPrefix\":\"\",\"imageCompressEnable\":false,\"catcherLocalDomain\":[\"127.0.0.1\",\"localhost\",\"img.baidu.com\"],\"imageManagerListPath\":\"/ueditor/jsp/upload/image/\",\"imageInsertAlign\":\"none\",\"catcherMaxSize\":2048000,\"videoMaxSize\":102400000,\"fileManagerUrlPrefix\":\"\",\"scrawlPathFormat\":\"/ueditor/jsp/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}\",\"scrawlMaxSize\":2048000,\"catcherFieldName\":\"source\"}";
        }

        if("uploadimage".equals(action) && null != file){
//            MultipartResolver resolver = new CommonsMultipartResolver(request.getSession().getServletContext());
//            MultipartHttpServletRequest multipartRequest = resolver.resolveMultipart(request);
//            CommonsMultipartFile file = (CommonsMultipartFile) multipartRequest.getFile("upfile");

//            DefaultMultipartHttpServletRequest request = (DefaultMultipartHttpServletRequest)req;
//            CommonsMultipartFile file = (CommonsMultipartFile) request.getFile("upfile");

            String logImageName = null;
            String suffix = null;
            String imgSrc = "";
            try {
                suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String folder = df.format(new Date());
                logImageName = MD5.MD5(UUID.randomUUID().toString()) + suffix;
                String filename = "/" + folder + "/" + logImageName;

                AVFile uploadFile = new AVFile(filename, file.getBytes());
                uploadFile.save();

                if (StringUtil.isNotEmpty(uploadFile.getUrl())) {
                    imgSrc = uploadFile.getUrl();
                }
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("ueditor upload error, cause: {}", e.getMessage());
            }
            return "{\"state\": \"SUCCESS\",\"title\": \""+logImageName+"\",\"original\": \""+logImageName+"\",\"type\": \""+suffix+"\",\"url\": \""+imgSrc+"\",\"size\": \"16585\"}";
        }
        return "";
    }
}
