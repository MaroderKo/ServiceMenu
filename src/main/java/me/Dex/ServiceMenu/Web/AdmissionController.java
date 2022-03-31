package me.Dex.ServiceMenu.Web;

import me.Dex.ServiceMenu.Domain.AdmissionDoc;
import me.Dex.ServiceMenu.Service.AdmissionDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdmissionController {
    @Autowired
    AdmissionDocService service;

    @GetMapping("/")
    public String list(Model model)
    {
        model.addAttribute("admissions", service.getAllActive());
        return "admissions";
    }

    @GetMapping("/admissions/archived")
    public String archivedList(Model model)
    {
        model.addAttribute("admissions", service.getAllArchived());
        return "admissions";
    }

    @GetMapping("/admissions/update")
    public String edit(@RequestParam("id") Long id, Model model)
    {
        model.addAttribute("admission", service.read(id));
        return "admissions_menu";
    }

    @GetMapping("/admissions/create")
    public String create(Model model)
    {
        model.addAttribute("admission", new AdmissionDoc());
        return "admissions_menu";
    }

    @PostMapping(value = {"/admissions/create", "/admissions/update"})
    public String save(@ModelAttribute AdmissionDoc doc, Model model)
    {
        service.create(doc);
        model.addAttribute("admission", new AdmissionDoc());
        return "redirect:/";
    }

    @RequestMapping("/admissions/archive")
    public String archive(@RequestParam("id") String id)
    {
        Long longid = Long.parseLong(id);
        service.setArchive(longid, true);
        return "redirect:/";
    }

    @RequestMapping("/admissions/restore")
    public String restore(@RequestParam("id") String id)
    {
        Long longid = Long.getLong(id);
        service.setArchive(longid, false);
        return "redirect:/";
    }



}
