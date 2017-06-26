package com.kitri.util;

public class PageNavigation {
	private String root;
	private boolean nowFirst; // 현재 pg가BoardConstance에서 Page_size보다 작을때 true, 크면 false
	private boolean nowEnd; // 마지막 범위에 속해있는지
	private int totalArticleCount; // 전체글수
	private int newArticleCount; // 새글수
	private int totalPageCount; // 전체페이지수
	private int pageNo; // 현재페이지
	private String navigator; // 페이징

	public String getRoot() {
		return root;
	}

	public void setRoot(String root) {
		this.root = root;
	}

	public boolean isNowFirst() {
		return nowFirst;
	}

	public void setNowFirst(boolean nowFirst) {
		this.nowFirst = nowFirst;
	}

	public boolean isNowEnd() {
		return nowEnd;
	}

	public void setNowEnd(boolean nowEnd) {
		this.nowEnd = nowEnd;
	}

	public int getTotalArticleCount() {
		return totalArticleCount;
	}

	public void setTotalArticleCount(int totalArticleCount) {
		this.totalArticleCount = totalArticleCount;
	}

	public int getNewArticleCount() {
		return newArticleCount;
	}

	public void setNewArticleCount(int newArticleCount) {
		this.newArticleCount = newArticleCount;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public String getNavigator() {
		return navigator;
	}

	public void setNavigator() {
		 StringBuffer tmpNavigator = new StringBuffer();
		 
		 int prePage = (pageNo -1) / BoardConstance.PAGE_SIZE * BoardConstance.PAGE_SIZE; // 마지막페이지가 40이었을때

	      tmpNavigator.append("<table cellpadding='0' cellspacing='0' border='0'>\n");
	      tmpNavigator.append(" <tr>\n");
	      if (this.isNowFirst()) {
	         tmpNavigator.append("  <td><font color='#999999'>\n<a href='javascript:firstArticle()'>");
	         tmpNavigator.append("   <img src='" + root + "/img/board/icon_prev02.gif' width='7' height='11' border='0' align='absmiddle' hspace='3'>최신목록</a>\n");
	         tmpNavigator.append("   <img src='" + root + "/img/board/icon_prev01_dim.gif' width='3' height='11' border='0' align='absmiddle' hspace='3'>\n");
	         tmpNavigator.append("   이전</font>\n");
	      } else {
	         tmpNavigator.append("  <td>\n<a href='javascript:firstArticle()'>");
	         tmpNavigator.append("   <img src='" + root + "/img/board/icon_prev02.gif' width='7' height='11' border='0' align='absmiddle' hspace='3'>최신목록 </a>\n");
	         tmpNavigator.append("   <a href='javascript:listArticle("+prePage+")'>");
	         tmpNavigator.append("   <img src='" + root + "/img/board/icon_prev01_dim.gif' width='3' height='11' border='0' align='absmiddle' hspace='3'>\n");
	         tmpNavigator.append("   이전</a>"); //이전을 누를 수 있음 (링크 걸려있음)
	      }
	      tmpNavigator.append("  \n</td>\n");
	      tmpNavigator.append("  <td style='padding: 0 5 0 5'>\n");
	      tmpNavigator.append("   <table cellpadding='0' cellspacing='0' border='0'>\n");
	      tmpNavigator.append("    <tr>\n");
	      tmpNavigator.append("     <td width='1' nowrap><img src='" + root + "/img/board/n_tab.gif' width='1'");
	      tmpNavigator.append(" height='11' border='0' align='absmiddle'><br>");
	      tmpNavigator.append("     </td>\n");
	      
	      int startPage = prePage + 1;
	      int endPage = startPage + (BoardConstance.PAGE_SIZE - 1) ;
	      if (endPage > totalPageCount) {
	    	  endPage = totalPageCount; // 총 페이지의 마지막보다 위에 endPage가 더 크면 총 페이지의 마지막이 endPage가 된다. totalPage : 37 / endPage : 40
	      }
	      for (int i = startPage; i <= endPage; i++) {
	         if (pageNo == i) { // 현재페이지 글씨 크기는 색이 다름, 클릭할 수 없음
	            tmpNavigator.append("     <td style='padding:0 7 0 7;' nowrap><font class='text_acc_02'><b>" + i + "</b></font></td>\n");
	            tmpNavigator.append("     <td width='1' nowrap><img src='" + root + "/img/board/n_tab.gif' width='1'");
	            tmpNavigator.append(" height='11' border='0' align='absmiddle'><br>\n");
	         } else { // 현재페이지가 아닌 다른 페이지는 클릭할 수 있고, 글씨는 다름
	            tmpNavigator.append("     <td style='padding:0 7 0 7;' nowrap><a href='javascript:listArticle(" + i + ")'>" + i + "</td>\n");
	            tmpNavigator.append("     <td width='1' nowrap><img src='" + root + "/img/board/n_tab.gif' width='1'");
	            tmpNavigator.append(" height='11' border='0' align='absmiddle'><br>\n");
	         }
	      }
	      tmpNavigator.append("     </td>\n");
	      tmpNavigator.append("    </tr>\n");
	      tmpNavigator.append("   </table>\n");
	      tmpNavigator.append("  </td>\n");
	      tmpNavigator.append("  <td>\n");
	      
	      if (this.isNowEnd()) {
	         tmpNavigator.append("   <font color='#999999'>다음<img");
	         tmpNavigator.append("   src='" + root + "/img/board/icon_next01_dim.gif' width='3' height='11'");
	         tmpNavigator.append(" border='0' align='absmiddle' hspace='3'> \n");
	         tmpNavigator.append("   끝목록<img src='" + root + "/img/board/icon_next02_dim.gif' width='7' height='11'");
	         tmpNavigator.append(" border='0' align='absmiddle' hspace='3'></font>\n");
	      } else {
	 		 int nextPage = prePage + BoardConstance.PAGE_SIZE + 1; // 40 + 페이지사이즈에 1 하면 그 다음 페이지사이즈에서 첫번째인 51
	         tmpNavigator.append("   <a href='javascript:listArticle(" + nextPage + ")'>다음<img");
	         tmpNavigator.append(" src='" + root + "/img/board/icon_next01_dim.gif' width='3' height='11'");
	         tmpNavigator.append(" border='0' align='absmiddle' hspace='3'></a>\n");
	         tmpNavigator.append("   <a href='javascript:listArticle(" + totalPageCount + ")'>끝목록<img src='" + root + "/img/board/icon_next02_dim.gif' width='7' height='11'");
	         tmpNavigator.append(" border='0' align='absmiddle' hspace='3'>\n");
	      }

	      tmpNavigator.append("  </td>\n");
	      tmpNavigator.append(" </tr>\n");
	      tmpNavigator.append("</table>\n");

	      this.navigator = tmpNavigator.toString();
	}

}