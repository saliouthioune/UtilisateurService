package com.coforge.hms.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.coforge.hms.model.*;
import com.coforge.hms.service.*;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(value="/api")
public class MatierController {
 @Autowired	
 private MatiereServiceImpl mService;
 @PostMapping(value="/addmat")
 public Matiere save(@RequestBody Matiere m) {
	 return mService.saveMat(m);
 }
 @GetMapping("/mat/{matId}")
 public Matiere getById(@PathVariable Long matId) throws Exception{
	 return mService.getById(matId);
 }
 @GetMapping("/mats")
 public List<Matiere>getAllMatiere(){
	 return mService.getAllMatiere();
 } 
}
