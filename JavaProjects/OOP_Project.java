// Object-Oriented Programming with Java - Project 1
// 1803021040 Berke Küçük
// 1803021038 Sarven Yontan
// 1803021022 Yavuz Savan
// In this program we wanted to create a mini market site. We used Abstract class and added Product class in Book, Food and Phone 
// class with using inheritence (extends).And also added some details on products that we can see on shopping list that we create 
// with arrayList. For choosing between categories, we use switch-case statement. CART (shopcart) interface for adding prices and  
// getting total price. 
//
//
// It got little bit longer than we thought and had problem with logical mistakes, but we solve them. Thanks for giving us that
// kind of project.It really helped us to learn.
//
package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BAZAAR.bazaar();
    }
}

abstract class Product {
    int id;
    String name;
    double price;

    public Product() {}

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

class Book extends Product { 
    String author;
    String brand;
	String publisher;

    Book(int id, String name, double price, String author,String publisher) {
        super(id, name, price);
        this.author = author;
        ;
        this.publisher = publisher;
    }
}

class Phone extends Product {

    private int size;
    private String brand;
    private int memory;
    private String ram;

    public Phone(int id, String name, double price, double size, String brand, String ram, int memory) {
        super();

        this.id = id;
        this.name = name;
        this.price = price;

        this.setSize(size);
        this.setBrand(brand);
        this.setMemory(memory);
        this.setRam(ram);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getSize() {
        return size;
    }

    public void setSize(double size2) {
        this.size = (int) size2;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }
}

class Food extends Product {

    private String setBrand;
    String brand;

    public Food(int id, String name, double price, String brand) {
        super();

        this.id = id;
        this.name = name;
        this.price = price;
        this.brand = brand;

    }

    public String getBrand() {
        return brand;        
    }

    public void setBrand(String brand) {
        this.brand = brand;

    }

	public String getSetBrand() {
		return setBrand;
	}

	public void setSetBrand(String setBrand) {
		this.setBrand = setBrand;
	}

}

class BAZAAR {

    public static void bazaar() {

        CART cart = new CARTImpl();      

        ArrayList < Book > books = new ArrayList < Book > (Arrays.asList(
            new Book(1, "Lord of The Rings", 50, "Tolkien", "Can"),
            new Book(2, "Dune", 65, "Frank Herbert", "Ithaki"),
            new Book(3, "1984", 40, "George Orwell", "Can")
        ));

        ArrayList < Food > foods = new ArrayList < Food > (Arrays.asList(
            new Food(4, "Pizza", 42, "Dominos"),
            new Food(5, "Burger", 34, "Ercan Burger"),
            new Food(6, "Lahmacun", 8, "Mevlana")
        ));

        ArrayList < Phone > phones = new ArrayList < Phone > (Arrays.asList(
            new Phone(7, "Iphone X", 5499, 5.8, "Apple", "3GB", 256),
            new Phone(8, "Note 20", 7899, 6.7, "Samsung", "8GB", 256),
            new Phone(9, "Mi 11", 10250, 6.8, "Xiaomi", "8GB", 128)
        ));

        ArrayList < Product > prods = new ArrayList < Product > ();
        prods.addAll(books);
        prods.addAll(foods);
        prods.addAll(phones);

        Scanner scanner = new Scanner(System.in);

        int option = -1;

        System.out.println("			Welcome to GrandBazaar");
        System.out.println("Please choose the type of the object you like to buy");
        System.out.println("Press 1 to see Book Category");
        System.out.println("Press 2 to see Food Category");
        System.out.println("Press 3 to see Phone Category");
        System.out.println("Press 4 to get total price of the basket");
        System.out.println("Press 5 to Pay");

        boolean found = false;

        while (option != 0) {

            option = scanner.nextInt();

            switch (option) {
            case 1:
                System.out.println("Please choose the book you want to buy");
                for (Book book: books) {
                    System.out.println(book.id + " - " + book.name + " - " + book.author + " - " + book.price+"TL" + " - " + book.publisher);
                }

                int choice = scanner.nextInt();
                found = false;
                for (Book book: books) {
                    if (book.id == choice) {
                        cart.add(book);
                        System.out.println(book.name + " by " + book.author +  " added to basket!");                   
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Book not found");
                }
                break;
            case 2:
                System.out.println("Please choose the food you want to buy");
                for (Food food: foods) {
                	System.out.println(food.id + " - " + food.name + " - " + food.brand + " - " + food.price+"TL");		
                }

                choice = scanner.nextInt();
                found = false;
                for (Food food: foods) {
                    if (food.id == choice) {
                        cart.add(food);
                        System.out.println(food.name + " added to basket!");
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Food not found");
                }
                break;
            case 3:
                System.out.println("Please choose the phone you want to buy");
                System.out.println("    Model      Price     Brand   Ram   Memory");
                for (Phone phone: phones) {
                    System.out.println(phone.id + " - " + phone.name + " - " + phone.price+"TL" + " - " + phone.getBrand() + " - " + phone.getRam() + " - " + phone.getMemory());
                }

                choice = scanner.nextInt();
                found = false;
                for (Phone phone: phones) {
                    if (phone.id == choice) {
                        cart.add(phone);
                        System.out.println(phone.name + " added to basket!");
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Phone not found");
                }
                break;
          

            case 4:
                System.out.println("Total price: " + cart.getPrice()+"TL. " + "Press 5 to PAY");
                break;

            case 5:
                cart.pay();
                System.out.println("Payment successful");
                break;

            default:
                System.out.println("Please enter a valid product...");
            }
        }
    }
}

interface CART {
    void add(Product product);
    double getPrice();
    void pay();
}

class CARTImpl implements CART {

    List < Product > products = new ArrayList < > ();

    
    public void add(Product product) {
        products.add(product);
    }
    
    public double getPrice() {
        double price = 0;

        for (Product product: products) {
            price += product.price;
        }
        return price;
    }
    
    public void pay() {
        products.clear();
    }
}