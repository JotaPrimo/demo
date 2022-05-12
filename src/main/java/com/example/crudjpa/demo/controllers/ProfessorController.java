package com.example.crudjpa.demo.controllers;

import com.example.crudjpa.demo.models.Professor;
import com.example.crudjpa.demo.repositories.ProfessorRepository;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/professores")
public class ProfessorController extends MyController {

    @Autowired
    ProfessorRepository repository;

    @GetMapping("")
    public String index(RedirectAttributes redirectAttributes, Model model){
        model.addAttribute("professores", repository.findAll());
        return "auth/professores/index";

    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("professor", new Professor());
        return "auth/professores/create";
    }

    @PostMapping("/store")
    public String store(@Valid Professor professor, BindingResult result, RedirectAttributes redirectAttributes) {
            if (result.hasErrors()) {
                return "auth/professores/create";
            }
            repository.save(professor);
            redirectAttributes.addFlashAttribute(TITLE_SUCCESS, "Professor cadastro com sucesso");
            return "redirect:/professores";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model, RedirectAttributes attributes) {
        Optional<Professor> professorOpt = repository.findById(id);
        if(!professorOpt.isPresent()){
            throw new IllegalArgumentException("Professor não encontrada");
        }
        Professor professor = professorOpt.get();
        model.addAttribute("professor", professor);
        attributes.addFlashAttribute(TITLE_SUCCESS, MSG_SUCCESS);
        return "auth/professores/edit";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, @Valid Professor professor, BindingResult result, RedirectAttributes attributes){

            if (result.hasErrors()) {
                professor.setId(id);
                attributes.addFlashAttribute(TITLE_ERROR, MSG_ERROR);
                return "auth/professores/edit";
            }

            repository.save(professor);
            attributes.addFlashAttribute(TITLE_SUCCESS, "Professor atualizado com sucesso");
            return "redirect:/professores";

    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, RedirectAttributes attributes){
        Professor professor = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Registro não encontrado"));
        repository.delete(professor);
        attributes.addFlashAttribute(TITLE_SUCCESS, "Professor deletado com sucesso");
        return "redirect:/professores";
    }

}
