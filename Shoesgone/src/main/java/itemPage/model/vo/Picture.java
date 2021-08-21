package itemPage.model.vo;

public class Picture implements java.io.Serializable {

	private static final long serialVersionUID = 100021L;

	private int pictureno;
	private int modelno;
	private String picturepath;
	
	public Picture() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Picture(int pictureno, int modelno, String picturepath) {
		super();
		this.pictureno = pictureno;
		this.modelno = modelno;
		this.picturepath = picturepath;
	}

	public int getPictureno() {
		return pictureno;
	}

	public void setPictureno(int pictureno) {
		this.pictureno = pictureno;
	}

	public int getModelno() {
		return modelno;
	}

	public void setModelno(int modelno) {
		this.modelno = modelno;
	}

	public String getPicturepath() {
		return picturepath;
	}

	public void setPicturepath(String picturepath) {
		this.picturepath = picturepath;
	}

	@Override
	public String toString() {
		return "Picture [pictureno=" + pictureno + ", modelno=" + modelno + ", picturepath=" + picturepath + "]";
	}
	
	
}
