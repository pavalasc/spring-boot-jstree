package ro.procont.jspringjstree.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ro.procont.jspringjstree.model.Asset;
import ro.procont.jspringjstree.service.AssetService;

@Controller
@RequestMapping(value = "/assets")
public class AssetController {
	
	@Autowired
	private AssetService assetService;
	
	private Boolean editMode = false;
	
	private Boolean newMode = false;
	
	
	@GetMapping("/addForm/{id}") //show the new node form ATENTIE este GET
	public String showAddNewEntityForm(@PathVariable("id") int id, @Valid Model model) {
		System.out.println("-->add new node, parent id " + id);
		this.newMode = true;
		Asset asset = new Asset();
		asset.setParent(String.valueOf(id));
		model.addAttribute("asset", asset);//new user to populate the form 
		model.addAttribute("newMode", newMode);
		return "jsTree";
	}
	
	
	
	@PostMapping("/addNew")
	public String onSubmitNewEntity(@ModelAttribute("asset") @Valid Asset asset, BindingResult result, Model model) {
		System.out.println("Asset: " + asset);
		if (result.hasErrors()) {
			
			return "/jsTree";
		}
		assetService.save(asset);
		this.editMode = true;
		model.addAttribute("newMode", newMode);
		return "redirect:/jstree";
	}

	
	@GetMapping("/edit/{id}") //mapat cu butonul edit din index ATENTIE GET
	public String showUpdateForm(@PathVariable("id") int id, Model model) {
		System.out.println(" --> in edit");
		this.editMode = true;
		System.out.println("--> this.editMode: " + this.editMode);
		Asset asset = assetService.findById(id);//.orElseThrow(() -> new IllegalArgumentException("Invalid asset Id:" + id));
		model.addAttribute("asset", asset);
		model.addAttribute("editMode", editMode);
		
		return "jsTree"; //"assets/edit"
	}

	
	@PostMapping("/update/{id}") //mapat cu save/update din form de editare
	public String updateUser(@PathVariable("id") int id, @Valid Asset asset, BindingResult result, Model model) {
		
		if (result.hasErrors()) {
			asset.setId(id);
			return "redirect:assets/edit";
		}
		
		assetService.save(asset);

		model.addAttribute("assetList", assetService.findAll());
		this.editMode = false;
		return "redirect:/jstree";
	}
	
	@GetMapping("/delete/{id}") 
	public String deleteAsset(@PathVariable("id") int id, Model model) {
		Asset asset = assetService.findById(id);//.orElseThrow(() -> new IllegalArgumentException("Invalid asset Id:" + id));
		System.out.println("Aseet to delete: " + asset);
		assetService.delete(asset);
		
		return "redirect:/jstree";
	}


	public Boolean getEditMode() {
		return editMode;
	}


	public void setEditMode(Boolean editMode) {
		this.editMode = editMode;
	}

}
