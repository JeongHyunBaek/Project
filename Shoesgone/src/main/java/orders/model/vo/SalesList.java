package orders.model.vo;

public class SalesList implements java.io.Serializable {
	// Serial ID
		private static final long serialVersionUID = 21521L;

		// Field
		private String date;
		private Double price;
		
		public SalesList() {
			super();
			// TODO Auto-generated constructor stub
		}

		public SalesList(String date, Double price) {
			super();
			this.date = date;
			this.price = price;
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public Double getPrice() {
			return price;
		}

		public void setPrice(Double price) {
			this.price = price;
		}

		@Override
		public String toString() {
			return "SalesList [date=" + date + ", price=" + price + "]";
		}
		
		
}
