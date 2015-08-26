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


public class TalendColumn {

	private String label, typeToGenerate, pattern, precision, length;	
	private Object value;
		
	public TalendColumn(String label, Object value, String typeToGenerate,
			String pattern, String precisionValue, String lengthValue) {
		super();
		this.label = label;
		this.value = value;
		this.typeToGenerate = typeToGenerate;
		this.pattern = pattern;
		this.precision = precisionValue;
		this.length = lengthValue;
	}
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public String getTypeToGenerate() {
		return typeToGenerate;
	}
	public void setTypeToGenerate(String typeToGenerate) {
		this.typeToGenerate = typeToGenerate;
	}
	public String getPattern() {
		return pattern;
	}
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	public String getPrecisionValue() {
		return precision;
	}
	public void setPrecisionValue(String precisionValue) {
		this.precision = precisionValue;
	}
	public String getLengthValue() {
		return length;
	}
	public void setLengthValue(String lengthValue) {
		this.length = lengthValue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		result = prime * result
				+ ((length == null) ? 0 : length.hashCode());
		result = prime * result + ((pattern == null) ? 0 : pattern.hashCode());
		result = prime * result
				+ ((precision == null) ? 0 : precision.hashCode());
		result = prime * result
				+ ((typeToGenerate == null) ? 0 : typeToGenerate.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		TalendColumn other = (TalendColumn) obj;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		if (length == null) {
			if (other.length != null)
				return false;
		} else if (!length.equals(other.length))
			return false;
		if (pattern == null) {
			if (other.pattern != null)
				return false;
		} else if (!pattern.equals(other.pattern))
			return false;
		if (precision == null) {
			if (other.precision != null)
				return false;
		} else if (!precision.equals(other.precision))
			return false;
		if (typeToGenerate == null) {
			if (other.typeToGenerate != null)
				return false;
		} else if (!typeToGenerate.equals(other.typeToGenerate))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TalendColumn [label=" + label + ", value=" + value
				+ ", typeToGenerate=" + typeToGenerate + ", pattern=" + pattern
				+ ", precisionValue=" + precision + ", lengthValue="
				+ length + "]";
	}
	
		
}
