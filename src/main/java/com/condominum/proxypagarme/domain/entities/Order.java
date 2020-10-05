package com.condominum.proxypagarme.domain.entities;

import com.condominum.proxypagarme.domain.dto.interfaces.ICredCard;

import me.pagar.PaymentMethod;

public class Order {
    private Integer id;
    
    private PaymentMethod method;

    private Integer userId;

    private ICredCard credCard;

    public Integer getId() {
        return id;
    }

    public ICredCard getCredCard() {
        return credCard;
    }

    public void setCredCard(ICredCard credCard) {
        this.credCard = credCard;
    }

    public PaymentMethod getMethod() {
        return method;
    }

    public void setMethod(PaymentMethod method) {
        this.method = method;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
