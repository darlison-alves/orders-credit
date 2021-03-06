package com.condominum.proxypagarme.application.services;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Service;

import me.pagar.model.Address;
import me.pagar.model.Billing;
import me.pagar.model.Customer;
import me.pagar.model.Document;
import me.pagar.model.Item;
import me.pagar.model.PagarMe;
import me.pagar.model.PagarMeException;
import me.pagar.model.Shipping;
import me.pagar.model.Transaction;

@Service
public class TransacaoService {
    public TransacaoService() {
        PagarMe.init("ak_test_yqAjN4oEROfaAhI9NZwHfSjwBHo2A0");
    }

    public void initTransactionCredCard() {
        Transaction transaction = new Transaction();
        Customer customer = new Customer();
        customer.setType(Customer.Type.INDIVIDUAL);
        customer.setExternalId("1001");
        customer.setName("Phineas Flynn");
        customer.setBirthday("1999-07-09");
        customer.setEmail("phineas@threestatearea.com");
        customer.setCountry("br");

        Collection<Document> documents = new ArrayList();
        Document document = new Document();
        document.setType(Document.Type.CPF);
        document.setNumber("77551442758");
        documents.add(document);
        customer.setDocuments(documents);

        Collection<String> phones = new ArrayList();
        phones.add("+5511982657575");
        customer.setPhoneNumbers(phones);

        Billing billing = new Billing(); 
        billing.setName("Phineas Flynn");
        Address address  = new Address(); 
        address.setCity("Santo Andre");
        address.setCountry("br");
        address.setState("sp");
        address.setNeighborhood("Parque Miami");
        address.setStreet("Rua Rio Jari");
        address.setZipcode("09133180");
        address.setStreetNumber("7");
        billing.setAddress(address);
    
        Shipping shipping = new Shipping();
        shipping.setAddress(address);
        shipping.setName("Phineas Flynn");
        shipping.setFee(3200);
    
        Collection<Item> items = new ArrayList();
        Item item = new Item(); 
        item.setId("OX890");
        item.setQuantity(12);
        item.setTangible(Boolean.TRUE);
        item.setTitle("Rockets");
        item.setUnitPrice(120);
        transaction.setShipping(shipping);
        transaction.setBilling(billing);
        transaction.setItems(items);
        transaction.setPaymentMethod(Transaction.PaymentMethod.CREDIT_CARD);
        transaction.setAmount(4640);
        transaction.setCardHolderName("Phineas Flynn");
        transaction.setCardNumber("4242424242424242");
        transaction.setCardCvv("909");
        transaction.setCardExpirationDate("1119"); 
        transaction.setCustomer(customer);
        transaction.setPostbackUrl("https://webhook.site/12bb6bbb-7e72-442b-ba6f-e9923722481b");

        try {
            Transaction newTransaction = transaction.save();
            System.out.println(newTransaction.toJson());
        } catch (PagarMeException e) {
            e.printStackTrace();
        }
    }
}
