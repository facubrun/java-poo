public class Principal {
    // Function total price
    public static float totalPrice(float priceUd, int quantity) {
        float total = priceUd * quantity;
        return total;
    }

    public static void main(String[] args) throws Exception { // static indica que el método pertenece a la clase y no a un objeto
        float price1 = totalPrice(20.50f, 3);
        float price2 = totalPrice(500f,  22);
    
        System.out.println("Total price 1: " + price1);
        System.out.println("Total price 2: " + price2);
    }
}