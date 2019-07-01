package POJO;

public class Kupon {

	protected int popust;

	public Kupon(int popust) {
		this.setPopust(popust);
	}
	
	public Kupon()
	{
		this.setPopust(0);
	}
	
	public Kupon(Kupon k)
	{
		this.setPopust(k.getPopust());
	}
	
	@Override
	public String toString()
	{
		return ""+this.getPopust();
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == null) {
			return false;
		}else if(o instanceof Kupon){
			Kupon c = (Kupon)o;
			if(c.getPopust() == this.getPopust() ) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}

	public int getPopust() {
		return popust;
	}

	public void setPopust(int popust) {
		this.popust = popust;
	}
	
	
	
}
