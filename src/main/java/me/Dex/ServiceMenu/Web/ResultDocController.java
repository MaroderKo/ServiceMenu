package me.Dex.ServiceMenu.Web;

import me.Dex.ServiceMenu.DTO.ResultDTO;
import me.Dex.ServiceMenu.Factory.ResultDTOFactory;
import me.Dex.ServiceMenu.Service.ResultingDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/result")
public class ResultDocController {
    @Autowired
    ResultDTOFactory factory;

    @Autowired
    ResultingDocService service;

    @GetMapping("")
    public String edit(@RequestParam("id") Long id, Model model)
    {
        model.addAttribute("result", factory.getById(id));
        return "result_menu";
    }

    @PostMapping("")
    public String save(@ModelAttribute ResultDTO dto)
    {
        service.update(factory.extract(dto));
        return "redirect:/";
    }
}
