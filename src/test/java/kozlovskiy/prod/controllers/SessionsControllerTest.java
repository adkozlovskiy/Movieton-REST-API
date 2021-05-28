package kozlovskiy.prod.controllers;

import kozlovskiy.prod.entities.Session;
import kozlovskiy.prod.repo.SessionRepo;
import kozlovskiy.prod.service.SessionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(SessionsController.class)
public class SessionsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SessionRepo sessionRepo;

    @MockBean
    private SessionService sessionService;


    @Test
    public void getSessionsByMovieId() throws Exception {
        List<Session> response = new ArrayList<>() {{
            add(new Session());
        }};

        Mockito.when(sessionService.getSessionsByMovieId(1L)).thenReturn(response);
        mockMvc.perform(get("/api/sessions/on_movie")
                .param("movie_id", "1"))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void getSession() throws Exception {
        Session response = new Session();

        Mockito.when(sessionService.getSession(1L)).thenReturn(response);
        mockMvc.perform(get("/api/sessions")
                .param("session_id", "1"))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }
}