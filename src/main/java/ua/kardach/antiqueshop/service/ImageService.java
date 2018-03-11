package ua.kardach.antiqueshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.kardach.antiqueshop.dao.ImageDao;
import ua.kardach.antiqueshop.model.Image;
import ua.kardach.antiqueshop.model.Product;

/**
 * @author Yura Kardach
 */
@Service
public class ImageService {

	@Autowired
	private ImageDao imageDao;

	public Image insert(Image image){
		return imageDao.insert(image);
	}

	public Image findById(long id){
		return imageDao.findById(id);
	}
	
	public Image getImage(Product product){
		return imageDao.findById(product.getImage().getId());
	}

	public void update(Image image){
		imageDao.update(image);
	}

	public void delete(Image image){
		imageDao.delete(image);
	}

}
