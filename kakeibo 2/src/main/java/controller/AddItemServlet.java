package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.ItemDao;
import domain.Item;
import service.ItemValidator;

/**
 * Servlet implementation class AddItemServlet
 */
@WebServlet("/addItem")
public class AddItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("WEB-INF/view/addItem.jsp")
				.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//バリデーション
			ItemValidator validator = new ItemValidator(request);
			
			//バリデーションエラーが存在する場合
			if(!validator.isValid()) {
				//フォームの再表示
				request.getRequestDispatcher("/WEB-INF/view/addItem.jsp")
						.forward(request, response);
			}
			
			
			//データの追加
			String contents = request.getParameter("contents");
			Integer price = Integer.parseInt(request.getParameter("price"));
			Item item = new Item();
			item.setContents(contents);
			item.setPrice(price);
			ItemDao itemDao = DaoFactory.createItemDao();
			itemDao.insert(item);
			
			request.getRequestDispatcher("/WEB-INF/view/addItemDone.jsp")
					.forward(request, response);
		}catch (Exception e) {
			throw new ServletException(e);
		}
	}

}
