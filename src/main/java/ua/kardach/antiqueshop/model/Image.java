package ua.kardach.antiqueshop.model;

public class Image {

	private long id;
	private String path;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "Image [id=" + id + ", path=" + path + "]";
	}

}
