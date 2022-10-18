package joa.helpdesk.model;

import java.util.*;

public interface JoaMHService {
	
	public int addManyHelp(JoaManyHelpDTO dto);
	
	public int deleteManyHelp(int idx);
	
	public int rewriteManyHelp(JoaManyHelpDTO dto);
	
	public List<JoaManyHelpDTO> ManyHelpList();
	
	public List<JoaManyHelpDTO> serchManyHelpList(String type);
	
	public JoaManyHelpDTO ManyHelpBorder(int idx);
}
