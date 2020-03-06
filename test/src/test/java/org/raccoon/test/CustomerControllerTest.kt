package org.raccoon.test

import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.BDDMockito.then
import org.mockito.Mockito.reset
import org.mockito.Mockito.times
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@RunWith(SpringRunner::class)
@SpringBootTest
@AutoConfigureMockMvc
class CustomerControllerTest{
    @Autowired
    lateinit var mockMvc:MockMvc

    @MockBean
    lateinit var customerService: CustomerService

    @Test
    fun `mock mvc should be configured`(){

    }

    @Test
    fun `we should GET a customer by id`(){
        //Mock
        given(customerService.getCustomer(1))
                .willReturn(Customer(1,"mock customer"))

        mockMvc.perform(get("/customer/1"))
                .andExpect(jsonPath("\$.id").value(1))
                .andExpect(jsonPath("\$.name").value("kotlin"))
                .andDo(print())
        reset(customerService)
    }
//    mockMvc.perform(get("/customer/1"))
//    .andExpect(status().isOk)
//    .andDo(print())
// 결과 확인

    @Test
    fun `we should GET a list of customers`(){
        //Mock
        given(customerService.getAllCustomer())
                .willReturn(listOf(Customer(1,"test"), Customer(2,"mocks")))

        mockMvc.perform(get("/customers"))
                .andExpect(status().isOk)
                .andExpect(jsonPath("\$").isArray)
                .andExpect(jsonPath("\$[0].id").value(1))
                .andExpect(jsonPath("\$[0].name").value("Kotlin"))
                .andExpect(jsonPath("\$[1].id").value(2))
                .andExpect(jsonPath("\$[1].name").value("Spring"))
                .andExpect(jsonPath("\$[2].id").value(3))
                .andExpect(jsonPath("\$[2].name").value("Microservice"))

        then(customerService).should(times(1)).getAllCustomer()
        then(customerService).shouldHaveNoMoreInteractions()

        reset(customerService)
    }
}