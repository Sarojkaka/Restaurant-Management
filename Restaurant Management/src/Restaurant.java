
public class Restaurant {

		private Integer catId;
		
		private String category;
		
		private Integer menuId;
		
		private String menuName;
		
		private Integer menuPrice;
		
		private String menuDescription;

		public Restaurant(Integer catId, String category, Integer menuId, String menuName, Integer menuPrice,
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



		


		public Restaurant(Integer catId, String menuName, Integer menuPrice, String menuDescription) {
			
			this.catId = catId;
			
			this.menuName = menuName;
			
			this.menuPrice = menuPrice;
			
			this.menuDescription = menuDescription;
		}

		public Restaurant(Integer menuId, String menuName, Integer menuPrice, String menuDescription,Integer catId) {
			
			this.menuId = menuId;
			
			this.menuName = menuName;
			
			this.menuPrice = menuPrice;
			
			this.menuDescription = menuDescription;
			
			this.catId = catId;
		}



		public Restaurant(Integer catId) {
			this.catId = catId;
		}
		
		public Restaurant(int menuId) {
			this.menuId = menuId;
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

		public Integer getMenuPrice() {
			return menuPrice;
		}

		public void setMenuPrice(Integer menuPrice) {
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
			