package genie99.prj.board;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class BoardServlet
 */
@WebServlet("/board")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		
		switch(act) {
		case "list": list(request,response); break;
		case "detail": detail(request,response); break;
		case "writeForm" : writeForm(request,response); break;
		case "write": write(request,response); break;
		case "modifyForm": modifyForm(request,response); break;
		case "modify": modify(request,response); break;
		case "delete": delete(request,response); break;
		default : 
		
		}
	}
	
	
	
	private void modify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int no = Integer.parseInt(request.getParameter("no"));
		
		BoardDao dao = BoardDao.getInstance();
		dao.modifyBoard(no,title,content);
		response.sendRedirect(request.getContextPath() + "/board?act=list");
		
	}

	private void modifyForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/board/modify.jsp");
		rd.forward(request, response);
		
	}

	private void write(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String content = request.getParameter("content");
		
		BoardDao dao = BoardDao.getInstance();
		dao.insertBoard(title,author,content);
		response.sendRedirect(request.getContextPath() + "/board?act=list");
	}

	private void writeForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/board/write.jsp");
		rd.forward(request, response);
	}

	
	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDao dao = BoardDao.getInstance();
		String title = request.getParameter("title");
		
		dao.delete(title);
		
		List<Board> boards = dao.selectBoard();
		request.setAttribute("boards", boards);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/board/list.jsp");
		rd.forward(request, response);
	}
	
	private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardDao dao = BoardDao.getInstance();
		Board board = dao.findByNo(Integer.parseInt(request.getParameter("no")));
		request.setAttribute("board", board);
				
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/board/board.jsp");
		rd.forward(request, response);
	}
	
	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDao dao = BoardDao.getInstance();
		List<Board> boards = dao.selectBoard();
		request.setAttribute("boards", boards);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/board/list.jsp");
		rd.forward(request, response);
	}

}
