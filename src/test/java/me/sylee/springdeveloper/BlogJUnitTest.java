package me.sylee.springdeveloper;

import me.sylee.springdeveloper.domain.Article;
import me.sylee.springdeveloper.repository.BlogRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

// 아래 스태틱 임포트들이 있어야 get(), jsonPath()를 사용할 수 있습니다.
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest // 테스트용 애플리케이션 컨텍스트 생성
@AutoConfigureMockMvc // MockMvc 생성 및 자동 설정
public class BlogJUnitTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    private BlogRepository blogRepository; // @Autowired가 있어야 null이 안 됩니다.

    @DisplayName("findAllArticles: 블로그 글 목록 조회에 성공한다.")
    @Test
    public void findAllArticles() throws Exception {
        // Given
        blogRepository.deleteAll();

        // 첫 번째 글 삽입
        blogRepository.save(Article.builder()
                .title("제목1")
                .content("내용1")
                .build());

        // 두 번째 글 삽입
        blogRepository.save(Article.builder()
                .title("제목2")
                .content("내용2")
                .build());

        // When
        final ResultActions resultActions = mockMvc.perform(get("/api/articles")
                .accept(MediaType.APPLICATION_JSON_VALUE));

        // Then
        resultActions
                .andExpect(status().isOk())

                .andExpect(jsonPath("$[0].title").value("제목1"))
                .andExpect(jsonPath("$[0].content").value("내용1"))

                .andExpect(jsonPath("$[1].title").value("제목2"))
                .andExpect(jsonPath("$[1].content").value("내용2"));
    }
}