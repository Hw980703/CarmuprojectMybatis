package write.model.vo;

import java.util.List;

public class PageData {
	private List<Write> nList;
	private String pageNavi;
	
	
	
	public PageData(List<Write> nList, String pageNavi) {
		super();
		this.nList = nList;
		this.pageNavi = pageNavi;
	}
	public PageData() {
		super();
	}
	public List<Write> getnList() {
		return nList;
	}
	public void setnList(List<Write> nList) {
		this.nList = nList;
	}
	public String getPageNavi() {
		return pageNavi;
	}
	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}
	@Override
	public String toString() {
		return "PageData [nList=" + nList + ", pageNavi=" + pageNavi + "]";
	}
	
	
	
	
}
