package com.guitar.store.guitarstoremanager.api.controller;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(MockitoExtension.class)
public class GuitarControllerTest {

    private static final String BOOK_API_URL_PATH = "/api/v1/guitars";
/*    private MockMvc mockMvc;

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
        GuitarModel guitarModel = createFakeGuitarDTO();
        MessageResponseDTO expectedMessageResponse = MessageResponseDTO.builder()
                .message("Guitar created with ID " + guitarModel.getId())
                .build();

        when(guitarService.create(guitarModel)).thenReturn(expectedMessageResponse);

        mockMvc.perform(post(BOOK_API_URL_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(guitarModel)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message", Is.is(expectedMessageResponse.getMessage())));
    }*/

}
