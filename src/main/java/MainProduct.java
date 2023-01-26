public class MainProduct {
    public static void main(String[] args) {

        Product product1 = new Product("lollipop", 2.22);
        Product product2 = new Product("Candy-bar", 0.53);
        Product product3 = new Product("marshmallow", 1.05);
        Product product4 = new Product("waffle", 0.75);


        CartItem cartItem1 = new CartItem(product1, 1);
        CartItem cartItem2 = new CartItem(product2, 1);
        CartItem cartItem3 = new CartItem(product3, 1);
        CartItem cartItem4 = new CartItem(product4, 1);


        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addProduct(product1, 1);
        shoppingCart.addProduct(product2, 1);
        shoppingCart.addProduct(product3, 1);
        shoppingCart.addProduct(product4, 1);

        shoppingCart.printItems();

        shoppingCart.removeProduct(product2);

        shoppingCart.printItems();

        System.out.println("--------------");

        shoppingCart.updateProduct(product1, 3);

        System.out.println("--------------");

        shoppingCart.printItems();

        System.out.println("--------------");

        shoppingCart.printReceipt();

        System.out.println("--------------");

        shoppingCart.getTotalQuantity();

        System.out.println("--------------");

        shoppingCart.getTotalSum();


    }
}
