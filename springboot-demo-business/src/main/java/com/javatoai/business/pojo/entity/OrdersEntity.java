package com.javatoai.business.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 */
/**
    * 订单分布式表
    */
@TableName(value = "orders")
public class OrdersEntity {
    /**
     * 订单ID，主键
     */
    @TableId(value = "order_id", type = IdType.INPUT)
    private Long orderId;

    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 商品ID
     */
    @TableField(value = "product_id")
    private Long productId;

    /**
     * 购买数量
     */
    @TableField(value = "quantity")
    private Long quantity;

    /**
     * 商品单价
     */
    @TableField(value = "price")
    private BigDecimal price;

    /**
     * 订单总金额
     */
    @TableField(value = "total_amount")
    private BigDecimal totalAmount;

    /**
     * 币种，如CNY、USD等
     */
    @TableField(value = "currency")
    private String currency;

    /**
     * 订单状态，如已创建、已支付、已发货等
     */
    @TableField(value = "order_status")
    private String orderStatus;

    /**
     * 支付方式，如支付宝、微信、信用卡等
     */
    @TableField(value = "payment_method")
    private String paymentMethod;

    /**
     * 收货地址
     */
    @TableField(value = "shipping_address")
    private String shippingAddress;

    /**
     * 收货城市
     */
    @TableField(value = "shipping_city")
    private String shippingCity;

    /**
     * 收货国家
     */
    @TableField(value = "shipping_country")
    private String shippingCountry;

    /**
     * 联系方式
     */
    @TableField(value = "contact_phone")
    private String contactPhone;

    /**
     * 邮箱地址
     */
    @TableField(value = "contact_email")
    private String contactEmail;

    /**
     * 订单创建时间
     */
    @TableField(value = "created_at")
    private Date createdAt;

    /**
     * 最后一次更新时间
     */
    @TableField(value = "updated_at")
    private Date updatedAt;

    /**
     * 获取订单ID，主键
     *
     * @return order_id - 订单ID，主键
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * 设置订单ID，主键
     *
     * @param orderId 订单ID，主键
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取用户ID
     *
     * @return user_id - 用户ID
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取商品ID
     *
     * @return product_id - 商品ID
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * 设置商品ID
     *
     * @param productId 商品ID
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * 获取购买数量
     *
     * @return quantity - 购买数量
     */
    public Long getQuantity() {
        return quantity;
    }

    /**
     * 设置购买数量
     *
     * @param quantity 购买数量
     */
    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    /**
     * 获取商品单价
     *
     * @return price - 商品单价
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 设置商品单价
     *
     * @param price 商品单价
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 获取订单总金额
     *
     * @return total_amount - 订单总金额
     */
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    /**
     * 设置订单总金额
     *
     * @param totalAmount 订单总金额
     */
    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * 获取币种，如CNY、USD等
     *
     * @return currency - 币种，如CNY、USD等
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * 设置币种，如CNY、USD等
     *
     * @param currency 币种，如CNY、USD等
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * 获取订单状态，如已创建、已支付、已发货等
     *
     * @return order_status - 订单状态，如已创建、已支付、已发货等
     */
    public String getOrderStatus() {
        return orderStatus;
    }

    /**
     * 设置订单状态，如已创建、已支付、已发货等
     *
     * @param orderStatus 订单状态，如已创建、已支付、已发货等
     */
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * 获取支付方式，如支付宝、微信、信用卡等
     *
     * @return payment_method - 支付方式，如支付宝、微信、信用卡等
     */
    public String getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * 设置支付方式，如支付宝、微信、信用卡等
     *
     * @param paymentMethod 支付方式，如支付宝、微信、信用卡等
     */
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    /**
     * 获取收货地址
     *
     * @return shipping_address - 收货地址
     */
    public String getShippingAddress() {
        return shippingAddress;
    }

    /**
     * 设置收货地址
     *
     * @param shippingAddress 收货地址
     */
    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    /**
     * 获取收货城市
     *
     * @return shipping_city - 收货城市
     */
    public String getShippingCity() {
        return shippingCity;
    }

    /**
     * 设置收货城市
     *
     * @param shippingCity 收货城市
     */
    public void setShippingCity(String shippingCity) {
        this.shippingCity = shippingCity;
    }

    /**
     * 获取收货国家
     *
     * @return shipping_country - 收货国家
     */
    public String getShippingCountry() {
        return shippingCountry;
    }

    /**
     * 设置收货国家
     *
     * @param shippingCountry 收货国家
     */
    public void setShippingCountry(String shippingCountry) {
        this.shippingCountry = shippingCountry;
    }

    /**
     * 获取联系方式
     *
     * @return contact_phone - 联系方式
     */
    public String getContactPhone() {
        return contactPhone;
    }

    /**
     * 设置联系方式
     *
     * @param contactPhone 联系方式
     */
    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    /**
     * 获取邮箱地址
     *
     * @return contact_email - 邮箱地址
     */
    public String getContactEmail() {
        return contactEmail;
    }

    /**
     * 设置邮箱地址
     *
     * @param contactEmail 邮箱地址
     */
    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    /**
     * 获取订单创建时间
     *
     * @return created_at - 订单创建时间
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * 设置订单创建时间
     *
     * @param createdAt 订单创建时间
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * 获取最后一次更新时间
     *
     * @return updated_at - 最后一次更新时间
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * 设置最后一次更新时间
     *
     * @param updatedAt 最后一次更新时间
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}