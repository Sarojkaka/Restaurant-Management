
public class Restaurant {

		private Integer catId;
		
		private String category;
		
		private Integer menuId;
		
		private String menuName;
		
		private Double menuPrice;
		
		private String menuDescription;
		
		private String orderTakenBy;
		
		private int tableNo;
		
		private int custId;
		
		private int qty;
		
		private Integer userid;
		
		private String firstname;
		
		private String lastname;
		
		private Gender gender;
		
		private String username;
		
		private String password;
		
		private UserType usertype;

		public Restaurant(Integer userid, String firstname, String lastname, Gender gender, String username,
				String password, UserType usertype) {
			this.userid = userid;
			this.firstname = firstname;
			this.lastname = lastname;
			this.gender = gender;
			this.username = username;
			this.password = password;
			this.usertype = usertype;
		}

		public Restaurant(Integer catId, String category, Integer menuId, String menuName, Double menuPrice,
				String menuDescription) {
			
			this.catId = catId;
			
			this.category = category;
			
			this.menuId = menuId;
			
			this.menuName = menuName;
			
			this.menuPrice = menuPrice;
			
			this.menuDescription = menuDescription;
		}

		public Restaurant(String category) {
			this.category = category;
		}


		public Restaurant(Integer catId, String category) {
			
			this.catId = catId;
			
			this.category = category;
		}



		


		public Integer getUserid() {
			return userid;
		}

		public void setUserid(Integer userid) {
			this.userid = userid;
		}

		public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}

		public Gender getGender() {
			return gender;
		}

		public void setGender(Gender gender) {
			this.gender = gender;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public UserType getUsertype() {
			return usertype;
		}

		public void setUsertype(UserType usertype) {
			this.usertype = usertype;
		}

		public Restaurant(Integer catId, String menuName, Double menuPrice, String menuDescription) {
			
			this.catId = catId;
			
			this.menuName = menuName;
			
			this.menuPrice = menuPrice;
			
			this.menuDescription = menuDescription;
		}



		public Restaurant(Integer catId) {
			this.catId = catId;
		}
		
		public Restaurant(int menuId) {
			this.menuId = menuId;
		}

		public Restaurant(Integer menuId, String menuName, Double menuPrice, String menuDescription,
				Integer catId) {
			this.menuId = menuId;
			
			this.menuName = menuName;
			
			this.menuPrice = menuPrice;
			
			this.menuDescription = menuDescription;
			
			this.catId = catId;
		}

		public Restaurant(Integer catId, Integer menuId) {
			this.catId = catId;
			this.menuId = menuId;
		}

		public Restaurant(String ordertakenby, int tableno, int qty, int menuId, int custId) {
			this.orderTakenBy = ordertakenby;
			
			this.tableNo = tableno;
			
			this.qty = qty;
			
		
			
			this.menuId = menuId;
			
			this.custId = custId;
			
		}


		public Restaurant(String username, String password) {
			this.username = username;
			this.password = password;
		}

		public Restaurant() {
			this.username = username;
			this.password = password;
		}

		public String getOrderTakenBy() {
			return orderTakenBy;
		}

		public void setOrderTakenBy(String orderTakenBy) {
			this.orderTakenBy = orderTakenBy;
		}

		public int getTableNo() {
			return tableNo;
		}

		public void setTableNo(int tableNo) {
			this.tableNo = tableNo;
		}

		public int getCustId() {
			return custId;
		}

		public void setCustId(int custId) {
			this.custId = custId;
		}

		public int getQty() {
			return qty;
		}

		public void setQty(int qty) {
			this.qty = qty;
		}

		public Integer getCatId() {
			return catId;
		}

		public void setCatId(Integer catId) {
			this.catId = catId;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}

		public Integer getMenuId() {
			return menuId;
		}

		public void setMenuId(Integer menuId) {
			this.menuId = menuId;
		}

		public String getMenuName() {
			return menuName;
		}

		public void setMenuName(String menuName) {
			this.menuName = menuName;
		}

		public Double getMenuPrice() {
			return menuPrice;
		}

		public void setMenuPrice(Double menuPrice) {
			this.menuPrice = menuPrice;
		}

		public String getMenuDescription() {
			return menuDescription;
		}

		public void setMenuDescription(String menuDescription) {
			this.menuDescription = menuDescription;
		}

		@Override
		public String toString() {
			return "Restaurant [catId=" + catId + ", category=" + category + ", menuId=" + menuId + ", menuName="
					+ menuName + ", menuPrice=" + menuPrice + ", menuDescription=" + menuDescription + "]";
		}
		
}
			