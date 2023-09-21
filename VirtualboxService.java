package com.atividaden1.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.atividaden1.enity.Virtualbox;
import com.atividaden1.repository.VirtualboxRespository;
import jakarta.transaction.Transactional;

@Service
public class VirtualboxService {

    @Autowired(required = false)
    private VirtualboxRespository VirtualboxRespository;

    @Transactional
    public String createProduto(Produto produto) {
        try {
            if (!VirtualboxRespository.existsByCliente(Virtualbox.getCliente())) {
                Virtualbox.setId(null == VirtualboxRespository.findMaxId() ? 0 : VirtualboxRespository.findMaxId() + 1);
                VirtualboxRespository.save(LojaVirtual);
                return "produto cadastrado com sucesso.";
            }else {
                return "produto já existe no database.";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Virtualbox> listprodutos() {
        return VirtualboxRespository.findAll();
    }

    @Transactional
    public String updateproduto(Produto produto) {
        if (VirtualboxRespository.existsByCliente(Virtualbox.getCliente())) {
            try {
                List<Virtualbox> Virtualbox = VirtualboxRespository.findByCliente(Virtualbox.getCliente());
                produtos.stream().forEach(s -> {
                    Virtualbox produtoToBeuptade = VirtualboxRespository.findById(s.getId()).get();
                    produtoToBeuptade.setnome(produto.getnome());
                    produtoToBeuptade.setvalidade(produto.getvalidade());
                    VirtualboxRespository.save(produtoToBeuptade);
                });
                return "produto atualizado.";
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "produto não existe no banco";
        }
    }

    @Transactional
    public String deleteproduto(Produto produto) {
        if (VirtualboxRespository.existsByCliente(produto.getCliente())) {
            try {
                List<Virtualbox> Virtualbox = VirtualboxRespository.findByCliente(getCliente());
                produtos.stream().forEach(s -> {
                    VirtualboxRespository.delete(s);
                });
                return "produto deletado.";
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "produto n\u00e3o existe no banco.";
        }
    }
}