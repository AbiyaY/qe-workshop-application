package com.example.qeproject.ui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;


@Controller
public class UIProvider
{
    /**
     * Method returns the name of the page to be loaded in relation to a given URL match
     *
     * @param name This is a URL parameter, such as that found in as "...?key=value"
     * @param model A populated model is passed to the page. Keys are tokens that are found
     *        alongside the HTML and would look something like ${name}. The framework replaces
     *        the token with the value associated to that key in the model.
     *
     * @return The name of the page to load
     */
    @GetMapping("/calc0")
    public String
    servePage(@RequestParam(name="name", required=false, defaultValue= "everyone") String name,
              Model model)
    {
        System.out.println("servePage 0");
        System.out.println("Argument name contains: " + name);

        model.addAttribute("name", name);
        model.addAttribute("clientId", UUID.randomUUID().toString());
        System.out.println(model.getAttribute("clientId"));

        return "index";
    }

    @GetMapping("/calc1")
    public String servePage(Model model)
    {
        System.out.println("servePage 1");
        model.addAttribute("name", "nobody");
        return "index";
    }

    @GetMapping("/calc2")
    public String servePage()
    {
        System.out.println("servePage 2");
        return "index";
    }
}
