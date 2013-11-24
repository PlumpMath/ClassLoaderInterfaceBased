package about.sorting;

public class Tab {
	
	private int position;

	public Tab(int position) {
		this.position=position;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
	
	@Override
	public String toString(){
		return "Tab in posizione "+position;
		
	}

}
