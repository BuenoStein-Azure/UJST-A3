package Models;

import java.util.List; 

public class RestaurantModel {
    private String restaurantName;
    private String locate;
    private int phoneRestaurantNumber;
    private List<String> catalogo;

    public RestaurantModel(String RestaurantName, String Locate, int phoneRestaurantNumber, List<String> catalogo){
        this.restaurantName= RestaurantName;
        this.locate = Locate;
        this.phoneRestaurantNumber = phoneRestaurantNumber;
        this.catalogo = catalogo;
    }

    public String getRestaurantName(){
        return restaurantName;
    }
    public String getLocate(){
        return locate;
    }
    public int getphoneRestaurantNumber(){
        return phoneRestaurantNumber;
    }
    public List<String> getcatalogo(){
        return catalogo;
    }

    public void setRestaurantName(String restaurantName){
        this.restaurantName = restaurantName;
    }
    public void setlocate(String locate){
        this.locate = locate;
    }
    public void setphoneRestaurantNumber(int phoneRestaurantNumber){
        this.phoneRestaurantNumber = phoneRestaurantNumber;
    }
    public void setcatalogo(List<String> catalogo){
        this.catalogo = catalogo;
    }
    }
