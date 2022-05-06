package upm.fis.practica.model;

public class Libro {

	private String titulo;
	private String isbn;
	private Integer year;

	public Libro(String titulo, String isbn, Integer year) {
		super();
		this.titulo = titulo;
		this.isbn = isbn;
		this.year = year;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

}
