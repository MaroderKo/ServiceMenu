package me.Dex.ServiceMenu.Web;

import me.Dex.ServiceMenu.DTO.RepairDTO;
import me.Dex.ServiceMenu.Factory.RepairDTOFactory;
import me.Dex.ServiceMenu.Service.RepairDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/repair")
public class RepairDocController {

    @Autowired
    RepairDTOFactory factory;

    @Autowired
    RepairDocService service;

    @GetMapping
    public String edit(@RequestParam("id") Long id, Model model)
    {
        model.addAttribute("repair", factory.getById(id));
        return "repair_menu";
    }

    @PostMapping
    public String save(@ModelAttribute RepairDTO dto)
    {
        service.update(factory.extract(dto));
        return "redirect:/";
    }
    
}
