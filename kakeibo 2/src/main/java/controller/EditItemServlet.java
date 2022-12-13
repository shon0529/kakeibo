package controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
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
 * Servlet implementation class EditItemServlet
 */
@WebServlet("/editItem")
public class EditItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ItemDao itemDao;

	public void init(ServletConfig config) throws ServletException {

		try {
			itemDao = DaoFactory.createItemDao();
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Item item = itemDao.findById(Integer.parseInt(request.getParameter("id")));

			// フォーム初期表示データ
			request.setAttribute("id", item.getId());
			request.setAttribute("contents", item.getContents());
			request.setAttribute("price", item.getPrice());
			request.getRequestDispatcher("/WEB-INF/view/editItem.jsp").forward(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// バリデーション
			ItemValidator validator = new ItemValidator(request);

			// バリデーションエラーが存在する場合
			if (!validator.isValid()) {
				// フォームの再表示
				request.getRequestDispatcher("/WEB-INF/view/editItem.jsp").forward(request, response);
				return;
			}
			// 更新用の内容情報にidをセット
			Item item = validator.getValidatedItem();
			item.setId(Integer.parseInt(request.getParameter("id")));
			// データの更新
			itemDao.update(item);
			// 完了ページへフォワード
			request.getRequestDispatcher("/WEB-INF/view/editItemDone.jsp").forward(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

}
