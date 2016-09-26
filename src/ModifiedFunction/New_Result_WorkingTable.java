package ModifiedFunction;

public class New_Result_WorkingTable {
 private String workingTableId;
 private String datesToken;
 private String timesToken;
 private String namesToken;//同一个block中的name用；连接，不同block之间的name串用&连接
 private String row;
 private String column;
public String getWorkingTableId() {
	return workingTableId;
}
public void setWorkingTableId(String workingTableId) {
	this.workingTableId = workingTableId;
}
public String getDatesToken() {
	return datesToken;
}
public void setDatesToken(String datesToken) {
	this.datesToken = datesToken;
}
public String getTimesToken() {
	return timesToken;
}
public void setTimesToken(String timesToken) {
	this.timesToken = timesToken;
}
public String getNamesToken() {
	return namesToken;
}
public void setNamesToken(String namesToken) {
	this.namesToken = namesToken;
}
public String getRow() {
	return row;
}
public void setRow(String row) {
	this.row = row;
}
public String getColumn() {
	return column;
}
public void setColumn(String column) {
	this.column = column;
}
 
}
