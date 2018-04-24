package com.products.Backend.model;

import java.math.BigDecimal;
import java.util.Date;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name = "product")
public class Product implements Serializable
{
	
		private static final long serialVersionUID = -3009157732242241606L;
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(columnDefinition = "serial")
		private long id;		
		
		@Column(name = "description")	
		private String description;
		
		@Column(name = "date")
		@Temporal(TemporalType.DATE)
		private Date date;
		
		@Column(name = "image")	
		private String image;
		
		@Column(name = "coin")	
		private String coin;
		
		@Column(name = "price")	
		private BigDecimal price;	
		
		@Column(name = "pricer")	
		private BigDecimal pricer;	
		
		@Column(name = "priced")	
		private BigDecimal priced;			
		
		@Column(name = "origen")	
		private String origen;
		
		@Column(name = "category")	
		private String category;
					

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}
				
		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public String getImage() {
			return image;
		}

		public void setImage(String image) {
			this.image = image;
		}

		public String getCoin() {
			return coin;
		}

		public void setCoin(String coin) {
			this.coin = coin;
		}

		public BigDecimal getPrice() {
			return price;
		}

		public void setPrice(BigDecimal price) 
		{
			this.price = price;
			
			if( this.coin != null )
			{
				BigDecimal real = BigDecimal.ONE,
						   dollar = BigDecimal.ONE;
				
				if( this.coin.equals("R$") )
				{	
					real = price;
					dollar = BigDecimal.valueOf(price.doubleValue() / 3.599);
				}	
				else
				{
					real = BigDecimal.valueOf(price.doubleValue() * 3.599);
					dollar = price;	
				}
				
				this.setPricer(real);	
				this.setPriced(dollar);		
					
			}	
			else {}
			
		}

		public BigDecimal getPricer() {
			return pricer;
		}

		public void setPricer(BigDecimal pricer) 
		{
			if( pricer != null )
			    this.pricer = pricer;
		}

		public BigDecimal getPriced() 
		{
			return priced;
		}

		public void setPriced(BigDecimal priced) 
		{
			if( priced != null )
			    this.priced = priced;
		}

		public String getOrigen() {
			return origen;
		}

		public void setOrigen(String origen) {
			this.origen = origen;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}
		
		public Product() {}

		public Product(String description, Date date, String image, String coin, BigDecimal price, BigDecimal pricer, BigDecimal priced, String origen, String category) 
		{
			this.description = description;
			this.date = date;
			this.image = image;
			this.coin = coin;
			this.price = price;
			//this.pricer = pricer;
			//this.priced = priced;
			this.origen = origen;
			this.category = category;
		}
	 
		@Override
		public String toString() 
		{
			return String.format("Product[id=%d, description='%s', date='%s', image='%s', coin='%s', price='%s', pricer='%s', priced='%s', origen='%s', category='%s']", id, description, date, image, coin, price, pricer, priced, origen, category);
		}		
		
  
}
