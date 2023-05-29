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
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import HaHuShoes.Connection.ConnectionDB;
import HaHuShoes.Model.CountByRoleName;
import HaHuShoes.Model.ProductCategoryDTO;
import HaHuShoes.Model.ProductModel;
import HaHuShoes.Service.iAccountService;
import HaHuShoes.Service.iProductService;
import HaHuShoes.Service.Impl.AccountServiceImpl;
import HaHuShoes.Service.Impl.ProductServiceImpl;
@WebServlet(urlPatterns = "/admin/statictis/userChartbyRoleName")
public class ChartByRoleName extends HttpServlet {
    private iAccountService accountService = new AccountServiceImpl();
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy dữ liệu về số lượng sản phẩm theo từng loại
        List<CountByRoleName> countByRoleNames = accountService.countbyRoleNames();
        request.setAttribute("countByRoleNames", countByRoleNames);
        
        // Tạo dataset cho biểu đồ
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (CountByRoleName pcc : countByRoleNames) {
            dataset.addValue(pcc.getCountNameInteger(),"Number of users", pcc.getRoleName());
        }
        
     // Tạo biểu đồ cột
        JFreeChart chart = ChartFactory.createBarChart(
                "User Chart by Role Name", // Tiêu đề biểu đồ
                "Role Name", // Trục x (Role Name)
                "Number of Users", // Trục y (Số lượng người dùng)
                dataset, // Dữ liệu
                PlotOrientation.VERTICAL, // Định hướng biểu đồ
                true, // Hiển thị legend
                true, // Hiển thị tooltips
                false // Không hiển thị urls
        );

        // Tạo khung biểu đồ
        ChartFrame frame = new ChartFrame("User Chart", chart);
        frame.pack();
        frame.setVisible(true);

        // Lưu biểu đồ vào file
        String filePath = getServletContext().getRealPath("/imageChart/userChart.png");
        File chartFile = new File(filePath);
        ChartUtils.saveChartAsPNG(chartFile, chart, 500, 400);
    }

//        
//        // Redirect the request to the JSP file
//        response.sendRedirect(request.getContextPath() + "/views/admin/chartProduct.jsp");
    
}
