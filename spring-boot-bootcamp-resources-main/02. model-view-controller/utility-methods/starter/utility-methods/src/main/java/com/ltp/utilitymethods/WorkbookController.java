package com.ltp.utilitymethods;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class WorkbookController {

    @GetMapping(value="/")
    public String getMethodName(Model model) {
        model.addAttribute("menu1", "We sell chocolate rice cakes bubble tea");
        model.addAttribute("menu2", "We sell just chocolate");
        return "view";
    }
    
    
}
