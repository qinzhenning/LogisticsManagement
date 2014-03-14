/**
 * 
 */
package com.LogisticsManagement.logic;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;


/**
 * @author qinzhenning
 * 2014-3-14下午9:19:40
 */
public class ProductModel extends AbstractTableModel{

	final String title[]={"货物编号","货物名称","货物数量","货物总重量","是否易碎"};
	Object content[][];
	private static final long serialVersionUID = -7495940408592595397L;

    public ProductModel(ArrayList<Product> temp) {
    	if(temp!= null)
    	{
	        content = new Object[temp.size()][7];
	        for(int i=0;i<temp.size();i++){
				content[i][0]=temp.get(i).getPid();
				content[i][1]=temp.get(i).getPname();
				content[i][2]=temp.get(i).getPnum();
				content[i][3]=temp.get(i).getSumpweight();
				content[i][4]=temp.get(i).isSquashy();
			}
    	}
    	else
    	{
    		 content = new Object[20][7];
    		 for(int i=0;i<20;i++){
 				content[i][0]="";
 				content[i][1]="";
 				content[i][2]="";
 				content[i][3]="";
 				content[i][4]="";
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