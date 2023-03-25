// @Test
// void testUpdatePerson() throws Exception {

//     // PATCH запрос
//     MockHttpServletResponse responsePost = mockMvc
//         .perform(
//             // Выполняем PATCH запрос
//             patch("/company/1")
//                 // Устанавливает тип содержимого и тело запроса
//                 .contentType(MediaType.APPLICATION_JSON)
//                 .content("{\"name\": \"Gooogle\"}");
//         )
//         // Выполняем запрос и получаем ответ
//         .andReturn()
//         .getResponse();
//     // Так можно получить статус ответа
//     int status = responsePost.getStatus();

//     // DELETE запрос
//     MockHttpServletResponse responsePost = mockMvc
//         .perform(delete("/company/1"))
//         .andReturn()
//         .getResponse();

// }
