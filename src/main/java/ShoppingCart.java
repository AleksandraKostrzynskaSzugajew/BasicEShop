import java.util.Arrays;

public class ShoppingCart {

    private CartItem[] cartItems;

    public ShoppingCart() {
        cartItems = new CartItem[0];
    }

    public void addProduct(Product product, int quantity) {
        int positionToFind = findProduct(product);
        if (positionToFind >= 0) {
            int newQuantity = cartItems[positionToFind].getQuantity() + quantity;
            updateProduct(product, newQuantity);
        } else {
            CartItem cartItem = new CartItem(product, quantity);
            cartItems = Arrays.copyOf(cartItems, cartItems.length + 1);
            cartItems[cartItems.length - 1] = cartItem;
        }
    }

    public void removeProduct(Product product) {

        //searching for position to remove
        int positionToRemove = findProduct(product);

        //checking if the array is empty or index is out of bounds
        if (cartItems == null || positionToRemove < 0 || positionToRemove >= cartItems.length) {
            System.out.println("Position not found, cannot be removed.");
        }

        // creating an array to hold elements after deletion
        CartItem[] copyArray = new CartItem[cartItems.length - 1];

        // copying elements from original array from beginning till index into copyArray
        System.arraycopy(cartItems, 0, copyArray, 0, positionToRemove);

        // copying elements from original array from index+1 till end into copyArray
        System.arraycopy(cartItems, positionToRemove + 1, copyArray, positionToRemove, cartItems.length - positionToRemove - 1);

        //copying copyArray to cartItems and decreasing by 1 cause willing to safe an array from this class
        cartItems = Arrays.copyOf(copyArray, cartItems.length - 1);
    }

    public int findProduct(Product product) {
        int index = -1;
        for (int i = 0; i < cartItems.length - 1; i++) {
            if (cartItems[i].getProduct().getId() == product.getId()) {
                index = i;
            }
        }
        System.out.println("Sorry, such positions does not exist on your list");
        return index;
    }

    public void updateProduct(Product product, int quantity) {
        int positionToUpdate = findProduct(product);
        if (positionToUpdate >= 0) {
            cartItems[positionToUpdate].setQuantity(quantity);
            System.out.println("Successfully updated " + product.getName() + " with new quantity of " + quantity);
        }
    }

    public int getTotalQuantity() {
        int count = 0;
        for (int i = 0; i < cartItems.length; i++) {
            count += cartItems[i].getQuantity();
        }
        System.out.println("Currently total quantity is : " + count);
        return count;
    }

    public double getTotalSum() {
        double totalSum = 0;
        for (int i = 0; i < cartItems.length; i++) {
            totalSum += (cartItems[i].getProduct().getPrice() * cartItems[i].getQuantity());
        }
        System.out.print("Currently total price is : " + totalSum);
        return totalSum;
    }

    public void printReceipt() {

        System.out.println("Current content of Your basket : ");
        double sum = 0;
        for (int i = 0; i < cartItems.length; i++) {

            System.out.println(cartItems[i].getProduct().getId() +
                    " : " + cartItems[i].getProduct().getName() + ", "
                    + cartItems[i].getQuantity() + "x" + cartItems[i].getProduct().getPrice()
                    + " = " + (cartItems[i].getQuantity() * cartItems[i].getProduct().getPrice()));


            sum += cartItems[i].getQuantity() * cartItems[i].getProduct().getPrice();
        }
        System.out.println("---");
        System.out.println("Razem: " + sum);

    }

    public void printItems() {
        for (CartItem cartItem : cartItems) {
            System.out.println(cartItem);
        }
        System.out.println("All done");
    }
}
