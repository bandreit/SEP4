package via.sep4.model.Product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import via.sep4.model.Room.Room;

import javax.persistence.*;

/**
 * The type Product.
 */
@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column(updatable = false, name="productid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productID;
    @Column(updatable = false, name="productname")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String productName;
    @Column(updatable = false, name="quantity")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private int quantity;
    @Column(updatable = false, name="category")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String category;
    @Column(updatable = false, name="ischilled")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private boolean isChilled;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "roomid", nullable = false)
    private Room room;

    /**
     * Instantiates a new Product.
     *
     * @param productName the product name
     * @param quantity    the quantity
     * @param category    the category
     * @param isChilled   the is chilled
     * @param room        the room
     */
    public Product(String productName,int quantity,String category,boolean isChilled,Room room)
    {
        this.productName=productName;
        this.quantity=quantity;
        this.category=category;
        this.isChilled=isChilled;
        this.room=room;
    }

    /**
     * Instantiates a new Product.
     */
    public Product()
    {
    }


    /**
     * Gets product id.
     *
     * @return the product id
     */
    public Long getProductID()
    {
        return productID;
    }

    /**
     * Sets product id.
     *
     * @param productID the product id
     */
    public void setProductID(Long productID)
    {
        this.productID=productID;
    }

    /**
     * Gets product name.
     *
     * @return the product name
     */
    public String getProductName()
    {
        return productName;
    }

    /**
     * Sets product name.
     *
     * @param productName the product name
     */
    public void setProductName(String productName)
    {
        this.productName=productName;
    }

    /**
     * Gets quantity.
     *
     * @return the quantity
     */
    public int getQuantity()
    {
        return quantity;
    }

    /**
     * Sets quantity.
     *
     * @param quantity the quantity
     */
    public void setQuantity(int quantity)
    {
        this.quantity=quantity;
    }

    /**
     * Gets category.
     *
     * @return the category
     */
    public String getCategory()
    {
        return category;
    }

    /**
     * Sets category.
     *
     * @param category the category
     */
    public void setCategory(String category)
    {
        this.category=category;
    }

    /**
     * Gets is chilled.
     *
     * @return the is chilled
     */
    public boolean getIsChilled()
    {
        return isChilled;
    }

    /**
     * Sets is chilled.
     *
     * @param isChilled the is chilled
     */
    public void setIsChilled(boolean isChilled)
    {
        this.isChilled=isChilled;
    }

    /**
     * Gets room.
     *
     * @return the room
     */
    @JsonBackReference
    public Room getRoom()
    {
        return room;
    }

    /**
     * Sets room.
     *
     * @param room the room
     */
    public void setRoom(Room room)
    {
        this.room=room;
    }
}
