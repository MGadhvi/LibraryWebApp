package com.sparta.mg.librarywebapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.annotation.SessionScope;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class LibraryWebAppApplicationTests {

    @Autowired
    MockMvc mvc;

    @Test
    void contextLoads() {
    }
    @Test
    @WithAnonymousUser
    public void checkAuthorsWithAnonLogin() throws Exception {
        mvc.perform(get("/authors"))
                .andExpect(status().is(401));
    }

    @Test
    @WithUserDetails
    public void checkAuthorsWithUserLogin() throws Exception {
        mvc.perform(get("/authors"))
                .andExpect(status().isOk());
    }

    @Test
    @WithUserDetails
    public void checkEditAuthorWithUserLogin() throws Exception {
        mvc.perform(get("/author/edit/3"))
                .andExpect(status().isOk());
    }

    @Test
    @WithUserDetails(value = "admin")
    public void checkAuthorsWithAdminLogin() throws Exception {
        mvc.perform(get("/authors"))
                .andExpect(status().isOk());
    }

    @Test
    @WithUserDetails(value = "admin")
    @SessionScope
    public void checkEditAuthorWithAdminLogin() throws Exception {
        mvc.perform(get("/author/edit/3"))
                .andExpect(status().isOk());
    }
}
