package br.com.estoquefacil.controller;

import br.com.estoquefacil.model.Condominio;
import br.com.estoquefacil.repository.CondominioRepository;
import br.com.estoquefacil.repository.UnidadeRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class CondominioController {

    @Autowired
    private CondominioRepository rep;

    @Autowired
    private UnidadeRepository unidadeRep;

    // Método GET para exibir a lista de condomínios
    @GetMapping("/index")
    public ModelAndView index() {
        List<Condominio> condominios = rep.findAll();
        ModelAndView mv = new ModelAndView("condominio");
        mv.addObject("var", condominios);
        return mv;
    }

    @GetMapping("/inserir_form")
    public ModelAndView condominio() {
        System.out.println("Chamou");
        ModelAndView mv = new ModelAndView("condominio_inserir");
        mv.addObject("var", new Condominio());
        return mv;
    }

    @PostMapping("/insere_condominio")
    public ModelAndView inserir(@ModelAttribute("var") @Valid Condominio condominio, BindingResult bd) {
        if (bd.hasErrors()) {
            System.out.println("Chamou2");
            ModelAndView mv = new ModelAndView("condominio_inserir");
            mv.addObject("var", condominio);
            return mv;
        } else {
            System.out.println("Chamou3");
            rep.save(condominio);
            return new ModelAndView("redirect:/index");
        }
    }

    @GetMapping("/atualiza_condominio/{id}")
    public ModelAndView retornaCondominio(@PathVariable Long id) {
        Optional<Condominio> op = rep.findById(id);
        if (op.isPresent()) {
            ModelAndView mv = new ModelAndView("condominio_atualizar");
            mv.addObject("condominio", op.get());
            return mv;
        } else {
            return new ModelAndView("redirect:/index");
        }
    }

    @PostMapping("/atualizar_condominio/{id}")
    public ModelAndView atualizaCondominio(@PathVariable Long id, @Valid Condominio condominio, BindingResult bd) {
        if (bd.hasErrors()) {
            ModelAndView mv = new ModelAndView("condominio_atualizar");
            mv.addObject("condominio", condominio);
            return mv;
        } else {
            Optional<Condominio> op = rep.findById(id);
            if (op.isPresent()) {
                Condominio cond = op.get();
                cond.setNome(condominio.getNome());
                cond.setEndereco(condominio.getEndereco());
                cond.setCnpj(condominio.getCnpj());
                cond.setFinanceiro(condominio.getFinanceiro());
                rep.save(cond);
                return new ModelAndView("redirect:/index");
            } else {
                ModelAndView mv = new ModelAndView("condominio_atualizar");
                mv.addObject("errorMessage", "Condomínio não encontrado.");
                mv.addObject("condominio", condominio);
                return mv;
            }
        }
    }

    @Transactional
    @GetMapping("/remove_condominio/{id}")
    public String remover(@PathVariable Long id) {
        Optional<Condominio> cond = rep.findById(id);
        if (cond.isPresent()) {
            // Remove todas as unidades associadas ao condomínio
            unidadeRep.deleteByCondominioId(id);

            // Agora pode deletar o condomínio
            rep.deleteById(id);
            return "redirect:/index";
        } else {
            return "redirect:/index";
        }
    }
}
