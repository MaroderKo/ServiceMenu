package me.Dex.ServiceMenu.Web;

import me.Dex.ServiceMenu.DTO.RepairDTO;
import me.Dex.ServiceMenu.Domain.AdmissionDoc;
import me.Dex.ServiceMenu.Domain.RepairDoc;
import me.Dex.ServiceMenu.Factory.RepairDTOFactory;
import me.Dex.ServiceMenu.Service.AdmissionDocService;
import me.Dex.ServiceMenu.Service.RepairDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RepairController {

    @Autowired
    RepairDTOFactory factory;

    @Autowired
    RepairDocService service;

    @GetMapping("/repair/update")
    public String edit(@RequestParam("id") Long id, Model model)
    {
        model.addAttribute("repair", factory.getById(id));
        return "repair_menu";
    }

    @PostMapping("/repair/update")
    public String save(@ModelAttribute RepairDTO doc, Model model)
    {
        service.update(doc.simplify());
        //model.addAttribute("repairDTO", new AdmissionDoc());
        return "redirect:/";
    }
    
}
