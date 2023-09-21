package com.atividaden1.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.atividaden1.enity.Virtualbox;
import com.atividaden1.service.VirtualboxService;

@RestController
public class VirtualboxController {

    @Autowired
    private VirtualboxService VirtualboxService;

    @RequestMapping(value = "info", method = RequestMethod.GET)
    public String info() {
        return "Aplicação ativa";
    }

    @RequestMapping(value = "createproduto", method = RequestMethod.GET)
    public String createproduto(@RequestBody Produto produto) {
        return VirtualboxController.createproduto(LojaVirtual);
    }

    @RequestMapping(value = "listprodutos", method = RequestMethod.GET)
    public String listprodutos() {
        return VirtualboxService.listprodutos();
    }

    @RequestMapping(value = "uptadeproduto", method = RequestMethod.GET)
    public String updateproduto(@RequestBody Produto produto) {
        return VirtualboxService.updateproduto(LojaVirtual);
    }

    @RequestMapping(value = "deleteproduto", method = RequestMethod.GET)
    public String deleteproduto(@RequestBody Produto produto) {
        return VirtualboxService.deleteproduto(LojaVirtual);
    }
}