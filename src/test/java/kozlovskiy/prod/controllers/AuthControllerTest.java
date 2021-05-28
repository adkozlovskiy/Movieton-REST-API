package kozlovskiy.prod.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import kozlovskiy.prod.entities.User;
import kozlovskiy.prod.repo.AuthRepo;
import kozlovskiy.prod.service.AuthService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AuthController.class)
public class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthRepo authRepo;

    @MockBean
    private AuthService authService;

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void getUserData() throws Exception {
        User response = new User();

        Mockito.when(authService.getUserData(1L)).thenReturn(response);
        mockMvc.perform(get("/api/users")
                .param("user_id", "1"))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void registerUser() throws Exception {
        User user = new User();
        user.setEmail("test@gmail.com");
        user.setPassword("8229193313311");
        user.setSalt("sdf-m1csdc");
        user.setName("Michael");
        user.setNickname("test");

        mockMvc.perform(post("/api/reg")
                .content(asJsonString(user))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    public void authorizeUser() throws Exception {
        User user = new User();
        user.setEmail("test@gmail.com");
        user.setPassword("8229193313311");
        user.setSalt("sdf-m1csdc");
        user.setName("Michael");
        user.setNickname("test");

        mockMvc.perform(post("/api/auth")
                .content(asJsonString(user))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}