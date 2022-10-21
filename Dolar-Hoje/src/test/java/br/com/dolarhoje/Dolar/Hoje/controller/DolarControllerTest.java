package br.com.dolarhoje.Dolar.Hoje.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class DolarControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void deveriaDevolver200CasoADataEstejaCorreta() throws Exception {
        String data = "11-25-2021";
        URI uri = new URI("/dolarHoje/" + data);

        mockMvc.perform(MockMvcRequestBuilders
                        .get(uri))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(200));
    }
}
