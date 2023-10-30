package com.epcafes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;

import com.epcafes.model.Maquina;
import com.epcafes.model.enums.EnumUtil;
import com.epcafes.model.enums.TipoAuxiliarInsumos;
import com.epcafes.model.enums.TipoCombustivel;
import com.epcafes.model.enums.TipoInsumo;
import com.epcafes.service.MaquinaService;
import com.epcafes.util.NegocioExeption;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.PostMapping;

@Getter
@Setter
@Controller
public class InsumoController {
    @Autowired
    private MaquinaService maquinaService;

    @GetMapping("/cadastroInsumos")
    public String cadastroInsumos(Model model) {
        TipoInsumo[] opcoesInsumos = TipoInsumo.values();
        List<TipoAuxiliarInsumos> opcoesMaquinas = EnumUtil.getTiposMaquinas();
        List<TipoAuxiliarInsumos> opcoesImplementos = EnumUtil.getTiposImplementos();
        TipoCombustivel[] opcoesCombustivel = TipoCombustivel.values();

        model.addAttribute("opcoesInsumos", opcoesInsumos);
        model.addAttribute("opcoesMaquinas", opcoesMaquinas);
        model.addAttribute("opcoesImplementos", opcoesImplementos);
        model.addAttribute("opcoesCombustivel", opcoesCombustivel);

        return "restricted/cadastro/cadastroInsumos";
    }

    @PostMapping("/cadastroInsumos")
    public String create(Maquina insumo) throws NegocioExeption {

        maquinaService.salvar(insumo);
        return "redirect:/pesquisaInsumos";

    }

    @GetMapping("/pesquisaInsumos")
    public String pesquisa(Model model) {
        model.addAttribute("maquinas", maquinaService.buscarMaquinas());

        return "restricted/cadastro/PesquisaInsumos";

    }

    @GetMapping("/editarInsumo/{id}")
    public String editarInsumo(@PathVariable("id") Long id, Model model) throws NegocioExeption {

        TipoInsumo[] opcoesInsumos = TipoInsumo.values();
        List<TipoAuxiliarInsumos> opcoesMaquinas = EnumUtil.getTiposMaquinas();
        List<TipoAuxiliarInsumos> opcoesImplementos = EnumUtil.getTiposImplementos();
        TipoCombustivel[] opcoesCombustivel = TipoCombustivel.values();

        model.addAttribute("opcoesInsumos", opcoesInsumos);
        model.addAttribute("opcoesMaquinas", opcoesMaquinas);
        model.addAttribute("opcoesImplementos", opcoesImplementos);
        model.addAttribute("opcoesCombustivel", opcoesCombustivel);

        Maquina maquinaFind = maquinaService.buscarPeloCodigo(id);
        maquinaService.buscarMaquinas().stream().filter(maquina -> id.equals(maquina.getId()))
                .findFirst().get();

        model.addAttribute("maquina", maquinaFind);
        return "restricted/cadastro/editarInsumo";

    }

    @PostMapping("/editarInsumo/{id}")
    public String salvarEdicaoInsumo(@PathVariable("id") Long id, @ModelAttribute("maquina") Maquina maquina)
            throws NegocioExeption {
        maquinaService.salvar(maquina);

        return "redirect:/pesquisaInsumos";
    }

    @GetMapping("/delete/{id}")
    public String deleteItem(@PathVariable("id") Long id) throws NegocioExeption {
        Maquina maquina = maquinaService.buscarPeloCodigo(id);

        maquinaService.excluir(maquina);
        return "redirect:/pesquisaInsumos";

    }

}
