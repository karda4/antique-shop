package ua.kardach.antiqueshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.kardach.antiqueshop.dao.ImageDao;
import ua.kardach.antiqueshop.model.Image;
import ua.kardach.antiqueshop.model.Product;

@Service
public class ImageService {

	@Autowired
	private ImageDao imageDao;

	public Image addImage(Image image){
		return imageDao.addImage(image);
	}

	public Image getImageById(long id){
		return imageDao.getImageById(id);
	}
	
	public Image getImage(Product product){
		return imageDao.getImageById(product.getImageId());
	}

	public boolean updateImage(Image image){
		return imageDao.updateImage(image);
	}

	public boolean deleteImage(Image image){
		return imageDao.deleteImage(image);
	}

}
