package dao;

import java.io.Serializable;

public class ProductBean implements Serializable{
	private String pcode;
	private String pnamel;
	private double pprice;
	private int pquantity;
	
	public ProductBean() {
		
	}

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public String getPnamel() {
		return pnamel;
	}

	public void setPnamel(String pnamel) {
		this.pnamel = pnamel;
	}

	public double getPprice() {
		return pprice;
	}

	public void setPprice(double pprice) {
		this.pprice = pprice;
	}

	public int getPquantity() {
		return pquantity;
	}

	public void setPquantity(int pquantity) {
		this.pquantity = pquantity;
	}

	

}
