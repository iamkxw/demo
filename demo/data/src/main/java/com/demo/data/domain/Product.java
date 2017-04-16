package com.demo.data.domain;

import com.demo.data.domain.base.BaseDomain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@Table(name="product")
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PRODUCT_ID", unique=true, nullable=false)
	private Integer productId;

	@Column(name="`DESC`", length=255)
	private String desc;

	@Column(nullable=false, length=45)
	private String name;

	@Column(nullable=false)
	private Byte status;

	@Column(name="UNIT_PRICE", nullable=false)
	private Integer unitPrice;

	//bi-directional many-to-one association to OrderDetail
	@OneToMany(mappedBy="product")
	private List<OrderDetail> orderDetails;

	//bi-directional many-to-one association to Vendor
	@ManyToOne
	@JoinColumn(name="VENDOR_ID", nullable=false)
	private Vendor vendor;

	//bi-directional many-to-one association to ProductPic
	@OneToMany(mappedBy="product")
	private List<ProductPic> productPics;

	public Product() {
	}

	public Integer getProductId() {
		return this.productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Byte getStatus() {
		return this.status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public Integer getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}

	public List<OrderDetail> getOrderDetails() {
		return this.orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public OrderDetail addOrderDetail(OrderDetail orderDetail) {
		getOrderDetails().add(orderDetail);
		orderDetail.setProduct(this);

		return orderDetail;
	}

	public OrderDetail removeOrderDetail(OrderDetail orderDetail) {
		getOrderDetails().remove(orderDetail);
		orderDetail.setProduct(null);

		return orderDetail;
	}

	public Vendor getVendor() {
		return this.vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public List<ProductPic> getProductPics() {
		return this.productPics;
	}

	public void setProductPics(List<ProductPic> productPics) {
		this.productPics = productPics;
	}

	public ProductPic addProductPic(ProductPic productPic) {
		getProductPics().add(productPic);
		productPic.setProduct(this);

		return productPic;
	}

	public ProductPic removeProductPic(ProductPic productPic) {
		getProductPics().remove(productPic);
		productPic.setProduct(null);

		return productPic;
	}

}