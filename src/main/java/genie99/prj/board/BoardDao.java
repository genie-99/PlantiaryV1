package genie99.prj.board;

import java.util.ArrayList;
import java.util.List;
/*
 * C: insert
 * R: select
 * U: update
 * D: delete
 */
public class BoardDao {
	
	private static int boardno = 0;
	
	private static List<Board> boards = new ArrayList<>();
	
	private static BoardDao instance;
	private BoardDao() {}
	public static synchronized BoardDao getInstance() {
		if(instance == null) {			
			return new BoardDao();
		}
		return instance;
	}
	
	
	public void insertBoard(String title, String author, String content) {
		boards.add(new Board(++boardno,title,author,content,0));
	}
	
	public List<Board> selectBoard(){	
		return boards;
	}
	
	public Board findByNo(int no) {
		return boards.stream()
		.filter(n -> n.getNo() == no)
		.findFirst()
		.orElse(null);
	}
	public Board findByTitle(String name) {
		return boards.stream()
		.filter(n -> n.getTitle().equals(name))
		.findFirst()
		.orElse(null);
	}
	
	public void delete(String title) {
		Board tmp = findByTitle(title);
		int idx =0;
		for(int i =0;i<boards.size();i++) {
			if(tmp.getNo()==boards.get(i).getNo()) {
				idx = i;
				break;
			}
		}
		boards.remove(idx);
	}
	public void modifyBoard(int no,String title, String content) {
		Board board = findByNo(no);
		board.setTitle(title);
		board.setContent(content);
	}
}
