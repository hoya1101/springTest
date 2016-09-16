package com.sap.bean;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TableBean {

	private String country;
	private boolean orgood;
	private Country countryInfo;
	private CountryDetail[] countryDetail;

	public String getCountry() {
		return country;
	}

	public TableBean(){
		System.out.println("Constructor of TableBean called");
	}
	public void setCountry(String country) {
		this.country = country;
	}

	public boolean isOrgood() {
		return orgood;
	}

	public void setOrgood(boolean orgood) {
		this.orgood = orgood;
	}

	public Country getCountryInfo() {
		return countryInfo;
	}

	public void setCountryInfo(Country countryInfo) {
		this.countryInfo = countryInfo;
	}

	public CountryDetail[] getCountryDetail() {
		return countryDetail;
	}

	public void setCountryDetail(CountryDetail[] countryDetail) {
		this.countryDetail = countryDetail;
	}

	public static class Country {
		public String getGolden() {
			return golden;
		}

		public void setGolden(String golden) {
			this.golden = golden;
		}

		public String getSilver() {
			return silver;
		}

		public void setSilver(String silver) {
			this.silver = silver;
		}

		public String getCopper() {
			return copper;
		}

		public void setCopper(String copper) {
			this.copper = copper;
		}

		public String getTank() {
			return tank;
		}

		public void setTank(String tank) {
			this.tank = tank;
		}

		private String golden;
		private String silver;
		private String copper;
		private String tank;

		public String toString() {
			String result = "Golden: " + this.golden + " silver: "
					+ this.silver + " copper: " + this.copper + " tank: "
					+ this.tank;
			return result;
		}
	}

	public static class CountryDetail {
		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getHeader() {
			return header;
		}

		public void setHeader(String header) {
			this.header = header;
		}

		public String getFieldIndex() {
			return fieldIndex;
		}

		public void setFieldIndex(String fieldIndex) {
			this.fieldIndex = fieldIndex;
		}

		public String getSortOrder() {
			return sortOrder;
		}

		public void setSortOrder(String sortOrder) {
			this.sortOrder = sortOrder;
		}

		public boolean isPrintable() {
			return printable;
		}

		public void setPrintable(boolean printable) {
			this.printable = printable;
		}

		private String id;
		private String header;
		private String fieldIndex;
		private String sortOrder;
		private boolean printable;
		
		public String toString(){
			String result = "Country detail id: " + this.id + " header: " + this.header
					 + " fieldIndex: " + this.fieldIndex + " sortOrder: " + this.sortOrder
					 + "printable: " + this.printable;
			return result;
		}

	}

	private static void testMap() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			// TableBean bean = mapper.readValue(new File("table.json"),
			// TableBean.class);
			// does not work if TableBean.class.getClass().getResource
			// nullURL url =
			// TableBean.class.getResource("\\src\\main\\java\\com\\sap\\bean\\table.jsontable.json");
			TableBean bean2 = new TableBean();
			URL url = bean2.getClass().getResource("/table.json");

			InputStream stream = TableBean.class.getResourceAsStream("/table.json");
			System.out.println(stream != null);

			if (url == null) {
				// C:\Users\i042416\git\springTest\table.json
				File a = new File("table.json");
				System.out.println(a.getAbsolutePath());
				// C:\Users\i042416\git\springTest\.\table.json
				File a2 = new File("./table.json");
				System.out.println(a2.getAbsolutePath());
			}
			File file = new File(url.getPath());
			TableBean bean = mapper.readValue(file, TableBean.class);
			System.out.println("Country:" + bean.getCountryInfo());
			
			CountryDetail[] detail = bean.getCountryDetail();
			for( int i = 0; i < detail.length; i++)
				System.out.println("CountryDetail:" + detail[i]);
			System.out.println("orgood:" + bean.isOrgood());
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		testMap();
	}
}