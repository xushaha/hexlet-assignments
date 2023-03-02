package exercise.servlet;

import exercise.Data;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.stream.Collectors;

public class CompaniesServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
                throws IOException, ServletException {

        // BEGIN
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        List<String> companies = Data.getCompanies();
        String search = request.getParameter("search");
        String query = request.getQueryString();
        int count = 0;

        if (search == null) {
            companies.forEach(writer::println);
        } else if (search.equals("") || !query.contains("search")) {
            companies.forEach(writer::println);
        } else {
            for (String company : companies) {
                if (company.contains(search)) {
                    writer.println(company);
                    count++;
                }
            }
            if (count == 0) {
                writer.println("Companies not found");
            }
        }
        // END
    }
}
