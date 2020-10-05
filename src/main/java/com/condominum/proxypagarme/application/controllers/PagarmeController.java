package com.condominum.proxypagarme.application.controllers;

import com.condominum.proxypagarme.application.services.TransacaoService;
import com.condominum.proxypagarme.domain.entities.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/orders")
public class PagarmeController {

    @Autowired
    private TransacaoService transacaoService;

    @RequestMapping(method = RequestMethod.GET)
    public String getVersion() {
        return "API PAGAMENTO 1.0.0";
    }

    // @RequestMapping(method = RequestMethod.POST)
    // public String pagamentoCradCard() {
    //     this.transacaoService.initTransactionCredCard();
    //     return "solicitação realizada com sucesso";
    // }

    @RequestMapping( value = "/credit", method = RequestMethod.POST)
    public ResponseEntity<Order> orderCredit() {
        return ResponseEntity.ok(new Order());
    }
}