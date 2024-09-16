package br.com.estoquefacil.controller;

import br.com.estoquefacil.model.Condominio;
import br.com.estoquefacil.model.Unidade;
import br.com.estoquefacil.repository.CondominioRepository;
import br.com.estoquefacil.repository.UnidadeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
public class UnidadeController {

    @Autowired
    private UnidadeRepository rep;

    @Autowired
    private CondominioRepository repP;

    @GetMapping("{id}/unidade")
    public ModelAndView unidade(@PathVariable Long id){
        System.out.println("ID do Condomínio: " + id);

        Optional<Condominio> cond = repP.findById(id);
        if (cond.isPresent()){
            List<Unidade> unid = rep.findByCondominioId(id);
            System.out.println("Unidades encontradas: " + unid);

            ModelAndView mv = new ModelAndView("unidade");
            mv.addObject("condominio",cond.get());
            mv.addObject("unidade",unid);
            return mv;
        } else {
            return new ModelAndView("redirect:/index");
        }
    }

    @GetMapping("{id}/inserir_unidade")
    public ModelAndView unidadeInserir(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("unidade_inserir");
        mv.addObject("condominioId", id);  // Passando o ID do condomínio para o formulário
        mv.addObject("unidade", new Unidade());  // Inicializa o objeto Unidade
        return mv;
    }

    @PostMapping("{id}/insere_unidade")
    public ModelAndView inserir(@PathVariable Long id, @Valid Unidade unidade, BindingResult bd) {
        if (bd.hasErrors()) {
            ModelAndView mv = new ModelAndView("unidade_inserir");
            mv.addObject("unidade", unidade);
            mv.addObject("condominioId", id);
            return mv;
        }

        Optional<Condominio> condominioOptional = repP.findById(id);
        if (!condominioOptional.isPresent()) {
            return new ModelAndView("redirect:/index");
        }

        Condominio condominio = condominioOptional.get();

        // Aqui garantimos que o ID da unidade seja nulo para forçar uma inserção
        unidade.setId(null);  // Garante que o Hibernate crie uma nova unidade
        unidade.setCondominio(condominio);  // Associa a nova unidade ao condomínio existente

        rep.save(unidade);  // Salva a nova unidade no banco de dados

        return new ModelAndView("redirect:/" + id + "/unidade");
    }

    @GetMapping("/atualiza_unidade/{id}")
    public ModelAndView retornaUnidade(@PathVariable Long id){
        Optional<Unidade> op = rep.findById(id);

        if (op.isPresent()){
            ModelAndView mv = new ModelAndView("unidade_atualizar");
            mv.addObject("unidade",op.get());
            return mv;
        } else {
            return new ModelAndView("redirect:/index");
        }
    }

    @PostMapping("/atualizar_unidade/{id}")
    public ModelAndView atualizaUnidade(@PathVariable Long id, @Valid Unidade unidade,BindingResult bd){
        if (bd.hasErrors()){
            ModelAndView mv = new ModelAndView("unidade_atualizar");
            return mv;
        }else {
            Optional<Unidade> op = rep.findById(id);

            if (op.isPresent()){
                Unidade unid = op.get();

                unid.setNumero(unidade.getNumero());
                rep.save(unid);
                return new ModelAndView("redirect:/" + unid.getCondominio().getId() + "/unidade");
            }else{
                ModelAndView mv = new ModelAndView("unidade_atualizar");
                mv.addObject("unidade",unidade);
                return mv;
            }
        }
    }

    @GetMapping("/remove_unidade/{id}")
    public String remover (@PathVariable Long id){
        Optional<Unidade> op = rep.findById(id);

        if (op.isPresent()){
            rep.deleteById(id);
            return "redirect:/index" ;
        }else{
            return "redirect:/index";
        }
    }


}




