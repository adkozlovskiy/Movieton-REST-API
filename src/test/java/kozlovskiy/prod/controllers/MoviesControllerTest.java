package kozlovskiy.prod.controllers;

import kozlovskiy.prod.entities.Movie;
import kozlovskiy.prod.repo.MovieRepo;
import kozlovskiy.prod.service.MoviesService;
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
@WebMvcTest(MoviesController.class)
public class MoviesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovieRepo movieRepo;

    @MockBean
    private MoviesService moviesService;

    @Test
    public void getMovies() throws Exception {
        List<Movie> response = new ArrayList<>() {{
            add(new Movie());
        }};

        Mockito.when(moviesService.getMovies()).thenReturn(response);
        mockMvc.perform(get("/api/movies"))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }
}
