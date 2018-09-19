package edu.hm.cs.pblv.catvsdog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.nio.file.Path;

@Controller
public class CatvsdogController {

    @GetMapping("/result")
    public String displayText(@RequestParam(name="result", required=false, defaultValue="none") String result, Model model) {
        String text = "This is ";
        switch(result.toLowerCase())
        {
            case "cat":
                text += "a cat.";
                break;
            case "dog":
                text += "a dog.";
                break;
            default:
                text += "neither a cat nor a dog.";
                break;
        }
        model.addAttribute("result", text);
        return text;
    }

    @PostMapping("/image")
    public String getResult(@RequestParam(name="image", required = true) Path image, Model model)
    {
        Catvsdog checker = new Catvsdog(image);
        return checker.getResult();
    }
}
