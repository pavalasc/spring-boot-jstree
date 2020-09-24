package ro.procont.jspringjstree.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

//import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Asset {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	    @JsonProperty("id")
	    private Integer id;
	   
	    @JsonProperty("parent")
	    @NotEmpty(message = "Please provide a parent for this node, must not be empty.")
	    @NotNull
	    private String parent;
	    
	    @NotEmpty(message = "Please provide a text for this node, must not be empty.")
	    @NotNull
	    @JsonProperty("text")
	    private String text;
	    
	    @JsonProperty("a_attr")
	    private String a_attr;
	    
	    
}
