package com.demo.data.domain;

import com.demo.data.domain.base.BaseDomain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the product_pic database table.
 * 
 */
@Entity
@Table(name="product_pic")
@NamedQuery(name="ProductPic.findAll", query="SELECT p FROM ProductPic p")
public class ProductPic extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PRODUCT_PIC_ID", unique=true, nullable=false)
	private int productPicId;

	@Column(name="IS_VALID", nullable=false)
	private boolean isValid;

	@Column(nullable=false, length=200)
	private String path;

	@Column(nullable=false)
	private byte type;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="PRODUCT_ID", nullable=false)
	private Product product;

	public ProductPic() {
	}

	public int getProductPicId() {
		return this.productPicId;
	}

	public void setProductPicId(int productPicId) {
		this.productPicId = productPicId;
	}

	public boolean getIsValid() {
		return this.isValid;
	}

	public void setIsValid(boolean isValid) {
		this.isValid = isValid;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public byte getType() {
		return this.type;
	}

	public void setType(byte type) {
		this.type = type;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}