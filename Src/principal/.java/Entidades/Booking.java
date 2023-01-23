@@ -0,0 +1,71 @@
Entidades do pacote ;


Reserva de classe pública {
    sobrenome privado da cadeia de caracteres;
    nome particular da cadeia de caracteres ;
    preço total do flutuador privado;
    depósito booleano privadopago;
    privado BookingDatas de reserva;
    necessidades adicionais de cadeia de caracteres privadas;

    public Booking(String firstName, String  lastName, float totalPrice, boolean depositPaid, BookingDates bookingDates, String additionalNeeds) {
        isso. nomenário = nome-próprio;
        isso. sobrenome = sobrenome;
        isso. totalprice = totalPrice;
        isso. depositpaid = depositPaid;
        isso. bookingdates = bookingDates;
        isso. necessidades adicionais = necessidades adicionais;
    }

    flutuação pública getTotalprice() {
        retorno totalpreço;
    }

    public void setTotalprice(float totalprice) {
        isso. preço total = preço total;
    }

    público booleano getDepositpaid() {
        depósito de retornopago ;
    }

    conjunto nulo públicoDepositpaid(depósito booleanopago ) {
        isso. depositpaid = depositpaid;
    }

     public String getAdditionalneeds() {
        necessidades adicionais de retorno;
    }

    public void setAdditionalneeds(String additionalneeds) {
        isso. necessidades adicionais = necessidades adicionais;
    }

     público BookingDates getBookingdates() {
        datas de reserva de retorno;
    }

    conjunto de vazios públicosDatas de reserva(Datas de reservasdatas de reserva) {
        isso. bookingdates = bookingdates;
    }

    public String getLastname() {
        retornar sobrenome;
    }

    public void setLastname(String sobrenome) {
        isso. sobrenome = sobrenome;
    }

    cadeia de caracteres pública getFirstname() {
        retornar o nome próprio;
    }

    public void setFirstname(Nome da cadeia de caracteres) {
        isso.  nome próprio = nome próprio;
    }



}
