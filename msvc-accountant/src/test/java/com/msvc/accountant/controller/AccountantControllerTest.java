package com.msvc.accountant.controller;

import com.msvc.accountant.entities.Accountant;
import com.msvc.accountant.projection.AccountantProjection;
import com.msvc.accountant.services.AccountantService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;
import java.util.Collections;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * @author David Santiago
 */
@WebMvcTest(AccountantController.class)
public class AccountantControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountantService accountantService;

    @Test
    void testCreateAccountant() throws Exception {
        Accountant accountant = Accountant.builder()
                .id(1L)
                .dni("12345678")
                .firstName("John")
                .lastName("Doe")
                .email("john.doe@example.com")
                .address("123 Main St")
                .phone("555-5555")
                .createOn(LocalDateTime.now())
                .build();

        when(accountantService.create(any(Accountant.class))).thenReturn(accountant);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/accountant")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"dni\": \"12345678\", \"firstName\": \"John\", \"lastName\": \"Doe\", \"email\": \"john.doe@example.com\", \"address\": \"123 Main St\", \"phone\": \"555-5555\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.dni").value("12345678"))
                .andExpect(jsonPath("$.firstName").value("John"))
                .andExpect(jsonPath("$.lastName").value("Doe"))
                .andExpect(jsonPath("$.email").value("john.doe@example.com"))
                .andExpect(jsonPath("$.address").value("123 Main St"))
                .andExpect(jsonPath("$.phone").value("555-5555"))
                .andDo(print());
    }

    @Test
    void testFindAllAccountants() throws Exception {
        AccountantProjection accountantProjection = new AccountantProjection() {
            @Override
            public Long getId() {
                return 1L;
            }

            @Override
            public String getDni() {
                return "12345678";
            }

            @Override
            public String getFirstName() {
                return "John";
            }

            @Override
            public String getEmail() {
                return "john.doe@example.com";
            }
        };

        when(accountantService.findAllProjection()).thenReturn(Collections.singletonList(accountantProjection));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/accountant"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].dni").value("12345678"))
                .andExpect(jsonPath("$[0].firstName").value("John"))
                .andExpect(jsonPath("$[0].email").value("john.doe@example.com"))
                .andDo(print());
    }

    @Test
    void testFindById() throws Exception {
        Accountant accountant = Accountant.builder()
                .id(1L)
                .dni("12345678")
                .firstName("John")
                .lastName("Doe")
                .email("john.doe@example.com")
                .address("123 Main St")
                .phone("555-5555")
                .createOn(LocalDateTime.now())
                .build();

        when(accountantService.findById(1L)).thenReturn(accountant);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/accountant/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.dni").value("12345678"))
                .andExpect(jsonPath("$.firstName").value("John"))
                .andExpect(jsonPath("$.lastName").value("Doe"))
                .andExpect(jsonPath("$.email").value("john.doe@example.com"))
                .andExpect(jsonPath("$.address").value("123 Main St"))
                .andExpect(jsonPath("$.phone").value("555-5555"))
                .andDo(print());
    }

    @Test
    void testUpdateAccountant() throws Exception {
        Accountant accountant = Accountant.builder()
                .id(1L)
                .dni("12345678")
                .firstName("John")
                .lastName("Doe Updated")
                .email("john.doe@example.com")
                .address("123 Main St")
                .phone("555-5555")
                .updateOn(LocalDateTime.now())
                .build();

        when(accountantService.update(any(Accountant.class))).thenReturn(accountant);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/accountant")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\": 1, \"dni\": \"12345678\", \"firstName\": \"John\", \"lastName\": \"Doe Updated\", \"email\": \"john.doe@example.com\", \"address\": \"123 Main St\", \"phone\": \"555-5555\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.dni").value("12345678"))
                .andExpect(jsonPath("$.firstName").value("John"))
                .andExpect(jsonPath("$.lastName").value("Doe Updated"))
                .andExpect(jsonPath("$.email").value("john.doe@example.com"))
                .andExpect(jsonPath("$.address").value("123 Main St"))
                .andExpect(jsonPath("$.phone").value("555-5555"))
                .andDo(print());
    }

    @Test
    void testDeleteAccountant() throws Exception {
        Mockito.doNothing().when(accountantService).delete(1L);

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/accountant/1"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
