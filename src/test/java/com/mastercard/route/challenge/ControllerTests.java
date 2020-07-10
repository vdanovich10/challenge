package com.mastercard.route.challenge;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnNegativeAnswer() throws Exception {
        this.mockMvc.perform(get("/").param("origin", "Albany").param("destination","New York")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("No")));
    }

    @Test
    public void shouldReturnPositiveAnswer() throws Exception {
        this.mockMvc.perform(get("/").param("origin", "Boston").param("destination","Philadelphia")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Yes")));
    }
}

