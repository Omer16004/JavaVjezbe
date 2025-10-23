package aa;

 class Player {
	private String name;
	private int pozitionX;
	private int pozitionY;
	private int width;
	private int height;
	private int health;

	public Player(String name, int pozitionX, int pozitionY, int width, int height, int health) {
		this.name = name;
		this.pozitionX = pozitionX;
		this.pozitionY = pozitionY;
		this.width = width;
		this.height = height;
		this.health = health;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name.isEmpty()) {
			this.name = "Player";
		}
		else
		this.name = name;
	}

	public int getPozitionX() {
		return pozitionX;
	}

	public void setPozitionX(int pozitionX) {
		this.pozitionX = pozitionX;
	}

	public int getPozitionY() {
		return pozitionY;
	}

	public void setPozitionY(int pozitionY) {
		this.pozitionY = pozitionY;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getHealth() {
		if (getHealth() < 0 ) {
			health = 0;
			} else if (getHealth() > 100) {
				health = 100;
				} else {
					return health;
			
		

			}
		return health;
		}

	public void setHealth(int health) {
		this.health = health;
	}

}
