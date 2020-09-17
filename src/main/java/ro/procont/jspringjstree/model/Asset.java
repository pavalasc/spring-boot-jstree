package ro.procont.jspringjstree.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	    private String parent;
	    
	    @JsonProperty("text")
	    private String text;
	    
	    @JsonProperty("a_attr")
	    private String a_attr;
	    
	    
}
