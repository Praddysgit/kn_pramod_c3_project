import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();
    
    public static void main(String[] args) throws NumberFormatException, IOException {

    	//ADDING RESTAURANTS FOR TESTING
		LocalTime openingTime = LocalTime.parse("10:30:00");
        LocalTime closingTime = LocalTime.parse("22:00:00");
		Restaurant restaurant;
		restaurant =new Restaurant("Amelie's cafe","Chennai",openingTime,closingTime);
        restaurant.addToMenu("Sweet corn soup",119);
        restaurant.addToMenu("Vegetable lasagne", 269);
		restaurants.add(restaurant);
		

		Restaurant restaurant2;
		restaurant2	=	new Restaurant("Halli Mane","Bengaluru",openingTime,closingTime);
		restaurant2.addToMenu("Tomato soup",119);
		restaurant2.addToMenu("Mutton Paya", 269);
		restaurants.add(restaurant2);
       // System.out.println("res::"+restaurants.size());
    			
    	RestaurantService service	=	new RestaurantService();
    	service.paamiNanMaga();
    }

    public Restaurant findRestaurantByName(String restaurantName){
    	
    	
    	//doesn't work with string  - it is not string - but ojbect.
 		//boolean isFound	=	restaurants.contains(restaurantName);
    	//System.out.println("found 111::"+isFound);
    	
    	//Using Stream API
    	//restaurantFound	=	restaurants.stream().filter(restaurantFound -> restaurantName.equals(restaurantFound.getName())).findAny().orElse(null);
 		
    	//Iterator
    	    Iterator<Restaurant> iterator = restaurants.iterator();
    	    while (iterator.hasNext()) {
    	        Restaurant res = iterator.next();
    	        if (res.getName().equals(restaurantName)) {
    	        	//System.out.println("found::"+res.getName());
    	            return res;
    	        }
    	    }
    	    
    	    
    	
        return null;
        //DELETE ABOVE STATEMENT AND WRITE CODE HERE
        
        
    }


    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        restaurants.remove(restaurantToBeRemoved);
        return restaurantToBeRemoved;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
    
    
    //Test
    public void paamiNanMaga() throws NumberFormatException, IOException {
    	

        //FIND RESTAURANT BY NAME
        RestaurantService service	=	new RestaurantService();
        
        
        //get the restaurant menus
        
        
        
        //Read input from console for switch choices
    	BufferedReader br	=	new BufferedReader(new InputStreamReader(System.in));
    	
    	System.out.println("Enter 1 for Show Restaurants");
    	System.out.println("Enter 2 for Search Restaurant");
    	System.out.println("Enter 3 for Show Restaurant Menu");
    	System.out.println("\n\n");
    	
    	System.out.println("Enter the choice:");
    	int reqNumb	=	Integer.parseInt(br.readLine());
    	String restName		=	"";
    	Restaurant userRest	=	null;
    	
        switch(reqNumb) {
        case 1:
    		System.out.println("Available Restaurant are");
        	for(Restaurant res: restaurants)
        		System.out.println("Restaurant Name::"+res.getName());
        	paamiNanMaga();
        	break;
        	
        case 2:
    		System.out.println("Enter Restaurant Name");
        	restName	=	(br.readLine());
        	userRest	=	service.findRestaurantByName(restName);
        	if(userRest!=null)
        		System.out.println("Restaurant found and name is::"+userRest.getName());
        	else
        		System.out.println("Restaurant not Found");
        	paamiNanMaga();
        	break;
        
        case 3:
        	System.out.println("Enter the Restaurant Name:");

        	restName	=	(br.readLine());
        	userRest	=	service.findRestaurantByName(restName);
        	for(Item item : userRest.getMenu()) {
        		System.out.println(item.toString());
        	}
        	paamiNanMaga();
        	break;
        	

        default :
        	System.out.println("nothing found");
        	break;
        }
        
        	
        
	
    	
    }
}
