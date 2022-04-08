package com.example.board.controller;

import com.example.board.BoardApplication;
import com.example.board.domain.vo.BoardVO;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartHttpServletRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

//JUnit5사용
@ExtendWith(SpringExtension.class)  //4버전->5버전 컨트롤러 테스트 가능하게됨
@SpringBootTest(classes = {BoardApplication.class})
@Slf4j
public class BoardControllerTests {

//   가짜 MVC
//    마치 브라우저에서 URL을 요청한 것처럼 환경을 만들어준다.
    private MockMvc mockMvc;

//    사용자의 요청을 처리해주는 WebApplicationContext를 불러온다.
    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setUp(){
       mockMvc= MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testRegister()throws Exception{
      String checkBno= mockMvc.perform( MockMvcRequestBuilders.post("/board/register")
               .param("title","테스트 새 글 제목")
               .param("content", "테스트 새 글 내용")
               .param("writer","hds1234")

       ).andReturn().getFlashMap().toString();
      log.info(checkBno);

    }



//    @Test
//    public void testList() throws Exception{
//
//        log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/list")).andReturn().getModelAndView().getModelMap().toString());
//    }

    @Test
    public void testRead()throws Exception{
      String checkread =  mockMvc.perform(MockMvcRequestBuilders.get("/board/read")
                .param("bno",String.valueOf(8L))).andReturn().getModelAndView().getViewName();/*getModelMap().toString();*/
      log.info(checkread);

    }

    @Test
    public void testRemove()throws Exception{

       String checkRemove = mockMvc.perform(MockMvcRequestBuilders.get("/board/remove").param("bno", String.valueOf(1L))).andReturn().getFlashMap().toString();
       log.info(checkRemove);

    }

    @Test
    public void testModify()throws Exception{

       String checkModify= mockMvc.perform(MockMvcRequestBuilders.post("/board/modify")
        .param("bno", String.valueOf(5L))
        .param("title", "수정된 테스트 제목")
        .param("content","수정된 테스트 내용")

        ).andReturn().getModelAndView().getModelMap().toString();
        log.info(checkModify);
    }

    @Test
    public void testRegisterGet()throws Exception{
       String responseURI = mockMvc.perform(MockMvcRequestBuilders.get("/board/register")).andReturn().getModelAndView().getViewName();
       log.info(responseURI);
    }

    @Test
    public void testReadGet()throws Exception{
        String responseURI = mockMvc.perform(MockMvcRequestBuilders.get("/board/read").param("bno",String.valueOf(5L)))
                .andReturn().getModelAndView().getViewName();
        log.info(responseURI);
    }


}


