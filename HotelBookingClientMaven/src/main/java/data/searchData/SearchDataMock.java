package data.searchData;

import java.util.ArrayList;

import po.SearchPO;

public class SearchDataMock extends SearchData{
	ArrayList<SearchPO> allsearchhistory=new ArrayList<SearchPO>();
	public SearchDataMock(){
		SearchPO sp1=new SearchPO("wuxiufeng", null, "酒店1");
		SearchPO sp2=new SearchPO("wuxiufeng", null, "酒店2");
		SearchPO sp3=new SearchPO("xiekaihang", null, "酒店3");
		SearchPO sp4=new SearchPO("xiekailian", null, "酒店4");
		
		allsearchhistory.add(sp1);
		allsearchhistory.add(sp2);
		allsearchhistory.add(sp3);
		allsearchhistory.add(sp4);
	}

	
	@Override
	public ArrayList<SearchPO> showSearchHistory(String username) {
		// TODO Auto-generated method stub
		ArrayList<SearchPO> result=new ArrayList<SearchPO>();
		
		for (int i = 0; i < allsearchhistory.size(); i++) {
			if(allsearchhistory.get(i).getPersonname().equals(username)){
				result.add(allsearchhistory.get(i));
			}
		}
		return result;
	}

	@Override
	public boolean addSearchHistory(SearchPO s) {
		allsearchhistory.add(s);
		return true;
	}

	@Override
	public boolean deleteSearchHistory(SearchPO s) {
		allsearchhistory.remove(s);
		return true;
	}

	
}
