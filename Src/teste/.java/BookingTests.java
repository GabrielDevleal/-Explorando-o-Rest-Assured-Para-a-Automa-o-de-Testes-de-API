importar Entidades. Reserva;
importar Entidades. Datas de Reserva;
importar Entidades. Utilizador;
importar com. github. javafaker. Impostor;
importação io. inquieto. Tranquilidade;
importação io. inquieto. filtro. log. ErrorLoggingFilter;
importação io. inquieto. filtro. log. RequestLoggingFilter (Filtro de SolicitaçãoLog);
importação io. inquieto. filtro. log. ResponseLoggingFilter (Filtro de Registro de Resposta);
importação io. inquieto. Disponível em: http. Tipo de Conteúdo;
importação io. inquieto. resposta. Resposta;
importação io. inquieto. especificação. RequestSpecification (em inglês);
importar organização. junit. Júpiter. api.*;

importar io estático. inquieto. Fique tranquilo. dado;
importar io estático. inquieto. config. LogConfig. logConfig;
importar io estático. inquieto. módulo. jsv. JsonSchemaValidator.*;
importar organização estática. hamcrest. Correspondências.*;

java de importação. texto. Método SimpleDateFormat;
java de importação. util. HashMap (em inglês);
java de importação. util. Mapa;
java de importação. util. simultânea. Unidade de Tempo;

BookingTests de classe pública {
    token de cadeia de caracteres estático público = "";
    falsificador de falsificação  estático público;
    solicitação RequestSpecification estática  privada;
    Reserva estática  privada Reserva;
     privado estático BookingDates bookingDates ;
    usuário estático privado Usuário;

    @AntesTudo
    configuração de vazio estático público(){
        Fique tranquilo. baseURI = "https://restful-booker.herokuapp.com";
        faker = novo Faker();
         usuário = novo usuário(faker. nome(). nome de usuário(),
                falsificação. nome(). nome(),
                falsificação. nome(). sobrenome(),
                falsificação. internet(). safeEmailAddress(),
                falsificação. internet(). senha(8,10),
                falsificação. número de telefone(). toString());

        SimpleDateFormat sdf = novo SimpleDateFormat("aaaa-MM-dd" );
        bookingDates = novas BookingDates(sdf. format(faker. data(). passado(1, TimeUnit. DIAS)), sdf. format(faker. data(). future(1, TimeUnit. DIAS)));
        reserva = nova Reserva (usuário. getFirstName(), usuário. getLastName(),
                (flutuação) falsificação. número(). randomDouble(2, 50, 100000),
                falsificação. bool(). bool(), bookingDates, "");
        Fique tranquilo. filtros(novo RequestLoggingFilter(), novo ResponseLoggingFilter(), novo   ErrorLoggingFilter());
    }

    @AntesCada um
    void setRequest(){
        request = given(). config(RestAssured. config(). logConfig(logConfig(). enableLoggingOfRequestAndResponseIfValidationFails()))
 . contentType(ContentType. JSON)
 . auth(). basic("admin", "password123")
        ;
    }

    @Testar // Criar reserva
    createBooking_WithValidData_returnOk de nulidade pública(){
        pedir
 . contentType(ContentType. JSON)
 . quando()
 . corpo(reserva))
 . post("/reserva")
 . então()
 . body(correspondeJsonSchemaInClasspath("createBookingRequestSchema.json"))
 . e()
 . afirmarQue()
 . statusCode(200)
 . contentType(ContentType. JSON). e(). tempo (lessThan(2000L))
 . extrair()
 . jsonPath()
        ;
    }

    @Testar // criar token
    public void createAuthToken(){
        Map<String, String> body = new HashMap<>();
        body.put("username", "admin");
        body.put("password", "password123");

        token = request
            .header("ContentType", "application/json") //.contentType(ContentType.JSON)
            .when()
                .body(body)
                .post("/auth")
            .then()
                .assertThat()
                .statusCode(200)
            .extract()
                .path("token")
        ;
    }

    @Test // Get Booking id list
    public void getAllBookingIds_returnOk(){
        Response response = request
            .when()
                .get("/booking")
            .then()
                .extract()
                .response()
        ;

        Assertions.assertNotNull(response);
        Assertions.assertEquals(200, response.statusCode());
    }

    @Test // Get booking by id
    public void getBookingById_returnOk(){
        request
            .when()
                .get("/booking/" + faker.number().digits(1))
            .then()
                .assertThat()
                .statusCode(200)
        ;
    }

    @Test // Get bookings by user first name
    public void getAllBookingsByUserFirstName_BookingExists_returnOk(){
        request
            .when()
                .queryParam("firstName", faker.name().firstName())
                .get("/booking")
 . então()
 . afirmarQue()
 . statusCode(200)
 . contentType(ContentType. JSON)
 . e()
 . corpo("resultados", temSize(maiorQue(0)))
        ;
    }

    @Teste // Obter reservas por preço específico
    getAllBookingsByPrice_BookingExists_returnOk de vazio público(){
        pedir
 . quando()
 . queryParam("totalprice", falsificador. número(). dígitos(4))
 . get("/reserva))
 . então()
 . afirmarQue()
 . statusCode(200)
 . contentType(ContentType. JSON)
 . e()
 . corpo("resultados", temSize(maiorQue(0)))
        ;
    }

    @Testar // Excluir reserva
    deleteBookingById_returnOk de nulidade pública(){
        pedir
 . header("Cookie", "token=". concat(token))
 . quando()
 . delete("/booking/" + faker. número(). dígitos(2))
 . então()
 . afirmarQue()
 . statusCode(201)
        ;
    }

    @Teste // Verificação de integridade
    apiIsUpCheck_returnCreated de vazio público(){
        pedir
 . quando()
 . get("/ping))
 . então()
 . afirmarQue()
 . statusCode(201)
        ;
    }
}
