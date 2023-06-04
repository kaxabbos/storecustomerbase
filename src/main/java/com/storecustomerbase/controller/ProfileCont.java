package com.storecustomerbase.controller;

import com.storecustomerbase.controller.main.Attributes;
import com.storecustomerbase.model.Primarys;
import com.storecustomerbase.model.Secondary;
import com.storecustomerbase.model.Tertiary;
import com.storecustomerbase.model.Users;
import com.storecustomerbase.model.enums.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

@Controller
@RequestMapping("/profile")
public class ProfileCont extends Attributes {

    @GetMapping
    public String Profile(Model model) {
        AddAttributesProfile(model);
        return "profile";
    }

    @GetMapping("/edit")
    public String ProfileEdit(Model model) {
        AddAttributesProfileEdit(model);
        return "profile_edit";
    }

    @PostMapping("/edit")
    public String HumanEditOld(
            Model model, @RequestParam MultipartFile photo, @RequestParam String surname,
            @RequestParam String name, @RequestParam String patronymic, @RequestParam String passport,
            @RequestParam String passport_number, @RequestParam String date, @RequestParam String issued,
            @RequestParam String issued_date, @RequestParam String identity, @RequestParam String address,
            @RequestParam String tel_mob, @RequestParam String tel_home, @RequestParam String email,
            @RequestParam String job, @RequestParam String post, @RequestParam int income,
            @RequestParam Marital marital, @RequestParam Origin origin, @RequestParam Citizenship citizenship,
            @RequestParam YesNo retiree, @RequestParam YesNo conscripted, @RequestParam Disability disability) {
        Users user = getUser();
        try {
            if (photo != null && !Objects.requireNonNull(photo.getOriginalFilename()).isEmpty()) {
                String uuidFile = UUID.randomUUID().toString();
                File uploadDir = new File(uploadImg);
                if (!uploadDir.exists()) uploadDir.mkdir();
                String result = "humans/" + uuidFile + "_" + photo.getOriginalFilename();
                photo.transferTo(new File(uploadImg + "/" + result));
                user.getPrimarys().setPhoto(result);
            }
        } catch (IOException e) {
            AddAttributesProfileEdit(model);
            model.addAttribute("message", "Некорректные данные!");
            return "profile_edit";
        }

        Primarys primarys = user.getPrimarys();
        primarys.set(surname, name, patronymic, passport, passport_number);
        Secondary secondary = user.getSecondary();
        secondary.set(date, issued, issued_date, identity, address, tel_mob, tel_home, email, job, post, income);
        Tertiary tertiary = user.getTertiary();
        tertiary.set(marital, origin, citizenship, retiree, conscripted, disability);

        usersRepo.save(user);

        return "redirect:/profile";
    }
}
