package com.storecustomerbase.controller;

import com.storecustomerbase.controller.main.Attributes;
import com.storecustomerbase.model.Apps;
import com.storecustomerbase.model.enums.AppsStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/apps")
public class AppsCont extends Attributes {

    @GetMapping
    public String Apps(Model model) {
        AddAttributesApps(model);
        return "apps";
    }

    @GetMapping("/answer/{id}")
    public String appsAnswer(@PathVariable Long id) {
        Apps apps = appsRepo.getReferenceById(id);
        apps.setStatus(AppsStatus.REVIEWED);
        appsRepo.save(apps);
        return "redirect:/apps";
    }

    @PostMapping("/add")
    public String AppsAdd(@RequestParam String text, @RequestParam String tel) {
        appsRepo.save(new Apps(text, tel, DateNow(), getUser()));
        return "redirect:/apps";
    }
}
