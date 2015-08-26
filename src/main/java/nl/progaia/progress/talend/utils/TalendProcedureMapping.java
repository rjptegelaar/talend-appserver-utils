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
import java.util.Set;

import nl.progaia.progress.client.Mapper;
import nl.progaia.progress.client.Parameter;
import nl.progaia.progress.client.ParameterModeType;
import nl.progaia.progress.client.ParameterType;
import nl.progaia.progress.client.Procedure;
import nl.progaia.progress.exception.AppserverClientException;
import nl.progaia.progress.valueholder.ValueHolder;

public class TalendProcedureMapping {
	private Map<Integer, String> mappingRules = new HashMap<Integer, String>();
	private Procedure proc;
	
	public TalendProcedureMapping(String name){
		proc = new Procedure(name);
	}
	
	public void addParameter(ParameterModeType inputOuputType, ParameterType dataType, String talendColumnName){
		int index = proc.addParameter(inputOuputType, dataType);
		mappingRules.put(index, talendColumnName);		
	}	

	public Map<Integer, String> getMappingRules() {
		return mappingRules;
	}

	public void setMappingRules(Map<Integer, String> mappingRules) {
		this.mappingRules = mappingRules;		
	}

	public Procedure getProcedure() {
		return proc;
	}

	public void setProcedure(Procedure proc) {
		this.proc = proc;
	}
	
	public Map<Integer, ValueHolder<?>> getValues(TalendRow tr) throws AppserverClientException{
		Map<Integer, ValueHolder<?>> values = new HashMap<Integer, ValueHolder<?>>();
		Set<Integer> columnIndexes = mappingRules.keySet();
		for (int index : columnIndexes) {
			String columnName = mappingRules.get(index);
			Parameter param = proc.getParameter(index);			
			TalendColumn column = tr.getColumnByName(columnName);			
			if(column!=null){
				values.put(index, Mapper.getValueHolder(param.getDataType(), column.getValue()));					
			}else{
				values.put(index, Mapper.getValueHolder(param.getDataType(), null));	
			}
		}			
		return values;
	}
	
	public void appendProcedureResult(Map<Integer, ValueHolder<?>> values, TalendRow tr){
		Map<Integer,Parameter> params = proc.getParameters();
		Set<Integer> paramIndexes = params.keySet();
		for (Integer paramIndex : paramIndexes) {
			Parameter param = params.get(paramIndex);
			switch(param.getInputOuputType()){
			case INPUT:
				System.out.println("Ignore input param");
			break;
			case INPUT_OUTPUT:
				TalendColumn columnIO = new TalendColumn(mappingRules.get(paramIndex), values.get(paramIndex).getValue(), null, null, null,null);
				tr.addColumn(columnIO, mappingRules.get(paramIndex));
			break;
			case OUTPUT:
				TalendColumn columnO = new TalendColumn(mappingRules.get(paramIndex), values.get(paramIndex).getValue(), null, null, null,null);
				tr.addColumn(columnO, mappingRules.get(paramIndex));
			break;
			}
		}
	}
	
		

	@Override
	public String toString() {
		return "TalendProcedureMapping [mappingRules=" + mappingRules
				+ ", proc=" + proc + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((mappingRules == null) ? 0 : mappingRules.hashCode());
		result = prime * result + ((proc == null) ? 0 : proc.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TalendProcedureMapping other = (TalendProcedureMapping) obj;
		if (mappingRules == null) {
			if (other.mappingRules != null)
				return false;
		} else if (!mappingRules.equals(other.mappingRules))
			return false;
		if (proc == null) {
			if (other.proc != null)
				return false;
		} else if (!proc.equals(other.proc))
			return false;
		return true;
	}
	
	
	
}
