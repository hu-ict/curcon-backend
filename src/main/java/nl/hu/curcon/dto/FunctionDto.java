package nl.hu.curcon.dto;

import nl.hu.curcon.domain.Function;

public class FunctionDto extends HRefDto{
	private int id;
		private String name;
		
		public FunctionDto() {
			super();
		}
		
		public FunctionDto(int i, String name) {
			this.setName(name);
			this.setId(i);
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setId(int i) {
			this.id=i;
			
		}
		public int getId() {
			return id;
		}
		@Override
	    public boolean equals(Object oth){
	        return id==(((FunctionDto)oth).id);
	    }
}
