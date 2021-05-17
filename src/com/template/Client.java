package com.template;

public class Client {
    public static void main(String[] args) {
        HtmlTemplate home = new HomePage();
        home.displayPage();
        HtmlTemplate shoppingCart = new ShoppingCart();
        shoppingCart.displayPage();
    }
}
