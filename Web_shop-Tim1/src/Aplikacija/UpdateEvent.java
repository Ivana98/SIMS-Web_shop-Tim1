package POJO;

import java.util.EventObject;

public class UpdateEvent extends EventObject {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Stanje s;
	
	public UpdateEvent(Object object, Stanje s) {		
		super(object);
		this.s = s;
		
	}
	
	public Stanje getStanje() {
		return this.s;
	}
	
	

}