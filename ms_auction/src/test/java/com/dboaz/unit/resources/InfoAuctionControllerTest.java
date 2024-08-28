package com.dboaz.unit.resources;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;

import com.dboaz.ms_auction.utils.constants.Route;
import com.dboaz.resources.InfoAuctionController;
import com.dboaz.utils.models.GlobalInfo;

@ActiveProfiles("test")
@WebMvcTest(InfoAuctionController.class)
class InfoAuctionControllerTest {

    @Autowired MockMvc mockMvc;

    @Value("${microservice.ms_auction.name}") String name;
    @Value("${microservice.ms_auction.version}") String version;
    @Value("${microservice.ms_auction.description}") String description;

    @MockBean InfoAuctionController infoAuctionController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetInfo() throws Exception {
        when(infoAuctionController.getInfo()).thenReturn(stub());

        mockMvc.perform(get(Route.GET_INFO))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name").value(name))
            .andExpect(jsonPath("$.version").value(version))
            .andExpect(jsonPath("$.description").value(description));
    }

    protected ResponseEntity<GlobalInfo> stub() {
      var globalInfo = GlobalInfo.builder()
          .name(name).version(version).description(description)
          .build();

      return ResponseEntity.ok(globalInfo);
    }
}