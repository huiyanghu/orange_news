package com.it7890.orange.manage.vo;


import com.avos.avoscloud.AVFile;

import java.util.ArrayList;
import java.util.List;

public class ImageInfoDTO {
    private String ImageUrl;
//    private int ImageWidth;
//    private int ImageHeight;

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

//    public int getImageWidth() {
//        return ImageWidth;
//    }
//
//    public void setImageWidth(int imageWidth) {
//        ImageWidth = imageWidth;
//    }
//
//    public int getImageHeight() {
//        return ImageHeight;
//    }
//
//    public void setImageHeight(int imageHeight) {
//        ImageHeight = imageHeight;
//    }
//
    public static List<ImageInfoDTO> buildImageInfoDTO(List<AVFile> titlePics){
        List<ImageInfoDTO> titlePicInfo = new ArrayList<ImageInfoDTO>();

        ImageInfoDTO imageInfoDTO = null;
        for (AVFile titlePic : titlePics) {
            imageInfoDTO = new ImageInfoDTO();
//            AVObject avoFile = new MediaInfoDao().getByFileId(titlePic.getObjectId());
            imageInfoDTO.setImageUrl(titlePic.getUrl());
//            imageInfoDTO.setImageWidth(avoFile.getInt("width"));
//            imageInfoDTO.setImageHeight(avoFile.getInt("height"));
            titlePicInfo.add(imageInfoDTO);
        }
        return titlePicInfo;
    }
}
