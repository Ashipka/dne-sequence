package com.shypkao.dne.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shypkao.dne.model.DneRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static com.shypkao.dne.controller.DneRestController.SERVER_ENDPOINT;


@ExtendWith(SpringExtension.class)
    @SpringBootTest
    @AutoConfigureMockMvc
    public class DneRestControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @Test
        public void testServerReturnsFalseForArrayWithoutDneSequence() throws Exception {
            int[] seq = {1, 2, 3, 4, 5};
            DneRequest request = new DneRequest(seq);
            String requestBody = new ObjectMapper().writeValueAsString(request);

            mockMvc.perform(MockMvcRequestBuilders.post(SERVER_ENDPOINT)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(requestBody))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().string("false"));
        }

        @Test
        public void testServerReturnsTrueForArrayWithDneSequence() throws Exception {
            int[] seq = {1, 3, 2, 4, 5};
            DneRequest request = new DneRequest(seq);
            String requestBody = new ObjectMapper().writeValueAsString(request);
            mockMvc.perform(MockMvcRequestBuilders.post(SERVER_ENDPOINT)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(requestBody))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().string("true"));
        }

}
