package ua.kardach.antiqueshop.dao;

import ua.kardach.antiqueshop.model.Image;

/**
 * @author Yura Kardach
 */
public interface ImageDao {

	// create
	public Image addImage(Image image);

	// read
	public Image getImageById(long id);

	// update
	public boolean updateImage(Image image);

	// delete
	public boolean deleteImage(Image image);
}
