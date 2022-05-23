package idv.fc.model.dto;

public class FlashcardHolderListDTO {
	private Integer id;
	private String name;
	private String term;

	public FlashcardHolderListDTO(Integer id, String name, String term) {
		super();
		this.id = id;
		this.name = name;
		this.term = term;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	@Override
	public String toString() {
		return "TestDTO [id=" + id + ", name=" + name + ", term=" + term + "]";
	}

}
