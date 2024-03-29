package HaHuShoes.Model;

public class ProductCategoryDTO {
    private int categoryId;
    private String categoryName;
    private int productCount;

    public ProductCategoryDTO(int categoryId, String categoryName, int productCount) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.productCount = productCount;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    @Override
    public String toString() {
        return "ProductCategoryDTO{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", productCount=" + productCount +
                '}';
    }
}
