import java.util.ArrayList;
/**
 * A simple class for holding product information.
 *
 * @author Gabe Hedges
 * @version 9/12/19
 */

public class Product {
	private String productName;
	private String productCode;
	private int productQuantity;
	private String productType;
	private int price;
	private ArrayList<Integer> ratings; 

    // Private member variables go here - you will need to add them yourself.

    /**
     * Product constructor - creates a default product with no name or type and
     * a price of 0.
     */
    public Product() {
    	this.productName ="";
    	this.productType="";
    	this.price = 0;
    	this.ratings = new ArrayList<Integer>();
    	this.productCode="";
    	this.productQuantity=0;
    }

    /**
     * sets the name of the product object
     *
     * @param name
     *            - new name for the product
     */
    public void setName(String name) {
    	productName = name;
    }

    /**
     * returns the name of the product
     *
     * @return the name of the product
     */
    public String getName() {
        return this.productName;
    }

    /**
     * sets the type of the product
     *
     * @param type
     *            - the type of the product
     */
    public void setType(String type) {
    	productType = type;
    }

    /**
     * returns the type of the product
     *
     * @return - the product type
     */
    public String getType() {
        return this.productType;
    }

    /**
     * sets the price of the product in cents. A $10 product will have a price
     * of 1000.
     *
     * @param price
     *            - the price of the product
     */
    public void setPrice(int price) {
    	if (price >= 0) {
        	this.price = price;
    	}  else { System.out.println("Error! Price must be a positive number."); }

    }

    /**
     * returns the price of the product in cents.
     *
     * @return the price of the product
     */
    public int getPrice() {
        return this.price;
    }

    /**
     * sets the count of this product in our inventory.
     *
     * @param quantity
     *            - the number of this product in inventory
     */
    public void setQuantity(int quantity) {
    	if (quantity >= 0) {
        	this.productQuantity = quantity;	
    	} else { System.out.println("Error! Quantity must be a positive number."); }

    }

    /**
     * returns the count of this product in our inventory
     *
     * @return the number of this product in inventory
     */
    public int getQuantity() {
        return this.productQuantity;
    }

    /**
     * sets the inventory code for this product
     *
     * @param code
     *            - the new inventory code for the product
     */
    public void setInventoryCode(String code) {
    	this.productCode = code;
    }

    /**
     * returns the inventory code for this product
     *
     * @return the inventory code of the product
     */
    public String getInventoryCode() {
        return this.productCode;
    }

    /**
     * NOTE: Each individual rating is stored with the product, so you need to
     * maintain a list of user ratings. This method should append a new rating
     * to the end of that list
     *
     * @param rating
     *            - the new rating to add to this product
     */
    public void addUserRating(int rating) {
    	if ((rating <= 5) && (rating >= 0)) {
    		this.ratings.add(rating); }
    	else { System.out.println("Error! Invalid rating. Rating must be between 0 and 5"); }
    	
    }

    /**
     * NOTE: See note on addUserRating above. This method should be written to
     * allow you to access an individual value from the list of user ratings
     *
     * @param index
     *            - the index of the rating we want to see
     *
     * @return the rating indexed by the value index
     */
    public int getUserRating(int index) {
        return this.ratings.get(index);
    }

    /**
     * NOTE: See note on addUserRating above. This method should be written to
     * return the total number of ratings this product has associated with it
     *
     * @return the number of ratings associated with this product
     */
    public int getUserRatingCount() {
        return this.ratings.size();
    }

    /**
     * NOTE: see note on addUserRating above. This method should be written to
     * compute the average user rating on demand from a stored list of ratings.
     *
     * @return the average rating for this product as a whole integer value (use
     *         integer math)
     */
    public int getAvgUserRating() {
    	int index = 0;
    	int total = 0;
    	int average = 0;
    	int numberOfItemsInArray = this.getUserRatingCount();
    	while (index<ratings.size()) { //while the index is less than the size of the arraylist...
    		total += this.ratings.get(index); //Adds each position of arraylist to total
    		index++;
    	}
    	if (numberOfItemsInArray == 0) {
    		return average;
    	} else {
    	average = total/numberOfItemsInArray;
        return average; }
    }
}
