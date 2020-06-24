package com.guitar.store.guitarstoremanager.controller;

import com.guitar.store.guitarstoremanager.dto.GuitarDTO;
import com.guitar.store.guitarstoremanager.dto.MessageResponseDTO;
import com.guitar.store.guitarstoremanager.service.GuitarService;
import com.guitar.store.guitarstoremanager.utils.GuitarUtils;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.net.URI;

import static com.guitar.store.guitarstoremanager.utils.GuitarUtils.asJsonString;
import static com.guitar.store.guitarstoremanager.utils.GuitarUtils.createFakeGuitarDTO;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class GuitarControllerTest {

    private static final String BOOK_API_URL_PATH = "/api/v1/guitars";
    private MockMvc mockMvc;

    @Mock
    private GuitarService guitarService;

    @InjectMocks
    private GuitarController guitarController;


    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(guitarController)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .setViewResolvers((viewName,locale) -> new MappingJackson2JsonView()).build();
    }
    @Test
    void testWhenPOSTisCalledThenAGuitarShouldBeCreated() throws Exception {
        GuitarDTO guitarDTO = createFakeGuitarDTO();
        MessageResponseDTO expectedMessageResponse = MessageResponseDTO.builder()
                .message("Guitar created with ID " + guitarDTO.getId())
                .build();

        when(guitarService.create(guitarDTO)).thenReturn(expectedMessageResponse);

        mockMvc.perform(post(BOOK_API_URL_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(guitarDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message", Is.is(expectedMessageResponse.getMessage())));
    }

}
