package joa.helpdesk.model;

import java.util.*;

public interface JoaMHService {
	
	public int addManyHelp(JoaManyHelpDTO dto);
	
	public int deleteManyHelp(int idx);
	
	public int rewriteManyHelp(JoaManyHelpDTO dto);
	
	public List<JoaManyHelpDTO> ManyHelpList(int cp, int ls);
	
	public List<JoaManyHelpDTO> serchManyHelpList(String type,int cp, int ls);
	
	public List<JoaManyHelpDTO> manyHelpType(String keyword,int cp, int ls);
	
	public JoaManyHelpDTO ManyHelpBorder(int idx);
	
	public int manyHelpListTotalCnt();
	
	public int manyHelpTypeTotalCnt(String type);
	
	public int serchManyHelpListTotalCnt(String keyword);
	
	public void upDateReadNum(int idx);
}
