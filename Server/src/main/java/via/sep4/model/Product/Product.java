package via.sep4.model.Product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import via.sep4.model.Room.Room;

import javax.persistence.*;

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

    public Product(String productName,int quantity,String category,boolean isChilled,Room room)
    {
        this.productName=productName;
        this.quantity=quantity;
        this.category=category;
        this.isChilled=isChilled;
        this.room=room;
    }

    public Product()
    {
    }


    public Long getProductID()
    {
        return productID;
    }

    public void setProductID(Long productID)
    {
        this.productID=productID;
    }

    public String getProductName()
    {
        return productName;
    }

    public void setProductName(String productName)
    {
        this.productName=productName;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity=quantity;
    }

    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category=category;
    }

    public boolean getIsChilled()
    {
        return isChilled;
    }

    public void setIsChilled(boolean isChilled)
    {
        this.isChilled=isChilled;
    }
    @JsonBackReference
    public Room getRoom()
    {
        return room;
    }

    public void setRoom(Room room)
    {
        this.room=room;
    }
}
