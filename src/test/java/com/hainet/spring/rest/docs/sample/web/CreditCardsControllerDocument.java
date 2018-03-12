package com.hainet.spring.rest.docs.sample.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CreditCardsController.class)
@AutoConfigureRestDocs(outputDir = "docs")
public class CreditCardsControllerDocument {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void creditCardsDocument() throws Exception {
        this.mockMvc.perform(get("/creditcards"))
            .andExpect(status().isOk())
                .andDo(document("creditcards-document",
                        responseFields(
                                fieldWithPath("id").description("The id of this credit card. e.g. 1"),
                                fieldWithPath("number").description("The number of this credit card. e.g. 1234-5678-9012-3456"),
                                fieldWithPath("holder").description("The holder of this credit card.  e.g. HAINE TAKANO"),
                                fieldWithPath("goodThru").description("The goodthru of this credit card. e.g. 2020/12"),
                                fieldWithPath("securityCode").description("The security code of this credit card. e.g. 123"),
                                fieldWithPath("securePassword").description("The secure password of this credit card. e.g. 12345")
                        )));
    }
}
