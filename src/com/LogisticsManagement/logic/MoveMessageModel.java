/**
 * 
 */
package com.LogisticsManagement.logic;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

/**
 * @author qinzhenning
 * 2014-3-17����2:26:56
 */
public class MoveMessageModel extends AbstractTableModel{
	final String title[]={"����ʱ��","������Ϣ","������"};
	Object content[][];
	private static final long serialVersionUID = -7495940408592595397L;
	
	/*
	 * ����string��� , �ָ�����ȷ�� ����ʱ�� ������Ϣ ������
	 */
    public MoveMessageModel(ArrayList<String> temp) {
    	if(temp!= null)
    	{
	        content = new Object[temp.size()][3];
	        for(int i=0;i<temp.size();i++){
				String[] s = temp.get(i).split(",");
				content[i][0]=s[0];
				content[i][1]=s[1];
				content[i][2]=s[2];
			}
    	}
    	else
    	{
    		 content = new Object[10][3];
    		 for(int i=0;i<10;i++){
 				content[i][0]="";
 				content[i][1]="";
 				content[i][2]="";
 			}
    	}
    }

    public int getColumnCount() {
        return title.length;
    }
      
    public int getRowCount() {
        return content.length;
    }

    public Object getValueAt(int row, int col) {
        return content[row][col];
    }

    public String getColumnName(int col){
    	return title[col];
    }
}



