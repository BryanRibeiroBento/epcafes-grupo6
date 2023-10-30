package com.epcafes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.epcafes.model.Fertilizante;
import com.epcafes.model.enums.EnumUtil;
import com.epcafes.model.enums.TipoAuxiliarInsumos;
import com.epcafes.service.FertilizanteService;
import com.epcafes.util.NegocioExeption;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.PostMapping;

@Getter
@Setter
@Controller
public class FertilizanteController {

    @Autowired
    private FertilizanteService fertilizanteService;

    @GetMapping("/cadastroFertilizantes")
    public String cadastroInsumos(Model model) {

        List<TipoAuxiliarInsumos> opcoesInsumos = EnumUtil.getTiposInsumos();
        List<TipoAuxiliarInsumos> opcoesFertilizantes = EnumUtil.getTiposFertilizantes();
        List<TipoAuxiliarInsumos> opcoesFungicidas = EnumUtil.getTiposFungicidas();
        List<TipoAuxiliarInsumos> opcoesHerbicidas = EnumUtil.getTiposHerbicidas();
        List<TipoAuxiliarInsumos> opcoesInseticidas = EnumUtil.getTiposInseticidas();
        List<TipoAuxiliarInsumos> opcoesAdjuvantes = EnumUtil.getTiposAdjuvantes();
        List<TipoAuxiliarInsumos> opcoesMedidas = EnumUtil.getTiposMedidas();

        model.addAttribute("opcoesInsumos", opcoesInsumos);
        model.addAttribute("opcoesFertilizantes", opcoesFertilizantes);
        model.addAttribute("opcoesFungicidas", opcoesFungicidas);
        model.addAttribute("opcoesHerbicidas", opcoesHerbicidas);
        model.addAttribute("opcoesInseticidas", opcoesInseticidas);
        model.addAttribute("opcoesAdjuvantes", opcoesAdjuvantes);
        model.addAttribute("opcoesMedidas", opcoesMedidas);

        return "restricted/cadastro/cadastroFertilizantes";
    }

    @PostMapping("/cadastroFertilizantes")
    public String create(Fertilizante fertilizante) throws NegocioExeption {

        fertilizanteService.salvar(fertilizante);

        return "redirect:/cadastroFertilizantes";

    }

}
