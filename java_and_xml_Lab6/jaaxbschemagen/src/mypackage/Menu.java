
package mypackage;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "food"
})
@XmlRootElement(name = "menu")
public class Menu {

    @XmlElement(required = true)
    protected List<Menu.Food> food;

    /**
     * Gets the value of the food property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the food property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFood().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Menu.Food }
     * 
     * 
     */
    public List<Menu.Food> getFood() {
        if (food == null) {
            food = new ArrayList<Menu.Food>();
        }
        return this.food;
    }



    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "name",
        "price",
        "description",
        "calories"
    })

    public static class Food {

        @XmlElement(required = true)
        protected String name;
        @XmlElement(defaultValue = "1")
        protected float price;
        @XmlElement(required = true, defaultValue = "")
        protected String description;
        protected int calories;
        @XmlAttribute(name = "category", required = true)
        protected String category;

        /**
         * Gets the value of the name property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getName() {
            return name;
        }

        /**
         * Sets the value of the name property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setName(String value) {
            this.name = value;
        }

        /**
         * Gets the value of the price property.
         * 
         */
        public float getPrice() {
            return price;
        }

        /**
         * Sets the value of the price property.
         * 
         */
        public void setPrice(float value) {
            this.price = value;
        }

        /**
         * Gets the value of the description property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDescription() {
            return description;
        }

        /**
         * Sets the value of the description property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDescription(String value) {
            this.description = value;
        }

        /**
         * Gets the value of the calories property.
         * 
         */
        public int getCalories() {
            return calories;
        }

        /**
         * Sets the value of the calories property.
         * 
         */
        public void setCalories(int value) {
            this.calories = value;
        }

        /**
         * Gets the value of the category property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCategory() {
            return category;
        }

        /**
         * Sets the value of the category property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCategory(String value) {
            this.category = value;
        }

    }

}
