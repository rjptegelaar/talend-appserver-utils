//Copyright 2015 Paul Tegelaar

//
//Licensed under the Apache License, Version 2.0 (the "License");
//you may not use this file except in compliance with the License.
//You may obtain a copy of the License at
//
//http://www.apache.org/licenses/LICENSE-2.0
//
//Unless required by applicable law or agreed to in writing, software
//distributed under the License is distributed on an "AS IS" BASIS,
//WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//See the License for the specific language governing permissions and
//limitations under the License.
package nl.progaia.progress.talend.utils;

import java.util.HashMap;
import java.util.Map;

public class TalendRow {
	public Map<String, TalendColumn> columns;
	
	public TalendRow(){
		columns = new HashMap<String, TalendColumn>();
	}
	
	public void addColumn(TalendColumn tc, String name){
		columns.put(name, tc);
	}
	
	public TalendColumn getColumnByName(String talendColumnName){
		return columns.get(talendColumnName);
	}

	@Override
	public String toString() {
		return "TalendRow [columns=" + columns + "]";
	}		
	
}
