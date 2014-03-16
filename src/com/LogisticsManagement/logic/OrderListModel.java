/**
 * 
 */
package com.LogisticsManagement.logic;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

/**
 * @author qinzhenning
 * 2014-3-15下午1:30:28
 */
public class OrderListModel extends AbstractTableModel {

	final String title[]={"运单编号","运单状态","创建时间","结束时间","发货人姓名","发货人电话","收货人姓名","收货人电话","代售货款"};
	Object content[][];
	private static final long serialVersionUID = -7495940408592595397L;

    public OrderListModel(ArrayList<Order> temp) {
    	if(temp!= null)
    	{
	        content = new Object[temp.size()][9];
	        for(int i=0;i<temp.size();i++){
				content[i][0]=temp.get(i).getOid();
				content[i][1]=temp.get(i).getStatus();
				content[i][2]=temp.get(i).getSdate();
				content[i][3]=temp.get(i).getEdate();
				content[i][4]=temp.get(i).getSname();
				content[i][5]=temp.get(i).getSphone();
				content[i][6]=temp.get(i).getCname();
				content[i][7]=temp.get(i).getCphone();
				content[i][8]=temp.get(i).getCOD();
			}
    	}
    	else
    	{
    		 content = new Object[20][9];
    		 for(int i=0;i<20;i++){
 				content[i][0]="";
 				content[i][1]="";
 				content[i][2]="";
 				content[i][3]="";
 				content[i][4]="";
 				content[i][5]="";
 				content[i][6]="";
 				content[i][7]="";
 				content[i][8]="";
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

