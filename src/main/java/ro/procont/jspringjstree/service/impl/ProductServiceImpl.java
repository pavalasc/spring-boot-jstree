package ro.procont.jspringjstree.service.impl;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.procont.jspringjstree.mapper.ProductMapper;
import ro.procont.jspringjstree.model.Product;

import java.util.List;

/**
 * @author prist
 */
@Service
public class ProductServiceImpl implements ro.procont.jspringjstree.service.ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
	public List<Product> list() {
		// TODO Auto-generated method stub
		return productMapper.list();
	}


}
