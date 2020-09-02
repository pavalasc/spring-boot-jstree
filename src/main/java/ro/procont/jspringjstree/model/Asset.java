package ro.procont.jspringjstree.model;

import javax.persistence.Entity;
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
	    @JsonProperty("id")
	    private Integer id;
	   
	    @JsonProperty("parent")
	    private String parent;
	    
	    @JsonProperty("text")
	    private String text;
	    
	    @JsonProperty("a_attr")
	    private String a_attr;
	    
	    
}

////Alternative format of the node (id & parent are required)
//{
//id          : "string" // required
//parent      : "string" // required
//text        : "string" // node text
//icon        : "string" // string for custom
//state       : {
// opened    : boolean  // is the node open
// disabled  : boolean  // is the node disabled
// selected  : boolean  // is the node selected
//},
//li_attr     : {}  // attributes for the generated LI node
//a_attr      : {}  // attributes for the generated A node
//}
