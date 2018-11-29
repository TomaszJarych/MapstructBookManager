package tj.udemy.Commons.BaseClass;


public abstract class BaseDto {

	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BaseDto(Long id) {
		this.id = id;
	}

	public BaseDto() {
	}
	
	

	
	
}
