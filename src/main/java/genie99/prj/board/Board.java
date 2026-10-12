package genie99.prj.board;

public class Board {
	private int no;
	private int viewCnt;
	private String title; 
	private String content;
	private String author;
	
	public Board(int no,  String title, String author,String content, int viewCnt) {
		this.no = no;
		this.title = title;
		this.author = author; 
		this.content = content;
		this.viewCnt = viewCnt;
	}



	public int getNo() {
		return no;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}
	public String getContent() {
		return content;
	}



	@Override
	public String toString() {
		return "Board [no=" + no + ", viewCnt=" + viewCnt + ", title=" + title + ", content=" + content + ", author="
				+ author + "]";
	}

	
}
