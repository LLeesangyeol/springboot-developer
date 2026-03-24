package me.sylee.springdeveloper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TestControllerTest {

    @Autowired
    protected MockMvc mockMvc;
//
//    @Autowired
//    private WebApplicationContext context;
//
//    @Autowired
//    private TestRepository testRepository;
//
//    @BeforeEach
//    public void mockMvcSetup(){
//        // 실제 스프링 웹 컨텍스를 사용해 MockMvc 테스트 환경을 초기화한다.
//        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
//
//    }
//
//    @DisplayName("getAllMembers : 멤버 조회에 성공한다.")
//    @Test
//    public void getAllMembers() throws Exception {
//        // given (데이타 준비
//        Member savedMember = testRepository.save(new Member("홍길동"));
//
//        // when (기능 실행
//        final ResultActions result = mockMvc.perform(get("/test").accept(MediaType.APPLICATION_JSON));
//
//        // then (결과 검증
//        result.andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].id").value(savedMember.getId()))
//                .andExpect(jsonPath("$[0].name").value(savedMember.getName()));
//
//
//    }
//    @AfterEach
//    public void cleanUp(){
//        testRepository.deleteAll();
//
//    }

    @Test
    @DisplayName("GET /test 요청 시 Hello World 반환")
    void getTestAPI() throws Exception {
        // Given: (없음)

        //  When & Then
        mockMvc.perform(get("/test/Hello"))
                .andExpect(status().isOk()) //HTTP 200 확인
                .andExpect(content().string("Hello World")) // 본문 내용 확인
                .andDo(print()); //로그 출력
    }
}