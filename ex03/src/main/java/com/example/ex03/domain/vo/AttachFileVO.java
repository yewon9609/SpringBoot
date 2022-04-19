package com.example.ex03.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class AttachFileVO {
   private String fileName;
   private String uploadPath;   //파일 경로
   private String uuid;
   private boolean image;       //이미지인지 아닌지

}
