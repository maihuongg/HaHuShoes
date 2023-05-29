package HaHuShoes.Controller.Admin;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;

import HaHuShoes.Connection.ConnectionDB;
import HaHuShoes.Model.ProductCategoryDTO;
import HaHuShoes.Model.ProductModel;
import HaHuShoes.Service.iProductService;
import HaHuShoes.Service.Impl.ProductServiceImpl;
@WebServlet(urlPatterns = "/admin/statictis/productCountByCategory")
public class ProductChart extends HttpServlet {
    private iProductService productService = new ProductServiceImpl();
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy dữ liệu về số lượng sản phẩm theo từng loại
        List<ProductCategoryDTO> productCategoryCounts = productService.getProductCountByCategory();
        request.setAttribute("productCategoryList", productCategoryCounts);
        
        // Tạo dataset cho biểu đồ
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (ProductCategoryDTO pcc : productCategoryCounts) {
            dataset.setValue(pcc.getCategoryName(), pcc.getProductCount());
        }
        
        // Tạo biểu đồ
        JFreeChart chart = ChartFactory.createPieChart3D("Product Category Chart", dataset, true, true, false);
        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setStartAngle(290);
        plot.setForegroundAlpha(0.5f);
        plot.setCircular(true);
        
        // Lưu biểu đồ vào file
        String filePath = getServletContext().getRealPath("/imageChart/chart.png");
        File chartFile = new File(filePath);
        ChartUtils.saveChartAsPNG(chartFile, chart, 500, 400);
//        
//        // Redirect the request to the JSP file
//        response.sendRedirect(request.getContextPath() + "/views/admin/chartProduct.jsp");
    }
}
