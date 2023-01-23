@@ -0,0 +1,29 @@
Entidades do pacote ;

classe pública BookingDates {

    check-in privado de cadeia de caracteres;
    check-out privado de cadeia de caracteres;
    BookingDates públicas(Check-in de cadeia de caracteres, Check-out de cadeias de caracteres) {
        isso. checkin = check-in;
        isso. checkout = check-out;
    }

    getCheckin de cadeia de caracteres pública() {
        check-in de retorno;
    }

    public void setCheckin(Checkin de cadeia de caracteres) {
        isso. checkin = check-in;
    }

    getCheckout de cadeia de caracteres pública() {
        retorno do checkout;
    }

    public void setCheckout(Checkout de cadeia de caracteres ) {
        isso. checkout = check-out;
    }


}
